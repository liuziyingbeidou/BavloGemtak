/**   
*
* @version V1.0   
*/
package com.bavlo.gemtak.utils;

import java.lang.reflect.InvocationTargetException;

import com.bavlo.gemtak.dao.HibernateDAO;


/**
 * @author Administrator
 *  ��������
 */
public interface ICheckRule {

	/**
	 * �����ֶ��Ƿ�ɿա�<br>
	 *
	 * @return boolean �ɿշ���true�����򷵻�false��ȱʡΪfalse��<br>
	 */
	boolean canNull();
	/**
	 * �����ֶ���ʾ���ơ�<br>
	 *
	 * @return java.lang.String<br>
	 */
	String[] getDisplayName();
	/**
	 * �����ֶ����ơ�<br>
	 *
	 * @return java.lang.String<br>
	 */
	String[] getFieldName();
	
	String getErrMsg();
	
	public boolean check(Object entity,HibernateDAO dao)throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException;


}
