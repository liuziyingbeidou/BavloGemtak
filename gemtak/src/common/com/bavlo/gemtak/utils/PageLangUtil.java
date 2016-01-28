package com.bavlo.gemtak.utils;

import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.constant.page.AGemCardLang;
import com.bavlo.gemtak.model.page.AGemCardVO;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: PageLangUtil 
 * @Description: 页面中（英）文内容
 * @author liuzy
 * @date 2016-1-27 下午02:41:34
 */
public class PageLangUtil {

	/**
	 * @Description: 管理宝石表头界面
	 * @param @param lang
	 * @param @return
	 * @return AGemCardVO
	 */
	public static AGemCardVO getAGemCardHeadPageVO(String lang){
		AGemCardVO aGemCardVO = new AGemCardVO();
		//英文
		if(IConstant.EN_UK.equals(lang)){
			
		}else{//中文
			
		}
		return aGemCardVO;
	}
	
	/**
	 * @Description: 管理宝石表尾界面
	 * @param @param lang
	 * @param @return
	 * @return AGemCardVO
	 */
	public static AGemCardVO getAGemCardFootPageVO(String lang){
		AGemCardVO aGemCardVO = new AGemCardVO();
		//英文
		if(IConstant.EN_UK.equals(lang)){
			
		}else{//中文
			
		}
		return aGemCardVO;
	}
	
	/**
	 * @Description: 管理宝石信息录入界面
	 * @param @param lang
	 * @param @return
	 * @return AGemCardVO
	 */
	public static AGemCardVO getAGemCardBodyPageVO(String lang){
		AGemCardVO aGemCardVO = new AGemCardVO();
		//英文
		if(IConstant.EN_UK.equals(lang)){
			//标题
			aGemCardVO.setTitleEdit(AGemCardLang.TITLE_EDIT_EN);
			//表映射
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
			//按钮
			aGemCardVO.setButtonCert(AGemCardLang.BUTTON_CERT_EN);
			aGemCardVO.setButtonClose(AGemCardLang.BUTTON_CLOSE_EN);
			aGemCardVO.setButtonDelete(AGemCardLang.BUTTON_CLOSE_EN);
			aGemCardVO.setButtonSave(AGemCardLang.BUTTON_SAVE_EN);
			aGemCardVO.setButtonInfo(AGemCardLang.button_Info_EN);
			aGemCardVO.setButtonViewGem(AGemCardLang.button_ViewGem_EN);
		}else{//中文
			//标题
			aGemCardVO.setTitleEdit(AGemCardLang.TITLE_EDIT_CN);
			//表映射
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
			//按钮
			aGemCardVO.setButtonCert(AGemCardLang.BUTTON_CERT_CN);
			aGemCardVO.setButtonClose(AGemCardLang.BUTTON_CLOSE_CN);
			aGemCardVO.setButtonDelete(AGemCardLang.BUTTON_CLOSE_CN);
			aGemCardVO.setButtonSave(AGemCardLang.BUTTON_SAVE_CN);
			aGemCardVO.setButtonInfo(AGemCardLang.button_Info_CN);
			aGemCardVO.setButtonViewGem(AGemCardLang.button_ViewGem_CN);
		}
		return aGemCardVO;
	}
	
}
