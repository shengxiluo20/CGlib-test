package com.chi;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author chi  2018-05-18 15:02
 **/
public class TableDAOFactory {private static TableDAO tDao = new TableDAO();
    public static TableDAO getInstance(){
        return tDao;
    }

    public static TableDAO getAuthInstance(AuthProxy authProxy){
        Enhancer en = new Enhancer();
        //进行代理
        en.setSuperclass(TableDAO.class);
        en.setCallback(authProxy);
        //生成代理实例
        return (TableDAO)en.create();
    }

}
