package com.bavlo.gemtak.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bavlo.gemtak.constant.IConstant;

/**
 * @Title: ±¦ççCounter
 * @ClassName: CommonController 
 * @Description: 
 * @author liuzy
 * @date 2015-11-5 ÉÏÎç10:57:03
 */
@Controller(value="commonController")
@RequestMapping(value="/common")
public class CommonController extends BaseController {

	@RequestMapping(value="getChainInfo")
	public ModelAndView getChainInfo(){
		
		ModelAndView model = new ModelAndView(IConstant.PATH_COMMON + IConstant.COMMON_CHAIN);
		
		return model;
	}
	
	@RequestMapping(value="getGemInfo")
	public ModelAndView getGemInfo(){
		
		ModelAndView model = new ModelAndView(IConstant.PATH_COMMON + IConstant.COMMON_GEM);
		
		return model;
	}
	
}
