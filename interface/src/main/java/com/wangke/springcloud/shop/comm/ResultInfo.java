package com.wangke.springcloud.shop.comm;

import lombok.Data;

@Data
public class ResultInfo {
    private String info;
    private int code;
    private Object result;

    public ResultInfo() {
    }

    public ResultInfo(String info, int code, Object result) {
        this.info = info;
        this.code = code;
        this.result = result;
    }
    public ResultInfo ok(Object result){
        return  new ResultInfo("success",1001,result);
    }
    public ResultInfo err(Object result){
        return  new ResultInfo("err",1002,result);
    }
}
