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
	 * ת����Ӱ汾ҳ��
	 */
	@RequestMapping("goAddAppVersion")
	public String goAddAppVersion(Integer id,Model model) {
		List<AppVersion> appVersionList = appVersionService.findAppVersionsByAppId(id);
		model.addAttribute("appId",id);
		model.addAttribute("appVersionList", appVersionList);
		return"developer/appversionadd";
	}
	/**
	 * ��Ӱ汾��Ϣ�ķ���
	 */
	@RequestMapping("addAppversion")
	@ResponseBody
	public String addAppversion(HttpServletRequest req,HttpSession session,Integer appId,String versionNo,BigDecimal versionSize,Integer publishStatus,String versionInfo,MultipartFile a_downloadLink){
		DevUser devUser =(DevUser) session.getAttribute("devUserSession");
		String APKName = ((AppInfo)appInfoService.findAppInfoById(appId)).getAPKName();
		//�ļ���
		String fileName = a_downloadLink.getOriginalFilename();
		//��׺
		String prefix = FilenameUtils.getExtension(fileName);
		String newFileName = APKName +"."+prefix;
		String apkLocPath = Tool.FILE_LOCAL+newFileName;
		String downloadLink = Tool.LOCAL +"/statics/uploadfiles/"+newFileName;
		if(prefix.equalsIgnoreCase("apk")) {
			File targetFile = new File(apkLocPath);
			try {
				a_downloadLink.transferTo(targetFile);
			} catch (IllegalStateException | IOException e) {
				System.out.println("��Ӱ汾ʱ��ͼƬ����ʧ��");
				e.printStackTrace();
			}
		}else
			return "<script>alert('�ļ���ʽ����ȷ');history.back();</script>";
		AppVersion version = new AppVersion(null, appId, versionNo, versionInfo, publishStatus, downloadLink, versionSize, devUser.getId(), new Date(), devUser.getId(), new Date(), apkLocPath, null, null, newFileName);
		if(appVersionService.addAppVersion(version)){ 
			AppInfo app = new AppInfo();
			app.setVersionId(version.getId());
			app.setId(appId);
			app.setModifyBy(devUser.getId());
			appInfoService.modifyAppInfo(app);
			return "<script>alert('app�汾��ӳɹ�');location='"+Tool.LOCAL+"dev/app/refresh.do';</script>";
		}else
			return "<script>alert('app�汾���ʧ��');history.back();</script>"; 
	}
	/**
	 * ת���޸İ汾��Ϣҳ��ķ���
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
	 * �޸İ汾��Ϣ�ķ���
	 */
	@RequestMapping("modifyAppVersion")
	public String modifyAppVersion(HttpServletRequest req,AppVersion appVersion,String APKName,MultipartFile attach) {
		String fileName = attach.getName();
		if(fileName!=""&&fileName!="") {
			//��׺
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
					System.out.println("�޸İ汾ʱ���ļ��ϴ�ʧ��");
					e.printStackTrace();
				}
			}else
				return "<script>alert('��ѡ��apk');history.back();</script>";
		}
		if(appVersionService.modifyAppVersion(appVersion))
			return"<script>alert('�汾�޸ĳɹ�');location='"+Tool.LOCAL+"dev/app/refresh.do';</script>";
		return"<script>alert('�汾�޸�ʧ��');history.back();</script>";
	}

}
