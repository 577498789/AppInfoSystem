package cn.seventeen.appinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.seventeen.appinfo.entity.AppCategory;
import cn.seventeen.appinfo.mapper.AppCategoryMapper;
import cn.seventeen.appinfo.service.AppCategoryService;
@Service
public class AppCategoryServiceImpl implements AppCategoryService {

	@Resource
	AppCategoryMapper mapper;
	
	@Override
	public List<AppCategory> findAppCategorysByParentId(Integer parentId) {
		return mapper.findAppCategorysByParentId(parentId);
	}

}
