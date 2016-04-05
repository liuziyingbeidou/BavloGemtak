package com.bavlo.gemtak.constant;

/**
 * @Title: ����Counter
 * @ClassName: IConstant 
 * @Description: ����
 * @author liuzy
 * @date 2015-10-20 ����04:56:51
 */
public interface IConstant {
	
	public static final String YES = "Y";
	public static final String NO = "N";
	public static final String SESSIONUSERNAEM = "sessionusername";
	//��¼�ӿ�
	public static final String loginURL = "http://www.bavlo.com/gemtak-invoke/tologin";
	//ע��ӿ�
	public static final String registerURL = "http://www.bavlo.com/gemtak-invoke/register";
	//�һ�����
	public static final String forgetPwdURL = "http://www.bavlo.com/web/forgetPwd";

	//�������Ի�
	public static final String COOKIE_LANG = "lang";
	public static final String ZH_CN = "cn";
	public static final String EN_UK = "en";
	
	//	��ʯ���ͽӿ�				
	public static final String URL_GEMTYPE = "http://www.bavlo.com/getAllGemType";
	//	��ʯ��ɫ�ӿ�				
	public static final String URL_GEMCOLOR = "http://www.bavlo.com/getAllGemColor";
	//	��ʯ��״�ӿ�				
	public static final String URL_GEMSHAPE = "http://www.bavlo.com/getAllGemShape";
	//	��ʯ���ӿ�		��״ID		
	public static final String URL_GEMCALIBRATED = "http://www.bavlo.com/getGemCalibratedByShape";//?shapeId=10
	//	��ʯ�й��ӿ�				
	public static final String URL_GEMCUT = "http://www.bavlo.com/getAllGemCut";
	//	��ʯ���Ƚӿ�
	public static final String URL_GEMCLARITY = "http://www.bavlo.com/getAllGemClarity";
	//	��ʯ���ؽӿ�				
	public static final String URL_GEMORIGIN = "http://www.bavlo.com/getAllGemOrigin";
	//	��ʯ����ӿ�				
	public static final String URL_GEMTREATMENT = "http://www.bavlo.com/getAllGemTreatment";
	//	��ʯ֤�����ͽӿ�				
	public static final String URL_GEMLAB = "http://www.bavlo.com/getAllGemLab";
	
	
	//�ѷ���
	public static final String RELEASE_Y = "Y";
	//���ϴ���E��
	public static final String RELEASE_E = "E";
	//��⣨S��
	public static final String RELEASE_S = "S";
	//�ѹرգ�C��
	public static final String RELEASE_C = "C";
	
	//������(A)���̼�(B)��ֻ�Լ�(M)
	public static final String POWER_A = "A";
	public static final String POWER_B = "B";
	public static final String POWER_M = "M";
	
	//����ͼ����
	public static final String PIC_COVER = "001.jpg";
	
	public static final Short SHORT_ZERO = 0;
	
	//�ղ�
	public static final String PCAT_FIV = "5";
	public static final String PCAT_THR = "3";
}
