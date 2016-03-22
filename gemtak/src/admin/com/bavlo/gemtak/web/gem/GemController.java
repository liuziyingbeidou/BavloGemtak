package com.bavlo.gemtak.web.gem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.constant.page.AGemListLang;
import com.bavlo.gemtak.model.gem.GemVO;
import com.bavlo.gemtak.service.gem.itf.IGemService;
import com.bavlo.gemtak.utils.CommonUtils;
import com.bavlo.gemtak.utils.PageLangUtil;
import com.bavlo.gemtak.utils.SelectUtil;
import com.bavlo.gemtak.utils.StringUtil;
import com.bavlo.gemtak.utils.WebUtils;
import com.bavlo.gemtak.web.BaseController;

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
	
	
	/**
	 * @Description: 管理首页
	 * @param @param model
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="viewGemList")
	public String viewGemList(Model model,HttpServletRequest request,HttpServletResponse response,Integer dgpage,String allgem,String typegem,String shapegem,String inputgem){
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("本地语言："+lang);
		//根据本地语言更新页面数据
		getListPageModel(model,lang);
		
		/**数据查询-start**/
		
		//过滤条件
		StringBuilder sql = new StringBuilder(" 1=1");
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
		List<GemVO> gems = gemService.findListGem(sql+"",dgpage,rows);
		
		model.addAttribute("gems",gems);
		model.addAttribute("total",total/rows);
		/**数据查询-end**/
		
		return "/admin/gem/gem-list";
	}
	
	/**
	 * 根据条件获取宝石列表数据
	 */
	@Deprecated
	@RequestMapping(value="getGemListByWh")
	public void getGemListByWh(Model model,HttpServletRequest request,HttpServletResponse response,Integer dgpage,String allgem,String typegem,String shapegem,String inputgem){
		
		StringBuilder sql = new StringBuilder(" 1=1");
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
		List<GemVO> gems = gemService.findListGem(sql+"",dgpage,rows);
		
		renderJson(gems);
		/*Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("items", gems);
		jsonMap.put("total", total);
		renderJson(jsonMap);*/
	}
	
	/**
	 * @Description: 新增宝石
	 * @param @param model
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="addGem")
	public String insertGem(Model model,HttpServletRequest request,HttpServletResponse response){
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		getCardPageModel(model,lang);
		
		return "/admin/gem/gem-card";
	}
	
	/**
	 * @Description: 新增gemVO的方法
	 * @param @param GemVO 
	 * @param @param lisuike
	 * @return void
	 */
	@RequestMapping(value="saveOrUpdate")
	public String saveOrupdateGemVO(Model model,HttpServletRequest request,HttpServletResponse response,GemVO gemVO) {
		try {
			gemService.saveOrupdateGemVO(gemVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/admin/gem/gem-list";
	}
	
	
	
	/**
	 * @Description: 查询出所有gemVO
	 * @param @param List<GemVO>
	 * @param @param lisuike
	 * @return void
	 */
	@RequestMapping(value="findAllGemVO")
	public String findAllGemVO(Model model) {
		
		List<GemVO> gems = gemService.findAllGemVO();
		model.addAttribute("gems", gems);
		return "/admin/gem/gem-list";
	}
	
	/**
	 * 
	 * @Description: TODO(点击删除按钮，更新DR字段为1) 
	 * @param @param id
	 * @param @param dr
	 * @return void
	 */
	@RequestMapping(value="updateDrGemById")
	public void updateDrGemById(Integer id){
		try {
			gemService.updateDrGemById(id);
		} catch (Exception e) {
			e.printStackTrace();
			renderText("{\"msg\":\"N\",\"id\":\""+id+"\"}");
		}
		renderText("{\"msg\":\"Y\",\"id\":\""+id+"\"}");
	}
	
	
	/**
	 * @Description: 给据id查询出一条gemVO 点击发布按钮 将其改为关闭
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
			bkst = IConstant.RELEASE_C;
			if(IConstant.EN_UK.equals(lang)){
				btnName = AGemListLang.LT_GEM_RELEASE_EN;//发布
				warName = AGemListLang.LT_GEM_CLOSE_EN;//关闭
			}else{
				btnName = AGemListLang.LT_GEM_RELEASE_CN;//发布
				warName = AGemListLang.LT_GEM_CLOSE_CN;//关闭
			}
		}else{
			bkst = IConstant.RELEASE_Y;
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
	
	
}
