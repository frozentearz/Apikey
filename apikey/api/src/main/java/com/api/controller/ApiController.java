package com.api.controller;

import java.util.ArrayList;
import java.util.Date;
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
    	log.info("公共接口：" + this.getClass().getName() + "根据 name: " + name + " 查询全部数据......");
    	CommonResult<List<Map<String, Object>>> cr = new CommonResult<>();
    	
    	APIKey apikey = new APIKey();
    	apikey.setName(name);
    	apikey.setPassword(password);
    	
    	List<APIKey> apiKeys = apikeyService.selectByUser(apikey);
    	
    	if (apiKeys != null) {
	    	List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
	        Map<String, Object> resultObject = new HashMap<String, Object>();
	        
	    	for (APIKey api : apiKeys) {
	    		if (api.getDeleted() == 0) {
	        		resultObject.put("id", api.getId());
	            	resultObject.put("name", api.getName());
	            	resultObject.put("type", api.getType());
	            	resultObject.put("tag", api.getTag());
	            	resultObject.put("key", api.getKey());
	            	resultObject.put("createTime", api.getCreateTime());
	            	resultObject.put("status", api.getStatus());
	            	result.add(resultObject);
	        	}
	    	}
        	cr.setCode(CommonResult.SUCCESS_CODE);
        	cr.setMsg("查询成功");
        	cr.setEntiy(result);
        } else {
        	cr.setCode(CommonResult.NULLDATA_CODE);
        	cr.setMsg("空数据");
        	cr.setEntiy(null);
        }
        return cr;
    }
    
    /**
     * @Title: getAPIByType
     * @Description: TODO(根据 name，password，type 查询 APIKeys)
     * @type：公开接口
     * @param: name
     * @param: password
     * @param: type
     * @return: CommonResult<List<Map<String, Object>>>
     * @throws
     */
    @ApiOperation(value = "根据 name，password，type 查询指 APIKeys", notes = "通过 name，password，type 获取APIKey")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "name", value = "name", required = true, dataType = "String"),
        @ApiImplicitParam(name = "password", value = "password", required = true, dataType = "String"),
        @ApiImplicitParam(name = "type", value = "type", required = true, dataType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/getAPIByType", method = { RequestMethod.GET, RequestMethod.POST })
    public CommonResult<List<Map<String, Object>>> getAPIByType(@RequestParam String name, @RequestParam String password, @RequestParam String type) {
    	log.info("公共接口：" + this.getClass().getName() + "根据 name: " + name + " 的 type: " + type + " 查询APIKey......");
    	CommonResult<List<Map<String, Object>>> cr = new CommonResult<>();
    	
    	APIKey apikey = new APIKey();
    	apikey.setName(name);
    	apikey.setPassword(password);
    	apikey.setType(type);
    	List<APIKey> apikeys = apikeyService.selectByType(apikey);
    	
    	if (apikeys != null) {
	    	List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
	    	Map<String, Object> resultObject = new HashMap<String, Object>();
	    	
	    	for (APIKey api : apikeys) {
	    		if (api.getDeleted() == 0) {
	    			resultObject.put("id", api.getId());
	    			resultObject.put("name", api.getName());
	    			resultObject.put("type", api.getType());
	    			resultObject.put("tag", api.getTag());
	    			resultObject.put("key", api.getKey());
	    			resultObject.put("createTime", api.getCreateTime());
	    			resultObject.put("status", api.getStatus());
	    			result.add(resultObject);
	    		}
	    	}
    		cr.setCode(CommonResult.SUCCESS_CODE);
    		cr.setMsg("查询成功");
    		cr.setEntiy(result);
    	} else {
    		cr.setCode(CommonResult.NULLDATA_CODE);
    		cr.setMsg("空数据");
    		cr.setEntiy(null);
    	}
    	return cr;
    }
    
    /**
     * @Title: getAPIByTag
     * @Description: TODO(根据 name，password，type，tag 查询指定 APIKey)
     * @type：公开接口
     * @param: name
     * @param: password
     * @param: type
     * @param: tag
     * @return: CommonResult<Map<String, Object>>
     * @throws
     */
    @ApiOperation(value = "根据 name，password，type，tag 查询指定 APIKey", notes = "【推荐接口】 通过 name，password，type，tag 获取指定 APIKey")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "name", value = "name", required = true, dataType = "String"),
    	@ApiImplicitParam(name = "password", value = "password", required = true, dataType = "String"),
    	@ApiImplicitParam(name = "type", value = "type", required = true, dataType = "String"),
    	@ApiImplicitParam(name = "tag", value = "tag", required = true, dataType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/getAPIByTag", method = { RequestMethod.GET, RequestMethod.POST })
    public CommonResult<Map<String, Object>> getAPIByTag(
    		@RequestParam String name,
    		@RequestParam String password,
    		@RequestParam String type,
    		@RequestParam String tag) {
    	log.info("公共接口：" + this.getClass().getName() + "根据 name: " + name + " 的 type: " + type + " 和 tag: " + tag + " 查询指定 APIKey......");
    	CommonResult<Map<String, Object>> cr = new CommonResult<>();
    	
    	APIKey apikey = new APIKey();
    	apikey.setName(name);
    	apikey.setPassword(password);
    	apikey.setType(type);
    	apikey.setTag(tag);
    	APIKey resultAPIKey = apikeyService.selectByTag(apikey);
    	
    	if (resultAPIKey != null) {
    		Map<String, Object> resultObject = new HashMap<String, Object>();
    		
    		if (resultAPIKey.getDeleted() == 0) {
    			resultObject.put("id", resultAPIKey.getId());
    			resultObject.put("name", resultAPIKey.getName());
    			resultObject.put("type", resultAPIKey.getType());
    			resultObject.put("tag", resultAPIKey.getTag());
    			resultObject.put("key", resultAPIKey.getKey());
    			resultObject.put("createTime", resultAPIKey.getCreateTime());
    			resultObject.put("status", resultAPIKey.getStatus());
    		}
    		cr.setCode(CommonResult.SUCCESS_CODE);
    		cr.setMsg("查询成功");
    		cr.setEntiy(resultObject);
    	} else {
    		cr.setCode(CommonResult.NULLDATA_CODE);
    		cr.setMsg("空数据");
    		cr.setEntiy(null);
    	}
    	return cr;
    }
    
    /**
     * @Title: saveByAPIKey
     * @Description: TODO(根据 name，password，type，tag，key 保存一个 APIKey)
     * @type：公开接口
     * @param: name
     * @param: password
     * @param: type
     * @param: tag
     * @param: key
     * @return: CommonResult<String>
     * @throws
     */
    @ApiOperation(value = "根据 name，password，type，tag，key 保存 APIKey", notes = "【推荐接口】 通过 name，password，type，tag，key 保存一个 APIKey")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "name", value = "name", required = true, dataType = "String"),
    	@ApiImplicitParam(name = "password", value = "password", required = true, dataType = "String"),
    	@ApiImplicitParam(name = "type", value = "type", required = true, dataType = "String"),
    	@ApiImplicitParam(name = "tag", value = "tag", required = true, dataType = "String"),
    	@ApiImplicitParam(name = "key", value = "key", required = true, dataType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/saveByAPIKey", method = {RequestMethod.POST})
    public CommonResult<String> saveByAPIKey(
    		@RequestParam String name,
    		@RequestParam String password,
    		@RequestParam String type,
    		@RequestParam String tag,
    		@RequestParam String key) {
    	log.info("公共接口：" + this.getClass().getName() + "根据 name: " + name + " 的 type: " + type + " 和 tag:" + tag + " 保存 APIKey......");
    	CommonResult<String> cr = new CommonResult<>();
    	
    	APIKey apikey = new APIKey();
    	apikey.setName(name);
    	apikey.setPassword(password);
    	apikey.setType(type);
    	apikey.setTag(tag);
    	apikey.setKey(key);
    	apikey.setCreateTime(new Date());
    	apikey.setStatus(1);
    	apikey.setDeleted(0);
    	
    	if (apikeyService.selectByTag(apikey) != null) {
    		// 先根据name password type tag 查询一遍，如果没有才插入
    		cr.setCode(CommonResult.FAILURE_CODE);
    		cr.setMsg("插入失败");
    		cr.setEntiy("数据库中已有重复的 name、password、type、tag 项");
    	} else if (apikeyService.insertByAPIKey(apikey) == 1) {
    		cr.setCode(CommonResult.SUCCESS_CODE);
    		cr.setMsg("插入成功");
    	} else {
    		cr.setCode(CommonResult.FAILURE_CODE);
    		cr.setMsg("插入失败");
    	}
    	return cr;
    }
    
    /**
     * @Title: updateByAPIId
     * @Description: TODO(根据 id 更新一个 APIKey 的 name，password，type，tag，key )
     * @type：公开接口
     * @param: id
     * @param: name
     * @param: password
     * @param: type
     * @param: tag
     * @param: key
     * @return: CommonResult<String>
     * @throws
     */
    @ApiOperation(value = "更新 APIKey", notes = "更新一个 APIKey")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String"),
    	@ApiImplicitParam(name = "name", value = "name", required = true, dataType = "String"),
    	@ApiImplicitParam(name = "password", value = "password", required = true, dataType = "String"),
    	@ApiImplicitParam(name = "type", value = "type", required = true, dataType = "String"),
    	@ApiImplicitParam(name = "tag", value = "tag", required = true, dataType = "String"),
    	@ApiImplicitParam(name = "key", value = "key", required = true, dataType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public CommonResult<String> updateById(
    		@RequestParam String id,
    		@RequestParam String name,
    		@RequestParam String password,
    		@RequestParam String type,
    		@RequestParam String tag,
    		@RequestParam String key) {
    	log.info("公共接口：" + this.getClass().getName() + "根据 name: " + name + " 的 type:" + type + " 和 tag:" + tag + " 保存 APIKey......");
    	CommonResult<String> cr = new CommonResult<>();
    	
    	APIKey apikey = new APIKey();
    	apikey.setId(id);
    	apikey.setName(name);
    	apikey.setPassword(password);
    	apikey.setType(type);
    	apikey.setTag(tag);
    	apikey.setKey(key);
    	apikey.setUpdateTime(new Date());
    	
    	if (apikeyService.updateById(apikey) == 1) {
    		cr.setCode(CommonResult.SUCCESS_CODE);
    		cr.setMsg("更新成功");
    	} else {
    		cr.setCode(CommonResult.FAILURE_CODE);
    		cr.setMsg("更新失败");
    	}
    	return cr;
    }
}
