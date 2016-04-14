package com.bavlo.gemtak.web.weixin;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bavlo.gemtak.service.ui.itf.IGemService;
import com.bavlo.gemtak.util.weixin.MessageUtil;
import com.bavlo.gemtak.web.BaseController;


/**
 * @Title: ����Gemtak
 * @ClassName: WxPayController 
 * @Description: ΢��
 * @author liuzy
 * @date 2016-3-17 ����04:40:48
 */
@Controller(value="wxPayController")
@RequestMapping(value="wx")
public class WxPayController extends BaseController {

	@Resource
	IGemService gemService;
	
	/**
	 * @Description: ΢��֧���ص�
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="payNoticeUrl")
	public String payNoticeUrl(HttpServletResponse response,HttpServletRequest request){
		System.out.println("΢��֧����ɻص���ʼ...");
		String st = "SUCCESS";
		// ����parseXml��������������Ϣ
		try {
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// ����״̬��
			String returnCode = requestMap.get("return_code");
			//ҵ����
			String resultCode = requestMap.get("result_code");
			//�̻�������
			String outTradeNo = requestMap.get("out_trade_no");
			/**֧������߼�����---��ʼ**/
			synchronized (outTradeNo) {
				gemService.rewriteOrderStatus(outTradeNo);	
			}
		} catch (Exception e) {
			e.printStackTrace();
			st = "FAIL";
		}
		String reqXml = "<xml>"+
	    "<return_code><![CDATA["+st+"]]></return_code>"+
	    "<return_msg><![CDATA[OK]]></return_msg>"+
	    "</xml>";
		return reqXml;
	}
}
