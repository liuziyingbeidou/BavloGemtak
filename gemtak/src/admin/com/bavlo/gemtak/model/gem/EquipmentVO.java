package com.bavlo.gemtak.model.gem;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bavlo.gemtak.model.IdEntity;

@Entity
@Table(name="gt_equipment")
public class EquipmentVO extends IdEntity {

	private static final long serialVersionUID = -5779870299691542352L;

	
	//  供应商
	private String vsupplierName;
	//  供应商编号
	private String vsupplierCode;
	//  公司
	private String company;
    // 	卖家（供应商）			微信企业号所绑定的账号---供应商标签
	private String supplier;
	//  微信号
	private String wxcode;
	//  QQ
	private String qq;
	//  手机
	private Integer phone;
	//   座机
	private String tel;
	//   地址
	private String address;
	//    开户人
	private String account_holder;
	//    开户行
	private String deposit_bank;
	//    卡号
	private String card_no;
	//    邮编
	private String post;
	//  是否关闭(N,Y)
	private String bisClose;
	//  创建日期
	private Timestamp createdate;
	
	
	public String getVsupplierName() {
		return vsupplierName;
	}
	public void setVsupplierName(String vsupplierName) {
		this.vsupplierName = vsupplierName;
	}
	public String getVsupplierCode() {
		return vsupplierCode;
	}
	public void setVsupplierCode(String vsupplierCode) {
		this.vsupplierCode = vsupplierCode;
	}
	public String getBisClose() {
		return bisClose;
	}
	public void setBisClose(String bisClose) {
		this.bisClose = bisClose;
	}
	public Timestamp getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccount_holder() {
		return account_holder;
	}
	public void setAccount_holder(String account_holder) {
		this.account_holder = account_holder;
	}
	public String getDeposit_bank() {
		return deposit_bank;
	}
	public void setDeposit_bank(String deposit_bank) {
		this.deposit_bank = deposit_bank;
	}
	public String getCard_no() {
		return card_no;
	}
	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getWxcode() {
		return wxcode;
	}
	public void setWxcode(String wxcode) {
		this.wxcode = wxcode;
	}
	
}
