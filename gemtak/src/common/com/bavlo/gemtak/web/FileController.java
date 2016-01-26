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
	//Spring这里是通过实现ServletContextAware接口来注入ServletContext对象  
    private ServletContext servletContext; 
	
    /**
     * @Description: 下载
     * @param @param filePath 模块存储路径 eg：entitysign
     * @param @param fileName 文件名 eg:2015120200909.jpg
     * @param @param request
     * @param @param response
     * @param @return
     * @return String
     */
    public void download(String filePath,String fileName, HttpServletRequest request,
            HttpServletResponse response) {
    	 //所要下载的文件路径，从数据库中查询得到，当然也可以直接写文件路径，如：C:\\Users\\Administrator\\Desktop\\csv\\号码_utf8_100.csv
    	String basePath = servletContext.getRealPath("/");  
        String path = basePath +"/"+IConstant.FILE_DIR+"//"+filePath;
        filePath = path + File.separator + fileName;
         try {
             File file = new File(filePath);
             //得到文件名
             fileName = new String(fileName.getBytes("UTF-8"),"ISO8859-1");//把文件名按UTF-8取出并按ISO8859-1编码，保证弹出窗口中的文件名中文不乱码，中文不要太多，最多支持17个中文，因为header有150个字节限制。
             response.setContentType("application/octet-stream");//告诉浏览器输出内容为流
             response.addHeader("Content-Disposition", "attachment;filename="+fileName);//Content-Disposition中指定的类型是文件的扩展名，并且弹出的下载对话框中的文件类型图片是按照文件的扩展名显示的，点保存后，文件以filename的值命名，保存类型以Content中设置的为准。注意：在设置Content-Disposition头字段之前，一定要设置Content-Type头字段。
             String len = String.valueOf(file.length());
             response.setHeader("Content-Length", len);//设置内容长度
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
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        // 输入流
        InputStream is = con.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        OutputStream os = new FileOutputStream(filename);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
          os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        is.close();
    }   
    
    @RequestMapping("/download")
    public void download_T(String filePath,String fileName, HttpServletRequest request,
            HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        //response.setContentType("application/octet-stream");
        //设置文件MIME类型  
        response.setContentType(servletContext.getMimeType(fileName));  
        response.setHeader("Content-Disposition", "attachment;fileName="
                + fileName);
        
        if(CommonUtils.isNull(fileName) || CommonUtils.isNull(filePath)){
        	renderText("文件不存在!");
        }
        
        try {
        	/*
        	HttpServletRequest httpRequest=(HttpServletRequest)request;
            
        	/*String strBackUrl = "http://" + request.getServerName() //服务器地址
        	                    + ":" 
        	                    + request.getServerPort()           //端口号
        	                    + httpRequest.getContextPath()      //项目名称
        	                    + httpRequest.getServletPath()      //请求页面或其他地址
        	        	    + "?" + (httpRequest.getQueryString()); //参数
        	     	
        	String strBackUrl = "http://" + request.getServerName() //服务器地址
            + ":" 
            + request.getServerPort()           //端口号
            + httpRequest.getContextPath();      //项目名称
        	String urlString = strBackUrl+"/"+IConstant.FILE_DIR+"/"+filePath+"/"+fileName;
        	System.out.print(urlString);
        	
        	download(urlString,fileName);
        	*/
        	
        	String basePath = servletContext.getRealPath("/");  
            String path = basePath +"/"+IConstant.FILE_DIR+"//"+filePath;//这个download目录为啥建立在classes下的
            InputStream inputStream = new FileInputStream(new File(path
                    + File.separator + fileName));
 
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
 
             // 这里主要关闭。
            os.flush();
            os.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            renderText("文件不存在!");
        } catch (Exception e) {
            e.printStackTrace();
            renderText("下载异常!");
        }
    }
    
    @Override  
    public void setServletContext(ServletContext servletContext) {  
        this.servletContext = servletContext;  
    }  
}
