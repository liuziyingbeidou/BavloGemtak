package com.bavlo.gemtak.model.gem;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bavlo.gemtak.model.IdEntity;

/**
 * 
 * @Title :����Gemtak
 * @ClassName :EquipmentVO
 * @Description :��Ӧ��
 * @author lsk
 * @date 2016-9-2����11:37:05
 */
@Entity
@Table(name="gt_equipment")
public class EquipmentVO extends IdEntity {

	private static final long serialVersionUID = -5779870299691542352L;

	
	//  Ʒ��
	private String vsupplierName;
/*	//  ��Ӧ�̱��
	private String vsupplierCode;*/
	//  ��˾ȫ��
	private String company;
	//    ����
	private String card_no;
	//    ������
	private String deposit_bank;
	//    ����
	private String account_holder;
	//  �Ƿ�ر�(N,Y)
	private String bisClose;
	//  ��������
	private Timestamp createdate;
	//   ��˾��ַ
	private String address;
	

	
/*--------------------------------------------------------------------------------*/
	public String getVsupplierName() {
		return vsupplierName;
	}
	public void setVsupplierName(String vsupplierName) {
		this.vsupplierName = vsupplierName;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
