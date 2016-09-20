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
			map.put("msg", "�Ƿ�����!");
			map.put("status", "N");
			return map;
		}
		//�ö���״̬
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		if (orderList == null) {
			map.put("msg", "���������ڻ����Ѹ���!");
			map.put("status", "N");
			return map;
		}
	
		//����ͳһ�µ�
		WxPayDto tpWxPay = new WxPayDto();
		tpWxPay.setOpenId(openid);
		tpWxPay.setBody("�������鱦");
		tpWxPay.setOrderId(orderId);
		tpWxPay.setSpbillCreateIp(WebUtils.getIpAddr(request));
		tpWxPay.setTotalFee(totalPrice);
		PackageResult pr=WXPayUtil.getPackage(tpWxPay,IContant.notifyurl1);  //IContant΢�ŷ���ų���
		map.put("pr", pr);
		map.put("status", "Y");
		map.put("price", "123");
	   
		return map;
	}

}
