package com.eking.mapper;

import com.eking.model.CommonLanguage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


//@MapperScan
@Mapper
public interface CommonLanguageMapper {

    public List<CommonLanguage> queryByCh(CommonLanguage commonLanguage);

    public void createDic(CommonLanguage commonLanguage);

    public List<CommonLanguage> queryForList(int num);

    public List<CommonLanguage> queryForSort(int num);

    public void updateDic(CommonLanguage commonLanguage);

}
