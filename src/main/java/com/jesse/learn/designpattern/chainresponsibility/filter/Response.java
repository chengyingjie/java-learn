package com.jesse.learn.designpattern.chainresponsibility.filter;

public class Response {

    Response(String respStr) {
        this.respStr = respStr;
    }

    private String respStr;

    public String getRespStr() {
        return respStr;
    }

    public void setRespStr(String respStr) {
        this.respStr = respStr;
    }
}
