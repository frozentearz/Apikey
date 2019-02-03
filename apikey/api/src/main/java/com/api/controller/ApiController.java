package com.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.common.model.pojo.APIKey;
import com.api.result.common.CommonResult;
import com.api.rpc.IAPIKeyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@Controller
@RequestMapping ( "/v1" )
@Api(value = "API 接口", tags = "API 接口")
public class ApiController {
	
    @Autowired
    private IAPIKeyService apikeyService;
    
    private final static Logger log = Logger.getLogger(ApiController.class);

    /**
     * @Title: getAPIKeyByUser
     * @Description: TODO(根据 name，password 查询所有 APIs)
     * @type：公开接口
     * @param: name
     * @param: password
     * @return: CommonResult<List<Map<String, Object>>>
     * @throws
     */
    @ApiOperation(value = "根据 name, password 查询所有 APIKeys", notes = "根据用户名和密码查询用户所拥有的全部 APIKeys")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "name", value = "name", required = true, dataType = "String"),
    	@ApiImplicitParam(name = "password", value = "password", required = true, dataType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/getAPIKeyByUser", method = { RequestMethod.GET, RequestMethod.POST })
    public CommonResult<List<Map<String, Object>>> getAPIKeyByUser(@RequestParam String name, @RequestParam String password) {
    	log.info("公共接口：" + this.getClass().getName() + "根据 " + name + " 查询全部数据......");
    	CommonResult<List<Map<String, Object>>> cr = new CommonResult<>();
    	
    	APIKey apikey = new APIKey();
    	apikey.setName(name);
    	apikey.setPassword(password);
    	
    	List<APIKey> apiKeys = apikeyService.selectByUser(apikey);
    	
    	List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Map<String, Object> resultObject = new HashMap<String, Object>();
        
    	for (APIKey api : apiKeys) {
    		if (api.getDeleted() == 0) {
        		resultObject.put("id", api.getId());
            	resultObject.put("name", api.getName());
            	resultObject.put("type", api.getType());
            	resultObject.put("key", api.getKey());
            	resultObject.put("createTime", api.getCreateTime());
            	resultObject.put("status", api.getStatus());
            	result.add(resultObject);
        	}
    	}
        if (apiKeys != null) {
        	cr.setCode(CommonResult.SUCCESS_CODE);
        	cr.setMsg("查询成功");
        	cr.setEntiy(result);
        } else {
        	cr.setCode(CommonResult.NULLDATA_CODE);
        	cr.setMsg("空数据");
        	cr.setEntiy(result);
        }
        return cr;
    }
    /**
     * @Title: getAPIKey
     * @Description: TODO(根据 name，password，type 查询指定 APIKey)
     * @type：公开接口
     * @param: name
     * @param: password
     * @param: type
     * @return: CommonResult<Map<String, Object>>
     * @throws
     */
    @ApiOperation(value = "根据 name，password，type 查询指定 APIKey", notes = "【推荐接口】 通过 name，password，type 获取唯一指定APIKey")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "name", value = "name", required = true, dataType = "String"),
        @ApiImplicitParam(name = "password", value = "password", required = true, dataType = "String"),
        @ApiImplicitParam(name = "type", value = "type", required = true, dataType = "String")
    })
    
    @ResponseBody
    @RequestMapping(value = "/getAPI", method = { RequestMethod.GET, RequestMethod.POST })
    public CommonResult<Map<String, Object>> getAPI(@RequestParam String name, @RequestParam String password, @RequestParam String type) {
    	log.info("公共接口：" + this.getClass().getName() + "根据 " + name + " 的 " + type + " 查询APIKey......");
    	
    	APIKey apiKey = apiService.selectByVerify(name, password, type);
    	
    	CommonResult<Map<String, Object>> cr = new CommonResult<>();
    	List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
    	Map<String, Object> resultObject = new HashMap<String, Object>();
    	
    	for (APIKey api : apiKeys) {
    		if (api.getDeleted() == 0) {
    			resultObject.put("id", api.getId());
    			resultObject.put("name", api.getName());
    			resultObject.put("type", api.getType());
    			resultObject.put("key", api.getKey());
    			resultObject.put("createTime", api.getCreateTime());
    			resultObject.put("status", api.getStatus());
    			result.add(resultObject);
    		}
    	}
    	if (apiKeys != null) {
    		cr.setCode(CommonResult.SUCCESS_CODE);
    		cr.setMsg("查询成功");
    		cr.setEntiy(result);
    	} else {
    		cr.setCode(CommonResult.NULLDATA_CODE);
    		cr.setMsg("空数据");
    		cr.setEntiy(result);
    	}
    	return cr;
    }
}
