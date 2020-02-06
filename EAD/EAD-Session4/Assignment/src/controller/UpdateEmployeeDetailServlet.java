package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * This servlet is use to update employee detail
 *
 */
@WebServlet("/UpdateEmployeeDetailServlet")
public class UpdateEmployeeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateEmployeeDetailServlet() {
		super();
	}

	/**
	 * This method is use to update employee details
	 * @param request object of HttpServletRequest
	 * @param response object of HttpServletResponse
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeDTO employee = new EmployeeDTO();
		HttpSession session = request.getSession();
		try {
			employee.setId(Integer.parseInt(request.getParameter("eid")));
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
				RequestDispatcher rd = request.getRequestDispatcher("RedirectToEditPage");
				rd.forward(request, response);
				return;
			}

			EmployeeFacade employeeFacade = EmployeeFacade.getInstance();

			boolean result = employeeFacade.updateEmployeeDetail(employee);
			if (result) {
				session.setAttribute("message", "Update successful");
				session.setAttribute("email", employee.getEmail());
				RequestDispatcher rd = request.getRequestDispatcher("LogoutServlet");
				rd.forward(request, response);
				return;
			} else {
				session.setAttribute("error", "Update unsuccessful");
				RequestDispatcher rd = request.getRequestDispatcher("ShowEmployeeDetailServlet");
				rd.forward(request, response);
				return;
			}
		} catch (Exception e) {
			session.setAttribute("error", "Update unsuccessful");
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("ShowEmployeeDetailServlet");
			rd.forward(request, response);
			return;
		}
	}

}