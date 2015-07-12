package org.snow.cms.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.snow.cms.auth.AuthClass;
import org.snow.cms.model.BaseInfo;
import org.snow.cms.web.BaseInfoUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@AuthClass
@Controller
@RequestMapping({"/admin/system"})
public class SystemController
{
  @RequestMapping({"/baseinfo"})
  public String showBaseInfo()
  {
    return "system/showBaseInfo";
  }

  @RequestMapping(value={"/baseinfo/update"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String updateBaseInfo(HttpSession session, Model model) {
    model.addAttribute("baseInfo", session.getServletContext().getAttribute("baseInfo"));
    return "system/updateBaseInfo";
  }
  @RequestMapping(value={"/baseinfo/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String updateBaseInfo(BaseInfo baseInfo, HttpSession session) {
    BaseInfo bi = BaseInfoUtil.getInstacne().write(baseInfo);
    session.getServletContext().setAttribute("baseInfo", bi);
    return "redirect:/admin/system/baseinfo";
  }
}