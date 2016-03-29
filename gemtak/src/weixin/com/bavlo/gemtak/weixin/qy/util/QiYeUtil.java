package com.bavlo.gemtak.weixin.qy.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bavlo.gemtak.utils.StringUtil;
import com.bavlo.gemtak.weixin.qy.pojo.AccessToken;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * ΢����ҵ�ŵ����� {"errcode":0,"errmsg":"ok"} �˽����ʾ���÷����ɹ�����
 * 
 * @author shijf
 * 
 */
public class QiYeUtil {
	/**
	 * ��ȡ��ҵ��AccessToken
	 * 
	 * @param CorpID
	 * @param CorpSecret
	 * @return
	 */
	public static AccessToken getAccessToken(HttpServletRequest request,String CorpID, String CorpSecret) {
		AccessToken accessToken = null;
		if(request != null){
			HttpSession session = request.getSession();
			Object at = session.getAttribute(Constants.AccessToken);
			if(at == null){
				accessToken = WechatAccessToken.getAccessToken(CorpID,CorpSecret,1);
				session.setAttribute(Constants.AccessToken, accessToken);
			}else{
				accessToken = (AccessToken)at;
			}
		}else{
			accessToken = WechatAccessToken.getAccessToken(CorpID,CorpSecret,1);
		}
		return accessToken;
	}

	/**
	 * OAuth2��֤�ӿڸ���code��ȡ��Ա��Ϣ
	 * 
	 * @param token
	 * @param code
	 * @param AgentID
	 * @return
	 */
	public static Result<String> oAuth2GetUserByCode(String token, String code,
			int AgentID) {
		Result<String> result = new Result<String>();
		JSONObject jo = WechatOAuth2.getUserByCode(token, code, AgentID);
		if (jo != null) {
			try {
				String userId = jo.getString("UserId");
				if (userId != null && userId.length() > 0) {
					result.setErrmsg("");
					result.setErrcode("0");
					result.setObj(userId);
				} else {
					result.setErrmsg(jo.getString("errmsg"));
					result.setErrcode(jo.getString("errcode"));
				}

			} catch (Exception e) {
				result.setErrmsg("accessToken ��ʱ......");
				result.setErrcode("42001");
			}
		}
		return result;
	}
	
	/**
	 * @Description: ��ȡRD-��ǩ�µ����в����б�
	 * @param @return
	 * @return Map<Integer,String>
	 */
	@Deprecated
	public static Map<Integer,String> getDepartMap(HttpServletRequest request){
		
		//������ǩ������map
		Map<Integer,String> tag = new HashMap<Integer,String>();
		
		Map<Integer,String> tagMap = getTagMap(request);
		if(tagMap != null){
			//1��������ǩ�ҵ�RD-�ŵ��ǩID;
			for (Map.Entry<Integer,String> tagEntry : tagMap.entrySet()) {
				String tagName = tagEntry.getValue();
				//RD-ǰ׺��ǩ���ŵ�
				/*if(Constants.LB_DEPART.equals(tagName.subSequence(0, 3))){
					tag.put(tagEntry.getKey(), tagEntry.getValue().substring(3));
				}*/
			}
		}
		
		return tag;
	}
	
	/**
	 * ���ݱ�ǩ���ƻ�ȡ��Ա�б���ɫ��
	 * @param tagid
	 * @return
	 */
	public static JSONArray getUserList(HttpServletRequest request,String tagName){
		
		JSONArray roleArray = new JSONArray();
		
		//���յ�΢�ŷ��ؽ��
		JSONObject jo = WechatTag.getTagList(request);
		//�ѱ�ǩ�б�תΪJSONArray
		JSONArray tagList = (JSONArray) jo.get("taglist");
		for(int i=0; i< tagList.size(); i++){
			try {
				Integer tagid = Integer.valueOf(tagList.getJSONObject(i).getString("tagid")).intValue();
				String tagname = tagList.getJSONObject(i).getString("tagname");
				if(tagName.equals(tagname.substring(3))){
					//���ڸý�ɫ��
					JSONObject tagObj = WechatTag.getUserList(request,tagid);
					if(tagObj != null){
						JSONArray tagArray = tagObj.getJSONArray("userlist");
						if(tagArray != null){
							for(int j = 0; j < tagArray.size(); j++){
								String userid = tagArray.getJSONObject(j).getString("userid");
								//*��ɫ��Ա��ϸ��Ϣ
								JSONObject jobj = WechatDepart.getUserInfo(request,userid);
								roleArray.add(jobj);
							}
						}
					}
					break;
				}
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			}
		}
		return roleArray;
	}
	
