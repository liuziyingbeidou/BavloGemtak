package com.bavlo.counter.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;

/**
 * @Title: ����Counter
 * @ClassName: Constant 
 * @Description: ϵͳ�������� 
 * @author liuzy
 * @date 2015-9-19 ����11:54:55
 */
public class Constant {
    
    
    public static final String INDEXURL = "frame!index.do";

    public static final String LOGINURL = "index.jsp";

    public static final int MENU_MAXLEVEL = 2;

    public static final int EXE_STATUS_SUCCESS = 1;

    public static final int EXE_STATUS_FALIURE = 0;
    
    /**
     * ���õ���־��¼ ����yu ��Ӧ��URL
     * �û���־��ʾ��
     */
    public static Map<String,String> LOGDEFINE_MAP = new LinkedHashMap<String, String>();
    
    public static String LOGDEFINE_LASTDATE = "";

    // ϵͳ����
    public static final String LOGININFO = "LOGININFO"; 

    public static final String ROLE_CODE_ADMIN = "ROLE_ADMIN";

    public static final String ROLE_NAME_ADMIN = "����Ա";

    public static final String USER_SA_LOGIN_NAME = "sa";

    public static final String USER_SA_USER_NAME = "��������Ա";

    public static final String USER_SA_PASSWORD = "bigbucks";

    public static final String FALSE = "false";

    public static final String TRUE = "true";

    public static final String YES = "y";

    public static final String NO = "n";

    public static final int INT_TRUE = 1;

    public static final int INT_FALSE = 0;

    public static final String UNLIMIT = "unlimit";  

    public static boolean PAGE_ENCODING = false;

    public static boolean SERVER_ENCODING = false;

    public static boolean SHOW_ALL_CATEGORG = false;

    public static boolean IGNORE_BAD_URL_FUNC = false;

    public static Map<String, String> serverInfoMap = new HashMap<String, String>();

    // ϵͳ����
    public static String CONFIG_PATH;

    public static int PAGE_SIZE = 15;
    public static Integer[] PAGE_SELECT = new Integer[]{5,10,15,20,25,30};
    

    public static Map<String, String> zoneCache = new HashMap<String, String>();

    public static Map<String, Map<String, String>> dictCache = new HashMap<String, Map<String, String>>();

    // ϵͳ����
    public static ApplicationContext AppContext;

    public static MessageSource MESSAGE;

    public static String TEMP_PATH = null;

    public static boolean enableMsgSender = false;

    public static boolean isDebugMode = true;

    public static String ServerInfo;

    // �ύ��ʾ��Ϣ
    public static String SUBMIT_MESSAGE = "ϵͳ����Ĳ�����������������ȵ�����棬��ȷ��������ٵ���ύ����ȷ��Ҫ�ύ��";

}
