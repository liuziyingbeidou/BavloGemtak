package com.bavlo.gemtak.model.ui;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bavlo.gemtak.model.IdEntity;

/**
 * @Title: ����Gemtak
 * @ClassName: ShoppingCardVO 
 * @Description: ���ﳵ����
 * @author lsk
 * @date 2016-3-28 ����10:10
 */
@Entity
@Table(name="gt_shopping")
public class ShoppingCarVO extends IdEntity{
    /**
     * 
     */
	private static final long serialVersionUID = 1L;
	//�û�id
	private Integer user_id;
	//�û���
	private String user_name;
	//��ʯ
	private Integer gem_id;
	//����ͼ
	private String pic;
	//�۸�
	private Double price;
	//����
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
