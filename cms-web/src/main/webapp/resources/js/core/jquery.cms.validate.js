(function($){
	var _validate = $.fn.validate;
	$.fn.cmsvalidate = function(opts){
		var _rules = $.extend({
			username:"required",
			password:{
				required:true,
				minlength:3,
				maxlength:14
			},
			confirmPwd:{
				equalTo:"#password"
			},
			email:"email",
			name:"required",
			title:"required",
			cid:{
				min:1
			}
		},opts?(opts.rules||{}):{});
		
		var _messages = $.extend({
			username:"用户名不能为空!",
			password:{
				required:"用户密码不能为空!",
				minlength:"密码长度不能小于3位",
				maxlength:"密码长度不能大于14位"
			},
			confirmPwd:"两次输入密码不一致!",
			email:"邮箱格式不正确",
			name:"栏目名称不能为空",
			title:"标题不能为空",
			cid:"栏目不能为空"
		},opts?opts.message||{}:{});
		
		var _defaultOpts = $.extend(opts||{},{
			rules:_rules,
			messages:_messages,
			errorElement:opts?(opts.errorElement||"span"):"span",
			errorClass:opts?(opts.errorClass||"errorContainer"):"errorContainer"
		});
		$.extend($.fn.validate.prototype,_defaultOpts);
		_validate.call(this, _defaultOpts);
		return this;
	}
})(jQuery)
