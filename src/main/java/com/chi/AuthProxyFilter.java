package com.chi;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * 方法拦截器
 *
 * @author chi  2018-05-18 15:50
 **/
public class AuthProxyFilter implements CallbackFilter {
    public int accept(Method arg0) {
        if (!"query".equalsIgnoreCase(arg0.getName()))
            return 0;  //执行第0个拦截器

        System.out.println(arg0.getName() +"方法执行第一个拦截器(放行)");
        return 1;  //执行第1个拦截器
    }
}
