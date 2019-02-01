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

import com.api.common.model.pojo.ApiKey;
import com.api.result.common.CommonResult;
import com.api.rpc.IApiService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


@Controller
public class ApiController {
	
    @Autowired
    private IApiService apiService;
    
    private final static Logger log = Logger.getLogger(ApiController.class);
    
    /**
     * @Title: getApis
     * @Description: (查询所有 api)
     * @type：公开接口
     * @param: name
     * @return: ResponseEntity<String>
     * @throws
     */
    @SuppressWarnings({ "unused" })
	@ApiOperation(value = "获得所有的  API 对象的 list", notes = "GET、POST 请求，查询所有的 API")
    @ResponseBody
    @RequestMapping(value = "/all", method = { RequestMethod.GET, RequestMethod.POST })
    public CommonResult<List<Map<String, Object>>> getApis() {
    	
        log.info("公开接口：" + this.getClass().getName() + ", 查询全部数据......");
        
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Map<String, Object> resultObject = new HashMap<String, Object>();
        CommonResult<List<Map<String, Object>>> cr = new CommonResult<>();
        
        List<ApiKey> apiKeys = apiService.selectList();
        for (ApiKey api : apiKeys) {
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
        if (result != null) {
        	cr.setCode(CommonResult.SUCCESS_CODE);
        	cr.setMsg("查询成功");
        	cr.setEntiy(result);
        } else {
        	cr.setCode(CommonResult.NULLDATA_CODE);
        	cr.setMsg("查询失败，空数据");
        	cr.setEntiy(result);
        }
        return cr;
    }

    /**
     * @Title: getApisWithRoot
     * @Description: TODO(查询所有 api)
     * @type：非公开接口
     * @param: name
     * @return: ResponseEntity<String>
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/allwithroot", method = { RequestMethod.GET, RequestMethod.POST })
    public CommonResult<List<ApiKey>> getApisWithRoot() {
    	
        log.info("私有接口：" + this.getClass().getName() + ", 查询全部数据......");
        
        List<ApiKey> apiKeys = apiService.selectList();
        
        CommonResult<List<ApiKey>> cr = new CommonResult<>();
        if (apiKeys != null) {
        	cr.setCode(CommonResult.SUCCESS_CODE);
        	cr.setMsg("查询成功");
        	cr.setEntiy(apiKeys);
        } else {
        	cr.setCode(CommonResult.NULLDATA_CODE);
        	cr.setMsg("空数据");
        	cr.setEntiy(apiKeys);
        }
        return cr;
    }
    
    /**
     * @Title: getApiByName
     * @Description: TODO(根据 name 查询所有 api)
     * @type：公开接口
     * @param: name
     * @return: ResponseEntity<String>
     * @throws
     */
    @ApiOperation(value = "根据 name 查询所有 api", notes = "根据用户名查询用户所有的 api")
    @ApiImplicitParam(name = "name", value = "name", required = true, dataType = "String")
    @ResponseBody
    @RequestMapping(value = "/getApiByName", method = { RequestMethod.GET, RequestMethod.POST })
    public CommonResult<List<ApiKey>> getApiByName(@RequestParam String name) {
    	log.info("私有接口：" + this.getClass().getName() + "根据 " + name + "查询全部数据......");
    	
    	List<ApiKey> apiKeys = apiService.selectListByName(name);
    	CommonResult<List<ApiKey>> cr = new CommonResult<>();
    	
        if (apiKeys != null) {
        	cr.setCode(CommonResult.SUCCESS_CODE);
        	cr.setMsg("查询成功");
        	cr.setEntiy(apiKeys);
        } else {
        	cr.setCode(CommonResult.NULLDATA_CODE);
        	cr.setMsg("空数据");
        	cr.setEntiy(apiKeys);
        }
        return cr;
    }
}
