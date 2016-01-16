package com.bavlo.counter.utils;


public class StringUtil {
	
	/**
	 * 控制str的显示字符形式（用于推盘时显示房产相关信息）
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
	 * str是否为空. 当str为null或为""时认为是空,返回true.
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * str是否不为空. 当str不为null或不为""时认为是非空,返回true.
	 */
	public static boolean isNotEmpty(String str) {
		return (str != null && str.trim().length() > 0);
	}

	/**
	 * 判断二个字符串是否相等 。 
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
	 * 判断二个字符串是否相等,忽略大小写。
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
	 * 从字符串数组转换成字符串形式 传入String[]，返回可以直接用在SQL中in()的字符串
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
	 * add by qinly [BUG]1941 in语句超过1000条时报错处理 ,处理之后变成fieldname in(...) or
	 * fieldname in(...) or fieldname in(...)
	 * 
	 * @param temp
	 * @param fieldname
	 *            字段名称
	 * @param length
	 *            in语句中的最大长度
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
					st = new StringBuffer(st.subSequence(0, st.length() - 1));// 去掉最后一个逗号
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
			//如果传入的数组长度刚好是length的倍数时，不会加上最后的‘)’，所以注释这行   hezy  08-22  折扣信息移除房产功能
//			if (i % length != 0)
				st.append(")");
		}

		return st.toString();
	}
	


}
