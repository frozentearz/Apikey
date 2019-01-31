package com.api.dao;

import com.api.common.model.pojo.ApiKey;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: XFW
 * @version:
 * @create: 2019-01-31 15:53
 **/
@Repository
public interface ApiDao {

    List<ApiKey> selectList();

    ApiKey selectListById(String Id);

    List<ApiKey> selectListByName(String name);

    ApiKey selectListByVerify(String name, String password, String type);
}
