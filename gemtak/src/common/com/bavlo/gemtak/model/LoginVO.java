package com.bavlo.gemtak.model;

import java.util.List;

/**
 * @Title: 宝珑Counter
 * @ClassName: LoginVO 
 * @Description: 存储登录信息
 * @author liuzy
 * @date 2015-11-19 下午10:30:44
 */
public class LoginVO {

	//登录用户userid
	private String userId;
	//用户名
	private String uname;
	//主用户userid
	private String muserId;
	//角色
	private List<String> role;
	//店名{key-value}
	private String shop;
	//主微信号
	private String mwxcode;
	//客服工号
	private String kfcode;
	//设备号
	private String ecode;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
	}
	public String getMwxcode() {
		return mwxcode;
	}
	public void setMwxcode(String mwxcode) {
		this.mwxcode = mwxcode;
	}
	public List<String> getRole() {
		return role;
	}
	public void setRole(List<String> role) {
		this.role = role;
	}
	public String getMuserId() {
		return muserId;
	}
	public void setMuserId(String muserId) {
		this.muserId = muserId;
	}
	public String getKfcode() {
		return kfcode;
	}
	public void setKfcode(String kfcode) {
		this.kfcode = kfcode;
	}
	public String getEcode() {
		return ecode;
	}
	public void setEcode(String ecode) {
		this.ecode = ecode;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
}
