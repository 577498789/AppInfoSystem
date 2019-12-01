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

	@Override
	public boolean exist(String APKName) {
		return mapper.getRecordsByAPKName(APKName)>0;
	}

	@Override
	public AppInfo findAppInfoById(Integer id) {
		return mapper.findAppInfoById(id);
	}

	@Override
	public boolean deleteAppInfo(Integer id) {
		return mapper.deleteAppInfo(id)>0;
	}

	@Override
	public boolean modifyAppInfo(AppInfo appInfo) {
		return mapper.modifyAppInfo(appInfo)>0;
	}

}
