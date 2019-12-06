package cn.seventeen.appinfo.service;

import java.util.List;

import cn.seventeen.appinfo.entity.AppVersion;

public interface AppVersionService {
	//查询指定app的所有版本
	List<AppVersion> findAppVersionsByAppId(Integer appId);
	//查询指定id的版本
	AppVersion findAppVersionsById(Integer id);
	//新增app版本
	boolean addAppVersion(AppVersion appVersion);
	//修改app版本信息
	boolean modifyAppVersion(AppVersion appVersion);
	//删除指定app的所有版本信息
	boolean deleteAppVersionsByAppId(Integer appId);
	
}
