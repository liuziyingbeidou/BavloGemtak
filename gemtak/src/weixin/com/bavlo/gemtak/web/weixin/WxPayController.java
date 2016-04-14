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
 * @Title: 宝珑Gemtak
 * @ClassName: WxPayController 
 * @Description: 微信
 * @author liuzy
 * @date 2016-3-17 下午04:40:48
 */
@Controller(value="wxPayController")
@RequestMapping(value="wx")
public class WxPayController extends BaseController {

	@Resource
	IGemService gemService;
	
	/**
	 * @Description: 微信支付回调
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="payNoticeUrl")
	public String payNoticeUrl(HttpServletResponse response,HttpServletRequest request){
		System.out.println("微信支付完成回调开始...");
		String st = "SUCCESS";
		// 调用parseXml方法解析请求消息
		try {
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// 返回状态码
			String returnCode = requestMap.get("return_code");
			//业务结果
			String resultCode = requestMap.get("result_code");
			//商户订单号
			String outTradeNo = requestMap.get("out_trade_no");
			/**支付结果逻辑处理---开始**/
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
