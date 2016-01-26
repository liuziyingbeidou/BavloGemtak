package com.bavlo.gemtak.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.CycleDetectionStrategy;

/**
 * @Title: ����Counter
 * @ClassName: JsonUtils 
 * @Description: ����json�Ĺ����࣬����json����ת����java�����java����ת����json
 * @author liuzy
 * @date 2015-9-19 ����11:34:35
 */
public class JsonUtils {

	public static List<Map<String, Object>> toMapList(List<?> src, String entityKey) {

		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		for (Object entity : src) {
			Map<String, Object> itemMap = new HashMap<String, Object>();
			itemMap.put(entityKey, entity);
			returnList.add(itemMap);
		}
		return returnList;
	}

	/**
	 * ��һ��JSON �����ַ���ʽ�еõ�һ��java����
	 * 
	 * @param jsonString
	 * @param pojoCalss
	 * @return
	 */
	public static Object getObject4JsonString(String jsonString, Class<?> pojoCalss) {
		Object pojo;
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		pojo = JSONObject.toBean(jsonObject, pojoCalss);
		return pojo;
	}

	/**
	 * ��json HASH���ʽ�л�ȡһ��map����map֧��Ƕ�׹���
	 * 
	 * @param jsonString
	 * @return
	 */
	@SuppressWarnings({ "unchecked"})
	public static Map getMap4Json(String jsonString) {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		Iterator keyIter = jsonObject.keys();
		String key;
		Object value;
		Map valueMap = new HashMap();

		while (keyIter.hasNext()) {
			key = (String) keyIter.next();
			value = jsonObject.get(key);
			valueMap.put(key, value);
		}

		return valueMap;
	}

	/**
	 * ��json�����еõ���Ӧjava����
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Object[] getObjectArray4Json(String jsonString) {
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		return jsonArray.toArray();

	}

	/**
	 * ��json���󼯺ϱ��ʽ�еõ�һ��java�����б�
	 * 
	 * @param jsonString
	 * @param pojoClass
	 * @return
	 */
	@SuppressWarnings({ "unchecked"})
	public static List getList4Json(String jsonString, Class pojoClass) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		JSONObject jsonObject;
		Object pojoValue;

