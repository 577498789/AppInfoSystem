package cn.seventeen.appinfo.mapper;

import java.util.List;
import java.util.Map;

import cn.seventeen.appinfo.entity.AppInfo;

public interface AppInfoMapper {
	// 分页查询app应用信息
	List<AppInfo> findAppInfos(Map map);
	//添加app
	Integer addAppInfo(AppInfo appInfo);
	//获得记录数量
	Integer getRecords(Map map);
	//通过名字查询数量
	Integer getRecordsByAPKName(String APKName);
}
