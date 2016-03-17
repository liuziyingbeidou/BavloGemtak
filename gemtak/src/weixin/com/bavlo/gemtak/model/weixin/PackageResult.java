package com.bavlo.gemtak.model.weixin;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: PackageResult 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author liuzy
 * @date 2016-3-17 上午10:17:53
 */
public class PackageResult {
	private String appId;
	private String timeStamp;//验证后的签名
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
