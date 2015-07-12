<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/validate/main.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.cms.validate.js"></script>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<sf:form method="post" modelAttribute="group" id="addForm">
	<table width="800" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="2">查询用户组功能,ID: ${group.id }</td></tr></thead>
		<tr>
			<td class="rightTd" width="200px">组名称:</td>
			<td class="leftTd">${group.name }</td>
		</tr>
		<tr>
			<td class="rightTd">组描述:</td>
			<td class="leftTd">${group.descr }</td>
		</tr>
		<tr>
			<td class="rightTd">组中的所有用户:</td>
			<td>
				<c:forEach items="${users }" var="user">
					<a href="<%=request.getContextPath()%>/admin/user/${user.id}" class="list_op">[${user.nickname }]</a>&nbsp;
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="centerTd"><a href="update/${group.id }" class="list_op">修改用户组</a></td>
		</tr>
	</table>
	</sf:form>
</div>
</body>
</html>