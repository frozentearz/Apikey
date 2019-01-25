package com.api.service;

import java.util.List;

import com.api.model.pojo.Apikey;

/**
 * ApikeyService接口
 * @author Frazier
 * @email frozen_tearz@163.com
 */
public interface IApikeyService {
	
	public List<Apikey> selectList();
	
	public Apikey selectListById(String Id);

	public List<Apikey> selectListByName(String name);
	
	public Apikey selectListByVerify(String name, String password, String type);
}