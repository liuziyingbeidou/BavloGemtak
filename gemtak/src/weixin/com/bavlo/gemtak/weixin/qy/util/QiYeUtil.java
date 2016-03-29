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
 * 微信企业号调用类 {"errcode":0,"errmsg":"ok"} 此结果表示调用方法成功返回
 * 
 * @author shijf
 * 
 */
public class QiYeUtil {
	/**
	 * 获取企业号AccessToken
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
	 * OAuth2验证接口根据code获取成员信息
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
				result.setErrmsg("accessToken 超时......");
				result.setErrcode("42001");
			}
		}
		return result;
	}
	
	/**
	 * @Description: 获取RD-标签下的所有部门列表
	 * @param @return
	 * @return Map<Integer,String>
	 */
	@Deprecated
	public static Map<Integer,String> getDepartMap(HttpServletRequest request){
		
		//遍历标签并放入map
		Map<Integer,String> tag = new HashMap<Integer,String>();
		
		Map<Integer,String> tagMap = getTagMap(request);
		if(tagMap != null){
			//1、遍历标签找到RD-门店标签ID;
			for (Map.Entry<Integer,String> tagEntry : tagMap.entrySet()) {
				String tagName = tagEntry.getValue();
				//RD-前缀标签，门店
				/*if(Constants.LB_DEPART.equals(tagName.subSequence(0, 3))){
					tag.put(tagEntry.getKey(), tagEntry.getValue().substring(3));
				}*/
			}
		}
		
		return tag;
	}
	
	/**
	 * 根据标签名称获取成员列表（角色）
	 * @param tagid
	 * @return
	 */
	public static JSONArray getUserList(HttpServletRequest request,String tagName){
		
		JSONArray roleArray = new JSONArray();
		
		//接收到微信返回结果
		JSONObject jo = WechatTag.getTagList(request);
		//把标签列表转为JSONArray
		JSONArray tagList = (JSONArray) jo.get("taglist");
		for(int i=0; i< tagList.size(); i++){
			try {
				Integer tagid = Integer.valueOf(tagList.getJSONObject(i).getString("tagid")).intValue();
				String tagname = tagList.getJSONObject(i).getString("tagname");
				if(tagName.equals(tagname.substring(3))){
					//存在该角色组
					JSONObject tagObj = WechatTag.getUserList(request,tagid);
					if(tagObj != null){
						JSONArray tagArray = tagObj.getJSONArray("userlist");
						if(tagArray != null){
							for(int j = 0; j < tagArray.size(); j++){
								String userid = tagArray.getJSONObject(j).getString("userid");
								//*角色成员详细信息
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
	 * @Description: 获取标签键值对
	 * @param @return
	 * @return Map<Integer,String>
	 */
	public static Map<Integer,String> getTagMap(HttpServletRequest request){
		//接收到微信返回结果
		JSONObject jo = WechatTag.getTagList(request);
		//把标签列表转为JSONArray
		JSONArray tagList = (JSONArray) jo.get("taglist");
		//遍历标签并放入map
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
	 * 获取所有标签ID
	 * @return
	 */
	public static List<Integer> getTagIdList(HttpServletRequest request) {
		//接收到微信返回结果
		JSONObject jo = WechatTag.getTagList(request);
		//把标签列表转为JSONArray
		JSONArray tagList = (JSONArray) jo.get("taglist");
		//遍历标签并放入list
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
	 * 获取所有标签名称
	 * @return
	 */
	public static List<String> getTagNameList(HttpServletRequest request) {
		//接收到微信返回结果
		JSONObject jo = WechatTag.getTagList(request);
		//把标签列表转为JSONArray
		JSONArray tagList = (JSONArray) jo.get("taglist");
		//遍历标签并放入list
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
	 * 根据成员ID获取成员标签
	 * @param UserId
	 * @return
	 */
	public static Map<String,Object> getUserTag(HttpServletRequest request,String UserId) {
		//角色标签
		List<String> userRLTag = new ArrayList<String>();
		//店标签
		List<String> userRDTag = new ArrayList<String>();
		//所属门店
		String userShop = null;
		
		Map<Integer,String> tagMap = getTagMap(request);
		if(tagMap != null){
			//遍历标签
			for (Map.Entry<Integer,String> tagEntry : tagMap.entrySet()) {
				//查找当前标签下的用户{返回列表仅包含管理组管辖范围的成员}
				JSONObject userList = WechatTag.getUserList(request,tagEntry.getKey());
				if(userList != null){
					//标签对应该管理组下的成员列表
					JSONArray userAry = userList.getJSONArray("userlist");
					if(userAry != null){
						for (int i = 0; i < userAry.size(); i++) {
							String uid = userAry.getJSONObject(i).getString("userid");
							if(StringUtil.equals(UserId, uid)){
								String tagName = tagEntry.getValue();
								if(tagName!=null && tagName.length()>3){
									//角色
									if(Constants.LB_ROLE.equals(tagName.substring(0, 3))){
										userRLTag.add(tagEntry.getValue().substring(3)+"-RL");
									}
									//店名(key-value)
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
		/*//获取所有标签ID
		List<Integer> tagIds = QiYeUtil.getTagIdList();
		//获取所有标签名称
		List<String> tagNames = QiYeUtil.getTagNameList();
		//遍历list里面的标签
		for(int i = 0; i < tagIds.size(); i++){
			int tagid = tagIds.get(i);
			String tagname = tagNames.get(i);
			JSONObject jo = WechatTag.getUserList(tagid);//查找所有标签里的所有用户
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
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式（GET、POST）
	 * @param outputStr
	 *            提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject HttpRequest(String request, String RequestMethod,
			String output) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 建立连接
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
			// 流处理
			InputStream input = connection.getInputStream();
			InputStreamReader inputReader = new InputStreamReader(input,
					"UTF-8");
			BufferedReader reader = new BufferedReader(inputReader);
			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			// 关闭连接、释放资源
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
	 * 根据内容类型判断文件扩展名
	 * 
	 * @param contentType
	 *            内容类型
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
	 * 数据提交与请求通用方法
	 * 
	 * @param access_token
	 *            凭证
	 * @param RequestMt
	 *            请求方式
	 * @param RequestURL
	 *            请求地址
	 * @param outstr
	 *            提交json数据
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
	 * 数据提交与请求通用方法
	 * 
	 * @param access_token
	 *            凭证
	 * @param RequestMt
	 *            请求方式
	 * @param RequestURL
	 *            请求地址
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
	 * 数据提交与请求通用方法
	 * 
	 * @param access_token
	 *            凭证
	 * @param RequestMt
	 *            请求方式
	 * @param RequestURL
	 *            请求地址
	 * @param outstr
	 *            提交json数据
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
