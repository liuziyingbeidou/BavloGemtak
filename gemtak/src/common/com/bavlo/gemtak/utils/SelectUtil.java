package com.bavlo.gemtak.utils;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.httpclient.HttpTools;
import com.bavlo.gemtak.model.page.KeyValueVO;

/**
 * @Title: ����Gemtak
 * @ClassName: SelectUtil 
 * @Description: Զ�̽ӿ�����ת����ӦVO
 * @author liuzy
 * @date 2016-1-27 ����05:05:52
 */
public class SelectUtil {
	
	/**
	 * @Description: ��ʯ����
	 * @param @param lang
	 * @param @return
	 * @return List<KeyValueVO>
	 */
	public static List<KeyValueVO> getListGemType(String lang){
		//��ʯ����
		String rmGemTypeJson = HttpTools.getDataByURL(IConstant.URL_GEMTYPE);
		List<KeyValueVO> listGemType = getGemType(lang,rmGemTypeJson);
		return listGemType;
	}
	
	/**
	 * @Description:  ��ʯ��״
	 * @param @param lang
	 * @param @return
	 * @return List<KeyValueVO>
	 */
	public static List<KeyValueVO> getListGemShape(String lang){
		//��ʯ��״
		String rmGemShapeJson = HttpTools.getDataByURL(IConstant.URL_GEMSHAPE);
		List<KeyValueVO> listGemShape = getGemShape(lang,rmGemShapeJson);
		return listGemShape;
	}
	
	/**
	 * @Description: ��ʯ�й�
	 * @param @param lang
	 * @param @return
	 * @return List<KeyValueVO>
	 */
	public static List<KeyValueVO> getListGemCut(String lang){
		//��ʯ�й�
		String rmGemCutJson = HttpTools.getDataByURL(IConstant.URL_GEMCUT);
		List<KeyValueVO> listGemCut = getGemCut(lang,rmGemCutJson);
		return listGemCut;
	}
	
	/**
	 * @Description: ��ʯ����
	 * @param @param lang
	 * @param @return
	 * @return List<KeyValueVO>
	 */
	public static List<KeyValueVO> getListGemClarity(String lang){
		//��ʯ����
		String rmGemClarityJson = HttpTools.getDataByURL(IConstant.URL_GEMCLARITY);
		List<KeyValueVO> listGemClarity = getGemClarity(lang,rmGemClarityJson);
		return listGemClarity;
	}
	
	/**
	 * @Description: ��ʯ����
	 * @param @param lang
	 * @param @return
	 * @return List<KeyValueVO>
	 */
	public static List<KeyValueVO> getListGemOrigin(String lang){
		//��ʯ����
		String rmGemOriginJson = HttpTools.getDataByURL(IConstant.URL_GEMORIGIN);
		List<KeyValueVO> listGemOrigin = getGemOrigin(lang,rmGemOriginJson);
		return listGemOrigin;
	}
	
	/**
	 * @Description: ��ʯ������
	 * @param @param lang
	 * @param @return
	 * @return List<KeyValueVO>
	 */
	public static List<KeyValueVO> getListGemTreatment(String lang){
		//��ʯ������
		String rmGemTreatmentJson = HttpTools.getDataByURL(IConstant.URL_GEMTREATMENT);
		List<KeyValueVO> listGemTreatment = getGemTreatment(lang,rmGemTreatmentJson);
		return listGemTreatment;
	}
	
	/**
	 * @Description: ��ʯ֤��
	 * @param @param lang
	 * @param @return
	 * @return List<KeyValueVO>
	 */
	public static List<KeyValueVO> getListGemLab(String lang){
		//��ʯ֤��
		String rmGemLabJson = HttpTools.getDataByURL(IConstant.URL_GEMLAB);
		List<KeyValueVO> listGemLab = getGemLab(lang,rmGemLabJson);
		return listGemLab;
	}
	
	/**
	 * @Description: ��ʯ����
	 * @param @param lang
	 * @param @return
	 * @return KeyValueVO
	 */
	public static List<KeyValueVO> getGemType(String lang,String json){
		List<KeyValueVO> list = new ArrayList<KeyValueVO>();
		//Ӣ��
		if(IConstant.EN_UK.equals(lang)){
			JSONArray array = JSONArray.fromObject(json);
			if(array != null){
				for(int i = 0; i < array.size(); i++){
					KeyValueVO kvo = new KeyValueVO();
					JSONObject obj = array.getJSONObject(i);
					kvo.setpKey(obj.getString("id"));
					kvo.setpValue(obj.getString("type"));
					kvo.setpValueCN(obj.getString("type_cn"));
					kvo.setpValueEN(obj.getString("type"));
					kvo.setpDescCN(obj.getString("introduce"));
					list.add(kvo);
				}
			}
		}else{
			//����
			JSONArray array = JSONArray.fromObject(json);
			if(array != null){
				for(int i = 0; i < array.size(); i++){
					KeyValueVO kvo = new KeyValueVO();
					JSONObject obj = array.getJSONObject(i);
					kvo.setpKey(obj.getString("id"));
					kvo.setpValue(obj.getString("type_cn"));
					kvo.setpValueCN(obj.getString("type_cn"));
					kvo.setpValueEN(obj.getString("type"));
					kvo.setpDescCN(obj.getString("introduce"));
					list.add(kvo);
				}
			}
		}
		
		return list;
	}
	
