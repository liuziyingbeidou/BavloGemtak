package com.bavlo.gemtak.util.weixin.http;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * @Title: ����Gemtak
 * @ClassName: TrustAnyTrustManager 
 * @Description: ֤�����ι�������
 * @author liuzy
 * @date 2016-3-17 ����10:06:12
 */
public class TrustAnyTrustManager implements X509TrustManager{

	public void checkClientTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		
	}

	public void checkServerTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		
	}

	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}

}