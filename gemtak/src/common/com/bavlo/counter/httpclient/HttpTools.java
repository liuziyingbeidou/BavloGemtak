package com.bavlo.counter.httpclient;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.SecureRandom;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @Title: 宝珑Counter
 * @ClassName: HttpTools 
 * @Description: java HttpClient URL
 * @author liuzy
 * @date 2015-10-21 下午05:00:11
 */
public class HttpTools
{

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static String getDataByURL(String url)
	{
		//url = "http://www.bavlo.com/getGemCalibrated?typeId=3&shapeId=4";
		String res = null;
		// 创建HttpClient实例   
	    HttpClient httpclient = new DefaultHttpClient();
	    // 创建Get方法实例   
        HttpGet httpgets = new HttpGet(url);  
        HttpResponse response;
        try {
			response = httpclient.execute(httpgets);
	        HttpEntity entity = response.getEntity();  
	        if (entity != null) {  
	            InputStream instreams = entity.getContent();  
	            String str = convertStreamToString(instreams);
	            res = str;
	            httpgets.abort();  
	        }
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return res;
	}
	
	public static String convertStreamToString(InputStream is) {    
		StringBuilder sb1 = new StringBuilder();      
        byte[] bytes = new byte[4096];    
        int size = 0;    
          
        try {      
            while ((size = is.read(bytes)) > 0) {    
                String str = new String(bytes, 0, size, "UTF-8");    
                sb1.append(str);    
            }    
        } catch (IOException e) {      
            e.printStackTrace();      
        } finally {      
            try {      
                is.close();      
            } catch (IOException e) {      
               e.printStackTrace();      
            }      
        }      
        return sb1.toString();       
    }
	
	 /**
	  * java.net实现 HTTP POST方法提交
	  *
	  * @param url
	  * @param paramContent
	  * @return
	  */
	 public static StringBuffer submitPost(String url, String paramContent) {
	  StringBuffer responseMessage = null;
	  java.net.URLConnection connection = null;
	  java.net.URL reqUrl = null;
	  OutputStreamWriter reqOut = null;
	  InputStream in = null;
	  BufferedReader br = null;
	  String param = paramContent;
	  try {

	   System.out.println("url=" + url + "?" + paramContent + "\n");
	   System.out.println("===========post method start=========");
	   responseMessage = new StringBuffer();
	   reqUrl = new java.net.URL(url);
	   connection = reqUrl.openConnection();
	   connection.setDoOutput(true);
	   reqOut = new OutputStreamWriter(connection.getOutputStream());
	   reqOut.write(param);
	   reqOut.flush();
	   int charCount = -1;
	   in = connection.getInputStream();

	   br = new BufferedReader(new InputStreamReader(in, "utf-8"));
	   while ((charCount = br.read()) != -1) {
	    responseMessage.append((char) charCount);
	   }

	   System.out.println(responseMessage);
	   System.out.println("===========post method end=========");
	  } catch (Exception ex) {
	   System.out
	     .println("url=" + url + "?" + paramContent + "\n e=" + ex);
	  } finally {
	   try {
	    in.close();
	    reqOut.close();
	   } catch (Exception e) {
	    System.out
	      .println("paramContent=" + paramContent + "|err=" + e);
	   }

	  }
	  return responseMessage;
	 }

	 /**
	  * java.net实现 HTTP或HTTPs GET方法提交
	  *
	  * @param strUrl
	  *            提交的地址及参数
	  * @return 返回的response信息
	  */
	 public static String submitGet(String strUrl) {
	  URLConnection connection = null;
	  BufferedReader reader = null;
	  String str = null;
	  try {
	   System.out.println("send getmethod=" + strUrl);
	   URL url = new URL(strUrl);
	   connection = url.openConnection();
	   connection.setDoInput(true);
	   connection.setDoOutput(false);
	   // 取得输入流，并使用Reader读取
	   reader = new BufferedReader(new InputStreamReader(connection
	     .getInputStream()));
	   System.out
	     .println("============Contents of get request===============");
	   String lines;
	   StringBuffer linebuff = new StringBuffer("");
	   while ((lines = reader.readLine()) != null) {
	    linebuff.append(lines);
	   }
	   System.out.println(linebuff);
	   System.out
	     .println("============Contents of get request ends==========");
	   str = linebuff.toString();
	  } catch (Exception e) {
	   System.out.println("getmethod is err=" + e);
	   e.printStackTrace();
	  } finally {
	   try {
	    reader.close();
	   } catch (Exception e) {
	    e.printStackTrace();
	   }
	  }
	  return str;
	 }
}