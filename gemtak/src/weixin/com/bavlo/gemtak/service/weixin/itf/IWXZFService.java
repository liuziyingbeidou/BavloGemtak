package com.bavlo.gemtak.service.weixin.itf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * ΢��֧��
 * @author Administrator
 *
 */
public interface IWXZFService {

	/**
	 * ���������Package���� ��ҳ֧����ʽ
	 * @param orderId
	 * @param openid
	 * @return
	 */
	Map createOrder(HttpServletRequest request,String orderId,String openid,String totalPrice);
}
