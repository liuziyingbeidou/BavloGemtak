package com.bavlo.gemtak.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class NumberUtils {
	
	public static String formatWithZeroPrefix(String src, int maxLen) {
		StringBuffer bf = new StringBuffer("");
		for (int i = 0; i < maxLen; i++) {
			bf.append(0);
		}
		DecimalFormat df = new DecimalFormat(bf.toString());
		return df.format(new BigDecimal(src));
	}
	public static String format(String src, int scale,boolean ix) {
		BigDecimal bd = new BigDecimal(src);
		Double doubleV = bd.setScale(scale, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
		StringBuffer bf = new StringBuffer("0");
		if(scale>0)bf.append(".");
		for (int i = 0; i < scale; i++) {
			bf.append("0");
		}
		java.text.DecimalFormat df = new java.text.DecimalFormat(bf.toString());
		String x =  df.format(doubleV);
		if(ix){
			if(StringUtils.isNotEmpty(x) && x.indexOf(".")!=-1){
				while(x.endsWith("0")){
					x = x.substring(0,x.length()-1);
				}
				
				
				if(x.endsWith(".")){
					x = x.substring(0,x.length()-1);
				}
			}
		}
		return x;
	}

	public static String format(String src, int scale) {
		return format(src,scale,false);
	}

	public static String formatPercent(String value, int minimumFractionDigits,
			int maximumFractionDigits) {
		NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMinimumFractionDigits(minimumFractionDigits);
		nf.setMaximumFractionDigits(maximumFractionDigits);
		String output = nf.format(Double.parseDouble(value));

		return output;
	}

	public static String formatCurrency(String value,
			int minimumFractionDigits, int maximumFractionDigits) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		nf.setMinimumFractionDigits(minimumFractionDigits);
		nf.setMaximumFractionDigits(maximumFractionDigits);
		String output = nf.format(Double.parseDouble(value));

		return output;
	}

	public static String numberToChinese(String input,boolean isMoney) {
		String s1 = "零壹贰叁肆伍陆柒捌玖";
		String s4 = "分角整圆拾佰仟万拾佰仟亿拾佰仟";
		String temp = "";
		String result = "";
		if (input == null)
			return "输入的字符串只能包括以下字符（0~9,.),且最大只能精确到仟亿，小数点只能两位！";
		temp = input.trim();
		float f;
		try {
			//System.out.println(Float.parseFloat(temp));
			f = Float.parseFloat(temp);
		} catch (Exception e) {
			return "输入的字符串只能包括以下字符（0~9,.),且最大只能精确到仟亿，小数点只能两位！";
		}
		if(f==0F)temp="0";
		int len = 0;
		if (temp.indexOf(".") == -1)
			len = temp.length();
		else
			len = temp.indexOf(".");
		if (len > s4.length() - 3)
			return ("输入字符串最大只能精确到仟亿，小数点只能两位！");
		int n1 = 0;
		String num = "";
		String unit = "";
		for (int i = 0; i < temp.length(); i++) {
			if (i > len + 2) {
				break;
			}
			if (i == len) {
				continue;
			}
			
			//判断是否是负数
			if((String.valueOf(temp.charAt(i)).equals("-"))) {
				num = "负";
				result = result.concat(num);
			}else {
				n1 = Integer.parseInt(String.valueOf(temp.charAt(i)));
				num = s1.substring(n1, n1 + 1);
				n1 = len - i + 2;
				if(isMoney){
					unit = s4.substring(n1, n1 + 1);
					result = result.concat(num).concat(unit);
				}
				else{
					result = result.concat(num);
				}
			}
			//n1 = Integer.parseInt(String.valueOf(temp.charAt(i)));
			
		}
		if(isMoney){
			if ((len == temp.length()) || (len == temp.length() - 1))
				result = result.concat("整");
			if (len == temp.length() - 2)
				result = result.concat("零分");
		}
		else{
			
		}
		result = result.replace("零拾", "零");   
		result = result.replace("零佰", "零");   
		result = result.replace("零仟", "零");
		result = result.replace("零零零", "零"); 
		result = result.replace("零零", "零");
		result = result.replace("零亿", "亿");
		result = result.replace("零万", "万");
		if(result.indexOf("零圆")>0){
			result = result.replace("零圆", "圆");	
		}
		   /** 这两句不能颠倒顺序 */  
		result = result.replace("零零零零万", "");   
		result = result.replace("零零零零", "");
		result = result.replace("亿万", "亿");
		   /** 这样读起来更习惯. */  
		//result = result.replace("壹拾亿", "拾亿");   
		//result = result.replace("壹拾万", "拾万");
		//如果以金额大写是以壹拾开头的,则替换成拾,否则不用替换
		if(result.startsWith("壹拾")){
			result = result.replace("壹拾亿", "拾亿");
			result = result.replace("壹拾万", "拾万");
		}
		
		
		if(result.contains("零角零分")) {
			result=result.replace("零角零分", "整");
		}
		return result;
	}
	
	/**
	 * 判断是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		try {
			String regxa = "[+-]?[0-9]+.[0-9]+[Ee][+-]?\\d+";
			Pattern patterna = Pattern.compile(regxa);
			Matcher matchera = patterna.matcher(str);
     
			String regxb = "[+-]?[0-9]+[Ee][+-]?\\d+";
			Pattern patternb = Pattern.compile(regxb);
			Matcher matcherb = patternb.matcher(str);
     
			String regx1 = "[+-]?[0-9]+.[0-9]?\\d+";
			Pattern pattern1 = Pattern.compile(regx1);
			Matcher matcher1 = pattern1.matcher(str);
     
			String regx2 = "[+-]?[0-9]?\\d+";
			Pattern pattern2 = Pattern.compile(regx2);
			Matcher matcher2 = pattern2.matcher(str);
			
			/*输入不可以包含字符*/
			String regxLower = "[a-zA-Z]?";
			Pattern patternLower = Pattern.compile(regxLower);
			
			String latter = "[^0-9&&[^.]]";
			Pattern patternlatter = Pattern.compile(latter);
			
			int n = str.length()-1;
			
			for(int i = 0; i < n; i++) {
				String s = str.substring(i, i+1);
				Matcher matcherLower = patternLower.matcher(s);
				
				if(matcherLower.matches()) {
					return false;
				}
				
				Matcher matcherLatter = patternlatter.matcher(s);
				if(i > 0 && matcherLatter.matches()) {
					return false;
				}
			}
 
			if(!matchera.matches() && !matcherb.matches() && !matcher1.matches() && !matcher2.matches()){
				return false;
			}
		} catch (Exception e) {
		 
			e.printStackTrace();
		}
		return true;
	}
	
	public static void main(String args[]) {
//		System.out.println(isNumeric("7m3") + " 7m3 ");
//		System.out.println(isNumeric("1x70") + " 1x70");
//		System.out.println(isNumeric("1A70")  + " 1A70");
//		System.out.println(isNumeric("1D70")  + " 1D70");
//		System.out.println(isNumeric("30-8")  + " 30-8");
//		System.out.println(isNumeric("12.23")  + " 12.23");
//		System.out.println(isNumeric("430943")  + " 430943");
//		System.out.println(isNumeric("2323")  + " 2323");
//		System.out.println(isNumeric("-323")  + " -323");
//		System.out.println(isNumeric("+323.32")  + " +323.32");
//		System.out.println(isNumeric("+323.32-3")  + " +323.32-3");
//		System.out.println(isNumeric("+323.32+3")  + " +323.32+3");
//		System.out.println(isNumeric("-23424")  + " 12313123123123123123132141212312312312313123131312312412312312.231231231231231312313132131312313213132131313131313131313131231312312+");
//		System.out.println(isNumeric("+2123134543")  + "  = 12313123123123123123132141212312312312313123131312312412312312.231231231231231312313132131312313213132131313131313131313131231312312+");
//		System.out.println(isNumeric("3453523424")  + "  = 2342+");
//		System.out.println(isNumeric("12208.74")  + "  = 12208.74");
//		System.out.println(isNumeric(".234")  + ".234");
		
	}
	
	public static String convertToBigNumber(int s) {
	         String[] c = { "","一", "二", "三", "四", "五", "六", "七", "八", "九" };
	         String[] d = { "", "十", "百", "仟", "万", "拾万", "百万", "千万", "亿" };
	         String ss = s + "";// 数字强行转换成字符串
	         StringBuffer buffer = new StringBuffer();
	         for (int i = 0; i < ss.length(); i++) {
	             String k = ss.substring(i, i + 1);
	             int f = Integer.parseInt(k);
	             if (f == 0) {
	                 int u = Integer.parseInt(ss.substring(i - 1, i));
	                 if (u != 0) {
	                     buffer.append(c[0]);
	                 }
	             } else {
	                 buffer.append(c[f]);
	                 buffer.append(d[ss.length() - i - 1]);
	             }
	         }
	         //如果是10 或者十几，我们前面是没有1的
	         String numStr = buffer.toString();
	         if(numStr.length()==3){
	             if(numStr.charAt(1)=='十'&&numStr.charAt(0)=='一')
	                 return numStr.substring(1, 3);
	         }
	         if(numStr.equals("一十")){
	                 return "十";
	         }
	         return numStr;
	     } 
	
	public static String formatNumber(String num, int n) {
		StringBuffer decimal = new StringBuffer("0");
		if(n>0)decimal.append(".");
		for (int i = 0; i < n; i++) {
			decimal.append("0");
		}
		 
		if(num.contains("%")) {
			String numTemp[] = num.split("%");
			num = numTemp[0].replaceAll(",", ""); // 去掉所有逗号
			java.text.DecimalFormat df = new java.text.DecimalFormat("##,###,##"+decimal);
			return df.format(new BigDecimal(num))+"%";
		}else if(num.contains(".") && Double.parseDouble(num) != 0){
			num = num.replaceAll(",", "");
			java.text.DecimalFormat df = new java.text.DecimalFormat("###,###,###,###,###,###,###,###,###,###,###,##"+decimal);
			return df.format(new BigDecimal(num));
		}
		
		num = num.replaceAll(",", ""); // 去掉所有逗号
		java.text.DecimalFormat df = new java.text.DecimalFormat("##,###,##"+decimal);
		return df.format(new BigDecimal(num));
	}
	
	//public static String decimalFormat(String num, int n) {
