package com.bavlo.gemtak.web.gem;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.constant.page.AGemListLang;
import com.bavlo.gemtak.model.gem.EquipmentVO;
import com.bavlo.gemtak.model.gem.GemVO;
import com.bavlo.gemtak.model.gem.LinkmanVO;
import com.bavlo.gemtak.service.gem.itf.IGemService;
import com.bavlo.gemtak.utils.CommonUtils;
import com.bavlo.gemtak.utils.PageLangUtil;
import com.bavlo.gemtak.utils.SelectUtil;
import com.bavlo.gemtak.utils.StringUtil;
import com.bavlo.gemtak.utils.WebUtils;
import com.bavlo.gemtak.web.BaseController;
import com.bavlo.gemtak.weixin.qy.interceptor.OAuthRequired;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: GemController 
 * @Description: 宝石控制器
 * @author liuzy
 * @date 2016-1-26 下午02:59:13
 */
@Controller("gemController")
@RequestMapping(value="gemAdmin")
public class GemController extends BaseController {
	
	@Resource
	IGemService gemService;
	private Object LoginVO;
	
	/**
	 * @Description: 校验有效用户
	 * @param @return
	 * @return Boolean
	 */
	public Boolean checkU(){
		Object objUid = session.getAttribute("loginInfo");
		if(objUid != null){
			return false;
		}
		return true;
	}
	
	/**
	 * 1. 管理首页
	 * @param model
	 * @param request
	 * @param response
	 * @param dgpage
	 * @param allgem
	 * @param typegem
	 * @param shapegem
	 * @param inputgem
	 * @return
	 * OAuthRequired 配置注解 （开放授权）
	 */
	@OAuthRequired
	@RequestMapping(value="viewGemList")
	public String viewGemList(Model model,HttpServletRequest request,HttpServletResponse response,Integer dgpage,String allgem,String typegem,String shapegem,String inputgem){
		/*if(checkU()){
			return "/admin/warn";
		}*/
		
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("本地语言："+lang);
		//根据本地语言更新页面数据
		getListPageModel(model,lang);
		
		/**数据查询-start**/
		//当前的条件根据登录商户的微信号来查  supplier='"+uid+"'
		//微信授权登录获取信息
		Object objUid = session.getAttribute("loginInfo");
		if(objUid != null){
			String uid = ((com.bavlo.gemtak.model.LoginVO) objUid).getUserId();
			System.out.println("当前登录的用户是："+uid);
			StringBuilder sql = new StringBuilder(" supplier='"+uid+"'");
			if(!("A".equals(allgem) || CommonUtils.isNull(allgem))){
				sql.append( "  and  is_release = '"+allgem+"'");
			}
			if(!("-1".equals(typegem) || CommonUtils.isNull(typegem))){
				sql.append( " and type_id = '"+typegem+"'");
			}
			if(!("-1".equals(shapegem) || CommonUtils.isNull(shapegem))){
				sql.append(" and shape_id = '"+shapegem+"'");
			}
			if(StringUtil.isNotEmpty(inputgem)){
				sql.append(" and ( is_release like '%"+inputgem+"%' or type_id like '%"+inputgem+"%' or shape_id like '%"+inputgem+"%')");
			}
			//逻辑处理
			Integer total = gemService.getListSizeGem(sql+"");
			if(dgpage == null){
				dgpage = this.dgpage;
			}
			List<GemVO> gems = gemService.findListGem(sql+"",dgpage,rows,null,null);
			
			model.addAttribute("gems",gems);
			model.addAttribute("total",CommonUtils.roundByNum(total,rows)); //CommonUtils类中 根据总数 当前页面大小获取总页数
		}
		/**数据查询-end**/
		
		
		/*StringBuilder sql = new StringBuilder();
		if(!("A".equals(allgem) || CommonUtils.isNull(allgem))){
			sql.append( "  and  is_release = '"+allgem+"'");
		}
		if(!("-1".equals(typegem) || CommonUtils.isNull(typegem))){
			sql.append( " and type_id = '"+typegem+"'");
		}
		if(!("-1".equals(shapegem) || CommonUtils.isNull(shapegem))){
			sql.append(" and shape_id = '"+shapegem+"'");
		}
		if(StringUtil.isNotEmpty(inputgem)){
			sql.append(" and ( is_release like '%"+inputgem+"%' or type_id like '%"+inputgem+"%' or shape_id like '%"+inputgem+"%')");
		}
		//逻辑处理
		Integer total = gemService.getListSizeGem(sql+"");
		if(dgpage == null){
			dgpage = this.dgpage;
		}
		List<GemVO> gems = gemService.findListGem(sql+"",dgpage,rows,null,null);
		
		model.addAttribute("gems",gems);
		model.addAttribute("total",CommonUtils.roundByNum(total,rows)); //CommonUtils类中 根据总数 当前页面大小获取总页数
*/
		return "/admin/gem/gem-list";
	}
	
