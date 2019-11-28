package cn.seventeen.appinfo.service;

import cn.seventeen.appinfo.entity.BackendUser;

public interface BackendUserService {
	//通过用户名密码查询用户
	BackendUser findBackendUserByUserCodeAndUserPassword(String userCode,String userPassword); 
}
