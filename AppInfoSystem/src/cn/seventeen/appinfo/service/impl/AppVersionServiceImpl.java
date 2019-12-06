package cn.seventeen.appinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.seventeen.appinfo.entity.AppVersion;
import cn.seventeen.appinfo.mapper.AppVersionMapper;
import cn.seventeen.appinfo.service.AppVersionService;

@Service
public class AppVersionServiceImpl implements AppVersionService {
	
	@Resource
	private AppVersionMapper mapper;
	
	@Override
	public List<AppVersion> findAppVersionsByAppId(Integer appId) {
		return mapper.findAppVersionsByAppId(appId);
	}

	@Override
	public boolean addAppVersion(AppVersion appVersion) {
		return mapper.addAppVersion(appVersion)>0;
	}

	@Override
	public boolean modifyAppVersion(AppVersion appVersion) {
		return mapper.modifyAppVersion(appVersion)>0;
	}

	@Override
	public boolean deleteAppVersionsByAppId(Integer appId) {
		return mapper.deleteAppVersionsByAppId(appId)>0;
	}

	@Override
	public AppVersion findAppVersionsById(Integer id) {
		return mapper.findAppVersionsById(id);
	}
	
}
