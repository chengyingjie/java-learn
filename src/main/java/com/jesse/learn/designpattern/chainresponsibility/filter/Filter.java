package com.jesse.learn.designpattern.chainresponsibility.filter;

public interface Filter {

    void doFilter(Request request, Response response, FilterChain filterChain);
}
