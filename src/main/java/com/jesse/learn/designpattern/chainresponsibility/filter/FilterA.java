package com.jesse.learn.designpattern.chainresponsibility.filter;

/**
 * 过滤器A
 */
public class FilterA implements Filter {

    public void doFilter(Request request, Response response, FilterChain filterChain) {

        // 执行过滤器A的特有逻辑，比如：去除字符串中敏感词
        request.setReqStr(request.getReqStr() + "_filterA");

        // 走到下一个链条节点
        filterChain.doFilter(request, response, filterChain);

        // 过滤器后置处理
        response.setRespStr(response.getRespStr() + "filterA");
    }
}
