/**   
*
* @version V1.0   
*/
package com.bavlo.gemtak.utils;

/**
 * @Title: ����Counter
 * @ClassName: SQLUtils 
 * @Description: SQL������չ
 * @author liuzy
 * @date 2015-9-19 ����11:33:27
 */
public class SQLUtils {
	
	private static final int SQL_IN_LIST_LIMIT = 200;
	/**
	 * ����In�Ӿ�
	 */
	public static String buildSqlForIn(final String fieldname,
			final String[] fieldvalue) {
		StringBuffer sbSQL = new StringBuffer();
		sbSQL.append("(" + fieldname + " IN ( ");
		int len = fieldvalue.length;
		// ѭ��д������
		for (int i = 0; i < len; i++) {
			if (fieldvalue[i] != null && fieldvalue[i].trim().length() > 0) {
				sbSQL.append("'").append(fieldvalue[i].toString()).append("'");
				// �������� ÿ��ȡֵ�����",", �������һ��ȡֵ���治�����"," ���Ҽ��� oracle �� IN 254 ���ơ�ÿ
				// 200 �� ���� or һ�Ρ�ʱҲ�������","
				if (i != (fieldvalue.length - 1)
						&& !(i > 0 && (i + 1) % SQL_IN_LIST_LIMIT == 0)) {
					sbSQL.append(",");
				}
			} else {
				return null;
			}

			// ���� oracle �� IN 254 ���ơ�ÿ 200 �� ���� or һ�Ρ�
			if (i > 0
					&& (i + 1) % SQL_IN_LIST_LIMIT == 0
					&& i != (fieldvalue.length - 1)) {
				sbSQL.append(" ) OR ").append(fieldname).append(" IN ( ");
			}
		}
		sbSQL.append(" )) ");
		return sbSQL.toString();
	}
	public static String buildSqlForIn(final String fieldname,
			final Integer[] fieldvalue) {
		StringBuffer sbSQL = new StringBuffer();
		sbSQL.append("(" + fieldname + " IN ( ");
		int len = fieldvalue.length;
		// ѭ��д������
		for (int i = 0; i < len; i++) {
			if (fieldvalue[i] != null && fieldvalue[i] > 0) {
				sbSQL.append(fieldvalue[i]);
				// �������� ÿ��ȡֵ�����",", �������һ��ȡֵ���治�����"," ���Ҽ��� oracle �� IN 254 ���ơ�ÿ
				// 200 �� ���� or һ�Ρ�ʱҲ�������","
				if (i != (fieldvalue.length - 1)
						&& !(i > 0 && (i + 1) % SQL_IN_LIST_LIMIT == 0)) {
					sbSQL.append(",");
				}
			} else {
				return null;
			}

			// ���� oracle �� IN 254 ���ơ�ÿ 200 �� ���� or һ�Ρ�
			if (i > 0
					&& (i + 1) % SQL_IN_LIST_LIMIT == 0
					&& i != (fieldvalue.length - 1)) {
				sbSQL.append(" ) OR ").append(fieldname).append(" IN ( ");
			}
		}
		sbSQL.append(" )) ");
		return sbSQL.toString();
	}
}
