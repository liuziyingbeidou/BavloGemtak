package com.bavlo.gemtak.utils;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.model.page.KeyValueVO;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: SelectUtil 
 * @Description: 远程接口数据转换相应VO
 * @author liuzy
 * @date 2016-1-27 下午05:05:52
 */
public class SelectUtil {
	
	/**
	 * @Description: 宝石类型
	 * @param @param lang
	 * @param @return
	 * @return KeyValueVO
	 */
	public static List<KeyValueVO> getGemType(String lang,String json){
		List<KeyValueVO> list = new ArrayList<KeyValueVO>();
		//英文
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
			//中文
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
	 * @Description: 宝石形状
	 * @param @param lang
	 * @param @return
	 * @return KeyValueVO
	 */
	public static List<KeyValueVO> getGemShape(String lang,String json){
		List<KeyValueVO> list = new ArrayList<KeyValueVO>();
		//英文
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
			//中文
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
	 * @Description: 宝石切工
	 * @param @param lang
	 * @param @return
	 * @return KeyValueVO
	 */
	public static List<KeyValueVO> getGemCut(String lang,String json){
		List<KeyValueVO> list = new ArrayList<KeyValueVO>();
		//英文
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
			//中文
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
	 * @Description: 宝石净度
	 * @param @param lang
	 * @param @return
	 * @return KeyValueVO
	 */
	public static List<KeyValueVO> getGemClarity(String lang,String json){
		List<KeyValueVO> list = new ArrayList<KeyValueVO>();
		//英文
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
			//中文
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
	 * @Description: 宝石产地
	 * @param @param lang
	 * @param @return
	 * @return KeyValueVO
	 */
	public static List<KeyValueVO> getGemOrigin(String lang,String json){
		List<KeyValueVO> list = new ArrayList<KeyValueVO>();
		//英文
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
			//中文
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
	 * @Description: 宝石处理
	 * @param @param lang
	 * @param @return
	 * @return KeyValueVO
	 */
	public static List<KeyValueVO> getGemTreatment(String lang,String json){
		List<KeyValueVO> list = new ArrayList<KeyValueVO>();
		//英文
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
			//中文
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
	 * @Description: 宝石证书
	 * @param @param lang
	 * @param @return
	 * @return KeyValueVO
	 */
	public static List<KeyValueVO> getGemLab(String lang,String json){
		List<KeyValueVO> list = new ArrayList<KeyValueVO>();
		//英文
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
			//中文
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
