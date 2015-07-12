package org.snow.cms.controller;

import org.snow.cms.auth.AuthClass;
import org.snow.cms.util.BackupFileUtil;
import org.snow.cms.util.SystemContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@AuthClass
@Controller
@RequestMapping({"/admin"})
public class BackupController
{
  @RequestMapping(value={"/backup/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String backup()
  {
    return "backup/add";
  }

  @RequestMapping(value={"/backup/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String backup(String backupFilename) {
    BackupFileUtil bfu = BackupFileUtil.getInstance(SystemContext.getRealPath());
    bfu.backup(backupFilename);
    return "redirect:/admin/backups";
  }

  @RequestMapping({"/backups"})
  public String list(Model model) {
    BackupFileUtil bfu = BackupFileUtil.getInstance(SystemContext.getRealPath());
    model.addAttribute("backups", bfu.listBackups());
    return "backup/list";
  }

  @RequestMapping({"delete/{name}"})
  public String delete(@PathVariable String name, String type) {
    BackupFileUtil bfu = BackupFileUtil.getInstance(SystemContext.getRealPath());
    bfu.delete(name + "." + type);
    return "redirect:/admin/backups";
  }

  @RequestMapping({"resume/{name}"})
  public String resume(@PathVariable String name, String type) {
    BackupFileUtil bfu = BackupFileUtil.getInstance(SystemContext.getRealPath());
    bfu.resume(name + "." + type);
    return "redirect:/admin/backups";
  }
}