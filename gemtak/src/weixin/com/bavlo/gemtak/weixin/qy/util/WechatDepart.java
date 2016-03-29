package com.bavlo.gemtak.weixin.qy.util;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import com.bavlo.gemtak.weixin.qy.enums.EnumMethod;
import com.bavlo.gemtak.weixin.qy.pojo.AccessToken;

/**
 * @Title: 宝珑Counter
 * @ClassName: WechatDepart 
 * @Description: 部门管理相关接口实现
 * @author liuzy
 * @date 2015-11-18 下午05:25:16
 */
public class WechatDepart {
	
	//获取部门成员
	private static final String get_DepartUser_url = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&userid=USERID";
	//获取部门列表
	private static final String get_DepartById_url = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=ACCESS_TOKEN&id=ID";
	
	/**
	 * 根据userId获取成员详细信息
	 * 管理组须拥有指定成员的查看权限
	 * @param userId
	 * @return
	 */
	public static JSONObject getUserInfo(HttpServletRequest request,String userId) {
		AccessToken accessToken = QiYeUtil.getAccessToken(request,Constants.CORPID, Constants.SECRET);
		String TegUserUrl = get_DepartUser_url.replace("ACCESS_TOKEN", accessToken.getToken()).replace("USERID", userId + "");
		JSONObject jo = HttpRequestUtil.httpRequest(TegUserUrl, EnumMethod.GET.name(), null);
		return jo;
	}
	/**
	 * 根据部门id获取指定部门及其下的子部门
	 * 管理组须拥有指定部门的查看权限。
	 * @param userId
	 * @return
	 */
	public static JSONObject getDepartInfo(HttpServletRequest request,String id) {
		AccessToken accessToken = QiYeUtil.getAccessToken(request,Constants.CORPID, Constants.SECRET);
		String TegDepartUrl = get_DepartById_url.replace("ACCESS_TOKEN", accessToken.getToken()).replace("ID", id + "");
		JSONObject jo = HttpRequestUtil.httpRequest(TegDepartUrl, EnumMethod.GET.name(), null);
		return jo;
	}
}
