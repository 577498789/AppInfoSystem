package cn.seventeen.appinfo.service;

import java.util.List;

import cn.seventeen.appinfo.entity.DataDictionary;

public interface DataDictionaryService {
	//通过类型名称查询
	List<DataDictionary> findDataDictionaryByTypeCode(String typeCode);
}
