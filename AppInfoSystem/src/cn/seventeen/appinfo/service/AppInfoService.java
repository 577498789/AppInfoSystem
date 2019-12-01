package cn.seventeen.appinfo.service;

import java.util.List;
import java.util.Map;

import cn.seventeen.appinfo.entity.AppInfo;
import cn.seventeen.appinfo.entity.Page;

public interface AppInfoService {
	// 分页查询app应用信息
	List<AppInfo> findAppInfos(Map map);

	// 初始化page
	void initialPage(Page page, Map map);

	// 添加app
	boolean addAppInfo(AppInfo appInfo);

}
