package com.bavlo.gemtak.web.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.constant.controller.IClientForward;
import com.bavlo.gemtak.httpclient.HttpTools;
import com.bavlo.gemtak.model.gem.GemVO;
import com.bavlo.gemtak.model.ui.ShoppingCarVO;
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
		model.addAttribute("model", "hbx");
		/*return IClientForward.viewGemDetaile;*/
		return "/client/gem/detaile";
	}
	
	/**
	 * ��ӵ����ﳵ
	 * @param model
	 * @param response
	 * @param request
	 * @param carVO
	 * lisuike 2016-3-28 ����10:44:50
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	@RequestMapping(value="addShoppingCar")
	public void insertShoppingCar(Model model,HttpServletResponse response,HttpServletRequest request,ShoppingCarVO carVO,Integer gemId,
			String username,Integer quantity) {
	    Object uname = request.getSession().getAttribute(IConstant.SESSIONUSERNAEM);
	    if(CommonUtils.isNull(uname)){
	    	username = (String) uname;
	    }
	   Integer num = 0;
	   
	   //�û�ע�ᡢ��¼���ܻ�ûʵ�֣�������
	   /*if(!CommonUtils.isNull(uname)){
		   userId = 1;
	   }
	   userId = 1;*/
	    try {
			gemService.saveOrupdateShoppingCarVO(gemId, username,quantity);
			num = gemService.getShoppingCarNumByUname(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		   renderText("{\"mess\":\"Y\",\"carNum\":\""+num+"\"}");
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
	public String viewGemShoppingCar(Model model,HttpServletResponse response,HttpServletRequest request,Integer gemId){
		
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		GemClientPageModel.getCShoppingCarPageModel(model,lang);
		Object username = request.getSession().getAttribute(IConstant.SESSIONUSERNAEM);
		
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
	 * @Description: ��¼�ɹ�
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="loginSuccess")
	@ResponseBody
	public String loginSuccess(Model model,HttpServletRequest request,HttpServletResponse response,String uname,String upwd){
		String msg = HttpTools.submitPost(IConstant.loginURL,"uname="+uname+"&upwd="+upwd)+"";
		//��¼�ɹ����û�������session��
		request.getSession().setAttribute(IConstant.SESSIONUSERNAEM, uname);
		return msg;
		//renderText(msg);
	}
	
	/**
	 * @Description: ��¼�ɹ�����ʾ��ҳ������ѯ���û��Ĺ��ﳵ
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="goToList")
	public String goToList(Model model,HttpServletRequest request,HttpServletResponse response,String uname){
		Integer num = 0;
		try {
			num = gemService.getShoppingCarNumByUname(uname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("carNum",num);
		model.addAttribute("uname",uname);
		return "/client/gem/list";
		//renderText(msg);
	}
	
	/**
	 * @Description: ע��ɹ�
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="registerSuccess")
	@ResponseBody
	public String registerSuccess(Model model,HttpServletRequest request,HttpServletResponse response,
			String uname,String upwd,String regauthcode){
		String msg = "";
		String authcode = (String) request.getSession().getAttribute("validateCode");
		if(authcode != null && authcode != ""){
			if(authcode.equalsIgnoreCase(regauthcode)){
				msg = HttpTools.submitPost(IConstant.registerURL,"uname="+uname+"&upwd="+upwd)+"";
			}else{
				msg = "error2";
			}
		}
		
		
		return msg;
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
	
	@RequestMapping(value="loadImg")
	public String loadImg(Model model,HttpServletResponse response,HttpServletRequest request){
		
		model.addAttribute("model", "hbx");
		return "/client/gem/load-img";
	}
	@RequestMapping("imgValidate")
	@ResponseBody
	public String imgValidate(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			int width = 80; // ���
			int height = 25;// �߶�
			int codeCount = 4;// ��֤���ַ�����
			char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
					'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
					'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5',
					'6', '7', '8', '9' };

			BufferedImage buffImg = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = buffImg.createGraphics();
			// ����һ���������������
			Random random = new Random();
			// ��ͼ�����Ϊ��ɫ
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, width, height);
			// �������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�����."Times New Roman"/Fixedsys, Font.PLAIN, 20
			Font font = new Font("Fixedsys", Font.PLAIN, 20);
			// �������塣
			g.setFont(font);
			// ���߿�
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, width - 1, height - 1);
			// �������160(i<160)�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽��
			g.setColor(Color.BLACK);
			for (int i = 0; i < 20; i++) {
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				int xl = random.nextInt(12);
				int yl = random.nextInt(12);
				g.drawLine(x, y, x + xl, y + yl); // ������
			}
			// randomCode���ڱ��������������֤�룬�Ա��û���¼�������֤��
			StringBuffer randomCode = new StringBuffer();
			int red = 0, green = 0, blue = 0;
			// �������codeCount���ֵ���֤�롣
			for (int i = 0; i < codeCount; i++) {
				// �õ������������֤�����֡�
				String strRand = String
						.valueOf(codeSequence[random.nextInt(36)]);
				// �����������ɫ������������ɫֵ�����������ÿλ���ֵ���ɫֵ������ͬ��
				red = random.nextInt(255);
				green = random.nextInt(255);
				blue = random.nextInt(255);
				// �������������ɫ����֤����Ƶ�ͼ���С�
				g.setColor(new Color(red, green, blue));
				g.drawString(strRand, (i + 1) * (width / (codeCount + 1)),
						height - 4);
				// ���������ĸ�����������һ��
				randomCode.append(strRand);
			}
			// ����λ���ֵ���֤�뱣�浽Session�С�
			HttpSession session = request.getSession();
			session.setAttribute("validateCode", randomCode.toString());
			// ��ֹͼ�񻺴档
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/jpeg");

			// ��ͼ�������Servlet������С�
			ServletOutputStream sos = response.getOutputStream();
			ImageIO.write(buffImg, "jpeg", sos);
			sos.flush();
			sos.close();
			sos = null;
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
