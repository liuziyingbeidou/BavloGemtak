package com.bavlo.gemtak.config;

/* *
 *������AlipayConfig
 *���ܣ�����������
 *��ϸ�������ʻ��й���Ϣ������·��
 *�汾��3.2
 *���ڣ�2011-03-17
 *˵����
 *���´���ֻ��Ϊ�˷����̻����Զ��ṩ���������룬�̻����Ը����Լ���վ����Ҫ�����ռ����ĵ���д,����һ��Ҫʹ�øô��롣
 *�ô������ѧϰ���о�֧�����ӿ�ʹ�ã�ֻ���ṩһ���ο���
	
 *��ʾ����λ�ȡ��ȫУ����ͺ���������ID
 *1.������ǩԼ֧�����˺ŵ�¼֧������վ(www.alipay.com)
 *2.������̼ҷ���(https://b.alipay.com/order/myOrder.htm)
 *3.�������ѯ����������(PID)��������ѯ��ȫУ����(Key)��
	
 *��ȫУ����鿴ʱ������֧�������ҳ��ʻ�ɫ��������ô�죿
 *���������
 *1�������������ã������������������������
 *2���������������ԣ����µ�¼��ѯ��
 */

public class AlipayConfig {
	
	//�����������������������������������Ļ�����Ϣ������������������������������
	// ����������ID����2088��ͷ��16λ��������ɵ��ַ���
	public static String partner = "2088701356508911";
	
	// ���װ�ȫ�����룬�����ֺ���ĸ��ɵ�32λ�ַ���
	public static String key = "vu9mctqkmhr2cz95q48yudhco6wqd8n1";
	
	// ǩԼ֧�����˺Ż������տ�֧�����ʻ�
	public static String seller_email = "bavlo@sina.com";
	
	// ֧����������֪ͨ��ҳ�� Ҫ�� http://��ʽ������·������������?id=123�����Զ������
	// ���뱣֤���ַ�ܹ��ڻ������з��ʵĵ�
	public static String notify_url = "http://www.bavlo.com/web/payNotify";
	
	// ��ǰҳ����ת���ҳ�� Ҫ�� http://��ʽ������·������������?id=123�����Զ������
	// ��������д��http://localhost/create_direct_pay_by_user_jsp_utf8/return_url.jsp ������ᵼ��return_urlִ����Ч
	public static String return_url = "http://www.bavlo.com/web/payReturn";

	//�����������������������������������Ļ�����Ϣ������������������������������
	
	// �̻���˽Կ
    // ���ǩ����ʽ����Ϊ��0001��ʱ�������øò���
    public static String private_key = "";

	// �����ã�����TXT��־·��
	public static String log_path = "c:\\alipay_log_" + System.currentTimeMillis()+".txt";

	// �ַ������ʽ Ŀǰ֧�� gbk �� utf-8
	public static String input_charset = "UTF-8";
	
	// ǩ����ʽ �����޸�
	public static String sign_type = "MD5";
	
	//����ģʽ,�����Լ��ķ������Ƿ�֧��ssl���ʣ���֧����ѡ��https������֧����ѡ��http
	public static String transport = "http";

}