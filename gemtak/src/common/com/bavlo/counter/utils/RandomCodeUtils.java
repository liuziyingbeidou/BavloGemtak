package com.bavlo.counter.utils;

import java.util.Random;

public class RandomCodeUtils {
	public static String getRandomCode(Integer length,String base){
		// 创建一个随机数生成器类。
	 	Random random = new Random();
		StringBuffer randomCode = new StringBuffer();
	 	int size = base.length();
	 	// 随机产生4位数字的验证码。
	 	for (int i = 0; i < length; i++) {
	 		int start = random.nextInt(size);
	 		String strRand = base.substring(start, start + 1);
	 		randomCode.append(strRand);
	 	}
		return randomCode.toString();
	}
}
