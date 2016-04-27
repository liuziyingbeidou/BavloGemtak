package com.alipay.util;

import java.util.ArrayList;

public class PwdUtil {

	public  static  String pwdUtil(String email)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();//存储随机数
		//ArrayList list2 = new ArrayList();//存储Email随机数
		StringBuffer pwd=new StringBuffer();//随机密码
		//int index=email.indexOf(".", 0);
		//StringBuffer sb=new StringBuffer(email);
		//sb.delete(index, index+1);
		//String str=sb.toString();
		int mathInt;//随机数

		for (int i = 0; i < 10; i++)
		{
			list.add(i);
		}
		/*
		for (char c = 'a'; c <= 'z'; c++)
		{
			list.add(c);
		}

		for (char z = 'A'; z <= 'Z'; z++)
		{
			list.add(z);
		}
		

		for(int j=0;j<str.length();j++)
		{
			list2.add(str.charAt(j));
		}
		*/
		for (int i = 0; i < 6; i++) 
		{
			mathInt=(int) (Math.random()*list.size());
			pwd.append(list.get(mathInt));								            //list.remove(mathInt);
		}

		/*
		for(int y=0;y<3;y++)
		{
			mathInt=(int) (Math.random()*list2.size());
			pwd.append(list2.get(mathInt));
		}*/
		return pwd.toString();
	}
	
	public static String pwdUtil(){
		StringBuffer password = new StringBuffer();
		for(int i = 0; i<6;i++){
			int randomNumber = (int) (Math.random()*10);
			password.append(randomNumber+"");
		}
		return password.toString();
	}
}
