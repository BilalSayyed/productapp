package com.bca.util;

//import com.mysql.cj.xdevapi.SessionFactory;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryUtil {
    private static SessionFactory sessionFactory=null;

    public static SessionFactory getSessionFactory()
    {
        StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        sessionFactory=new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
        return sessionFactory;

    }
}
