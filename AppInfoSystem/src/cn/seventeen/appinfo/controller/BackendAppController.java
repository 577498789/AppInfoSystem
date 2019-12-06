package cn.seventeen.appinfo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

@Controller
@RequestMapping("backend/app")
public class BackendAppController {
	@Resource
	private AppInfoService appInfoService;
	@Resource
	private AppCategoryService appCategoryService;
	@Resource
	private DataDictionaryService dataDictionaryService;
	@Resource
	private AppVersionService appVersionService;
	@RequestMapping("goAppInfoList")
	public String goAppInfoList(Model model,HttpSession session) {
		Page page = new Page();
		Map map = new HashMap();
		map.put("page",page);
		map.put("status", 1);
		session.setAttribute("selectInfoMap", map);
		model.addAttribute("appInfoList", appInfoService.findAppInfos(map));
		model.addAttribute("statusList", dataDictionaryService.findDataDictionaryByTypeCode(Tool.APP_STATUS));
		model.addAttribute("flatFormList", dataDictionaryService.findDataDictionaryByTypeCode(Tool.APP_FLATFORM));
		model.addAttribute("categoryLevel1List", appCategoryService.findAppCategorysByParentId(null));
		return "backend/applist";
	}
	
	/**
	 * 查询app列表的方法
	 */
	@RequestMapping("/findAppinfoByInfo")
	public String findAppinfoByInfo(String querySoftwareName,Integer queryFlatformId,Integer queryStatus,Integer queryCategoryLevel1,Integer queryCategoryLevel2,Integer queryCategoryLevel3,HttpSession session,Model model) {
		Map map = (Map) session.getAttribute("selectInfoMap");
		Page page = new Page();
		map.put("softwareName", querySoftwareName);
		map.put("flatformId", queryFlatformId);
		map.put("status", 1);
		map.put("categoryLevel1", queryCategoryLevel1);
		map.put("categoryLevel2", queryCategoryLevel2);
		map.put("categoryLevel3", queryCategoryLevel3);
		map.put("page",page);
		model.addAttribute("appInfoList", appInfoService.findAppInfos(map));
		return"backend/applist_ajax";
	}
	/**
	 * app列表翻页的方法
	 */
	@RequestMapping("changePage")
	public String changePage(HttpSession session,Integer pageNo,Model model) {
		Map map = (Map) session.getAttribute("selectInfoMap");
		Page page = (Page) map.get("page");
		page.setPageNo(pageNo);
		model.addAttribute("appInfoList", appInfoService.findAppInfos(map));
		return"backend/applist_ajax";
	}
	/**
	 * app列表翻页的方法
	 */
	@RequestMapping("refresh")
	public String refresh(HttpSession session,Model model) {
		Map map = (Map) session.getAttribute("selectInfoMap");
		model.addAttribute("appInfoList", appInfoService.findAppInfos(map));
		return"backend/applist";
	}
	/**
	 * 转到app审核页面的方法
	 */
	@RequestMapping("goExamineApp{appId}")
	public String goExamineApp(@PathVariable Integer appId,Model model) {
		AppInfo app = appInfoService.findAppInfoById(appId);
		AppVersion version = appVersionService.findAppVersionsById(app.getVersionId());
		model.addAttribute("appInfo", app);
		model.addAttribute("appVersion", version);
		return "backend/appcheck";
	}
	
	/**
	 * app审核的方法
	 */
	@RequestMapping("examineApp")
	@ResponseBody
	public String examineApp(HttpSession session,Integer appId,Integer status,Model model) {
		AppInfo appInfo = new AppInfo();
		appInfo.setId(appId);
		appInfo.setStatus(status);
		if(appInfoService.modifyAppInfo(appInfo)) {
			return "1";
		}else {
			return "0";
		}
	}
	

}
