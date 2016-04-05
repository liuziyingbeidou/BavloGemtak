package com.bavlo.gemtak.weixin.qy.interceptor;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bavlo.gemtak.model.LoginVO;
import com.bavlo.gemtak.utils.StringUtil;

public class OAuth2Interceptor implements HandlerInterceptor {

	/**
	 * ��DispatcherServlet��ȫ����������󱻵���
	 * �����������׳��쳣ʱ,��ӵ�ǰ����������ִ�����е���������afterCompletion()
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("**ִ��˳��: 3��afterCompletion**");

	}

	/**
	 * ��ҵ��������������ִ����ɺ�,������ͼ֮ǰִ�еĶ���
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView modelAndView) throws Exception {
		System.out.println("**ִ��˳��: 2��postHandle**");

	}

	/**
	 * ��ҵ��������������֮ǰ������ �������false �ӵ�ǰ������������ִ��������������afterCompletion(),���˳���������
	 * �������true ִ����һ��������,ֱ�����е���������ִ����� ��ִ�б����ص�Controller Ȼ�������������,
	 * �����һ������������ִ�����е�postHandle() �����ٴ����һ������������ִ�����е�afterCompletion()
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("**ִ��˳��: 1��preHandle**");
		String url = request.getRequestURL().toString();

		HttpSession session = request.getSession();
		// ���ж��Ƿ���ע��

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		OAuthRequired annotation = method.getAnnotation(OAuthRequired.class);
		if (annotation != null) {
			System.out.println("OAuthRequired����ķ�����Ҫ��ȡ��¼��Ϣ��");
			Object objUid = session.getAttribute("loginInfo");
			if (isAuto(objUid)) {
				String resultUrl = request.getRequestURL().toString();
				String param=request.getQueryString();
				if(param!=null){
					resultUrl+= "?" + param;
					System.out.println("param");
				}
				System.out.println("resultUrl="+resultUrl);
				try {
					resultUrl = java.net.URLEncoder.encode(resultUrl, "utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				//�����·��
		        String contextPath=request.getContextPath();
				response.sendRedirect(contextPath + "/oauth2.do?resultUrl=" + resultUrl);
				return false;
			}
		}
		return true;
	}

	public boolean isAuto(Object objUid){
		boolean flg = false;
		if (objUid == null) {
			flg = true;
		}else{
			if(StringUtil.isEmpty(((LoginVO)objUid).getUserId())){
				flg = true;
			}
		}
		return flg;
	}
	
}
