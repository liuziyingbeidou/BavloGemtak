package com.bavlo.gemtak.service.weixin.itf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

/**
 * @Title: ����Counter
 * @ClassName: ICoreService 
 * @Description: ΢����ҵ�� 
 * @author liuzy
 * @date 2015-12-9 ����02:48:48
 */
public interface ICoreService {

	public String processRequest(String msg,HttpSession session);
	/**
	 * @Description: ͨ����ɫ��ǩ��ȡ��Ա�б�
	 * @param @param tagName
	 * @param @return
	 * @return JSONArray
	 */
	public JSONArray getRoleListByTagName(HttpServletRequest request,String tagName);
	
}
