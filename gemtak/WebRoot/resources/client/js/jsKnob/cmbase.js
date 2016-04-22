void function(win)
{
	var cm = win.cm ||
	{};
	win.cm = cm;
	cm.name = 'cm';
	if (typeof define === 'function' && define.amd)
	{
		define(cm.name, [], function()
		{
			return cm;
		});
	}
	cm.version = '1.0.0';

	String.prototype.endWith = function(s)
	{
		if (s == null || s == "" || this.length == 0 || s.length > this.length)
			return false;
		if (this.substring(this.length - s.length) == s)
			return true;
		else
			return false;
		return true;
	}
	String.prototype.startWith = function(s)
	{
		if (s == null || s == "" || this.length == 0 || s.length > this.length)
			return false;
		if (this.substr(0, s.length) == s)
			return true;
		else
			return false;
		return true;
	}

	cm.htmlEncode = function(s)
	{
		var div = document.createElement('div');
		div.appendChild(document.createTextNode(s));
		return div.innerHTML;
	}
	cm.htmlDecode = function(s)
	{
		var div = document.createElement('div');
		div.innerHTML = s;
		return div.innerText || div.textContent;
	}
	cm.gotoUrl = function(urlStr)
	{
		window.location.href = urlStr;
	}
	cm.openUrl = function(url)
	{
		window.open(url);
	}
	cm.winClose = function()
	{
		window.close();
	}
	cm.refreshPage = function()
	{
		location.reload();
	}
	cm.toJSON = function(jsonStr)
	{
		jsonStr = jsonStr.replace(new RegExp('<', "gm"), '&gt;');
		jsonStr = jsonStr.replace(new RegExp('>', "gm"), '&lt;');
		jsonStr = jsonStr.replace(new RegExp(' ', "gm"), '&nbsp;');
		// jsonStr = jsonStr.replace(new RegExp('\"',"gm"),'&quot;');
		jsonStr = jsonStr.replace(new RegExp('\'', "gm"), '&#39;');
		jsonStr = jsonStr.replace(new RegExp('\n', "gm"), '\\n');
		jsonStr = jsonStr.replace(new RegExp('\r', "gm"), '\\r');
		return jQuery.parseJSON(jsonStr);
	}
	cm.toString = function(json)
	{
		return JSON.stringify(json);
	}
	cm.changeVCode = function(id)
	{
		Math.floor(Math.random() * 987654321);
		$('#' + id).attr("src", "/captcha?rand=" + Math.floor(Math.random() * 123456789));
	}
	cm.bulidJson = function(ids)
	{
		var returnJson = '';
		returnJson = returnJson + '{';
		($chk(ids))
		{
			for (var i = 0; i < ids.length; i++)
			{
				if ($chk($(ids[i])))
				{
					if (returnJson != '{')
					{
						returnJson = returnJson + ",";
					}
					returnJson = returnJson + '"' + ids[i] + '":"' + $(ids[i]).get('value') + '"';
				}

			}
		}
		returnJson = returnJson + '}';
		return returnJson;

	}
	cm.mobileCheck = function(mobile)
	{
		if (!mobile.match(/^1[3|4|5|8][0-9]\d{4,8}$/))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	cm.getTS = function()
	{
		return (new Date()).valueOf();
	}
	cm.validatorInit = function(form_id, beforeValidate)
	{
		$('#' + form_id).validator(
		{
			stopOnError : false,
			msgMaker : false,
			focusInvalid : false,
			focusCleanup : true,
			timely : 0,
			beforeSubmit : beforeValidate,
			invalid : function(form, errors)
			{
				var html = '';
				$.map(errors, function(msg)
				{
					html += '<span class="" >' + msg + '<br/></span>'
				});
				cm.tip(
				{
					content : html
				});
			},
			valid : function(form)
			{
			}
		});
		return $('#' + form_id).data("validator");
	}
	cm.strToArray = function(str, split)
	{
		return str.split(split);
	}
	cm.getQueryString = function(name)
	{
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	}
	cm.post = function(para)
	{
		cm.loadingShow();
		if(!para.dataType)
		{
			para.dataType="json";
		}
		$.ajax(
		{
			type : "POST",
			url : para.url,
			data : para.data,
			dataType : para.dataType,
			timeout : 8000,
			success : function(data)
			{
				cm.loadingHide();
				para.success(data);
			},
			error : function(data)
			{
				cm.loadingHide();

			}
		});
	}
	cm.ajaxForm = function(para)
	{
		cm.loadingShow();
		var options =
		{
			url:para.url,
			dataType:'json',
			type:'POST',
			clearForm:true,
			data:para.data,
			success : function(data)
			{
				cm.loadingHide();
				para.success(data);
			},
			error : function(data)
			{
				cm.loadingHide();
			}
		};
		$("#"+para.form_id).ajaxSubmit(options);
	}

	cm.loading_window_id = 0;
	cm.loadingShow = function()
	{
		cm.loading_window_id = cm.tip(
		{
			content : '鍔犺浇涓�......',
			backdrop : 'static'
		});
		setTimeout("cm.loadingHide('" + cm.loading_window_id + "')", 20000);
	}
	cm.loadingHide = function(window_id)
	{
		if (window_id)
		{
			if (cm.loading_window_id != window_id)
			{
				return;
			}
			else
			{
				$('#' + window_id).modal('hide');
			}
		}
		else
		{
			$('[element_type=cm_tip]').modal('hide');
			$('[element_type=cm_tip]').remove();
		}

	}

	cm.alert_id_count = 0;
	cm.alert = function(para)
	{
		if (para.title == null || para.title == '')
		{
			para.title = "鎻愮ず淇℃伅";
		}
		if (para.content == null)
		{
			para.content = "";
		}
		if (para.height == null)
		{
			para.height = "";
		}
		if (para.animate == null)
		{
			para.animate = "";
		}
		if (para.commit_button_name == null)
		{
			para.commit_button_name = "纭畾";
		}

		cm.alert_id_count++;
		var alert_id = "modal_box_" + cm.alert_id_count;
		var box_html = '<div class="modal inmodal" element_type="cm_modal" tabindex="-1" role="dialog" aria-hidden="true" id="' + alert_id + '">';
		box_html += '<div class="modal-dialog">';
		box_html += '<div class="modal-content animated ' + para.animate + ' ">';
		box_html += '<div class="modal-header" style="padding:15px 10px;"><h4 class="modal-title">' + para.title + '</h4></div>';
		box_html += '<div class="modal-body">' + para.content + '</div>';
		box_html += '<div class="modal-footer" style="text-align: center;"><button type="button" class="btn btn-primary btn-block btn-outline" data-dismiss="modal">' + para.commit_button_name + '</button></div>';
		box_html += '</div>';
		box_html += '</div>';
		box_html += '</div>';
		var box = $(box_html);
		$('[element_type=cm_modal]').modal('hide');
		$('[element_type=cm_modal]').remove();
		$('body').append(box);
		$('#' + alert_id).modal('show');
		if (para.onFinishFunc != null)
		{
			para.onFinishFunc();
		}
		return alert_id;
	}
	
	cm.confirm_id_count = 0;
	cm.confirm = function(para)
	{
		if (para.title == null || para.title == '')
		{
			para.title = "鎻愮ず淇℃伅";
		}
		if (para.content == null)
		{
			para.content = "";
		}
		if (para.height == null)
		{
			para.height = "";
		}
		if (para.animate == null)
		{
			para.animate = "";
		}
		if (para.commit_button_name == null)
		{
			para.commit_button_name = "纭畾";
		}
		if (para.cancel_button_name == null)
		{
			para.cancel_button_name = "鍙栨秷";
		}

		cm.alert_id_count++;
		var confirm_id = "modal_box_" + cm.confirm_id_count;
		var box_html = '<div class="modal inmodal" element_type="cm_modal" tabindex="-1" role="dialog" aria-hidden="true" id="' + confirm_id + '">';
		box_html += '<div class="modal-dialog">';
		box_html += '<div class="modal-content animated ' + para.animate + ' ">';
		box_html += '<div class="modal-header" style="padding:15px 10px;"><h4 class="modal-title">' + para.title + '</h4></div>';
		box_html += '<div class="modal-body">' + para.content + '</div>';
		box_html += '<div class="modal-footer" style="text-align: center;"><button type="button" class="btn btn-white  btn-outline" data-dismiss="modal" onclick="'+para.cancelFunc+'">' + para.cancel_button_name + '</button><button type="button" class="btn btn-primary  btn-outline" data-dismiss="modal" onclick="'+para.commitFunc+'">' + para.commit_button_name + '</button></div>';
		box_html += '</div>';
		box_html += '</div>';
		box_html += '</div>';
		var box = $(box_html);
		$('[element_type=cm_modal]').modal('hide');
		$('[element_type=cm_modal]').remove();
		$('body').append(box);
		$('#' + confirm_id).modal('show');
		return confirm_id;
	}
	
	cm.modal_id_count = 0;
	cm.modal = function(para)
	{

		if (para.content == null)
		{
			para.content = "";
		}
		if (para.height == null)
		{
			para.height = "";
		}
		if (para.width == null)
		{
			para.width = "";
		}
		else
		{
			para.width = "width:"+para.width+"px;";
		}
		if (para.animate == null)
		{
			para.animate = "";
		}
		if (para.margin_top == null)
		{
			para.margin_top = "30";
		}

		cm.modal_id_count++;
		var modal_id = "modal_box_" + cm.modal_id_count;
		var box_html = '<div class="modal inmodal" element_type="cm_modal" tabindex="-1" role="dialog" aria-hidden="true" id="' + modal_id + '">';
		box_html += '<div class="modal-dialog" style="margin-top:'+para.margin_top+'px;'+para.width+'">';
		box_html += '<div class="modal-content animated ' + para.animate + ' ">';
		if(para.header=="true")
		{
			if(para.header_content!=null)
			{
				box_html += '<div class="modal-header" >'+para.header_content+'</div>';
			}
			else
			{
				box_html += '<div class="modal-header" ><button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">脳</span><span class="sr-only">Close</span></button></div>';
			}
			
		}
		else
		{
			box_html += '<div class="modal-header" style="padding:2px;border:0px;"></div>';
		}
		
		box_html += '<div class="modal-body" style="padding:2px;">' + para.content + '</div>';
		box_html += '<div class="modal-footer" style="padding:2px;border:0px;"></div>';
		box_html += '</div>';
		box_html += '</div>';
		box_html += '</div>';
		var box = $(box_html);
		$('[element_type=cm_modal]').modal('hide');
		$('[element_type=cm_modal]').remove();
		$('body').append(box);
		$('#' + modal_id).modal('show');
		if (para.onFinishFunc != null)
		{
			para.onFinishFunc();
		}
		return modal_id;
	}
	
	cm.window_id_count = 0;
	cm.window = function(para)
	{
		if (para.url == null)
		{
			return;
		}
		if (para.animate == null)
		{
			para.animate = "";
		}
		if (para.backdrop == null)
		{
			para.backdrop = 'true';
		}
		para.success = function(data)
		{
			if (data.status == 'success')
			{
				cm.window_id_count++;
				var modal_id = "modal_box_" + cm.window_id_count;
				var box_html = '<div class="modal inmodal" element_type="cm_window" tabindex="-1" role="dialog" aria-hidden="true" id="' + modal_id + '">';
				box_html += '<div class="modal-dialog" style="margin: 200px auto;">';
				box_html += '<div class="modal-content animated ' + para.animate + ' ">';
				box_html += '<div class="modal-header" style="padding:2px;border:0px;"><button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">脳</span><span class="sr-only">Close</span></button></div>';
				box_html += '<div class="modal-body" style="background-color:#ffffff;padding: 20px 30px 30px 30px;">' + data.html + '</div>';
				box_html += '<div class="modal-footer" style="padding:2px;border:0px;"></div>';
				box_html += '</div>';
				box_html += '</div>';
				box_html += '</div>';
				var box = $(box_html);
				$('[element_type=cm_window]').modal('hide');
				$('[element_type=cm_window]').remove();
				$('body').append(box);
				// $('#' + modal_id).modal('show');
				$('#' + modal_id).modal(
				{
					backdrop : para.backdrop,
					keyboard : false
				});
				if (sw&&sw.init)
				{
					sw.init();
				}
				return modal_id;
			}
			else
			{

			}
		}
		cm.post(para);

		
	}
	cm.subWindow = function(para)
	{
		if (para.url == null)
		{
			return;
		}
		if (para.width == null)
		{
			para.width = 800;
		}
		if (para.height == null)
		{
			para.height = 600;
		}

		var left = ($(window).width() - para.width) / 2;
		var top = ($(window).height() - para.height) / 2;
		var features="";
		features+="dialogHeight:"+para.height+"px;";
		features+="dialogWidth:"+para.width+"px;";
		features+="dialogLeft:"+left+"px;";
		features+="dialogTop:"+top+"px;";
		features+="center:yes;";
		features+="help:no;";
		features+="resizable:no;";
		features+="status:no;";
		features+="scroll:yes;";
		features+="toolbar:no;menubar:no;scrollbars:no;location:no;";
		window.showModalDialog('/common/sub_window',para,features);
		
	}

	cm.tip_id_count = 0;
	cm.tip = function(para)
	{
		if (para.content == null)
		{
			para.content = "";
		}
		if (para.animate == null)
		{
			para.animate = "";
		}
		if (para.backdrop == null)
		{
			para.backdrop = 'true';
		}

		cm.tip_id_count++;
		var modal_id = "modal_box_" + cm.tip_id_count;
		var box_html = '<div class="modal inmodal" element_type="cm_tip" tabindex="-1" role="dialog" aria-hidden="true" id="' + modal_id + '">';
		box_html += '<div class="modal-dialog" style="margin: 200px auto;">';
		box_html += '<div class="modal-content animated ' + para.animate + ' ">';
		box_html += '<div class="modal-header" style="padding:2px;border:0px;"></div>';
		box_html += '<div class="modal-body" style="background-color:#ffffff;padding: 20px 30px 30px 30px;">' + para.content + '</div>';
		box_html += '<div class="modal-footer" style="padding:2px;border:0px;"></div>';
		box_html += '</div>';
		box_html += '</div>';
		box_html += '</div>';
		var box = $(box_html);
		$('[element_type=cm_tip]').modal('hide');
		$('[element_type=cm_tip]').remove();
		$('body').append(box);
		// $('#' + modal_id).modal('show');
		$('#' + modal_id).modal(
		{
			backdrop : para.backdrop,
			keyboard : false
		});
		return modal_id;
	};
	cm.modalHide=function(modal_id)
	{
		$('#'+modal_id).modal('hide');
		$('#'+modal_id).remove();
	};
	
	cm.regex_url=function(str)
	{
		var strRegex = "^((https|http|ftp|rtsp|mms)?://)" 
			  + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?"
			        + "(([0-9]{1,3}/.){3}[0-9]{1,3}" 
			        + "|" 
			        + "([0-9a-z_!~*'()-]+/.)*" 
			        + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]/." 
			        + "[a-z]{2,6})" 
			        + "(:[0-9]{1,4})?" 
			        + "((/?)|" 
			        + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$"; 
			        var re=new RegExp(strRegex); 
			        if (re.test(str)){
			            return (true); 
			        }else{ 
			            return (false); 
			        }
	}
	cm.regex_list = new Object();
	cm.regex_list['email'] = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	cm.regex_list['mobile'] = /^(0|86|17951)?(13[0-9]|15[012356789]|18[0-9]|14[57])[0-9]{8}$/;
	cm.regex_list['qq'] = /^[1-9][0-9]{4,9}$/;
	cm.regex_list['integer'] = /^[-]{0,1}[0-9]{1,}$/;
	cm.regex_list['positive_integer'] = /^[0-9]+$/;
	cm.regex_list['phone'] = /^[0][1-9]{2,3}-[0-9]{5,10}$/;
	cm.regex_list['phone_no_area'] = /^[1-9]{1}[0-9]{5,8}$/;
	cm.regex_list['decimal'] = /^[-]{0,1}(\d+)[\.]+(\d+)$/;
	cm.regex_list['ip'] = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
	cm.regex_list['date'] = /^\d{4}-\d{1,2}-\d{1,2}$/;
	cm.regex_list['letter'] = /^[a-z]+$/i;
	cm.regex_list['id_card'] = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[A-Z])$/;
	cm.regex_list['chinese'] = /^[\u0391-\uFFE5]+$/;
	cm.regex = function(type, str)
	{
		if(type=='url')
		{
			return cm.regex_url(str);
		}
		else
		{
			if (cm.regex_list[type].test(str))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		

	}

}(window);
