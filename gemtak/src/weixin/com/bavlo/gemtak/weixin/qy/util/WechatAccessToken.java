package com.bavlo.gemtak.weixin.qy.util;


import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.bavlo.gemtak.weixin.qy.enums.EnumMethod;
import com.bavlo.gemtak.weixin.qy.pojo.AccessToken;

/**
 * ����ƽ̨ͨ�ýӿڹ�����
 * 
 */
public class WechatAccessToken {
	// ��ȡ΢�Ź��ںţ�access_token�Ľӿڵ�ַ��GET�� ��2000����/�죩
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	// ��ȡ��ҵ��access_token
	public final static String company_access_token_url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=CORPID&corpsecret=CORPSECRET";

	/**
	 * ��ȡaccess_token
	 * 
	 * @param appid
	 *            ƾ֤
	 * @param appsecret
	 *            ��Կ
	 * @return
	 */
	public static AccessToken getAccessToken(String appid, String appsecret, int type) {
		AccessToken accessToken = null;
		String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		if (type == 1) {
			requestUrl = company_access_token_url.replace("CORPID", appid).replace("CORPSECRET", appsecret);
			System.err.println(requestUrl);
		}
		JSONObject jsonObject = HttpRequestUtil.httpRequest(requestUrl, EnumMethod.GET.name(), null);
		if(jsonObject==null){
			jsonObject = HttpRequestUtil.httpRequest(requestUrl, EnumMethod.GET.name(), null);
		}
		// �������ɹ�
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				// ��ȡtokenʧ��
			}
		}
		return accessToken;
	}

}