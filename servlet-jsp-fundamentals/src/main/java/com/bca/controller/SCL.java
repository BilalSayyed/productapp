package com.bca.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class SCL
 *
 */
public class SCL implements ServletContextListener {

	private Dog dog=null;
    /**
     * Default constructor. 
     */
    public SCL() {
        System.err.println("Default Constructor of SCL");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	sce.getServletContext().removeAttribute("dog");
    	System.err.println("contextInitialized () of SCL");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	dog=new Dog();
    	dog.setDogName("Stonish");
    	sce.getServletContext().setAttribute("dog", dog);
    	 System.err.println("contextDestroyed () of SCL");
    	
    }
	
}
