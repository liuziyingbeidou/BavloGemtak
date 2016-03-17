package com.bavlo.gemtak.web.weixin;

import java.net.URLEncoder;

import com.bavlo.gemtak.util.weixin.IContant;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: GetWeiXinCode 
 * @Description: 获取微信的code URL
 * @author liuzy
 * @date 2016-3-17 上午10:16:59
 */
public class GetWeiXinCode {

	//public static String GetCodeRequest = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=gemtak#wechat_redirect";
	//public static String GetCodeRequest = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	public static String GetCodeRequest = "http://lzy348860554.imwork.net/gemtak/get-weixin-code.html?appid=APPID&redirect_uri=REDIRECT_URI&scope=SCOPE&state=STATE";

	public static String getCodeRequest() {

		String result = null;

		GetCodeRequest = GetCodeRequest.replace("APPID",
				urlEnodeUTF8(IContant.appId));

		GetCodeRequest = GetCodeRequest.replace("REDIRECT_URI",
				urlEnodeUTF8(IContant.REDIRECT_URI));

		GetCodeRequest = GetCodeRequest.replace("SCOPE", IContant.SCOPE);

		result = GetCodeRequest;

		return result;

	}

	public static String urlEnodeUTF8(String str) {

		String result = str;

		try {

			result = URLEncoder.encode(str, "UTF-8");

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;

	}

	public static void main(String[] args) {

		System.out.println(getCodeRequest());

	}

}