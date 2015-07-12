package org.snow.cms.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.snow.cms.model.Role;
import org.snow.cms.model.RoleType;
import org.snow.cms.model.User;
import org.snow.cms.service.IUserService;
import org.snow.cms.util.Chptcha;
import org.snow.cms.web.CmsSessionContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController
{

  @Inject
  private IUserService userService;

  @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String login()
  {
    return "admin/login";
  }

  @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String login(HttpSession session, String username, String password, String checkcode, Model model) {
    String cc = (String)session.getAttribute("cc");
    if (!cc.equalsIgnoreCase(checkcode)) {
      model.addAttribute("error", "验证码不正确!");
      return "admin/login";
    }
    User loginUser = this.userService.login(username, password);
    session.setAttribute("loginUser", loginUser);
    List rs = this.userService.listUserRoles(loginUser.getId());
    boolean isAdmin = isRole(rs, RoleType.ROLE_ADMIN);
    session.setAttribute("isAdmin", Boolean.valueOf(isAdmin));
    if (!isAdmin) {
      session.setAttribute("allActions", getAllActions(rs, session));
      session.setAttribute("isAudit", Boolean.valueOf(isRole(rs, RoleType.ROLE_AUDIT)));
      session.setAttribute("isPublish", Boolean.valueOf(isRole(rs, RoleType.ROLE_PUBLISH)));
    }
    session.removeAttribute("cc");
    CmsSessionContext.addSessoin(session);
    return "redirect:/admin";
  }

  @RequestMapping({"/drawCheckCode"})
  public void drawCheckCode(HttpServletResponse response, HttpSession session) throws IOException {
    response.setContentType("image/jpg");
    int width = 150;
    int height = 30;
    Chptcha c = Chptcha.getInstance();
    c.set(width, height);
    String checkcode = c.generateCheckcode();
    session.setAttribute("cc", checkcode);
    OutputStream os = response.getOutputStream();
    ImageIO.write(c.generateCheckImg(checkcode), "jpg", os);
  }

  private Set<String> getAllActions(List<Role> rs, HttpSession session)
  {
    Set actions = new HashSet();
    Map allAuths = (Map)session.getServletContext().getAttribute("allAuths");
    actions.addAll((Collection)allAuths.get("base"));
    for (Role r : rs) {
      if (r.getRoleType() != RoleType.ROLE_ADMIN)
        actions.addAll((Collection)allAuths.get(r.getRoleType().name()));
    }
    return actions;
  }

  private boolean isRole(List<Role> rs, RoleType rt) {
    for (Role r : rs) {
      if (r.getRoleType() == rt) {
        return true;
      }
    }
    return false;
  }
}