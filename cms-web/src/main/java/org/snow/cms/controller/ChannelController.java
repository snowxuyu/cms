package org.snow.cms.controller;

import org.snow.cms.auth.AuthClass;
import org.snow.cms.dto.AjaxObj;
import org.snow.cms.dto.TreeDto;
import org.snow.cms.model.Channel;
import org.snow.cms.model.ChannelTree;
import org.snow.cms.service.IChannelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"/admin/channel"})
@AuthClass
public class ChannelController
{

  @Inject
  private IChannelService channelService;

  @RequestMapping({"/channels"})
  public String list(Model model)
  {
    return "channel/list";
  }

  @RequestMapping({"/channels/{pid}"})
  public String listChild(@PathVariable Integer pid, @RequestParam(required=false) Integer refresh, Model model) {
    Channel pc = null;
    if (refresh == null)
      model.addAttribute("refresh", Integer.valueOf(0));
    else {
      model.addAttribute("refresh", Integer.valueOf(1));
    }
    if ((null == pid) || (pid.intValue() <= 0)) {
      pc = new Channel();
      pc.setId(0);
      pc.setName("网站系统栏目");
    } else {
      pc = this.channelService.load(pid.intValue());
    }
    model.addAttribute("pc", pc);
    model.addAttribute("channels", this.channelService.listChannelByParent(pid));
    return "channel/list_child";
  }
  @RequestMapping(value={"/treeAll"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public List<ChannelTree> treeAll() {
    return this.channelService.generateTree();
  }

  @RequestMapping(value={"/add/{pid}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(@PathVariable Integer pid, Model model) {
    Channel pc = null;
    if (null == pid) {
      pid = Integer.valueOf(0);
    }
    if (0 == pid.intValue()) {
      pc = new Channel();
      pc.setId(0);
      pc.setName("网站系统栏目");
    } else {
      pc = this.channelService.load(pid.intValue());
    }
    model.addAttribute("pc", pc);
    model.addAttribute(new Channel());
    return "channel/add";
  }

  @RequestMapping(value={"/add/{pid}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String add(@PathVariable Integer pid, Channel channel, Model model) {
    this.channelService.add(channel, pid);
    return "redirect:/admin/channel/channels/" + pid + "?refresh=1";
  }

  @RequestMapping({"/delete/{pid}/{id}"})
  public String delete(@PathVariable Integer pid, @PathVariable Integer id, Model model) {
    this.channelService.delete(id.intValue());
    return "redirect:/admin/channel/channels/" + pid + "?refresh=1";
  }

  @RequestMapping(value={"/update/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String update(@PathVariable Integer id, Model model) {
    Channel c = this.channelService.load(id.intValue());
    model.addAttribute("channel", c);
    Channel pc = null;
    if (c.getParent() == null) {
      pc = new Channel();
      pc.setId(0);
      pc.setName("网站系统栏目");
    } else {
      pc = c.getParent();
    }
    model.addAttribute("pc", pc);
    return "channel/update";
  }

  @RequestMapping(value={"/update/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(@PathVariable Integer id, Channel channel) {
    Channel tc = this.channelService.load(id.intValue());
    int pid = 0;
    if (tc.getParent() != null) pid = tc.getParent().getId();
    tc.setCustomLink(channel.getCustomLink());
    tc.setCustomLinkUrl(channel.getCustomLinkUrl());
    tc.setIsIndex(channel.getIsIndex());
    tc.setIsTopNav(channel.getIsTopNav());
    tc.setName(channel.getName());
    tc.setRecommend(channel.getRecommend());
    tc.setStatus(channel.getStatus());
    tc.setType(channel.getType());
    this.channelService.update(tc);
    return "redirect:/admin/channel/channels/" + pid + "?refresh=1";
  }
  @RequestMapping({"/channels/updateSort"})
  @ResponseBody
  public AjaxObj updateSort(@RequestParam(required=false) Integer[] ids) {
    try {
      this.channelService.updateSort(ids);
    } catch (Exception e) {
      return new AjaxObj(0, e.getMessage());
    }
    return new AjaxObj(1);
  }

  @RequestMapping(value={"/treeAsync"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public List<TreeDto> treeAsync(@RequestParam(required=false) Integer pid)
  {
    List list = new ArrayList();
    if (pid == null) {
      list.add(0, new TreeDto(0, "网站系统栏目", 1));
    }
    List<ChannelTree> cts = this.channelService.generateTreeByParent(pid);
    for (ChannelTree ct : cts) {
      list.add(new TreeDto(ct.getId().intValue(), ct.getName(), 1));
    }
    return list;
  }
}