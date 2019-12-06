package cn.seventeen.appinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.seventeen.appinfo.entity.AppVersion;

public interface AppVersionMapper {
	//��ѯָ��app�����а汾
	List<AppVersion> findAppVersionsByAppId(Integer appId);
	//��ѯָ��id�İ汾
	AppVersion findAppVersionsById(Integer id);
	//����app�汾
	Integer addAppVersion(AppVersion appVersion);
	//�޸�app�汾��Ϣ
	Integer modifyAppVersion(AppVersion appVersion);
	//ɾ��ָ��app�����а汾��Ϣ
	Integer deleteAppVersionsByAppId(Integer appId);
}
