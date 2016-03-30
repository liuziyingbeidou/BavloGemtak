package com.bavlo.gemtak.web.gem;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bavlo.gemtak.service.gem.itf.IGemService;
import com.bavlo.gemtak.web.BaseController;

/**
 * @Title: ±¦ççGemtak
 * @ClassName: InvokeController 
 * @Description: ½Ó¿Ú
 * @author liuzy
 * @date 2016-3-30 ÉÏÎç09:44:28
 */
@Controller("invokeController")
@RequestMapping(value="gemtak")
public class InvokeController extends BaseController {

	@Resource
	IGemService gemService;
	
	@RequestMapping("uploadGemPic")
	@ResponseBody
	public String uploadGemPic(HttpServletRequest request,HttpServletResponse response,String ecode,String folder){
		Boolean fg = true;
		try {
			gemService.saveHeadAndBody(ecode, folder);
		} catch (Exception e) {
			e.printStackTrace();
			fg = false;
		}
		return fg ? "SUCCESS" : "FAIL";
	}
}
