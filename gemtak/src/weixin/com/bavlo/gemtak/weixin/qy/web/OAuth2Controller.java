package com.bavlo.gemtak.weixin.qy.web;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bavlo.gemtak.model.LoginVO;
import com.bavlo.gemtak.utils.CommonUtils;
import com.bavlo.gemtak.weixin.qy.pojo.AccessToken;
import com.bavlo.gemtak.weixin.qy.util.Constants;
import com.bavlo.gemtak.weixin.qy.util.QiYeUtil;
import com.bavlo.gemtak.weixin.qy.util.Result;
import com.bavlo.gemtak.weixin.qy.util.WechatDepart;

/**
 * OAuth2 ���������
 * @author shijf
 *
 */
@Controller
public class OAuth2Controller {
	
	/**
	 * ����������������ض���΢��API��ȡ��¼��Ϣ
	 * 
	 * @param index
	 * @return
	 */
	@RequestMapping(value = { "/oauth2.do", "/oauth2" })
	public String Oauth2API(HttpServletRequest request, @RequestParam String resultUrl) {
		// �˴�������ӻ�ȡ�־û������ݣ�����ҵ��id�������Ϣ
		String CropId = Constants.CORPID;
		String redirectUrl = "";
		if (resultUrl != null) {
			String reqUrl = Constants.REQURL;
			//TODO �˴���������ķ������Ѳ�������reqUrl�� ƴ�����Լ��� URL
			String backUrl ="http://" + reqUrl + "/oauth2url.do?oauth2url=" + resultUrl;
			redirectUrl = oAuth2Url(CropId, backUrl);
		}
		return "redirect:" + redirectUrl;
	}

	/**
	 * ����code��ȡUserid����ת����Ҫ���û���Ϣ������ҳ��
	 * 
	 * @param request
	 * @param code
	 *            ��ȡ΢���ض����Լ����õ�URL��code����
	 * @param oauth2url
	 *            ��ת������ҳ��ĵ�ַ
	 * @return
	 */
	@RequestMapping(value = { "/oauth2url.do" })
	public String Oauth2MeUrl(HttpServletRequest request, @RequestParam String code, @RequestParam String oauth2url) {
		AccessToken accessToken = QiYeUtil.getAccessToken(request,Constants.CORPID, Constants.SECRET);
		HttpSession session = request.getSession();
		
		if (accessToken != null && accessToken.getToken() != null) {
			String Userid = getMemberGuidByCode(accessToken.getToken(), code, Constants.AGENTID);
			if (Userid != null) {
				LoginVO lvo = new LoginVO();
				Map<String,Object> mapRoleTag = QiYeUtil.getUserTag(request,Userid);
				List<String> listRoleTag = mapRoleTag.get("roleTag") != null ? (List<String>)mapRoleTag.get("roleTag") : null;
				String userShop = mapRoleTag.get("userShop")+"";
				JSONObject  obj = WechatDepart.getUserInfo(request,Userid);
				JSONObject  extattrObj = obj.getJSONObject("extattr");
				if(!extattrObj.isNullObject()){
					JSONArray jsonAry = extattrObj.getJSONArray("attrs");
					if(jsonAry != null){
						boolean isMain = false;
						for(int i = 0; i < jsonAry.size(); i++){
							JSONObject fileObj = jsonAry.getJSONObject(i);
							String name = fileObj.getString("name");
							if("�������˺�".equals(name)){
								lvo.setMuserId(fileObj.getString("value"));
							}else if("ɨ���豸��".equals(name)){
								lvo.setEcode(fileObj.getString("value"));
								if(!CommonUtils.isNull(fileObj.getString("value"))){
									isMain = true;
								}
							}
						}
						if(isMain){
							lvo.setUserId(Userid);
							lvo.setRole(listRoleTag);
							lvo.setShop(userShop);
							session.removeAttribute("loginInfo");
							session.setAttribute("loginInfo",lvo);
						}
					}
				}
			}
		}
		// ����򵥴���,�洢��session��
		return "redirect:" + oauth2url;
	}

	/**
	 * �����Ա�������Ϣ��URL
	 * 
	 * @param corpid
	 *            ��ҵid
	 * @param redirect_uri
	 *            ��Ȩ���ض���Ļص����ӵ�ַ����ʹ��urlencode�����ӽ��д���
	 * @param state
	 *            �ض��������state��������ҵ������дa-zA-Z0-9�Ĳ���ֵ
	 * @return
	 */
	private String oAuth2Url(String corpid, String redirect_uri) {
		try {
			redirect_uri = java.net.URLEncoder.encode(redirect_uri, "utf-8");
			System.out.println("��ҳ��Ȩ1:"+redirect_uri);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String oauth2Url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + corpid + "&redirect_uri=" + redirect_uri
				+ "&response_type=code&scope=snsapi_base&state=bavlo#wechat_redirect";
		System.out.println("��ҳ��Ȩ:"+redirect_uri);
		return oauth2Url;
	}

	/**
	 * ���ýӿڻ�ȡ�û���Ϣ
	 * 
	 * @param token
	 * @param code
	 * @param agentId
	 * @return
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public String getMemberGuidByCode(String token, String code, int agentId) {
		Result<String> result = QiYeUtil.oAuth2GetUserByCode(token, code, agentId);
		if (result.getErrcode() == "0") {
			if (result.getObj() != null) {
				// �˴�����ͨ��΢����Ȩ��code��Userid��ѯ�Լ����ط������е�����
				return result.getObj();
			}
		}
		return "";
	}

}
