package cn.seventeen.appinfo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.seventeen.appinfo.entity.DevUser;
import cn.seventeen.appinfo.mapper.DevUserMapper;
import cn.seventeen.appinfo.service.DevUserService;

@Service
public class DevUserServiceImpl implements DevUserService{
	
	@Resource
	private DevUserMapper mapper;
	
	@Override
	public DevUser findDevUserByDevCodeAndDevPassword(String devCode, String devPassword) {
		return mapper.findDevUserByDevCodeAndDevPassword(devCode, devPassword);
	}

}
