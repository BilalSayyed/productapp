package com.bca.one2one.controller;

import com.bca.one2one.entity.Employee;
import com.bca.one2one.entity.Parking;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Employee employee1=new Employee();
employee1.setName("JCB");
        Parking parking=new Parking("Loc-1",employee1);
        employee1.setParking(parking);
//        Employee employee=new Employee("ABC",);

        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("hibernate_jpa");
//        Session session=sessionFactory.openSession();
        EntityManager entityManager=entityManagerFactory.createEntityManager();
//        Transaction transaction=session.getTransaction();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        try
        {
//            transaction.begin();
            entityTransaction.begin();
//            Employee employee1=new Employee("BCA",10000,"IT");
//            Employee employee2=new Employee("ABC",20000,"Finance");
//            Employee employee3=new Employee("XYZ",20000,"Management");
//            session.persist(employee1);
//            session.persist(employee2);
//            session.persist(employee3);
            entityManager.persist(employee1);
//            entityManager.persist(employee2);
//            entityManager.persist(employee3);

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
