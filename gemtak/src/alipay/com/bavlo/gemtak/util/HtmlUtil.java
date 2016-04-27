package com.alipay.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class HtmlUtil {

	private static final String PATH="C:\\Program Files\\Apache Software Foundation\\Apache2.2\\htdocs\\";
	//	public static final String  PATH="C:\\Program Files (x86)\\Apache Software Foundation\\Apache2.2\\htdocs\\";
	public static void replaceHtml(String html,String node)
	{
		System.out.println(html+"default.html");
		File f = new File(PATH+node+".html");
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			fw.write("");
			fw.write(html);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String loadHtml(String htmlName)
	{
		String fileContent = ""; 
		try { 
			File f = new File(PATH+htmlName); 
			if(f.isFile()&&f.exists()){ 
				InputStreamReader read = new InputStreamReader(new FileInputStream(f),"GBK"); 
				BufferedReader reader=new BufferedReader(read); 
				String line; 
				while ((line = reader.readLine()) != null) { 
					fileContent += line; 
				} 
				read.close(); 
			} 
		} catch (Exception e) { 
			System.out.println("读取文件内容操作出错"); 
			e.printStackTrace(); 
		} 
		return fileContent; 
	}
}
