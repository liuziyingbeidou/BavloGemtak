package com.bavlo.gemtak.model.ui;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bavlo.gemtak.model.IdEntity;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: GetOrderVO 
 * @Description: 订单从表
 * @author Lisuike
 * @date 2016-4-8 下午14:54:22
 */
@Entity
@Table(name="gt_order_b")
public class OrderBVO extends IdEntity {
	
	//数量
	private Integer quantity;
	//版本
	private Integer version;
	
	private Integer design_id;
	private Integer diy_style_id;
	//宝石id
	private Integer gem_id;
	//宝石单价
	private Double price;
	//主表主键
	private Integer order_id;
	private String commentary_status;
	private Integer diamond_id;
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getDesign_id() {
		return design_id;
	}
	public void setDesign_id(Integer design_id) {
		this.design_id = design_id;
	}
	public Integer getDiy_style_id() {
		return diy_style_id;
	}
	public void setDiy_style_id(Integer diy_style_id) {
		this.diy_style_id = diy_style_id;
	}
	public Integer getGem_id() {
		return gem_id;
	}
	public void setGem_id(Integer gem_id) {
		this.gem_id = gem_id;
	}
	
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getCommentary_status() {
		return commentary_status;
	}
	public void setCommentary_status(String commentary_status) {
		this.commentary_status = commentary_status;
	}
	public Integer getDiamond_id() {
		return diamond_id;
	}
	public void setDiamond_id(Integer diamond_id) {
		this.diamond_id = diamond_id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

}
