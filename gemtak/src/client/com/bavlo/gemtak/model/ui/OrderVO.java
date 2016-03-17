package com.bavlo.gemtak.model.ui;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bavlo.gemtak.model.IdEntity;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: OrderVO 
 * @Description: 订单主表
 * @author liuzy
 * @date 2016-3-17 下午04:54:22
 */
@Entity
@Table(name="gt_order")
public class OrderVO extends IdEntity {

	private static final long serialVersionUID = 6114467828526147643L;

	
}
