package org.snow.cms.dto;

public class AjaxObj
{
  private int result;
  private String msg;
  private Object obj;

  public int getResult()
  {
    return this.result;
  }
  public void setResult(int result) {
    this.result = result;
  }
  public String getMsg() {
    return this.msg;
  }
  public void setMsg(String msg) {
    this.msg = msg;
  }
  public Object getObj() {
    return this.obj;
  }
  public void setObj(Object obj) {
    this.obj = obj;
  }
  public AjaxObj(int result, String msg, Object obj) {
    this.result = result;
    this.msg = msg;
    this.obj = obj;
  }
  public AjaxObj(int result, String msg) {
    this.result = result;
    this.msg = msg;
  }
  public AjaxObj(int result) {
    this.result = result;
  }
  public AjaxObj() {
    this.result = 1;
  }
}