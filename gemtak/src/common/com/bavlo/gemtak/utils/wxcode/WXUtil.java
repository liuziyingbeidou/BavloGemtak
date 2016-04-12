package com.bavlo.gemtak.utils.wxcode;
/**
 * 微信接口工具类
 * @author Administrator
 *
 */
public class WXUtil {
	
	public static final String getBoolean(String sessionKey){
		try {
			if("Y".equalsIgnoreCase(FrontWXManager.getInstance().getBoolean(sessionKey))){
				return "Y";
			}else{
				return "N";
			}
		} catch (Exception e) {
			return "YN";
		}
		
	}
	public static final void setBoolean(String sessionKey,String boo){
		FrontWXManager.getInstance().addBoolean(sessionKey, boo);
	}
	public static final void removeboolean(String sessionKey){
		FrontWXManager.getInstance().removeUser(sessionKey);
	}
}
