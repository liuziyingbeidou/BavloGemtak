package com.bavlo.gemtak.util.weixin;

/**
 * @Title: ����Gemtak
 * @ClassName: IContant 
 * @Description: ����ų���
 * @author liuzy
 * @date 2015-12-7 ����05:15:23
 */
public interface IContant {

	//AppID(Ӧ��ID)΢��֧���̻���ͨ�� ΢�Ż��ṩappid��appsecret���̻���partner
	public static String appId = "wx6daa3dcba790ad6f";
	//AppSecret(Ӧ����Կ)
	public static String appSecret = "e08d3c4e863555e7a99c8a510b433052";
	public static String partner = "1258965901";
	//�������partnerkey�����̻���̨���õ�һ��32λ��key,΢���̻�ƽ̨-�˻�����-��ȫ����-api��ȫ
	public static String partnerkey = "bavlocombavlocombavlocombavlocom";
	//���ں�֧��
	public static String trade_type = "JSAPI";
	//ͳһ�µ�URL
	public static String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	/*��Ŀ���ó���*�Զ���ص�URL*/
	public static final String REDIRECT_URI = "http://www.gemtak.com/gemtak/gemClient/orderSuccess.do";//"http://lzy348860554.imwork.net/gemtak/get-weixin-code.html";//
	//��Ȩ����Ĭ��ת
	public static final String SCOPE = "snsapi_base";//
	//΢��֧���ɹ���֪ͨ��ַ ����Ҫ��80�˿ڲ��ҵ�ַ���ܴ�����
	public static String notifyurl1 = "http://www.gemtak.com/gemtak/wx/payNoticeUrl.do";	
	
}
