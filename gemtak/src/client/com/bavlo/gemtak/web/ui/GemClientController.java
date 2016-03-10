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
 * @Title: ����Gemtak
 * @ClassName: GemClientController 
 * @Description: 
 * @author liuzy
 * @date 2016-3-8 ����04:42:31
 */
@Controller(value="GemClientController")
@RequestMapping(value="gemClient")
public class GemClientController extends BaseController {

	@RequestMapping(value="viewGemList")
	public String viewGemList(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		GemClientPageModel.getCListPageModel(model,lang);
		
		return IClientForward.viewGemList;
	}
	
	@RequestMapping(value="viewGemDetaile")
	public String viewGemDetaile(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		GemClientPageModel.getCDetailePageModel(model,lang);
		
		return IClientForward.viewGemDetaile;
	}
	
	@RequestMapping(value="viewShoppingCar")
	public String viewGemShoppingCar(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		GemClientPageModel.getCShoppingCarPageModel(model,lang);
		
		return IClientForward.viewGemShoppingCar;
	}
	
	@RequestMapping(value="/order")
	public String gemOrder(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		GemClientPageModel.getCOrderPageModel(model,lang);
		
		return IClientForward.gemOrder;
	}

}
