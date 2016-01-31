package com.bavlo.gemtak.model.page;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: AGemCardVO 
 * @Description: 页面CardVO  A- 后台
 * @author liuzy
 * @date 2016-1-27 下午02:19:07
 */
public class AGemCardVO{

	//编辑宝石数据
	private String titleEdit ;
	
	//更新
	private String tableModify ;
	//已浏览
	private String tablePageviews ;
	//次数
	private String tablePageviewsTime ;
	//宝石类型
	private String tableGemType;
	//宝石颜色	
	private String tableGemColor;
	//标准形状 非标准规格
	private String tableSTSPNCB;
	//非标准形状 非标准规格
	private String tableNSPNCB;
	//宝石形状
	private String tableGemShape;
	//规格
	private String tableGemCalibratedL;
	private String tableGemCalibratedW;
	private String tableGemCalibratedH;
	//宝石切工
	private String tableGemCut;
	//宝石净度
	private String tableGemClarity;
	//视角
	private String tableViewpoint;
	//平均颜色	
	private String tableAverageColor;
	//宝石产地
	private String tableOrigin;
	//宝石处理
	private String tableTreatment;
	//重量	
	private String tableWeight;
	//库存量	
	private String tableStockQty;
	//单位
	private String tablePairs;
	private String tablePairsSL;
	private String tablePairsML;
	private String tablePairsPL;
	//进价	
	private String tablePurchasePrice;
	//进价单位
	private String tablePurchaseUnit;
	//批发价	
	private String tableTradePrice;
	//批发价单位
	private String tableTradeUnit;
	//零售价	
	private String tableRetailPrice;
	//零售价单位	
	private String tableRetailUnit;
	//价格单位
	private String tablePriceUnitGL;
	private String tablePriceUnitCT;
	//宝石证书类型	
	private String tableLabType;
	//证书编号
	private String tableLabNo;
	//卖家（供应商）
	private String tableSupplier;
	//卖家编码（供应商）	
	private String tableSupplierCode;
	//货址	
	private String tableLocation;
	//可见性(所有人/供应商/自己)
	private String tableAllPower;
	private String tableSupplierPower;
	private String tableSelfPower;
	
	//查看详细页
	private String buttonInfo ;
	//查看我的宝石
	private String buttonViewGem ;
	//上传证书
	private String buttonCert ;
	//删除按钮
	private String buttonDelete ;
	//退出编辑按钮
	private String buttonClose ;
	//保存按钮
	private String buttonSave ;
	
