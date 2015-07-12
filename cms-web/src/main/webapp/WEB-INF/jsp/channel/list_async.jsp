<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/zTree/zTreeStyle.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/tree/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript">
$(function(){
	var setting = {
			view:{
				dblClickExpand: false,
				selectedMulti: false
			},
			async: {
				enable: true,
				url: "treeAsync",
				type: "post",
				autoParam: ["id=pid"]  //用来指定传递参数的key名称
			},
			callback: {
				onClick: function(event, treeId, treeNode){
					//返回放置tree的div的ID
					//alert(treeId);   
					
					//treeNode.isParent 是内部属性 判断选中的节点是不是父节点  是返回true 不是返回false
					//alert(treeNode.id+","+treeNode.pid+","+treeNode.name+","+treeNode.test+","+treeNode.isParent)
				}
			}
	};
	var t = $.fn.zTree.init($("#tree"), setting);
});
	
</script>
</head>
<body>
  	<div id="tree" class="ztree">
		
	</div>
</body>
</html>