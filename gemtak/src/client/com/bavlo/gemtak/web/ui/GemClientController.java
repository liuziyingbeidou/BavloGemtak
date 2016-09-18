package com.bavlo.gemtak.web.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.constant.controller.IClientForward;
import com.bavlo.gemtak.httpclient.HttpTools;
import com.bavlo.gemtak.model.LoginVO;
import com.bavlo.gemtak.model.gem.GemVO;
import com.bavlo.gemtak.model.ui.OrderBVO;
import com.bavlo.gemtak.model.ui.OrderVO;
import com.bavlo.gemtak.model.ui.ShoppingCarVO;
import com.bavlo.gemtak.model.weixin.WxPayDto;
import com.bavlo.gemtak.service.ui.itf.IGemService;
import com.bavlo.gemtak.service.weixin.itf.IWXZFService;
import com.bavlo.gemtak.services.AlipayService;
import com.bavlo.gemtak.util.weixin.WXPayUtil;
import com.bavlo.gemtak.utils.CommonUtils;
import com.bavlo.gemtak.utils.DateUtil;
import com.bavlo.gemtak.utils.GenerateQrCodeUtil;
import com.bavlo.gemtak.utils.QrCodeUtil;
import com.bavlo.gemtak.utils.WebUtils;
import com.bavlo.gemtak.utils.wxcode.WXUtil;
import com.bavlo.gemtak.web.BaseController;
import com.bavlo.gemtak.web.weixin.GetWeiXinCode;
import com.bavlo.gemtak.weixin.qy.interceptor.OAuthRequired;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: GemClientController 
 * @Description: GemClient
 * @author liuzy
 * @date 2016-3-8 下午04:42:31
 */
@Controller(value="GemClientController")
@RequestMapping(value="gemClient")
public class GemClientController extends BaseController {
	
	@Resource
	IWXZFService wXZFService;
	@Resource
	IGemService gemService;
	
	@Autowired
	private ServletContext servletContext;
	