	/**
	 *2. 根据条件获取宝石列表数据
	 */
	@Deprecated
	@RequestMapping(value="getGemListByWh")
	public void getGemListByWh(Model model,HttpServletRequest request,HttpServletResponse response,Integer dgpage,String allgem,String typegem,String shapegem,String inputgem){
		Object objUid = session.getAttribute("loginInfo");
		if(objUid != null){
			String uid = ((com.bavlo.gemtak.model.LoginVO) objUid).getUserId();
			System.out.println("当前登录后，依据条件查询用户是："+uid);
			StringBuilder sql = new StringBuilder(" supplier='"+uid+"'");
			if(!("A".equals(allgem) || CommonUtils.isNull(allgem))){
				sql.append( "  and  is_release = '"+allgem+"'");
			}else if(!("-1".equals(typegem) || CommonUtils.isNull(allgem))){
				sql.append( " and type_id = '"+typegem+"'");
			}else if(!("-1".equals(shapegem) || CommonUtils.isNull(allgem))){
				sql.append(" and shape_id = '"+shapegem+"'");
			}else if(StringUtil.isNotEmpty(inputgem)){
				sql.append(" and ( is_release like '%"+inputgem+"%' or type_id like '%"+inputgem+"%' or shape_id like '%"+inputgem+"%')");
			}
			//逻辑处理
			Integer total = gemService.getListSizeGem(sql+"");
			List<GemVO> gems = gemService.findListGem(sql+"",dgpage,rows,null,null);
			
			renderJson(gems);
		}
		
		/*Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("items", gems);
		jsonMap.put("total", total);
		renderJson(jsonMap);*/
	}
	
	/**
	 * @Description:新增宝石
	 * @param @param model
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @return String
	 *//*
	@RequestMapping(value="addGem")
	public String insertGem(Model model,HttpServletRequest request,HttpServletResponse response){
		if(checkU()){
			return "/admin/warn";
		}
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		getCardPageModel(model,lang);
		
		return "/admin/gem/gem-card";
	}*/
	
