package cn.seventeen.appinfo.controller;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
import cn.seventeen.appinfo.utility.Tool;
@Controller
@RequestMapping("dev/app")
public class DevAppController {
	@Resource
	private AppInfoService appInfoService;
	@Resource
	private AppCategoryService appCategoryService;
	@Resource
	private DataDictionaryService dataDictionaryService;
	@Resource
	private AppVersionService appVersionService;
	/**
	 * 转到app列表页面的方法
	 */
	@RequestMapping("goAppinfoList")
	public String goAppinfoList(Model model,HttpSession session) {
		DevUser devUser =(DevUser) session.getAttribute(Tool.DEVELOPER_USER);
		Page page = new Page();
		Map map = new HashMap();
		map.put("devId", devUser.getId());
		map.put("page",page);
		session.setAttribute("selectInfoMap", map);
		model.addAttribute("appInfoList", appInfoService.findAppInfos(map));
		model.addAttribute("statusList", dataDictionaryService.findDataDictionaryByTypeCode(Tool.APP_STATUS));
		model.addAttribute("flatFormList", dataDictionaryService.findDataDictionaryByTypeCode(Tool.APP_FLATFORM));
		model.addAttribute("categoryLevel1List", appCategoryService.findAppCategorysByParentId(null));
		return"developer/appinfolist";
	}
	/**
	 * 查询app列表的方法
	 */
	@RequestMapping("findAppinfoByInfo")
	public String findAppinfoByInfo(String querySoftwareName,Integer queryFlatformId,Integer queryStatus,Integer queryCategoryLevel1,Integer queryCategoryLevel2,Integer queryCategoryLevel3,HttpSession session,Model model) {
		DevUser devUser =(DevUser) session.getAttribute(Tool.DEVELOPER_USER);
		Map map = (Map) session.getAttribute("selectInfoMap");
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
		return"developer/appinfolist_ajax";
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
		return"developer/appinfolist_ajax";
	}
	/**
	 * app列表翻页的方法
	 */
	@RequestMapping("refresh")
	public String refresh(HttpSession session,Model model) {
		Map map = (Map) session.getAttribute("selectInfoMap");
		model.addAttribute("appInfoList", appInfoService.findAppInfos(map));
		return"developer/appinfolist";
	}
	/**
	 * 转到添加app信息的页面
	 */
	@RequestMapping("goAddAppInfo")
	public String goAddAppInfo(Model model) {
		model.addAttribute("flatFormList", dataDictionaryService.findDataDictionaryByTypeCode(Tool.APP_FLATFORM));
		model.addAttribute("categoryLevel1List", appCategoryService.findAppCategorysByParentId(null));
		return "developer/appinfoadd";
	}
	/**
	 * 判断apk名字是否存在的方法
	 */
	@RequestMapping("apkNameExist")
	@ResponseBody
	public Object apkNameExist(String APKName) {
		return appInfoService.exist(APKName);
	}
	/**
	 * 添加app信息的方法
	 */
	@RequestMapping("addAppInfo")
	@ResponseBody
	public Object addAppInfo(HttpSession session,String softwareName,String APKName,String supportROM,String interfaceLanguage,BigDecimal softwareSize,Integer downloads,Integer flatformId,Integer categoryLevel1,Integer categoryLevel2,Integer categoryLevel3,Integer status,String appInfo,MultipartFile a_logoPicPath, Model model) throws IllegalStateException, IOException {
		//文件名
		String fileName = a_logoPicPath.getOriginalFilename();
		//后缀
		String prefix = FilenameUtils.getExtension(fileName);
		DevUser devUser =(DevUser) session.getAttribute("devUserSession");
		String newFileName = APKName +"."+prefix;
		String logoLocPath =Tool.FILE_LOCAL+newFileName;
		String logoPicPath = Tool.LOCAL +"/statics/uploadfiles/"+newFileName;
		if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") ||prefix.equalsIgnoreCase("jepg") || prefix.equalsIgnoreCase("pneg")) {
			File targetFile = new File(logoLocPath);
			a_logoPicPath.transferTo(targetFile);
		}else
			return "<script>alert('请选择图片');history.back();</script>";
		AppInfo app = new AppInfo(null, softwareName, APKName, supportROM, interfaceLanguage, new Date(), softwareSize, devUser.getId(), appInfo, status, new Date(), new Date(), categoryLevel3, downloads, flatformId, devUser.getId(), new Date(), devUser.getId(), new Date(), null, null, null, null, categoryLevel1, categoryLevel2, null, null, logoPicPath, logoLocPath, null, null);
		if(appInfoService.addAppInfo(app)) {
			Map map = (Map) session.getAttribute("map");
			Page page = (Page) map.get("page");
			page.setRecords(page.getRecords()+1);
			return "<script>alert('上传成功');location='"+Tool.LOCAL+"dev/app/refresh.do';</script>";
		}
		return "<script>alert('上传失败');history.back();</script>";
	}
	/**
	 * 显示app信息的方法
	 */
	@RequestMapping("showAppInfo{id}")
	public String showAppInfo(@PathVariable Integer id,Model model) {
		AppInfo appInfo = appInfoService.findAppInfoById(id);
		List<AppVersion> appVersionList = appVersionService.findAppVersionsByAppId(id);
		model.addAttribute("appInfo", appInfo);
		model.addAttribute("appVersionList", appVersionList);
		return"developer/appinfoview";
	}
	/**
	 * 删除app信息的方法
	 */
	@RequestMapping("delAppInfo")
	@ResponseBody
	public boolean delAppInfo(Integer id,HttpSession session) {
		if(appInfoService.deleteAppInfo(id)) {
			appVersionService.deleteAppVersionsByAppId(id);
			Map map = (Map) session.getAttribute("selectInfoMap");
			Page page = (Page) map.get("page");
			appInfoService.initialPage(page, map);
			return true;
		}
		return false;
	}
	/**
	 * 转到修改app信息页面的方法
	 */
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
	/**
	 * 修改app信息的方法
	 */
	@RequestMapping("modifyAppInfo")
	@ResponseBody
	public String modifyAppInfo(AppInfo appInfo,MultipartFile attach,HttpSession session) {
		DevUser devUser =(DevUser) session.getAttribute("devUserSession");
		//文件名
		String fileName = attach.getOriginalFilename();
		if(fileName!=""&&fileName!=null) {
			//后缀
			String prefix = FilenameUtils.getExtension(fileName);
			String newFileName = appInfo.getAPKName() +"."+prefix;
			String logoLocPath = Tool.FILE_LOCAL+newFileName;
			String logoPicPath = Tool.LOCAL +"/statics/uploadfiles/"+newFileName;
			if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") ||prefix.equalsIgnoreCase("jepg") || prefix.equalsIgnoreCase("pneg")) {
				File targetFile = new File(logoLocPath);
				try {
					attach.transferTo(targetFile);
					appInfo.setLogoLocPath(logoLocPath);
					appInfo.setLogoPicPath(logoPicPath);
				} catch (IllegalStateException | IOException e) {
					System.out.println("文件上传失败");
					e.printStackTrace();
				}
			}else
				return "<script>alert('请选择图片');history.back();</script>";
		}
		appInfo.setModifyBy(devUser.getId());
		if(appInfoService.modifyAppInfo(appInfo))
			return "<script>alert('app信息修改成功');location='"+Tool.LOCAL+"dev/app/refresh.do';</script>";
			return "<script>alert('app信息修改失败');history.back();</script>"; 
	}
	/**
	 * 更改app状态的方法
	 */
	@RequestMapping("upperOrLowerShelf")
	@ResponseBody
	public String upperOrLowerShelf(AppInfo appInfo,HttpSession session) {
		DevUser devUser =(DevUser) session.getAttribute("devUserSession");
		appInfo.setModifyBy(devUser.getId());
		if(appInfoService.modifyAppInfo(appInfo))
			return "1";
		return "0"; 
	}
}
