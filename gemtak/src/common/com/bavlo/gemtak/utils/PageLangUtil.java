package com.bavlo.gemtak.utils;

import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.constant.page.AGemCardLang;
import com.bavlo.gemtak.constant.page.AGemHeadFootLang;
import com.bavlo.gemtak.constant.page.AGemListLang;
import com.bavlo.gemtak.model.page.AGemCardVO;
import com.bavlo.gemtak.model.page.AGemHeadFootVO;
import com.bavlo.gemtak.model.page.AGemListVO;

/**
 * @Title: ����Gemtak
 * @ClassName: PageLangUtil 
 * @Description: ҳ���У�Ӣ��������
 * @author liuzy
 * @date 2016-1-27 ����02:41:34
 */
public class PageLangUtil {

	/**
	 * @Description: ����ʯͷ��β������
	 * @param @param lang
	 * @param @return
	 * @return AGemCardVO
	 */
	public static AGemHeadFootVO getAGemCardHeadFootPageVO(String lang){
		AGemHeadFootVO aGemHeadFootVO = new AGemHeadFootVO();
		//Ӣ��
		if(IConstant.EN_UK.equals(lang)){
			//ͷ��
			aGemHeadFootVO.sethTitle(AGemHeadFootLang.H_Title_EN);
			
			//β��
			aGemHeadFootVO.setfAboutGemtak(AGemHeadFootLang.f_AboutGemtak_EN);
			aGemHeadFootVO.setfPrivacyClause(AGemHeadFootLang.f_PrivacyClause_EN);
			aGemHeadFootVO.setfCopyrightNotice(AGemHeadFootLang.f_CopyrightNotice_EN);
			aGemHeadFootVO.setfQualityCommitment(AGemHeadFootLang.f_QualityCommitment_EN);
			aGemHeadFootVO.setfJoinUs(AGemHeadFootLang.f_JoinUs_EN);
			aGemHeadFootVO.setfICP(AGemHeadFootLang.f_ICP_EN);
			aGemHeadFootVO.setfWeCal(AGemHeadFootLang.f_WeCal_EN);
		}else{//����
			//ͷ��
			aGemHeadFootVO.sethTitle(AGemHeadFootLang.H_Title_CN);
			
			//β��
			aGemHeadFootVO.setfAboutGemtak(AGemHeadFootLang.f_AboutGemtak_CN);
			aGemHeadFootVO.setfPrivacyClause(AGemHeadFootLang.f_PrivacyClause_CN);
			aGemHeadFootVO.setfCopyrightNotice(AGemHeadFootLang.f_CopyrightNotice_CN);
			aGemHeadFootVO.setfQualityCommitment(AGemHeadFootLang.f_QualityCommitment_CN);
			aGemHeadFootVO.setfJoinUs(AGemHeadFootLang.f_JoinUs_CN);
			aGemHeadFootVO.setfICP(AGemHeadFootLang.f_ICP_CN);
			aGemHeadFootVO.setfWeCal(AGemHeadFootLang.f_WeCal_CN);
		}
		return aGemHeadFootVO;
	}
	
