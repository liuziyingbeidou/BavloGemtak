package com.bavlo.gemtak.web.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bavlo.gemtak.constant.controller.IClientForward;
import com.bavlo.gemtak.utils.WebUtils;
import com.bavlo.gemtak.web.BaseController;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: GemClientController 
 * @Description: 
 * @author liuzy
 * @date 2016-3-8 下午04:42:31
 */
@Controller(value="GemClientController")
@RequestMapping(value="gemClient")
public class GemClientController extends BaseController {

	@RequestMapping(value="viewGemList")
	public String viewGemList(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCListPageModel(model,lang);
		
		return IClientForward.viewGemList;
	}
	
	@RequestMapping(value="viewGemDetaile")
	public String viewGemDetaile(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCDetailePageModel(model,lang);
		
		return IClientForward.viewGemDetaile;
	}
	
	@RequestMapping(value="viewShoppingCar")
	public String viewGemShoppingCar(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCShoppingCarPageModel(model,lang);
		
		return IClientForward.viewGemShoppingCar;
	}
	
	@RequestMapping(value="/order")
	public String gemOrder(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCOrderPageModel(model,lang);
		
		return IClientForward.gemOrder;
	}

}
