package com.bavlo.gemtak.web.ui;

import org.springframework.ui.Model;

import com.bavlo.gemtak.utils.PageLangUtil;
import com.bavlo.gemtak.utils.SelectUtil;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: GemClientPageModel 
 * @Description: PageModel
 * @author liuzy
 * @date 2016-3-10 上午09:53:49
 */
public class GemClientPageModel {

	/**
	 * @Description: 根据本地语言获取List页面数据
	 * @param @param model
	 * @param @param lang
	 * @return void
	 */
	public static void getCListPageModel(Model model, String lang) {
		//页面BodyVO
		//待完善...
		//页面HeadFootVO
		model.addAttribute("pagehfvo", PageLangUtil.getAGemCardHeadFootPageVO(lang));
		
		//宝石类型
		model.addAttribute("listGemType", SelectUtil.getListGemType(lang));
		//宝石形状
		model.addAttribute("listGemShape", SelectUtil.getListGemShape(lang));
		
	}
	
	/**
	 * @Description: 根据本地语言获取List页面数据
	 * @param @param model
	 * @param @param lang
	 * @return void
	 */
	public static void getCDetailePageModel(Model model, String lang) {
		//页面BodyVO
		//待完善...
		//页面HeadFootVO
		model.addAttribute("pagehfvo", PageLangUtil.getAGemCardHeadFootPageVO(lang));
		
		//宝石类型
		model.addAttribute("listGemType", SelectUtil.getListGemType(lang));
		//宝石形状
		model.addAttribute("listGemShape", SelectUtil.getListGemShape(lang));
		
	}
	
	/**
	 * @Description: 根据本地语言获取List页面数据
	 * @param @param model
	 * @param @param lang
	 * @return void
	 */
	public static void getCShoppingCarPageModel(Model model, String lang) {
		//页面BodyVO
		//待完善...
		//页面HeadFootVO
		model.addAttribute("pagehfvo", PageLangUtil.getAGemCardHeadFootPageVO(lang));
		
		//宝石类型
		model.addAttribute("listGemType", SelectUtil.getListGemType(lang));
		//宝石形状
		model.addAttribute("listGemShape", SelectUtil.getListGemShape(lang));
		
	}
	
	/**
	 * @Description: 根据本地语言获取List页面数据
	 * @param @param model
	 * @param @param lang
	 * @return void
	 */
	public static void getCOrderPageModel(Model model, String lang) {
		//页面BodyVO
		//待完善...
		//页面HeadFootVO
		model.addAttribute("pagehfvo", PageLangUtil.getAGemCardHeadFootPageVO(lang));
		
		//宝石类型
		model.addAttribute("listGemType", SelectUtil.getListGemType(lang));
		//宝石形状
		model.addAttribute("listGemShape", SelectUtil.getListGemShape(lang));
		
	}
}
