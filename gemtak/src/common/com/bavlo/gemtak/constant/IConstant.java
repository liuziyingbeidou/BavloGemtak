package com.bavlo.gemtak.constant;

/**
 * @Title: 宝珑Counter
 * @ClassName: IConstant 
 * @Description: 常量
 * @author liuzy
 * @date 2015-10-20 下午04:56:51
 */
public interface IConstant {
	
	public static final String YES = "Y";
	public static final String NO = "N";
	
	//本地语言化
	public static final String COOKIE_LANG = "lang";
	public static final String ZH_CN = "cn";
	public static final String EN_UK = "en";
	
	//	宝石类型接口				
	public static final String URL_GEMTYPE = "http://www.bavlo.com/getAllGemType";
	//	宝石颜色接口				
	public static final String URL_GEMCOLOR = "http://www.bavlo.com/getAllGemColor";
	//	宝石形状接口				
	public static final String URL_GEMSHAPE = "http://www.bavlo.com/getAllGemShape";
	//	宝石规格接口		形状ID		
	public static final String URL_GEMCALIBRATED = "http://www.bavlo.com/getGemCalibratedByShape";//?shapeId=10
	//	宝石切工接口				
	public static final String URL_GEMCUT = "http://www.bavlo.com/getAllGemCut";
	//	宝石净度接口
	public static final String URL_GEMCLARITY = "http://www.bavlo.com/getAllGemClarity";
	//	宝石产地接口				
	public static final String URL_GEMORIGIN = "http://www.bavlo.com/getAllGemOrigin";
	//	宝石处理接口				
	public static final String URL_GEMTREATMENT = "http://www.bavlo.com/getAllGemTreatment";
	//	宝石证书类型接口				
	public static final String URL_GEMLAB = "http://www.bavlo.com/getAllGemLab";
	
	
	//已发布
	public static final String RELEASE_Y = "Y";
}
