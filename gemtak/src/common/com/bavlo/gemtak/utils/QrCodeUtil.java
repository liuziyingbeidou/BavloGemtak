package com.bavlo.gemtak.utils;

import java.io.File;
import java.util.Hashtable;

import javax.servlet.ServletContext;

import com.bavlo.gemtak.constant.IConstant;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public class QrCodeUtil {

	// ����ɨһɨ��½��ά��
	public static String createCode(String sessionId,
			ServletContext servletContext) {
		String path = "resources\\client\\login\\";

		path = servletContext.getRealPath(path);

		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		;
		path += "\\" + sessionId;
		StringBuffer url = new StringBuffer(IConstant.WXSSLOGIN);
		url.append("?sessionId=");
		url.append(sessionId);
		int width = 300;
		int height = 300;
		// ��ά���ͼƬ��ʽ
		String format = "jpg";
		Hashtable hints = new Hashtable();
		// ������ʹ�ñ���
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix;
		try {
			bitMatrix = new MultiFormatWriter().encode(url.toString(),
					BarcodeFormat.QR_CODE, width, height, hints);
			File outputFile = new File(path + ".jpg");
			CreateCode.writeToFile(bitMatrix, format, outputFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ���ɶ�ά��
		return null;

	}
}
