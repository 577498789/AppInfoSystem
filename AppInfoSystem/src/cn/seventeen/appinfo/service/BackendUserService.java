package cn.seventeen.appinfo.service;

import cn.seventeen.appinfo.entity.BackendUser;

public interface BackendUserService {
	//ͨ���û��������ѯ�û�
	BackendUser findBackendUserByUserCodeAndUserPassword(String userCode,String userPassword); 
}
