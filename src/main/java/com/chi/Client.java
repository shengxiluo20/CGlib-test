package com.chi;

/**
 * @author chi  2018-05-18 15:03
 **/
public class Client {

    public static void main(String[] args) {
        normal();
        System.out.println("========================");
        haveNoAuth();
        System.out.println("========================");
        haveAuth();
        System.out.println("========================");
        haveAuthByFilter();
    }

    private static void doMethod(TableDAO dao) {
        dao.create();
        dao.query();
        dao.update();
        dao.delete();
    }

    //正常
    private static void normal() {
        TableDAO tableDao = TableDAOFactory.getInstance();
        doMethod(tableDao);
    }

    //有权限
    private static void haveAuth() {
        TableDAO tDao = TableDAOFactory.getAuthInstance(new AuthProxy("张三"));
        doMethod(tDao);
    }

    //无权限
    private static void haveNoAuth() {
        TableDAO tDao = TableDAOFactory.getAuthInstance(new AuthProxy("李四"));
        doMethod(tDao);
        //对象的所有方法都会调用拦截方法
        tDao.toString();
        tDao.hashCode();
    }


    //方法权限(开放查询功能)
    public static void haveAuthByFilter(){

        //开放查询功能
        TableDAO tDao = TableDAOFactory.getAuthInstanceByFilter(new AuthProxy("张三"));
        doMethod(tDao);

        tDao = TableDAOFactory.getAuthInstanceByFilter(new AuthProxy("李四"));
        doMethod(tDao);
    }
}
