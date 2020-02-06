package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.EmployeeDTO;
import facade.EmployeeFacade;

/**
 * 
 * @author Ramdev
 * This servlet is use to show employee details
 */
@WebServlet("/ShowEmployeeDetailServlet")
public class ShowEmployeeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowEmployeeDetailServlet() {
		super();

	}

	/**
	 * This method is use to show employee details
	 * @param request object of HttpServletRequest
	 * @param response object of HttpServletResponse
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		try{
			String email = (String) session.getAttribute("email");

			EmployeeFacade employeeFacade = EmployeeFacade.getInstance();

			EmployeeDTO employee = employeeFacade.getEmployeeDetail(email);
			session.setAttribute("employeeDetail", employee);
			response.sendRedirect("jsp/private/employeehome.jsp");
		}catch(Exception e){
			session.setAttribute("error","Unable to retrive details");
			response.sendRedirect("jsp/login.jsp");
		}
	}

	/**
	 * This method is use to show employee details
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		try{
			String email = (String) session.getAttribute("email");

			EmployeeFacade employeeFacade = EmployeeFacade.getInstance();

			EmployeeDTO employee = employeeFacade.getEmployeeDetail(email);
			session.setAttribute("employeeDetail", employee);
			response.sendRedirect("jsp/private/employeehome.jsp");
		}catch(Exception e){
			session.setAttribute("error","Unable to retrive details");
			response.sendRedirect("jsp/login.jsp");
		}
	}
}