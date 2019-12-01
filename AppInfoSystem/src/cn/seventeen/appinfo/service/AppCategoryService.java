package cn.seventeen.appinfo.service;

import java.util.List;

import cn.seventeen.appinfo.entity.AppCategory;

public interface AppCategoryService {
	List<AppCategory> findAppCategorysByParentId(Integer parentId);
}
