package com.bavlo.gemtak.web.ui;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bavlo.gemtak.constant.controller.IClientForward;
import com.bavlo.gemtak.service.weixin.itf.IWXZFService;
import com.bavlo.gemtak.util.weixin.WXPayUtil;
import com.bavlo.gemtak.utils.CommonUtils;
import com.bavlo.gemtak.utils.WebUtils;
import com.bavlo.gemtak.web.BaseController;
import com.bavlo.gemtak.web.weixin.GetWeiXinCode;

/**
 * @Title: ����Gemtak
 * @ClassName: GemClientController 
 * @Description: GemClient
 * @author liuzy
 * @date 2016-3-8 ����04:42:31
 */
@Controller(value="GemClientController")
@RequestMapping(value="gemClient")
public class GemClientController extends BaseController {
	
	@Resource
	IWXZFService wXZFService;

	/**
	 * @Description: ��ҳ-��ʯ�б�
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="viewGemList")
	public String viewGemList(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		GemClientPageModel.getCListPageModel(model,lang);
		
		return IClientForward.viewGemList;
	}
	
	/**
	 * @Description: ��ʯ��ϸҳ
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="viewGemDetaile")
	public String viewGemDetaile(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		GemClientPageModel.getCDetailePageModel(model,lang);
		
		return IClientForward.viewGemDetaile;
	}
	
	/**
	 * @Description: ���ﳵ
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="viewShoppingCar")
	public String viewGemShoppingCar(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		GemClientPageModel.getCShoppingCarPageModel(model,lang);
		
		return IClientForward.viewGemShoppingCar;
	}
	
	/**
	 * @Description: ����
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="order")
	public String gemOrder(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		GemClientPageModel.getCOrderPageModel(model,lang);
		
		return IClientForward.gemOrder;
	}
	
	/**
	 * @Description: �������
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="orderSuccess")
	public String orderSuccess(Model model,HttpServletResponse response,HttpServletRequest request){
		String code = request.getParameter("code");
		System.out.println("Code:-----"+code);
		String openId = WXPayUtil.getopendid(code);
		System.out.println("opendId:"+openId);
		String forword = IClientForward.gemOrderSuccess;
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		GemClientPageModel.getCOrderSuccessPageModel(model,lang);
		//΢��֧��
		String orderId = CommonUtils.getBillCode("GM");
		System.out.println(orderId);
		Map pr=wXZFService.createOrder(request,orderId, openId);
		model.addAttribute("map", pr);
		
		return forword;
	}
	
	/**
	 * @Description: ��ȡ΢���û�code
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="balancePay")
	public String testPay(HttpServletResponse response,HttpServletRequest request){
		String code = GetWeiXinCode.getCodeRequest();
		return "redirect:"+code;
	}
	
	
	/**
	 * @Description: ����֧��
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="orderPay")
	public String orderPay(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		GemClientPageModel.getCOrderPayPageModel(model,lang);
		
		return IClientForward.gemOrderPay;
	}
	
	/**
	 * @Description: ��¼
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="login")
	public String login(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		GemClientPageModel.getCLoginPageModel(model,lang);
		
		return IClientForward.gemLogin;
	}
	
	/**
	 * @Description: �û�
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="user")
	public String user(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		GemClientPageModel.getCUserPageModel(model,lang);
		
		return IClientForward.gemUser;
	}
	
}
