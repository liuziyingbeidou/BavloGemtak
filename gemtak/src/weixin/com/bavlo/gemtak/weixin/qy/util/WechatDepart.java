package com.bavlo.gemtak.weixin.qy.util;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import com.bavlo.gemtak.weixin.qy.enums.EnumMethod;
import com.bavlo.gemtak.weixin.qy.pojo.AccessToken;

/**
 * @Title: ����Counter
 * @ClassName: WechatDepart 
 * @Description: ���Ź�����ؽӿ�ʵ��
 * @author liuzy
 * @date 2015-11-18 ����05:25:16
 */
public class WechatDepart {
	
	//��ȡ���ų�Ա
	private static final String get_DepartUser_url = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&userid=USERID";
	//��ȡ�����б�
	private static final String get_DepartById_url = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=ACCESS_TOKEN&id=ID";
	
	/**
	 * ����userId��ȡ��Ա��ϸ��Ϣ
	 * ��������ӵ��ָ����Ա�Ĳ鿴Ȩ��
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
	 * ���ݲ���id��ȡָ�����ż����µ��Ӳ���
	 * ��������ӵ��ָ�����ŵĲ鿴Ȩ�ޡ�
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
