package com.bavlo.gemtak.constant.controller;

/**
 * @Title: ����Gemtak
 * @ClassName: IClient 
 * @Description: Controller ���Ƴ���
 * @author liuzy
 * @date 2016-3-8 ����04:47:46
 */
public interface IClientForward {

	/**GemClientController**/
	//��ҳ
	public static final String viewGemList = "/client/gem/list";
	//��ϸҳ
	public static final String viewGemDetaile = "/client/gem/detaile";
	//���ﳵ
	public static final String viewGemShoppingCar = "/client/gem/shopping-car";
	//����
	public static final String gemOrder = "/client/gem/order";
	//�������
	public static final String gemOrderSuccess = "/client/gem/order-finish";
	//����֧��
	public static final String gemOrderPay = "/client/gem/order-pay";
	//��¼
	public static final String gemLogin = "/client/gem/login";
	//�û�����
	public static final String gemUser = "/client/gem/user";
	
}
