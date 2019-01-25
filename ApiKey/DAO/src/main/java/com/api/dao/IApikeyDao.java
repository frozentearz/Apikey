package com.api.dao;

import java.util.List;

import com.api.model.pojo.Apikey;

/**
 * ApikeyDAO接口
 * @author Frazier
 *
 */
public interface IApikeyDao{
	public List<Apikey> selectList();
	
	public Apikey selectListById(String Id);

	public List<Apikey> selectListByName(String name);
	
	public Apikey selectListByVerify(String name, String password, String type);
}
