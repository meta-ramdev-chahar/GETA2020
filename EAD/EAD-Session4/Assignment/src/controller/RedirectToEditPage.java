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
 * This servlet is use to redirect to edit page
 */
@WebServlet("/RedirectToEditPage")
public class RedirectToEditPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RedirectToEditPage() {
		super();
	}

	/**
	 * This method redirect to employee edit page
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
			response.sendRedirect("jsp/private/updateemployeedetails.jsp");
		}catch(Exception e){
			session.setAttribute("error","Unable to retrive details");
			response.sendRedirect("jsp/private/employeehome.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}


}