package cn.seventeen.appinfo.service;

import java.util.List;
import java.util.Map;

import cn.seventeen.appinfo.entity.AppInfo;
import cn.seventeen.appinfo.entity.Page;

public interface AppInfoService {
	// ��ҳ��ѯappӦ����Ϣ
	List<AppInfo> findAppInfos(Map map);

	// ��ʼ��page
	void initialPage(Page page, Map map);

	// ���app
	boolean addAppInfo(AppInfo appInfo);

}
