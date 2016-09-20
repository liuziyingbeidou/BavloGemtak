package com.bavlo.gemtak.service.weixin.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.bavlo.gemtak.model.ui.OrderVO;
import com.bavlo.gemtak.model.weixin.PackageResult;
import com.bavlo.gemtak.model.weixin.WxPayDto;
import com.bavlo.gemtak.service.impl.CommonService;
import com.bavlo.gemtak.service.weixin.itf.IWXZFService;
import com.bavlo.gemtak.util.weixin.IContant;
import com.bavlo.gemtak.util.weixin.WXPayUtil;
import com.bavlo.gemtak.utils.WebUtils;

@Service("wXZFService")
public class WXZFService extends CommonService implements IWXZFService {

	@Override
	public Map createOrder(HttpServletRequest request,String orderId, String openid,String totalPrice) {
		Map map = new HashMap();
		if (orderId == null) {
			map.put("msg", "非法参数!");
			map.put("status", "N");
			return map;
		}
		//该订单状态
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		if (orderList == null) {
			map.put("msg", "订单不存在或者已付款!");
			map.put("status", "N");
			return map;
		}
	
		//调用统一下单
		WxPayDto tpWxPay = new WxPayDto();
		tpWxPay.setOpenId(openid);
		tpWxPay.setBody("购买宝珑珠宝");
		tpWxPay.setOrderId(orderId);
		tpWxPay.setSpbillCreateIp(WebUtils.getIpAddr(request));
		tpWxPay.setTotalFee(totalPrice);
		PackageResult pr=WXPayUtil.getPackage(tpWxPay,IContant.notifyurl1);  //IContant微信服务号常量
		map.put("pr", pr);
		map.put("status", "Y");
		map.put("price", "123");
	   
		return map;
	}

}
