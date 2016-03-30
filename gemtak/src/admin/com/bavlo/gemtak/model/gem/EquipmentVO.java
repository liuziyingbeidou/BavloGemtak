package com.bavlo.gemtak.model.gem;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bavlo.gemtak.model.IdEntity;

@Entity
@Table(name="gt_equipment")
public class EquipmentVO extends IdEntity {

	private static final long serialVersionUID = -5779870299691542352L;

	//�豸��
	private String vcode;
	//������
	private String vsupplierName;
	//�����̱��
	private String vsupplierCode;
	//�Ƿ�ر�(N,Y)
	private String bisClose;
	//��������
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