	public String getTitleEdit() {
		return titleEdit;
	}
	public void setTitleEdit(String titleEdit) {
		this.titleEdit = titleEdit;
	}
	public String getTableModify() {
		return tableModify;
	}
	public void setTableModify(String tableModify) {
		this.tableModify = tableModify;
	}
	public String getTablePageviews() {
		return tablePageviews;
	}
	public void setTablePageviews(String tablePageviews) {
		this.tablePageviews = tablePageviews;
	}
	public String getTablePageviewsTime() {
		return tablePageviewsTime;
	}
	public void setTablePageviewsTime(String tablePageviewsTime) {
		this.tablePageviewsTime = tablePageviewsTime;
	}
	public String getButtonCert() {
		return buttonCert;
	}
	public void setButtonCert(String buttonCert) {
		this.buttonCert = buttonCert;
	}
	public String getButtonDelete() {
		return buttonDelete;
	}
	public void setButtonDelete(String buttonDelete) {
		this.buttonDelete = buttonDelete;
	}
	public String getButtonClose() {
		return buttonClose;
	}
	public void setButtonClose(String buttonClose) {
		this.buttonClose = buttonClose;
	}
	public String getButtonSave() {
		return buttonSave;
	}
	public void setButtonSave(String buttonSave) {
		this.buttonSave = buttonSave;
	}
	public String getTableGemType() {
		return tableGemType;
	}
	public void setTableGemType(String tableGemType) {
		this.tableGemType = tableGemType;
	}
	public String getTableGemColor() {
		return tableGemColor;
	}
	public void setTableGemColor(String tableGemColor) {
		this.tableGemColor = tableGemColor;
	}
	public String getTableSTSPNCB() {
		return tableSTSPNCB;
	}
	public void setTableSTSPNCB(String tableSTSPNCB) {
		this.tableSTSPNCB = tableSTSPNCB;
	}
	public String getTableNSPNCB() {
		return tableNSPNCB;
	}
	public void setTableNSPNCB(String tableNSPNCB) {
		this.tableNSPNCB = tableNSPNCB;
	}
	public String getTableGemShape() {
		return tableGemShape;
	}
	public void setTableGemShape(String tableGemShape) {
		this.tableGemShape = tableGemShape;
	}
	public String getTableGemCalibratedL() {
		return tableGemCalibratedL;
	}
	public void setTableGemCalibratedL(String tableGemCalibratedL) {
		this.tableGemCalibratedL = tableGemCalibratedL;
	}
	public String getTableGemCalibratedW() {
		return tableGemCalibratedW;
	}
	public void setTableGemCalibratedW(String tableGemCalibratedW) {
		this.tableGemCalibratedW = tableGemCalibratedW;
	}
	public String getTableGemCalibratedH() {
		return tableGemCalibratedH;
	}
	public void setTableGemCalibratedH(String tableGemCalibratedH) {
		this.tableGemCalibratedH = tableGemCalibratedH;
	}
	public String getTableGemCut() {
		return tableGemCut;
	}
	public void setTableGemCut(String tableGemCut) {
		this.tableGemCut = tableGemCut;
	}
	public String getTableGemClarity() {
		return tableGemClarity;
	}
	public void setTableGemClarity(String tableGemClarity) {
		this.tableGemClarity = tableGemClarity;
	}
	public String getTableViewpoint() {
		return tableViewpoint;
	}
	public void setTableViewpoint(String tableViewpoint) {
		this.tableViewpoint = tableViewpoint;
	}
	public String getTableAverageColor() {
		return tableAverageColor;
	}
	public void setTableAverageColor(String tableAverageColor) {
		this.tableAverageColor = tableAverageColor;
	}
	public String getTableOrigin() {
		return tableOrigin;
	}
	public void setTableOrigin(String tableOrigin) {
		this.tableOrigin = tableOrigin;
	}
	public String getTableTreatment() {
		return tableTreatment;
	}
	public void setTableTreatment(String tableTreatment) {
		this.tableTreatment = tableTreatment;
	}
	public String getTableWeight() {
		return tableWeight;
	}
	public void setTableWeight(String tableWeight) {
		this.tableWeight = tableWeight;
	}
	public String getTableStockQty() {
		return tableStockQty;
	}
	public void setTableStockQty(String tableStockQty) {
		this.tableStockQty = tableStockQty;
	}
	public String getTablePairs() {
		return tablePairs;
	}
	public void setTablePairs(String tablePairs) {
		this.tablePairs = tablePairs;
	}
	public String getTablePurchasePrice() {
		return tablePurchasePrice;
	}
	public void setTablePurchasePrice(String tablePurchasePrice) {
		this.tablePurchasePrice = tablePurchasePrice;
	}
	public String getTablePurchaseUnit() {
		return tablePurchaseUnit;
	}
	public void setTablePurchaseUnit(String tablePurchaseUnit) {
		this.tablePurchaseUnit = tablePurchaseUnit;
	}
	public String getTableTradePrice() {
		return tableTradePrice;
	}
	public void setTableTradePrice(String tableTradePrice) {
		this.tableTradePrice = tableTradePrice;
	}
	public String getTableTradeUnit() {
		return tableTradeUnit;
	}
	public void setTableTradeUnit(String tableTradeUnit) {
		this.tableTradeUnit = tableTradeUnit;
	}
	public String getTableRetailPrice() {
		return tableRetailPrice;
	}
	public void setTableRetailPrice(String tableRetailPrice) {
		this.tableRetailPrice = tableRetailPrice;
	}
	public String getTableRetailUnit() {
		return tableRetailUnit;
	}
	public void setTableRetailUnit(String tableRetailUnit) {
		this.tableRetailUnit = tableRetailUnit;
	}
	public String getTableLabType() {
		return tableLabType;
	}
	public void setTableLabType(String tableLabType) {
		this.tableLabType = tableLabType;
	}
	public String getTableLabNo() {
		return tableLabNo;
	}
	public void setTableLabNo(String tableLabNo) {
		this.tableLabNo = tableLabNo;
	}
	public String getTableSupplier() {
		return tableSupplier;
	}
	public void setTableSupplier(String tableSupplier) {
		this.tableSupplier = tableSupplier;
	}
	public String getTableSupplierCode() {
		return tableSupplierCode;
	}
	public void setTableSupplierCode(String tableSupplierCode) {
		this.tableSupplierCode = tableSupplierCode;
	}
	public String getTableLocation() {
		return tableLocation;
	}
	public void setTableLocation(String tableLocation) {
		this.tableLocation = tableLocation;
	}
	public String getTableAllPower() {
		return tableAllPower;
	}
	public void setTableAllPower(String tableAllPower) {
		this.tableAllPower = tableAllPower;
	}
	public String getTableSupplierPower() {
		return tableSupplierPower;
	}
	public void setTableSupplierPower(String tableSupplierPower) {
		this.tableSupplierPower = tableSupplierPower;
	}
	public String getTableSelfPower() {
		return tableSelfPower;
	}
	public void setTableSelfPower(String tableSelfPower) {
		this.tableSelfPower = tableSelfPower;
	}
	public String getButtonInfo() {
		return buttonInfo;
	}
	public void setButtonInfo(String buttonInfo) {
		this.buttonInfo = buttonInfo;
	}
	public String getButtonViewGem() {
		return buttonViewGem;
	}
	public void setButtonViewGem(String buttonViewGem) {
		this.buttonViewGem = buttonViewGem;
	}
	public String getTablePairsSL() {
		return tablePairsSL;
	}
	public void setTablePairsSL(String tablePairsSL) {
		this.tablePairsSL = tablePairsSL;
	}
	public String getTablePairsML() {
		return tablePairsML;
	}
	public void setTablePairsML(String tablePairsML) {
		this.tablePairsML = tablePairsML;
	}
	public String getTablePairsPL() {
		return tablePairsPL;
	}
	public void setTablePairsPL(String tablePairsPL) {
		this.tablePairsPL = tablePairsPL;
	}
	public String getTablePriceUnitGL() {
		return tablePriceUnitGL;
	}
	public void setTablePriceUnitGL(String tablePriceUnitGL) {
		this.tablePriceUnitGL = tablePriceUnitGL;
	}
	public String getTablePriceUnitCT() {
		return tablePriceUnitCT;
	}
	public void setTablePriceUnitCT(String tablePriceUnitCT) {
		this.tablePriceUnitCT = tablePriceUnitCT;
	}
	
}
