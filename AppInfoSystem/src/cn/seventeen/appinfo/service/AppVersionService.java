package cn.seventeen.appinfo.service;

import java.util.List;

import cn.seventeen.appinfo.entity.AppVersion;

public interface AppVersionService {
	//��ѯָ��app�����а汾
	List<AppVersion> findAppVersionsByAppId(Integer appId);
	//��ѯָ��id�İ汾
	AppVersion findAppVersionsById(Integer id);
	//����app�汾
	boolean addAppVersion(AppVersion appVersion);
	//�޸�app�汾��Ϣ
	boolean modifyAppVersion(AppVersion appVersion);
	//ɾ��ָ��app�����а汾��Ϣ
	boolean deleteAppVersionsByAppId(Integer appId);
	
}
