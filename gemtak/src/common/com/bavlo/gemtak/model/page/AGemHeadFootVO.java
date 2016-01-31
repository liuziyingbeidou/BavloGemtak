package com.bavlo.gemtak.model.page;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: AGemHeadVO 
 * @Description: 后台表头表尾
 * @author liuzy
 * @date 2016-1-28 下午08:10:44
 */
public class AGemHeadFootVO {

	/**
	 * 头部
	 */
	//标题
	private String hTitle;
	
	/**
	 * 尾部
	 */
	//关于Gemtak
	private String fAboutGemtak;
	//隐私条款
	private String fPrivacyClause;
	//版权声明
	private String fCopyrightNotice;
	//质量承诺
	private String fQualityCommitment;
	//加入我们
	private String fJoinUs;
	//京ICP备11048465号
	private String fICP;
	//|恭候致电 010-82830789
	private String fWeCal;

	public String gethTitle() {
		return hTitle;
	}

	public void sethTitle(String hTitle) {
		this.hTitle = hTitle;
	}

	public String getfAboutGemtak() {
		return fAboutGemtak;
	}

	public void setfAboutGemtak(String fAboutGemtak) {
		this.fAboutGemtak = fAboutGemtak;
	}

	public String getfPrivacyClause() {
		return fPrivacyClause;
	}

	public void setfPrivacyClause(String fPrivacyClause) {
		this.fPrivacyClause = fPrivacyClause;
	}

	public String getfCopyrightNotice() {
		return fCopyrightNotice;
	}

	public void setfCopyrightNotice(String fCopyrightNotice) {
		this.fCopyrightNotice = fCopyrightNotice;
	}

	public String getfQualityCommitment() {
		return fQualityCommitment;
	}

	public void setfQualityCommitment(String fQualityCommitment) {
		this.fQualityCommitment = fQualityCommitment;
	}

	public String getfJoinUs() {
		return fJoinUs;
	}

	public void setfJoinUs(String fJoinUs) {
		this.fJoinUs = fJoinUs;
	}

	public String getfICP() {
		return fICP;
	}

	public void setfICP(String fICP) {
		this.fICP = fICP;
	}

	public String getfWeCal() {
		return fWeCal;
	}

	public void setfWeCal(String fWeCal) {
		this.fWeCal = fWeCal;
	}
	
}
