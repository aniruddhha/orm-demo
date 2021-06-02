package com.ani.orm.xmlconfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MobileManager {

    public static void main(String[] args) {
        final SessionFactory factory = new Configuration().configure().buildSessionFactory();

        MobileManager mgr = new MobileManager();
        mgr.saveMobile(factory);
        mgr.findAllMobiles(factory);
    }

    private void saveMobile(SessionFactory factory) {
        Session session = factory.openSession();
        Transaction txn = session.beginTransaction();
        Mobile mb = new Mobile(
                1L, "89666", 10
        );
        session.save(mb);
        txn.commit();
        session.close();
    }

    private void findAllMobiles(SessionFactory factory) {
        Session session = factory.openSession();
        Transaction txn = session.beginTransaction();
        List<Mobile> mobiles = session.createQuery("from Mobile").list();
        txn.commit();
        session.close();

        System.out.println("--List--"); // use loggers
        mobiles.forEach(System.out::println);
    }
}
