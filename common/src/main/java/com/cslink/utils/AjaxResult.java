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

    // TODO Error
    // TODO WARN
}
