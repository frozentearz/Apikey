package com.api.apiservice;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.common.model.pojo.APIKey;
import com.api.dao.APIKeyDAO;
import com.api.rpc.IAPIKeyService;

/**
 * @description:
 * @author: Frazier
 * @version:
 * @create: 2019-01-31 13:38
 **/
@Service
public class APIKeyServiceImpl implements IAPIKeyService {

    @Autowired
    private APIKeyDAO apikeyDAO;

	public List<APIKey> selectListWithRoot() {
		List<APIKey> apikeys = new ArrayList<APIKey>();
        try {
            apikeys = apikeyDAO.selectListWithRoot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apikeys;
	}

	public APIKey selectByIdWithRoot(String id) {
		APIKey apikey = new APIKey();
        try {
            apikey = apikeyDAO.selectByIdWithRoot(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apikey;
	}

	public List<APIKey> selectByNameWithRoot(String name) {
		List<APIKey> apikeys = new ArrayList<APIKey>();
        try {
            apikeys = apikeyDAO.selectByNameWithRoot(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apikeys;
	}

	public List<APIKey> selectByTypeWithRoot(String type) {
		List<APIKey> apikeys = new ArrayList<APIKey>();
        try {
            apikeys = apikeyDAO.selectByTypeWithRoot(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apikeys;
	}

	public List<APIKey> selectByTypeAndTagWithRoot(APIKey apikey) {
		List<APIKey> apikeys = new ArrayList<APIKey>();
        try {
            apikeys = apikeyDAO.selectByTypeAndTagWithRoot(apikey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apikeys;
	}

	public List<APIKey> selectByUser(APIKey apikey) {
		List<APIKey> apikeys = new ArrayList<APIKey>();
        try {
            apikeys = apikeyDAO.selectByUser(apikey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apikeys;
	}

	public List<APIKey> selectByType(APIKey apikey) {
		List<APIKey> apikeys = new ArrayList<APIKey>();
        try {
            apikeys = apikeyDAO.selectByType(apikey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apikeys;
	}

	public APIKey selectByTag(APIKey apikey) {
        try {
            apikey = apikeyDAO.selectByTag(apikey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apikey;
	}

	public Integer insertByAPIKey(APIKey apikey) {
    	return apikeyDAO.insertByAPIKey(apikey);
	}

	public Integer updateById(APIKey apikey) {
		return apikeyDAO.updateById(apikey);
	}

}
