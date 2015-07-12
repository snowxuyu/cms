package org.snow.cms.controller;

import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.snow.cms.auth.AuthClass;
import org.snow.cms.auth.AuthMethod;
import org.snow.cms.dto.UserDto;
import org.snow.cms.model.ChannelTree;
import org.snow.cms.model.Role;
import org.snow.cms.model.RoleType;
import org.snow.cms.model.User;
import org.snow.cms.service.IChannelService;
import org.snow.cms.service.IGroupService;
import org.snow.cms.service.IRoleService;
import org.snow.cms.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/admin/user"})
@AuthClass("login")
public class UserController
{

  @Inject
  private IUserService userService;

  @Inject
  private IGroupService groupService;

  @Inject
  private IRoleService roleService;

  @Inject
  private IChannelService channelService;

  @RequestMapping({"/users"})
  public String list(Model model)
  {
    model.addAttribute("datas", this.userService.findUser());
    return "user/list";
  }

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(Model model) {
    model.addAttribute("userDto", new UserDto());
    model.addAttribute("roles", this.roleService.listRole());
    model.addAttribute("groups", this.groupService.listGroup());
    return "user/add";
  }

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String add(UserDto userDto) {
    this.userService.add(userDto.getUser(), userDto.getRoleIds(), userDto.getGroupIds());
    return "redirect:/admin/user/users";
  }

  @RequestMapping(value={"/update/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String update(@PathVariable int id, Model model) {
    User user = this.userService.load(id);
    model.addAttribute("userDto", new UserDto(user, this.userService.listUserRoleIds(id), this.userService.listUserGroupIds(id)));
    model.addAttribute("roles", this.roleService.listRole());
    model.addAttribute("groups", this.groupService.listGroup());
    return "user/update";
  }

  @RequestMapping(value={"/update/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(UserDto userDto, @PathVariable int id) {
    User u = this.userService.load(id);
    u.setNickname(userDto.getNickname());
    u.setPhone(userDto.getPhone());
    u.setEmail(userDto.getEmail());
    u.setStatus(userDto.getStatus());
    this.userService.update(u, userDto.getRoleIds(), userDto.getGroupIds());
    return "redirect:/admin/user/users";
  }

  @RequestMapping({"/delete/{id}"})
  public String delete(@PathVariable int id) {
    this.userService.delete(id);
    return "redirect:/admin/user/users";
  }

  @RequestMapping({"/updateStatus/{id}"})
  public String updateStatus(@PathVariable int id) {
    this.userService.updateStatus(id);
    return "redirect:/admin/user/users";
  }

  @RequestMapping({"/{id}"})
  public String show(Model model, @PathVariable int id) {
    model.addAttribute("user", this.userService.load(id));
    model.addAttribute("roles", this.userService.listUserRoles(id));
    model.addAttribute("groups", this.userService.listUserGroups(id));
    return "user/show";
  }
  @RequestMapping({"/showSelf"})
  @AuthMethod
  public String showSelf(Model model, HttpSession session) {
    User user = (User)session.getAttribute("loginUser");
    model.addAttribute(user);
    model.addAttribute("groups", this.userService.listUserGroups(user.getId()));
    model.addAttribute("roles", this.userService.listUserRoles(user.getId()));
    return "user/show";
  }
  @RequestMapping(value={"/updateSelf"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @AuthMethod
  public String updateSelf(Model model, HttpSession session) {
    User user = (User)session.getAttribute("loginUser");
    model.addAttribute(new UserDto(user));
    return "user/updateSelf";
  }
  @RequestMapping(value={"/updateSelf"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @AuthMethod
  public String updateSelf(UserDto userDto, Model model, HttpSession session) {
    User ou = this.userService.load(userDto.getId());
    ou.setNickname(userDto.getNickname());
    ou.setPhone(userDto.getPhone());
    ou.setEmail(userDto.getEmail());
    this.userService.updateSelf(ou);
    session.setAttribute("loginUser", ou);
    return "redirect:/admin/user/showSelf";
  }
  @RequestMapping(value={"/updatePwd"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @AuthMethod
  public String updatePwd(Model model, HttpSession session) {
    User user = (User)session.getAttribute("loginUser");
    model.addAttribute("user", user);
    return "user/updatePwd";
  }
  @RequestMapping(value={"/updatePwd"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @AuthMethod
  public String updatePwd(int id, String oldPwd, String password) {
    this.userService.updatePwd(id, oldPwd, password);
    return "redirect:/admin/user/showSelf";
  }

  @RequestMapping({"/listChannels/{uid}"})
  public String listChannels(@PathVariable int uid, Model model) {
    model.addAttribute(this.userService.load(uid));
    List rs = this.userService.listUserRoles(uid);
    for (Role r : rs) {
      if (RoleType.ROLE_ADMIN == r.getRoleType())
        model.addAttribute("isAdmin", Integer.valueOf(1));
      else {
        model.addAttribute("isAdmin", Integer.valueOf(0));
      }
    }
    return "user/listChannel";
  }
  @RequestMapping(value={"/userTree/{uid}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public List<ChannelTree> userTree(@PathVariable Integer uid, @RequestParam(required=false) Integer isAdmin) {
    if ((1 == isAdmin.intValue()) && (null != isAdmin)) {
      return this.channelService.generateTree();
    }
    return this.groupService.generateUserChannelTree(uid.intValue());
  }
}