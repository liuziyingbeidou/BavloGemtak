package com.bavlo.gemtak.web.weixin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bavlo.gemtak.web.BaseController;

/**
 * @Title: ����Gemtak
 * @ClassName: WeiXinController 
 * @Description: ΢��Controller
 * @author liuzy
 * @date 2016-3-11 ����10:24:10
 */
@Controller(value="weiXinController")
@RequestMapping(value="pub_wx")
public class WeiXinController extends BaseController {

	@RequestMapping(value="pay")
	public void wxPay(){
		
		System.out.println("΢��֧��...");
	}
}
