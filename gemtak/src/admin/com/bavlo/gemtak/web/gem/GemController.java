package com.bavlo.gemtak.web.gem;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bavlo.gemtak.model.gem.GemVO;
import com.bavlo.gemtak.service.gem.itf.IGemService;
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
@RequestMapping(value="gemAdmin")
public class GemController extends BaseController {
	
	@Resource
	IGemService gemService;
	
	/**
	 * @Description: ������ҳ
	 * @param @param model
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value="viewGemList")
	public String viewGemList(Model model,HttpServletRequest request,HttpServletResponse response){
		//��ǰ���ػ�����
		String lang = WebUtils.getLang(request);
		System.out.println("�������ԣ�"+lang);
		//���ݱ������Ը���ҳ������
		getListPageModel(model,lang);
		
		return "/admin/gem/gem-list";
	}
	
	/**
	 * @Description: ������ʯ
	 * @param @param model
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @return String
	 */
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
	 * @Description: ����gemVO
	 * @param @param model
	 * @param @param lang
	 * @return void
	 */
	@RequestMapping(value="saveOrUpdate")
	private String saveOrupdateGemVO(Model model,HttpServletRequest request,HttpServletResponse response,GemVO gemVO) {
		try {
			gemService.saveOrupdateGemVO(gemVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/client/gem/list.jsp";
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
