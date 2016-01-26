/**   
*
* @version V1.0   
*/
package com.bavlo.gemtak.utils;

/**
 * @Title: ����Counter
 * @ClassName: TypeExchangeUtils 
 * @Description: ����ת��
 * @author liuzy
 * @date 2015-9-19 ����11:33:17
 */
public class TypeExchangeUtils {
	
	public static int[] IntegerToInt(Integer[] intary){
		int[] intarr = new int[intary.length];
		for(int i = 0 ; i < intary.length ; i++){
			intarr[i] = intary[i].intValue();
		}
		return intarr;
	}
	
	public static Integer[] IntToInteger(int[] intary){
		Integer[] inteary = new Integer[intary.length];
		for(int i = 0 ; i < intary.length ; i++){
			inteary[i] = intary[i];
		}
		return inteary;
	}
	
	public static String[] IntAryToStrAry(int[] intary){
		String[] strarray = new String[intary.length];
		for(int i = 0 ; i < intary.length ; i++){
			strarray[i] = String.valueOf(intary[i]);
		}
		return strarray;
	}
	
	public static String[] IntAryToStrAry(Integer[] intary){
		String[] strarray = new String[intary.length];
		for(int i = 0 ; i < intary.length ; i++){
			strarray[i] = String.valueOf(intary[i]);
		}
		return strarray;
	}
	
	public static Integer[] StrAryToInteAry(String[] strary){
		Integer[] intarray = new Integer[strary.length];
		for(int i = 0 ; i < strary.length ; i++){
			intarray[i] = Integer.valueOf(strary[i]);
		}
		return intarray;
	}
	
	public static int[] StrAryToIntAry(String[] strary){
		int[] intarray = new int[strary.length];
		for(int i = 0 ; i < strary.length ; i++){
			intarray[i] = Integer.valueOf(strary[i]);
		}
		return intarray;
	}

}
