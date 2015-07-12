package org.snow.cms.dto;

import java.util.List;
import org.snow.cms.model.User;

public class UserDto
{
  private int id;
  private String username;
  private String password;
  private String nickname;
  private String phone;
  private String email;
  private int status;
  private Integer[] roleIds;
  private Integer[] groupIds;

  public int getId()
  {
    return this.id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getUsername() {
    return this.username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return this.password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getNickname() {
    return this.nickname;
  }
  public void setNickname(String nickname) {
    this.nickname = nickname;
  }
  public String getPhone() {
    return this.phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public String getEmail() {
    return this.email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public int getStatus() {
    return this.status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
  public Integer[] getRoleIds() {
    return this.roleIds;
  }
  public void setRoleIds(Integer[] roleIds) {
    this.roleIds = roleIds;
  }
  public Integer[] getGroupIds() {
    return this.groupIds;
  }
  public void setGroupIds(Integer[] groupIds) {
    this.groupIds = groupIds;
  }

  public User getUser() {
    User user = new User();
    user.setId(this.id);
    user.setUsername(this.username);
    user.setPassword(this.password);
    user.setNickname(this.nickname);
    user.setPhone(this.phone);
    user.setEmail(this.email);
    user.setStatus(this.status);
    return user;
  }

  public UserDto(User user) {
    setId(user.getId());
    setUsername(user.getUsername());
    setPassword(user.getPassword());
    setNickname(user.getNickname());
    setPhone(user.getPhone());
    setEmail(user.getEmail());
    setStatus(user.getStatus());
  }

  public UserDto(User user, Integer[] roleIds, Integer[] groupIds) {
    setId(user.getId());
    setUsername(user.getUsername());
    setPassword(user.getPassword());
    setNickname(user.getNickname());
    setPhone(user.getPhone());
    setEmail(user.getEmail());
    setStatus(user.getStatus());
    setRoleIds(roleIds);
    setGroupIds(groupIds);
  }

  public UserDto(User user, List<Integer> roleIds, List<Integer> groupIds) {
    setId(user.getId());
    setUsername(user.getUsername());
    setPassword(user.getPassword());
    setNickname(user.getNickname());
    setPhone(user.getPhone());
    setEmail(user.getEmail());
    setStatus(user.getStatus());
    setRoleIds(listToArray(roleIds));
    setGroupIds(listToArray(groupIds));
  }

  private Integer[] listToArray(List<Integer> datas) {
    Integer[] nums = new Integer[datas.size()];
    for (int i = 0; i < datas.size(); i++) {
      nums[i] = ((Integer)datas.get(i));
    }
    return nums;
  }

  public UserDto()
  {
  }
}