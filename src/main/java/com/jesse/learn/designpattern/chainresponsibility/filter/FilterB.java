package com.jesse.learn.designpattern.chainresponsibility.filter;

/**
 * 过滤器B
 */
public class FilterB implements Filter {

    public void doFilter(Request request, Response response, FilterChain filterChain) {

        // 执行过滤器B的特有逻辑，比如：去除字符串中敏感词
        request.setReqStr(request.getReqStr() + "_filterB");

        // 走到下一个链条节点
        filterChain.doFilter(request, response, filterChain);

        // 过滤器后置处理
        response.setRespStr(response.getRespStr() + "filterB_");
    }
}
