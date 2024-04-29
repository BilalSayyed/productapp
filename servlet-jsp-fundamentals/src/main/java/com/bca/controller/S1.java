package com.bca.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class S1
 */
public class S1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String job;
	private String driver;
	private Dog dog;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S1() {
        super();
        System.err.println("Default Constructor S1");
        // TODO Auto-generated constructor stub
    }
	
//    public S1(int x) {
//       
//        System.err.println("Parameterized Constructor S1");
//        // TODO Auto-generated constructor stub
//    }

    
    
	@Override
	public void init(ServletConfig config) throws ServletException {
	job=config.getInitParameter("Job");
	driver=config.getServletContext().getInitParameter("driver");
	dog=(Dog) config.getServletContext().getAttribute("dog");
		super.init(config);
		System.err.println("init() S1");
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("S1 doGet()");
		PrintWriter printWriter=response.getWriter();
		printWriter.println("Hello all "+LocalDateTime.now());
		printWriter.println("Hello all i have done "+job);
		printWriter.println("Hello all i have mysql driver which is  "+driver);
		printWriter.println("Hello dog name is "+dog.getDogName());
	}

	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	@Override
	public void destroy() {
	
		super.destroy();
		System.err.println("destroy() S1");
	}

}
