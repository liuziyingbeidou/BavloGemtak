package com.bavlo.counter.commonbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BtcConstant {
	
	
	public static List<String> notCheckProperty = new ArrayList<String>();
	
	
	public static List<String> checkHtmlMarkers = new ArrayList<String>();
	
	public static List<String> excludes = new ArrayList<String>();
	
	static{
		checkHtmlMarkers.add("frame");
		checkHtmlMarkers.add("alert");
		checkHtmlMarkers.add("<script");
		checkHtmlMarkers.add("<img");
		checkHtmlMarkers.add("<a");
		checkHtmlMarkers.add("'");
		checkHtmlMarkers.add("and+");
		checkHtmlMarkers.add("+and");
		checkHtmlMarkers.add("and ");
		checkHtmlMarkers.add(" and");
		
		//checkHtmlMarkers.add("'");
		
		
	}
	
	
	public static boolean match(String str){
		String regEx="\\S*\\d+=\\d+\\S*";  
        Pattern   p   =   Pattern.compile(regEx);     
        Matcher   m   =   p.matcher(str);  
        
        return m.matches();
	}
	
	
	public static void main(String[] a){
		
		System.out.println(match("165/**/and/**/7659=7659"));
	}
	
	static{
		excludes.add("yqProject.noticeContent");
		excludes.add("yqProject.inviteContent");
		excludes.add("announcementTemplate.announcementContent");
		excludes.add("addtionalContent");
		excludes.add("previewContent");
	}
}
