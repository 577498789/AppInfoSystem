package cn.seventeen.appinfo.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.seventeen.appinfo.entity.AppInfo;
import cn.seventeen.appinfo.entity.DevUser;
import cn.seventeen.appinfo.entity.Page;
import cn.seventeen.appinfo.service.AppCategoryService;
import cn.seventeen.appinfo.service.AppInfoService;
import cn.seventeen.appinfo.service.DataDictionaryService;
import cn.seventeen.appinfo.service.DevUserService;

//开发者控制器
@Controller
@RequestMapping("/dev")
public class DevController {
	
	@Resource
	private DevUserService devUserService;
	@Resource
	private AppInfoService appInfoService;
	@Resource
	private AppCategoryService appCategoryService;
	@Resource
	private DataDictionaryService dataDictionaryService;
	
	private Map<String,Object> map = new HashMap<String, Object>();
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
	
	@RequestMapping("/goAppinfoList")
	public String goAppinfoList(Model model,HttpSession session) {
		DevUser devUser =(DevUser) session.getAttribute("devUserSession");
		Page page = new Page();
		map.put("devId", devUser.getId());
		map.put("softwareName", null);
		map.put("flatformId", null);
		map.put("status", null);
		map.put("categoryLevel1", null);
		map.put("categoryLevel2", null);
		map.put("categoryLevel3", null);
		map.put("page",page);
		model.addAttribute("appInfoList", appInfoService.findAppInfos(map));
		model.addAttribute("pages", page);
		model.addAttribute("statusList", dataDictionaryService.findDataDictionaryByTypeCode("APP_STATUS"));
		model.addAttribute("flatFormList", dataDictionaryService.findDataDictionaryByTypeCode("APP_FLATFORM"));
		model.addAttribute("categoryLevel1List", appCategoryService.findAppCategorysByParentId(null));
		return"developer/appinfolist";
	}
	
	@RequestMapping("/findAppinfoByInfo")
	public String findAppinfoByInfo(String querySoftwareName,Integer queryFlatformId,Integer queryStatus,Integer queryCategoryLevel1,Integer queryCategoryLevel2,Integer queryCategoryLevel3,HttpSession session,Model model) {
		DevUser devUser =(DevUser) session.getAttribute("devUserSession");
		Page page = new Page();
		map.put("devId", devUser.getId());
		map.put("softwareName", querySoftwareName);
		map.put("flatformId", queryFlatformId);
		map.put("status", queryStatus);
		map.put("categoryLevel1", queryCategoryLevel1);
		map.put("categoryLevel2", queryCategoryLevel2);
		map.put("categoryLevel3", queryCategoryLevel3);
		map.put("page",page);
		model.addAttribute("appInfoList", appInfoService.findAppInfos(map));
		model.addAttribute("pages", page);
		return"developer/appinfolist_ajax";
	}
	
	@RequestMapping("/changePage")
	public String changePage(Integer pageNo,Model model) {
		Page page = new Page();
		System.out.println(pageNo);
		page.setPageNo(pageNo);
		map.put("page", page);
		model.addAttribute("appInfoList", appInfoService.findAppInfos(map));
		model.addAttribute("pages", page);
		return"developer/appinfolist_ajax";
	}
	
	
	@RequestMapping("categorylevellist")
	@ResponseBody
	public Object categorylevellist(Integer pid) {
		return appCategoryService.findAppCategorysByParentId(pid);
	}
	
	@RequestMapping("goAddAppInfo")
	public Object goAddAppInfo(Model model) {
		model.addAttribute("flatFormList", dataDictionaryService.findDataDictionaryByTypeCode("APP_FLATFORM"));
		model.addAttribute("categoryLevel1List", appCategoryService.findAppCategorysByParentId(null));
		return "developer/appinfoadd";
	}
	
	@RequestMapping("addAppInfo")
	@ResponseBody
	public Object addAppInfo(HttpServletRequest req,HttpSession session,String softwareName,String APKName,String supportROM,String interfaceLanguage,BigDecimal softwareSize,Integer downloads,Integer flatformId,Integer categoryLevel1,Integer categoryLevel2,Integer categoryLevel3,Integer status,String appInfo,MultipartFile a_logoPicPath, Model model) throws IllegalStateException, IOException {
		//
		String realPath = req.getServletContext().getRealPath("/");
		//文件名
		String fileName = a_logoPicPath.getOriginalFilename();
		//后缀
		System.out.println(fileName);
		String prefix = FilenameUtils.getExtension(fileName);
		String contextPath = req.getContextPath();
		System.out.println(contextPath);
		DevUser devUser =(DevUser) session.getAttribute("devUserSession");
		String newFileName = APKName +"."+prefix;
		String logoLocPath = realPath+"statics\\uploadfiles\\"+newFileName;
		String logoPicPath = contextPath +"/statics/uploadfiles/"+newFileName;
		System.out.println(logoLocPath);
		System.out.println(logoPicPath);
		if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") ||prefix.equalsIgnoreCase("jepg") || prefix.equalsIgnoreCase("pneg")) {
			 File targetFile = new File(logoLocPath);
			 if(!targetFile.exists()){
				 a_logoPicPath.transferTo(targetFile);
			 }else {
				 System.out.println("图片已存在");
			 }
		}else {
			return "<script>alert('请选择图片');history.back();</script>";
		}
		AppInfo app = new AppInfo(null, softwareName, APKName, supportROM, interfaceLanguage, new Date(), softwareSize, devUser.getId(), appInfo, status, new Date(), new Date(), categoryLevel3, downloads, flatformId, devUser.getId(), new Date(), devUser.getId(), new Date(), null, null, null, null, categoryLevel1, categoryLevel2, null, null, logoPicPath, logoLocPath, null, null);
		if(appInfoService.addAppInfo(app)) {
			return "<script>alert('上传成功');location='/AppInfoSystem/dev/goAppinfoList.do';</script>";
		}else {
			return "<script>alert('上传失败');history.back();</script>";
		}
	}
	
	@RequestMapping("sb")
	public String sb() {
		return"developer/appinfoadd";
	}
}