	/**
	 * @Description: ��ʯ��״
	 * @param @param lang
	 * @param @return
	 * @return KeyValueVO
	 */
	public static List<KeyValueVO> getGemShape(String lang,String json){
		List<KeyValueVO> list = new ArrayList<KeyValueVO>();
		//Ӣ��
		if(IConstant.EN_UK.equals(lang)){
			JSONArray array = JSONArray.fromObject(json);
			if(array != null){
				for(int i = 0; i < array.size(); i++){
					KeyValueVO kvo = new KeyValueVO();
					JSONObject obj = array.getJSONObject(i);
					kvo.setpKey(obj.getString("id"));
					kvo.setpValue(obj.getString("shape"));
					kvo.setpValueCN(obj.getString("shape_cn"));
					kvo.setpValueEN(obj.getString("shape"));
					kvo.setpDescCN(obj.getString("des_cn"));
					kvo.setpDescEN(obj.getString("des_en"));
					
					list.add(kvo);
				}
			}
		}else{
			//����
			JSONArray array = JSONArray.fromObject(json);
			if(array != null){
				for(int i = 0; i < array.size(); i++){
					KeyValueVO kvo = new KeyValueVO();
					JSONObject obj = array.getJSONObject(i);
					kvo.setpKey(obj.getString("id"));
					kvo.setpValue(obj.getString("shape_cn"));
					kvo.setpValueCN(obj.getString("shape_cn"));
					kvo.setpValueEN(obj.getString("shape"));
					kvo.setpDescCN(obj.getString("des_cn"));
					kvo.setpDescEN(obj.getString("des_en"));
					list.add(kvo);
				}
			}
		}
		
		return list;
	}
	
	/**
	 * @Description: ��ʯ�й�
	 * @param @param lang
	 * @param @return
	 * @return KeyValueVO
	 */
	public static List<KeyValueVO> getGemCut(String lang,String json){
		List<KeyValueVO> list = new ArrayList<KeyValueVO>();
		//Ӣ��
		if(IConstant.EN_UK.equals(lang)){
			JSONArray array = JSONArray.fromObject(json);
			if(array != null){
				for(int i = 0; i < array.size(); i++){
					KeyValueVO kvo = new KeyValueVO();
					JSONObject obj = array.getJSONObject(i);
					kvo.setpKey(obj.getString("id"));
					kvo.setpValue(obj.getString("name_en"));
					kvo.setpValueCN(obj.getString("name_cn"));
					kvo.setpValueEN(obj.getString("name_en"));
					kvo.setpDescCN(obj.getString("gem_des_cn"));
					kvo.setpDescEN(obj.getString("gem_des_en"));
					
					list.add(kvo);
				}
			}
		}else{
			//����
			JSONArray array = JSONArray.fromObject(json);
			if(array != null){
				for(int i = 0; i < array.size(); i++){
					KeyValueVO kvo = new KeyValueVO();
					JSONObject obj = array.getJSONObject(i);
					kvo.setpKey(obj.getString("id"));
					kvo.setpValue(obj.getString("name_cn"));
					kvo.setpValueCN(obj.getString("name_cn"));
					kvo.setpValueEN(obj.getString("name_en"));
					kvo.setpDescCN(obj.getString("gem_des_cn"));
					kvo.setpDescEN(obj.getString("gem_des_en"));
					list.add(kvo);
				}
			}
		}
		
		return list;
	}
	
	/**
	 * @Description: ��ʯ����
	 * @param @param lang
	 * @param @return
	 * @return KeyValueVO
	 */
	public static List<KeyValueVO> getGemClarity(String lang,String json){
		List<KeyValueVO> list = new ArrayList<KeyValueVO>();
		//Ӣ��
		if(IConstant.EN_UK.equals(lang)){
			JSONArray array = JSONArray.fromObject(json);
			if(array != null){
				for(int i = 0; i < array.size(); i++){
					KeyValueVO kvo = new KeyValueVO();
					JSONObject obj = array.getJSONObject(i);
					kvo.setpKey(obj.getString("id"));
					kvo.setpValue(obj.getString("name_en"));
					kvo.setpValueCN(obj.getString("name_cn"));
					kvo.setpValueEN(obj.getString("name_en"));
					kvo.setpDescCN(obj.getString("des_cn"));
					kvo.setpDescEN(obj.getString("des_en"));
					
					list.add(kvo);
				}
			}
		}else{
			//����
			JSONArray array = JSONArray.fromObject(json);
			if(array != null){
				for(int i = 0; i < array.size(); i++){
					KeyValueVO kvo = new KeyValueVO();
					JSONObject obj = array.getJSONObject(i);
					kvo.setpKey(obj.getString("id"));
					kvo.setpValue(obj.getString("name_cn"));
					kvo.setpValueCN(obj.getString("name_cn"));
					kvo.setpValueEN(obj.getString("name_en"));
					kvo.setpDescCN(obj.getString("des_cn"));
					kvo.setpDescEN(obj.getString("des_en"));
					list.add(kvo);
				}
			}
		}
		
		return list;
	}
	
