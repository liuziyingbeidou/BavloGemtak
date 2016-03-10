package com.bavlo.gemtak.constant.controller;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: IClient 
 * @Description: Controller 控制常量
 * @author liuzy
 * @date 2016-3-8 下午04:47:46
 */
public interface IClientForward {

	/**GemClientController**/
	//首页
	public static final String viewGemList = "/client/gem/list";
	//详细页
	public static final String viewGemDetaile = "/client/gem/detaile";
	//购物车
	public static final String viewGemShoppingCar = "/client/gem/shopping-car";
	//订单
	public static final String gemOrder = "/client/gem/order";
	//订单完成
	public static final String gemOrderSuccess = "/client/gem/order-finish";
	//订单支付
	public static final String gemOrderPay = "/client/gem/order-pay";
	//登录
	public static final String gemLogin = "/client/gem/login";
	//用户中心
	public static final String gemUser = "/client/gem/user";
	
}
