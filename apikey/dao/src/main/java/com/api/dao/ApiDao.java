package com.api.dao;

import com.api.common.model.pojo.ApiKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiDao {

    List<ApiKey> selectList();

    ApiKey selectById(String Id);

    List<ApiKey> selectListByName(String name);

    ApiKey selectListByVerify(String name, String password, String type);

}
