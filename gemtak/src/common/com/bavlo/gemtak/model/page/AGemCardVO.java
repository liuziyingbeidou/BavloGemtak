package com.bavlo.gemtak.model.page;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: AGemCardVO 
 * @Description: 页面VO
 * @author liuzy
 * @date 2016-1-27 下午02:19:07
 */
public class AGemCardVO {

	//编辑宝石数据
	private String titleEdit ;
	//更新
	private String tableModify ;
	//已浏览
	private String tablePageviews ;
	//次数
	private String tablePageviewsTime ;
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
	
}
