package com.cts.ejb.training.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.ejb.training.facade.MessageSenderImpl;
import com.cts.ejb.training.facade.StudentDao;

/**
 * Servlet implementation class UserAuthentication
 */
@WebServlet("/UserAuthentication")
public class UserAuthentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	MessageSenderImpl messageSenderImpl;
	
	
	

	/**
	 * Default constructor.
	 */
	public UserAuthentication() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		messageSenderImpl.sendData(request.getParameter("name"));
		
			RequestDispatcher  dispatcher =  request.getRequestDispatcher("/jsp/login.jsp"); 
			dispatcher.forward(request, response);
			
		
		  
	
	}

	
}
