package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.EmpBean;
import com.dao.EmpDao;

/**
 * Servlet implementation class AddStudentController
 */
public class AddEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String eName = request.getParameter("txtEmpName");
		EmpBean eb = new EmpBean();
		eb.seteName(eName);;

		if (new EmpDao().addEmployee(eb)) {

			response.sendRedirect("addemp");

		} else {

			System.out.println("new changes");
			response.sendRedirect("error.jsp");
		}

		doGet(request, response);
	}

}
