package com.bca.service;

import com.bca.entity.Employee;
import com.bca.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Objects;

public class B_ShowEmployees {
    public static void main(String[] args) {
        SessionFactory sessionFactory= SessionFactoryUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        List<Employee> employees=session.createQuery("select e from Employee e",Employee.class).getResultList();
        employees.forEach(employee -> System.out.println(employee));
        List<String> employeeNames=session.createQuery("select e.name from Employee e",String.class).getResultList();
        employeeNames.forEach(employeeName-> System.out.println(employeeName));
        List<Object[]> emps=session.createQuery("select e.name,e.salary from Employee e",Object[].class).getResultList();
        emps.forEach(employee-> System.out.println(employee.toString() ));

        session.close();
        sessionFactory.close();
    }
}
