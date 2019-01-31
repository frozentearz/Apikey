package com.api.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.api.common.model.pojo.ApiKey;
import com.api.common.model.pojo.ResultVO;
import com.api.rpc.IApiService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


@Controller
public class ApiController {
	
    @Autowired
    private IApiService apiService;
    
    private final static Logger log = Logger.getLogger(ApiController.class);
    
    @ApiOperation(value = "获得所有的api对象list", notes = "get请求，查询所有的api。")
    @ResponseBody
    @RequestMapping(value = "/all", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<String> getApis() {
    	
    	ResultVO<Object> rvo = new ResultVO<Object>();
        log.info("查询全部数据......");
        
        List<ApiKey> apiKeys = apiService.selectList();
        
        if (apiKeys != null) {
        	rvo.setCode(1);
        	rvo.setMsg("查询成功");
        	rvo.setData(apiKeys.get(1));
        	return new ResponseEntity<String>(JSON.toJSON(rvo).toString(), HttpStatus.OK);
        } else {
        	rvo.setCode(0);
        	rvo.setMsg("查询失败");
        	rvo.setData(null);
        	return new ResponseEntity<String>(JSON.toJSON(rvo).toString(), HttpStatus.OK);
        }
    }
    
    @ApiOperation(value = "根据 id 查询 api ", notes = "根据 id 查询 api ")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String")
    @ResponseBody
    @RequestMapping(value = "/getApiById", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<String> getApiById(@RequestParam String id) {
//    	JSONObject jsonObject = new JSONObject();
    	log.info("正在根据ID:" + id + "查询数据......");
    	
        ApiKey apiKey = apiService.selectById(id);
        String apiJson = JSON.toJSON(apiKey).toString();
        
        log.info("查询完成...  -------  " + apiJson);
        
		return new ResponseEntity<String>(apiJson, HttpStatus.OK);
    }
}
