package com.bavlo.gemtak.utils;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.bavlo.gemtak.constant.IConstant;

/**
 * @Title: ����Counter
 * @ClassName: UploadHelper 
 * @Description: �ϴ�������
 * @author liuzy
 * @date 2015-10-31 ����04:14:37
 */
public class UploadHelper {
    private String allowSuffix = "jpg,png,gif,jpeg,txt";//�����ļ���ʽ
    private long allowSize = 2L;//�����ļ���С
    private String fileName;//�ļ���(��������·��)
    private String[] fileNames;
    private String model;//�ļ��ϴ�ģ��
    private String fName;//�ļ���(������չ��)
    private String[] fNames;
    
    private String minFilePath;//����ͼ���·��
    
    public String getAllowSuffix() {
        return allowSuffix;
    }
 
    public void setAllowSuffix(String allowSuffix) {
        this.allowSuffix = allowSuffix;
    }
 
    public long getAllowSize() {
        return allowSize*1024*1024;
    }
 
    public void setAllowSize(long allowSize) {
        this.allowSize = allowSize;
    }
 
    public String getFileName() {
        return fileName;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
 
    public String[] getFileNames() {
        return fileNames;
    }
 
    public void setFileNames(String[] fileNames) {
        this.fileNames = fileNames;
    }
    
    public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String[] getfNames() {
		return fNames;
	}

	public void setfNames(String[] fNames) {
		this.fNames = fNames;
	}

	public String getMinFilePath() {
		return minFilePath;
	}

	public void setMinFilePath(String minFilePath) {
		this.minFilePath = minFilePath;
	}

	/**
     * @Description: ���������ļ�
     * @param @return
     * @return String
     */
    private String getFileNameNew(){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Random random = new Random();
    	String randomCode = "";
    	for ( int i = 0; i < 6; i++ )
    	{
    		randomCode += Integer.toString(random.nextInt(36), 36);
    	}
        return fmt.format(new Date()) + randomCode;
    }
     
	/**
     * @Description: �ļ��ϴ�
     * @param @param files
     * @param @param destDir 
     * @param @param request
     * @param @throws Exception
     * @return void
     */
    public void uploads(MultipartFile[] files, String destDir,HttpServletRequest request) throws Exception {
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
        try {
            fileNames = new String[files.length];
            fNames = new String[files.length];
            int index = 0;
            for (MultipartFile file : files) {
                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
                int length = getAllowSuffix().indexOf(suffix);
                if(length == -1){
                    throw new Exception("���ϴ������ʽ���ļ�");
                }
                if(file.getSize() > getAllowSize()){
                    throw new Exception("���ϴ����ļ���С�Ѿ�������Χ");
                }
                if(StringUtil.isEmpty(destDir)){
                	destDir = "";
                }else{
                	destDir = destDir;
                }
                String realPath = request.getSession().getServletContext().getRealPath("/");
                File destFile = new File(realPath+destDir);
                if(!destFile.exists()){
                    destFile.mkdirs();
                }
                String fileNameNew = getFileNameNew()+"."+suffix;//
                File f = new File(destFile.getAbsoluteFile()+"\\"+fileNameNew);
                file.transferTo(f);
                f.createNewFile();
                fileNames[index++] =basePath+destDir+fileNameNew;
                fNames[index++] =fileNameNew;
            }
        } catch (Exception e) {
            throw e;
        }
    }
     
    /**
     * @Description: �ļ��ϴ� 
     * @param @param file
     * @param @param destDir ģ��
     * @param @param request
     * @param @throws Exception
     * @return void
     */
    public void upload(MultipartFile file,String fileType, String destDir,HttpServletRequest request) throws Exception {
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
        try {
                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
                int length = getAllowSuffix().indexOf(suffix);
                if(length == -1){
                    throw new Exception("���ϴ������ʽ���ļ�");
                }
                if(file.getSize() > getAllowSize()){
                    throw new Exception("���ϴ����ļ���С�Ѿ�������Χ");
                }
                if(StringUtil.isEmpty(destDir)){
                	//destDir = "";
                }else{
                	//destDir = getStaticDir() + destDir;
                }
                String realPath = request.getSession().getServletContext().getRealPath("/");
                File destFile = new File(realPath+destDir);
                if(!destFile.exists()){
                    destFile.mkdirs();
                }
                String fileNameNew = getFileNameNew()+"."+suffix;
                File f = new File(destFile.getAbsoluteFile()+"/"+fileNameNew);
                file.transferTo(f);
                f.createNewFile();
                fileName = basePath+destDir+fileNameNew;
                fName = fileNameNew;
                
        } catch (Exception e) {
            throw e;
    }
}
	
	   /**
	    * @Description: ��������������ͼ
	    * @param 
	    * @return void
	     * @throws IOException 
	     */
	    public void toZoom(File getUpload) throws IOException{
	    	String minFileName = null;
	    	
	    	BufferedImage srcBufferImage = ImageIO.read(getUpload);
	    	BufferedImage scaledImage;
	    	ScaleImage scaleImage = ScaleImage.getInstance();
			int yw = srcBufferImage.getWidth();
			int yh = srcBufferImage.getHeight();
			int w = 80, h = 80;
			
			String uploadFileName = getfName();
	        int index = uploadFileName.lastIndexOf(".");
	        if (index != -1) {
	        	minFileName = uploadFileName.substring(0, index) + "_min" + uploadFileName.substring(index);
	        } else {
	        	minFileName = uploadFileName+"_min";
	        }
	    	
	     // ����ϴ�ͼƬ ��� �� ѹ����ҪС ��ѹ��
			if (w > yw && h > yh)
			{
				FileOutputStream fos = new FileOutputStream(getMinFilePath() + "/" + minFileName);

				FileInputStream fis = new FileInputStream(getUpload);
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = fis.read(buffer)) > 0)
				{
					fos.write(buffer, 0, len);
				}
			}
			else
			{
				scaledImage = scaleImage.imageZoomOut(srcBufferImage, w, h);
				FileOutputStream out = new FileOutputStream(getMinFilePath() + "/" + minFileName);
				ImageIO.write(scaledImage, "jpeg", out);
			}
	    	
	    }

}

