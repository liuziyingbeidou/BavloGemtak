package com.bavlo.gemtak.util.weixin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.SortedMap;
import java.util.TreeMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bavlo.gemtak.httpclient.HttpTools;
import com.bavlo.gemtak.model.weixin.PackageResult;
import com.bavlo.gemtak.model.weixin.WxPayDto;
import com.bavlo.gemtak.utils.StringUtil;

/**
 * @Title: ����Gemtak
 * @ClassName: WXPayUtil 
 * @Description: 
 * @author liuzy
 * @date 2016-3-17 ����10:05:06
 */
public class WXPayUtil {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*//΢��֧��jsApi
		WxPayDto tpWxPay = new WxPayDto();
		tpWxPay.setOpenId(openId);
		tpWxPay.setBody("��Ʒ��Ϣ");
		tpWxPay.setOrderId(getNonceStr());
		tpWxPay.setSpbillCreateIp("124.172.223.19");
		tpWxPay.setTotalFee("0.01");
	    getPackage(tpWxPay);
	  
	    //ɨ��֧��
	    WxPayDto tpWxPay1 = new WxPayDto();
	    tpWxPay1.setBody("��Ʒ��Ϣ");
	    tpWxPay1.setOrderId("184b6335e1570");
	    tpWxPay1.setSpbillCreateIp("124.172.223.19");
	    tpWxPay1.setTotalFee("0.01");
		String codeurl=getCodeurl(tpWxPay1,notifyurl1);  */
		System.out.println(Sha1Util.getTimeStamp());
		System.out.println( Sha1Util.getSha1("jsapi_ticket=sM4AOVdWfPE4DxkXGEs8VBm73XPzqHrNRCC_5Py8dtR-J-f2fFpqlumGEW1Kd8d5J6aibceSM-AxvF9jSPooPQ&noncestr=1432172228&timestamp=1446445979&url=http://weluckcn.com/user/order/wxpaydj?orderId=55555"));
	}
	
	/**
	 * @Description: ��ȡOpenId
	 * @param @param code
	 * @param @return
	 * @return String
	 */
	public static String getopendid(String code) {
	    String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=AppId&secret=AppSecret&code=CODE&grant_type=authorization_code";
	    url = url.replace("AppId", IContant.appId).replace("AppSecret", IContant.appSecret )
	            .replace("CODE", code);
	    String jsonResult = HttpTools.getDataByURL(url);
	    JSONObject jsonTexts = (JSONObject) JSON.parse(jsonResult);
	    String openid = "";
	    if (StringUtil.isNotEmpty(jsonTexts.get("openid")+"")) {
	        openid = jsonTexts.get("openid").toString();
	    }
	    return openid;
	}
	
	/**
	 * ��ȡ΢��ɨ��֧����ά������
	 */
	public static String getCodeurl(WxPayDto tpWxPayDto,String notifyurl){
		
		// 1 ����
		// ������
		String orderId = tpWxPayDto.getOrderId();
		// �������� ԭ������
		String attach = "";
		// �ܽ���Է�Ϊ��λ������С����
		String totalFee = getMoney(tpWxPayDto.getTotalFee());
		
		// �������ɵĻ��� IP
		String spbill_create_ip = tpWxPayDto.getSpbillCreateIp();
		// ����notify_url�� ֧����ɺ�΢�ŷ�����������Ϣ�������жϻ�Ա�Ƿ�֧���ɹ����ı䶩��״̬�ȡ�
		String notify_url = notifyurl;
		String trade_type = "NATIVE";

		// �̻���
		String mch_id = IContant.partner;
		// ����ַ���
		String nonce_str = getNonceStr();

		// ��Ʒ������������޸�
		String body = tpWxPayDto.getBody();

		// �̻�������
		String out_trade_no = orderId;

		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", IContant.appId);
		packageParams.put("mch_id", mch_id);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("body", body);
		packageParams.put("attach", attach);
		packageParams.put("out_trade_no", out_trade_no);

		// ����д�Ľ��Ϊ1 �ֵ�ʱ�޸�
		packageParams.put("total_fee", totalFee);
		packageParams.put("spbill_create_ip", spbill_create_ip);
		packageParams.put("notify_url", notify_url);

		packageParams.put("trade_type", trade_type);

		RequestHandler reqHandler = new RequestHandler(null, null);
		reqHandler.init(IContant.appId, IContant.appSecret, IContant.partnerkey);

		String sign = reqHandler.createSign(packageParams);
		String xml = "<xml>" + "<appid>" + IContant.appId + "</appid>" + "<mch_id>"
				+ mch_id + "</mch_id>" + "<nonce_str>" + nonce_str
				+ "</nonce_str>" + "<sign>" + sign + "</sign>"
				+ "<body><![CDATA[" + body + "]]></body>" 
				+ "<out_trade_no>" + out_trade_no
				+ "</out_trade_no>" + "<attach>" + attach + "</attach>"
				+ "<total_fee>" + totalFee + "</total_fee>"
				+ "<spbill_create_ip>" + spbill_create_ip
				+ "</spbill_create_ip>" + "<notify_url>" + notify_url
				+ "</notify_url>" + "<trade_type>" + trade_type
				+ "</trade_type>" + "</xml>";
		String code_url = "";
		String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		
		
		code_url = new GetWxOrderno().getCodeUrl(createOrderURL, xml);
		System.out.println("code_url----------------"+code_url);
		
		return code_url;
	}
	
	
	/**
	 * ��ȡ����Ԥ֧��id����
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static PackageResult getPackage(WxPayDto tpWxPayDto,String notifyurl) {
		
		String openId = tpWxPayDto.getOpenId();
		// 1 ����
		// ������
		String orderId = tpWxPayDto.getOrderId();
		// �������� ԭ������
		String attach = "";
		// �ܽ���Է�Ϊ��λ������С����
		String totalFee = getMoney(tpWxPayDto.getTotalFee());
		
		// �������ɵĻ��� IP
		String spbill_create_ip = tpWxPayDto.getSpbillCreateIp();
		// ����notify_url�� ֧����ɺ�΢�ŷ�����������Ϣ�������жϻ�Ա�Ƿ�֧���ɹ����ı䶩��״̬�ȡ�
		String notify_url = notifyurl;
		String trade_type = IContant.trade_type;

		// ---�������
		// �̻���
		String mch_id = IContant.partner;
		// ����ַ���
		String nonce_str = getNonceStr();

		// ��Ʒ������������޸�
		String body = tpWxPayDto.getBody();

		// �̻�������
		String out_trade_no = orderId;

		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", IContant.appId);
		packageParams.put("mch_id", mch_id);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("body", body);
		packageParams.put("attach", attach);
		packageParams.put("out_trade_no", out_trade_no);

		// ����д�Ľ��Ϊ1 �ֵ�ʱ�޸�
		packageParams.put("total_fee", totalFee);
		packageParams.put("spbill_create_ip", spbill_create_ip);
		packageParams.put("notify_url", notify_url);

		packageParams.put("trade_type", trade_type);
		packageParams.put("openid", openId);

		RequestHandler reqHandler = new RequestHandler(null, null);
		reqHandler.init(IContant.appId, IContant.appSecret, IContant.partnerkey);

		String sign = reqHandler.createSign(packageParams);
		String xml = "<xml>" + "<appid>" + IContant.appId + "</appid>" + "<mch_id>"
				+ mch_id + "</mch_id>" + "<nonce_str>" + nonce_str
				+ "</nonce_str>" + "<sign>" + sign + "</sign>"
				+ "<body><![CDATA[" + body + "]]></body>" 
				+ "<out_trade_no>" + out_trade_no
				+ "</out_trade_no>" + "<attach>" + attach + "</attach>"
				+ "<total_fee>" + totalFee + "</total_fee>"
				+ "<spbill_create_ip>" + spbill_create_ip
				+ "</spbill_create_ip>" + "<notify_url>" + notify_url
				+ "</notify_url>" + "<trade_type>" + trade_type
				+ "</trade_type>" + "<openid>" + openId + "</openid>"
				+ "</xml>";
		String prepay_id = "";
		String createOrderURL = IContant.createOrderURL;
		
		prepay_id = new GetWxOrderno().getPayNo(createOrderURL, xml);

		System.out.println("��ȡ����Ԥ֧��ID��" + prepay_id);
		
		
		//��ȡprepay_id��ƴ���������֧������Ҫ��package
		
		SortedMap<String, String> finalpackage = new TreeMap<String, String>();
		String timestamp = Sha1Util.getTimeStamp();
		String packages = "prepay_id="+prepay_id;
		finalpackage.put("appId", IContant.appId);  
		finalpackage.put("timeStamp", timestamp);  
		finalpackage.put("nonceStr", nonce_str);  
		finalpackage.put("package", packages);  
		finalpackage.put("signType", "MD5");
		//Ҫǩ��
		String finalsign = reqHandler.createSign(finalpackage);
		
		String finaPackage = "\"appId\":\"" + IContant.appId + "\",\"timeStamp\":\"" + timestamp
		+ "\",\"nonceStr\":\"" + nonce_str + "\",\"package\":\""
		+ packages + "\",\"signType\" : \"MD5" + "\",\"paySign\":\""
		+ finalsign + "\"";
		PackageResult pr=new PackageResult();
		pr.setAppId(IContant.appId);
		pr.setNonceStr(nonce_str);
		pr.setPackageurl(packages);
		pr.setPaySign(finalsign);
		pr.setSignType("MD5");
		pr.setTimeStamp(timestamp);
		System.out.println("V3 jsApi package:"+finaPackage);
		return pr;
	}

	/**
	 * ��ȡ����ַ���
	 * @return
	 */
	public static String getNonceStr() {
		// �����
		String currTime = TenpayUtil.getCurrTime();
		// 8λ����
		String strTime = currTime.substring(8, currTime.length());
		// ��λ�����
		String strRandom = TenpayUtil.buildRandom(4) + "";
		// 10λ���к�,�������е�����
		return strTime + strRandom;
	}

	/**
	 * Ԫת���ɷ�
	 * @param money
	 * @return
	 */
	public static String getMoney(String amount) {
		if(amount==null){
			return "";
		}
		// ���ת��Ϊ��Ϊ��λ
		String currency =  amount.replaceAll("\\$|\\��|\\,", "");  //�������, �� ����$�Ľ��  
        int index = currency.indexOf(".");  
        int length = currency.length();  
        Long amLong = 0l;  
        if(index == -1){  
            amLong = Long.valueOf(currency+"00");  
        }else if(length - index >= 3){  
            amLong = Long.valueOf((currency.substring(0, index+3)).replace(".", ""));  
        }else if(length - index == 2){  
            amLong = Long.valueOf((currency.substring(0, index+2)).replace(".", "")+0);  
        }else{  
            amLong = Long.valueOf((currency.substring(0, index+1)).replace(".", "")+"00");  
        }  
        return amLong.toString(); 
	}
	//��ȡ����access token
	public static String  getSignature(){
		BufferedReader in=null;
		try {
			String str = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+IContant.appId+"&secret="+IContant.appSecret;
				URL msgRespon;
				msgRespon = new URL(str);
			 in= new BufferedReader(new InputStreamReader(
				msgRespon.openStream()));
			String inputLine=null;
			while ((inputLine = in.readLine()) != null){
				System.out.println("inputLine:"+inputLine);
				return inputLine;
			 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return null;
}
}