	/**
	 * @Description: ��ȡ��ǩ��ֵ��
	 * @param @return
	 * @return Map<Integer,String>
	 */
	public static Map<Integer,String> getTagMap(HttpServletRequest request){
		//���յ�΢�ŷ��ؽ��
		JSONObject jo = WechatTag.getTagList(request);
		//�ѱ�ǩ�б�תΪJSONArray
		JSONArray tagList = (JSONArray) jo.get("taglist");
		//������ǩ������map
		Map<Integer,String> tag = new HashMap<Integer,String>();
		for(int i=0; i< tagList.size(); i++){
			try {
				tag.put(Integer.valueOf(tagList.getJSONObject(i).getString("tagid")).intValue(), tagList.getJSONObject(i).getString("tagname"));
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			}
		}
		return tag;
	}
	
	/**
	 * ��ȡ���б�ǩID
	 * @return
	 */
	public static List<Integer> getTagIdList(HttpServletRequest request) {
		//���յ�΢�ŷ��ؽ��
		JSONObject jo = WechatTag.getTagList(request);
		//�ѱ�ǩ�б�תΪJSONArray
		JSONArray tagList = (JSONArray) jo.get("taglist");
		//������ǩ������list
		List<Integer> tagids = new ArrayList<Integer>();
		for(int i=0; i< tagList.size(); i++){
			try {
				tagids.add(Integer.valueOf(tagList.getJSONObject(i).getString("tagid")).intValue());
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			}
		}
		return tagids;
	}
	
