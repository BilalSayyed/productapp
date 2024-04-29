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
public class S2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String job;
	private Dog dog;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S2() {
        super();
        System.err.println("Default Constructor S2");
        // TODO Auto-generated constructor stub
    }
	
//    public S2(int x) {
//       
//        System.err.println("Parameterized Constructor S2");
//        // TODO Auto-generated constructor stub
//    }

    
    
	@Override
	public void init(ServletConfig config) throws ServletException {
	job=config.getInitParameter("Job");
	dog=(Dog) config.getServletContext().getAttribute("dog");
		super.init(config);
		System.err.println("init() S2");
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
		System.err.println("destroy() S2");
	}

}
