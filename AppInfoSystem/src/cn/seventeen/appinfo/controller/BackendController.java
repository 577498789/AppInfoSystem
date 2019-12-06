package cn.seventeen.appinfo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.seventeen.appinfo.entity.BackendUser;
import cn.seventeen.appinfo.entity.DevUser;
import cn.seventeen.appinfo.service.BackendUserService;
import cn.seventeen.appinfo.service.DevUserService;
//管理员控制器
@Controller
@RequestMapping("/backend")
public class BackendController {
	
	@Resource
	private BackendUserService backendUserService;
	//去登录
	@RequestMapping("/gologin")
	public String goLogin() {
		return"backendlogin";
	}
	//登录
	@RequestMapping("/login")
	public String doBackendUserLogin(String userCode, String userPassword,HttpSession session) {
		BackendUser backendUser = backendUserService.findBackendUserByUserCodeAndUserPassword(userCode, userPassword);
		if(backendUser!=null) {
			session.setAttribute("userSession", backendUser);
			return"backend/main";
		}else {
			return"backendlogin";
		}
	}
	//注销
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return"redirect:/index.jsp";
	}
}