	/**
	 * @Description: ��ʯ����
	 * @param @param lang
	 * @param @return
	 * @return KeyValueVO
	 */
	public static List<KeyValueVO> getGemOrigin(String lang,String json){
		List<KeyValueVO> list = new ArrayList<KeyValueVO>();
		//Ӣ��
		if(IConstant.EN_UK.equals(lang)){
			JSONArray array = JSONArray.fromObject(json);
			if(array != null){
				for(int i = 0; i < array.size(); i++){
					KeyValueVO kvo = new KeyValueVO();
					JSONObject obj = array.getJSONObject(i);
					kvo.setpKey(obj.getString("id"));
					kvo.setpValue(obj.getString("origin_en"));
					kvo.setpValueCN(obj.getString("origin"));
					kvo.setpValueEN(obj.getString("origin_en"));
					list.add(kvo);
				}
			}
		}else{
			//����
			JSONArray array = JSONArray.fromObject(json);
			if(array != null){
				for(int i = 0; i < array.size(); i++){
					KeyValueVO kvo = new KeyValueVO();
					JSONObject obj = array.getJSONObject(i);
					kvo.setpKey(obj.getString("id"));
					kvo.setpValue(obj.getString("origin"));
					kvo.setpValueCN(obj.getString("origin"));
					kvo.setpValueEN(obj.getString("origin_en"));
					list.add(kvo);
				}
			}
		}
		
		return list;
	}
	
	/**
	 * @Description: ��ʯ����
	 * @param @param lang
	 * @param @return
	 * @return KeyValueVO
	 */
	public static List<KeyValueVO> getGemTreatment(String lang,String json){
		List<KeyValueVO> list = new ArrayList<KeyValueVO>();
		//Ӣ��
		if(IConstant.EN_UK.equals(lang)){
			JSONArray array = JSONArray.fromObject(json);
			if(array != null){
				for(int i = 0; i < array.size(); i++){
					KeyValueVO kvo = new KeyValueVO();
					JSONObject obj = array.getJSONObject(i);
					kvo.setpKey(obj.getString("id"));
					kvo.setpValue(obj.getString("name_en"));
					kvo.setpValueCN(obj.getString("name_cn"));
					kvo.setpValueEN(obj.getString("name_en"));
					kvo.setpDescCN(obj.getString("des_cn"));
					kvo.setpDescEN(obj.getString("des_en"));
					
					list.add(kvo);
				}
			}
		}else{
			//����
			JSONArray array = JSONArray.fromObject(json);
			if(array != null){
				for(int i = 0; i < array.size(); i++){
					KeyValueVO kvo = new KeyValueVO();
					JSONObject obj = array.getJSONObject(i);
					kvo.setpKey(obj.getString("id"));
					kvo.setpValue(obj.getString("name_cn"));
					kvo.setpValueCN(obj.getString("name_cn"));
					kvo.setpValueEN(obj.getString("name_en"));
					kvo.setpDescCN(obj.getString("des_cn"));
					kvo.setpDescEN(obj.getString("des_en"));
					list.add(kvo);
				}
			}
		}
		
		return list;
	}
	
	/**
	 * @Description: ��ʯ֤��
	 * @param @param lang
	 * @param @return
	 * @return KeyValueVO
	 */
	public static List<KeyValueVO> getGemLab(String lang,String json){
		List<KeyValueVO> list = new ArrayList<KeyValueVO>();
		//Ӣ��
		if(IConstant.EN_UK.equals(lang)){
			JSONArray array = JSONArray.fromObject(json);
			if(array != null){
				for(int i = 0; i < array.size(); i++){
					KeyValueVO kvo = new KeyValueVO();
					JSONObject obj = array.getJSONObject(i);
					kvo.setpKey(obj.getString("id"));
					kvo.setpValue(obj.getString("lab_abbr"));
					kvo.setpValueCN(obj.getString("lab_abbr"));
					kvo.setpValueEN(obj.getString("lab_abbr"));
					kvo.setpDescCN(obj.getString("lab_cn"));
					kvo.setpDescEN(obj.getString("lab"));
					
					list.add(kvo);
				}
			}
		}else{
			//����
			JSONArray array = JSONArray.fromObject(json);
			if(array != null){
				for(int i = 0; i < array.size(); i++){
					KeyValueVO kvo = new KeyValueVO();
					JSONObject obj = array.getJSONObject(i);
					kvo.setpKey(obj.getString("id"));
					kvo.setpValue(obj.getString("lab_abbr"));
					kvo.setpValueCN(obj.getString("lab_abbr"));
					kvo.setpValueEN(obj.getString("lab_abbr"));
					kvo.setpDescCN(obj.getString("lab_cn"));
					kvo.setpDescEN(obj.getString("lab"));
					list.add(kvo);
				}
			}
		}
		
		return list;
	}
	
}
