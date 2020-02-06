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
import util.Validation;

/**
 * 
 * @author Ramdev
 * This servlet add employee
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEmployeeServlet() {
		super();	
	}

	/**
	 * This method add employee
	 * @param request object of HttpServletRequest
	 * @param response object of HttpServletResponse
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeDTO employee = new EmployeeDTO();
		HttpSession session = request.getSession();
		try {
			employee.setName(request.getParameter("name"));
			employee.setGender(request.getParameter("gender"));
			employee.setEmail(request.getParameter("email"));
			employee.setPassword(request.getParameter("password"));
			String confirmPassword = request.getParameter("confirmpassword");
			employee.setPhoneNumber(request.getParameter("contactnumber"));

			employee.setOrganization(request.getParameter("organization"));

			Validation validate = new Validation();
			String error = validate.validateEmployeeDetail(employee, confirmPassword);
			if (!error.equals("")) {
				session.setAttribute("error", error);
				response.sendRedirect("jsp/employeeregister.jsp");
			}

			EmployeeFacade employeeFacade = EmployeeFacade.getInstance();

			int employeeId = employeeFacade.addEmployee(employee);
			if (employeeId > -1) {
				session.setAttribute("message", "Welcome " + employee.getName() + " please login to continue");
				response.sendRedirect("jsp/login.jsp");
			} else {
				session.setAttribute("error", "Registration failed");
				response.sendRedirect("jsp/employeeregister.jsp");
			}
		} catch (Exception e) {
			session.setAttribute("error", "Registration failed");
			response.sendRedirect("jsp/employeeregister.jsp");
		}

	}

}