package com.bavlo.gemtak.service.weixin.itf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信支付
 * @author Administrator
 *
 */
public interface IWXZFService {

	/**
	 * 创建定金的Package数据 网页支付形式
	 * @param orderId
	 * @param openid
	 * @return
	 */
	Map createOrder(HttpServletRequest request,String orderId,String openid,String totalPrice);
}
