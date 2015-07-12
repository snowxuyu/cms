$(function(){
		var t = $("#tree").mytree({
			url: $("#treePath").val(),
			mine: {listChild:0},
			callback: {
				onAsyncSuccess: initTree,
				beforeCheck: function(treeId, treeNode) {
					if (!treeNode.checked) {
						//ps中的节点进行添加
						var ps = t.getCheckParentNodes(treeNode, false);
						ps.push(treeNode);
						addGroupChannels(ps);
					} else {
						var cs = new Array();
						t.getCheckChildNodes(treeNode,true,cs);
						cs.push(treeNode);
						//cs中的节点进行删除
						deleteGroupChannels(cs);
					}
				},
				onCheck: function(event, treeId, treeNode) {
					if (!treeNode.checked) {
						var ps = t.getCheckParentNodes(treeNode, false);
						//ps就表示要删除的元素
						deleteGroupChannels(ps);
					}
				}
			},
			check:{
				enable: true,
				chkboxType:{"Y":"p", "N":"ps"}
			}
		});
		
		function initTree() {
			t.expandAll(true);
			var cids = $("input[name='cids']");
			for (var i=0; i<cids.length; i++) {
				var cid = cids[i].value;
				var n = t.getNodeByParam("id",cid,null);
				t.checkNode(n,true,true);
			}
		}
		
		function handler(msg, exc) {
			alert(msg);
		}
		
		dwr.engine.setErrorHandler(handler);
		
		function addGroupChannels(cs) {
			var gid = $("#gid").val();
			for (var i=0; i<cs.length; i++) {
				var c = cs[i];
				if (c.id>0) {
					dwrController.addGroupChannel(gid, c.id);
				}
			}
		}
		
		function deleteGroupChannels(cs) {
			var gid = $("#gid").val();
			for (var i=0; i<cs.length; i++) {
				var c = cs[i];
				if (c.id>0) {
					dwrController.deleteGroupChannel(gid, c.id);
				}
			}
		}
		
	});