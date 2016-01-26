package com.bavlo.gemtak.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.bavlo.gemtak.utils.ReflectionUtils;

@MappedSuperclass
@SuppressWarnings({"serial"})
public class IdEntity implements Serializable{
	
	public static final String tablePrefix = "";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;
	
	public Integer getId() {
	
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Transient boolean selected = false;
	@Transient Object userValue;
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	@Transient	
	private Map<Object, Object> condmap;
 	
 	public void setAttribute(Object key,Object value){
		if(condmap==null)condmap=new HashMap<Object,Object>();
		condmap.put(key, value);
	}
	
    public Object getAttribute(Object key){
    	if(condmap==null)condmap=new HashMap<Object,Object>();
    	return condmap.get(key);
    }
    
    /**
	 * @return the condmap
	 */
	public Map<Object, Object> getCondmap() {
		return condmap;
	}
	/**
	 * @param condmap the condmap to set
	 */
	public void setCondmap(Map<Object, Object> condmap) {
		this.condmap = condmap;
	}
	
	
	public boolean equals(Object object) {
		if (null == object)
			return false;
		if (!(object.getClass().getName().toString().equals(this.getClass().getName().toString())))
			return false;
		else {
			Integer object_id = (Integer) ReflectionUtils.getFieldValue(object,
					"id");
			if (null == this.getId() || null == object_id)
				return false;
			else
				return (this.getId().intValue() == object_id.intValue());
		}
	}
	@Transient
	public int hashCode = Integer.MIN_VALUE;

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

	public Object getUserValue() {
		return userValue;
	}

	public void setUserValue(Object userValue) {
		this.userValue = userValue;
	}
	
	/**
	 * 以下是补充
	 */
	/**
	 * 时间戳		timestamp	
	 */
	private Timestamp ts;
	/**
	 * dr		smallint	删除(1);未删除(0);默认值:0
	 */
	@Column(columnDefinition="smallint default 0")
	private Short dr;
	/**
	 * 	自定义项		varchar(255)	
	 */
	private String vdef1;
	private String vdef2;
	private String vdef3;
	private String vdef4;
	private String vdef5;
	/**
	 * 自定义项		decimal(20,8)	
	 */
	@Column(precision=20,scale=8)
	private Double vdef6;
	@Column(precision=20,scale=8)
	private Double vdef7;
	@Column(precision=20,scale=8)
	private Double vdef8;
	@Column(precision=20,scale=8)
	private Double vdef9;
	@Column(precision=20,scale=8)
	private Double vdef10;
	/**
	 * 预留字段		varchar(255)	
	 */
	private String vreserve1;
	private String vreserve2;
	private String vreserve3;
	private String vreserve4;
	private String vreserve5;
	/**
	 * 备注		varchar(255)	
	 */
	private String vmemo;
	
	//上传图片
	@Transient
	private String FILE_0;
	@Transient
	private String FILE_1;
	@Transient
	private String FILE_2;
	@Transient
	private String FILE_3;
	@Transient
	private String FILE_4;
	@Transient
	private String FILE_5;
	@Transient
	private String FILE_6;
	@Transient
	private String FILE_7;
	@Transient
	private String FILE_8;

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

	public Short getDr() {
		return dr;
	}

	public void setDr(Short dr) {
		this.dr = dr;
	}

	public String getVdef1() {
		return vdef1;
	}

	public void setVdef1(String vdef1) {
		this.vdef1 = vdef1;
	}

	public String getVdef2() {
		return vdef2;
	}

	public void setVdef2(String vdef2) {
		this.vdef2 = vdef2;
	}

	public String getVdef3() {
		return vdef3;
	}

	public void setVdef3(String vdef3) {
		this.vdef3 = vdef3;
	}

	public String getVdef4() {
		return vdef4;
	}

	public void setVdef4(String vdef4) {
		this.vdef4 = vdef4;
	}

	public String getVdef5() {
		return vdef5;
	}

	public void setVdef5(String vdef5) {
		this.vdef5 = vdef5;
	}

	public Double getVdef6() {
		return vdef6;
	}

	public void setVdef6(Double vdef6) {
		this.vdef6 = vdef6;
	}

	public Double getVdef7() {
		return vdef7;
	}

	public void setVdef7(Double vdef7) {
		this.vdef7 = vdef7;
	}

	public Double getVdef8() {
		return vdef8;
	}

	public void setVdef8(Double vdef8) {
		this.vdef8 = vdef8;
	}

	public Double getVdef9() {
		return vdef9;
	}

	public void setVdef9(Double vdef9) {
		this.vdef9 = vdef9;
	}

	public Double getVdef10() {
		return vdef10;
	}

	public void setVdef10(Double vdef10) {
		this.vdef10 = vdef10;
	}

	public String getVreserve1() {
		return vreserve1;
	}

	public void setVreserve1(String vreserve1) {
		this.vreserve1 = vreserve1;
	}

	public String getVreserve2() {
		return vreserve2;
	}

	public void setVreserve2(String vreserve2) {
		this.vreserve2 = vreserve2;
	}

	public String getVreserve3() {
		return vreserve3;
	}

	public void setVreserve3(String vreserve3) {
		this.vreserve3 = vreserve3;
	}

	public String getVreserve4() {
		return vreserve4;
	}

	public void setVreserve4(String vreserve4) {
		this.vreserve4 = vreserve4;
	}

	public String getVreserve5() {
		return vreserve5;
	}

	public void setVreserve5(String vreserve5) {
		this.vreserve5 = vreserve5;
	}

	public String getVmemo() {
		return vmemo;
	}

	public void setVmemo(String vmemo) {
		this.vmemo = vmemo;
	}

	public String getFILE_0() {
		return FILE_0;
	}

	public void setFILE_0(String fILE_0) {
		FILE_0 = fILE_0;
	}

	public String getFILE_1() {
		return FILE_1;
	}

	public void setFILE_1(String fILE_1) {
		FILE_1 = fILE_1;
	}

	public String getFILE_2() {
		return FILE_2;
	}

	public void setFILE_2(String fILE_2) {
		FILE_2 = fILE_2;
	}

	public String getFILE_3() {
		return FILE_3;
	}

	public void setFILE_3(String fILE_3) {
		FILE_3 = fILE_3;
	}

	public String getFILE_4() {
		return FILE_4;
	}

	public void setFILE_4(String fILE_4) {
		FILE_4 = fILE_4;
	}

	public String getFILE_5() {
		return FILE_5;
	}

	public void setFILE_5(String fILE_5) {
		FILE_5 = fILE_5;
	}

	public String getFILE_6() {
		return FILE_6;
	}

	public void setFILE_6(String fILE_6) {
		FILE_6 = fILE_6;
	}

	public String getFILE_7() {
		return FILE_7;
	}

	public void setFILE_7(String fILE_7) {
		FILE_7 = fILE_7;
	}

	public String getFILE_8() {
		return FILE_8;
	}

	public void setFILE_8(String fILE_8) {
		FILE_8 = fILE_8;
	}
	
}
