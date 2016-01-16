package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.bavlo.counter.model.IdEntity;

/**
 * @author shijf
 *  客户信息实体类
 * 
 */
@Entity
public class CustomerVO extends IdEntity implements Serializable{

	private static final long serialVersionUID = -8245498015501333348L;
	/** 
	 * 加盟店ID 
	 */ 
	@Column(length=200)
	private String agentId;
	/** 
	 * 客服编号
	 */ 
	@Column(length=50)
	private String vserviceCode;
	/** 
	 * 客户编号 
	 */ 
	@Column(length=50)
	private String vcustomerCode;
	/** 
	 * 客户姓名 
	 */ 
	@Column(length=50)
	private String vname;
	/** 
	 * 客户昵称
	 */ 
	@Column(length=50)
	private String vnickname;
	/** 
	 * 客户性别 
	 */ 
	@Column(length=50)
	private String vsex;
	/** 
	 * 客户手机号
	 */ 
	private Long vphoneCode;
	/** 
	 * 地址：国家 
	 */ 
	@Column(length=50)
	private String vcontry;
	/** 
	 * 地址：省份
	 */ 
	@Column(length=50)
	private String vprovince;
	/** 
	 * 地址：城市 
	 */ 
	@Column(length=50)
	private String vcity;
	/** 
	 * 地址：县区 
	 */ 
	@Column(length=50)
	private String vdistrict;
	/** 
	 * 地址：街道
	 */ 
	@Column(length=150)
	private String vstreet;
	/** 
	 * 地址：邮编 
	 */ 
	private Long vzipcode;
	/** 
	 * 客户邮箱 
	 */ 
	@Column(length=50)
	private String vemail;
	/** 
	 * 客户微信号
	 */ 
	@Column(length=50)
	private String vwechat;
	/** 
	 * 客户的openid
	 */ 
	@Column(length=100)
	private String vopenid;
	/** 
	 * 客户语言 
	 */ 
	@Column(length=50)
	private String vlanguage;
	/** 
	 * 客户分组
	 */ 
	@Column(length=50)
	private String vgroup;
	/** 
	 * 客户头像地址 
	 */ 
	@Column(length=255)
	private String vhendimgurl;
	/** 
	 * 客户关注时间
	 */ 
	@Column(length=50)
	private String vsubscribeTime;
	//关注状态
	private Integer vsubscribeState;
	
	/**
	 * 转发与过的userid
	 */
	private String toUserids;

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getVserviceCode() {
		return vserviceCode;
	}

	public void setVserviceCode(String vserviceCode) {
		this.vserviceCode = vserviceCode;
	}
	
	public String getVcustomerCode() {
		return vcustomerCode;
	}
	
	public void setVcustomerCode(String vcustomerCode) {
		this.vcustomerCode = vcustomerCode;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getVnickname() {
		return vnickname;
	}

	public void setVnickname(String vnickname) {
		this.vnickname = vnickname;
	}

	public String getVsex() {
		return vsex;
	}

	public void setVsex(String vsex) {
		this.vsex = vsex;
	}

	public Long getVphoneCode() {
		return vphoneCode;
	}

	public void setVphoneCode(Long vphoneCode) {
		this.vphoneCode = vphoneCode;
	}

	public String getVcontry() {
		return vcontry;
	}

	public void setVcontry(String vcontry) {
		this.vcontry = vcontry;
	}

	public String getVprovince() {
		return vprovince;
	}

	public void setVprovince(String vprovince) {
		this.vprovince = vprovince;
	}

	public String getVcity() {
		return vcity;
	}

	public void setVcity(String vcity) {
		this.vcity = vcity;
	}

	public String getVdistrict() {
		return vdistrict;
	}

	public void setVdistrict(String vdistrict) {
		this.vdistrict = vdistrict;
	}

	public String getVstreet() {
		return vstreet;
	}

	public void setVstreet(String vstreet) {
		this.vstreet = vstreet;
	}

	public Long getVzipcode() {
		return vzipcode;
	}

	public void setVzipcode(Long vzipcode) {
		this.vzipcode = vzipcode;
	}

	public String getVemail() {
		return vemail;
	}

	public void setVemail(String vemail) {
		this.vemail = vemail;
	}

	public String getVwechat() {
		return vwechat;
	}

	public void setVwechat(String vwechat) {
		this.vwechat = vwechat;
	}

	public String getVopenid() {
		return vopenid;
	}

	public void setVopenid(String vopenid) {
		this.vopenid = vopenid;
	}

	public String getVlanguage() {
		return vlanguage;
	}

	public void setVlanguage(String vlanguage) {
		this.vlanguage = vlanguage;
	}

	public String getVhendimgurl() {
		return vhendimgurl;
	}

	public void setVhendimgurl(String vhendimgurl) {
		this.vhendimgurl = vhendimgurl;
	}

	public String getVsubscribeTime() {
		return vsubscribeTime;
	}

	public void setVsubscribeTime(String vsubscribeTime) {
		this.vsubscribeTime = vsubscribeTime;
	}

	public void setVgroup(String vgroup) {
		this.vgroup = vgroup;
	}

	public String getVgroup() {
		return vgroup;
	}

	public Integer getVsubscribeState() {
		return vsubscribeState;
	}

	public void setVsubscribeState(Integer vsubscribeState) {
		this.vsubscribeState = vsubscribeState;
	}

	public String getToUserids() {
		return toUserids;
	}

	public void setToUserids(String toUserids) {
		this.toUserids = toUserids;
	}

}
