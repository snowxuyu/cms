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
	<sf:form method="post" modelAttribute="userDto" id="addForm">
	<table width="800" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="2">查询用户功能-->${user.nickname }</td></tr></thead>
		<tr>
			<td class="rightTd" width="200px">用户名(必须是英文):</td>
			<td class="leftTd">${user.username }</td>
		</tr>
		<tr>
			<td class="rightTd">显示名称(可以是中文):</td>
			<td class="leftTd">${user.nickname }</td>
		</tr>
		<tr>
			<td class="rightTd">联系电话:</td>
			<td>${user.phone }</td>
		</tr>
		<tr>
			<td class="rightTd">电子邮件:</td>
			<td>${user.email }</td>
		</tr>
		<tr>
			<td class="rightTd">状态:</td>
			<td>
				<c:if test="${user.status eq 0 }">
					<span class="emp">停用</span>
				</c:if>
				<c:if test="${user.status eq 1 }">
					<span>启用</span>
				</c:if>
				&nbsp;
			</td>
		</tr>
		<tr>
			<td class="rightTd">创建时间:</td>
			<td>
				<fmt:formatDate value="${user.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
		</tr>
		<tr>
			<td class="rightTd">拥有角色:</td>
			<td>
				<c:forEach items="${roles }" var="role">
					<c:if test="${isAdmin }">
						<a href="<%=request.getContextPath()%>/admin/role/${role.id}" class="list_op">[${role.name }]</a>&nbsp;
					</c:if>
					<c:if test="${not isAdmin }">
						[${role.name }]
					</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td class="rightTd">所在用户组:</td>
			<td>
				<c:forEach items="${groups }" var="group">
					<c:if test="${isAdmin }">
						<a href="<%=request.getContextPath()%>/admin/group/${group.id}" class="list_op">[${group.name }]</a>&nbsp;
					</c:if>
					<c:if test="${not isAdmin }">
						[${group.name }]
					</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<c:if test="${isAdmin }">
				<td colspan="2" class="centerTd"><a href="update/${user.id }" class="list_op">修改用户</a></td>
			</c:if>
			<c:if test="${not isAdmin }">
				<td colspan="2" class="centerTd"><a href="updateSelf" class="list_op">修改个人信息</a></td>
			</c:if>
		</tr>
	</table>
	</sf:form>
</div>
</body>
</html>