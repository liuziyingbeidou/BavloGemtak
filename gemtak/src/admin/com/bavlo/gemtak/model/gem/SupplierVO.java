package com.bavlo.gemtak.model.gem;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bavlo.gemtak.model.IdEntity;

/**
 * @Title: ����Gemtak
 * @ClassName: SupplierVO 
 * @Description: ��Ӧ��VO
 * @author liuzy
 * @date 2016-1-26 ����05:33:08
 */
@Entity
@Table(name="gt_supplier")
public class SupplierVO extends IdEntity implements Serializable {

	private static final long serialVersionUID = 5214128294269514226L;

	//	��Ӧ��userid
	private String userid;
	
	//	��������
	private Timestamp createdate;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}
	
}
