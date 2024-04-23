package com.bca.service;

import com.bca.entity.Employee;
import com.bca.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class A_AddEmployee {


    public static void main(String[] args) {
        SessionFactory sessionFactory=SessionFactoryUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.getTransaction();
        try
        {
            transaction.begin();
            Employee employee1=new Employee("BCA",10000,"IT");
            Employee employee2=new Employee("ABC",20000,"Finance");
            Employee employee3=new Employee("XYZ",20000,"Management");
            session.persist(employee1);
            session.persist(employee2);
            session.persist(employee3);

            transaction.commit();

        }catch (Exception e )
        {
            System.out.println(e);
            transaction.rollback();

        }
        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
