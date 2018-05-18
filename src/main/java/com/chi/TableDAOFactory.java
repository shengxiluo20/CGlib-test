package com.chi;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * @author chi  2018-05-18 15:02
 **/
public class TableDAOFactory {private static TableDAO tDao = new TableDAO();

    /**
     * 生成普通类
     * @return
     */
    public static TableDAO getInstance(){
        return tDao;
    }

    /**
     * 生成动态代理类
     * @param authProxy
     * @return
     */
    public static TableDAO getAuthInstance(AuthProxy authProxy){
        Enhancer en = new Enhancer();
        //进行代理
        en.setSuperclass(TableDAO.class);
        en.setCallback(authProxy);
        //生成代理实例
        return (TableDAO)en.create();
    }

    /**
     * 生成多拦截器代理类
     * @param authProxy
     * @return
     */
    public static TableDAO getAuthInstanceByFilter(AuthProxy authProxy){
        Enhancer en = new Enhancer();
        en.setSuperclass(TableDAO.class);
        //NoOp.INSTANCE是CGlib所提供的实际是一个没有任何操作的拦截器，
        en.setCallbacks(new Callback[]{authProxy, NoOp.INSTANCE});
        en.setCallbackFilter(new AuthProxyFilter());
        return (TableDAO)en.create();
    }

}
