package com.api.common.model.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @description:
 * @author: Frazier
 * @version:
 * @create: 2019-01-31 15:47
 **/
public class APIKey {
    private String id;// 
    private String name;//
    private String password;//
    private String type;// 【APIKey的类型】多个APIKey可能有同一类型，推荐填入网站（在某网站拥有多个APIKey）
    private String tag;// 【唯一】在同一类型下的唯一标识
    private String key;//
    private Date createTime;//
    private Date updateTime;//
    private Integer status;// 【apikey状态】1可用，2即将失效，0失效
    private Integer deleted;// 【soft delete】1 已删除，0 未删除
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	@Override
	public String toString() {
		return "ApiKey [id=" + id + ", name=" + name + ", password=" + password + ", type=" + type + ", tag=" + tag
				+ ", key=" + key + ", createTime=" + createTime + ", updateTime=" + updateTime + ", status=" + status
				+ ", deleted=" + deleted + "]";
	}
}
