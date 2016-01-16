package com.bavlo.counter.web.manage.tools;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;

import com.bavlo.counter.service.manage.tools.itf.IToolsService;
import com.bavlo.counter.web.BaseController;

/**
 * @Title: 宝珑Counter
 * @ClassName: ToolsController 
 * @Description: 工具管理Controller
 * @author liuzy
 * @date 2015-12-7 下午04:12:33
 */
@Controller("toolsController")
@RequestMapping(value="/tools")
public class ToolsController extends BaseController implements ServletContextAware{
	
	@Resource
	IToolsService toolsService;
	
    private ServletContext servletContext; 
   
	
    @Override  
    public void setServletContext(ServletContext servletContext) {  
        this.servletContext = servletContext;  
    }  
}
