package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import facade.EmployeeFacade;

/**
 * This servlet is to redirect to vehicle registration page
 * @author Ramdev
 *
 */
@WebServlet("/RedirectToVehicleRegistrationPage")
public class RedirectToVehicleRegistrationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RedirectToVehicleRegistrationPage() {
		super();
	}

	/**
	 * This method is use to redirect to vehicle registration page
	 * @param request object of HttpServletRequest
	 * @param response object of HttpServletResponse
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmployeeFacade employeeFacade = EmployeeFacade.getInstance();
		HttpSession session = request.getSession();
		try {
			String email = (String) session.getAttribute("email");

			int empId = employeeFacade.getEmployeeId(email);
			session.setAttribute("employeeId", empId);
			response.sendRedirect("jsp/private/register/vehicleregister.jsp");
		} catch (Exception e) {
			session.setAttribute("error", "Can't get vehicle details");
			RequestDispatcher rd = request.getRequestDispatcher("LogoutServlet");
			rd.forward(request, response);
		}
	}

}