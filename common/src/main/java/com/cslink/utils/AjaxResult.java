package com.cslink.utils;

import com.cslink.constants.HttpStatus;

import java.util.HashMap;

public class AjaxResult extends HashMap<String, Object> {
    private static final String CODE_TAG = "code";
    public static final String MSG_TAG = "msg";
    public static final String DATA_TAG = "data";

    public AjaxResult(){}
    public AjaxResult(int code,String msg) {
        super.put(CODE_TAG,code);
        super.put(MSG_TAG,msg);
    }
    public AjaxResult(int code,String msg,Object Data) {
        super.put(CODE_TAG,code);
        super.put(MSG_TAG,msg);
        super.put(DATA_TAG,Data);
    }

    public static AjaxResult success(){
        return AjaxResult.success("操作成功");
    }
    public static AjaxResult success(String msg) {
        return AjaxResult.success(msg,null);
    }
    public static AjaxResult success(Object data) {
        return AjaxResult.success("操作成功",data);
    }
    public static AjaxResult success(String msg,Object Data) {
        return new AjaxResult(HttpStatus.SUCCESS,msg,Data);
    }

    public static AjaxResult error()
    {
        return AjaxResult.error("操作失败");
    }

    public static AjaxResult error(String msg)
    {
        return AjaxResult.error(msg, null);
    }
    public static AjaxResult error(String msg, Object data)
    {
        return new AjaxResult(HttpStatus.ERROR, msg, data);
    }
    public static AjaxResult warn(){
        return AjaxResult.warn("警告!网络不是不法之地");
    }
    public static AjaxResult warn(String msg)
    {
        return AjaxResult.warn(msg, null);
    }
    public static AjaxResult warn(String msg, Object data)
    {
        return new AjaxResult(HttpStatus.WARN, msg, data);
    }

}
