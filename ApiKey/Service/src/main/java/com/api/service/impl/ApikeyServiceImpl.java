package com.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.IApikeyDao;
import com.api.model.pojo.Apikey;
import com.api.service.IApikeyService;

/**
 * ApikeyService实现
 * <br>
 * <b>功能：</b>ApikeyService<br>
 */
@Service
public class ApikeyServiceImpl implements IApikeyService {
	
	// private final static Logger log = Logger.getLogger(ApikeyServiceImpl.class);

	@Autowired
    private IApikeyDao apikeydao;
	
	public List<Apikey> selectList() {
		List<Apikey> apikeys = new ArrayList<Apikey>();
		try {
			apikeys = apikeydao.selectList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apikeys;
	}
	
	public Apikey selectListById(String Id) {
		Apikey api = new Apikey();
		try {
			api = apikeydao.selectListById(Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return api;
	}

	public List<Apikey> selectListByName(String name) {
		List<Apikey> apikeys = new ArrayList<Apikey>();
		try {
			apikeys = apikeydao.selectListByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apikeys;
	}
	
	public Apikey selectListByVerify(String name, String password, String type) {
		Apikey api = new Apikey();
		try {
			api = apikeydao.selectListByVerify(name, password, type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return api;
	}
}
