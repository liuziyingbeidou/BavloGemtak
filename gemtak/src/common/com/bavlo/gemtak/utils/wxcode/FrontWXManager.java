package com.bavlo.gemtak.utils.wxcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * ΢��ɨһɨ��½����
 * ��booleanΪN��ʱ�� δɨ��  ΪY��ʱ��  ��ɨ��
 * @author Administrator
 *
 */


public class FrontWXManager {
	private static FrontWXManager instance = new FrontWXManager();
	
	private FrontWXManager(){}
	
	public static FrontWXManager getInstance(){
		return instance;
	}
	private Map<String,String> map = new HashMap<String, String>();
	
	/**
	 * 
	 * @param sessionId
	 * @param client
	 */
	public void addBoolean(String sessionId,String client){
		map.put(sessionId, client);
	}
	/**
	 * sessionId
	 */
	public void removeUser(String sessionId){
		map.remove(sessionId);
	}
	/**
	 * 
	 * @param sessionId
	 * @return
	 */
	public String getBoolean(String sessionId){
		return map.get(sessionId);
	}
	/**
	 * 
	 * @return
	 */
	public Collection<String> getAllClient(){
		return map.values();
	}
}
