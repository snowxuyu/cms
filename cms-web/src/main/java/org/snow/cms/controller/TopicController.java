package org.snow.cms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.snow.cms.auth.AuthClass;
import org.snow.cms.auth.AuthMethod;
import org.snow.cms.dto.AjaxObj;
import org.snow.cms.dto.TopicDto;
import org.snow.cms.model.Attachment;
import org.snow.cms.model.ChannelTree;
import org.snow.cms.model.Topic;
import org.snow.cms.model.User;
import org.snow.cms.service.IAttachmentService;
import org.snow.cms.service.IChannelService;
import org.snow.cms.service.IKeywordService;
import org.snow.cms.service.ITopicService;
import org.snow.cms.util.JsonUtil;
import org.snow.cms.util.SystemContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping({"/admin/topic"})
@AuthClass("login")
public class TopicController
{

  @Inject
  private ITopicService topicService;

  @Inject
  private IChannelService channelService;

  @Inject
  private IKeywordService keywordService;

  @Inject
  private IAttachmentService attachmentService;
  private static final List<String> imgTypes = Arrays.asList(new String[] { "jpg", "jpeg", "gif", "png" });

  private void initList(String con, Integer channelId, Model model, HttpSession session, Integer status) {
    SystemContext.setSort("t.publish_date");
    SystemContext.setOrder("desc");
    boolean isAdmin = ((Boolean)session.getAttribute("isAdmin")).booleanValue();
    if (isAdmin) {
      model.addAttribute("datas", this.topicService.find(channelId, con, status));
    } else {
      User loginUser = (User)session.getAttribute("loginUser");
      model.addAttribute("datas", this.topicService.find(Integer.valueOf(loginUser.getId()), channelId, con, status));
    }
    if (null == con) con = "";
    SystemContext.removeOrder();
    SystemContext.removeSort();
    model.addAttribute("con", con);
    model.addAttribute("cid", channelId);
    model.addAttribute("cs", this.channelService.listPublishChannel());
  }
  @RequestMapping({"/audits"})
  @AuthMethod(role="ROLE_PUBLISH,ROLE_AUDIT")
  public String auditList(@RequestParam(required=false) String con, @RequestParam(required=false) Integer cid, Model model, HttpSession session) {
    initList(con, cid, model, session, Integer.valueOf(1));
    return "topic/audits";
  }
  @RequestMapping({"/unaudits"})
  @AuthMethod(role="ROLE_PUBLISH,ROLE_AUDIT")
  public String unauditList(@RequestParam(required=false) String con, @RequestParam(required=false) Integer cid, Model model, HttpSession session) {
    initList(con, cid, model, session, Integer.valueOf(0));
    return "topic/unaudits";
  }
  @RequestMapping({"/changeStatus/{id}"})
  @AuthMethod(role="ROLE_AUDIT")
  public String changeStatus(@PathVariable int id, Integer status) {
    this.topicService.updateStatus(id);
    if (0 == status.intValue()) {
      return "redirect:/admin/topic/unaudits";
    }
    return "redirect:/admin/topic/audits";
  }

  @RequestMapping({"/delete/{id}"})
  @AuthMethod(role="ROLE_PUBLISH")
  public String delete(@PathVariable int id, Integer status) {
    this.topicService.delete(id);
    if (0 == status.intValue()) {
      return "redirect:/admin/topic/unaudits";
    }
    return "redirect:/admin/topic/audits";
  }

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @AuthMethod(role="ROLE_PUBLISH")
  public String add(Model model) {
    model.addAttribute("topicDto", new TopicDto());
    return "topic/add";
  }

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String add(TopicDto topicDto, String[] aks, Integer[] aids, HttpSession session) {
    Topic t = topicDto.getTopic();
    User loginUser = (User)session.getAttribute("loginUser");
    StringBuffer keys = new StringBuffer();
    if (null != aks) {
      for (String ak : aks) {
        keys.append(ak).append("|");
        this.keywordService.addOrUpdate(ak);
      }
    }
    t.setKeyword(keys.toString());
    this.topicService.add(t, topicDto.getCid(), loginUser.getId(), aids);
    return "redirect:/jsp/common/addSuc.jsp";
  }

  @RequestMapping({"/{id}"})
  public String show(@PathVariable int id, Model model)
  {
    model.addAttribute(this.topicService.load(id));
    model.addAttribute("atts", this.attachmentService.listByTopic(id));
    return "topic/show";
  }

  @RequestMapping(value={"/upload"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public void upload(MultipartFile attach, HttpServletResponse resp, Model model) throws IOException {
    resp.setContentType("text/plain;charset=utf-8");
    AjaxObj ao = null;
    try {
      Attachment att = new Attachment();
      String ext = FilenameUtils.getExtension(attach.getOriginalFilename());
      att.setIsAttach(0);
      if (imgTypes.contains(ext)) att.setIsImg(1); else
        att.setIsImg(0);
      att.setIsIndexPic(0);
      att.setNewName(String.valueOf(new Date().getTime()) + "." + ext);
      att.setOldName(FilenameUtils.getBaseName(attach.getOriginalFilename()));
      att.setSuffix(ext);
      att.setType(attach.getContentType());
      att.setTopic(null);
      att.setSize(attach.getSize());
      this.attachmentService.add(att, attach.getInputStream());
      ao = new AjaxObj(1, null, att);
    } catch (Exception e) {
      ao = new AjaxObj(0, e.getMessage());
    }
    resp.getWriter().write(JsonUtil.getInstance().obj2json(ao));
  }
  @RequestMapping({"/searchKeyword"})
  @AuthMethod(role="ROLE_PUBLISH")
  @ResponseBody
  public List<String> searchKeyword(String term) { return this.keywordService.listKeywordStringByCon(term); } 
  @RequestMapping(value={"/treeAll"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @AuthMethod(role="ROLE_PUBLISH")
  @ResponseBody
  public List<ChannelTree> treeAll() {
    return this.channelService.generateTree();
  }
}