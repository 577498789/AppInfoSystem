package cn.seventeen.appinfo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.seventeen.appinfo.entity.DevUser;
import cn.seventeen.appinfo.service.BackendUserService;
import cn.seventeen.appinfo.service.DevUserService;

//开发者控制器
@Controller
@RequestMapping("/dev")
public class DevController {
	
	@Resource
	private DevUserService devUserService;
	//去登录页面
	@RequestMapping("/gologin")
	public String goDevUserLogin() {
		return"devlogin";
	}
	//登录方法
	@RequestMapping("/dologin")
	public String doDevUserLogin(String devCode,String devPassword,HttpSession session) {
		DevUser devUser = devUserService.findDevUserByDevCodeAndDevPassword(devCode, devPassword);
		if(devUser!=null) {
			session.setAttribute("devUserSession", devUser);
			return"developer/main";
		}else {
			return"devlogin";
		}
	}
	//注销
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return"devlogin";
	}
	@RequestMapping("sb")
	public String sb() {
		return"developer/main";
	}
}
