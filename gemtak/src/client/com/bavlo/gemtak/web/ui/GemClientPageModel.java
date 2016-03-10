package com.bavlo.gemtak.web.ui;

import org.springframework.ui.Model;

import com.bavlo.gemtak.utils.PageLangUtil;
import com.bavlo.gemtak.utils.SelectUtil;

/**
 * @Title: ����Gemtak
 * @ClassName: GemClientPageModel 
 * @Description: PageModel
 * @author liuzy
 * @date 2016-3-10 ����09:53:49
 */
public class GemClientPageModel {

	/**
	 * @Description: ���ݱ������Ի�ȡ��ҳ��ʯ�б�ҳ������
	 * @param @param model
	 * @param @param lang
	 * @return void
	 */
	public static void getCListPageModel(Model model, String lang) {
		//ҳ��BodyVO
		//������...
		//ҳ��HeadFootVO
		model.addAttribute("pagehfvo", PageLangUtil.getAGemCardHeadFootPageVO(lang));
		
		//��ʯ����
		model.addAttribute("listGemType", SelectUtil.getListGemType(lang));
		//��ʯ��״
		model.addAttribute("listGemShape", SelectUtil.getListGemShape(lang));
		
	}
	
	/**
	 * @Description: ���ݱ������Ի�ȡ��Ʒ��ϸҳ������
	 * @param @param model
	 * @param @param lang
	 * @return void
	 */
	public static void getCDetailePageModel(Model model, String lang) {
		//ҳ��BodyVO
		//������...
		//ҳ��HeadFootVO
		model.addAttribute("pagehfvo", PageLangUtil.getAGemCardHeadFootPageVO(lang));
		
	}
	
	/**
	 * @Description: ���ݱ������Ի�ȡ���ﳵҳ������
	 * @param @param model
	 * @param @param lang
	 * @return void
	 */
	public static void getCShoppingCarPageModel(Model model, String lang) {
		//ҳ��BodyVO
		//������...
		//ҳ��HeadFootVO
		model.addAttribute("pagehfvo", PageLangUtil.getAGemCardHeadFootPageVO(lang));
		
	}
	
	/**
	 * @Description: ���ݱ������Ի�ȡ����ҳ������
	 * @param @param model
	 * @param @param lang
	 * @return void
	 */
	public static void getCOrderPageModel(Model model, String lang) {
		//ҳ��BodyVO
		//������...
		//ҳ��HeadFootVO
		model.addAttribute("pagehfvo", PageLangUtil.getAGemCardHeadFootPageVO(lang));
		
	}
	
	/**
	 * @Description: ���ݱ������Ի�ȡ��ɶ���ҳ������
	 * @param @param model
	 * @param @param lang
	 * @return void
	 */
	public static void getCOrderSuccessPageModel(Model model, String lang) {
		//ҳ��BodyVO
		//������...
		//ҳ��HeadFootVO
		model.addAttribute("pagehfvo", PageLangUtil.getAGemCardHeadFootPageVO(lang));
		
	}
	
	/**
	 * @Description: ���ݱ������Ի�ȡ����֧��ҳ������
	 * @param @param model
	 * @param @param lang
	 * @return void
	 */
	public static void getCOrderPayPageModel(Model model, String lang) {
		//ҳ��BodyVO
		//������...
		//ҳ��HeadFootVO
		model.addAttribute("pagehfvo", PageLangUtil.getAGemCardHeadFootPageVO(lang));
		
	}
	
	/**
	 * @Description: ���ݱ������Ի�ȡ��¼ҳ������
	 * @param @param model
	 * @param @param lang
	 * @return void
	 */
	public static void getCLoginPageModel(Model model, String lang) {
		//ҳ��BodyVO
		//������...
		//ҳ��HeadFootVO
		model.addAttribute("pagehfvo", PageLangUtil.getAGemCardHeadFootPageVO(lang));
		
	}
	
	/**
	 * @Description: ���ݱ������Ի�ȡ�û�ҳ������
	 * @param @param model
	 * @param @param lang
	 * @return void
	 */
	public static void getCUserPageModel(Model model, String lang) {
		//ҳ��BodyVO
		//������...
		//ҳ��HeadFootVO
		model.addAttribute("pagehfvo", PageLangUtil.getAGemCardHeadFootPageVO(lang));
		
	}
}
