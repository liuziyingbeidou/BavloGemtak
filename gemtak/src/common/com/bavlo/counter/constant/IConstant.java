package com.bavlo.counter.constant;

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
	
	/**
	 * ����״̬ 
	 * �ύ(0)���ư�(1)������(2)���ʼ�(3)�����(4)��֧��(5)
	 * commit (0), Plate (1), Production (2), quality (3), express (4), payment (5)
	 */
	public static final Integer ORDER_COMMIT = 0;
	public static final Integer ORDER_PLATE = 1;
	public static final Integer ORDER_PRODUCTION = 2;
	public static final Integer ORDER_QUALITY = 3;
	public static final Integer ORDER_EXPRESS = 4;
	public static final Integer ORDER_PAYMENT = 5;
	
	/**��ɫ**/
	/**
	 * �ͻ�{ʵ���ͻ�}
	 * �鿴:��������ʽ������ʯǩ�յ���ʵ��ǩ�յ�
	 */
	public static final String ROLE_CUST = "CUST";
	/**
	 * ���ƹ���{ʵ����Ա}
	 * �鿴���༭:��������ʽ������ʯǩ�յ���ʵ��ǩ�յ����ͻ�����
	 */
	public static final String ROLE_CC = "CC";
	/**
	 * ��Ʒ����{��Ʒ�������Э��}
	 * �鿴���༭����ʽ��
	 */
	public static final String ROLE_PM = "PM";
	/**
	 * CAD���ʦ{3D��桢�������}
	 * �༭���鿴����ʽ�����ϴ�CAD�ļ�������ͼ��
	 */
	public static final String ROLE_CAD = "CAD";
	/**
	 * ��������{���������Ϲ���}
	 * �༭���鿴�����������Ƶ����ϴ����ء�CAD������ͼ��
	 */
	public static final String ROLE_PMC = "PMC";
	/**
	 * ��ʯԱ{��ʯ�ɹ�}
	 * �༭���鿴����ʯ����������ʯ�������
	 */
	public static final String ROLE_GB = "GB";
	/**
	 * ��������Ա{�����������ƻ����ܿظ�����}
	 * �鿴�����Ƶ����ӹ�������������Ƚ����
	 */
	public static final String ROLE_PPS = "PPS";
	
	/**
	 * ����ǰ׺
	 */
	//��ʯǩ�յ�
	public static final String CODE_GEMSIGN = "GS";
	//ʵ��ǩ�յ�
	public static final String CODE_ENTITYSIGN = "ES";
	//����
	public static final String CODE_ORDER = "OD";
	//�ͻ�
	public static final String CODE_CUSTER = "CR";
	//��ʯ��
	public static final String CODE_USEGEM = "UG";
	/*****************************Viewģ���ViewName***************************/
	
	public static final String PATH_COMMON = "common/";
	public static final String COMMON_UPLOAD = "upload";
	public static final String COMMON_SHOWPIC = "showpic";
	public static final String COMMON_CHAIN = "chain";
	public static final String COMMON_GEM = "gem";
	/**ʵ��ǩ�յ�ģ��*/
	public static final String PATH_ENTITY = "entitysign/";
	public static final String ENTITY_SIGN_EDIT = "entity-sign-edit";
	public static final String ENTITY_SIGN_LIST = "entity-sign-list";
	
	/**��ʯǩ�յ�ģ��*/
	public static final String PATH_GEM = "gemsign/";
	public static final String GEM_SIGN_EDIT = "gem-sign-edit";
	public static final String GEM_SIGN_LIST = "gem-sign-list";
	
	/** �ͻ�ģ�� */
	public static final String PATH_CUSTOMER = "customer/";
	/** ��ʯ��ģ�� */
	public static final String PATH_USE_GEM = "useGem/";
	/** ���Ƶ�ģ��*/
	public static final String PATH_CUSTOM = "custom/";
	
	/**����ģ��*/
	public static final String PATH_ORDER = "order/";
	public static final String ORDER_EDIT = "order-edit";
	public static final String ORDER_LIST = "order-list";
	public static final String ORDER_VIEW = "order-view";
	
	/*****************************��������**************************/
	//����
	public static final String PAGE_TYPE_ADD = "����";
	//�༭
	public static final String PAGE_TYPE_EDIT = "�༭";
	//�鿴
	public static final String PAGE_TYPE_VIEW = "�鿴";
	

	
	/***************************** ת��·�� ***************************/
	/** ת�� */
	public static final String REDIRECT = "redirect:/";

	
	/*************************�ļ��ϴ�����***************************/
	public static final String FILE_DIR = "staticRes";//Ĭ��
	public static final String FILE_MODEL = "/temp";//��ʱģ��
	public static final String RES_TYPE_PIC = "pic";//ͼƬ
	public static final String RES_TYPE_FILE = "file";//��ͨ�ļ�
//	public static final String FILE_DIR_ORDER = "order";//����
//	public static final String FILE_DIR_CUSTOM = "custom";//���Ƶ�
//	public static final String FILE_DIR_ENTSIGN = "entsign";//ʵ��ǩ�յ�
//	public static final String FILE_DIR_GEMSIGN = "gemsign";//��ʯǩ�յ�
//	public static final String FILE_DIR_CUSTOMER = "customer";//�ͻ�
	
	/*****************************ҳ������************************/
	//�ͻ�(cust)
	public static final String PAGE_ATTR_CUST = "CUST";
	//���Ƶ�(style)
	public static final String PAGE_ATTR_STYLE = "STYLE";
	//����(order)
	public static final String PAGE_ATTR_ORDER = "ORDER";
	//��ʯǩ�յ�(gem)
	public static final String PAGE_ATTR_GEM = "GEM";
	//ʵ��ǩ�յ�(entity)
	public static final String PAGE_ATTR_ENTITY = "ENTITY";
	//��ʯ��(deploy)
	public static final String PAGE_ATTR_DEPLOY = "DEPLOY";
}
