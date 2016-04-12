package com.bavlo.gemtak.model.ui;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bavlo.gemtak.model.IdEntity;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: OrderVO 
 * @Description: 订单主表
 * @author lisuike
 * @date 2016-4-8 下午14:54:22
 */
@Entity
@Table(name="gt_order")
public class OrderVO extends IdEntity {

	private static final long serialVersionUID = 6114467828526147643L;
	
	//手机
	private String cellphone;
	
	private Timestamp complete_date;
	//优惠劵
	private String coupon;
	//优惠劵金额
	private Double coupon_fee;
	//创建日期
	private Timestamp created;
	
	//保价金额
	private Double support_fee;
	private Timestamp delivery_date;
	//邮箱
	private String email;
	private Double insure_fee;
	//是否开发票
	private String invoice;
	//发票抬头
	private String invoice_title;
	//发票内容
	private String invoice_content;
	//邮寄地址
	private String mail_address;
	private Timestamp manufacture_date;
	//订单信息
	private String order_message;
	//订单号
	private String order_no;
	//交付日期
	private Timestamp pay_date;
	
	private String proccess_comments;
	private String progress;
	//真实姓名
	private String real_name;
	private String send_email;
	private String settle_accounts_status;
	private String settle_accounts_type;
	//发货日期
	private Timestamp shipping_date;
	//快递费
	private Double shipping_fee;
	//快递单号
	private String shipping_no; 
	//订单状态
	private String status;
	//座机
	private String tel;
	//版本
	private Integer version;
	//邮编
	private String zipcode;
	private Integer agent_id;
	private Integer code_id;
	//用户id
	private Integer customer_id;
	private Integer invoice_id;
	private Integer logistic_id;
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public Timestamp getComplete_date() {
		return complete_date;
	}
	public void setComplete_date(Timestamp complete_date) {
		this.complete_date = complete_date;
	}
	public Double getCoupon_fee() {
		return coupon_fee;
	}
	public void setCoupon_fee(Double coupon_fee) {
		this.coupon_fee = coupon_fee;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Timestamp getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(Timestamp delivery_date) {
		this.delivery_date = delivery_date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getInsure_fee() {
		return insure_fee;
	}
	public void setInsure_fee(Double insure_fee) {
		this.insure_fee = insure_fee;
	}
	public String getMail_address() {
		return mail_address;
	}
	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}
	public Timestamp getManufacture_date() {
		return manufacture_date;
	}
	public void setManufacture_date(Timestamp manufacture_date) {
		this.manufacture_date = manufacture_date;
	}
	public String getOrder_message() {
		return order_message;
	}
	public void setOrder_message(String order_message) {
		this.order_message = order_message;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public Timestamp getPay_date() {
		return pay_date;
	}
	public void setPay_date(Timestamp pay_date) {
		this.pay_date = pay_date;
	}
	public String getProccess_comments() {
		return proccess_comments;
	}
	public void setProccess_comments(String proccess_comments) {
		this.proccess_comments = proccess_comments;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getSend_email() {
		return send_email;
	}
	public void setSend_email(String send_email) {
		this.send_email = send_email;
	}
	public String getSettle_accounts_status() {
		return settle_accounts_status;
	}
	public void setSettle_accounts_status(String settle_accounts_status) {
		this.settle_accounts_status = settle_accounts_status;
	}
	public String getSettle_accounts_type() {
		return settle_accounts_type;
	}
	public void setSettle_accounts_type(String settle_accounts_type) {
		this.settle_accounts_type = settle_accounts_type;
	}
	public Timestamp getShipping_date() {
		return shipping_date;
	}
	public void setShipping_date(Timestamp shipping_date) {
		this.shipping_date = shipping_date;
	}
	public Double getShipping_fee() {
		return shipping_fee;
	}
	public void setShipping_fee(Double shipping_fee) {
		this.shipping_fee = shipping_fee;
	}
	public String getShipping_no() {
		return shipping_no;
	}
	public void setShipping_no(String shipping_no) {
		this.shipping_no = shipping_no;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Integer getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(Integer agent_id) {
		this.agent_id = agent_id;
	}
	public Integer getCode_id() {
		return code_id;
	}
	public void setCode_id(Integer code_id) {
		this.code_id = code_id;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public Integer getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(Integer invoice_id) {
		this.invoice_id = invoice_id;
	}
	public Integer getLogistic_id() {
		return logistic_id;
	}
	public void setLogistic_id(Integer logistic_id) {
		this.logistic_id = logistic_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Double getSupport_fee() {
		return support_fee;
	}
	public void setSupport_fee(Double support_fee) {
		this.support_fee = support_fee;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public String getInvoice_title() {
		return invoice_title;
	}
	public void setInvoice_title(String invoice_title) {
		this.invoice_title = invoice_title;
	}
	public String getInvoice_content() {
		return invoice_content;
	}
	public void setInvoice_content(String invoice_content) {
		this.invoice_content = invoice_content;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	
}
