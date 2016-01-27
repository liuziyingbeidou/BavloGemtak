package com.bavlo.gemtak.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bavlo.gemtak.model.LoginVO;
import com.bavlo.gemtak.utils.JsonUtils;
import com.bavlo.gemtak.utils.StringUtil;

@Controller(value="systemController")
public class SystemController extends BaseController {
	
	@RequestMapping(value={"/index.do"})
	public ModelAndView index(HttpServletRequest request,HttpSession session){
		ModelAndView model = new ModelAndView("index");
		Object loginInfo = session.getAttribute("loginInfo");
		/*if(loginInfo != null){
			if(StringUtil.isEmpty(((LoginVO)loginInfo).getUserId())){
				model.setViewName("redirect:/index.do");
			}
			LoginVO loginVO = (LoginVO)loginInfo;
			model.addObject("uvo", loginVO);
		}else{
			model.setViewName("redirect:/index.do");
		}*/
		System.out.println("µÇÂ¼ÈËÐÅÏ¢:"+JsonUtils.getJsonString4JavaPOJO(loginInfo));
		return model;
	}
	
	@RequestMapping(value={"/exit.do"})
	public void exit(){
		session.removeAttribute("loginInfo");
		renderText("0");
	}
}
