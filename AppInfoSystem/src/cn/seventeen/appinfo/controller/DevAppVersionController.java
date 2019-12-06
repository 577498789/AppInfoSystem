package cn.seventeen.appinfo.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
import cn.seventeen.appinfo.entity.AppVersion;
import cn.seventeen.appinfo.entity.DevUser;
import cn.seventeen.appinfo.service.AppCategoryService;
import cn.seventeen.appinfo.service.AppInfoService;
import cn.seventeen.appinfo.service.AppVersionService;
import cn.seventeen.appinfo.service.DataDictionaryService;
import cn.seventeen.appinfo.service.DevUserService;
import cn.seventeen.appinfo.utility.Tool;
@Controller
@RequestMapping("dev/app/version")
public class DevAppVersionController {

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
	
	
	/**
	 * 转到添加版本页面
	 */
	@RequestMapping("goAddAppVersion")
	public String goAddAppVersion(Integer id,Model model) {
		List<AppVersion> appVersionList = appVersionService.findAppVersionsByAppId(id);
		model.addAttribute("appId",id);
		model.addAttribute("appVersionList", appVersionList);
		return"developer/appversionadd";
	}
	/**
	 * 添加版本信息的方法
	 */
	@RequestMapping("addAppversion")
	@ResponseBody
	public String addAppversion(HttpServletRequest req,HttpSession session,Integer appId,String versionNo,BigDecimal versionSize,Integer publishStatus,String versionInfo,MultipartFile a_downloadLink){
		DevUser devUser =(DevUser) session.getAttribute("devUserSession");
		String APKName = ((AppInfo)appInfoService.findAppInfoById(appId)).getAPKName();
		//文件名
		String fileName = a_downloadLink.getOriginalFilename();
		//后缀
		String prefix = FilenameUtils.getExtension(fileName);
		String newFileName = APKName +"."+prefix;
		String apkLocPath = Tool.FILE_LOCAL+newFileName;
		String downloadLink = Tool.LOCAL +"/statics/uploadfiles/"+newFileName;
		if(prefix.equalsIgnoreCase("apk")) {
			File targetFile = new File(apkLocPath);
			try {
				a_downloadLink.transferTo(targetFile);
			} catch (IllegalStateException | IOException e) {
				System.out.println("添加版本时，图片保存失败");
				e.printStackTrace();
			}
		}else
			return "<script>alert('文件格式不正确');history.back();</script>";
		AppVersion version = new AppVersion(null, appId, versionNo, versionInfo, publishStatus, downloadLink, versionSize, devUser.getId(), new Date(), devUser.getId(), new Date(), apkLocPath, null, null, newFileName);
		if(appVersionService.addAppVersion(version)){ 
			AppInfo app = new AppInfo();
			app.setVersionId(version.getId());
			app.setId(appId);
			app.setModifyBy(devUser.getId());
			appInfoService.modifyAppInfo(app);
			return "<script>alert('app版本添加成功');location='"+Tool.LOCAL+"dev/app/refresh.do';</script>";
		}else
			return "<script>alert('app版本添加失败');history.back();</script>"; 
	}
	/**
	 * 转到修改版本信息页面的方法
	 */
	@RequestMapping("goModifyAppVersion")
	public String goModifyAppVersion(Model model,Integer appId,Integer versionId) {
		List<AppVersion> appVersionList = appVersionService.findAppVersionsByAppId(appId);
		AppVersion appVersion = appVersionService.findAppVersionsById(versionId);
		model.addAttribute("appVersionList",appVersionList);
		model.addAttribute("appVersion",appVersion);
		return"developer/appversionmodify";
	}
	/**
	 * 修改版本信息的方法
	 */
	@RequestMapping("modifyAppVersion")
	public String modifyAppVersion(HttpServletRequest req,AppVersion appVersion,String APKName,MultipartFile attach) {
		String fileName = attach.getName();
		if(fileName!=""&&fileName!="") {
			//后缀
			String prefix = FilenameUtils.getExtension(fileName);
			String newFileName = APKName +"-"+appVersion.getVersionNo()+"."+prefix;
			String apkLocPath = Tool.FILE_LOCAL+newFileName;
			if(prefix.equalsIgnoreCase("apk")) {
				 File targetFile = new File(apkLocPath);
				try {
					attach.transferTo(targetFile);
					appVersion.setApkFileName(newFileName);
					appVersion.setApkLocPath(apkLocPath);
				} catch (IllegalStateException | IOException e) {
					System.out.println("修改版本时，文件上传失败");
					e.printStackTrace();
				}
			}else
				return "<script>alert('请选择apk');history.back();</script>";
		}
		if(appVersionService.modifyAppVersion(appVersion))
			return"<script>alert('版本修改成功');location='"+Tool.LOCAL+"dev/app/refresh.do';</script>";
		return"<script>alert('版本修改失败');history.back();</script>";
	}

}
