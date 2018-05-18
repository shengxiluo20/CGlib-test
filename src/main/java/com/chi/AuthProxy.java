package com.chi;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author chi  2018-05-18 15:06
 **/
public class AuthProxy implements MethodInterceptor {
    private String name ;
    //传入用户名称
    public AuthProxy(String name){
        this.name = name;
    }

    /**
     * 拦截器方法
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @return
     * @throws Throwable
     */
    public Object intercept(Object arg0, Method arg1, Object[] arg2,
                            MethodProxy arg3) throws Throwable {
        //用户进行判断
        if(!"张三".equals(name)){
            System.out.println(name +":方法["+ arg1.getName()+ "]你没有权限！");
            return null;
        }
        return arg3.invokeSuper(arg0, arg2);
    }
}
