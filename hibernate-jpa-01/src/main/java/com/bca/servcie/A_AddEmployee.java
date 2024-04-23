package com.bca.servcie;

import com.bca.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class A_AddEmployee {


    public static void main(String[] args) {
//        SessionFactory sessionFactory=SessionFactoryUtil.getSessionFactory();
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("hibernate_jpa");
//        Session session=sessionFactory.openSession();
        EntityManager entityManager=entityManagerFactory.createEntityManager();
//        Transaction transaction=session.getTransaction();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        try
        {
//            transaction.begin();
            entityTransaction.begin();
            Employee employee1=new Employee("BCA",10000,"IT");
            Employee employee2=new Employee("ABC",20000,"Finance");
            Employee employee3=new Employee("XYZ",20000,"Management");
//            session.persist(employee1);
//            session.persist(employee2);
//            session.persist(employee3);
            entityManager.persist(employee1);
            entityManager.persist(employee2);
            entityManager.persist(employee3);

            entityTransaction.commit();

        }catch (Exception e )
        {
            System.out.println(e);
            entityTransaction.rollback();

        }
        finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