	/**
	 * @Description: ����ʯ��Ϣ¼�����
	 * @param @param lang
	 * @param @return
	 * @return AGemCardVO
	 */
	public static AGemCardVO getAGemCardBodyPageVO(String lang){
		AGemCardVO aGemCardVO = new AGemCardVO();
		//Ӣ��
		if(IConstant.EN_UK.equals(lang)){
			//����
			aGemCardVO.setTitleEdit(AGemCardLang.TITLE_EDIT_EN);
			//��ӳ��
			aGemCardVO.setTableModify(AGemCardLang.TABLE_MODIFY_EN);
			aGemCardVO.setTablePageviews(AGemCardLang.TABLE_PAGEVIEWS_EN);
			aGemCardVO.setTablePageviewsTime(AGemCardLang.TABLE_PAGEVIEWS_TIMES_EN);
			
			aGemCardVO.setTableSTSPNCB(AGemCardLang.table_STSPNCB_EN);
			aGemCardVO.setTableNSPNCB(AGemCardLang.table_NSPNCB_EN);
			aGemCardVO.setTableGemCalibratedL(AGemCardLang.table_GemCalibratedL_EN);
			aGemCardVO.setTableGemCalibratedW(AGemCardLang.table_GemCalibratedW_EN);
			aGemCardVO.setTableGemCalibratedH(AGemCardLang.table_GemCalibratedH_EN);
			aGemCardVO.setTableGemCut(AGemCardLang.table_GemCut_EN);
			aGemCardVO.setTableGemClarity(AGemCardLang.table_GemClarity_EN);
			aGemCardVO.setTableViewpoint(AGemCardLang.table_Viewpoint_EN);
			aGemCardVO.setTableAverageColor(AGemCardLang.table_AverageColor_EN);
			aGemCardVO.setTableOrigin(AGemCardLang.table_Origin_EN);
			aGemCardVO.setTableTreatment(AGemCardLang.table_Treatment_EN);
			aGemCardVO.setTableStockQty(AGemCardLang.table_StockQty_EN);
			aGemCardVO.setTablePurchasePrice(AGemCardLang.table_PurchasePrice_EN);
			aGemCardVO.setTableTradePrice(AGemCardLang.table_TradePrice_EN);
			aGemCardVO.setTableRetailPrice(AGemCardLang.table_RetailPrice_EN);
			aGemCardVO.setTablePriceUnitGL(AGemCardLang.table_PriceUnitGL_EN);
			aGemCardVO.setTablePriceUnitCT(AGemCardLang.table_PriceUnitCT_EN);
			aGemCardVO.setTableLabType(AGemCardLang.table_LabType_EN);
			aGemCardVO.setTableLabNo(AGemCardLang.table_LabNo_EN);
			aGemCardVO.setTableSupplier(AGemCardLang.table_Supplier_EN);
			aGemCardVO.setTableSupplierCode(AGemCardLang.table_SupplierCode_EN);
			aGemCardVO.setTableAllPower(AGemCardLang.table_AllPower_EN);
			aGemCardVO.setTableSupplierPower(AGemCardLang.table_SupplierPower_EN);
			aGemCardVO.setTableSelfPower(AGemCardLang.table_SelfPower_EN);
			aGemCardVO.setTablePairsSL(AGemCardLang.table_PairsSL_EN);
			aGemCardVO.setTablePairsML(AGemCardLang.table_PairsML_EN);
			aGemCardVO.setTablePairsPL(AGemCardLang.table_PairsPL_EN);
			aGemCardVO.setTableLocation(AGemCardLang.table_Location_EN);
			//��ť
			aGemCardVO.setButtonCert(AGemCardLang.BUTTON_CERT_EN);
			aGemCardVO.setButtonClose(AGemCardLang.BUTTON_CLOSE_EN);
			aGemCardVO.setButtonDelete(AGemCardLang.BUTTON_DELETE_EN);
			aGemCardVO.setButtonSave(AGemCardLang.BUTTON_SAVE_EN);
			aGemCardVO.setButtonInfo(AGemCardLang.button_Info_EN);
			aGemCardVO.setButtonViewGem(AGemCardLang.button_ViewGem_EN);
		}else{//����
			//����
			aGemCardVO.setTitleEdit(AGemCardLang.TITLE_EDIT_CN);
			//��ӳ��
			aGemCardVO.setTableModify(AGemCardLang.TABLE_MODIFY_CN);
			aGemCardVO.setTablePageviews(AGemCardLang.TABLE_PAGEVIEWS_CN);
			aGemCardVO.setTablePageviewsTime(AGemCardLang.TABLE_PAGEVIEWS_TIMES_CN);
			
			aGemCardVO.setTableSTSPNCB(AGemCardLang.table_STSPNCB_CN);
			aGemCardVO.setTableNSPNCB(AGemCardLang.table_NSPNCB_CN);
			aGemCardVO.setTableGemCalibratedL(AGemCardLang.table_GemCalibratedL_CN);
			aGemCardVO.setTableGemCalibratedW(AGemCardLang.table_GemCalibratedW_CN);
			aGemCardVO.setTableGemCalibratedH(AGemCardLang.table_GemCalibratedH_CN);
			aGemCardVO.setTableGemCut(AGemCardLang.table_GemCut_CN);
			aGemCardVO.setTableGemClarity(AGemCardLang.table_GemClarity_CN);
			aGemCardVO.setTableViewpoint(AGemCardLang.table_Viewpoint_CN);
			aGemCardVO.setTableAverageColor(AGemCardLang.table_AverageColor_CN);
			aGemCardVO.setTableOrigin(AGemCardLang.table_Origin_CN);
			aGemCardVO.setTableTreatment(AGemCardLang.table_Treatment_CN);
			aGemCardVO.setTableStockQty(AGemCardLang.table_StockQty_CN);
			aGemCardVO.setTablePurchasePrice(AGemCardLang.table_PurchasePrice_CN);
			aGemCardVO.setTableTradePrice(AGemCardLang.table_TradePrice_CN);
			aGemCardVO.setTableRetailPrice(AGemCardLang.table_RetailPrice_CN);
			aGemCardVO.setTablePriceUnitGL(AGemCardLang.table_PriceUnitGL_CN);
			aGemCardVO.setTablePriceUnitCT(AGemCardLang.table_PriceUnitCT_CN);
			aGemCardVO.setTableLabType(AGemCardLang.table_LabType_CN);
			aGemCardVO.setTableLabNo(AGemCardLang.table_LabNo_CN);
			aGemCardVO.setTableSupplier(AGemCardLang.table_Supplier_CN);
			aGemCardVO.setTableSupplierCode(AGemCardLang.table_SupplierCode_CN);
			aGemCardVO.setTableAllPower(AGemCardLang.table_AllPower_CN);
			aGemCardVO.setTableSupplierPower(AGemCardLang.table_SupplierPower_CN);
			aGemCardVO.setTableSelfPower(AGemCardLang.table_SelfPower_CN);
			aGemCardVO.setTablePairsSL(AGemCardLang.table_PairsSL_CN);
			aGemCardVO.setTablePairsML(AGemCardLang.table_PairsML_CN);
			aGemCardVO.setTablePairsPL(AGemCardLang.table_PairsPL_CN);
			aGemCardVO.setTableLocation(AGemCardLang.table_Location_CN);
			//��ť
			aGemCardVO.setButtonCert(AGemCardLang.BUTTON_CERT_CN);
			aGemCardVO.setButtonClose(AGemCardLang.BUTTON_CLOSE_CN);
			aGemCardVO.setButtonDelete(AGemCardLang.BUTTON_DELETE_CN);
			aGemCardVO.setButtonSave(AGemCardLang.BUTTON_SAVE_CN);
			aGemCardVO.setButtonInfo(AGemCardLang.button_Info_CN);
			aGemCardVO.setButtonViewGem(AGemCardLang.button_ViewGem_CN);
		}
		return aGemCardVO;
	}
	
