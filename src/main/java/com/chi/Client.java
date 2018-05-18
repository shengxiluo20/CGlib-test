package com.chi;

/**
 * @author chi  2018-05-18 15:03
 **/
public class Client {

    public static void main(String[] args) {
        normal();
        haveNoAuth();
        haveAuth();
    }

    private static void doMethod(TableDAO dao) {
        dao.create();
        dao.query();
        dao.update();
        dao.delete();
        System.out.println("========================");
    }

    private static void normal() {
        TableDAO tableDao = TableDAOFactory.getInstance();
        doMethod(tableDao);
    }

    private static void haveAuth() {
        TableDAO tDao = TableDAOFactory.getAuthInstance(new AuthProxy("张三"));
        doMethod(tDao);
    }

    private static void haveNoAuth() {
        TableDAO tDao = TableDAOFactory.getAuthInstance(new AuthProxy("李四"));
        doMethod(tDao);
    }
}
