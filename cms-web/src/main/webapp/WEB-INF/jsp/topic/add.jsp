<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/js/base/jquery.ui.all.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/zTree/zTreeStyle.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/article.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/validate/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/uploadify/uploadify.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/js/core/jquery.cms.keywordinput.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/ui/jquery-ui-1.10.0.custom.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.cms.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/tree/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.cms.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/main.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.cms.keywordinput.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/uploadify/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/dwr/engine.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/dwr/interface/dwrController.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/topicAdd.js"></script>
<script type="text/javascript">
	$(function(){
		var editor = CKEDITOR.replace("content"
	   			, { toolbar :[
	   				['Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript'],
	   				['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent'],
	   				['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
	   				['Link', 'Unlink', 'Anchor'],
	   				['Maximize', 'ShowBlocks', '-'],
	   				['Image', 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar'],'/',
	   				['Styles', 'Format', 'Font', 'FontSize'],
	   				['TextColor', 'BGColor']]
	   			, width : "auto", height : "200px"
	   				,filebrowserImageUploadUrl :  "<%=request.getContextPath()%>/ckeditor/uploader?Type=Image"}
	   			);
		
		$("#keyword").keywordinput({
			autocomplete:{
				enable:true,
				url: "searchKeyword",
			}
		});
		$("#attach").uploadify({
			swf:$("#ctx").val()+"/resources/uploadify/uploadify.swf",
			uploader:"upload",
			fileObjName:"attach",
			auto:false,
			formData: {"sid":$("#sid").val()},
			fileTypeExts:"*.jpg;*.gif;*.png;*.doc;*.docx;*.txt;*.xls;*.xlsx;*.rar;*.zip;*.pdf;*.flv;*.swf",
			onUploadSuccess:function(file, data, response) {
				var ao = $.parseJSON(data);
				var suc = $.ajaxCheck(ao);
				if (suc) {
					var node = createAttachNode(ao.obj);
					$("#ok_attach").find("tbody").append(node);
				}
			}
		});
		var uploadPath = $(ctx).val()+"/resources/upload/";
		function createAttachNode(attach) {
			var node = "<tr>";
			if (attach.isImg) {
				node+= "<td><img src='"+uploadPath+"/thumbnail/"+attach.newName+"'/></td>";
			} else {
				node+= "<td>是普通类型附件</td>";
			}
			node += "<td>"+attach.oldName+"</td>";
			node += "<td>"+Math.round(attach.size/1024)+"K</td>";
			if (attach.isImg) {
				node += "<td><input type='checkbox' value='"+attach.id+"' name='indexPic' class='indexPic'/></td>";
				node += "<td><input type='radio' value='"+attach.id+"' name='channelPicId'/></td>";
			} else {
				node+= "<td>&nbsp;</td><td>&nbsp;</td>";
			}
			node += "<td><input type='checkbox' value='"+attach.id+"' name='isAttach' class='isAttach'/><input type='hidden' name='aids' value='"+attach.id+"'/></td>";
			node += "<td><a href='#' class='list_op insertAttach' title='"+attach.id+"' isImg='"+attach.isImg+"' name='"+attach.newName+"' oldName='"+attach.oldName+"'>插入到文章</a>&nbsp;<a href='#' title='"+attach.id+"' class='delete deleteAttach list_op'>删除附件</a></td>";
			node += "</tr>";
			return node;
		}
		
		$("#ok_attach").on("click", ".indexPic", function(){
			dwrController.updateIndexPic($(this).val());
		});
		$("#ok_attach").on("click", ".isAttach", function(){
			dwrController.updateAttachInfo($(this).val());
		});
		$("#ok_attach").on("click", ".insertAttach", function(){
			var node = "";
			var isImg = $(this).attr("isimg");
			if (1==isImg) {
				node = "<img src='"+uploadPath+$(this).attr("name")+"' id='attach_"+$(this).attr("title")+"'/>";
			} else {
				node = "<a href='"+uploadPath+$(this).attr("name")+"' id='attach_"+$(this).attr("title")+"'>"+$(this).attr("oldName")+"</a>";
			}
			editor.insertHtml(node);
		});
		$("#ok_attach").on("click", ".deleteAttach", function(){
			var conf = confirm("确定删除附件信息吗？");
			if (conf) {
				var ad = this;
				var id = $(this).attr("title");
				dwrController.deleteAttach(id, function(data){
					$(ad).parent("td").parent("tr").remove();
					//删除CKEDITOR中的附件
				});
			}
		});
		
		$("#uploadFile").click(function() {
			$("#attach").uploadify("upload","*");
		});
		
		var validate = $("#addForm").cmsvalidate();
		$("#addBtn").click(function(){
			if(validate.valid()) {
				$("#addForm").submit();
				$(this).attr("disabled");
			}
		});
		getNowDate($("#publishDate"));
	});
	
	function getNowDate(obj) {
		var mydate =   new Date();
		var myyear = mydate.getFullYear();
		var mymonth = mydate.getMonth()+1;
		var myday = mydate.getDate();
		if (String(mymonth).length<2) {mymonth = "0"+mymonth;}
		if (String(myday).length<2) {myday = "0"+myday;}
		var times = obj.val(myyear+"-"+mymonth+"-"+myday);
		return times;
	}
</script>
</head>
<body>
<input type="hidden" id="sid" value="<%=session.getId()%>"/>
<div id="menuContent" class="menuContent" style="display:none; position: absolute;background:#eee;z-index: 999;border:1px solid #999">
	<ul id="mytree" class="ztree" style="margin-top:0;"></ul>
</div>
<div id="container">
<jsp:include page="/jsp/admin/top_inc.jsp"></jsp:include>
<div id="contents">
	<input type="hidden" id="ctx" value="<%=request.getContextPath() %>"/>
	<h3 class="admin_link_bar" style="text-align:center">
	</h3>
	<sf:form method="post" modelAttribute="topicDto" id="addForm">
	<table width="980" cellspacing="0" cellPadding="0" id="addTable">
		<tr>
			<td class="rightTd" width="120px">文章标题:</td>
			<td class="leftTd">
			<sf:input path="title" size="80"/><sf:errors cssClass="errorContainer" path="title"/></td>
		</tr>
		<tr>
			<td class="rightTd">文章栏目:</td>
			<td class="leftTd">
				<input type="text" readonly="readonly" name="cname" id="cname"/>
				<input type="text" readonly="readonly" id="cid" name="cid" value="0"/>
			</td>
		</tr>
		<c:choose>
			<c:when test="${isAudit||isAdmin }">
			<tr>
				<td class="rightTd">文章状态:</td>
				<td class="leftTd">
					<sf:radiobutton path="status" value="0"/>未发布
					<sf:radiobutton path="status" value="1"/>已发布
				</td>
			</tr>
			</c:when>
			<c:otherwise>
			<sf:hidden path="status"/>
			</c:otherwise>
		</c:choose>
		<tr>
			<td class="rightTd">是否推荐该文章:</td>
			<td class="leftTd">
				<sf:radiobutton path="recommend" value="0"/>不推荐
				<sf:radiobutton path="recommend" value="1"/>推荐
			</td>
		</tr>
		<tr>
			<td class="rightTd">发布时间:</td>
			<td class="leftTd">
				<input id="publishDate" name="publishDate" readonly="readonly" type="text" onfocus="WdatePicker({isShowWeek:true})"/>
			</td>
		</tr>
		<tr>
			<td class="rightTd">文章关键字:</td>
			<td class="leftTd">
			<input id="keyword" name="keyword" type="text"/>
			</td>
		</tr>
		<tr>
			<td class="rightTd">文章附件</td>
			<td class="leftTd">
				<div id="attachs"></div>
				<input type="file" id="attach" name="attach"/>
				<input type="button" id="uploadFile" value="上传文件"/>
			</td>
		</tr>
		<tr>
		<td colspan="2">已传附件</td>
		</tr>
		<tr>
		<td colspan="2">
		<table id="ok_attach" width="890px" cellpadding="0" cellspacing="0">
			<thead>
				<tr>
				<Td>文件名缩略图</Td>
				<td width="180">文件名</td>
				<td>文件大小</td>
				<td>主页图片</td>
				<td>栏目图片</td>
				<td>附件信息</td>
				<td width="160">操作</td>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		</td>
		</tr>
		<tr>
			<td colspan="2">文章内容</td>
		</tr>
		<tr>
			<td colspan="2">
			<textarea id="context" name="content" rows="45" cols="110"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">文章摘要</td>
		</tr>
		<tr>
			<td colspan="2">
			<sf:textarea path="summary" rows="5" cols="110"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="centerTd"><input type="button" id="addBtn" value="添加文章"/><input type="reset"/></td>
		</tr>
	</table>
	</sf:form>
</div>
</div>
</body>
</html>