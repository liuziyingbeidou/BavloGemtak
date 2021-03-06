package com.bavlo.gemtak.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.bavlo.gemtak.commonbeans.Page;
import com.bavlo.gemtak.utils.JsonUtils;
import com.bavlo.gemtak.utils.StringHelper;
import com.bavlo.gemtak.utils.WebUtils;

/**
 * @Title: 宝珑Counter
 * @ClassName: BaseAction 
 * @Description:  
 * @author liuzy
 * @date 2015-9-20 下午04:05:13
 */
public class BaseAction {
	
	//分页-start
	protected Integer dgpage=30;
	protected Integer rows;
	//分页-end
	
	protected void renderJson(Object object, JsonConfig config) {
		JSONObject jsonObject = JSONObject.fromObject(object, config);
		renderJson(jsonObject.toString());
	}
	protected void renderJson(Object object) {
		JSONObject jsonObject = JSONObject.fromObject(object);
		renderJson(jsonObject.toString());
	}
	protected void renderJson(Page page) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("items", page.getItems());
		jsonMap.put("total", page.getTotal());
		renderJson(jsonMap);
	}
	
	protected void renderJson(Map<String, ?> jsonMap) {
		JSONObject jsonObject = JSONObject.fromObject(jsonMap,JsonUtils.configJson("yyyy-MM-dd"));
		String s = jsonObject.toString();
		renderJson(s);
	}

	protected void renderJson(Map<String, ?> jsonMap, JsonConfig config) {
		JSONObject jsonObject = JSONObject.fromObject(jsonMap, config);
		String s = jsonObject.toString();
		renderJson(s);
	}
	
	protected void renderJson(List<?> list) {
		JSONArray JSONArray = net.sf.json.JSONArray.fromObject(list,JsonUtils.configJson("yyyy-MM-dd"));
		renderJson(JSONArray.toString());
	}

	protected void renderJson(List<?> list, JsonConfig config) {
		JSONArray JSONArray = net.sf.json.JSONArray.fromObject(list, config);
		renderJson(JSONArray.toString());
	}

	protected void renderJson(List<?> list, String entityKey, JsonConfig config) {
		List<Map<String, Object>> jsonList = JsonUtils.toMapList(list, entityKey);
		renderJson(jsonList, config);
	}
	
	/**
	 * 直接输出json字符串.
	 * @param json
	 * @return
	 */
	protected void renderJson(String json) {
		render(json, "text/json;charset=UTF-8");
	}

	
	/**
	 * 直接输出JS字符串.
	 * @param jsText
	 * @return
	 */
	protected void renderJs(String jsText) {
		render(jsText, "application/x-javascript;charset=utf-8");
	}
	
	/**
	 * 直接输出字符串.
	 */
	protected void renderText(String text) {
		WebUtils.setNoCacheHeader(ServletActionContext.getResponse());
		render(text, "text/plain;charset=UTF-8");
	}

	/**
	 * 直接输出HTML.
	 */
	protected void renderHtml(String html) {
		render(html, "text/html;charset=UTF-8");
	}

	/**
	 * 直接输出XML.
	 */
	protected void renderXML(String xml) {
		
		render(xml, "text/xml;charset=UTF-8");
	}
	
	protected void render(String text, String contentType) {
		try {
			WebUtils.setNoCacheHeader(ServletActionContext.getResponse());
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType(contentType);
			response.getWriter().write(text);
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 输出FusionCharts的XML
	 * 
	 * @param xml
	 */
	protected void renderFusionChartsXML(String xml) {

		try {
			WebUtils.setNoCacheHeader(ServletActionContext.getResponse());
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/xml; charset=UTF-8");
			OutputStream outs = response.getOutputStream();
			outs.write(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF });
			outs.flush();
			outs.write(xml.getBytes("UTF-8"));
			outs.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public  String truncate(String str, int bytelength, String sufix) {
		
		return StringHelper.truncate(str, bytelength, sufix);
	}
	
	public void CheckNotNull(Object ...objects ){
		WebUtils.CheckNotNull(objects);
	}
	
	public void CheckInValidChars(String... Strings) {
		WebUtils.CheckInValidChars(Strings);
	}

	public void CheckInValidSQLChars(String... a) {
		WebUtils.CheckInValidSQLChars(a);
	}
	
	public void renderJson(Object... vals) {
		Map jsonMap =new HashMap();
		
		for(int i = 0;vals !=null && i<vals.length;i+=2){
			Object i1 = vals[i];
			Object i2 = vals[i+1];
			jsonMap.put(i1, i2);
		}
		this.renderJson(jsonMap);
	}
	
	public Integer getDgpage() {
		return dgpage;
	}

	public void setDgpage(Integer dgpage) {
		this.dgpage = dgpage;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
}
