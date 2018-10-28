package com.repairsystem.utils;

/**
 * @author CheungChingYin
 * @date 2018/10/28
 * @time 15:10
 */
public class JsonResult<T> {

    private T data;
    private Integer code;
    private String msg;

    /**
     * 若没有返回数据，默认状态码为200，提示操作成功
     */
    public JsonResult(){
        this.code = 200;
        this.msg = "操作成功";
    }

    /**
     * 没有返回数据，人为指定状态码和提示信息
     * @param code
     * @param mes
     */
    public JsonResult(Integer code, String mes) {
        this.code = code;
        this.msg = mes;
    }

    /**
     * 有数据返回，状态码为200，默认提示操作成功
     * @param data
     */
    public JsonResult(T data) {
        this.data = data;
        this.code = 200;
        this.msg = "操作成功";
    }

    /**
     * 有数据返回，人为提示信息
     * @param data
     * @param msg
     */
    public JsonResult(T data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    /**
     * 缺少异常处理
     */

}
