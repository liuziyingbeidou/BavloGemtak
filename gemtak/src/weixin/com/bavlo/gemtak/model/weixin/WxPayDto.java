package com.bavlo.gemtak.model.weixin;

/**
 * @Title: ����Gemtak
 * @ClassName: WxPayDto 
 * @Description: TODO(������һ�仰��������������) 
 * @author liuzy
 * @date 2016-3-17 ����10:18:01
 */
public class WxPayDto {

	private String orderId;//������
	private String totalFee;//���
	private String spbillCreateIp;//�������ɵĻ��� IP
	private String notifyUrl;//����notify_url�� ֧����ɺ�΢�ŷ�����������Ϣ�������жϻ�Ա�Ƿ�֧���ɹ����ı䶩��״̬��
	private String body;// ��Ʒ������������޸�
	private String openId;//΢���û���һ�����ں�Ψһ
	
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the totalFee
	 */
	public String getTotalFee() {
		return totalFee;
	}
	/**
	 * @param totalFee the totalFee to set
	 */
	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}
	/**
	 * @return the spbillCreateIp
	 */
	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}
	/**
	 * @param spbillCreateIp the spbillCreateIp to set
	 */
	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}
	/**
	 * @return the notifyUrl
	 */
	public String getNotifyUrl() {
		return notifyUrl;
	}
	/**
	 * @param notifyUrl the notifyUrl to set
	 */
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}
	/**
	 * @return the openId
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * @param openId the openId to set
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
}
