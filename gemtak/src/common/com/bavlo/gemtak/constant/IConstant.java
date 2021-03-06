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
	public static final String SESSIONUSERNAEM = "sessionusername";
	//登录接口
	public static final String loginURL = "http://www.bavlo.com/gemtak-invoke/tologin";
	//注册接口
	public static final String registerURL = "http://www.bavlo.com/gemtak-invoke/register";
	//找回密码接口
	public static final String forgetPwdURL = "http://www.bavlo.com/web/forgetPwd";
	//根据用户id获取收货地址接口
	public static final String shoppingAddressURL = "http://www.bavlo.com/gemtak-invoke/getCustomerAddrByUname";
	//新增用户收货地址接口
    public static final String  addShoppingAddressURL = "http://www.bavlo.com/gemtak-invoke/updateAddress";
    //删除用户收货地址接口
    public static final String delShoppingAddressURL = "http://www.bavlo.com/gemtak-invoke/deleteAddress";
    //根据id获取用户收货地址接口
    public static final String getShoppingAddressByAidURL = "http://www.bavlo.com/gemtak-invoke/getCustomerAddrById";
    
    //修改密码
    public static final String updatePwdByUnameURL = "http://www.bavlo.com/gemtak-invoke/changePwdByUname";
    
    //获取优惠码接口
  	public static final String getCoupponURL = "http://www.bavlo.com/gemtak-invoke/checkCode";
    
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
	
	// 扫一扫登陆路径  lzy348860554.imwork.net
	public final static String WXSSLOGIN = "http://www.gemtak.com/gemtak/gemClient/wxlogin.do";
	
	// 扫一扫支付成功后返回的路径
    public final static String WXSSPAYSUCCESSURL = "http://www.gemtak.com/gemtak/wx/payNoticeUrl.do";
	
	//已发布 
	public static final String RELEASE_Y = "Y";
	//新上传（E）
	public static final String RELEASE_E = "E";
	//入库（S）
	public static final String RELEASE_S = "S";
	//已关闭（C）
	public static final String RELEASE_C = "C";
	
	//所有人(A)、商家(B)、只自己(M)
	public static final String POWER_A = "A";
	public static final String POWER_B = "B";
	public static final String POWER_M = "M";
	
	//封面图名称
	public static final String PIC_COVER = "00001.jpg";
	
	public static final Short SHORT_ZERO = 0;
	
	//收藏
	public static final String PCAT_FIV = "5";
	public static final String PCAT_THR = "3";
}
