package com.bavlo.gemtak.model.gem;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bavlo.gemtak.model.IdEntity;

/**
 * 
 * @Title :����Gemtak
 * @ClassName :LinkmanVO
 * @Description :��Ӧ����ϵ��VO
 * @author lsk
 * @date :
 */
@Entity
@Table(name="gt_linkman")
public class LinkmanVO extends IdEntity{
        
	private static final long serialVersionUID = 3453053583850358641L;
		//  ��ϵ������
	    private String lname;
	    // 	��ҵ���˺�
		private String supplier;
		//  ����΢�ź�
		private String wxcode;
		//  ����
		private String email;
		//  QQ
		private String qq;
		//  �ֻ�
		private Integer phone;
		//   ����
		private String tel;
		//   ��ַ
		private String address;
		//    �ʱ�
		private String post;
		//   ������˾
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
