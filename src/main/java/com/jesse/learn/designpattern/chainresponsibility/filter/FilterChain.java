package com.jesse.learn.designpattern.chainresponsibility.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {

    // 用来存储过滤规则
    private List<Filter> filters = new ArrayList<Filter>();

    // 规则初始坐标值
    private int index = 0;

    public void doFilter(Request request, Response response, FilterChain filterChain) {

        if (index == filters.size()) {
            return;
        }

        Filter filter = filters.get(index++);
        filter.doFilter(request, response, filterChain);
    }

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;  // 返回当前对象示例，模拟builder模式
    }

}
