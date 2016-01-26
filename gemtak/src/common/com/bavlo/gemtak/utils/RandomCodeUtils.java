package com.bavlo.gemtak.utils;

import java.util.Random;

public class RandomCodeUtils {
	public static String getRandomCode(Integer length,String base){
		// ����һ��������������ࡣ
	 	Random random = new Random();
		StringBuffer randomCode = new StringBuffer();
	 	int size = base.length();
	 	// �������4λ���ֵ���֤�롣
	 	for (int i = 0; i < length; i++) {
	 		int start = random.nextInt(size);
	 		String strRand = base.substring(start, start + 1);
	 		randomCode.append(strRand);
	 	}
		return randomCode.toString();
	}
}
