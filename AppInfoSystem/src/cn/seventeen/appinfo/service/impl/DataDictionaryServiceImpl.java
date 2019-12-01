package cn.seventeen.appinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.seventeen.appinfo.entity.DataDictionary;
import cn.seventeen.appinfo.mapper.DataDictionaryMapper;
import cn.seventeen.appinfo.service.DataDictionaryService;
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

	@Resource
	private DataDictionaryMapper mapper;
	
	@Override
	public List<DataDictionary> findDataDictionaryByTypeCode(String typeCode) {
		return mapper.findDataDictionaryByTypeCode(typeCode);
	}

}
