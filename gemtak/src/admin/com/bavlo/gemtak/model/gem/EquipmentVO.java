package com.bavlo.gemtak.model.gem;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bavlo.gemtak.model.IdEntity;

@Entity
@Table(name="gt_equipment")
public class EquipmentVO extends IdEntity {

	private static final long serialVersionUID = -5779870299691542352L;

	//设备号
	private String vcode;
	//供货商
	private String vsupplierName;
	//供货商编号
	private String vsupplierCode;
	//是否关闭(N,Y)
	private String bisClose;
	//创建日期
	private Timestamp createdate;
	
	public String getVcode() {
		return vcode;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
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
	
}
