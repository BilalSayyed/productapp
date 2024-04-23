package com.bca.service;

import com.bca.entity.Employee;
import com.bca.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class C_UpdateEmployee {
    public static void main(String[] args) {
        SessionFactory sessionFactory= SessionFactoryUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.getTransaction();
        try {
            transaction.begin();
            Employee employee=session.get(Employee.class,1);
            System.out.println(employee);
            employee.setName("JCB");
            session.persist(employee);
            transaction.commit();
        }
        catch (Exception e)
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
