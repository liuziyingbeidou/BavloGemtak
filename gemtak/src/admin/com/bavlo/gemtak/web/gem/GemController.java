package com.bavlo.gemtak.web.gem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String viewGemList(Model model,HttpServletRequest request,HttpServletResponse response){
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("�������ԣ�"+lang);
		//���ݱ������Ը���ҳ������
		getListPageModel(model,lang);
		
		return "/admin/gem/gem-list";
	}
	

	@RequestMapping(value="addGem")
	public String insertGem(Model model,HttpServletRequest request,HttpServletResponse response){
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		getCardPageModel(model,lang);
		
		return "/admin/gem/gem-card";
	}
	
	/**
	 * @Description: ���ݱ������Ի�ȡCardҳ������
	 * @param @param model
	 * @param @param lang
	 * @param @return
	 * @return Model
	 */
	public void getCardPageModel(Model model,String lang){
		//ҳ��BodyVO
		model.addAttribute("pagevo", PageLangUtil.getAGemCardBodyPageVO(lang));
		//ҳ��HeadFootVO
		model.addAttribute("pagehfvo", PageLangUtil.getAGemCardHeadFootPageVO(lang));
		
		//��ʯ����
		model.addAttribute("listGemType", SelectUtil.getListGemType(lang));
		//��ʯ��״
		model.addAttribute("listGemShape", SelectUtil.getListGemShape(lang));
		//��ʯ�й�
		model.addAttribute("listGemCut", SelectUtil.getListGemCut(lang));
		//��ʯ����
		model.addAttribute("listGemClarity", SelectUtil.getListGemClarity(lang));
		//��ʯ����
		model.addAttribute("listGemOrigin", SelectUtil.getListGemOrigin(lang));
		//��ʯ������
		model.addAttribute("listGemTreatment", SelectUtil.getListGemTreatment(lang));
		//��ʯ֤��
		model.addAttribute("listGemLab", SelectUtil.getListGemLab(lang));
		
	}
	
	/**
	 * @Description: ���ݱ������Ի�ȡListҳ������
	 * @param @param model
	 * @param @param lang
	 * @return void
	 */
	private void getListPageModel(Model model, String lang) {
		//ҳ��BodyVO
		model.addAttribute("pagevo", PageLangUtil.getAGemListBodyPageVO(lang));
		//ҳ��HeadFootVO
		model.addAttribute("pagehfvo", PageLangUtil.getAGemCardHeadFootPageVO(lang));
		//��ʯ����
		model.addAttribute("listGemType", SelectUtil.getListGemType(lang));
		//��ʯ��״
		model.addAttribute("listGemShape", SelectUtil.getListGemShape(lang));
	}
}
