package cn.seventeen.appinfo.mapper;

import org.apache.ibatis.annotations.Param;

import cn.seventeen.appinfo.entity.DevUser;

public interface DevUserMapper {
	DevUser findDevUserByDevCodeAndDevPassword(@Param("devCode")String devCode,@Param("devPassword")String devPassword);
}
