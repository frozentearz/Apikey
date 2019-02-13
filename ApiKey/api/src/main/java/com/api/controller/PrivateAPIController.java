package com.api.controller;

import java.util.List;

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

import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping ( "/root" )
@ApiIgnore()
//@Api(value = "APIKey 私有接口", tags = "APIKey 私有接口")
public class PrivateAPIController {
	@Autowired
    private IAPIKeyService apikeyService;
	
	private final static Logger log = Logger.getLogger(PrivateAPIController.class);
	
    /**
     * @Title: getAPIKeysWithRoot
     * @Description: TODO(查询所有 APIKey)
     * @type：非公开接口
     * @param: none
     * @return: CommonResult<List<ApiKey>>
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/allwithroot", method = { RequestMethod.GET, RequestMethod.POST })
    public CommonResult<List<APIKey>> getAPIKeysWithRoot() {
        log.info("私有接口：" + this.getClass().getName() + ", 查询全部数据......");
        CommonResult<List<APIKey>> cr = new CommonResult<List<APIKey>>();
        
        List<APIKey> apiKeys = apikeyService.selectListWithRoot();
        
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
     * @Title: getAPIKeyByIdWithRoot
     * @Description: TODO(根据 id 查询所有 APIKey)
     * @type：私有接口
     * @param: id
     * @return: CommonResult<APIKey>
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/getAPIKeyByIdWithRoot", method = { RequestMethod.GET, RequestMethod.POST })
    public CommonResult<APIKey> getAPIKeyByIdWithRoot(@RequestParam String id) {
    	log.info("私有接口：" + this.getClass().getName() + "根据 id: " + id + " 查询全部数据......");
    	CommonResult<APIKey> cr = new CommonResult<APIKey>();
    	
    	APIKey apiKey = apikeyService.selectByIdWithRoot(id);
    	
        if (apiKey != null) {
        	cr.setCode(CommonResult.SUCCESS_CODE);
        	cr.setMsg("查询成功");
        	cr.setEntiy(apiKey);
        } else {
        	cr.setCode(CommonResult.NULLDATA_CODE);
        	cr.setMsg("空数据");
        	cr.setEntiy(apiKey);
        }
        return cr;
    }
    
    /**
     * @Title: getAPIKeyByNameWithRoot
     * @Description: TODO(根据 name 查询所有 APIKey)
     * @type：私有接口
     * @param: name
     * @return: CommonResult<List<APIKey>>
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/getAPIKeyByNameWithRoot", method = { RequestMethod.GET, RequestMethod.POST })
    public CommonResult<List<APIKey>> getAPIKeyByNameWithRoot(@RequestParam String name) {
    	log.info("私有接口：" + this.getClass().getName() + "根据 name: " + name + " 查询全部数据......");
    	CommonResult<List<APIKey>> cr = new CommonResult<List<APIKey>>();
    	
    	List<APIKey> apiKeys = apikeyService.selectByNameWithRoot(name);
    	
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
     * @Title: getAPIKeyByTypeWithRoot
     * @Description: TODO(根据 type 查询所有 APIKey)
     * @type：私有接口
     * @param: type
     * @return: CommonResult<List<APIKey>>
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/getAPIKeyByTypeWithRoot", method = { RequestMethod.GET, RequestMethod.POST })
    public CommonResult<List<APIKey>> getAPIKeyByTypeWithRoot(@RequestParam String type) {
    	log.info("私有接口：" + this.getClass().getName() + "根据 type:" + type + " 查询全部数据......");
    	CommonResult<List<APIKey>> cr = new CommonResult<List<APIKey>>();
    	
    	List<APIKey> apiKeys = apikeyService.selectByTypeWithRoot(type);
    	
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
     * @Title: getAPIKeyByTypeAndTagWithRoot
     * @Description: TODO(根据 Type,Tag 查询所有 APIKeys)
     * @type：私有接口
     * @param: type
     * @param: tag
     * @return: CommonResult<List<APIKey>>
     * @throws 
     */
    @ResponseBody
    @RequestMapping(value = "/getAPIKeyByTypeAndTagWithRoot", method = { RequestMethod.GET, RequestMethod.POST })
    public CommonResult<List<APIKey>> getAPIKeyByTypeAndTagWithRoot(@RequestParam String type, @RequestParam String tag) {
    	log.info("私有接口：" + this.getClass().getName() + "根据 type:" + type + " + tag: " + tag + " 查询全部数据......");
    	CommonResult<List<APIKey>> cr = new CommonResult<List<APIKey>>();
    	
    	APIKey apikey = new APIKey();
    	apikey.setType(type);
    	apikey.setTag(tag);
    	
    	List<APIKey> apiKeys = apikeyService.selectByTypeAndTagWithRoot(apikey);
    	
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
