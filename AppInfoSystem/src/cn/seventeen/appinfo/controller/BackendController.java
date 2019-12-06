package cn.seventeen.appinfo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.seventeen.appinfo.entity.BackendUser;
import cn.seventeen.appinfo.entity.DevUser;
import cn.seventeen.appinfo.service.BackendUserService;
import cn.seventeen.appinfo.service.DevUserService;
//����Ա������
@Controller
@RequestMapping("/backend")
public class BackendController {
	
	@Resource
	private BackendUserService backendUserService;
	//ȥ��¼
	@RequestMapping("/gologin")
	public String goLogin() {
		return"backendlogin";
	}
	//��¼
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
	//ע��
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return"redirect:/index.jsp";
	}
}
