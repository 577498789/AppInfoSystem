package cn.seventeen.appinfo.mapper;

import org.apache.ibatis.annotations.Param;

import cn.seventeen.appinfo.entity.BackendUser;

public interface BackendUserMapper {
	//ͨ���û��������ѯ�û�
	BackendUser findBackendUserByUserCodeAndUserPassword(@Param("userCode")String userCode,@Param("userPassword")String userPassword); 
}
