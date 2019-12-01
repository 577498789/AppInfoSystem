package cn.seventeen.appinfo.mapper;

import java.util.List;

import cn.seventeen.appinfo.entity.DataDictionary;

public interface DataDictionaryMapper {
	//通过类型名称查询
	List<DataDictionary> findDataDictionaryByTypeCode(String typeCode);
}
