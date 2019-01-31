package com.api.rpc;

import com.api.common.model.pojo.ApiKey;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: XFW
 * @version:
 * @create: 2019-01-31 13:40
 **/
@Service
public interface IApiService {

    /**
     * @Title: selectList   
     * @Description: TODO(查询所有信息) 非管理员勿用
     * @param:       
     * @return: List<ApiKey>      
     * @throws   
     */
    List<ApiKey> selectList();

    /**
     * @Title: selectListById
     * @Description: TODO(根据ID查询所有)
     * @param:  Id
     * @return: ApiKey
     * @throws   
     */
    ApiKey selectById(String Id);

    /**
     * @Title: selectListByName
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param: @param name
     * @param: @return
     * @return: List<ApiKey>
     * @throws
     */
    List<ApiKey> selectListByName(String name);

    ApiKey selectListByVerify(String name, String password, String type);
}
