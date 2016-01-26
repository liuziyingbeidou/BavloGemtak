package com.bavlo.gemtak.listeners;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.bavlo.gemtak.config.Constant;
import com.bavlo.gemtak.service.ICommonService;



/**
 * 用户登录，退出，保存
 * 
 * @author Gmm
 * 
 */
public class SysLoginLogListener implements HttpSessionListener,HttpSessionAttributeListener {
	private static Date loginDate;// 登录时间

	/**
	 * 登录成功创建session及日志
	 */
	public void attributeAdded(HttpSessionBindingEvent arg0) {
/*		HttpRequest request=
		AttributePrincipal?principal?=?(AttributePrincipal)arg0.getgetUserPrincipal();??*/
	}

	/**
	 * 登出，或者session超时，更新此用户退出时间
	 */
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		String name = arg0.getName();
		if (Constant.LOGININFO.equals(name)) {
			HttpSession session = arg0.getSession();
			String sessionId = session.getId();
			ICommonService commonService = (ICommonService) Constant.AppContext.getBean("commonService");
			commonService.execute("update SysLoginLog set logoutTime=?  where  sessionId=? ",new Object[] { new Date(), sessionId });
		}
	}


	/**
	 * 
	 */
	public void attributeReplaced(HttpSessionBindingEvent arg0) {

	}

	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
