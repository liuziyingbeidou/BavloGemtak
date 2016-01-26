/**   
*
* @version V1.0   
*/
package com.bavlo.gemtak.utils;

import java.lang.reflect.InvocationTargetException;

import com.bavlo.gemtak.dao.HibernateDAO;


/**
 * @Title: ����Counter
 * @ClassName: IUniqueRule 
 * @Description: Ψһ��У��
 * @author liuzy
 * @date 2015-9-19 ����11:32:49
 */
public interface IUniqueRule {
	/**
	 * ����Ψһ�ֶ���ϡ�<br>
	 *
	 * @return java.lang.String[] Ψһ�ֶ���ϡ�<br>
	 */
	public java.lang.String[] getFields();
	/**
	 * ������ʾ��Ϣ��<br>
	 *
	 * @return java.lang.String ��ʾ��Ϣ��<br>
	 */
	String getHint();
	String getErrMsg();
	public void setFieldnames(String[] fieldnames) ;
	public boolean check(Object entity,HibernateDAO dao)throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException;
	public void setWherePart(String wherePart);
}