	/**
	 * @Description: 首页-宝石列表
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="viewGemList")
	public String viewGemList(Model model,HttpServletRequest request,HttpServletResponse response,
			Integer dgpage){
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCListPageModel(model,lang);
		
        //Integer gemNo = gemService.getListSizeGem(typegem, shapegem, fromWeight, toWeight, fromPrice, toPrice, inwhere, inwheres);
		Object username = request.getSession().getAttribute(IConstant.SESSIONUSERNAEM);
		if(username == null){
			username = "NLogin";
		}
		//model.addAttribute("gemNo",gemNo);
		model.addAttribute("uname", username);
		return "/client/gem/list";
	}
	
	/**
	 * @Description: 首页-宝石总数
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="selGemNO")
	public void selGemNO(Model model,HttpServletRequest request,HttpServletResponse response,
			String typegem,String shapegem,String fromWeight,String toWeight,String fromPrice,String toPrice,
			String inwhere,String inwheres){
			Integer gemNo = gemService.getListSizeGem(typegem, shapegem, fromWeight, toWeight, fromPrice, toPrice, inwhere, inwheres);
			 renderText("{\"gemNo\":\""+gemNo+"\"}");
        
	}
	
	/**
	 * 2.ajax根据条件查询
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
		if((!CommonUtils.isNull(typegem)) && (!"a".equals(typegem))){
			sql.append( " and type_id = '"+typegem+"'");
		}
		if((!CommonUtils.isNull(shapegem)) && (!"a".equals(shapegem))){
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
		//形状 弧度、切面
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
        /****/
        Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
        for(Cookie cookie : cookies){
            System.out.println("name:"+cookie.getName()+",value:"+ cookie.getValue());
            if(!"".equals(cookie.getName())){
            	if(cookie.getName().equals(cookie.getValue())){
            		for(GemVO vo : gems){
            			Integer id = vo.getId();
            			if(cookie.getValue().equals(id+"")){
            				vo.setVdef3("T");
            			}
            		}
            	}
            }
        }
        /****/
        if(gems.size() != 0){
        	renderJson(gems);
        }
	}
	
	
	/**
	 * 3.按类型名称或类型id模糊 查询
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
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCListPageModel(model,lang);
		String tgem = new String( typegem.getBytes("ISO-8859-1") , "utf-8");
		StringBuilder sql = new StringBuilder(" 1=1");
		if(!CommonUtils.isNull(typegem)){
			sql.append( " and (type_id like '%"+tgem+"%' or type_cn like '%"+tgem+"%')");
		}
		
        List<GemVO> gems = gemService.findListGem(sql+"", dgpage, rows,null,null);
		model.addAttribute("gems", gems);
		Object username = request.getSession().getAttribute(IConstant.SESSIONUSERNAEM);
		if(username == null){
			username = "NLogin";
		}
		model.addAttribute("uname", username);
		/*return IClientForward.viewGemList;*/
		return "/client/gem/list";
	}
	
	
	/**
	 * @Description: 宝石详细页
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 * @throws Exception 
	 */
	@RequestMapping(value="viewGemDetaile")
	public String viewGemDetaile(Model model,HttpServletResponse response,HttpServletRequest request,Integer id) throws Exception{
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCDetailePageModel(model,lang);
		GemVO gem = gemService.findGemVOByID(id);
		request.getSession().setAttribute("type", gem.getType_cn());
		request.getSession().setAttribute("shape", gem.getShape_cn());
		request.getSession().setAttribute("weight", gem.getWeight());
		gemService.updateGemVOPageViews(gem);//每查看一次详情页，浏览次数加1
		model.addAttribute("gem", gem);
		model.addAttribute("model", gem.getUrl_360());   //gem.getUrl_360();
		/*return IClientForward.viewGemDetaile;*/
		return "/client/gem/detaile";
	}
	
	/**
	 * @Description: 全屏展示宝石
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 * @throws Exception 
	 */
	@RequestMapping(value="viewGemPic")
	public String viewGemPic(Model model,HttpServletResponse response,HttpServletRequest request,Integer id) throws Exception{
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCDetailePageModel(model,lang);
		GemVO gem = gemService.findGemVOByID(id);
		model.addAttribute("model", gem.getUrl_360());   //gem.getUrl_360();
		return "/client/gem/full-img";
	}
	
	/**
	 * 添加到购物车
	 * @param model
	 * @param response
	 * @param request
	 * @param carVO
	 * lisuike 2016-3-28 上午10:44:50
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	@RequestMapping(value="addShoppingCar")
	public void insertShoppingCar(Model model,HttpServletResponse response,HttpServletRequest request,ShoppingCarVO carVO,Integer gemId,
			String username,Integer quantity) {
	    Object uname = request.getSession().getAttribute(IConstant.SESSIONUSERNAEM);
	    if(uname == ""|| uname == null){
	    	 renderText("{\"mess\":\"N\"}"); //添加到购物车前判断session是否为空，为空返回N，让其登录
	    }else {
	    	username = (String) uname;
	    	Integer num = 0;
		    try {
				gemService.saveOrupdateShoppingCarVO(gemId, username,quantity);
				num = gemService.getShoppingCarNumByUname(username);
			} catch (Exception e) {
				e.printStackTrace();
			}
			   renderText("{\"mess\":\"Y\",\"carNum\":\""+num+"\"}");
	    } 
	}
	
	/**
	 * 删除购物车 中选中的商品
	 * @param model
	 * @param response
	 * @param request
	 * @param carVO
	 * lisuike 2016-3-31 上午13:25:50
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	@RequestMapping(value="delShoppingCar")
	public void deleteShoppingCar(Model model,HttpServletResponse response,HttpServletRequest request,ShoppingCarVO carVO,Integer shoppingCarId) {
	    Object uname = request.getSession().getAttribute(IConstant.SESSIONUSERNAEM);
	    if(uname != ""|| uname != null){
		    try {
				gemService.delShoppingCarByGemId(uname+"", shoppingCarId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			   renderText("{\"mess\":\"Y\"}");
	    } 
	}
	
	/**
	 * @Description:根据用户名 查询该用户的购物车商品总数
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return 
	 */
	@RequestMapping(value="getCarNum")
	public void getCarNum(HttpServletRequest request,HttpServletResponse response){
	    Object username = request.getSession().getAttribute(IConstant.SESSIONUSERNAEM);
	    if(username == ""|| username == null){
	    	renderText("0");
	    }else{
	    	Integer num = 0;
			try {
				num = gemService.getShoppingCarNumByUname(username.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			renderText(num+"");
	    }
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
	public String viewGemShoppingCar(Model model,HttpServletResponse response,HttpServletRequest request,String uname,Integer gmeid){
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCShoppingCarPageModel(model,lang);
		List<GemVO> gemList;
		Object username = request.getSession().getAttribute(IConstant.SESSIONUSERNAEM);
		if(username != null|| username != ""){
			try {
				uname = (String) username;
				gemList = gemService.getShoppingCarListByUname(uname);
				model.addAttribute("gemList",gemList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return IClientForward.viewGemShoppingCar;
	}
	
	/**
	 * @Description: 检查购物车 是否为空
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="checkGemShoppingCar")
	public void checkGemShoppingCar(Model model,HttpServletResponse response,HttpServletRequest request,String uname,Integer gmeid){
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCShoppingCarPageModel(model,lang);
		List<GemVO> gemList = null;
		Object username = request.getSession().getAttribute(IConstant.SESSIONUSERNAEM);
		if(username != null|| username != ""){
			try {
				uname = (String) username;
				gemList = gemService.getShoppingCarListByUname(uname);
				/*renderText(gemList+"");*/
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String flag = "N";
		if(gemList != null){
			if(gemList.size() > 0){
				flag = "Y";
			}
		}
		renderText(flag);
	}
	
	/**
	 * 获取用户 收货地址
	 * @param model
	 * @param response
	 * @param request
	 */
	@RequestMapping(value="getUserAddress")
	public void getUserAddress(Model model,HttpServletResponse response,HttpServletRequest request){
		Object uname = request.getSession().getAttribute(IConstant.SESSIONUSERNAEM);
		StringBuffer user = HttpTools.submitPost(IConstant.shoppingAddressURL, "uname="+uname+"");
		renderJson(user+"");
	}
	
	/**
	 * 根据id 收货地址
	 * @param model
	 * @param response
	 * @param request
	 */
	@RequestMapping(value="getUserAddressByAid")
	public void getUserAddressByAid(Model model,HttpServletResponse response,HttpServletRequest request,Long aid){
		String user = HttpTools.getDataByURL(IConstant.getShoppingAddressByAidURL+"?asi="+aid+"");
		renderJson(user);
	}
	
	/**
	 * 新增用户 收货地址
	 * @param model
	 * @param response
	 * @param request
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="addUserAddress")
	public void addUserAddress(Model model,HttpServletResponse response,HttpServletRequest request,String cellphone,String tel,
			String area,String detailAddress,String email,String zipCode,String realName,Long aid) throws UnsupportedEncodingException{
		Object uname = request.getSession().getAttribute(IConstant.SESSIONUSERNAEM);
//		StringBuffer user = HttpTools.submitPost(IConstant.addShoppingAddressURL, "realName="+realName+"&cellphone="+cellphone+"&tel="+tel+"" +
//				"&area="+area+"&detailAddress="+detailAddress+"&email="+email+"&zipCode="+zipCode+"&uname="+uname+"");
		String user = "";
		if(aid == null){
			user = HttpTools.getDataByURL(IConstant.addShoppingAddressURL+"?realName="+realName+"&cellphone="+cellphone+"&tel="+tel+"" +
					"&area="+area+"&detailAddress="+detailAddress+"&email="+email+"&zipCode="+zipCode+"&uname="+uname+"");
		}else{
			user = HttpTools.getDataByURL(IConstant.addShoppingAddressURL+"?realName="+realName+"&cellphone="+cellphone+"&tel="+tel+"" +
					"&area="+area+"&detailAddress="+detailAddress+"&email="+email+"&zipCode="+zipCode+"&aid="+aid+"&uname="+uname+"");
		}
		renderText(user);
	}
	
	/**
	 * 修改用户 收货地址
	 * @param model
	 * @param response
	 * @param request
	 *//*
	@RequestMapping(value="updateUserAddress")
	public void updateUserAddress(Model model,HttpServletResponse response,HttpServletRequest request,String cellphone,String tel,
			String area,String detailAddress,String email,String zipCode,String realName,String optype){
		Object uname = request.getSession().getAttribute(IConstant.SESSIONUSERNAEM);
		String user = HttpTools.getDataByURL(IConstant.addShoppingAddressURL+"?realName="+realName+"&cellphone="+cellphone+"&tel="+tel+"" +
				"&area="+area+"&detailAddress="+Address+"&email="+email+"&zipCode="+zipCode+"&optype="+optype+"&uname="+uname+"");
		renderText(user);
	}*/
	
	/**
	 * 删除用户 收货地址
	 * @param model
	 * @param response
	 * @param request
	 */
	@RequestMapping(value="delUserAddress")
	public void delUserAddress(Model model,HttpServletResponse response,HttpServletRequest request,String id){
		StringBuffer user = HttpTools.submitPost(IConstant.delShoppingAddressURL, "id="+id);
		renderText(user+"");
	}
	
	/**
	 * 修改用户密码
	 * @param model
	 * @param response
	 * @param request
	 */
	@RequestMapping(value="updateUserPWD")
	public void updateUserPWD(Model model,HttpServletResponse response,HttpServletRequest request,String oldPwd,String newPwd){
		String uname = (String)request.getSession().getAttribute(IConstant.SESSIONUSERNAEM);
		String user = HttpTools.getDataByURL(IConstant.updatePwdByUnameURL+"?uname="+uname+"&oldPwd="+oldPwd+"&newPwd="+newPwd);
		renderText(user);
	}
	
	/**
	 * 根据订单id查询 宝石
	 * @param model
	 * @param response
	 * @param request
	 */
	@RequestMapping(value="selOrderGemById")
	public void selOrderGemById(Model model,HttpServletResponse response,HttpServletRequest request,String orderid){
		List<GemVO> list = gemService.getOrderGemById(orderid);
		renderJson(list);
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
		Object uname = request.getSession().getAttribute(IConstant.SESSIONUSERNAEM);
		try {
			List<GemVO> gemList = new ArrayList<GemVO>();
			if(uname != null){
				gemList = gemService.getShoppingCarListByUname(uname.toString());
			}
			if(gemList != null){
				model.addAttribute("gemList",gemList);	
				session.setAttribute("shoppCart", gemList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IClientForward.gemOrder;
	}
	
	/**
	 * 订单完成
	 * @param model
	 * @param response
	 * @param request
	 * @param toalPrice
	 * @return
	 */
	@RequestMapping(value="orderFish")
	public String ordrFish(Model model,HttpServletResponse response,HttpServletRequest request,String toalPrice,String orderNo){
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCShoppingCarPageModel(model,lang);
		model.addAttribute("totalPrice",toalPrice);
		model.addAttribute("orderNo",orderNo);
		return IClientForward.gemOrderSuccess;
	}
	
	/**
	 * @Description: 提交订单
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 * @throws Exception 
	 */
	@RequestMapping(value="orderSuccess")
	public String orderSuccess(Model model,HttpServletResponse response,HttpServletRequest request){
		String code = request.getParameter("code");
		System.out.println("Code:-----"+code);
		String openId = WXPayUtil.getopendid(code);
		System.out.println("opendId:"+openId);
	
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCOrderPayPageModel(model,lang);
		
		//微信支付
		Object mapOrder = session.getAttribute("sOrderMap");// CommonUtils.getBillCode("GM");
		if(mapOrder != null){
			Map mpo = (Map)mapOrder;
			Object orderId = mpo.get("orderCode");
			Object totalPrice = mpo.get("totalPrice");
			Map pr=wXZFService.createOrder(request,orderId+"", openId,totalPrice+"");
			model.addAttribute("map", pr);
			model.addAttribute("totalPrice", mpo.get("totalPrice"));
			model.addAttribute("orderNo", orderId);
		}
		
		String forword = IClientForward.gemOrderSuccess;
		return forword;
	}
	
	/**
	 * @Description: 微信扫码支付 重刷新当前支付页面
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 * @throws Exception 
	 */
	@RequestMapping(value="orderSuc")
	public String orderSuc(Model model,HttpServletResponse response,HttpServletRequest request){
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCOrderPayPageModel(model,lang);

		//微信支付PC
		Object mapOrder = session.getAttribute("pcwxOrderMap");// CommonUtils.getBillCode("GM");
		if(mapOrder != null){
			Map mpo = (Map)mapOrder;
			Object orderId = mpo.get("orderCode");
			Object totalPrice = mpo.get("totalPrice");
			Object code_url = mpo.get("code_url");
			model.addAttribute("totalPrice", totalPrice);
			model.addAttribute("orderNo", orderId);
			model.addAttribute("code_url", code_url);
		}
		
		String forword = "/client/gem/order-success";
		return forword;
	}
	
	
	
	/**
	 * 支付宝扫码支付
	 * @param model
	 * @param orderNo
	 * @param totalPrice
	 * @return
	 */
	@RequestMapping(value="alipayURL")
	public String alipayURL(Model model,String orderNo,Double totalPrice){
		Map<String,String> sParaTemp = new HashMap<String,String>();
		sParaTemp.put("payment_type", "1");
		sParaTemp.put("out_trade_no", orderNo);
		sParaTemp.put("subject", "订单："+orderNo);
		sParaTemp.put("body", "");
		sParaTemp.put("total_fee", totalPrice+"");
		String url = AlipayService.create_direct_pay_by_user(sParaTemp);
	    model.addAttribute("url", url);
		return "/client/gem/order-alipaysuccess";
	}
	
	/**
	 * @Description: 获取微信用户code
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="balancePay")
	public String testPay(Model model,HttpServletResponse response,HttpServletRequest request,OrderVO orderVO,Integer shoppingCarid,String list){
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCOrderPayPageModel(model,lang);
		String orderNo = null;
		String sessionId = session.getId();
		Object sid = session.getAttribute("sessionId");
		if(sessionId.equals(sid)){
			orderNo = session.getAttribute(sessionId)+"";
		}else{
			orderNo = CommonUtils.getBillCode("GM");
		}
		
		System.out.println("当前取到的sessionId:"+sessionId);
		
		if(!sessionId.equals(sid)){
			session.setAttribute("sessionId", sessionId);
			session.setAttribute(sessionId, orderNo);
			orderVO.setOrder_no(orderNo);
			Integer orderId;
			//根据 用户名 和 购物车id 删除 购物车信息
			Object uname = request.getSession().getAttribute(IConstant.SESSIONUSERNAEM);
			try {
				orderVO.setUsername(uname+"");
				orderId = gemService.saveOrderRelID(orderVO);
			
				if(orderId > 0){
					System.out.println("新增成功！");
					//获取Session 商品表
					Object spCart = session.getAttribute("shoppCart");
					if(spCart != null){
						List<GemVO> gemList = (List<GemVO>)spCart;
						List<OrderBVO> orderBList = new ArrayList<OrderBVO>();
						OrderBVO orderBVO;
						for (GemVO gemVO : gemList) {
							orderBVO = new OrderBVO();
							orderBVO.setPrice(gemVO.getRetail_price());
							orderBVO.setGem_id(gemVO.getId());
							orderBVO.setQuantity(CommonUtils.isNull(gemVO.getVdef1()) ? 0 : Integer.valueOf(gemVO.getVdef1()));
							orderBVO.setOrder_id(orderId);
							orderBVO.setTs(DateUtil.getCurTimestamp());
							orderBVO.setDr(IConstant.SHORT_ZERO);
							orderBList.add(orderBVO);
						}
						gemService.saveOrderBVORelID(orderBList);
					}
				}
				gemService.delShoppingCarByUname(uname+"");
			} catch (Exception e) {
				e.printStackTrace();
			}
			//*************将订单 号 和总价格存在 session中********************
			Map map = new HashMap();
			//orderVO.setTotalPrice(0.1);
			map.put("totalPrice", orderVO.getTotalPrice());
			map.put("orderCode", orderNo);
			session.setAttribute("sOrderMap", map);
		}
		
		
		String zhifu = orderVO.getZhifu();
		String mrType = orderVO.getMrType();
		String forw = "";
		if("1".equals(zhifu)){  //支付宝支付
			if("pc".equals(mrType)){ //PC端扫码支付
				forw = "redirect:alipayURL.do?orderNo="+orderNo+"&totalPrice="+orderVO.getTotalPrice();
			}else{
				Map<String,String> sParaTemp = new HashMap<String,String>();
				sParaTemp.put("payment_type", "1");
				sParaTemp.put("out_trade_no", orderNo);
				sParaTemp.put("subject", "订单："+orderNo);
				sParaTemp.put("body", "");
				sParaTemp.put("total_fee", orderVO.getTotalPrice()+"");
				String url = AlipayService.create_direct_pay_by_phone(sParaTemp);
			    model.addAttribute("url", url);
				return "/client/gem/order-alipaysuccess";
			}
			
		}else if("2".equals(zhifu)){ //微信支付
			if("pc".equals(mrType)){
				//PC端扫码支付
				//扫码支付
			    WxPayDto tpWxPay1 = new WxPayDto();
			    tpWxPay1.setBody("商品信息");
			    tpWxPay1.setOrderId(orderNo);
			    tpWxPay1.setSpbillCreateIp(WebUtils.getIpAddr(request));
			    tpWxPay1.setTotalFee(orderVO.getTotalPrice()+"");
				String codeurl=WXPayUtil.getCodeurl(tpWxPay1,IConstant.WXSSPAYSUCCESSURL);
				Map map = new HashMap();
				map.put("totalPrice", orderVO.getTotalPrice());
				map.put("orderCode", orderNo);
				map.put("code_url", codeurl);
				session.setAttribute("pcwxOrderMap", map);
				forw = "redirect:orderSuc.do";
			}else if("mobile".equals(mrType)){
				String code = GetWeiXinCode.getCodeRequest();
				forw = "redirect:"+code;
			}
		}
		
		return forw;
	}
	
	
	/**    
	* 生成二维码图片并直接以流的形式输出到页面    
	* @param code_url    
	* @param response    
	*/
	 @RequestMapping("qr_code")
	 @ResponseBody
	 public void getQRCode(String code_url,HttpServletResponse response){
		GenerateQrCodeUtil.encodeQrcode(code_url, response);
	}
	  
	
	   
	 /**
		 * @Description: 宝石订单列表
		 * @param @param model
		 * @param @param response
		 * @param @param request
		 * @param @return
		 * @return String
		 */
		@RequestMapping(value="viewOrderList")
		public String viewOrderList(Model model,HttpServletRequest request,HttpServletResponse response,
				Integer dgpage,String startDate,String endDate,String typeNo){
			
			//当前本地化语言
			String lang = WebUtils.getLang(request);
			System.out.println("Loc Lang："+lang);
			//根据本地语言更新页面数据
			GemClientPageModel.getCListPageModel(model,lang);
			Integer total = gemService.getListSizeOrder(startDate,endDate,typeNo);
			if(dgpage == null){
				dgpage = this.dgpage;
			}
			model.addAttribute("dgpage", dgpage);
			model.addAttribute("rows", rows);
			List<OrderVO> list = gemService.getOrderVO(dgpage,rows,startDate,endDate,typeNo);
			model.addAttribute("list",list);
			model.addAttribute("total",total);
			return "/admin/gem/order-list";
		}
		
		/**
		 * 模糊查询宝石订单
		 * @param model
		 * @param request
		 * @param response
		 * @param dgpage
		 * @param startDate
		 * @param endDate
		 * @param typeNo
		 * @return
		 */
		@RequestMapping(value="viewOrderListBytype")
		public String viewOrderListBytype(Model model,HttpServletRequest request,HttpServletResponse response,
				Integer dgpage,String startDate,String endDate,String typeNo){
			
			//当前本地化语言
			String lang = WebUtils.getLang(request);
			System.out.println("Loc Lang："+lang);
			//根据本地语言更新页面数据
			GemClientPageModel.getCListPageModel(model,lang);
			Integer total = gemService.getListSizeOrder(startDate,endDate,typeNo);
			if(dgpage == null){
				dgpage = this.dgpage;
			}
			model.addAttribute("dgpage", dgpage);
			model.addAttribute("rows", rows);
			List<OrderVO> list = gemService.getOrderVOBytype(dgpage,total,startDate,endDate,typeNo);
			model.addAttribute("list",list);
			model.addAttribute("total",total);
			return "/admin/gem/order-list";
		}
		
		/**
		 * @Description:根据id 修改快递单号，发货时间
		 * @param @param model
		 * @param @param response
		 * @param @param request
		 * @param @return
		 * @return String
		 */
		@RequestMapping(value="updateShippingDateById")
		public void updateShippingDateById(Model model,HttpServletRequest request,HttpServletResponse response,
				Integer dgpage,Integer id,String shippingDate,String shippingNo){
			
			//当前本地化语言
			String lang = WebUtils.getLang(request);
			System.out.println("Loc Lang："+lang);
			//根据本地语言更新页面数据
			GemClientPageModel.getCListPageModel(model,lang);
			if(!CommonUtils.isNull(shippingDate)){
				gemService.selOrderVOById(id,shippingDate,shippingNo);
			}
			
			renderText("{\"msg\":\"Y\"}");
		}
		
		
		/**
		 * @Description: 根据订单id 删除订单
		 * @param @param 如果订单为未付款，可以删除
		 * @param @param response
		 * @param @param request
		 * @param @return
		 * @return String
		 * @throws Exception 
		 */
		@RequestMapping(value="delOrderListById")
		public String delOrderListById(Model model,HttpServletResponse response,HttpServletRequest request,Integer id){
			//当前本地化语言
			String lang = WebUtils.getLang(request);
			System.out.println("Loc Lang："+lang);
			//根据本地语言更新页面数据
			GemClientPageModel.getCOrderPayPageModel(model,lang);
			gemService.delOrderVOById(id);
			return "redirect:viewOrderList.do";
		}
	
	/**
	 * @Description: 立即支付user.jsp 
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="insPay")
	public String insPay(HttpServletResponse response,HttpServletRequest request,Model model,String zhifu,String mrType,String orderno,String totalPrice){
		//*************将订单 号 和总价格存在 session中********************
		Map map = new HashMap();
		//orderVO.setTotalPrice(0.1);
		map.put("totalPrice", totalPrice);
		map.put("orderCode", orderno);
		session.setAttribute("sOrderMap", map);
		
		String forw = "";
		if("1".equals(zhifu)){
			//支付宝支付
			if("pc".equals(mrType)){
				if("pc".equals(mrType)){ //PC端扫码支付
					forw = "redirect:alipayURL.do?orderNo="+orderno+"&totalPrice="+totalPrice;
				}else{
					Map<String,String> sParaTemp = new HashMap<String,String>();
					sParaTemp.put("payment_type", "1");
					sParaTemp.put("out_trade_no", orderno);
					sParaTemp.put("subject", "订单："+orderno);
					sParaTemp.put("body", "");
					sParaTemp.put("total_fee", totalPrice+"");
					String url = AlipayService.create_direct_pay_by_phone(sParaTemp);
				    model.addAttribute("url", url);
					return "/client/gem/order-alipaysuccess";
				}
			}
			
		}else if("2".equals(zhifu)){
			if("pc".equals(mrType)){
				//PC端扫码支付
				//扫码支付
			    WxPayDto tpWxPay1 = new WxPayDto();
			    tpWxPay1.setBody("商品信息");
			    tpWxPay1.setOrderId(orderno);
			    tpWxPay1.setSpbillCreateIp(WebUtils.getIpAddr(request));
			    tpWxPay1.setTotalFee(totalPrice);
				String codeurl=WXPayUtil.getCodeurl(tpWxPay1,IConstant.WXSSPAYSUCCESSURL);
				Map hmap = new HashMap();
				hmap.put("totalPrice", totalPrice);
				hmap.put("orderCode", orderno);
				hmap.put("code_url", codeurl);
				session.setAttribute("pcwxOrderMap", hmap);
				forw = "redirect:orderSuc.do";
			}else if("mobile".equals(mrType)){
				String code = GetWeiXinCode.getCodeRequest();
				forw = "redirect:"+code;
			}
		}
		
		return forw;
	}
	
	/**88888888888888
	 * @Description: 根据订单号 改写订单状态
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="rewriteOrderStatus")
	public void rewriteOrderStatus(Model model,HttpServletResponse response,HttpServletRequest request,String orderno){
		if(orderno != null){
			gemService.rewriteOrderStatus(orderno);
		}
		renderText("{\"msg\":\"Y\"}");//8888888888888888888888888888888888888888
	}
	
	/**88888888888888
	 * @Description: 跳转订单 成功界面
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="goOrderPay")
	public String goOrderPay(Model model,HttpServletResponse response,HttpServletRequest request,String orderno,String totalPrice){
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCOrderPayPageModel(model,lang);
		if(orderno != null){
		 model.addAttribute("orderno");
		}
		if(totalPrice != null){
			 model.addAttribute("totalPrice");
		}
		return IClientForward.gemOrderPay;
	}
	
	/**
	 * @Description: 根据优惠码 获取优惠价格
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="getcouppon")
	public void getcouppon(HttpServletResponse response,HttpServletRequest request,String code){
		String coup = HttpTools.getDataByURL(IConstant.getCoupponURL+"?code="+code);
		/*return "redirect:"+coup.toString();*/
		renderText(coup);
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
	 * @Description: 查询 我的订单
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="selMyOrder")
	public String selMyOrder(Model model,HttpServletResponse response,HttpServletRequest request){
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCOrderPayPageModel(model,lang);
		String uname = (String)session.getAttribute(IConstant.SESSIONUSERNAEM);
		List<OrderVO> orderList = gemService.getOrderByUname(uname);
		Integer num = gemService.getOrderNoByUname(uname);
		model.addAttribute("num",num);
		model.addAttribute("orderList",orderList);
		return IClientForward.gemUser;
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
	public String login(Model model,HttpServletResponse response,HttpServletRequest request,String dengluNUM){
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCLoginPageModel(model,lang);
		model.addAttribute("dengluNo",dengluNUM);
		
		// 为微信扫一扫创造条件
		String sessionId = session.getId();
		WXUtil.setBoolean(sessionId, "N");
		QrCodeUtil.createCode(sessionId, servletContext);
		String url = sessionId + ".jpg";
		model.addAttribute("qrname", url);
		String ua = request.getHeader("user-agent").toLowerCase();
		if (ua.indexOf("micromessenger") > 0) {// 是微信浏览器
			session.setAttribute("isweixin", "Y");
		} else {
			session.setAttribute("isweixin", "N");
		}
		
		return IClientForward.gemLogin;
	}
	
	/**
	 * @Description: 登录成功
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="loginSuccess")
	@ResponseBody
	public String loginSuccess(Model model,HttpServletRequest request,HttpServletResponse response,String uname,String upwd,String status){
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCListPageModel(model,lang);	
		String msg = HttpTools.submitPost(IConstant.loginURL,"uname="+uname+"&upwd="+upwd)+"";
		//登录成功后将用户名存在session中
		request.getSession().setAttribute(IConstant.SESSIONUSERNAEM, uname);
		return msg;
		//renderText(msg);
	}
	
	/**
	 * 判断微信是否扫一扫
	 * 
	 * @return
	 */
	@Deprecated
	@RequestMapping("wxsslogin")
	public void WSSSLogin(HttpServletRequest request) {
		Object bisb = request.getSession().getAttribute("bisBis");
		if("Y".equals(bisb)){
			renderText("Y");
		}else{
			renderText("N");
		}
	}
	
	/**
	 * @Description: 企业号注册后商家登录
	 * @param @param model
	 * @param @param request
	 * @param @param response
	 * @param @param uname
	 * @param @param upwd
	 * @param @param status
	 * @param @return
	 * @return String
	 */
	@OAuthRequired
	@RequestMapping(value="wxlogin")
	public String loginByWx(Model model,HttpServletRequest request,HttpServletResponse response,String typegem,String shapegem,String fromWeight,String toWeight,String fromPrice,String toPrice,
			String inwhere,String inwheres){
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCListPageModel(model,lang);	
		
		//微信授权登录获取信息
		Object objUid = session.getAttribute("loginInfo");
		if(objUid != null){
			//登录成功后将用户名存在session中
			request.getSession().setAttribute(IConstant.SESSIONUSERNAEM, ((LoginVO)objUid).getUserId());
			//标记是否为商户
			request.getSession().setAttribute("bisBis", "Y");
			model.addAttribute("uname", "WxLogin");
		}
		System.out.println("是否商户："+request.getSession().getAttribute("bisBis"));
		System.out.println("当前登录的商户是："+request.getSession().getAttribute(IConstant.SESSIONUSERNAEM));
		Integer gemNo = gemService.getListSizeGem(typegem, shapegem, fromWeight, toWeight, fromPrice, toPrice, inwhere, inwheres);
		model.addAttribute("gemNo",gemNo);
		return "/client/gem/list";
	}
	
	@RequestMapping(value="test")
	public String testWarn(){
		return "/client/warn";
	}
	
	/**
	 * @Description: 忘记密码
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="forgetpwd")
	@ResponseBody
	public String forgetpassword(Model model,HttpServletRequest request,HttpServletResponse response,String email){
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCListPageModel(model,lang);	
		String msg = HttpTools.submitPost(IConstant.forgetPwdURL,"email="+email)+"";
		return msg;
	}
	
	/**
	 * @Description: 注销
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="logout")
	public String logout(Model model,HttpServletRequest request,HttpServletResponse response,String uname){
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCListPageModel(model,lang);		
		request.getSession().removeAttribute(IConstant.SESSIONUSERNAEM);
		request.getSession().removeAttribute("bisBis");
		model.addAttribute("uname", "NLogin");
		return "/client/gem/list";
		//renderText(msg);
	}
	
	/**
	 * 添加到收藏夹
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="favorite")
	public void favorite(Model model,HttpServletRequest request,HttpServletResponse response,Integer gemid){
		Cookie cookie = new Cookie(gemid+"", gemid+"");
        cookie.setMaxAge(30000);// 设置为30min
        cookie.setPath("/");
        System.out.println(gemid+""+"Cookie已添加===============");
        response.addCookie(cookie);
        renderText("{\"msg\":\"Y\"}");
       
	}
	
    /**
     * 点击删除收藏夹 中选中的商品
     * @param request
     * @param response
     * @param gemid
     */
    @RequestMapping("removeCookie")
    public void removeCookie(HttpServletRequest request,HttpServletResponse response,String gemid){
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
            System.out.println("没有cookie==============");
        } else {
            for(Cookie cookie : cookies){
            	if(!"".equals(cookie.getName())){
                	if(cookie.getName().equals(gemid+"")){
                    cookie.setValue(null);
                    cookie.setMaxAge(0);// 立即销毁cookie
                    cookie.setPath("/");
                    System.out.println("被删除的cookie名字为:"+cookie.getName());
                    response.addCookie(cookie);
                }
            }
         }
         renderText("{\"msg\":\"Y\"}");
      }
    }
	
	/**
	 * 显示收藏夹
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="showCookies")
	public void showCookies(Model model,HttpServletRequest request,HttpServletResponse response){
		Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
		List<GemVO> listVo = new ArrayList<GemVO>();
        if (null==cookies) {
            System.out.println("没有cookie=========");
        } else {
        	String ids = "";
            for(Cookie cookie : cookies){
                System.out.println("name:"+cookie.getName()+",value:"+ cookie.getValue());
                if(!"".equals(cookie.getName())){
                	if(cookie.getName().equals(cookie.getValue())){
                		ids += cookie.getValue()+",";
                	}
                }
            }
            if(!"".equals(ids)){
            	ids = ids.substring(0, ids.length()-1);
            	try {
            		listVo = gemService.getGemByCookie(ids);
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        }
        renderJson(listVo);
	}
	
	/**
	 * @Description: 登录成功后显示首页，并查询该用户的购物车
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="goToList")
	public String goToList(Model model,HttpServletRequest request,HttpServletResponse response,String uname){
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCListPageModel(model,lang);	
		Integer num = 0;
		try {
			num = gemService.getShoppingCarNumByUname(uname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("carNum",num);
		model.addAttribute("uname", uname);
		return "/client/gem/list";
	}
	
	
	
	/**
	 * @Description: 注册成功
	 * @param @param model
	 * @param @param response
	 * @param @param request
	 * @param @return regauthcode 后台生成的验证码
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
	
	/**
	 * 11.将图片文件夹传到360页面
	 * @param model
	 * @param response
	 * @param request
	 * @return
	 */
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
			int width = 80; // 宽度
			int height = 25;// 高度
			int codeCount = 4;// 验证码字符个数
			char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
					'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
					'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5',
					'6', '7', '8', '9' };

			BufferedImage buffImg = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = buffImg.createGraphics();
			// 创建一个随机数生成器类
			Random random = new Random();
			// 将图像填充为白色
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, width, height);
			// 创建字体，字体的大小应该根据图片的高度来定."Times New Roman"/Fixedsys, Font.PLAIN, 20
			Font font = new Font("Fixedsys", Font.PLAIN, 20);
			// 设置字体。
			g.setFont(font);
			// 画边框。
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, width - 1, height - 1);
			// 随机产生160(i<160)条干扰线，使图象中的认证码不易被其它程序探测到。
			g.setColor(Color.BLACK);
			for (int i = 0; i < 20; i++) {
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				int xl = random.nextInt(12);
				int yl = random.nextInt(12);
				g.drawLine(x, y, x + xl, y + yl); // 线条数
			}
			// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
			StringBuffer randomCode = new StringBuffer();
			int red = 0, green = 0, blue = 0;
			// 随机产生codeCount数字的验证码。
			for (int i = 0; i < codeCount; i++) {
				// 得到随机产生的验证码数字。
				String strRand = String
						.valueOf(codeSequence[random.nextInt(36)]);
				// 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
				red = random.nextInt(255);
				green = random.nextInt(255);
				blue = random.nextInt(255);
				// 用随机产生的颜色将验证码绘制到图像中。
				g.setColor(new Color(red, green, blue));
				g.drawString(strRand, (i + 1) * (width / (codeCount + 1)),
						height - 4);
				// 将产生的四个随机数组合在一起。
				randomCode.append(strRand);
			}
			// 将四位数字的验证码保存到Session中。
			HttpSession session = request.getSession();
			session.setAttribute("validateCode", randomCode.toString());
			// 禁止图像缓存。
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/jpeg");

			// 将图像输出到Servlet输出流中。
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
	
	
	
//----------------------------------test JVR start-------------------------------
/*	*//**
	 * 	
	 * @param model
	 * @param response
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value="goJvr")
	public String goJvr(Model model,HttpServletResponse response,HttpServletRequest request){
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCOrderPayPageModel(model,lang);
		String codeurl="http://cj.bavlo.com/down.myapp.com/JVR.apk";
		model.addAttribute("code_url", codeurl);
		return "/client/jvr";
	}	
	
	@RequestMapping(value="goJvr1")
	public String goJvr1(Model model,HttpServletResponse response,HttpServletRequest request){
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		GemClientPageModel.getCOrderPayPageModel(model,lang);
		String codeurl="http://cj.bavlo.com/down.myapp.com/JVR.apk";
		model.addAttribute("code_url", codeurl);
		return "/client/jvr1";
	}	*/
	
/*	*//**    
	* 生成二维码图片并直接以流的形式输出到页面    
	* @param code_url    
	* @param response    
	*//*
	 @RequestMapping("jvr_code")
	 @ResponseBody
	 public void getJvrCode(String code_url,HttpServletResponse response){
		GenerateQrCodeUtil.encodeQrcode(code_url, response);
	}*/

//------------------------------test JVR end-----------------------------------------
	
	
	
	
}
