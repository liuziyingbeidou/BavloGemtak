package com.bavlo.gemtak.model.weixin;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: ����Gemtak
 * @ClassName: PackageResult 
 * @Description: TODO(������һ�仰��������������) 
 * @author liuzy
 * @date 2016-3-17 ����10:17:53
 */
public class PackageResult {
	private String appId;
	private String timeStamp;//��֤���ǩ��
	private String nonceStr;
	private String packageurl;
	private String signType;
	private String paySign;
	private Map<String,String> map=new HashMap<String,String>();
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getPackageurl() {
		return packageurl;
	}
	public void setPackageurl(String packageurl) {
		this.packageurl = packageurl;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public String getPaySign() {
		return paySign;
	}
	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	
}
