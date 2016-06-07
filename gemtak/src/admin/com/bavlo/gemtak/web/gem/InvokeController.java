package com.bavlo.gemtak.web.gem;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bavlo.gemtak.service.gem.itf.IGemService;
import com.bavlo.gemtak.web.BaseController;

/**
 * @Title: 宝珑Gemtak
 * @ClassName: InvokeController 
 * @Description: 接口
 * @author liuzy
 * @date 2016-3-30 上午09:44:28
 */
@Controller("invokeController")
@RequestMapping(value="invokeGemtak")
public class InvokeController extends BaseController {

	@Resource
	IGemService gemService;
	
	@RequestMapping("uploadGemPic")
	@ResponseBody
	public String uploadGemPic(HttpServletRequest request,HttpServletResponse response,String ecode,Integer equipmentId){
		//如果在同一时间登录的商户 有多家，须判断是否为当前登录的商家
		String gemId;
		try {
			gemId =  gemService.saveHeadAndBody(ecode, equipmentId);
		} catch (Exception e) {
			e.printStackTrace();
			gemId = null;
		}
		return gemId;
	}
	
	@RequestMapping("saveGem")
	@ResponseBody
	public String  saveGem(HttpServletRequest request,HttpServletResponse respose,String gid,String weight,String viewpoint,String average_color){
		Boolean fg = false;
		try {
			gemService.getGemVOByGid(gid, weight, viewpoint, average_color);
			fg = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fg = false;
		}
		return fg ? "SUCCESS":"FAIL";
	}
	
}
