package cn.seventeen.appinfo.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.seventeen.appinfo.entity.AppInfo;
import cn.seventeen.appinfo.entity.AppVersion;
import cn.seventeen.appinfo.entity.DevUser;
import cn.seventeen.appinfo.entity.Page;
import cn.seventeen.appinfo.service.AppCategoryService;
import cn.seventeen.appinfo.service.AppInfoService;
import cn.seventeen.appinfo.service.AppVersionService;
import cn.seventeen.appinfo.service.DataDictionaryService;
import cn.seventeen.appinfo.service.DevUserService;
import cn.seventeen.appinfo.utility.Tool;

//开发者控制器
@Controller
@RequestMapping("/dev")
public class DevController {
	@Resource
	private DevUserService devUserService;
	/**
	 * 转到登录页面的方法
	 * @return
	 */
	@RequestMapping("/gologin")
	public String goDevUserLogin() {
		return"devlogin";
	}
	/**
	 * 登录的方法
	 */
	@RequestMapping("/login")
	public String doDevUserLogin(String devCode,String devPassword,HttpSession session) {
		DevUser devUser = devUserService.findDevUserByDevCodeAndDevPassword(devCode, devPassword);
		if(devUser!=null) {
			session.setAttribute(Tool.DEVELOPER_USER, devUser);
			return"developer/main";
		}else
			return"devlogin";
	}
	/**
	 *注销的方法 
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return"redirect:/index.jsp";
	}
}
