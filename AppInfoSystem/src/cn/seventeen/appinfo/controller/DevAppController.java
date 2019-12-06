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
	 * ת��app�б�ҳ��ķ���
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
	 * ��ѯapp�б�ķ���
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
	 * app�б�ҳ�ķ���
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
	 * app�б�ҳ�ķ���
	 */
	@RequestMapping("refresh")
	public String refresh(HttpSession session,Model model) {
		Map map = (Map) session.getAttribute("selectInfoMap");
		model.addAttribute("appInfoList", appInfoService.findAppInfos(map));
		return"developer/appinfolist";
	}
	/**
	 * ת�����app��Ϣ��ҳ��
	 */
	@RequestMapping("goAddAppInfo")
	public String goAddAppInfo(Model model) {
		model.addAttribute("flatFormList", dataDictionaryService.findDataDictionaryByTypeCode(Tool.APP_FLATFORM));
		model.addAttribute("categoryLevel1List", appCategoryService.findAppCategorysByParentId(null));
		return "developer/appinfoadd";
	}
	/**
	 * �ж�apk�����Ƿ���ڵķ���
	 */
	@RequestMapping("apkNameExist")
	@ResponseBody
	public Object apkNameExist(String APKName) {
		return appInfoService.exist(APKName);
	}
	/**
	 * ���app��Ϣ�ķ���
	 */
	@RequestMapping("addAppInfo")
	@ResponseBody
	public Object addAppInfo(HttpSession session,String softwareName,String APKName,String supportROM,String interfaceLanguage,BigDecimal softwareSize,Integer downloads,Integer flatformId,Integer categoryLevel1,Integer categoryLevel2,Integer categoryLevel3,Integer status,String appInfo,MultipartFile a_logoPicPath, Model model) throws IllegalStateException, IOException {
		//�ļ���
		String fileName = a_logoPicPath.getOriginalFilename();
		//��׺
		String prefix = FilenameUtils.getExtension(fileName);
		DevUser devUser =(DevUser) session.getAttribute("devUserSession");
		String newFileName = APKName +"."+prefix;
		String logoLocPath =Tool.FILE_LOCAL+newFileName;
		String logoPicPath = Tool.LOCAL +"/statics/uploadfiles/"+newFileName;
		if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") ||prefix.equalsIgnoreCase("jepg") || prefix.equalsIgnoreCase("pneg")) {
			File targetFile = new File(logoLocPath);
			a_logoPicPath.transferTo(targetFile);
		}else
			return "<script>alert('��ѡ��ͼƬ');history.back();</script>";
		AppInfo app = new AppInfo(null, softwareName, APKName, supportROM, interfaceLanguage, new Date(), softwareSize, devUser.getId(), appInfo, status, new Date(), new Date(), categoryLevel3, downloads, flatformId, devUser.getId(), new Date(), devUser.getId(), new Date(), null, null, null, null, categoryLevel1, categoryLevel2, null, null, logoPicPath, logoLocPath, null, null);
		if(appInfoService.addAppInfo(app)) {
			Map map = (Map) session.getAttribute("map");
			Page page = (Page) map.get("page");
			page.setRecords(page.getRecords()+1);
			return "<script>alert('�ϴ��ɹ�');location='"+Tool.LOCAL+"dev/app/refresh.do';</script>";
		}
		return "<script>alert('�ϴ�ʧ��');history.back();</script>";
	}
	/**
	 * ��ʾapp��Ϣ�ķ���
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
	 * ɾ��app��Ϣ�ķ���
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
	 * ת���޸�app��Ϣҳ��ķ���
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
	 * �޸�app��Ϣ�ķ���
	 */
	@RequestMapping("modifyAppInfo")
	@ResponseBody
	public String modifyAppInfo(AppInfo appInfo,MultipartFile attach,HttpSession session) {
		DevUser devUser =(DevUser) session.getAttribute("devUserSession");
		//�ļ���
		String fileName = attach.getOriginalFilename();
		if(fileName!=""&&fileName!=null) {
			//��׺
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
					System.out.println("�ļ��ϴ�ʧ��");
					e.printStackTrace();
				}
			}else
				return "<script>alert('��ѡ��ͼƬ');history.back();</script>";
		}
		appInfo.setModifyBy(devUser.getId());
		if(appInfoService.modifyAppInfo(appInfo))
			return "<script>alert('app��Ϣ�޸ĳɹ�');location='"+Tool.LOCAL+"dev/app/refresh.do';</script>";
			return "<script>alert('app��Ϣ�޸�ʧ��');history.back();</script>"; 
	}
	/**
	 * ����app״̬�ķ���
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
