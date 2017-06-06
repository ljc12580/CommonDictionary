package com.eking.service;

import com.eking.mapper.CommonLanguageMapper;
import com.eking.model.CommonLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommonLanguageService {

    @Autowired
    private CommonLanguageMapper commonLanguageMapper;

    public List<CommonLanguage> queryByCh(CommonLanguage commonLanguage){
        return commonLanguageMapper.queryByCh(commonLanguage);
    }

    public void createDic(CommonLanguage commonLanguage){
            commonLanguageMapper.createDic(commonLanguage);
    }
    public List<CommonLanguage> queryForList(int num){
        return commonLanguageMapper.queryForList(num);
    }
    public List<CommonLanguage> queryForSort(int num){
        return commonLanguageMapper.queryForSort(num);
    }

    public void updateDic(CommonLanguage commonLanguage){
        commonLanguageMapper.updateDic(commonLanguage);
    };

}
