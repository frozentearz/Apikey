package com.api.result.common;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName: CommonResult
 * @Description: 通用返回结果
 * @author  Frazier
 * @date    2019/2/1 14:19:23
 * @version V1.0 
 *
 */
@ApiModel(description = "通用返回结果")
public class CommonResult<T> implements Serializable {

	private static final long serialVersionUID = -8727623256526713604L;
	
	/**
	 * 成功结果码：1
	 */
	@ApiModelProperty(value = "成功结果码", required = false)
	public static final Integer SUCCESS_CODE = 1;
	
	/**
	 * 失败结果码：-1
	 */
	@ApiModelProperty(value = "失败结果码", required = false)
	public static final Integer FAILURE_CODE = -1;
	
	/**
	 * 空数据结果码：0
	 */
	@ApiModelProperty(value = "空数据结果码", required = false)
	public static final Integer NULLDATA_CODE = 0;
	
	/**
	 * 系统异常结果码：-2
	 */
	@ApiModelProperty(value = "系统异常结果码", required = false)
	public static final Integer SYSEXP_CODE = -2;
	
	
	
	/**
	 * 响应结果码
	 */
	@ApiModelProperty(value = "响应结果码", required = true)
	private int code;
	
	/**
	 * 响应结果信息
	 */
	@ApiModelProperty(value = "响应结果信息", required = true)
	private String msg;
	
	/**
	 * 响应结果对象
	 */
	@ApiModelProperty(value = "响应结果对象", required = true)
	private T entiy;

	/**
	 * 服务器系统当前时间
	 */
	@ApiModelProperty(value = "服务器系统当前时间", required = true)
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
	private Date systemTime = new Date();
	
	public CommonResult(){
	}

	public CommonResult(int code, String msg, T entiy) {
		super();
		this.code = code;
		this.msg = msg;
		this.entiy = entiy;
	}

	public CommonResult(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getEntiy() {
		return entiy;
	}

	public void setEntiy(T entiy) {
		this.entiy = entiy;
	}

	public Date getSystemTime() {
		return systemTime;
	}

	public void setSystemTime(Date systemTime) {
		this.systemTime = systemTime;
	}
	
}
