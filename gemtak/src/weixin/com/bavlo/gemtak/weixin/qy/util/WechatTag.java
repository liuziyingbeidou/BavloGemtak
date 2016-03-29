package com.bavlo.gemtak.weixin.qy.util;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import com.bavlo.gemtak.weixin.qy.enums.EnumMethod;
import com.bavlo.gemtak.weixin.qy.pojo.AccessToken;

public class WechatTag {
	
	private static final String get_Tag_url = "https://qyapi.weixin.qq.com/cgi-bin/tag/list?access_token=ACCESS_TOKEN";
	
	private static final String get_TagUser_url = "https://qyapi.weixin.qq.com/cgi-bin/tag/get?access_token=ACCESS_TOKEN&tagid=TAGID";
	
	/**
	 * 根据ACCESS_TOKEN获取标签列表
	 * @return
	 */
	public static JSONObject getTagList(HttpServletRequest request) {
		AccessToken accessToken = QiYeUtil.getAccessToken(request,Constants.CORPID, Constants.SECRET);
		String TegUrl = get_Tag_url.replace("ACCESS_TOKEN", accessToken.getToken());
		JSONObject jo = HttpRequestUtil.httpRequest(TegUrl, EnumMethod.GET.name(), null);
		return jo;
	}
	
	/**
	 * 根据tagid获取成员列表
	 * @param tagid
	 * @return
	 */
	public static JSONObject getUserList(HttpServletRequest request,int tagid) {
		AccessToken accessToken = QiYeUtil.getAccessToken(request,Constants.CORPID, Constants.SECRET);
		String TegUserUrl = get_TagUser_url.replace("ACCESS_TOKEN", accessToken.getToken()).replace("TAGID", tagid + "");
		JSONObject jo = HttpRequestUtil.httpRequest(TegUserUrl, EnumMethod.GET.name(), null);
		return jo;
	}
	
}
