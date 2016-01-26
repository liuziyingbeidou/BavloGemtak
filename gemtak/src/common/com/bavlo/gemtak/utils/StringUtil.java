package com.bavlo.gemtak.utils;


public class StringUtil {
	
	/**
	 * ����str����ʾ�ַ���ʽ����������ʱ��ʾ���������Ϣ��
	 * @param str
	 * @return
	 */
	public static String getShowString(String str){
		if(str ==null || str.length()==0 || "null".equals(str.toLowerCase())){
			return "";
		}
		return str.trim();
	}

	/**
	 * str�Ƿ�Ϊ��. ��strΪnull��Ϊ""ʱ��Ϊ�ǿ�,����true.
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * str�Ƿ�Ϊ��. ��str��Ϊnull��Ϊ""ʱ��Ϊ�Ƿǿ�,����true.
	 */
	public static boolean isNotEmpty(String str) {
		return (str != null && str.trim().length() > 0);
	}

	/**
	 * �ж϶����ַ����Ƿ���� �� 
	 * StringUtil.equals(null,null)=true;
	 * StringUtil.equals(null,"abc")=false; 
	 * StringUtil.equals("abc",null)=false
	 * StringUtil.equals("abc","abc")=true 
	 * StringUtil.equals("abc","ABC")=false
	 */
	public static boolean equals(String str1, String str2) {
		return str1 == null ? str2 == null : str1.equals(str2);
	}

	/**
	 * �ж϶����ַ����Ƿ����,���Դ�Сд��
	 *  StringUtil.equals(null,null)=true;
	 * StringUtil.equals(null,"abc")=false; 
	 * StringUtil.equals("abc",null)=false
	 * StringUtil.equals("abc","abc")=true 
	 * StringUtil.equals("abc","ABC")=true
	 */
	public static boolean equalsIgnoreCase(String str1, String str2) {
		return str1 == null ? str2 == null : str1.equalsIgnoreCase(str2);
	}

	/**
	 * ���ַ�������ת�����ַ�����ʽ ����String[]�����ؿ���ֱ������SQL��in()���ַ���
	 */
	public static String arrayToString(String[] temp) {
		StringBuffer st = null;
		if (temp != null && temp.length > 0) {
			st = new StringBuffer();
			for (int i = 0; i < temp.length; i++) {
				st.append("'");
				st.append(temp[i]);
				st.append("'");
				st.append(",");
			}
		}
		if (st != null) {
			return st.substring(0, st.length() - 1).toString();
		}
		return "";
	}
	
	public static String arrayToSqlCond(String[] temp) {
		StringBuffer st = new StringBuffer("");
		if (temp != null) {
			st = new StringBuffer();
			int len = temp.length;
			if (len == 0) {
				st.append("='errorCond'");
			} else if (len == 1) {
				st.append(" ='").append(temp[0]).append("'");
			} else if (len > 1) {
				st.append(" in (");
				for (int i = 0; i < len; i++) {
					st.append("'");
					st.append(temp[i]);
					st.append("'");
					if (i < len - 1)
						st.append(",");
				}
				st.append(")");
			}
		} else {
			st.append("='errorCond'");
		}
		return st.toString();
	}

	/**
	 * add by qinly [BUG]1941 in��䳬��1000��ʱ������ ,����֮����fieldname in(...) or
	 * fieldname in(...) or fieldname in(...)
	 * 
	 * @param temp
	 * @param fieldname
	 *            �ֶ�����
	 * @param length
	 *            in����е���󳤶�
	 * @return
	 */
	public static String arrayToSqlCond(String[] temp, String fieldname,
			int length) {
		StringBuffer st = new StringBuffer("");
		if (temp != null && temp.length > length) {
			int len = temp.length;
			int i = 0;
			st.append(fieldname);
			st.append(" in (");
			for (i = 0; i < len; i++) {
				if (i != 0 && i % length == 0) {
					st = new StringBuffer(st.subSequence(0, st.length() - 1));// ȥ�����һ������
					st.append(") or ");
					st.append(fieldname);
					st.append(" in (");
				}
				st.append("'");
				st.append(temp[i]);
				st.append("'");
				if (i < len - 1)
					st.append(",");
			}
			//�����������鳤�ȸպ���length�ı���ʱ������������ġ�)��������ע������   hezy  08-22  �ۿ���Ϣ�Ƴ���������
//			if (i % length != 0)
				st.append(")");
		}

		return st.toString();
	}
	


}
