$(function(){
	
	var t = $("#mytree").mytree({mine:{listChild:0},
		callback: {
			onAsyncSuccess: function(){
				t.expandAll(true);
			},
			beforeClick:beforeChoice,
			onClick:choice
		}
	});
	$("#cname").click(showMenu);
});

function showMenu() {
	$("#mytree").width($(this).width());
	var cityObj = $("#cname");
	var cityOffset = $("#cname").offset();
	$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
	$("body").bind("mousedown", onBodyDown);
}
function hideMenu() {
	$("#menuContent").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown);
}
function onBodyDown(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
		hideMenu();
	}
}
function choice(event,treeId,treeNode) {
	$("#cname").val(treeNode.name);
	$("#cid").val(treeNode.id);
	hideMenu();
}
function beforeChoice(treeId,treeNode) {
	var check = (treeNode && !treeNode.isParent);
	if (!check) {
		alert("此节点不可被选中...");
		return check;
	} 
}