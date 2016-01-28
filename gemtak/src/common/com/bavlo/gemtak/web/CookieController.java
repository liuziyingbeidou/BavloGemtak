package com.bavlo.gemtak.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title: ����Gemtak
 * @ClassName: CookieController 
 * @Description: Cookie
 * @author liuzy
 * @date 2016-1-26 ����03:50:27
 */
@Controller("cookieController")
@RequestMapping(value="coki")
public class CookieController extends BaseController {
	
	/**
     * ��ȡ����cookie
     * ע������ӿͻ��˶�ȡCookieʱ������maxAge���ڵ��������Զ��ǲ��ɶ��ģ�Ҳ���ᱻ�ύ��������ύCookieʱֻ���ύname��value���ԡ�maxAge����ֻ������������ж�Cookie�Ƿ����
     * @param request
     * @param response
     */
    @RequestMapping("/showCookies")
    public void showCookies(HttpServletRequest request,HttpServletResponse response ){
         
        Cookie[] cookies = request.getCookies();//��������Ի�ȡһ��cookie����
        if (null==cookies) {
            System.out.println("û��cookie=========");
        } else {
            for(Cookie cookie : cookies){
                System.out.println("name:"+cookie.getName()+",value:"+ cookie.getValue());
            }
        }
         
    }
    /**
     * ���cookie
     * @param response
     * @param name
     * @param value
     */
    @RequestMapping("/addCookie")
    public void addCookie(HttpServletResponse response,String name,String value){
        Cookie cookie = new Cookie(name.trim(), value.trim());
        cookie.setMaxAge(-1);// ����Ϊ30min
        cookie.setPath("/");
        System.out.println(name+"Cookie�����===============");
        response.addCookie(cookie);
    }
    /**
     * �޸�cookie
     * @param request
     * @param response
     * @param name
     * @param value
     * ע��һ���޸ġ�ɾ��Cookieʱ���½���Cookie��value��maxAge֮����������ԣ�����name��path��domain�ȣ���Ҫ��ԭCookie��ȫһ�����������������Ϊ������ͬ��Cookie���踲�ǣ������޸ġ�ɾ��ʧ�ܡ�
     */
    @RequestMapping("/editCookie")
    public void editCookie(HttpServletRequest request,HttpServletResponse response,String name,String value){
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
            System.out.println("û��cookie==============");
        } else {
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(name)){
                    System.out.println("ԭֵΪ:"+cookie.getValue());
                    cookie.setValue(value);
                    cookie.setPath("/");
                    cookie.setMaxAge(30 * 60);// ����Ϊ30min
                    System.out.println("���޸ĵ�cookie����Ϊ:"+cookie.getName()+",��ֵΪ:"+cookie.getValue());
                    response.addCookie(cookie);
                    break;
                }
            }
        }
         
    }
    /**
     * ɾ��cookie
     * @param request
     * @param response
     * @param name
     */
    @RequestMapping("/delCookie")
    public void delCookie(HttpServletRequest request,HttpServletResponse response,String name){
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
            System.out.println("û��cookie==============");
        } else {
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(name)){
                    cookie.setValue(null);
                    cookie.setMaxAge(0);// ��������cookie
                    cookie.setPath("/");
                    System.out.println("��ɾ����cookie����Ϊ:"+cookie.getName());
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }
}