	/**
	 * @Description: ����ʯ��Ϣ�б����
	 * @param @param lang
	 * @param @return
	 * @return AGemCardVO
	 */
	public static AGemListVO getAGemListBodyPageVO(String lang){
		AGemListVO aGemListVO = new AGemListVO();
		//Ӣ��
		if(IConstant.EN_UK.equals(lang)){
			/**
			 * ��������
			 */
			//ȫ����Ʒ
			aGemListVO.setFltAllGem(AGemListLang.FLT_ALL_GEM_EN);
			//���ϴ�
			aGemListVO.setFltNewGem(AGemListLang.FLT_NEW_GEM_EN);
			//�ѷ���
			aGemListVO.setFltReleaseGem(AGemListLang.FLT_RELEASE_GEM_EN);
			//�ѹر�
			aGemListVO.setFltCloseGem(AGemListLang.FLT_CLOSE_GEM_EN);
			//��ⱦʯ
			aGemListVO.setFltStorageGem(AGemListLang.FLT_STORAGE_GEM_EN);
			//ǩ�ձ�ʯ
			aGemListVO.setFltSignGem(AGemListLang.FLT_SIGN_GEM_EN);
			
			//��ʯ����
			aGemListVO.setFltGemType(AGemListLang.FLT_GEM_TYPE_EN);
			//��ʯ��״
			aGemListVO.setFltGemShape(AGemListLang.FLT_GEM_SHAPE_EN);
			
			//����
			aGemListVO.setFltGemSearch(AGemListLang.FLT_GEM_SEARCH_EN);
			//��������
			aGemListVO.setFltDefaultSer(AGemListLang.FLT_DEFAULT_SER_EN);
			
			/**
			 * ����
			 */
			//ͼƬ
			aGemListVO.setTlGemPic(AGemListLang.TL_GEM_PIC_EN);
			//����
			aGemListVO.setTlGemInfo(AGemListLang.TL_GEM_INFO_EN);
			//�༭ѡ��
			aGemListVO.setTlGemEditOption(AGemListLang.TL_GEM_EDITOPTION_EN);
			//����
			aGemListVO.setTlGemOperation(AGemListLang.TL_GEM_OPERATION_EN);
			//��Ϣ�����
			aGemListVO.setTlGemInfoAndOpr(AGemListLang.TL_GEM_INFOANDOPR_EN);
			
			/**
			 * List
			 */
			//��ʯ
			aGemListVO.setLtTypeGem(AGemListLang.LT_TYPE_GEM_EN);
			//��Ʒ
			aGemListVO.setLtTypeProduct(AGemListLang.LT_TYPE_PRODUCT_EN);
			//��Ʒ���
			aGemListVO.setLtStorage(AGemListLang.LT_STORAGE_EN);
			//��Ʒǩ��
			aGemListVO.setLtSign(AGemListLang.LT_SIGN_EN);
			
			/**
			 * List Button
			 */
			//ɾ��
			aGemListVO.setLtGemDel(AGemListLang.LT_GEM_DEL_EN);
			//����
			aGemListVO.setLtGemRelease(AGemListLang.LT_GEM_RELEASE_EN);
			//�ر�
			aGemListVO.setLtGemClose(AGemListLang.LT_GEM_CLOSE_EN);
			
			/**
			 * ��ť
			 */
			//����
			aGemListVO.setBtnMore(AGemListLang.BTN_MORE_EN);

		}else{//����
			/**
			 * ��������
			 */
			//ȫ����Ʒ
			aGemListVO.setFltAllGem(AGemListLang.FLT_ALL_GEM_CN);
			//���ϴ�
			aGemListVO.setFltNewGem(AGemListLang.FLT_NEW_GEM_CN);
			//�ѷ���
			aGemListVO.setFltReleaseGem(AGemListLang.FLT_RELEASE_GEM_CN);
			//�ѹر�
			aGemListVO.setFltCloseGem(AGemListLang.FLT_CLOSE_GEM_CN);
			//��ⱦʯ
			aGemListVO.setFltStorageGem(AGemListLang.FLT_STORAGE_GEM_CN);
			//ǩ�ձ�ʯ
			aGemListVO.setFltSignGem(AGemListLang.FLT_SIGN_GEM_CN);
			
			//��ʯ����
			aGemListVO.setFltGemType(AGemListLang.FLT_GEM_TYPE_CN);
			//��ʯ��״
			aGemListVO.setFltGemShape(AGemListLang.FLT_GEM_SHAPE_CN);
			
			//����
			aGemListVO.setFltGemSearch(AGemListLang.FLT_GEM_SEARCH_CN);
			//��������
			aGemListVO.setFltDefaultSer(AGemListLang.FLT_DEFAULT_SER_CN);
			
			/**
			 * ����
			 */
			//ͼƬ
			aGemListVO.setTlGemPic(AGemListLang.TL_GEM_PIC_CN);
			//����
			aGemListVO.setTlGemInfo(AGemListLang.TL_GEM_INFO_CN);
			//�༭ѡ��
			aGemListVO.setTlGemEditOption(AGemListLang.TL_GEM_EDITOPTION_CN);
			//����
			aGemListVO.setTlGemOperation(AGemListLang.TL_GEM_OPERATION_CN);
			//��Ϣ�����
			aGemListVO.setTlGemInfoAndOpr(AGemListLang.TL_GEM_INFOANDOPR_CN);
			
			/**
			 * List
			 */
			//��ʯ
			aGemListVO.setLtTypeGem(AGemListLang.LT_TYPE_GEM_CN);
			//��Ʒ
			aGemListVO.setLtTypeProduct(AGemListLang.LT_TYPE_PRODUCT_CN);
			//��Ʒ���
			aGemListVO.setLtStorage(AGemListLang.LT_STORAGE_CN);
			//��Ʒǩ��
			aGemListVO.setLtSign(AGemListLang.LT_SIGN_CN);
			
			/**
			 * List Button
			 */
			//ɾ��
			aGemListVO.setLtGemDel(AGemListLang.LT_GEM_DEL_CN);
			//����
			aGemListVO.setLtGemRelease(AGemListLang.LT_GEM_RELEASE_CN);
			//�ر�
			aGemListVO.setLtGemClose(AGemListLang.LT_GEM_CLOSE_CN);
			
			/**
			 * ��ť
			 */
			//����
			aGemListVO.setBtnMore(AGemListLang.BTN_MORE_CN);
		}
		return aGemListVO;
	}
	
}