	/**
	 * 3.点击宝石入库 根据gemid查询出一条宝石信息  跳转gem-card.jsp 
	 * @Description:
	 * @param @param model
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="updateGem")
	public String updateGem(Model model,HttpServletRequest request,HttpServletResponse response,String gemid){
		/*if(checkU()){
			return "/admin/warn";
		}*/
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		getCardPageModel(model,lang);
		GemVO gem = gemService.findGemVOByID(Integer.valueOf(gemid));
		model.addAttribute("gem",gem);
		List<EquipmentVO> list = gemService.getSupplier();
		model.addAttribute("list", list);
		return "/admin/gem/gem-card";
	}
	
	/**
	 * 4.修改gemVO的方法
	 * @Description: 
	 * @param @param GemVO 
	 * @param @param lisuike
	 * @return void
	 */
	@RequestMapping(value="saveOrUpdate")
	public String saveOrupdateGemVO(Model model,HttpServletRequest request,HttpServletResponse response,GemVO gemVO) {
		/*if(checkU()){
			return "/admin/warn";
		}*/
		try {
			gemService.updateGemVO(gemVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/admin/gem/gem-list";
	}
	
	
	
	/**
	 * 5.查询出所有gemVO
	 * @Description: 
	 * @param @param List<GemVO>
	 * @param @param lisuike
	 * @return void
	 */
	@RequestMapping(value="findAllGemVO")
	public String findAllGemVO(Model model) {
		if(checkU()){
			return "/admin/warn";
		}
		List<GemVO> gems = gemService.findAllGemVO();
		model.addAttribute("gems", gems);
		return "/admin/gem/gem-list";
	}
	
	/**
	 * 6.点击删除按钮，更新DR字段为1
	 * @Description: TODO(点击删除按钮，更新DR字段为1) 
	 * @param @param id
	 * @param @param dr
	 * @return void
	 */
	@RequestMapping(value="updateDrGemById")
	public void updateDrGemById(HttpServletRequest request,Model model,Integer id,String st){
		try {
			gemService.updateDrGemById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		renderText("{\"mess\":\"Y\",\"id\":\""+id+"\"}");
	}
	
	
	/**
	 * 7.点击发布按钮 将其改为关闭
	 * @Description: 给据id查询出一条gemVO 
	 * @param @param GemVO
	 * @param @param lisuike
	 * @return void
	 */
	@RequestMapping(value="findGemVOByID")
	public void findGemVOByID(HttpServletRequest request,Model model,Integer id,String st) {
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//按钮显示
		String btnName = AGemListLang.LT_GEM_CLOSE_CN;//关闭
		//操作提示
		String warName = AGemListLang.LT_GEM_RELEASE_CN;//发布
		//返回状态
		String bkst = st;
		if(!IConstant.RELEASE_C.equals(st)){
			bkst = IConstant.RELEASE_C; //已关闭
			if(IConstant.EN_UK.equals(lang)){
				btnName = AGemListLang.LT_GEM_RELEASE_EN;//发布
				warName = AGemListLang.LT_GEM_CLOSE_EN;//关闭
			}else{
				btnName = AGemListLang.LT_GEM_RELEASE_CN;//发布
				warName = AGemListLang.LT_GEM_CLOSE_CN;//关闭
			}
		}else{
			bkst = IConstant.RELEASE_Y; //已发布
			if(IConstant.EN_UK.equals(lang)){
				btnName = AGemListLang.LT_GEM_CLOSE_EN;//关闭
				warName = AGemListLang.LT_GEM_RELEASE_EN;//发布
			}else{
				btnName = AGemListLang.LT_GEM_CLOSE_CN;//关闭
				warName = AGemListLang.LT_GEM_RELEASE_CN;//发布
			}
		}
		try {
			gemService.updateGemById(id,st);
		} catch (Exception e) {
			e.printStackTrace();
			renderText("{\"msg\":\"N\",\"id\":\""+id+"\",\"warName\":\""+warName+"\"}");
		}
		renderText("{\"msg\":\"Y\",\"id\":\""+id+"\",\"btnNm\":\""+btnName+"\",\"warName\":\""+warName+"\",\"bkst\":\""+bkst+"\"}");
	}
	
	/**
	 * @Description: 根据本地语言获取Card页面数据
	 * @param @param model
	 * @param @param lang
	 * @param @return
	 * @return Model
	 */
	public void getCardPageModel(Model model,String lang){
		//页面BodyVO
		model.addAttribute("pagevo", PageLangUtil.getAGemCardBodyPageVO(lang));
		//页面HeadFootVO
		model.addAttribute("pagehfvo", PageLangUtil.getAGemCardHeadFootPageVO(lang));
		
		//宝石类型
		model.addAttribute("listGemType", SelectUtil.getListGemType(lang));
		//宝石形状
		model.addAttribute("listGemShape", SelectUtil.getListGemShape(lang));
		//宝石切工
		model.addAttribute("listGemCut", SelectUtil.getListGemCut(lang));
		//宝石净度
		model.addAttribute("listGemClarity", SelectUtil.getListGemClarity(lang));
		//宝石产地
		model.addAttribute("listGemOrigin", SelectUtil.getListGemOrigin(lang));
		//宝石处理工艺
		model.addAttribute("listGemTreatment", SelectUtil.getListGemTreatment(lang));
		//宝石证书
		model.addAttribute("listGemLab", SelectUtil.getListGemLab(lang));
		
	}
	
	/**
	 * @Description: 根据本地语言获取List页面数据
	 * @param @param model
	 * @param @param lang
	 * @return void
	 */
	private void getListPageModel(Model model, String lang) {
		//页面中间BodyVO
		model.addAttribute("pagevo", PageLangUtil.getAGemListBodyPageVO(lang));
		//页面表头、表尾HeadFootVO
		model.addAttribute("pagehfvo", PageLangUtil.getAGemCardHeadFootPageVO(lang));
		//宝石类型
		model.addAttribute("listGemType", SelectUtil.getListGemType(lang));
		//宝石形状
		model.addAttribute("listGemShape", SelectUtil.getListGemShape(lang));
	}

	
	
//------------------------------------------宝石供应商管理--------------------------------------------------
	@RequestMapping("viewSupplier")
	public String viewSupplier(Model model,HttpServletRequest request,HttpServletResponse response){
		List<EquipmentVO> list = gemService.getSupplier();
		model.addAttribute("list", list);
		/*List<LinkmanVO> linkmanList = gemService.getLinkman();
		model.addAttribute("linkmanList", linkmanList);*/
		return "/admin/gem/supplier_management";
	}
	
	@RequestMapping("addSupplier")
	public String addSupplier(Model model,HttpServletRequest request,HttpServletResponse response,Integer id){
		if(id!=null){
			EquipmentVO equipment=gemService.getEquipmentByid(id);
			model.addAttribute("equipment", equipment);
		}
		return "/admin/gem/addSupplier";
	}
	
	@RequestMapping("saveSupplier")
	public void saveSupplier(Model model,HttpServletRequest request,HttpServletResponse response,EquipmentVO equipment){
		gemService.saveSupplier(equipment);
		//return "redirect:viewSupplier.do";
		renderText("{\"msg\":\"Y\"}");
	}
	
	@RequestMapping("delSupplier")
	public void delSupplier(Model model,HttpServletRequest request,HttpServletResponse response,Integer id){
		gemService.delSupplier(id);
		renderText("{\"msg\":\"Y\"}");
	}
	
	@RequestMapping("addLinkman")
	public String addLinkman(Model model,HttpServletRequest request,HttpServletResponse response,Integer id,Integer equipmentId){
		if(id!=null){
			LinkmanVO linkman=gemService.getLinkmanByid(id);
			model.addAttribute("linkman", linkman);
		}
		model.addAttribute("equipmentId", equipmentId);
		return "/admin/gem/addLinkman";
	}
	
	@RequestMapping("saveLinkman")
	public void saveLinkman(Model model,HttpServletRequest request,HttpServletResponse response,LinkmanVO linkman){
		gemService.saveLinkman(linkman);
		renderText("{\"msg\":\"Y\"}");
	}
	
	@RequestMapping("viewLinkman")
	public String viewLinkman(Model model,HttpServletRequest request,HttpServletResponse response,Integer id){
		List<LinkmanVO> linkmanList = gemService.getLinkman(id);
		if(linkmanList!=null){
			model.addAttribute("linkmanList", linkmanList);
			model.addAttribute("id", id);
		}
		return "/admin/gem/linkman_management";
	}
	
	@RequestMapping("delLinkman")
	public void delLinkman(Model model,HttpServletRequest request,HttpServletResponse response,Integer id){
		gemService.delLinkman(id);
		renderText("{\"msg\":\"Y\"}");
	}
}
