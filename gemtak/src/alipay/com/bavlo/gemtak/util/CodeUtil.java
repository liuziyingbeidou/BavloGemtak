package com.bavlo.gemtak.util;

import java.util.ArrayList;
import java.util.List;

public class CodeUtil {

	public static String codeUtil(){
		
		List<Object> list = new ArrayList<Object>();
		StringBuffer sb = new StringBuffer();
		int mathInt;//随机数
		for(int i = 0; i<10; i++){
			list.add(i);
		}
		for(char c='a';c<='z';c++){
			list.add(c);
		}
		for(int j = 0;j < 9;j++){
			mathInt=(int) (Math.random()*list.size());
			sb.append(list.get(mathInt));	
		}
		return sb.toString();
	}
}
