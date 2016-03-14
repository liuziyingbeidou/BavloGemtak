package com.bavlo.gemtak.web.weixin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bavlo.gemtak.web.BaseController;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: WeiXinController 
 * @Description: 微信Controller
 * @author liuzy
 * @date 2016-3-11 上午10:24:10
 */
@Controller(value="weiXinController")
@RequestMapping(value="pub_wx")
public class WeiXinController extends BaseController {

	@RequestMapping(value="pay")
	public void wxPay(){
		
		System.out.println("微信支付...");
	}
}
