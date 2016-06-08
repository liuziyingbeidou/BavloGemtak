package com.bavlo.gemtak.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.google.zxing.common.StringUtils;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: CommonUtils 
 * @Description: 工具
 * @author liuzy
 * @date 2015-11-2 下午07:14:41
 */
public class CommonUtils {
	
	public static void main(String[] args){
		System.out.println(getBillCode("CM"));
	}
	
	/**
	 * @param bnum分页 获得共几页
	 * @param pnum
	 */
	public static Integer roundByNum(Integer bnum,Integer pnum){
		if(bnum % pnum == 0){
			return bnum/pnum;
		}else{
			return (bnum/pnum)+1;
		}
	}

	//获取小图名称
	public static String getMinPicName(String uploadFileName){
		String minFileName = null;
		int index = uploadFileName.lastIndexOf(".");
        if (index != -1) {
        	minFileName = uploadFileName.substring(0, index) + "_min" + uploadFileName.substring(index);
        }
        return minFileName;
	}
	
	/**
	 * @Description: 自动编号
	 * @param @return
	 * @return String
	 */
	public static String getBillCode(String prefix){
        SimpleDateFormat fmt = new SimpleDateFormat("yyMMdd");//yyyyMMddHHmmss
        if(StringUtil.isEmpty(prefix)){
        	prefix = "GM";
        }
        Random random = new Random();
    	String randomCode = "";
    	for ( int i = 0; i < 5; i++ )
    	{
    		randomCode += Integer.toString(random.nextInt(10), 10);
    	}
        return prefix + fmt.format(new Date()) + randomCode;
    }
	
	/**
	 * 为Gid自动编号
	 * @param prefix
	 * @return
	 */
	public static String getGidCode(String prefix){
		SimpleDateFormat fmt = new SimpleDateFormat("yyMMdd");
		if(StringUtil.isEmpty(prefix)){
			prefix = "GID";
		}
		Random random = new Random();
		String code = "";
		for (int i = 0; i < 5; i++) {
			code += Integer.toString(random.nextInt(10),10);
		}
		return prefix+fmt.format(new Date())+code;
	}
	
	/**
	 * 判断参数为null/""/"null"/"  " [],
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNull(Object obj) {
		boolean flag = true;
		if (obj != null) {
			String objs = obj.toString();
			if (!"null".equals(objs) && !"".equals(objs.trim())&&!"[]".equals(objs)) {
				flag = false;
			}
		}
		return flag;
	}
}
