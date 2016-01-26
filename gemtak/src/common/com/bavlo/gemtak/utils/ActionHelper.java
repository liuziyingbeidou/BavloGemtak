package com.bavlo.gemtak.utils;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class ActionHelper {
	
	public static String getActionName(String url){
		int dotIndex = url.indexOf(".");
		int whIndex =  url.indexOf("?");
		int sIndex =  url.lastIndexOf("/")==-1?0:url.lastIndexOf("/")+1;
		//../../user!list
		if(dotIndex==-1 && whIndex==-1){
			return url.substring(sIndex);
		}
		//../../user!list?start=1&limit=9
		else if(dotIndex==-1 && whIndex!=-1){
			return url.substring(sIndex,whIndex);
		}
		//../../user!list.do
		else if(dotIndex!=-1 && whIndex==-1){
			return url.substring(sIndex,dotIndex);
		}
		//../../user!list.do?start=1&limit=9
		else if(dotIndex!=-1 && whIndex!=-1){
			return url.substring(sIndex,dotIndex);
		}
		
		return "";
	}
	/**
	 * 获取URL中的Action后缀
	 * @param url
	 * @return
	 */
	public static String getActionSufix(String url) {
		
		int dotIndex = url.indexOf(".");
		int whIndex =  url.indexOf("?");
		
		//user!list
		if(dotIndex==-1 && whIndex==-1){
			return "";
		}
		//user!list?start=1&limit=9
		else if(dotIndex==-1 && whIndex!=-1){
			return "";
		}
		//user!list.do
		else if(dotIndex!=-1 && whIndex==-1){
			return url.substring(dotIndex);
		}
		//user!list.do?start=1&limit=9
		else if(dotIndex!=-1 && whIndex!=-1){
			return url.substring(dotIndex,whIndex);
		}
		
		return "";
	}
	
	public static String getActionSufix(HttpServletRequest request){
		String requestURI = (String)request.getAttribute("requestURI");
		if(StringUtils.isNotEmpty(requestURI)){
			return getActionSufix(requestURI);
		}
		else{
			return getActionSufix(request.getRequestURI());
		}
	}
	
	public static String getAction(String actionName,HttpServletRequest request){
		return actionName.indexOf(".")==-1 ?  actionName + getActionSufix(request) : actionName;
	}
	
	
	public static String getActionUrl(HttpServletRequest request,String actionName,String params,boolean includeParentParams,String...includes){
		String sParams = "";
		
		String actionSufix = getActionSufix(request);
		String action = actionName + actionSufix;
		
	
		if(includeParentParams && includes!=null && includes.length>0){
			sParams = getParentParams(request,params,true,includes);
		}
		else{
			sParams = params;
		}
		String url = action + (StringUtils.isNotEmpty(sParams) ?  "?" + sParams : "");
		return url;
	}
	
	public static String getActionUrl(HttpServletRequest request,String actionName,String actionSufix,String params,boolean includeParentParams,String...includes){
		String sParams = "";
		String action = actionName + actionSufix;
		
		if(includeParentParams && includes!=null && includes.length>0){
			sParams = getParentParams(request,params,true,includes);
		}
		else{
			sParams = params;
		}
		
		String w_char = action.indexOf("?")==-1? "?" : "&";
		String url = action + (StringUtils.isNotEmpty(sParams) ?  w_char + sParams : "");
		return url;
	}
	
	/**
	 * 生成指定Action后缀的url
	 * @param url
	 * @param actionSufix
	 * @return
	 */
	public static String replaceActionSufix(String url,String actionSufix) {
		
		int dotIndex = url.indexOf(".");
		int whIndex =  url.indexOf("?");
		//user.do?i=0
		String returnURL = "";
		//user!list
		if(dotIndex==-1 && whIndex==-1){
			returnURL = url + actionSufix;
		}
		//user!list?start=1&limit=9
		else if(dotIndex==-1 && whIndex!=-1){
			String paramsTemp = url.substring(whIndex);
			returnURL = url + actionSufix + paramsTemp;
		}
		//user!list.do
		else if(dotIndex!=-1 && whIndex==-1){
			String targetSufix = url.substring(dotIndex);
			returnURL = url.replace(targetSufix, actionSufix);
		}
		//user!list.do?start=1&limit=9
		else if(dotIndex!=-1 && whIndex!=-1){
			String targetSufix = url.substring(dotIndex,whIndex);
			returnURL = url.replace(targetSufix, actionSufix);
		}
		
		
		return returnURL;
	}
	
	
	@SuppressWarnings("unchecked")
	public static String getParentParams(HttpServletRequest request,String params,boolean mergeParams,String...includes){
		
		String parent_params = "";
		Set<String> paramsList = new HashSet<String>();
		if(includes!=null&&includes.length>0){
			for(String paramName : includes){
				if(StringUtils.isNotEmpty(params) && params.indexOf(paramName)!=-1){
					continue;
				}
				paramsList.add(paramName);
			}
		}
		else{
			Enumeration<String>  e = request.getParameterNames();
			while(e.hasMoreElements()){
				String paramName = e.nextElement();
				//params优先覆盖
				if(StringUtils.isNotEmpty(params) && params.indexOf(paramName)!=-1){
					continue;
				}
				paramsList.add(paramName);
			}
		}
		if(paramsList.size()>0){
			for(String paramName : paramsList){
				Object pv = request.getParameterMap().get(paramName);
				if(pv!=null){
				    //永远返回flase
					/*if(pv instanceof String){
						parent_params = "&" + paramName + "=" +  pv;
					}*/
					if(pv instanceof String[]){
						for(String pvItem : (String[])pv){
							parent_params = "&" + paramName + "=" +  pvItem;
						}
					}
				}
			}
		}
		if(StringUtils.isNotEmpty(parent_params) && parent_params.startsWith("&")){
			parent_params = parent_params.substring(1);
		}
		if(StringUtils.isNotEmpty(params) && params.startsWith("&")){
			params = params.substring(1);
		}
		if(StringUtils.isNotEmpty(params) && params.endsWith("&")){
			params = params.substring(0,params.length()-1);
		}
		
		String returnParams = "";
		if(mergeParams){
			if(StringUtils.isEmpty(parent_params) && StringUtils.isEmpty(params)){
				returnParams = "";
			}
			else if(StringUtils.isNotEmpty(parent_params) && StringUtils.isEmpty(params)){
				returnParams = parent_params;
			}
			else if(StringUtils.isNotEmpty(parent_params) && StringUtils.isNotEmpty(params)){
				returnParams = params + "&" + parent_params;
			}
			else if(StringUtils.isEmpty(parent_params) && StringUtils.isNotEmpty(params)){
				returnParams = params;
			}
		}
		return returnParams;
	}

	public static String appendToParams(String params, String key, String value) {
		String returnParams = (params==null?"":params);
		if(StringUtils.isNotEmpty(value)&&!"null".equalsIgnoreCase(value)){
			if(StringUtils.isEmpty(returnParams)){
				returnParams = key + "=" + value;
			}
			else{
				returnParams = "&" + key + "=" + value;
			}
		}
		return returnParams;
	}
	
	
	
}
