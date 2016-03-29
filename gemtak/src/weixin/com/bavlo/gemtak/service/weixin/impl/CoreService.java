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
 * ����΢�ŷ�������Ϣ
 * @author shijf
 *
 */
@Service("qycoreService")
public class CoreService implements ICoreService{

	@Override
	public String processRequest(String msg,HttpSession session) {
		String respMessage = null;
		try {
			// Ĭ�Ϸ��ص��ı���Ϣ����
			String respContent = "�������쳣�����Ժ��ԣ�";

			System.out.println("msg_XML=="+msg);
			
			// xml�������
			Map<String, String> requestMap = MessageUtil.parseXml(msg);

			System.out.println("Event=="+requestMap.get("Event"));
			
			// ���ͷ��ʺţ�open_id��
			String fromUserName = requestMap.get("FromUserName");
			// �����ʺ�
			String toUserName = requestMap.get("ToUserName");
			// ��Ϣ����
			String msgType = requestMap.get("MsgType");
			
			// �ظ��ı���Ϣ
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			// �ı���Ϣ
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				String content = requestMap.get("Content"); 
				respContent = "shijf��ʾ�������͵����ı���Ϣ�������ǣ�"+content;
			}
			// ͼƬ��Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "shijf��ʾ�������͵���ͼƬ��Ϣ��";
			}
			// ����λ����Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "shijf��ʾ�������͵��ǵ���λ����Ϣ��"; 
			}
			// ������Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "shijf��ʾ�������͵���������Ϣ��";
			}
			// ��Ƶ��Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "shijf��ʾ�������͵�����Ƶ��Ϣ��";
			}
			// �¼�����
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// �¼�����
				String eventType = requestMap.get("Event");
				
				
				// �Զ���˵�����¼�
				if (eventType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_CLICK)) {
					// �¼�KEYֵ���봴���Զ���˵�ʱָ����KEYֵ��Ӧ  
                    String eventKey = requestMap.get("EventKey");	
                    System.out.println("EventKey="+eventKey);
                    respContent = "shijf��ʾ��������Ĳ˵�KEY��"+eventKey;
				}
			}

			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			respMessage="���쳣�ˡ�����";
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
