package cn.seventeen.appinfo.mapper;

import java.util.List;

import cn.seventeen.appinfo.entity.DataDictionary;

public interface DataDictionaryMapper {
	//ͨ���������Ʋ�ѯ
	List<DataDictionary> findDataDictionaryByTypeCode(String typeCode);
}
