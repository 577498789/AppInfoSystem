package cn.seventeen.appinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.seventeen.appinfo.entity.AppCategory;

public interface AppCategoryMapper {
	//ͨ����id��ѯ
	List<AppCategory> findAppCategorysByParentId(@Param("parentId")Integer parentId);
}
