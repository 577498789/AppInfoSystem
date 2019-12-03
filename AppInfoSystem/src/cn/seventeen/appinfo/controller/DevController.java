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
	@Resource
	private AppVersionService appVersionService;
	
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
		Map map = new HashMap();
		map.put("devId", devUser.getId());
		map.put("softwareName", null);
		map.put("flatformId", null);
		map.put("status", null);
		map.put("categoryLevel1", null);
		map.put("categoryLevel2", null);
		map.put("categoryLevel3", null);
		map.put("page",page);
		session.setAttribute("devSelectInfoMap", map);
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
		
		Map map = (Map) session.getAttribute("devSelectInfoMap");
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
	public String changePage(HttpSession session,Integer pageNo,Model model) {
		Map map = (Map) session.getAttribute("devSelectInfoMap");
		Page page = (Page) map.get("page");
		page.setPageNo(pageNo);
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
	public String goAddAppInfo(Model model) {
		model.addAttribute("flatFormList", dataDictionaryService.findDataDictionaryByTypeCode("APP_FLATFORM"));
		model.addAttribute("categoryLevel1List", appCategoryService.findAppCategorysByParentId(null));
		return "developer/appinfoadd";
	}
	
	@RequestMapping("apkNameExist")
	@ResponseBody
	public Object apkNameExist(String APKName) {
		return appInfoService.exist(APKName);
	}
	
	@RequestMapping("addAppInfo")
	@ResponseBody
	public Object addAppInfo(HttpServletRequest req,HttpSession session,String softwareName,String APKName,String supportROM,String interfaceLanguage,BigDecimal softwareSize,Integer downloads,Integer flatformId,Integer categoryLevel1,Integer categoryLevel2,Integer categoryLevel3,Integer status,String appInfo,MultipartFile a_logoPicPath, Model model) throws IllegalStateException, IOException {
		//
		String realPath = req.getServletContext().getRealPath("/");
		//文件名
		String fileName = a_logoPicPath.getOriginalFilename();
		//后缀
		String prefix = FilenameUtils.getExtension(fileName);
		String contextPath = req.getContextPath();
		DevUser devUser =(DevUser) session.getAttribute("devUserSession");
		String newFileName = APKName +"."+prefix;
		String logoLocPath ="D:\\java\\appinfo\\AppInfoSystem\\AppInfoSystem\\WebContent\\statics\\uploadfiles\\"+newFileName;
		String logoPicPath = contextPath +"/statics/uploadfiles/"+newFileName;
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
			return "<script>alert('上传成功');location='goAppinfoList.do';</script>";
		}else {
			return "<script>alert('上传失败');history.back();</script>";
		}
	}
	
	@RequestMapping("showAppInfo{id}")
	public String showAppInfo(@PathVariable Integer id,Model model) {
		AppInfo appInfo = appInfoService.findAppInfoById(id);
		List<AppVersion> appVersionList = appVersionService.findAppVersionsByAppId(id);
		model.addAttribute("appInfo", appInfo);
		model.addAttribute("appVersionList", appVersionList);
		return"developer/appinfoview";
	}
	
	@RequestMapping("delAppInfo")
	@ResponseBody
	public boolean delAppInfo(Integer id) {
		if(appInfoService.deleteAppInfo(id)) {
			appVersionService.deleteAppVersionsByAppId(id);
			return true;
		}
		return false;
	}
	
	@RequestMapping("goAddAppVersion")
	public String goAddAppVersion(Integer id,Model model) {
		List<AppVersion> appVersionList = appVersionService.findAppVersionsByAppId(id);
		model.addAttribute("appId",id);
		model.addAttribute("appVersionList", appVersionList);
		return"developer/appversionadd";
	}
	
	@RequestMapping("addAppversion")
	@ResponseBody
	public String addAppversion(HttpServletRequest req,HttpSession session,Integer appId,String versionNo,BigDecimal versionSize,Integer publishStatus,String versionInfo,MultipartFile a_downloadLink) throws IllegalStateException, IOException {
		DevUser devUser =(DevUser) session.getAttribute("devUserSession");
		String APKName = ((AppInfo)appInfoService.findAppInfoById(appId)).getAPKName();
		//
		String realPath = req.getServletContext().getRealPath("/");
		//文件名
		String fileName = a_downloadLink.getOriginalFilename();
		//后缀
		String prefix = FilenameUtils.getExtension(fileName);
		String contextPath = req.getContextPath();
		String newFileName = APKName +"."+prefix;
		String apkLocPath = "D:\\java\\appinfo\\AppInfoSystem\\AppInfoSystem\\WebContent\\statics\\uploadfiles\\"+newFileName;
		String downloadLink = contextPath +"/statics/uploadfiles/"+newFileName;
		if(prefix.equalsIgnoreCase("apk")) {
			 File targetFile = new File(apkLocPath);
			 if(!targetFile.exists()){
				 a_downloadLink.transferTo(targetFile);
			 }else {
				 System.out.println("文件已存在");
			 }
		}else {
			return "<script>alert('文件格式不正确');history.back();</script>";
		}
		AppVersion version = new AppVersion(null, appId, versionNo, versionInfo, publishStatus, downloadLink, versionSize, devUser.getId(), new Date(), devUser.getId(), new Date(), apkLocPath, null, null, newFileName);
		Integer id = null;
		if(appVersionService.addAppVersion(version,id)){ 
			System.out.println(id);
			return "<script>alert('app版本添加成功');location='goAppinfoList.do';</script>";
		}else { 
			return "<script>alert('app版本添加失败');history.back();</script>"; 
		}
	}
	
	@RequestMapping("goModifyAppInfo{id}")
	public String modifyAppInfo(@PathVariable Integer id,Model model) {
		AppInfo appInfo = appInfoService.findAppInfoById(id);
		List<AppVersion> appVersionList = appVersionService.findAppVersionsByAppId(id);

		model.addAttribute("flatFormList", dataDictionaryService.findDataDictionaryByTypeCode("APP_FLATFORM"));
		model.addAttribute("categoryLevel1List", appCategoryService.findAppCategorysByParentId(null));
		model.addAttribute("categoryLevel2List", appCategoryService.findAppCategorysByParentId(appInfo.getCategoryLevel1()));
		model.addAttribute("categoryLevel3List", appCategoryService.findAppCategorysByParentId(appInfo.getCategoryLevel2()));
		model.addAttribute("appInfo", appInfo);
		model.addAttribute("appVersionList", appVersionList);
		return"developer/appinfomodify";
	}
	
	@RequestMapping("modifyAppInfo")
	@ResponseBody
	public String modifyAppInfo(AppInfo appInfo,HttpServletRequest req,MultipartFile attach,HttpSession session) {
		DevUser devUser =(DevUser) session.getAttribute("devUserSession");
		//文件名
		String fileName = attach.getOriginalFilename();
		if(fileName!=""&&fileName!=null) {
			//
			String realPath = req.getServletContext().getRealPath("/");
			//后缀
			String prefix = FilenameUtils.getExtension(fileName);
			String contextPath = req.getContextPath();
			String newFileName = appInfo.getAPKName() +"."+prefix;
			String logoLocPath = "D:\\java\\appinfo\\AppInfoSystem\\AppInfoSystem\\WebContent\\statics\\uploadfiles\\"+newFileName;
			System.out.println(logoLocPath);
			String logoPicPath = contextPath +"/statics/uploadfiles/"+newFileName;
			if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") ||prefix.equalsIgnoreCase("jepg") || prefix.equalsIgnoreCase("pneg")) {
				 File targetFile = new File(logoLocPath);
				 if(!targetFile.exists()){
					 try {
						attach.transferTo(targetFile);
						appInfo.setLogoLocPath(logoLocPath);
						appInfo.setLogoPicPath(logoPicPath);
					} catch (IllegalStateException | IOException e) {
						System.out.println("文件上传失败");
						e.printStackTrace();
					}
				 }else {
					 System.out.println("图片已存在");
				 }
			}else {
				return "<script>alert('请选择图片');history.back();</script>";
			}
		}
		appInfo.setModifyBy(devUser.getId());
		appInfo.setModifyDate(new Date());
		appInfo.setUpdateDate(new Date());
		if(appInfoService.modifyAppInfo(appInfo)){ 
			return "<script>alert('app信息修改成功');location='goAppinfoList.do';</script>";
		}else { 
			return "<script>alert('app信息修改失败');history.back();</script>"; 
		}
	}
	
	@RequestMapping("goModifyAppVersion")
	public String goModifyAppVersion(Model model,Integer appId,Integer versionId) {
		List<AppVersion> appVersionList = appVersionService.findAppVersionsByAppId(appId);
		AppVersion appVersion = appVersionService.findAppVersionsById(versionId);
		model.addAttribute("appVersionList",appVersionList);
		model.addAttribute("appVersion",appVersion);
		return"developer/appversionmodify";
	}
	
	@RequestMapping("modifyAppVersion")
	public String modifyAppVersion(HttpServletRequest req,AppVersion appVersion,String APKName,MultipartFile attach) {
		String fileName = attach.getName();
		if(fileName!=""&&fileName!="") {
			//
			String realPath = req.getServletContext().getRealPath("/");
			//后缀
			String prefix = FilenameUtils.getExtension(fileName);
			String contextPath = req.getContextPath();
			String newFileName = APKName +"-"+appVersion.getVersionNo()+"."+prefix;
			String apkLocPath = "D:\\java\\appinfo\\AppInfoSystem\\AppInfoSystem\\WebContent\\statics\\uploadfiles\\"+newFileName;
			System.out.println(apkLocPath);
			if(prefix.equalsIgnoreCase("apk")) {
				 File targetFile = new File(apkLocPath);
				 if(!targetFile.exists()){
					 try {
						attach.transferTo(targetFile);
						appVersion.setApkFileName(newFileName);
						appVersion.setApkLocPath(apkLocPath);
					} catch (IllegalStateException | IOException e) {
						System.out.println("文件上传失败");
						e.printStackTrace();
					}
				 }else {
					 System.out.println("apk已存在");
				 }
			}else {
				return "<script>alert('请选择apk');history.back();</script>";
			}
		}
		if(appVersionService.modifyAppVersion(appVersion))
			return"<script>alert('版本修改成功');location='goAppinfoList.do';</script>";
		return"<script>alert('版本修改失败');history.back();</script>";
	}

	@RequestMapping("sb")
	public String sb() {
		return"developer/appinfoadd";
	}
}
