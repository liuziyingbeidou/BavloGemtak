package com.bavlo.gemtak.web.gem;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.httpclient.HttpTools;
import com.bavlo.gemtak.model.page.KeyValueVO;
import com.bavlo.gemtak.utils.PageLangUtil;
import com.bavlo.gemtak.utils.SelectUtil;
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
@RequestMapping(value="gem")
public class GemController extends BaseController {
	
	@RequestMapping(value="viewGemList")
	public String viewGemList(HttpServletRequest request){
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("本地语言："+lang);
		return "/admin/gem/gem-list";
	}
	
	@RequestMapping(value="addGem")
	public String insertGem(Model model,HttpServletRequest request,HttpServletResponse response){
		//当前本地化语言
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang："+lang);
		//根据本地语言更新页面数据
		getPageModel(model,lang);
		
		return "/admin/gem/gem-card";
	}
	
	/**
	 * @Description: 根据本地语言获取页面数据
	 * @param @param model
	 * @param @param lang
	 * @param @return
	 * @return Model
	 */
	public void getPageModel(Model model,String lang){
		//页面BodyVO
		model.addAttribute("pagevo", PageLangUtil.getAGemCardBodyPageVO(lang));
		//页面HeadVO
		model.addAttribute("pagehvo", PageLangUtil.getAGemCardHeadPageVO(lang));
		//页面FootVO
		model.addAttribute("pagefvo", PageLangUtil.getAGemCardFootPageVO(lang));
		//宝石类型
		String rmGemTypeJson = HttpTools.getDataByURL(IConstant.URL_GEMTYPE);
		List<KeyValueVO> listGemType = SelectUtil.getGemType(lang,rmGemTypeJson);
		model.addAttribute("listGemType", listGemType);
		
		//宝石形状
		String rmGemShapeJson = HttpTools.getDataByURL(IConstant.URL_GEMSHAPE);
		List<KeyValueVO> listGemShape = SelectUtil.getGemShape(lang,rmGemShapeJson);
		model.addAttribute("listGemShape", listGemShape);
		
		//宝石切工
		String rmGemCutJson = HttpTools.getDataByURL(IConstant.URL_GEMCUT);
		List<KeyValueVO> listGemCut = SelectUtil.getGemCut(lang,rmGemCutJson);
		model.addAttribute("listGemCut", listGemCut);
		
		//宝石净度
		String rmGemClarityJson = HttpTools.getDataByURL(IConstant.URL_GEMCLARITY);
		List<KeyValueVO> listGemClarity = SelectUtil.getGemClarity(lang,rmGemClarityJson);
		model.addAttribute("listGemClarity", listGemClarity);
		
		//宝石产地
		String rmGemOriginJson = HttpTools.getDataByURL(IConstant.URL_GEMORIGIN);
		List<KeyValueVO> listGemOrigin = SelectUtil.getGemOrigin(lang,rmGemOriginJson);
		model.addAttribute("listGemOrigin", listGemOrigin);
		
		//宝石处理工艺
		String rmGemTreatmentJson = HttpTools.getDataByURL(IConstant.URL_GEMTREATMENT);
		List<KeyValueVO> listGemTreatment = SelectUtil.getGemTreatment(lang,rmGemTreatmentJson);
		model.addAttribute("listGemTreatment", listGemTreatment);
		
		//宝石证书
		String rmGemLabJson = HttpTools.getDataByURL(IConstant.URL_GEMLAB);
		List<KeyValueVO> listGemLab = SelectUtil.getGemLab(lang,rmGemLabJson);
		model.addAttribute("listGemLab", listGemLab);
		
	}
	
}
