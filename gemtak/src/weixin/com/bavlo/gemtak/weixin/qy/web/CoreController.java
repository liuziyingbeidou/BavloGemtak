package com.bavlo.gemtak.weixin.qy.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bavlo.gemtak.service.weixin.itf.ICoreService;
import com.bavlo.gemtak.weixin.qy.aes.AesException;
import com.bavlo.gemtak.weixin.qy.aes.WXBizMsgCrypt;
import com.bavlo.gemtak.weixin.qy.util.Constants;

/**
 * ע�ⷽʽ������
 * 
 * @author shijf
 *
 */
@Controller("qycoreController")
public class CoreController {
	
	@Resource
	ICoreService qycoreService;
	
	private String token = Constants.TOKEN;
	private String encodingAESKey =Constants.encodingAESKey;
	private String corpId = Constants.CORPID;

	@RequestMapping(value = { "/coreJoin.do" }, method = RequestMethod.GET)
	public void coreJoinGet(HttpServletRequest request,
		HttpServletResponse response) throws IOException {
		// ΢�ż���ǩ��
		String msg_signature = request.getParameter("msg_signature");
		// ʱ���
		String timestamp = request.getParameter("timestamp");
		// �����
		String nonce = request.getParameter("nonce");
		// ����ַ���
		String echostr = request.getParameter("echostr");

		System.out.println("request=" + request.getRequestURL());

		PrintWriter out = response.getWriter();
		// ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��
		String result = null;
		try {
			WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(token, encodingAESKey,
					corpId);
			result = wxcpt.VerifyURL(msg_signature, timestamp, nonce, echostr);
		} catch (AesException e) {
			e.printStackTrace();
		}
		if (result == null) {
			result = token;
		}
		out.print(result);
		out.close();
		out = null;
	}

	@RequestMapping(value = { "/coreJoin.do" }, method = RequestMethod.POST)
	public void coreJoinPost(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws IOException {
		// ��������Ӧ�ı��������ΪUTF-8����ֹ�������룩
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// ΢�ż���ǩ��
		String msg_signature = request.getParameter("msg_signature");
		// ʱ���
		String timestamp = request.getParameter("timestamp");
		// �����
		String nonce = request.getParameter("nonce");
		
		//�������ж�ȡ����post����
		InputStream inputStream = request.getInputStream();
		String postData = IOUtils.toString(inputStream, "UTF-8");
		System.out.println(postData);
		
		String msg = "";
		WXBizMsgCrypt wxcpt = null;
		try {
			wxcpt = new WXBizMsgCrypt(token, encodingAESKey, corpId);
			//������Ϣ
			msg = wxcpt.DecryptMsg(msg_signature, timestamp, nonce, postData);
		} catch (AesException e) {
			e.printStackTrace();
		}
		System.out.println("msg=" + msg);
		
		// ���ú���ҵ���������Ϣ��������Ϣ
		String respMessage = qycoreService.processRequest(msg,session);
		
		String encryptMsg = "";
		try {
			//���ܻظ���Ϣ
			encryptMsg = wxcpt.EncryptMsg(respMessage, timestamp, nonce);
		} catch (AesException e) {
			e.printStackTrace();
		}
		
		// ��Ӧ��Ϣ
		PrintWriter out = response.getWriter();
		out.print(encryptMsg);
		out.close();

	}

}
