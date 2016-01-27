package com.bavlo.gemtak.utils;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.bavlo.gemtak.constant.IConstant;
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
}
