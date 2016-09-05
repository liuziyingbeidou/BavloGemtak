package com.bavlo.gemtak.web.gem;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bavlo.gemtak.model.gem.EquipmentVO;
import com.bavlo.gemtak.service.gem.itf.IGemService;
import com.bavlo.gemtak.web.BaseController;

/**
 * @Title: 接口Gemtak
 * @ClassName: InvokeController 
 * @Description: 宝石上传图片的接口类
 * @author liuzy
 * @date 2016-3-30  09:44:28
 */
@Controller("invokeController")
@RequestMapping(value="invokeGemtak")
public class InvokeController extends BaseController {

	@Resource
	IGemService gemService;
	
	/**
	 * 1.设备上传图片接口
	 * @param request
	 * @param response
	 * @param ecode
	 * @return
	 */
	@RequestMapping("uploadGemPic")
	@ResponseBody
	public String uploadGemPic(HttpServletRequest request,HttpServletResponse response,String ecode){
		//判断当前登录的商家
		String gemId;
		try {
			gemId =  gemService.saveHeadAndBody(ecode);
		} catch (Exception e) {
			e.printStackTrace();
			gemId = null;
		}
		return gemId;
	}
	
	/**
	 * 2.设备上传完成调用的接口
	 * @param request
	 * @param respose
	 * @param Gid
	 * @param Direction
	 * @param ViewAngle
	 * @param Height
	 * @param Brand
	 * @param Weight
	 * @param Multiple
	 * @param LightType
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value="saveGem",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String  saveGem(HttpServletRequest request,HttpServletResponse respose,String Gid,String Direction,
			String ViewAngle,String Height,String Brand,String Weight,String Multiple,String LightType) throws UnsupportedEncodingException{
		Integer light = Integer(LightType);
		Boolean fg = false;
		try {
			gemService.getGemVOByGid(Gid,Direction,ViewAngle, Height, Brand,Weight,Multiple,light);
			fg = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fg = false;
		}
		
		return fg ? "SUCCESS":"FAIL";
	}
	
	private Integer Integer(String lightType) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 3.将所有的供应商数据传给设备
	 * @param request
	 * @param respose
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value="getSupplier",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getSupplier(HttpServletRequest request,HttpServletResponse respose) throws UnsupportedEncodingException{
		System.out.println("当前编码："+request.getCharacterEncoding());
		StringBuffer su = new StringBuffer();
		List<EquipmentVO> list = gemService.getSupplier();
		for (EquipmentVO eq : list) {
			su.append(eq.getCompany());
			su.append("/");
		}
		return su.toString();
	}
	
}
