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
		System.out.println("Loc Lang��"+lang);
		//���ݱ������Ը���ҳ������
		getPageModel(model,lang);
		
		return "/admin/gem/gem-card";
	}
	
	/**
	 * @Description: ���ݱ������Ի�ȡҳ������
	 * @param @param model
	 * @param @param lang
	 * @param @return
	 * @return Model
	 */
	public void getPageModel(Model model,String lang){
		//ҳ��BodyVO
		model.addAttribute("pagevo", PageLangUtil.getAGemCardBodyPageVO(lang));
		//ҳ��HeadVO
		model.addAttribute("pagehvo", PageLangUtil.getAGemCardHeadPageVO(lang));
		//ҳ��FootVO
		model.addAttribute("pagefvo", PageLangUtil.getAGemCardFootPageVO(lang));
		//��ʯ����
		String rmGemTypeJson = HttpTools.getDataByURL(IConstant.URL_GEMTYPE);
		List<KeyValueVO> listGemType = SelectUtil.getGemType(lang,rmGemTypeJson);
		model.addAttribute("listGemType", listGemType);
		
		//��ʯ��״
		String rmGemShapeJson = HttpTools.getDataByURL(IConstant.URL_GEMSHAPE);
		List<KeyValueVO> listGemShape = SelectUtil.getGemShape(lang,rmGemShapeJson);
		model.addAttribute("listGemShape", listGemShape);
		
		//��ʯ�й�
		String rmGemCutJson = HttpTools.getDataByURL(IConstant.URL_GEMCUT);
		List<KeyValueVO> listGemCut = SelectUtil.getGemCut(lang,rmGemCutJson);
		model.addAttribute("listGemCut", listGemCut);
		
		//��ʯ����
		String rmGemClarityJson = HttpTools.getDataByURL(IConstant.URL_GEMCLARITY);
		List<KeyValueVO> listGemClarity = SelectUtil.getGemClarity(lang,rmGemClarityJson);
		model.addAttribute("listGemClarity", listGemClarity);
		
		//��ʯ����
		String rmGemOriginJson = HttpTools.getDataByURL(IConstant.URL_GEMORIGIN);
		List<KeyValueVO> listGemOrigin = SelectUtil.getGemOrigin(lang,rmGemOriginJson);
		model.addAttribute("listGemOrigin", listGemOrigin);
		
		//��ʯ������
		String rmGemTreatmentJson = HttpTools.getDataByURL(IConstant.URL_GEMTREATMENT);
		List<KeyValueVO> listGemTreatment = SelectUtil.getGemTreatment(lang,rmGemTreatmentJson);
		model.addAttribute("listGemTreatment", listGemTreatment);
		
		//��ʯ֤��
		String rmGemLabJson = HttpTools.getDataByURL(IConstant.URL_GEMLAB);
		List<KeyValueVO> listGemLab = SelectUtil.getGemLab(lang,rmGemLabJson);
		model.addAttribute("listGemLab", listGemLab);
		
	}
	
}
