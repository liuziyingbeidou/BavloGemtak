package com.bavlo.gemtak.service.weixin.itf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

/**
 * @Title: 宝珑Counter
 * @ClassName: ICoreService 
 * @Description: 微信企业号 
 * @author liuzy
 * @date 2015-12-9 下午02:48:48
 */
public interface ICoreService {

	public String processRequest(String msg,HttpSession session);
	/**
	 * @Description: 通过角色标签获取成员列表
	 * @param @param tagName
	 * @param @return
	 * @return JSONArray
	 */
	public JSONArray getRoleListByTagName(HttpServletRequest request,String tagName);
	
}
