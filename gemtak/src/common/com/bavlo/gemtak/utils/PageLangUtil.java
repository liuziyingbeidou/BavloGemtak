package com.bavlo.gemtak.utils;

import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.constant.page.AGemCardLang;
import com.bavlo.gemtak.constant.page.AGemHeadFootLang;
import com.bavlo.gemtak.constant.page.AGemListLang;
import com.bavlo.gemtak.model.page.AGemCardVO;
import com.bavlo.gemtak.model.page.AGemHeadFootVO;
import com.bavlo.gemtak.model.page.AGemListVO;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: PageLangUtil 
 * @Description: 页面中（英）文内容
 * @author liuzy
 * @date 2016-1-27 下午02:41:34
 */
public class PageLangUtil {

	/**
	 * @Description: 管理宝石头部尾部界面
	 * @param @param lang
	 * @param @return
	 * @return AGemCardVO
	 */
	public static AGemHeadFootVO getAGemCardHeadFootPageVO(String lang){
		AGemHeadFootVO aGemHeadFootVO = new AGemHeadFootVO();
		//英文
		if(IConstant.EN_UK.equals(lang)){
			//头部
			aGemHeadFootVO.sethTitle(AGemHeadFootLang.H_Title_EN);
			
			//尾部
			aGemHeadFootVO.setfAboutGemtak(AGemHeadFootLang.f_AboutGemtak_EN);
			aGemHeadFootVO.setfPrivacyClause(AGemHeadFootLang.f_PrivacyClause_EN);
			aGemHeadFootVO.setfCopyrightNotice(AGemHeadFootLang.f_CopyrightNotice_EN);
			aGemHeadFootVO.setfQualityCommitment(AGemHeadFootLang.f_QualityCommitment_EN);
			aGemHeadFootVO.setfJoinUs(AGemHeadFootLang.f_JoinUs_EN);
			aGemHeadFootVO.setfICP(AGemHeadFootLang.f_ICP_EN);
			aGemHeadFootVO.setfWeCal(AGemHeadFootLang.f_WeCal_EN);
		}else{//中文
			//头部
			aGemHeadFootVO.sethTitle(AGemHeadFootLang.H_Title_CN);
			
			//尾部
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
			//按钮
			aGemCardVO.setButtonCert(AGemCardLang.BUTTON_CERT_EN);
			aGemCardVO.setButtonClose(AGemCardLang.BUTTON_CLOSE_EN);
			aGemCardVO.setButtonDelete(AGemCardLang.BUTTON_DELETE_EN);
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
			//按钮
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
	 * @Description: 管理宝石信息列表界面
	 * @param @param lang
	 * @param @return
	 * @return AGemCardVO
	 */
	public static AGemListVO getAGemListBodyPageVO(String lang){
		AGemListVO aGemListVO = new AGemListVO();
		//英文
		if(IConstant.EN_UK.equals(lang)){
			/**
			 * 查找条件
			 */
			//全部产品
			aGemListVO.setFltAllGem(AGemListLang.FLT_ALL_GEM_EN);
			//新上传
			aGemListVO.setFltNewGem(AGemListLang.FLT_NEW_GEM_EN);
			//已发布
			aGemListVO.setFltReleaseGem(AGemListLang.FLT_RELEASE_GEM_EN);
			//已关闭
			aGemListVO.setFltCloseGem(AGemListLang.FLT_CLOSE_GEM_EN);
			//入库宝石
			aGemListVO.setFltStorageGem(AGemListLang.FLT_STORAGE_GEM_EN);
			//签收宝石
			aGemListVO.setFltSignGem(AGemListLang.FLT_SIGN_GEM_EN);
			
			//宝石类型
			aGemListVO.setFltGemType(AGemListLang.FLT_GEM_TYPE_EN);
			//宝石形状
			aGemListVO.setFltGemShape(AGemListLang.FLT_GEM_SHAPE_EN);
			
			//搜索
			aGemListVO.setFltGemSearch(AGemListLang.FLT_GEM_SEARCH_EN);
			//搜索内容
			aGemListVO.setFltDefaultSer(AGemListLang.FLT_DEFAULT_SER_EN);
			
			/**
			 * 标题
			 */
			//图片
			aGemListVO.setTlGemPic(AGemListLang.TL_GEM_PIC_EN);
			//概览
			aGemListVO.setTlGemInfo(AGemListLang.TL_GEM_INFO_EN);
			//编辑选项
			aGemListVO.setTlGemEditOption(AGemListLang.TL_GEM_EDITOPTION_EN);
			//操作
			aGemListVO.setTlGemOperation(AGemListLang.TL_GEM_OPERATION_EN);
			//信息与操作
			aGemListVO.setTlGemInfoAndOpr(AGemListLang.TL_GEM_INFOANDOPR_EN);
			
			/**
			 * List
			 */
			//宝石
			aGemListVO.setLtTypeGem(AGemListLang.LT_TYPE_GEM_EN);
			//产品
			aGemListVO.setLtTypeProduct(AGemListLang.LT_TYPE_PRODUCT_EN);
			//产品入库
			aGemListVO.setLtStorage(AGemListLang.LT_STORAGE_EN);
			//产品签收
			aGemListVO.setLtSign(AGemListLang.LT_SIGN_EN);
			
			/**
			 * List Button
			 */
			//删除
			aGemListVO.setLtGemDel(AGemListLang.LT_GEM_DEL_EN);
			//发布
			aGemListVO.setLtGemRelease(AGemListLang.LT_GEM_RELEASE_EN);
			//关闭
			aGemListVO.setLtGemClose(AGemListLang.LT_GEM_CLOSE_EN);
			
			/**
			 * 按钮
			 */
			//更多
			aGemListVO.setBtnMore(AGemListLang.BTN_MORE_EN);

		}else{//中文
			/**
			 * 查找条件
			 */
			//全部产品
			aGemListVO.setFltAllGem(AGemListLang.FLT_ALL_GEM_CN);
			//新上传
			aGemListVO.setFltNewGem(AGemListLang.FLT_NEW_GEM_CN);
			//已发布
			aGemListVO.setFltReleaseGem(AGemListLang.FLT_RELEASE_GEM_CN);
			//已关闭
			aGemListVO.setFltCloseGem(AGemListLang.FLT_CLOSE_GEM_CN);
			//入库宝石
			aGemListVO.setFltStorageGem(AGemListLang.FLT_STORAGE_GEM_CN);
			//签收宝石
			aGemListVO.setFltSignGem(AGemListLang.FLT_SIGN_GEM_CN);
			
			//宝石类型
			aGemListVO.setFltGemType(AGemListLang.FLT_GEM_TYPE_CN);
			//宝石形状
			aGemListVO.setFltGemShape(AGemListLang.FLT_GEM_SHAPE_CN);
			
			//搜索
			aGemListVO.setFltGemSearch(AGemListLang.FLT_GEM_SEARCH_CN);
			//搜索内容
			aGemListVO.setFltDefaultSer(AGemListLang.FLT_DEFAULT_SER_CN);
			
			/**
			 * 标题
			 */
			//图片
			aGemListVO.setTlGemPic(AGemListLang.TL_GEM_PIC_CN);
			//概览
			aGemListVO.setTlGemInfo(AGemListLang.TL_GEM_INFO_CN);
			//编辑选项
			aGemListVO.setTlGemEditOption(AGemListLang.TL_GEM_EDITOPTION_CN);
			//操作
			aGemListVO.setTlGemOperation(AGemListLang.TL_GEM_OPERATION_CN);
			//信息与操作
			aGemListVO.setTlGemInfoAndOpr(AGemListLang.TL_GEM_INFOANDOPR_CN);
			
			/**
			 * List
			 */
			//宝石
			aGemListVO.setLtTypeGem(AGemListLang.LT_TYPE_GEM_CN);
			//产品
			aGemListVO.setLtTypeProduct(AGemListLang.LT_TYPE_PRODUCT_CN);
			//产品入库
			aGemListVO.setLtStorage(AGemListLang.LT_STORAGE_CN);
			//产品签收
			aGemListVO.setLtSign(AGemListLang.LT_SIGN_CN);
			
			/**
			 * List Button
			 */
			//删除
			aGemListVO.setLtGemDel(AGemListLang.LT_GEM_DEL_CN);
			//发布
			aGemListVO.setLtGemRelease(AGemListLang.LT_GEM_RELEASE_CN);
			//关闭
			aGemListVO.setLtGemClose(AGemListLang.LT_GEM_CLOSE_CN);
			
			/**
			 * 按钮
			 */
			//更多
			aGemListVO.setBtnMore(AGemListLang.BTN_MORE_CN);
		}
		return aGemListVO;
	}
	
}
