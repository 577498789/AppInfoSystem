package cn.seventeen.appinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.seventeen.appinfo.entity.AppVersion;

public interface AppVersionMapper {
	//查询指定app的所有版本
	List<AppVersion> findAppVersionsByAppId(Integer appId);
	//查询指定id的版本
	AppVersion findAppVersionsById(Integer id);
	//新增app版本
	Integer addAppVersion(AppVersion appVersion);
	//修改app版本信息
	Integer modifyAppVersion(AppVersion appVersion);
	//删除指定app的所有版本信息
	Integer deleteAppVersionsByAppId(Integer appId);
}
