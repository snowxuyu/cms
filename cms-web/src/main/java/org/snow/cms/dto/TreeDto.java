package org.snow.cms.dto;

public class TreeDto
{
  private int id;
  private String name;
  private int isParent;

  public int getId()
  {
    return this.id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getIsParent() {
    return this.isParent;
  }
  public void setIsParent(int isParent) {
    this.isParent = isParent;
  }

  public TreeDto(int id, String name, int isParent) {
    this.id = id;
    this.name = name;
    this.isParent = isParent;
  }

  public TreeDto()
  {
  }
}