//		StringBuffer decimal = new StringBuffer("0");
//		if(n>0)decimal.append(".");
//		for (int i = 0; i < n; i++) {
//			decimal.append("0");
//		}
//		 
//		if(num.contains("%")) {
//			String numTemp[] = num.split("%");
//			num = numTemp[0].replaceAll(",", ""); // 去掉所有逗号
//			java.text.DecimalFormat df = new java.text.DecimalFormat("#######"+decimal);
//			return df.format(new BigDecimal(num))+"%";
//		}else if(num.contains(".") && Double.parseDouble(num) != 0){
//			num = num.replaceAll(",", "");
//			java.text.DecimalFormat df = new java.text.DecimalFormat("###################################"+decimal);
//			return df.format(new BigDecimal(num));
//		}
//		
//		num = num.replaceAll(",", ""); // 去掉所有逗号
//		java.text.DecimalFormat df = new java.text.DecimalFormat("#######"+decimal);
//		return df.format(new BigDecimal(num));
	//}
	
	/**
	 * 四舍五入
	 * @param number 
	 * @param n 保留小数的个数， 最后一位四舍五入
	 * @return
	 */
	public static BigDecimal decimalFormat(BigDecimal number, int n) {
		return number.setScale(n, BigDecimal.ROUND_HALF_UP);
	}

	public static boolean isGt0(BigDecimal test){
		return test!=null && test.doubleValue() > 10E-10;
	}
	
	 
}
