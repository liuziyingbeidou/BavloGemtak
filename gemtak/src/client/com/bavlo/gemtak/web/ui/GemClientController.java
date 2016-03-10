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

	/**
	 * @Description: 首页-宝石列表
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="viewGemList")
	public String viewGemList(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCListPageModel(model,lang);
		
		return IClientForward.viewGemList;
	}
	
	/**
	 * @Description: 宝石详细页
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="viewGemDetaile")
	public String viewGemDetaile(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCDetailePageModel(model,lang);
		
		return IClientForward.viewGemDetaile;
	}
	
	/**
	 * @Description: 购物车
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="viewShoppingCar")
	public String viewGemShoppingCar(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCShoppingCarPageModel(model,lang);
		
		return IClientForward.viewGemShoppingCar;
	}
	
	/**
	 * @Description: 订单
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="order")
	public String gemOrder(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCOrderPageModel(model,lang);
		
		return IClientForward.gemOrder;
	}
	
	/**
	 * @Description: 订单完成
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="orderSuccess")
	public String orderSuccess(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCOrderSuccessPageModel(model,lang);
		
		return IClientForward.gemOrderSuccess;
	}
	
	/**
	 * @Description: 订单支付
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="orderPay")
	public String orderPay(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCOrderPayPageModel(model,lang);
		
		return IClientForward.gemOrderPay;
	}
	
	/**
	 * @Description: 登录
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="login")
	public String login(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCLoginPageModel(model,lang);
		
		return IClientForward.gemLogin;
	}
	
	/**
	 * @Description: 用户
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="user")
	public String user(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCUserPageModel(model,lang);
		
		return IClientForward.gemUser;
	}
	
}
