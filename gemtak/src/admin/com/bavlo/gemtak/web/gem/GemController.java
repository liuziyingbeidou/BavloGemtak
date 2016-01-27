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
 * @Title: ����Gemtak
 * @ClassName: GemController 
 * @Description: ��ʯ������
 * @author liuzy
 * @date 2016-1-26 ����02:59:13
 */
@Controller("gemController")
@RequestMapping(value="gem")
public class GemController extends BaseController {
	
	@RequestMapping(value="viewGemList")
	public String viewGemList(HttpServletRequest request){
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("�������ԣ�"+lang);
		return "/admin/gem/gem-list";
	}
	
	@RequestMapping(value="addGem")
	public String insertGem(Model model,HttpServletRequest request,HttpServletResponse response){
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("�������ԣ�"+lang);
		
		model.addAttribute("pagevo", PageLangUtil.getAGemCardPageVO(lang));
		String rmJson = HttpTools.getDataByURL("http://www.bavlo.com/getAllGemType");
		List<KeyValueVO> listGemType = SelectUtil.getGemType(lang,rmJson);
		model.addAttribute("listGemType", listGemType);
		System.out.println("��ʯ���ͣ�" + rmJson);
		return "/admin/gem/gem-card";
	}
	
	
}
