package com.bavlo.gemtak.utils;

import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.constant.page.AGemCardLang;
import com.bavlo.gemtak.model.page.AGemCardVO;

/**
 * @Title: ����Gemtak
 * @ClassName: PageLangUtil 
 * @Description: ҳ���У�Ӣ��������
 * @author liuzy
 * @date 2016-1-27 ����02:41:34
 */
public class PageLangUtil {

	/**
	 * @Description: ����ʯ��Ϣ¼�����
	 * @param @param lang
	 * @param @return
	 * @return AGemCardVO
	 */
	public static AGemCardVO getAGemCardPageVO(String lang){
		AGemCardVO aGemCardVO = new AGemCardVO();
		//Ӣ��
		if(IConstant.EN_UK.equals(lang)){
			aGemCardVO.setTitleEdit(AGemCardLang.TITLE_EDIT_EN);
			aGemCardVO.setTableModify(AGemCardLang.TABLE_MODIFY_EN);
			aGemCardVO.setTablePageviews(AGemCardLang.TABLE_PAGEVIEWS_EN);
			aGemCardVO.setTablePageviewsTime(AGemCardLang.TABLE_PAGEVIEWS_TIMES_EN);
			aGemCardVO.setButtonCert(AGemCardLang.BUTTON_CERT_EN);
			aGemCardVO.setButtonClose(AGemCardLang.BUTTON_CLOSE_EN);
			aGemCardVO.setButtonDelete(AGemCardLang.BUTTON_CLOSE_EN);
			aGemCardVO.setButtonSave(AGemCardLang.BUTTON_SAVE_EN);
		}else{//����
			aGemCardVO.setTitleEdit(AGemCardLang.TITLE_EDIT_CN);
			aGemCardVO.setTableModify(AGemCardLang.TABLE_MODIFY_CN);
			aGemCardVO.setTablePageviews(AGemCardLang.TABLE_PAGEVIEWS_CN);
			aGemCardVO.setTablePageviewsTime(AGemCardLang.TABLE_PAGEVIEWS_TIMES_CN);
			aGemCardVO.setButtonCert(AGemCardLang.BUTTON_CERT_CN);
			aGemCardVO.setButtonClose(AGemCardLang.BUTTON_CLOSE_CN);
			aGemCardVO.setButtonDelete(AGemCardLang.BUTTON_CLOSE_CN);
			aGemCardVO.setButtonSave(AGemCardLang.BUTTON_SAVE_CN);
		}
		return aGemCardVO;
	}
	
}
