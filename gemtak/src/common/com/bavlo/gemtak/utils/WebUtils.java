package com.bavlo.gemtak.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.bavlo.gemtak.commonbeans.BtcConstant;
import com.bavlo.gemtak.commonbeans.Page;
import com.bavlo.gemtak.config.Constant;
import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.exception.JException;


public class WebUtils { 

	public static String getServetPath(HttpServletRequest httpServletRequest) {
		String serverPath = httpServletRequest.getScheme() + "://"
				+ httpServletRequest.getServerName() + ":"
				+ httpServletRequest.getServerPort()
				+ httpServletRequest.getContextPath();

		return serverPath;
	}

	public static void initServerInfo(HttpServletRequest request) {
		request.setAttribute("contextPath", request.getContextPath());
		request.setAttribute("serverPath", getServetPath(request));
		request.setAttribute("serverPort", String.valueOf(request
				.getServerPort()));
		request.setAttribute("serverName", request.getServerName());

		request.setAttribute("requestURI", request.getRequestURI());
		request.setAttribute("requestURL", request.getRequestURL().toString());
		if (StringUtils.isEmpty(Constant.CONFIG_PATH))
			Constant.CONFIG_PATH = ServletActionContext.getServletContext()
					.getRealPath("/");
	}

	public static void renderFusionchartXML(HttpServletResponse response,
			String xml) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/xml; charset=UTF-8");
			OutputStream outs = response.getOutputStream();
			outs.write(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF });
			outs.flush();
			outs.write(xml.getBytes("UTF-8"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void render(HttpServletResponse response, String text,
			String contentType) {
		try {
			response.setContentType(contentType);
			response.getWriter().write(text);
		} catch (IOException e) {

		}
	}

	/**
	 * ֱ������ַ���.
	 */
	public static void renderText(HttpServletResponse response, String text) {
		render(response, text, "text/plain;charset=UTF-8");
	}

	/**
	 * ֱ�����HTML.
	 */
	public static void renderHtml(HttpServletResponse response, String html) {
		render(response, html, "text/html;charset=UTF-8");
	}

	/**
	 * ֱ�����XML.
	 */
	public static void renderXML(HttpServletResponse response, String xml) {
		render(response, xml, "text/xml;charset=UTF-8");
	}

	/**
	 * ֱ�����JSON.
	 */
	public static void renderJson(HttpServletResponse response, String json) {
		render(response, json, "text/json;charset=UTF-8");
	}

	/**
	 * ֱ�����JS.
	 */
	public static void renderJs(HttpServletResponse response, String jsText) {
		render(response, jsText, "application/x-javascript;charset=utf-8");
	}

	/**
	 * ���ÿͻ��˻������ʱ�� Header.
	 */
	public static void setExpiresHeader(HttpServletResponse response,
			long expiresSeconds) {
		// Http 1.0 header
		response.setDateHeader("Expires", System.currentTimeMillis()
				+ expiresSeconds * 1000);
		// Http 1.1 header
		response.setHeader("Cache-Control", "max-age=" + expiresSeconds);
	}

	/**
	 * ���ÿͻ����޻���Header.
	 */
	public static void setNoCacheHeader(HttpServletResponse response) {
		// Http 1.0 header
		response.setDateHeader("Expires", 0);
		// Http 1.1 header
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setHeader("Cache-control", "private, no-cache, no-store");
		response.setHeader("Expires", "0");
		response.setStatus(HttpServletResponse.SC_OK);

		setLastModifiedHeader(response, System.currentTimeMillis() - 10000);
		setExpiresHeader(response, 1);
	}

	/**
	 * ����LastModified Header.
	 */
	public static void setLastModifiedHeader(HttpServletResponse response,
			long lastModifiedDate) {
		response.setDateHeader("Last-Modified", lastModifiedDate);
	}

	/**
	 * ������������������ضԻ����Header.
	 * 
	 * @param fileName
	 *            ���غ���ļ���.
	 * @throws UnsupportedEncodingException
	 */
	public static void setDownloadableHeader(HttpServletResponse response,
			String fileName) throws Exception {
		fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ fileName + "\"");
	}

	/**
	 * ȡ�ô���ͬǰ׺��Request Parameters.
	 * 
	 * ���صĽ��Parameter����ȥ��ǰ׺.
	 */

	public static Map<String, Object> getParametersStartingWith(
			HttpServletRequest request, String prefix) {
		return org.springframework.web.util.WebUtils.getParametersStartingWith(
				request, prefix);
	}

	public static void renderJson(HttpServletResponse response, Page page) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("items", page.getItems());
		jsonMap.put("total", page.getTotal());
		renderJson(response, jsonMap);
	}

	public static void renderJson(HttpServletResponse response,
			Map<String, Object> jsonMap) {
		JSONObject jsonObject = JSONObject.fromObject(jsonMap, JsonUtils
				.configJson("yyyy-MM-dd"));
		renderJson(response, jsonObject.toString());
	}

	public static void renderJson(HttpServletResponse response,
			Map<String, Object> jsonMap, JsonConfig config) {

		JSONObject jsonObject = JSONObject.fromObject(jsonMap, config);
		renderJson(response, jsonObject.toString());
	}

	public static void renderJson(HttpServletResponse response, Object object) {
		JSONObject jsonObject = JSONObject.fromObject(object, JsonUtils
				.configJson("yyyy-MM-dd"));
		renderJson(response, jsonObject.toString());
	}

	public static void renderJson(HttpServletResponse response, Object object,
			JsonConfig config) {
		JSONObject jsonObject = JSONObject.fromObject(object, config);
		renderJson(response, jsonObject.toString());
	}

	public static void renderJson(HttpServletResponse response, List<?> list) {
		JSONArray JSONArray = net.sf.json.JSONArray.fromObject(list, JsonUtils
				.configJson("yyyy-MM-dd"));
		renderJson(response, JSONArray.toString());
	}

	public static String getParameter(HttpServletRequest request,
			String paramName, boolean setAttribute) {
		return getParameter(request, paramName, null, setAttribute);
	}


	public static void CheckNotNull(Object... objects) {
		if (objects != null) {
			for (Object o : objects) {
				if (o == null) {
					throw new JException("����ʵ����Ӳ����ڻ��߲����������");

				}
			}
		}

	}

	public static void CheckInValidSQLChars(String... objects) {
		if (objects != null) {
			for (String o : objects) {
				if (o != null && o.indexOf("%") != -1) {
					throw new JException("�����з��ַǷ��ַ���");

				}
			}
		}

	}

	public static void CheckInValidChars(String... Strings) {
		if (Strings != null) {
			for (String o : Strings) {

//				if (o != null
//						&& (o.startsWith("http://") || Pattern.compile(
//								"\\S*\\d+=\\d+\\S*").matcher(o).matches())) {
//					throw new JException("�����з��ַǷ��ַ���");
//				}

				for (String def : BtcConstant.checkHtmlMarkers) {
					if (o != null && (o.toLowerCase().indexOf(def) != -1)) {
						throw new JException("�����з��ַǷ��ַ���");
					}
				}
			}
		}

	}

	public static String getParameter(HttpServletRequest request,
			String paramName, String defaultValue, boolean setAttribute) {

		String paramValue = request.getParameter(paramName);

		String pageEncodingString = request.getParameter("pageEncoding");

		boolean pageEncoding = StringHelper.parseBoolean(pageEncodingString)
				|| StringUtils.isEmpty(pageEncodingString)
				&& Constant.PAGE_ENCODING;

		paramValue = paramValue == null && defaultValue != null ? defaultValue
				: paramValue;
		if (paramValue != null) {
			paramValue = paramValue.trim();
			if ("GET".equalsIgnoreCase(request.getMethod())) {
				try {
					if (pageEncoding) {
						if (!Constant.SERVER_ENCODING) {
							paramValue = new String(paramValue
									.getBytes("ISO8859-1"), "GBK");
						}
					} else {
						if (!Constant.SERVER_ENCODING) {
							paramValue = new String(paramValue
									.getBytes("ISO8859-1"), "UTF-8");
						}
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		if (setAttribute)
			request.setAttribute(paramName, paramValue);

		if (StringUtils.isNotEmpty(paramValue)) {
			CheckInValidChars(paramValue);
		}
		return paramValue;
	}
	
	/**
     * �������ֻ�ȡcookie
     * @param request
     * @param name cookie����
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request,String name){
        Map<String,Cookie> cookieMap = ReadCookieMap(request);
        if(cookieMap.containsKey(name)){
            Cookie cookie = (Cookie)cookieMap.get(name);
            return cookie;
        }else{
            return null;
        }   
    }
      
      
      
    /**
     * ��cookie��װ��Map����
     * @param request
     * @return
     */
    private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){  
        Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
        Cookie[] cookies = request.getCookies();
        if(null!=cookies){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
    
    /**
     * @Description: ��ȡ��������
     * @param @param request
     * @param @return
     * @return String
     */
    public static String getLang(HttpServletRequest request){
    	String StrLang = IConstant.ZH_CN;
    	Cookie  lcki = getCookieByName(request,IConstant.COOKIE_LANG);
    	if(lcki != null){
    		if(lcki.getValue() != null && !"".equals(lcki.getValue())){
    			StrLang = lcki.getValue();
    		}
    	}
    	return StrLang;
    }
    
    /**
     * @Description: ��ȡ�ͻ���IP
     * @param @param request
     * @param @return
     * @return String
     */
    public static String getIpAddr(HttpServletRequest request) { 
        String ip = request.getHeader("x-forwarded-for"); 
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("Proxy-Client-IP"); 
        } 
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("WL-Proxy-Client-IP"); 
        } 
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getRemoteAddr(); 
        } 
        return ip; 
    } 
    
    /**
     * @Description: jdk��ȡ�ͻ���IP
     * @param @param request
     * @param @return
     * @return String
     */
    public static String getIpJdkAddr(){
    	InetAddress address;
    	String IP = "";
		try {
			address = InetAddress.getLocalHost();
			IP = address.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
    	return IP;
    }

}
