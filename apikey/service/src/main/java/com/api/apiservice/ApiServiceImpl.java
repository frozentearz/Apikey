package com.api.apiservice;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.common.model.pojo.ApiKey;
import com.api.dao.ApiDao;
import com.api.rpc.IApiService;

/**
 * @description:
 * @author: XFW
 * @version:
 * @create: 2019-01-31 13:38
 **/
@Service
public class ApiServiceImpl implements IApiService {

    @Autowired
    private ApiDao apiDao;

    public List<ApiKey> selectList() {
        List<ApiKey> apikeys = new ArrayList<ApiKey>();
        try {
            apikeys = apiDao.selectList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apikeys;
    }
    
    public ApiKey selectById(String Id) {
        ApiKey api = new ApiKey();
        try {
            api = apiDao.selectById(Id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return api;
    }
    
    public List<ApiKey> selectListByName(String name) {
        List<ApiKey> apikeys = new ArrayList<ApiKey>();
        try {
            apikeys = apiDao.selectListByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apikeys;
    }
    
    public ApiKey selectListByVerify(String name, String password, String type) {
        ApiKey api = new ApiKey();
        try {
            api = apiDao.selectListByVerify(name, password, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return api;
    }
}
