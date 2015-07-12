package org.snow.cms.controller;

import javax.inject.Inject;
import org.snow.cms.auth.AuthClass;
import org.snow.cms.model.Role;
import org.snow.cms.model.RoleType;
import org.snow.cms.service.IRoleService;
import org.snow.cms.service.IUserService;
import org.snow.cms.util.EnumUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/admin/role"})
@AuthClass
public class RoleController
{

  @Inject
  private IRoleService roleService;

  @Inject
  private IUserService userService;

  @RequestMapping({"/roles"})
  public String list(Model model)
  {
    model.addAttribute("roles", this.roleService.listRole());
    return "role/list";
  }

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(Model model) {
    model.addAttribute(new Role());
    model.addAttribute("types", EnumUtils.enumToName(RoleType.class));
    return "role/add";
  }

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String add(Role role) {
    this.roleService.add(role);
    return "redirect:/admin/role/roles";
  }

  @RequestMapping(value={"/update/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String update(@PathVariable int id, Model model) {
    model.addAttribute(this.roleService.load(id));
    model.addAttribute("types", EnumUtils.enumToName(RoleType.class));
    return "role/update";
  }

  @RequestMapping(value={"/update/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(@PathVariable int id, Role role) {
    Role r = this.roleService.load(id);
    r.setName(role.getName());
    r.setRoleType(role.getRoleType());
    this.roleService.update(r);
    return "redirect:/admin/role/roles";
  }

  @RequestMapping({"/delete/{id}"})
  public String delete(@PathVariable int id) {
    this.roleService.delete(id);
    return "redirect:/admin/role/roles";
  }

  @RequestMapping({"/clearUsers/{id}"})
  public String clearRoleUsers(@PathVariable int id) {
    this.roleService.deleteRoleUsers(id);
    return "redirect:/admin/role/roles";
  }

  @RequestMapping({"/{id}"})
  public String show(@PathVariable int id, Model model) {
    model.addAttribute(this.roleService.load(id));
    model.addAttribute("users", this.userService.listRoleUsers(id));
    return "role/show";
  }
}