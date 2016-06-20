package com.bavlo.gemtak.model.gem;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bavlo.gemtak.model.IdEntity;

/**
 * @Title: ����Gemtak
 * @ClassName: GemVO 
 * @Description: ��ʯ����VO
 * @author liuzy
 * @date 2016-1-26 ����06:09:34
 */
@Entity
@Table(name="gt_gem")
public class GemVO extends IdEntity implements Serializable {

	private static final long serialVersionUID = 2183301910494622850L;

	//		����ID			
	private Integer equipment_id;
	//		��ʯ������GID��ͷ	
	private String gid;
	//		��ʯ����			�ӿ�
	private String type_id;
	private String type_cn;
	private String type_en;
	//		��ʯ��ɫ			
	private String color_id;
	private String color_cn;
	private String color_en;
	//�Ƿ��׼��״ �ǹ��
	private String isstand;
	//		��ʯ��״			�ӿ�
	private String shape_id;
	private String shape_cn;
	private String shape_en;
	//		�Զ�����״			����
	private String shape_str;
	//		���			�ӿ�(���в�������״ID)
	private String calibrated_id;
	//		�Զ�����			����
	private String size_l;
	private String size_w;
	private String size_h;
	//		��ʯ�й�			�ӿ�
	private String cut_id;
	private String cut_cn;
	private String cut_en;
	//		��ʯ����			�ӿ�
	private String clarity_id;
	private String clarity_cn;
	private String clarity_en;
	//		�ӽ�			
	private String viewpoint;
	//     ��ɫ��     Ĭ��Ϊ�Ǳ�ɫ��   1Ϊ�Ǳ�ɫ�� 2Ϊ��ɫ��
	private Integer lightType;
	//     ��ɫ
	private String average_color;
	//		��ʯ����			�ӿ�
	private String origin_id;
	private String origin_cn;
	private String origin_en;
	//		��ʯ����			�ӿ�
	private String treatment_id;
	private String treatment_cn;
	private String treatment_en;
	//		����			
	private String weight;
	//		�����			
	private Integer stock_qty;
	//		��̬			��������ԡ�����
	private String pairs;
	//		����			
	private Double purchase_price;
	//		���۵�λ			
	private String purchase_unit;
	//		������		
	private Double trade_price;
	//		�����۵�λ
	private String trade_unit;
	//		���ۼ�			
	private Double retail_price;
	//		���ۼ۵�λ			
	private String retail_unit;
	//		��ʯ֤������			�ӿ�
	private String lab_id;
	private String lab_cn;
	private String lab_en;
	//		֤����		
	private String lab_no;
	//		֤��URL			
	private String lab_url;
	//     �豸��
	private String vcode;
	//		���ң���Ӧ�̣�			΢����ҵ�����󶨵��˺�---��Ӧ�̱�ǩ
	private String supplier;
	//	    ���ұ��루��Ӧ�̣�			
	private String supplier_code;
	//      ��˾
	private String company;
	
	//      ���ҵ绰
	private String supplier_tel;
	//		��ַ			
	private String location;
	//		�ɼ���			������(A)���̼�(B)��ֻ�Լ�(M)
	private String power;
	//		��ʯ360���ļ��洢URL			
	private String url_360;
	//		����ͼ����		
	private String is_cover;
	//		�������			
	private Integer page_views;
	//		�Ƿ񷢲�			���ϴ���E�����ѷ�����Y�����ѹرգ�C��
	private String is_release;
	//		��������			
	private Timestamp createdate;
	//��������
	private Timestamp releasedate;
	
