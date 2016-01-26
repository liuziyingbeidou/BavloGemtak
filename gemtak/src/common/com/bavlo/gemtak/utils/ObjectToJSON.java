
package com.bavlo.gemtak.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ��������java����ת����json
 * @author liuzy
 * @version 1.0
 */
public class ObjectToJSON {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private JsonGenerator jsonGenerator = null;
    private Object bean = null;
	
    public void ObjecyToJSON(){
    	init();
    }
    
    public void init() {
        try {
            jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void destory() {
        try {
            if (jsonGenerator != null) {
                jsonGenerator.flush();
            }
            if (!jsonGenerator.isClosed()) {
                jsonGenerator.close();
            }
            jsonGenerator = null;
            objectMapper = null;
            bean = null;
            System.gc();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	/**
	 * ������JavaBean(Entity/Model)ת����JSON
	 * <b>function:</b>��java����ת����json�ַ���
	 * @author liuzy
	 * @createDate 2015-03-27 ����22:32:10
	 */
	public static void writeEntityJSON(Object bean) {
	    
	    try {
//	        System.out.println("jsonGenerator");
//	        //writeObject����ת��java����eg:JavaBean/Map/List/Array��
//	        jsonGenerator.writeObject(bean);    
//	        System.out.println();
//	        
//	        System.out.println("ObjectMapper");
	        //writeValue���к�writeObject��ͬ�Ĺ���
	        objectMapper.writeValue(System.out, bean);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	

	 /**
	  * ��������Map����ת����Json�ַ���
	  * <b>function:</b>��mapת����json�ַ���
	  * @author liuzy
	  * @createDate 2015-03-27 ����22:42:26
	  */
	 public void writeMapJSON() {
	     try {
	         Map<String, Object> map = new HashMap<String, Object>();
	         bean = new Object();
	         map.put("account", bean);
	         
	         System.out.println("jsonGenerator");
	         jsonGenerator.writeObject(map);
	         System.out.println("");
	         
	         System.out.println("objectMapper");
	         objectMapper.writeValue(System.out, map);
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	 }
	
	 /**
	  * ��������List����ת����json
	  * <b>function:</b>��list����ת����json�ַ���
	  * @author liuzy
	  * @createDate 2015-03-27 ����22:43:59
	  */
	 public static String writeListJSON(List<?> list) {
		 String json = null;
	     try {
	         //listת����JSON�ַ���
//	    	 JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
//	         jsonGenerator.writeObject(list);
	         //��objectMapperֱ�ӷ���listת���ɵ�JSON�ַ���
	    	
	         json = objectMapper.writeValueAsString(list);
	         //objectMapper listת����JSON�ַ���
//	         objectMapper.writeValue(System.out, list);
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	     return json;
	 }
	 
	 
	
}
