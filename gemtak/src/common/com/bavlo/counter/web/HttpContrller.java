package com.bavlo.counter.web;

import java.math.BigDecimal;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bavlo.counter.httpclient.HttpTools;

/**
 * @Title: ����Counter
 * @ClassName: HttpContrller 
 * @Description: ajax��Զ�̽ӿڵķ���(json)
 * @author liuzy
 * @date 2015-10-21 ����04:50:48
 */
@Controller
@RequestMapping(value="/webservice")
public class HttpContrller extends BaseController {

	@RequestMapping(value="/http",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String request(String url){
		//url.replace("@", "&");
		System.out.println("��ʼ����Զ�̽ӿ�..."+url);
		String info = HttpTools.getDataByURL(url);
		System.out.println("��������:"+info);
		return info;
	}
	
	@RequestMapping(value="/httprequest",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String httprequest(String requestUrl, String requestMethod, String outputStr){
		
		System.out.println("��ʼ����Զ�̽ӿ�..."+requestUrl);
		String info = null;
		if("GET".equals(requestMethod)){
			info = HttpTools.submitGet(requestUrl);
		}else if("POST".equals(requestMethod)){
			info = HttpTools.submitPost(requestUrl, outputStr)+"";
		}
		System.out.println("��������:"+info);
		return info;
	}
	
	
	@RequestMapping(value="/httpcalculator",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String httpcalculator(String requestUrl, String outputStr){
		
		System.out.println("��ʼ����Զ�̽ӿ�..."+requestUrl);
		String info = null;

		info = HttpTools.submitPost(requestUrl, outputStr)+"";
		System.out.println("��������:"+info);
		StringBuffer sb = new StringBuffer(info);
		return sb.toString();
	}
}
