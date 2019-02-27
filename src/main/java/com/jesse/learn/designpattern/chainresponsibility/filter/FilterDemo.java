package com.jesse.learn.designpattern.chainresponsibility.filter;

/**
 * 模仿实现filter过滤器
 */
public class FilterDemo {

    public static void main(String[] args) {

        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new FilterA()).addFilter(new FilterB());

        Request request = new Request("filter demo request");
        Response response = new Response("filter demo response");
        filterChain.doFilter(request, response, filterChain);

        System.out.println(request.getReqStr());
        System.out.println(response.getRespStr());
    }
}
