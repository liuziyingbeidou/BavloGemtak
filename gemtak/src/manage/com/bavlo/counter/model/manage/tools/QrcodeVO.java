package com.bavlo.counter.model.manage.tools;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bavlo.counter.model.IdEntity;

/**
 * @Title: ����Counter
 * @ClassName: QrcodeVO 
 * @Description: �ͷ���ά��
 * @author liuzy
 * @date 2015-12-7 ����04:04:18
 */
@Entity
@Table(name="blct_qrcode")
public class QrcodeVO extends IdEntity {

	private static final long serialVersionUID = 1L;
	//�ͷ�����
	private String vkfcode;
	//��Ӧuserid
	private String userid;
	//�ŵ�
	private String vshop;
	//ͷ��Url
	private String vqrcodeUrl;
	
	public String getVkfcode() {
		return vkfcode;
	}
	public void setVkfcode(String vkfcode) {
		this.vkfcode = vkfcode;
	}
	public String getVshop() {
		return vshop;
	}
	public void setVshop(String vshop) {
		this.vshop = vshop;
	}
	public String getVqrcodeUrl() {
		return vqrcodeUrl;
	}
	public void setVqrcodeUrl(String vqrcodeUrl) {
		this.vqrcodeUrl = vqrcodeUrl;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
}
