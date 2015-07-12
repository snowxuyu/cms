package org.snow.cms.controller;

import javax.servlet.http.HttpSession;
import org.snow.cms.auth.AuthClass;
import org.snow.cms.auth.AuthMethod;
import org.snow.cms.web.CmsSessionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AuthClass("login")
public class AdminController
{
  @AuthMethod
  @RequestMapping({"/admin"})
  public String index()
  {
    return "admin/index";
  }
  @RequestMapping({"/admin/logout"})
  @AuthMethod
  public String logout(HttpSession session) {
    CmsSessionContext.removeSession(session);
    session.invalidate();
    return "redirect:/login";
  }
}