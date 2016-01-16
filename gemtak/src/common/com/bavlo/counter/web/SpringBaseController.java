package com.bavlo.counter.web;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bavlo.counter.commonbeans.Page;
import com.bavlo.counter.model.IdEntity;
import com.bavlo.counter.service.impl.CommonService;
import com.bavlo.counter.utils.JsonUtils;
import com.bavlo.counter.utils.StringHelper;
import com.bavlo.counter.utils.StringUtil;
import com.bavlo.counter.utils.WebUtils;
import com.xinleju.erp.flow.flowutils.bean.PageBean;
 

/**
 * 功能说明：springmvc的基类，处理异常，公共方法
 * @author ducc
 * @created 2014年6月27日 上午6:19:14
 * @updated 
 * @param <T>
 */
public abstract class SpringBaseController<T extends IdEntity,ID extends Serializable> {
	
	@Resource
	private CommonService commonService;
	
	protected Class<?> clasz;
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass()); 
	protected abstract  String getPrefix();
	protected  final String ADD=getPrefix()+"add";
	protected  final String EDIT=getPrefix()+"add";
	protected  final String VIEW=getPrefix()+"view";
	protected  final String LIST=getPrefix()+"list";
	/**
	 * 功能说明：通用列表查询方法，使用pager.ftl的处理页面分页
	 * @author ducc
	 * @updated 
	 * @param request
	 * @param model
	 * @param item
	 * @return
	 */
	@RequestMapping("list")
	protected String list(HttpServletRequest request,Model model,@ModelAttribute T item){
		String indexObj = request.getParameter("page.index");
		String pageSizeObj = request.getParameter("page.pageSize");
		String pageTotal=request.getParameter("page.total");
		
		//model.addAttribute("list", list);
		//model.addAttribute("page",page);
		return LIST;
	} 
	/**
	 * 功能说明：通用跳转到新增页面
	 * @author ducc
	 * @updated 
	 * @return
	 */
	@RequestMapping(value="add",method=RequestMethod.GET)
	protected String add() {
		return ADD;
	}
	/**
	 * 功能说明：通用跳转到编辑页面
	 * @author ducc
	 * @updated 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit/{id}")
	public String edit(Model model,@PathVariable("id") String id){
		//model.addAttribute("item", getBaseService().findById(id));
		return EDIT;
	}
	@RequestMapping(value="/view/{id}")
	public String view(Model model,@PathVariable("id") String id){
		//model.addAttribute("item", getBaseService().findById(id));
		return VIEW;
	}
	/**
	 * 功能说明：通用保存页面
	 * @author ducc
	 * @updated 
	 * @param response
	 * @param item 
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void save(HttpServletResponse response,@ModelAttribute T item){
		Map<String,String> map=new HashMap<String, String>();
		try {
			/*if(StringUtil.isNotEmpty(item.getId())){
				getBaseService().update(item);
			}else{
				getBaseService().save(item);
			}*/
			map.put("flag", "succ");
			map.put("msg", "保存成功！");
			//map.put("id", item.getId());
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("msg", "保存失败！");
			e.printStackTrace();
		}
		
		//SpringMvcUtil.responseJSONWriter(response, map);
	}
	/**
	 * 功能说明：通用删除功能
	 * @author ducc
	 * @updated 
	 * @param response HttpServletResponse
	 * @param id   删除的id
	 */
	@RequestMapping(value="/del/{id}")
	public void del(HttpServletResponse response,@PathVariable String id){
		Map<String,String> map=new HashMap<String, String>();
		try {
			if(StringUtil.isNotEmpty(id)){
				commonService.deleteByDr(getClasz(), id);
				map.put("flag", "succ");
				map.put("msg", "删除成功！");
			}else{
				map.put("flag", "error");
				map.put("msg", "请不要恶意操作！");
			}
		} catch (Exception e) {
			map.put("flag", "error");
			map.put("msg", "删除失败！");
			e.printStackTrace();
		}
		
	}
	/**
	 * 功能说明：使用pager.ftl的处理页面分页
	 *   直接返回springmvc的model
	 * @author ducc
	 * @created 2014年6月28日 下午8:43:56
	 * @updated 
	 * @return
	 */
	protected Model executePage(Model model,T t){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String indexObj = request.getParameter("page.index");
		String pageSizeObj = request.getParameter("page.pageSize");
		String pageTotal=request.getParameter("page.total");
		PageBean page=new PageBean();
//		if(StringUtil.isNotEmpty(indexObj)){
//			page.setIndex(Integer.parseInt((indexObj)));
//		}
//		if(StringUtil.isNotEmpty(pageSizeObj)){
//			page.setPageSize(Integer.parseInt(pageSizeObj));
//		}
//		if(StringUtil.isNotEmpty(pageTotal)){
//			page.setTotal(Integer.parseInt(pageTotal));
//		}
//		PageHelper.startPage(page.getIndex(), page.getPageSize());
//		List<T> list=getBaseService().findListBy(t);
//		page.setTotal(((Page<T>) list).getTotal());
//		model.addAttribute("list", list);
		model.addAttribute("page",page);
		return model;
	}
	/**
	 * 功能说明：获取datatable传过来的数据,普通的get方法
	 * @author ducc
	 * @created 2014年6月29日 下午8:21:42
	 * @updated 
	 * @param t    查询的实体，需要的查询的值，通过实体传过来，由mybatis解析
	 * @param prefix 排序字段的前缀
	 * @return 封装datatable 需要的map数据，由@ResponseBody 转成对应的json
	 */
	protected Map<String,Object> ReturnDataTableGet(T t,String prefix){
		Map<String,Object> map=new HashMap<String, Object>();
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String sEcho = request.getParameter("sEcho"); // 点击的次数
		String startNum = request.getParameter("iDisplayStart"); //从第几条数据开始检索
		String pageSizeStr = request.getParameter("iDisplayLength");//显示的行数
		String sortIndex=request.getParameter("iSortCol_0");//排序索引
		String search=request.getParameter("sSearch");//搜索值
//		t.setSearchValue(search);
//		String sort=request.getParameter("mDataProp_"+sortIndex);
//		String dir=request.getParameter("sSortDir_0");//排序方式
//		PageBean page = new PageBean();
//		if(StringUtil.isNotEmpty(pageSizeStr)){
//			page.setPageSize(Integer.parseInt(pageSizeStr));
//		}
//		if(StringUtil.isNotEmpty(startNum)){
//			page.setIndex((Integer.parseInt(startNum)/page.getPageSize())+1);
//		}
//		
//		if(StringUtil.isEmpty(sort)){
//			sort="id";
//		}
//		if(StringUtil.isEmpty(dir)){
//			dir="asc";
//		}
//		PageHelper.startPage(page.getIndex(), page.getPageSize());
//        List<T> list=getBaseService().findListBy(t, sort, dir);
//		page.setTotal(((Page<T>) list).getTotal());
//		map.put("sEcho", sEcho);
//		map.put("iTotalRecords", page.getTotal());
//		map.put("iTotalDisplayRecords", page.getTotal());
//		map.put("aaData", list);
		return map;
	}
	/**
	 * 功能说明：dataTable ajax post 请求数据的封装
	 * @author ducc
	 * @created 2014年7月4日 上午6:35:22
	 * @updated 
	 * @param t    查询的实体，需要的查询的值，通过实体传过来，由mybatis解析
	 * @param prefix 排序字段的前缀
	 * @return 封装datatable 需要的map数据，由@ResponseBody 转成对应的json
	 */
	protected Map<String,Object> ReturnDataTableAjaxPost(T t,String prefix){
		Map<String,Object> map=new HashMap<String, Object>();
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String sEcho = request.getParameter("draw"); // 点击的次数
		String startNum = request.getParameter("start"); //从第几条数据开始检索
		String pageSizeStr = request.getParameter("length");//显示的行数
		String sortIndex=request.getParameter("order[0][column]");//排序索引
		String search=request.getParameter("search[value]");//搜索值
//		t.setSearchValue(search);
//		String sort=request.getParameter("columns["+sortIndex+"][data]");
//		String dir=request.getParameter("order[0][dir]");//排序方式
//		PageBean page = new PageBean();
//		if(StringUtil.isNotEmpty(pageSizeStr)){
//			page.setPageSize(Integer.parseInt(pageSizeStr));
//		}
//		if(StringUtil.isNotEmpty(startNum)){
//			page.setIndex((Integer.parseInt(startNum)/page.getPageSize())+1);
//		}
//		
//		if(StringUtil.isEmpty(sort)){
//			sort="id";
//		}
//		if(StringUtil.isEmpty(dir)){
//			dir="asc";
//		}
//		PageHelper.startPage(page.getIndex(), page.getPageSize());
//        List<T> list=getBaseService().findListBy(t, sort, dir);
//		page.setTotal(((Page<T>) list).getTotal());
//		map.put("draw", sEcho);
//		map.put("length",pageSizeStr);
//		map.put("iTotalRecords", page.getTotal());
//		map.put("iTotalDisplayRecords", page.getTotal());
//		map.put("data", list);
		return map;
	}
	@InitBinder  
    protected void initBinder(WebDataBinder binder) {  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        dateFormat.setLenient(false);  
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat, false));  
    }  
    @ExceptionHandler
    public String exception(HttpServletRequest request, HttpServletResponse response, Exception e) {  
    	 logger.error(this.getClass()+" is errory, errorType="+e.getClass(),e);
         //如果是json格式的ajax请求
         if (request.getHeader("accept").indexOf("application/json") > -1
                 || (request.getHeader("X-Requested-With")!= null && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1)) { 
//            response.setStatus(500);
//            response.setContentType("application/json;charset=utf-8");   
//            SpringMvcUtil.responseWriter(response, e.getMessage());
            renderJson(e.getMessage());
            return null;
         }
         else{//如果是普通请求
            request.setAttribute("exceptionMsg", e.getMessage());  
            // 根据不同的异常类型可以返回不同界面
            if(e instanceof SQLException) 
                return "sqlerror";   
            else
                return "error";  
        }
    }
	public Class<?> getClasz() {
		return clasz;
	}
	public void setClasz(Class<?> clasz) {
		this.clasz = clasz;
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
	 * 直接输出json字符串.
	 * @param json
	 * @return
	 */
	protected void renderJson(String json) {
		render(json, "text/json;charset=UTF-8");
	}

	
	/**
	 * 直接输出JS字符串.
	 * @param jsText
	 * @return
	 */
	protected void renderJs(String jsText) {
		render(jsText, "application/x-javascript;charset=utf-8");
	}
	
	/**
	 * 直接输出字符串.
	 */
	protected void renderText(String text) {
		WebUtils.setNoCacheHeader(ServletActionContext.getResponse());
		render(text, "text/plain;charset=UTF-8");
	}

	/**
	 * 直接输出HTML.
	 */
	protected void renderHtml(String html) {
		render(html, "text/html;charset=UTF-8");
	}

	/**
	 * 直接输出XML.
	 */
	protected void renderXML(String xml) {
		
		render(xml, "text/xml;charset=UTF-8");
	}
	
	protected void render(String text, String contentType) {
		try {
			WebUtils.setNoCacheHeader(ServletActionContext.getResponse());
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType(contentType);
			response.getWriter().write(text);
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 输出FusionCharts的XML
	 * 
	 * @param xml
	 */
	protected void renderFusionChartsXML(String xml) {

		try {
			WebUtils.setNoCacheHeader(ServletActionContext.getResponse());
			HttpServletResponse response = ServletActionContext.getResponse();
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
}