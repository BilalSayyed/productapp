package com.bca.servcie;

import com.bca.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class D_DeleteEmployee {
    public static void main(String[] args) {


//    SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("hibernate_jpa");
//    Session session = sessionFactory.openSession();
        EntityManager entityManager =entityManagerFactory.createEntityManager();
//    Transaction transaction = session.getTransaction();
        EntityTransaction entityTransaction=entityManager.getTransaction();
    try

    {
        entityTransaction.begin();
        Employee employee=entityManager.find(Employee.class,6);
        entityManager.remove(employee);

        entityTransaction.commit();
    }
    catch(
    Exception exception)

    {
        System.out.println(exception);
        entityTransaction.rollback();
    }
    finally

    {
        entityManager.close();
        entityManagerFactory.close();
    }
}
}
