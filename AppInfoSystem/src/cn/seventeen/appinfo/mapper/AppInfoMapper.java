package cn.seventeen.appinfo.mapper;

import java.util.List;
import java.util.Map;

import cn.seventeen.appinfo.entity.AppInfo;

public interface AppInfoMapper {
	// ��ҳ��ѯappӦ����Ϣ
	List<AppInfo> findAppInfos(Map map);
	//���app
	Integer addAppInfo(AppInfo appInfo);
	//��ü�¼����
	Integer getRecords(Map map);
	//ͨ�����ֲ�ѯ����
	Integer getRecordsByAPKName(String APKName);
	//ͨ��id��ѯapp
	AppInfo findAppInfoById(Integer id);
	//ɾ��app
	Integer deleteAppInfo(Integer id);
	//�޸�app��Ϣ
	Integer modifyAppInfo(AppInfo appInfo);
	
}
