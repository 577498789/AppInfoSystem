package cn.seventeen.appinfo.service;

import java.util.List;

import cn.seventeen.appinfo.entity.DataDictionary;

public interface DataDictionaryService {
	//ͨ���������Ʋ�ѯ
	List<DataDictionary> findDataDictionaryByTypeCode(String typeCode);
}
