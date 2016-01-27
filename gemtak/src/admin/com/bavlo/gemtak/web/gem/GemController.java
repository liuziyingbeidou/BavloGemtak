package com.bavlo.gemtak.web.gem;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		System.out.println("本地语言："+lang);
		
		model.addAttribute("pagevo", PageLangUtil.getAGemCardPageVO(lang));
		String rmJson = HttpTools.getDataByURL("http://www.bavlo.com/getAllGemType");
		List<KeyValueVO> listGemType = SelectUtil.getGemType(lang,rmJson);
		model.addAttribute("listGemType", listGemType);
		System.out.println("宝石类型：" + rmJson);
		return "/admin/gem/gem-card";
	}
	
	
}
