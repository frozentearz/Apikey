package com.api.common.model.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
 
/**
 * @author yuanshushu
 * @date 2018/8/29
 * @description 返回结果VO对象
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> {
 
    @ApiModelProperty("状态码 0失败 1成功 2未登录 3没有权限")
    private Integer code;
 
    @ApiModelProperty("返回信息")
    private String msg;
 
    @ApiModelProperty("返回数据")
    private T data;
 
    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
 
    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
 
    public ResultVO() {
		
	}

	/**
     * 请求成功  状态码 1
     *
     * @param msg 返回信息
     * @param <T> 类型
     * @return ResultVO
     */
    public static <T> ResultVO getSuccess(String msg) {
        return new ResultVO(1, msg);
    }
 
    /**
     * 请求成功  状态码 1
     *
     * @param msg  返回信息
     * @param data 返回对象
     * @param <T>  类型
     * @return ResultVO
     */
    public static <T> ResultVO getSuccess(String msg, T data) {
        return new ResultVO(1, msg, data);
    }
 
    /**
     * 请求失败   状态码 0
     *
     * @param msg 返回信息
     * @param <T> 类型
     * @return ResultVO
     */
    public static <T> ResultVO getFailed(String msg) {
        return new ResultVO(0, msg);
    }
 
    /**
     * 请求失败  状态 0
     *
     * @param msg  返回信息
     * @param data 返回数据
     * @param <T>  类型
     * @return ResultVO
     */
    public static <T> ResultVO getFailed(String msg, T data) {
        return new ResultVO(0, msg, data);
    }

    /**
     * 用户没有操作权限
     *
     * @param <T> 类型
     * @return ResultVO
     */
    public static <T> ResultVO getNoAuthorization() {
        return new ResultVO(3, "用户没有操作权限，请重新登录");
    }
 
 
    public Integer getCode() {
        return code;
    }
 
    public void setCode(Integer code) {
        this.code = code;
    }
 
    public String getMsg() {
        return msg;
    }
 
    public void setMsg(String msg) {
        this.msg = msg;
    }
 
    public T getData() {
        return data;
    }
 
    public void setData(T data) {
        this.data = data;
    }
}