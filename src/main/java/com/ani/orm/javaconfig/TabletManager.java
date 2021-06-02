package com.ani.orm.javaconfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class TabletManager {
    public static void main(String[] args) {

        final SessionFactory factory = new Configuration()
                .setProperties(cfg()) // no cfg file
                .addAnnotatedClass(Tablet.class) // no mapping files
                .buildSessionFactory();

        TabletManager mgr = new TabletManager();
        mgr.save(factory);
    }

    private void save(SessionFactory factory) {
        Session session = factory.openSession();
        Transaction txn = session.beginTransaction();
        session.save(
                new Tablet(5L, "android", "10")
        );
        txn.commit();
        session.close();
    }

    private static Properties cfg() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.h2.Driver");
        properties.put(Environment.URL, "jdbc:h2:mem:testdb");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "password");
        properties.put(Environment.SHOW_SQL, true);
        properties.put(Environment.FORMAT_SQL, true);
        properties.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
        properties.put(Environment.HBM2DDL_AUTO, "create-drop");
        return properties;
    }
}
