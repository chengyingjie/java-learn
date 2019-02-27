package com.jesse.learn.designpattern.chainresponsibility.filter;

public class Request {

    private String reqStr;

    Request(String reqStr) {
        this.reqStr = reqStr;
    }

    public String getReqStr() {
        return reqStr;
    }

    public void setReqStr(String reqStr) {
        this.reqStr = reqStr;
    }
}
