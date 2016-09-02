package com.bavlo.gemtak.model.gem;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bavlo.gemtak.model.IdEntity;

/**
 * 
 * @Title :宝珑Gemtak
 * @ClassName :LinkmanVO
 * @Description :供应商联系人VO
 * @author lsk
 * @date :
 */
@Entity
@Table(name="gt_linkman")
public class LinkmanVO extends IdEntity{
        
	private static final long serialVersionUID = 3453053583850358641L;
		//  联系人姓名
	    private String lname;
	    // 	企业号账号
		private String supplier;
		//  个人微信号
		private String wxcode;
		//  邮箱
		private String email;
		//  QQ
		private String qq;
		//  手机
		private Integer phone;
		//   座机
		private String tel;
		//   地址
		private String address;
		//    邮编
		private String post;
		//   所属公司
		private Integer equipmentId;
		

		
/*--------------------------------------------------------------------------------*/
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		public String getSupplier() {
			return supplier;
		}
		public void setSupplier(String supplier) {
			this.supplier = supplier;
		}
		public String getWxcode() {
			return wxcode;
		}
		public void setWxcode(String wxcode) {
			this.wxcode = wxcode;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
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
		public String getPost() {
			return post;
		}
		public void setPost(String post) {
			this.post = post;
		}
		public Integer getEquipmentId() {
			return equipmentId;
		}
		public void setEquipmentId(Integer equipmentId) {
			this.equipmentId = equipmentId;
		}
		
		
}
