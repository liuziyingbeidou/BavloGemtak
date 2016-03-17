package com.bavlo.gemtak.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.bavlo.gemtak.commonbeans.Page;
import com.bavlo.gemtak.constant.IConstant;
import com.bavlo.gemtak.model.LoginVO;
import com.bavlo.gemtak.utils.JsonUtils;
import com.bavlo.gemtak.utils.ScaleImage;
import com.bavlo.gemtak.utils.StringHelper;
import com.bavlo.gemtak.utils.StringUtil;
import com.bavlo.gemtak.utils.WebUtils;


/**
 * @Title: ����Counter
 * @ClassName: BaseController 
 * @Description:  
 * @author liuzy
 * @date 2015-9-20 ����04:05:13
 */
public class BaseController{
	
	//��ҳ-start
	protected Integer dgpage=1;
	protected Integer rows=2;
	//��ҳ-end
	
	protected HttpServletResponse response;  
    protected HttpSession session;  
    protected HttpServletRequest request;
	
    @ModelAttribute  
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){  
        this.request = request;  
        this.response = response;  
        this.session = request.getSession();  
    }  
    
    @ModelAttribute
    public void setDgpageAndRows(Integer dgpage,Integer rows){
    	if(dgpage != null){
    		this.dgpage = dgpage;
    	}
    	//this.rows = rows;
    }
    
	protected void renderJson(Object object, JsonConfig config) {
		JSONObject jsonObject = JSONObject.fromObject(object, config);
		renderJson(jsonObject.toString());
	}
	protected void renderJson(Object object) {
		JSONObject jsonObject = JSONObject.fromObject(object);
		renderJson(jsonObject.toString());
	}
	protected void renderJson(Page page) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("items", page.getItems());
		jsonMap.put("total", page.getTotal());
		renderJson(jsonMap);
	}
	
	protected void renderJson(Map<String, ?> jsonMap) {
		JSONObject jsonObject = JSONObject.fromObject(jsonMap,JsonUtils.configJson("yyyy-MM-dd"));
		String s = jsonObject.toString();
		renderJson(s);
	}

	protected void renderJson(Map<String, ?> jsonMap, JsonConfig config) {
		JSONObject jsonObject = JSONObject.fromObject(jsonMap, config);
		String s = jsonObject.toString();
		renderJson(s);
	}
	
	protected void renderJson(List<?> list) {
		JSONArray JSONArray = net.sf.json.JSONArray.fromObject(list,JsonUtils.configJson("yyyy-MM-dd"));
		renderJson(JSONArray.toString());
	}

	protected void renderJson(List<?> list, JsonConfig config) {
		JSONArray JSONArray = net.sf.json.JSONArray.fromObject(list, config);
		renderJson(JSONArray.toString());
	}

	protected void renderJson(List<?> list, String entityKey, JsonConfig config) {
		List<Map<String, Object>> jsonList = JsonUtils.toMapList(list, entityKey);
		renderJson(jsonList, config);
	}
	
	/**
	 * ֱ�����json�ַ���.
	 * @param json
	 * @return
	 */
	protected void renderJson(String json) {
		render(json, "text/json;charset=UTF-8");
	}

	
	/**
	 * ֱ�����JS�ַ���.
	 * @param jsText
	 * @return
	 */
	protected void renderJs(String jsText) {
		render(jsText, "application/x-javascript;charset=utf-8");
	}
	
	/**
	 * ֱ������ַ���.
	 */
	protected void renderText(String text) {
		WebUtils.setNoCacheHeader(response);
		render(text, "text/plain;charset=UTF-8");
	}

	/**
	 * ֱ�����HTML.
	 */
	protected void renderHtml(String html) {
		render(html, "text/html;charset=UTF-8");
	}

	/**
	 * ֱ�����XML.
	 */
	protected void renderXML(String xml) {
		
		render(xml, "text/xml;charset=UTF-8");
	}
	
	protected void render(String text, String contentType) {
		try {
			WebUtils.setNoCacheHeader(response);
			response.setContentType(contentType);
			response.getWriter().write(text);
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���FusionCharts��XML
	 * 
	 * @param xml
	 */
	protected void renderFusionChartsXML(String xml) {

		try {
			WebUtils.setNoCacheHeader(response);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/xml; charset=UTF-8");
			OutputStream outs = response.getOutputStream();
			outs.write(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF });
			outs.flush();
			outs.write(xml.getBytes("UTF-8"));
			outs.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public  String truncate(String str, int bytelength, String sufix) {
		
		return StringHelper.truncate(str, bytelength, sufix);
	}
	
	public void CheckNotNull(Object ...objects ){
		WebUtils.CheckNotNull(objects);
	}
	
	public void CheckInValidChars(String... Strings) {
		WebUtils.CheckInValidChars(Strings);
	}

	public void CheckInValidSQLChars(String... a) {
		WebUtils.CheckInValidSQLChars(a);
	}
	
	public void renderJson(Object... vals) {
		Map jsonMap =new HashMap();
		
		for(int i = 0;vals !=null && i<vals.length;i+=2){
			Object i1 = vals[i];
			Object i2 = vals[i+1];
			jsonMap.put(i1, i2);
		}
		this.renderJson(jsonMap);
	}
	
	/***********************�ļ��ϴ�***********************/
	    private String allowSuffix = "jpg,png,gif,jpeg,txt,cdr,jcd,3dm";//�����ļ���ʽ
	    private long allowSize = 5L;//�����ļ���С
	    private String fileName;//�ļ���(��������·��)
	    private String[] fileNames;
	    private String model;//�ļ��ϴ�ģ��
	    private String fName;//�ļ���(������չ��)
	    private String[] fNames;
	    private String srcFilePath;
	    
	    private String minFilePath;//����ͼ���·��
	    private String minFileName;//����ͼ����
	    
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
	    public String getModel() {
			return StringUtil.isEmpty(model) ? "" : model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		//�ϴ��ļ�Ŀ¼
		public String getStaticDir() {
			return "";
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

		public String getSrcFilePath() {
			return srcFilePath;
		}

		public void setSrcFilePath(String srcFilePath) {
			this.srcFilePath = srcFilePath;
		}

		public String getMinFileName() {
			return minFileName;
		}

		public void setMinFileName(String minFileName) {
			this.minFileName = minFileName;
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
	                	destDir = getStaticDir() + getModel();
	                }else{
	                	destDir = getStaticDir() + destDir;
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
	    public String upload(MultipartFile file,String fileType, String destDir,HttpServletRequest request) throws Exception {
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
	                	destDir = getStaticDir() + getModel();
	                }else{
	                	destDir = getStaticDir() + destDir;
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
	                setSrcFilePath(destFile.getAbsoluteFile()+"/"+fileNameNew);
	                setMinFilePath(realPath+destDir+"min");
	        } catch (Exception e) {
	            throw e;
	        }
	        return fName;
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
				
				File mdestFile = new File(getMinFilePath());
                if(!mdestFile.exists()){
                	mdestFile.mkdirs();
                }
				
				String uploadFileName = getfName();
		        int index = uploadFileName.lastIndexOf(".");
		        if (index != -1) {
		        	minFileName = uploadFileName.substring(0, index) + "_min" + uploadFileName.substring(index);
		        } else {
		        	minFileName = uploadFileName+"_min.jpg";
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
