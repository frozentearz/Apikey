package com.api.rpc;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.common.model.pojo.APIKey;

@Service
public interface IAPIKeyService {
	
	// 管理员接口
    /**
     * @Title: selectList
     * @Description: TODO(查询所有 APIKey)
     * @param: 
     * @return: List<APIKey>
     * @throws
     */
    List<APIKey> selectListWithRoot();

    /**
     * @Title: selectById
     * @Description: TODO(根据 Id 查询 APIKey)
     * @param: Id
     * @return: APIKey
     * @throws
     */
    APIKey selectByIdWithRoot(String id);

    /**
     * @Title: selectByName
     * @Description: TODO(根据 name 查询 APIKey)
     * @param: name
     * @return: List<APIKey>
     * @throws
     */
    List<APIKey> selectByNameWithRoot(String name);
    
    /**
     * @Title: selectByType
     * @Description: TODO(根据 type 查询 APIKey)
     * @param: type
     * @return: List<APIKey>
     * @throws
     */
    List<APIKey> selectByTypeWithRoot(String type);
    
    /**
     * @Title: selectByTypeAndTagWithRoot
     * @Description: TODO(根据 type, tag 查询 APIKey)
     * @param: apikey
     * @return: List<APIKey>
     * @throws
     */
    List<APIKey> selectByTypeAndTagWithRoot(APIKey apikey);
    
    // 用户接口
    /**
     * @Title: selectByUser
     * @Description: TODO(根据 name，password 查询 APIKey)
     * @param: apikey
     * @return: List<APIKey>
     * @throws
     */
    List<APIKey> selectByUser(APIKey apikey);

    /**
     * @Title: selectByType
     * @Description: TODO(根据 name，password，type 查询 APIKey)
     * @param: apikey
     * @return: List<APIKey>
     * @throws
     */
    List<APIKey> selectByType(APIKey apikey);
    
    /**
     * @Title: selectByTag
     * @Description: TODO(根据 name，password，type，tag 查询 APIKey)
     * @param: apikey
     * @param: @return  
     * @return: APIKey
     * @throws
     */
    APIKey selectByTag(APIKey apikey);
    
    /**
     * @Title: insertByAPIKey
     * @Description: TODO(插入一个 APIKey)
     * @param: apikey  
     * @return: Integer
     * @throws
     */
    Integer insertByAPIKey(APIKey apikey);
    
    /**
     * @Title: updateById
     * @Description: TODO(根据id更新APIKey)
     * @param: apikey  
     * @return: Integer
     * @throws
     */
    Integer updateById(APIKey apikey);
}
