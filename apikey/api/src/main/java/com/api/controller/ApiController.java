package com.api.controller;

import com.api.common.model.pojo.ApiKey;
import org.apache.log4j.Logger;
import com.api.rpc.IApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @description:
 * @author: XFW
 * @version:
 * @create: 2019-01-31 12:10
 **/
@Controller
public class ApiController {
    private final static Logger log = Logger.getLogger(ApiController.class);

    @Autowired
    private IApiService apiService;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

    @RequestMapping("/apiTest")
    @ResponseBody
    public String apiTest() {
        return apiService.apiTest();
    }

    @ResponseBody
    @RequestMapping(value = "/all", method = { RequestMethod.GET, RequestMethod.POST })
    public String getApis() {
        log.info("查询全部数据......");
        List<ApiKey> apiKeys = apiService.selectList();
        log.info("查询完成...... 共：" + apiKeys.size() + "条数据。");
        return apiKeys.toString();
    }


    /*@ResponseBody
	@RequestMapping(value = "/getApiByName", method = { RequestMethod.GET, RequestMethod.POST })
    public void getApiByName(@RequestParam String name) {
    	log.info("根据 " + name + " 查询数据......");
    	List<ApiKey> apiKeys = apiService.selectListByName(name);
    	log.info("查询完成...... 共：" + apiKeys.size() + "条数据。");
    }*/
}
