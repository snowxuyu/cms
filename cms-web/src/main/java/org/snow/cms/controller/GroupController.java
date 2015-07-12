package org.snow.cms.controller;

import java.util.List;
import javax.inject.Inject;
import org.snow.cms.auth.AuthClass;
import org.snow.cms.model.ChannelTree;
import org.snow.cms.model.Group;
import org.snow.cms.service.IGroupService;
import org.snow.cms.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/admin/group"})
@AuthClass
public class GroupController
{

  @Inject
  private IUserService userService;

  @Inject
  private IGroupService groupService;

  @RequestMapping({"/groups"})
  public String list(Model model)
  {
    model.addAttribute("datas", this.groupService.findGroup());
    return "group/list";
  }

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(Model model) {
    model.addAttribute(new Group());
    return "group/add";
  }

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String add(Group group) {
    this.groupService.add(group);
    return "redirect:/admin/group/groups";
  }

  @RequestMapping(value={"/update/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String update(@PathVariable int id, Model model) {
    model.addAttribute("group", this.groupService.load(id));
    return "group/update";
  }

  @RequestMapping(value={"/update/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(@PathVariable int id, Group group) {
    Group g = this.groupService.load(id);
    g.setName(group.getName());
    g.setDescr(group.getDescr());
    this.groupService.update(g);
    return "redirect:/admin/group/groups";
  }

  @RequestMapping({"/delete/{id}"})
  public String delete(@PathVariable int id) {
    this.groupService.delete(id);
    return "redirect:/admin/group/groups";
  }

  @RequestMapping({"/{id}"})
  public String show(@PathVariable int id, Model model) {
    model.addAttribute(this.groupService.load(id));
    model.addAttribute("users", this.userService.listGroupUsers(id));
    return "group/show";
  }

  @RequestMapping({"/clearUsers/{id}"})
  public String clearGroupUsers(@PathVariable int id) {
    this.groupService.deleteGroupUsers(id);
    return "redirect:/admin/group/groups";
  }

  @RequestMapping({"/listChannels/{gid}"})
  public String listChannels(@PathVariable int gid, Model model) {
    model.addAttribute(this.groupService.load(gid));
    return "group/listChannel";
  }
  @RequestMapping(value={"/groupTree/{gid}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public List<ChannelTree> groupTree(@PathVariable Integer gid) {
    return this.groupService.generateGroupChannelTree(gid.intValue());
  }

  @RequestMapping({"/setChannels/{gid}"})
  public String setChannels(@PathVariable int gid, Model model) {
    model.addAttribute(this.groupService.load(gid));
    model.addAttribute("cids", this.groupService.listGroupChannelIds(gid));
    return "group/setChannel";
  }
}