		List list = new ArrayList();
		for (int i = 0; i < jsonArray.size(); i++) {

			jsonObject = jsonArray.getJSONObject(i);
			pojoValue = JSONObject.toBean(jsonObject, pojoClass);
			list.add(pojoValue);

		}
		return list;

	}
	/**
	* @Description: ֱ�ӷ��ظ���jsonת���õ�list 
	* @param @param src ��Ҫת�������ݣ�һ��list ���磺List<SrcChgcustDTO> srcChgcustDTOList
	* @param @param targetClass ׼����������һ���� ���磺NowChgcustDTO.class
	* @param @return List<NowChgcustDTO> nowChgcust
	* @return List
	 */
	public static List getListFromJson(Object src,Class targetClass){
		List list = new ArrayList();
		JSONArray JSONArray = net.sf.json.JSONArray.fromObject(src,JsonUtils.configJson("yyyy-MM-dd"));
		list = JsonUtils.getList4Json(JSONArray.toString(),targetClass);
		return list;
	}

	/**
	 * ��json�����н�����java�ַ�������
	 * 
	 * @param jsonString
	 * @return
	 */
	public static String[] getStringArray4Json(String jsonString) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		String[] stringArray = new String[jsonArray.size()];
		for (int i = 0; i < jsonArray.size(); i++) {
			stringArray[i] = jsonArray.getString(i);

		}

		return stringArray;
	}

	/**
	 * ��json�����н�����javaLong�Ͷ�������
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Long[] getLongArray4Json(String jsonString) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		Long[] longArray = new Long[jsonArray.size()];
		for (int i = 0; i < jsonArray.size(); i++) {
			longArray[i] = jsonArray.getLong(i);

		}
		return longArray;
	}

	/**
	 * ��json�����н�����java Integer�Ͷ�������
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Integer[] getIntegerArray4Json(String jsonString) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		Integer[] integerArray = new Integer[jsonArray.size()];
		for (int i = 0; i < jsonArray.size(); i++) {
			integerArray[i] = jsonArray.getInt(i);

		}
		return integerArray;
	}

	/**
	 * ��json�����н�����java Date �Ͷ������飬ʹ�ñ��������뱣֤
	 * 
	 * @param jsonString
	 * @return
	 * @throws ParseException
	 */
	public static Date[] getDateArray4Json(String jsonString, String DataFormat)
			throws ParseException {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		Date[] dateArray = new Date[jsonArray.size()];
		String dateString;
		Date date;

		for (int i = 0; i < jsonArray.size(); i++) {
			dateString = jsonArray.getString(i);
			date = DateUtils.str2Date(dateString, DataFormat);
			dateArray[i] = date;

		}
		return dateArray;
	}

	/**
	 * ��json�����н�����java Integer�Ͷ�������
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Double[] getDoubleArray4Json(String jsonString) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		Double[] doubleArray = new Double[jsonArray.size()];
		for (int i = 0; i < jsonArray.size(); i++) {
			doubleArray[i] = jsonArray.getDouble(i);

		}
		return doubleArray;
	}

	/**
	 * ��java����ת����json�ַ���
	 * 
	 * @param javaObj
	 * @return
	 */
	public static String getJsonString4JavaPOJO(Object javaObj) {

		JSONObject json;
		json = JSONObject.fromObject(javaObj);
		return json.toString();

	}

	/**
	 * ��java����ת����json�ַ���,���趨���ڸ�ʽ
	 * 
	 * @param javaObj
	 * @param dataFormat
	 * @return
	 */
	public static String getJsonString4JavaPOJO(Object javaObj,
			String dataFormat) {

		JSONObject json;
		JsonConfig jsonConfig = configJson(dataFormat);
		json = JSONObject.fromObject(javaObj, jsonConfig);
		return json.toString();

	}

	/**
	 * JSON ʱ���������
	 * 
	 * @param datePattern
	 * @return
	 */
	public static JsonConfig configJson(String datePattern) {
		JsonConfig jsonConfig = new JsonConfig();
		// jsonConfig.setExcludes(new String[] {""});
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor(datePattern));
		jsonConfig.registerJsonValueProcessor(java.sql.Date.class,
            new JsonDateValueProcessor(datePattern));
		jsonConfig.registerJsonValueProcessor(Timestamp.class,
            new JsonDateValueProcessor(datePattern));
		return jsonConfig;
	}

	/**
	 * ��ȥ�������ɵ��ֶΣ��ر��ʺ�ȥ�������Ķ���+ʱ��ת��
	 * 
	 * @param excludes
	 *            ��ȥ�������ɵ��ֶ�
	 * @param datePattern
	 * @return
	 */
	public static JsonConfig configJson(String[] excludes, String datePattern) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(excludes);
		jsonConfig.setIgnoreDefaultExcludes(true);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor(datePattern));

		return jsonConfig;
	}

	public static JsonConfig configJson(String[] excludes) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(excludes);
		jsonConfig.setIgnoreDefaultExcludes(true);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor("yyyy-MM-dd"));

		return jsonConfig;
	}

	static class JsonDateValueProcessor implements JsonValueProcessor {

		private String format = "yyyy-MM-dd HH:mm:ss";

		public JsonDateValueProcessor() {

		}

		public JsonDateValueProcessor(String format) {
			this.format = format;
		}

		public Object processArrayValue(Object value, JsonConfig jsonConfig) {
			String[] obj = {};
			if (value instanceof Date[]) {
				SimpleDateFormat sf = new SimpleDateFormat(format);
				Date[] dates = (Date[]) value;
				obj = new String[dates.length];
				for (int i = 0; i < dates.length; i++) {
					obj[i] = sf.format(dates[i]);
				}
			}
			return obj;
		}

		public Object processObjectValue(String key, Object value,
				JsonConfig jsonConfig) {
			if (value instanceof Date) {
				String str = new SimpleDateFormat(format).format((Date) value);
				return str;
			}
			return value == null ? null : value.toString();
		}

		public String getFormat() {
			return format;
		}

		public void setFormat(String format) {
			this.format = format;
		}

	}
}
