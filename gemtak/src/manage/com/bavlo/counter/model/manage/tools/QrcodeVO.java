package com.bavlo.counter.model.manage.tools;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bavlo.counter.model.IdEntity;

/**
 * @Title: 宝珑Counter
 * @ClassName: QrcodeVO 
 * @Description: 客服二维码
 * @author liuzy
 * @date 2015-12-7 下午04:04:18
 */
@Entity
@Table(name="blct_qrcode")
public class QrcodeVO extends IdEntity {

	private static final long serialVersionUID = 1L;
	//客服工号
	private String vkfcode;
	//对应userid
	private String userid;
	//门店
	private String vshop;
	//头像Url
	private String vqrcodeUrl;
	
	public String getVkfcode() {
		return vkfcode;
	}
	public void setVkfcode(String vkfcode) {
		this.vkfcode = vkfcode;
	}
	public String getVshop() {
		return vshop;
	}
	public void setVshop(String vshop) {
		this.vshop = vshop;
	}
	public String getVqrcodeUrl() {
		return vqrcodeUrl;
	}
	public void setVqrcodeUrl(String vqrcodeUrl) {
		this.vqrcodeUrl = vqrcodeUrl;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
}
