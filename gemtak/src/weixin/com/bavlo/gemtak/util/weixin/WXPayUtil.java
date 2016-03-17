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
 * @Title: 宝珑Gemtak
 * @ClassName: WXPayUtil 
 * @Description: 
 * @author liuzy
 * @date 2016-3-17 上午10:05:06
 */
public class WXPayUtil {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*//微信支付jsApi
		WxPayDto tpWxPay = new WxPayDto();
		tpWxPay.setOpenId(openId);
		tpWxPay.setBody("商品信息");
		tpWxPay.setOrderId(getNonceStr());
		tpWxPay.setSpbillCreateIp("124.172.223.19");
		tpWxPay.setTotalFee("0.01");
	    getPackage(tpWxPay);
	  
	    //扫码支付
	    WxPayDto tpWxPay1 = new WxPayDto();
	    tpWxPay1.setBody("商品信息");
	    tpWxPay1.setOrderId("184b6335e1570");
	    tpWxPay1.setSpbillCreateIp("124.172.223.19");
	    tpWxPay1.setTotalFee("0.01");
		String codeurl=getCodeurl(tpWxPay1,notifyurl1);  */
		System.out.println(Sha1Util.getTimeStamp());
		System.out.println( Sha1Util.getSha1("jsapi_ticket=sM4AOVdWfPE4DxkXGEs8VBm73XPzqHrNRCC_5Py8dtR-J-f2fFpqlumGEW1Kd8d5J6aibceSM-AxvF9jSPooPQ&noncestr=1432172228&timestamp=1446445979&url=http://weluckcn.com/user/order/wxpaydj?orderId=55555"));
	}
	
	/**
	 * @Description: 获取OpenId
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
	 * 获取微信扫码支付二维码连接
	 */
	public static String getCodeurl(WxPayDto tpWxPayDto,String notifyurl){
		
		// 1 参数
		// 订单号
		String orderId = tpWxPayDto.getOrderId();
		// 附加数据 原样返回
		String attach = "";
		// 总金额以分为单位，不带小数点
		String totalFee = getMoney(tpWxPayDto.getTotalFee());
		
		// 订单生成的机器 IP
		String spbill_create_ip = tpWxPayDto.getSpbillCreateIp();
		// 这里notify_url是 支付完成后微信发给该链接信息，可以判断会员是否支付成功，改变订单状态等。
		String notify_url = notifyurl;
		String trade_type = "NATIVE";

		// 商户号
		String mch_id = IContant.partner;
		// 随机字符串
		String nonce_str = getNonceStr();

		// 商品描述根据情况修改
		String body = tpWxPayDto.getBody();

		// 商户订单号
		String out_trade_no = orderId;

		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", IContant.appId);
		packageParams.put("mch_id", mch_id);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("body", body);
		packageParams.put("attach", attach);
		packageParams.put("out_trade_no", out_trade_no);

		// 这里写的金额为1 分到时修改
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
	 * 获取请求预支付id报文
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static PackageResult getPackage(WxPayDto tpWxPayDto,String notifyurl) {
		
		String openId = tpWxPayDto.getOpenId();
		// 1 参数
		// 订单号
		String orderId = tpWxPayDto.getOrderId();
		// 附加数据 原样返回
		String attach = "";
		// 总金额以分为单位，不带小数点
		String totalFee = getMoney(tpWxPayDto.getTotalFee());
		
		// 订单生成的机器 IP
		String spbill_create_ip = tpWxPayDto.getSpbillCreateIp();
		// 这里notify_url是 支付完成后微信发给该链接信息，可以判断会员是否支付成功，改变订单状态等。
		String notify_url = notifyurl;
		String trade_type = IContant.trade_type;

		// ---必须参数
		// 商户号
		String mch_id = IContant.partner;
		// 随机字符串
		String nonce_str = getNonceStr();

		// 商品描述根据情况修改
		String body = tpWxPayDto.getBody();

		// 商户订单号
		String out_trade_no = orderId;

		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", IContant.appId);
		packageParams.put("mch_id", mch_id);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("body", body);
		packageParams.put("attach", attach);
		packageParams.put("out_trade_no", out_trade_no);

		// 这里写的金额为1 分到时修改
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

		System.out.println("获取到的预支付ID：" + prepay_id);
		
		
		//获取prepay_id后，拼接最后请求支付所需要的package
		
		SortedMap<String, String> finalpackage = new TreeMap<String, String>();
		String timestamp = Sha1Util.getTimeStamp();
		String packages = "prepay_id="+prepay_id;
		finalpackage.put("appId", IContant.appId);  
		finalpackage.put("timeStamp", timestamp);  
		finalpackage.put("nonceStr", nonce_str);  
		finalpackage.put("package", packages);  
		finalpackage.put("signType", "MD5");
		//要签名
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
	 * 获取随机字符串
	 * @return
	 */
	public static String getNonceStr() {
		// 随机数
		String currTime = TenpayUtil.getCurrTime();
		// 8位日期
		String strTime = currTime.substring(8, currTime.length());
		// 四位随机数
		String strRandom = TenpayUtil.buildRandom(4) + "";
		// 10位序列号,可以自行调整。
		return strTime + strRandom;
	}

	/**
	 * 元转换成分
	 * @param money
	 * @return
	 */
	public static String getMoney(String amount) {
		if(amount==null){
			return "";
		}
		// 金额转化为分为单位
		String currency =  amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额  
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
	//获取调用access token
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