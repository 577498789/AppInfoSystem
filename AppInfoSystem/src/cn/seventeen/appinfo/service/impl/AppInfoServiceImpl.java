package cn.seventeen.appinfo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.seventeen.appinfo.entity.AppInfo;
import cn.seventeen.appinfo.entity.Page;
import cn.seventeen.appinfo.mapper.AppInfoMapper;
import cn.seventeen.appinfo.service.AppInfoService;

@Service
public class AppInfoServiceImpl implements AppInfoService {

	@Resource
	private AppInfoMapper mapper;
	
	@Override
	public List<AppInfo> findAppInfos(Map map) {
		Page page = (Page)map.get("page");
		if(page.getRecords()==null) {
			initialPage(page,map);
		}
		List<AppInfo> list = mapper.findAppInfos(map);
		return list;
	}

	@Override
	public void initialPage(Page page,Map map) {
		page.setRecords(mapper.getRecords(map));
	}

	@Override
	public boolean addAppInfo(AppInfo appInfo) {
		return mapper.addAppInfo(appInfo)>0;
	}

}