	public Integer getEquipment_id() {
		return equipment_id;
	}
	public void setEquipment_id(Integer equipment_id) {
		this.equipment_id = equipment_id;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public String getType_cn() {
		return type_cn;
	}
	public void setType_cn(String type_cn) {
		this.type_cn = type_cn;
	}
	public String getType_en() {
		return type_en;
	}
	public void setType_en(String type_en) {
		this.type_en = type_en;
	}
	public String getColor_id() {
		return color_id;
	}
	public void setColor_id(String color_id) {
		this.color_id = color_id;
	}
	public String getColor_cn() {
		return color_cn;
	}
	public void setColor_cn(String color_cn) {
		this.color_cn = color_cn;
	}
	public String getColor_en() {
		return color_en;
	}
	public void setColor_en(String color_en) {
		this.color_en = color_en;
	}
	public String getShape_id() {
		return shape_id;
	}
	public void setShape_id(String shape_id) {
		this.shape_id = shape_id;
	}
	public String getShape_cn() {
		return shape_cn;
	}
	public void setShape_cn(String shape_cn) {
		this.shape_cn = shape_cn;
	}
	public String getShape_en() {
		return shape_en;
	}
	public void setShape_en(String shape_en) {
		this.shape_en = shape_en;
	}
	public String getShape_str() {
		return shape_str;
	}
	public void setShape_str(String shape_str) {
		this.shape_str = shape_str;
	}
	public String getCalibrated_id() {
		return calibrated_id;
	}
	public void setCalibrated_id(String calibrated_id) {
		this.calibrated_id = calibrated_id;
	}
	
	
	public String getAverage_color() {
		return average_color;
	}
	public void setAverage_color(String average_color) {
		this.average_color = average_color;
	}
	public Integer getLightType() {
		return lightType;
	}
	public void setLightType(Integer lightType) {
		this.lightType = lightType;
	}
	public String getSize_l() {
		return size_l;
	}
	public void setSize_l(String size_l) {
		this.size_l = size_l;
	}
	public String getSize_w() {
		return size_w;
	}
	public void setSize_w(String size_w) {
		this.size_w = size_w;
	}
	public String getSize_h() {
		return size_h;
	}
	public void setSize_h(String size_h) {
		this.size_h = size_h;
	}
	public String getCut_id() {
		return cut_id;
	}
	public void setCut_id(String cut_id) {
		this.cut_id = cut_id;
	}
	public String getCut_cn() {
		return cut_cn;
	}
	public void setCut_cn(String cut_cn) {
		this.cut_cn = cut_cn;
	}
	public String getCut_en() {
		return cut_en;
	}
	public void setCut_en(String cut_en) {
		this.cut_en = cut_en;
	}
	public String getClarity_id() {
		return clarity_id;
	}
	public void setClarity_id(String clarity_id) {
		this.clarity_id = clarity_id;
	}
	public String getClarity_cn() {
		return clarity_cn;
	}
	public void setClarity_cn(String clarity_cn) {
		this.clarity_cn = clarity_cn;
	}
	public String getClarity_en() {
		return clarity_en;
	}
	public void setClarity_en(String clarity_en) {
		this.clarity_en = clarity_en;
	}
	public String getViewpoint() {
		return viewpoint;
	}
	public void setViewpoint(String viewpoint) {
		this.viewpoint = viewpoint;
	}
	
	public String getOrigin_id() {
		return origin_id;
	}
	public void setOrigin_id(String origin_id) {
		this.origin_id = origin_id;
	}
	public String getOrigin_cn() {
		return origin_cn;
	}
	public void setOrigin_cn(String origin_cn) {
		this.origin_cn = origin_cn;
	}
	public String getOrigin_en() {
		return origin_en;
	}
	public void setOrigin_en(String origin_en) {
		this.origin_en = origin_en;
	}
	public String getTreatment_id() {
		return treatment_id;
	}
	public void setTreatment_id(String treatment_id) {
		this.treatment_id = treatment_id;
	}
	public String getTreatment_cn() {
		return treatment_cn;
	}
	public void setTreatment_cn(String treatment_cn) {
		this.treatment_cn = treatment_cn;
	}
	public String getTreatment_en() {
		return treatment_en;
	}
	public void setTreatment_en(String treatment_en) {
		this.treatment_en = treatment_en;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public Integer getStock_qty() {
		return stock_qty;
	}
	public void setStock_qty(Integer stock_qty) {
		this.stock_qty = stock_qty;
	}
	public String getPairs() {
		return pairs;
	}
	public void setPairs(String pairs) {
		this.pairs = pairs;
	}
	public Double getPurchase_price() {
		return purchase_price;
	}
	public void setPurchase_price(Double purchase_price) {
		this.purchase_price = purchase_price;
	}
	public String getPurchase_unit() {
		return purchase_unit;
	}
	public void setPurchase_unit(String purchase_unit) {
		this.purchase_unit = purchase_unit;
	}
	public Double getTrade_price() {
		return trade_price;
	}
	public void setTrade_price(Double trade_price) {
		this.trade_price = trade_price;
	}
	public String getTrade_unit() {
		return trade_unit;
	}
	public void setTrade_unit(String trade_unit) {
		this.trade_unit = trade_unit;
	}
	public Double getRetail_price() {
		return retail_price;
	}
	public void setRetail_price(Double retail_price) {
		this.retail_price = retail_price;
	}
	public String getRetail_unit() {
		return retail_unit;
	}
	public void setRetail_unit(String retail_unit) {
		this.retail_unit = retail_unit;
	}
	public String getLab_id() {
		return lab_id;
	}
	public void setLab_id(String lab_id) {
		this.lab_id = lab_id;
	}
	public String getLab_cn() {
		return lab_cn;
	}
	public void setLab_cn(String lab_cn) {
		this.lab_cn = lab_cn;
	}
	public String getLab_en() {
		return lab_en;
	}
	public void setLab_en(String lab_en) {
		this.lab_en = lab_en;
	}
	public String getLab_no() {
		return lab_no;
	}
	public void setLab_no(String lab_no) {
		this.lab_no = lab_no;
	}
	public String getLab_url() {
		return lab_url;
	}
	public void setLab_url(String lab_url) {
		this.lab_url = lab_url;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getSupplier_code() {
		return supplier_code;
	}
	public void setSupplier_code(String supplier_code) {
		this.supplier_code = supplier_code;
	}
	public String getSupplier_tel() {
		return supplier_tel;
	}
	public void setSupplier_tel(String supplier_tel) {
		this.supplier_tel = supplier_tel;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getUrl_360() {
		return url_360;
	}
	public void setUrl_360(String url_360) {
		this.url_360 = url_360;
	}
	public String getIs_cover() {
		return is_cover;
	}
	public void setIs_cover(String is_cover) {
		this.is_cover = is_cover;
	}
	public Integer getPage_views() {
		return page_views;
	}
	public void setPage_views(Integer page_views) {
		this.page_views = page_views;
	}
	public String getIs_release() {
		return is_release;
	}
	public void setIs_release(String is_release) {
		this.is_release = is_release;
	}
	public Timestamp getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}
	public String getIsstand() {
		return isstand;
	}
	public void setIsstand(String isstand) {
		this.isstand = isstand;
	}
	public Timestamp getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(Timestamp releasedate) {
		this.releasedate = releasedate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getVcode() {
		return vcode;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	

}
