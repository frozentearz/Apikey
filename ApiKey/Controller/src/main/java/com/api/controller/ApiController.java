package com.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.model.pojo.Apikey;
import com.api.service.IApikeyService;

/**
 * Hello world!
 *
 */
@Controller
@RequestMapping("/api") 
public class ApiController {
	
	private final static Logger log = Logger.getLogger(ApiController.class);
	
	@Autowired
	private IApikeyService apikeyService;
	
	@ResponseBody
	@RequestMapping(value = "/getApiByName", method = { RequestMethod.GET, RequestMethod.POST })
    public void getApiByName(HttpServletRequest request,
    		HttpServletResponse response,
    		@RequestParam String name) {
    	List<Apikey> apikeys = new ArrayList<Apikey>();
    	log.info("根据 " + name + " 查询数据......");
    	apikeys = apikeyService.selectListByName(name);
    	log.info("查询完成...... 共：" + apikeys.size() + "条数据。");
    }
}
