package cn.seventeen.appinfo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.seventeen.appinfo.service.AppCategoryService;

@Controller
@RequestMapping("/app/category")
public class AppCategoryController {
	@Resource
	private AppCategoryService appCategoryService;
	/**
	 * 查询指定父级分类的分类列表
	 */
	@RequestMapping("/categorylevellist")
	@ResponseBody
	public Object categorylevellist(Integer pid) {
		return appCategoryService.findAppCategorysByParentId(pid);
	}
}
