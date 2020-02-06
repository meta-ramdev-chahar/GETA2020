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
import facade.LoginFacade;
import facade.VehicleFacade;

/**
 * 
 * @author Ramdev
 * This servlet is use to login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * This method is use to login
	 * @param request object of HttpServletRequest
	 * @param response object of HttpServletResponse
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmployeeDTO employee = new EmployeeDTO();
		HttpSession session = request.getSession();
		try{
			employee.setEmail(request.getParameter("email"));
			employee.setPassword(request.getParameter("password"));

			LoginFacade loginFacade = new LoginFacade();
			
			boolean result = loginFacade.login(employee);
			if(result)
			{
				session.setAttribute("email", employee.getEmail());
				EmployeeFacade employeeFacade = EmployeeFacade.getInstance();
				session.setAttribute("eid", employee.getId());
				boolean isVehicleRegistered = employeeFacade.isVehicleRegistrationComplete(employee.getEmail());
				if(isVehicleRegistered)
				{
					session.setAttribute("isVehicleRegistered", true);
					boolean isPlanRegistered = employeeFacade.isPlanRegistrationComplete(employee.getEmail());
					if(isPlanRegistered)
					{
						session.setAttribute("isPlanRegistered", true);
						RequestDispatcher rd = request.getRequestDispatcher("ShowEmployeeDetailServlet");
						rd.forward(request, response);
					}
					else
					{
						VehicleFacade vehicleFacade = VehicleFacade.getInstance();
						session.setAttribute("vehicleType", vehicleFacade.getVehicleType(employee.getEmail()));
						RequestDispatcher rd = request.getRequestDispatcher("RedirectToPlanRegistrationPage");
						rd.forward(request, response);
					}
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("RedirectToVehicleRegistrationPage");
					rd.forward(request, response);
				}
			}
			else
			{
				session.setAttribute("error","Login failed");
				response.sendRedirect("jsp/login.jsp");
			}
		}catch(Exception e){
			session.setAttribute("error","Login failed");
			e.printStackTrace();
			response.sendRedirect("jsp/login.jsp");
		}

	}

}