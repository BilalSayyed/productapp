package com.bca.servcie;

import com.bca.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Objects;

public class B_ShowEmployees {
    public static void main(String[] args) {
//        SessionFactory sessionFactory= SessionFactoryUtil.getSessionFactory();
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("hibernate_jpa");
//        Session session=sessionFactory.openSession();
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        List<Employee> employees=entityManager.createQuery("select e from Employee e",Employee.class).getResultList();
        employees.forEach(employee -> System.out.println(employee));
        List<String> employeeNames=entityManager.createQuery("select e.name from Employee e",String.class).getResultList();
        employeeNames.forEach(employeeName-> System.out.println(employeeName));
        List<Object[]> emps=entityManager.createQuery("select e.name,e.salary from Employee e",Object[].class).getResultList();
        emps.forEach(employee-> System.out.println(employee.toString() ));

        entityManager.close();
        entityManagerFactory.close();
    }
}
