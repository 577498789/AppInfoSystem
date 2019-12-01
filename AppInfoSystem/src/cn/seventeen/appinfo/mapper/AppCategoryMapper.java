package cn.seventeen.appinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.seventeen.appinfo.entity.AppCategory;

public interface AppCategoryMapper {
	//Í¨¹ý¸¸id²éÑ¯
	List<AppCategory> findAppCategorysByParentId(@Param("parentId")Integer parentId);
}