	/**
	 * ��ȡ���б�ǩ����
	 * @return
	 */
	public static List<String> getTagNameList(HttpServletRequest request) {
		//���յ�΢�ŷ��ؽ��
		JSONObject jo = WechatTag.getTagList(request);
		//�ѱ�ǩ�б�תΪJSONArray
		JSONArray tagList = (JSONArray) jo.get("taglist");
		//������ǩ������list
		List<String> tagNames = new ArrayList<String>();
		for(int i=0; i< tagList.size(); i++){
			try {
				tagNames.add(tagList.getJSONObject(i).getString("tagname"));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		return tagNames;
	}
	
	
	
	/**
	 * ���ݳ�ԱID��ȡ��Ա��ǩ
	 * @param UserId
	 * @return
	 */
	public static Map<String,Object> getUserTag(HttpServletRequest request,String UserId) {
		//��ɫ��ǩ
		List<String> userRLTag = new ArrayList<String>();
		//���ǩ
		List<String> userRDTag = new ArrayList<String>();
		//�����ŵ�
		String userShop = null;
		
		Map<Integer,String> tagMap = getTagMap(request);
		if(tagMap != null){
			//������ǩ
			for (Map.Entry<Integer,String> tagEntry : tagMap.entrySet()) {
				//���ҵ�ǰ��ǩ�µ��û�{�����б�������������Ͻ��Χ�ĳ�Ա}
				JSONObject userList = WechatTag.getUserList(request,tagEntry.getKey());
				if(userList != null){
					//��ǩ��Ӧ�ù������µĳ�Ա�б�
					JSONArray userAry = userList.getJSONArray("userlist");
					if(userAry != null){
						for (int i = 0; i < userAry.size(); i++) {
							String uid = userAry.getJSONObject(i).getString("userid");
							if(StringUtil.equals(UserId, uid)){
								String tagName = tagEntry.getValue();
								if(tagName!=null && tagName.length()>3){
									//��ɫ
									if(Constants.LB_ROLE.equals(tagName.substring(0, 3))){
										userRLTag.add(tagEntry.getValue().substring(3)+"-RL");
									}
									//����(key-value)
									else if(Constants.LB_DEPART.equals(tagName.substring(0, 3))){
										userRDTag.add(tagEntry.getKey()+"-"+tagEntry.getValue().substring(3));
										userShop = tagEntry.getKey()+"-"+tagEntry.getValue().substring(3);
									}
								}
							}
						}
					}
				}
			}
		}
		/*//��ȡ���б�ǩID
		List<Integer> tagIds = QiYeUtil.getTagIdList();
		//��ȡ���б�ǩ����
		List<String> tagNames = QiYeUtil.getTagNameList();
		//����list����ı�ǩ
		for(int i = 0; i < tagIds.size(); i++){
			int tagid = tagIds.get(i);
			String tagname = tagNames.get(i);
			JSONObject jo = WechatTag.getUserList(tagid);//�������б�ǩ��������û�
			JSONArray ja = (JSONArray) jo.get("userlist");//
			for(int j=0; j< ja.size(); j++){
				try {
					String userId = ja.getJSONObject(j).getString("userid");
					if(UserId != null&&UserId.equals(userId)){
						userTag.add(tagname);
					}
					System.out.println("userTag="+userTag);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
		}*/
		Map<String,Object> userTag = new HashMap<String,Object>();
		userTag.put("roleTag", userRLTag);
		userTag.put("departTag", userRDTag);
		userTag.put("userShop", userShop);
		return userTag;
	}
	
	/**
	 * ����https���󲢻�ȡ���
	 * 
	 * @param requestUrl
	 *            �����ַ
	 * @param requestMethod
	 *            ����ʽ��GET��POST��
	 * @param outputStr
	 *            �ύ������
	 * @return JSONObject(ͨ��JSONObject.get(key)�ķ�ʽ��ȡjson���������ֵ)
	 */
	public static JSONObject HttpRequest(String request, String RequestMethod,
			String output) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// ��������
			URL url = new URL(request);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setRequestMethod(RequestMethod);
			if (output != null) {
				OutputStream out = connection.getOutputStream();
				out.write(output.getBytes("UTF-8"));
				out.close();
			}
			// ������
			InputStream input = connection.getInputStream();
			InputStreamReader inputReader = new InputStreamReader(input,
					"UTF-8");
			BufferedReader reader = new BufferedReader(inputReader);
			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			// �ر����ӡ��ͷ���Դ
			reader.close();
			inputReader.close();
			input.close();
			input = null;
			connection.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (Exception e) {
		}
		return jsonObject;
	}

	public static String URLEncoder(String str) {
		String result = str;
		try {
			result = java.net.URLEncoder.encode(result, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * �������������ж��ļ���չ��
	 * 
	 * @param contentType
	 *            ��������
	 * @return
	 */
	public static String getFileEndWitsh(String contentType) {
		String fileEndWitsh = "";
		if ("image/jpeg".equals(contentType))
			fileEndWitsh = ".jpg";
		else if ("audio/mpeg".equals(contentType))
			fileEndWitsh = ".mp3";
		else if ("audio/amr".equals(contentType))
			fileEndWitsh = ".amr";
		else if ("video/mp4".equals(contentType))
			fileEndWitsh = ".mp4";
		else if ("video/mpeg4".equals(contentType))
			fileEndWitsh = ".mp4";
		return fileEndWitsh;
	}

	/**
	 * �����ύ������ͨ�÷���
	 * 
	 * @param access_token
	 *            ƾ֤
	 * @param RequestMt
	 *            ����ʽ
	 * @param RequestURL
	 *            �����ַ
	 * @param outstr
	 *            �ύjson����
	 * */
	public static int PostMessage(AccessToken access_token, String RequestMt,
			String RequestURL, String outstr) {
		int result = 0;
		RequestURL = RequestURL.replace("ACCESS_TOKEN", access_token.getToken());
		JSONObject jsonobject = QiYeUtil.HttpRequest(RequestURL, RequestMt,
				outstr);
		if (null != jsonobject) {
			if (0 != jsonobject.getInt("errcode")) {
				result = jsonobject.getInt("errcode");
			}
		}
		return result;
	}

	/**
	 * �����ύ������ͨ�÷���
	 * 
	 * @param access_token
	 *            ƾ֤
	 * @param RequestMt
	 *            ����ʽ
	 * @param RequestURL
	 *            �����ַ
	 * */
	public static JSONObject PostMessage(AccessToken access_token, String RequestMt,
			String RequestURL) {
		RequestURL = RequestURL.replace("ACCESS_TOKEN", access_token.getToken());
		JSONObject jsonobject = QiYeUtil.HttpRequest(RequestURL, RequestMt,
				RequestURL);
		if (null != jsonobject) {
			if (0 != jsonobject.getInt("errcode")) {
				jsonobject.getInt("errcode");
			}
		}
		return jsonobject;
	}

	/**
	 * �����ύ������ͨ�÷���
	 * 
	 * @param access_token
	 *            ƾ֤
	 * @param RequestMt
	 *            ����ʽ
	 * @param RequestURL
	 *            �����ַ
	 * @param outstr
	 *            �ύjson����
	 * */
	public static JSONObject GetMessage(AccessToken access_token, String RequestMt,
			String RequestURL, String outstr) {
		RequestURL = RequestURL.replace("ACCESS_TOKEN", access_token.getToken());
		JSONObject jsonobject = QiYeUtil.HttpRequest(RequestURL, RequestMt,
				outstr);
		if (null != jsonobject) {
			if (0 != jsonobject.getInt("errcode")) {
				jsonobject.getInt("errcode");
			}
		}
		return jsonobject;
	}
}
