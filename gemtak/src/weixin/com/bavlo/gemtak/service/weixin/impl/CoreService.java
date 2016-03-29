package com.bavlo.gemtak.service.weixin.impl;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;

import com.bavlo.gemtak.service.weixin.itf.ICoreService;
import com.bavlo.gemtak.utils.StringUtil;
import com.bavlo.gemtak.weixin.qy.pojo.resp.TextMessage;
import com.bavlo.gemtak.weixin.qy.util.MessageUtil;
import com.bavlo.gemtak.weixin.qy.util.QiYeUtil;


/**
 * 处理微信发来的信息
 * @author shijf
 *
 */
@Service("qycoreService")
public class CoreService implements ICoreService{

	@Override
	public String processRequest(String msg,HttpSession session) {
		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";

			System.out.println("msg_XML=="+msg);
			
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(msg);

			System.out.println("Event=="+requestMap.get("Event"));
			
			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			
			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				String content = requestMap.get("Content"); 
				respContent = "shijf提示：您发送的是文本消息！内容是："+content;
			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "shijf提示：您发送的是图片消息！";
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "shijf提示：您发送的是地理位置消息！"; 
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "shijf提示：您发送的是链接消息！";
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "shijf提示：您发送的是音频消息！";
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				
				
				// 自定义菜单点击事件
				if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_CLICK)) {
					// 事件KEY值，与创建自定义菜单时指定的KEY值对应  
                    String eventKey = requestMap.get("EventKey");	
                    System.out.println("EventKey="+eventKey);
                    respContent = "shijf提示：您点击的菜单KEY是"+eventKey;
				}
			}

			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			respMessage="有异常了。。。";
		}
		return respMessage;
	}

	@Override
	//@Cacheable(value="myCache", key="'getRoleListByTagName'+#tagName") 
	public JSONArray getRoleListByTagName(HttpServletRequest request,String tagName) {
		JSONArray  jsobj = null;
		if(StringUtil.isNotEmpty(tagName)){
			jsobj = QiYeUtil.getUserList(request,tagName);
			if(jsobj != null){
				 return jsobj;
			}
		}
		return null;
	}

}
