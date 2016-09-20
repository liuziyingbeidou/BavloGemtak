package com.bavlo.gemtak.util.weixin;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: IContant 
 * @Description: 服务号常量
 * @author liuzy
 * @date 2015-12-7 下午05:15:23
 */
public interface IContant {

	//AppID(应用ID)微信支付商户开通后 微信会提供appid和appsecret和商户号partner
	public static String appId = "wx6daa3dcba790ad6f";
	//AppSecret(应用密钥)
	public static String appSecret = "e08d3c4e863555e7a99c8a510b433052";
	public static String partner = "1258965901";
	//这个参数partnerkey是在商户后台配置的一个32位的key,微信商户平台-账户设置-安全设置-api安全
	public static String partnerkey = "bavlocombavlocombavlocombavlocom";
	//公众号支付
	public static String trade_type = "JSAPI";
	//统一下单URL
	public static String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	/*项目配置常量*自定义回调URL*/
	public static final String REDIRECT_URI = "http://www.gemtak.com/gemtak/gemClient/orderSuccess.do";//"http://lzy348860554.imwork.net/gemtak/get-weixin-code.html";//
	//授权，静默跳转
	public static final String SCOPE = "snsapi_base";//
	//微信支付成功后通知地址 必须要求80端口并且地址不能带参数
	public static String notifyurl1 = "http://www.gemtak.com/gemtak/wx/payNoticeUrl.do";	
	
}
