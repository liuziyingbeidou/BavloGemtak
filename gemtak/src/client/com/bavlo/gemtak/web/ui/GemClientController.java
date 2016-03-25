package com.bavlo.gemtak.web.ui;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bavlo.gemtak.constant.controller.IClientForward;
import com.bavlo.gemtak.model.gem.GemVO;
import com.bavlo.gemtak.service.ui.itf.IGemService;
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
	@Resource
	IGemService gemService;
	
	/**
	 * @Description: ��ҳ-��ʯ�б�
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="viewGemList")
	public String viewGemList(Model model,HttpServletRequest request,HttpServletResponse response,
			Integer dgpage,String typegem,String shapegem,String fromWeight,String toWeight,String fromPrice,String toPrice,
			String inwhere,String inwheres){
		
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		GemClientPageModel.getCListPageModel(model,lang);
		/*StringBuilder sql = new StringBuilder(" 1=1");
		if(!CommonUtils.isNull(typegem)){
			sql.append( " and type_id = '"+typegem+"'");
		}
		if(!CommonUtils.isNull(shapegem)){
			sql.append(" and shape_id = '"+shapegem+"'");
		}
		if(!CommonUtils.isNull(fromWeight) && !CommonUtils.isNull(toWeight)){
			sql.append(" and weight between "+fromWeight+" and "+toWeight+"");
		}
		if(!CommonUtils.isNull(fromPrice) && !CommonUtils.isNull(toPrice)){
			sql.append(" and retail_price between "+fromPrice+" and "+toPrice+"");
		}
		if(!CommonUtils.isNull(inwhere)){
			sql.append(" and pairs in ("+inwhere+")");
		}
		//��״ ���ȡ�����
		if(!CommonUtils.isNull(inwheres)){
			sql.append(" and pairs in ("+inwheres+")");
		}
		
        List<GemVO> gems = gemService.findListGem(sql+"", dgpage, rows,null,null);
		model.addAttribute("gems", gems);*/
		/*return IClientForward.viewGemList;*/
		return "/client/gem/list";
	}
	
	/**
	 * 2.ajax����������ѯ
	 * @param model
	 * @param request
	 * @param response
	 * @param dgpage
	 * @param typegem
	 * @param shapegem
	 * @param fromWeight
	 * @param toWeight
	 * @param fromPrice
	 * @param toPrice
	 */
	@RequestMapping(value="getGemClientListBy")
	public void getGemClientListBy(Model model,HttpServletRequest request,HttpServletResponse response,
			Integer dgpage,String typegem,String shapegem,String fromWeight,String toWeight,
			String fromPrice,String toPrice,String selDate,String inwhere,String inwheres){
		String reldate = "desc";
		StringBuilder sql = new StringBuilder(" 1=1");
		if(!CommonUtils.isNull(typegem)){
			sql.append( " and type_id = '"+typegem+"'");
		}
		if(!CommonUtils.isNull(shapegem)){
			sql.append(" and shape_id = '"+shapegem+"'");
		}
		if(!CommonUtils.isNull(fromWeight) && !CommonUtils.isNull(toWeight)){
			sql.append(" and weight between "+fromWeight+" and "+toWeight+"");
		}
		if(!CommonUtils.isNull(fromPrice) && !CommonUtils.isNull(toPrice)){
			sql.append(" and retail_price between "+fromPrice+" and "+toPrice+"");
		}
		
		if(!CommonUtils.isNull(inwhere)){
			sql.append(" and pairs in ("+inwhere+")");
		}
		//��״ ���ȡ�����
		if(!CommonUtils.isNull(inwheres)){
			sql.append(" and pairs in ("+inwheres+")");
		}
		
		if("htol".equals(selDate)){
			reldate = "desc";
		}
		if("ltoh".equals(selDate)){
			reldate = "asc";
		}
        List<GemVO> gems = gemService.findListGem(sql+"", dgpage, rows,"releasedate",reldate);
		renderJson(gems);
		
	}
	
	/**
	 * 3.���������ƻ�����idģ�� ��ѯ
	 * @param model
	 * @param request
	 * @param response
	 * @param dgpage
	 * @param typegem
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="selectClientByType")
	public String selectClientByType(Model model,HttpServletRequest request,HttpServletResponse response,
			Integer dgpage,String typegem) throws UnsupportedEncodingException{
		
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		GemClientPageModel.getCListPageModel(model,lang);
		String tgem = new String( typegem.getBytes("ISO-8859-1") , "utf-8");
		StringBuilder sql = new StringBuilder(" 1=1");
		if(!CommonUtils.isNull(typegem)){
			sql.append( " and (type_id like '%"+tgem+"%' or type_cn like '%"+tgem+"%')");
		}
		
        List<GemVO> gems = gemService.findListGem(sql+"", dgpage, rows,null,null);
		model.addAttribute("gems", gems);
		/*return IClientForward.viewGemList;*/
		return "/client/gem/list";
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
	public String viewGemDetaile(Model model,HttpServletResponse response,HttpServletRequest request,Integer id){
		
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		GemClientPageModel.getCDetailePageModel(model,lang);
		GemVO gem = gemService.findGemVOByID(id);
		model.addAttribute("gem", gem);
		/*return IClientForward.viewGemDetaile;*/
		return "/client/gem/detaile";
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
