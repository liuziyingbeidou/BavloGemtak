package com.bavlo.gemtak.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.bavlo.gemtak.util.weixin.MD5Util;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

/**
 * ���ɶ�ά�� 
 *2016-4-26
 * @author 
 *
 */
public class GenerateQrCodeUtil {
	private static final int WHITE = 0xFFFFFFFF;
    private static final int BLACK = 0xFF000000;
    private static final String UPLOAD ="upload";
    
    
      /**        
	   * ���ɶ�ά��ͼƬ ���洢 ֱ����������ʽ�����ҳ��        
	   * @param content        
	   * @param response       
	   */      
	   @SuppressWarnings({ "unchecked", "rawtypes" })      
	   public static void encodeQrcode(String content,HttpServletResponse response){  
	     if(StringUtils.isBlank(content)) {
	    	 return;       
	     }
		 MultiFormatWriter multiFormatWriter = new MultiFormatWriter(); 
		 Map hints = new HashMap();        
		 hints.put(EncodeHintType.CHARACTER_SET, "UTF-8"); //�����ַ�����������        
		 BitMatrix bitMatrix = null;         
		 try {           
			 bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 300, 300,hints); 
		     BufferedImage image = toBufferedImage(bitMatrix);           //�����ά��ͼƬ��            
			 try {              
			     ImageIO.write(image, "png", response.getOutputStream());             
			 } catch (IOException e) {
				 e.printStackTrace();  
	         }      
		 } catch (WriterException e1) {            
			 // TODO Auto-generated catch block            
			 e1.printStackTrace();         
		 }              
	  }
	   
	   /**
        * ��̬���ɶ�ά�� �洢�ڴ�����
        * @param content  //��ά����Ϣ
        * @param contextPath //���������·��
        * @param realPath    //������ʵ·��
        * @param subPath     //��·��
        * @return
        */
       @SuppressWarnings({ "rawtypes", "unchecked" })
       public static String generateQrcode(String content,String contextPath,String realPath,String subPath){
           if(content==null || realPath==null)
              return null;
           String fileName = generateFileName(content.getBytes())+".png";
           String url = "/" + UPLOAD + contextPath + "/" + subPath + "/" + fileName;//ͼƬ����Ŀ�д洢�����·��
           String filePath = url;
           //����ǲ����ڷ������ϵ����������Ҫ��webapps/�����uploadĿ¼
           if (StringUtils.isNotBlank(contextPath) || realPath.endsWith("root")) {    
               filePath = ".." + url;
           }
           MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
           Map hints = new HashMap();
           hints.put(EncodeHintType.CHARACTER_SET, "UTF-8"); //�����ַ�����������
           BitMatrix bitMatrix = null;
           try {
              bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 300, 300,hints);
              File file1 = new File(realPath,filePath); //�����洢ͼƬ���ļ�
               try {
                  GenerateQrCodeUtil.writeToFile(bitMatrix, "png", file1); //�洢��ά��ͼƬ
                   return filePath;
               } catch (IOException e) {
                 // TODO Auto-generated catch block
                   e.printStackTrace();
               }
           } catch (WriterException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
           }         
          return null;
       }
       
       private static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
           BufferedImage image = toBufferedImage(matrix);
           if (!ImageIO.write(image, format, file)) {
              throw new IOException("Could not write an image of format " + format + " to " + file);
          }
       }
       
       private static BufferedImage toBufferedImage(BitMatrix matrix) {
           int width = matrix.getWidth();
            int height = matrix.getHeight();
           BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
              for (int y = 0; y < height; y++) {
               image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
              }
           }
           return image;
       }
       
       private static String generateFileName(byte[] content) {
          return MD5Util.MD5Encode(null, null);  //md5����
       }
       
       
}

