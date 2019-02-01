package com.api.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.common.model.pojo.ApiKey;
import com.api.result.common.CommonResult;
import com.api.rpc.IApiService;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping ( "/root" )
@ApiIgnore()
public class PrivateAPIController {
	@Autowired
    private IApiService apiService;
	
	private final static Logger log = Logger.getLogger(PrivateAPIController.class);
	
    /**
     * @Title: getApisWithRoot
     * @Description: TODO(查询所有 api)
     * @type：非公开接口
     * @param: 
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
}
