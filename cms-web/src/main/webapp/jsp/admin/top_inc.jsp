<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	var xq = "";
	function setTime(){
		date = new Date();
		if (1==date.getDay()) {
			xq = "一";
		} else if (2==date.getDay()) {
			xq = "二";
		} else if (3==date.getDay()) {
			xq = "三";
		} else if (4==date.getDay()) {
			xq = "四";
		} else if (5==date.getDay()) {
			xq = "五";
		} else if (6==date.getDay()) {
			xq = "六";
		} else if (0==date.getDay()) {
			xq = "日";
		}
		time.innerHTML = date.getFullYear()+'年'+(date.getMonth()+1)+'月'+date.getDate()+'日,星期'+xq;
	}
	window.setInterval("setTime()", 1000);
</script>
<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>"/>
<div id="top">
	<div id="topIntro">
		<span id="logo"></span>
		<span id="user_operator">
			 <a href="<%=request.getContextPath()%>/index"  target="_blank">网站首页</a>
			|<a href="<%=request.getContextPath()%>/admin/user/showSelf"  target="content">查询个人信息</a>
			|<a href="<%=request.getContextPath()%>/admin/user/updateSelf"  target="content">修改个人信息</a>
			|<a href="<%=request.getContextPath()%>/admin/user/updatePwd"  target="content">修改密码</a>
			|<a href="javascript:exitSystem()">退出系统</a>
		</span>
	</div>
	<div id="remind">
		<span id="showDate"><span id="time"></span> 欢迎[${loginUser.nickname }]使用${baseInfo.name }网站后台管理程序</span>
	</div>
</div>
