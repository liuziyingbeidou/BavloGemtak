package com.bavlo.gemtak.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.utils.WebUtils;

/**
 * @Title: ����Counter
 * @ClassName: CommonController 
 * @Description: 
 * @author liuzy
 * @date 2015-11-5 ����10:57:03
 */
@Controller(value="commonController")
@RequestMapping(value="/common")
public class CommonController extends BaseController {

	@RequestMapping(value="changeLang")
	public void changeLang(HttpServletResponse response,HttpServletRequest request){
		
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		if(IConstant.EN_UK.equals(lang)){
			lang = IConstant.ZH_CN;
		}else{
			lang = IConstant.EN_UK;
		}
		Cookie cookie = new Cookie("lang", lang);
        cookie.setMaxAge(-1);// ����Ϊ30min
        cookie.setPath("/");
        System.out.println("lang Cookie���л���"+lang);
        response.addCookie(cookie);
	}
}
