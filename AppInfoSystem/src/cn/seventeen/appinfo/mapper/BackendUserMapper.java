package cn.seventeen.appinfo.mapper;

import org.apache.ibatis.annotations.Param;

import cn.seventeen.appinfo.entity.BackendUser;

public interface BackendUserMapper {
	//通过用户名密码查询用户
	BackendUser findBackendUserByUserCodeAndUserPassword(@Param("userCode")String userCode,@Param("userPassword")String userPassword); 
}
