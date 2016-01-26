package com.bavlo.gemtak.web;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;

import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.utils.CommonUtils;

@Controller("fileController")
@RequestMapping(value = "/file")
public class FileController extends BaseController implements ServletContextAware{
	//Spring������ͨ��ʵ��ServletContextAware�ӿ���ע��ServletContext����  
    private ServletContext servletContext; 
	
    /**
     * @Description: ����
     * @param @param filePath ģ��洢·�� eg��entitysign
     * @param @param fileName �ļ��� eg:2015120200909.jpg
     * @param @param request
     * @param @param response
     * @param @return
     * @return String
     */
    public void download(String filePath,String fileName, HttpServletRequest request,
            HttpServletResponse response) {
    	 //��Ҫ���ص��ļ�·���������ݿ��в�ѯ�õ�����ȻҲ����ֱ��д�ļ�·�����磺C:\\Users\\Administrator\\Desktop\\csv\\����_utf8_100.csv
    	String basePath = servletContext.getRealPath("/");  
        String path = basePath +"/"+IConstant.FILE_DIR+"//"+filePath;
        filePath = path + File.separator + fileName;
         try {
             File file = new File(filePath);
             //�õ��ļ���
             fileName = new String(fileName.getBytes("UTF-8"),"ISO8859-1");//���ļ�����UTF-8ȡ������ISO8859-1���룬��֤���������е��ļ������Ĳ����룬���Ĳ�Ҫ̫�࣬���֧��17�����ģ���Ϊheader��150���ֽ����ơ�
             response.setContentType("application/octet-stream");//����������������Ϊ��
             response.addHeader("Content-Disposition", "attachment;filename="+fileName);//Content-Disposition��ָ�����������ļ�����չ�������ҵ��������ضԻ����е��ļ�����ͼƬ�ǰ����ļ�����չ����ʾ�ģ��㱣����ļ���filename��ֵ����������������Content�����õ�Ϊ׼��ע�⣺������Content-Dispositionͷ�ֶ�֮ǰ��һ��Ҫ����Content-Typeͷ�ֶΡ�
             String len = String.valueOf(file.length());
             response.setHeader("Content-Length", len);//�������ݳ���
             OutputStream out = response.getOutputStream();
             FileInputStream in = new FileInputStream(file);
             byte[] b = new byte[1024];
             int n;
             while((n=in.read(b))!=-1){
                 out.write(b, 0, n);
             }
             in.close();
             out.close();
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
    
    public void download(String urlString, String filename) throws Exception {
        // ����URL
        URL url = new URL(urlString);
        // ������
        URLConnection con = url.openConnection();
        // ������
        InputStream is = con.getInputStream();
        // 1K�����ݻ���
        byte[] bs = new byte[1024];
        // ��ȡ�������ݳ���
        int len;
        // ������ļ���
        OutputStream os = new FileOutputStream(filename);
        // ��ʼ��ȡ
        while ((len = is.read(bs)) != -1) {
          os.write(bs, 0, len);
        }
        // ��ϣ��ر���������
        os.close();
        is.close();
    }   
    
    @RequestMapping("/download")
    public void download_T(String filePath,String fileName, HttpServletRequest request,
            HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        //response.setContentType("application/octet-stream");
        //�����ļ�MIME����  
        response.setContentType(servletContext.getMimeType(fileName));  
        response.setHeader("Content-Disposition", "attachment;fileName="
                + fileName);
        
        if(CommonUtils.isNull(fileName) || CommonUtils.isNull(filePath)){
        	renderText("�ļ�������!");
        }
        
        try {
        	/*
        	HttpServletRequest httpRequest=(HttpServletRequest)request;
            
        	/*String strBackUrl = "http://" + request.getServerName() //��������ַ
        	                    + ":" 
        	                    + request.getServerPort()           //�˿ں�
        	                    + httpRequest.getContextPath()      //��Ŀ����
        	                    + httpRequest.getServletPath()      //����ҳ���������ַ
        	        	    + "?" + (httpRequest.getQueryString()); //����
        	     	
        	String strBackUrl = "http://" + request.getServerName() //��������ַ
            + ":" 
            + request.getServerPort()           //�˿ں�
            + httpRequest.getContextPath();      //��Ŀ����
        	String urlString = strBackUrl+"/"+IConstant.FILE_DIR+"/"+filePath+"/"+fileName;
        	System.out.print(urlString);
        	
        	download(urlString,fileName);
        	*/
        	
        	String basePath = servletContext.getRealPath("/");  
            String path = basePath +"/"+IConstant.FILE_DIR+"//"+filePath;//���downloadĿ¼Ϊɶ������classes�µ�
            InputStream inputStream = new FileInputStream(new File(path
                    + File.separator + fileName));
 
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
 
             // ������Ҫ�رա�
            os.flush();
            os.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            renderText("�ļ�������!");
        } catch (Exception e) {
            e.printStackTrace();
            renderText("�����쳣!");
        }
    }
    
    @Override  
    public void setServletContext(ServletContext servletContext) {  
        this.servletContext = servletContext;  
    }  
}
