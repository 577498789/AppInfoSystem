package cn.seventeen.appinfo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.seventeen.appinfo.entity.BackendUser;
import cn.seventeen.appinfo.mapper.BackendUserMapper;
import cn.seventeen.appinfo.service.BackendUserService;
@Service
public class BackendUserServiceImpl implements BackendUserService{

	@Resource
	BackendUserMapper mapper;
	
	@Override
	public BackendUser findBackendUserByUserCodeAndUserPassword(String userCode, String userPassword) {
		return mapper.findBackendUserByUserCodeAndUserPassword(userCode, userPassword);
	}

}
