package com.bavlo.gemtak.model.ui;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bavlo.gemtak.model.IdEntity;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: ShoppingCardVO 
 * @Description: 购物车主表
 * @author lsk
 * @date 2016-3-28 上午10:10
 */
@Entity
@Table(name="gt_shopping")
public class ShoppingCarVO extends IdEntity{
    /**
     * 
     */
	private static final long serialVersionUID = 1L;
	//用户id
	private Integer user_id;
	//用户名
	private String user_name;
	//宝石
	private Integer gem_id;
	//封面图
	private String pic;
	//价格
	private Double price;
	//数量
	private Integer quantity;

	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getGem_id() {
		return gem_id;
	}
	public void setGem_id(Integer gem_id) {
		this.gem_id = gem_id;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
}
