package cn.seventeen.appinfo.service;

import cn.seventeen.appinfo.entity.DevUser;

public interface DevUserService {
	DevUser findDevUserByDevCodeAndDevPassword(String devCode,String devPassword);
}
