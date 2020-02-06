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

/**
 *
 * @author Ramdev
 * This servlet use to show friend details
 */
@WebServlet("/ShowFriendDetailServlet")
public class ShowFriendDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowFriendDetailServlet() {
		super();
	}

	/**
	 * This method is use to show friend details
	 * @param request object of HttpServletRequest
	 * @param response object of HttpServletResponse
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		try{
			String email = request.getParameter("email");

			EmployeeFacade employeeFacade = EmployeeFacade.getInstance();

			EmployeeDTO employee = employeeFacade.getFriendDetail(email);
			session.setAttribute("friendDetail", employee);
			response.sendRedirect("jsp/private/friendprofile.jsp");
		}catch(Exception e)
		{
			session.setAttribute("error","Unable to retrive friends details");
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("ShowEmployeeDetailServlet");
			rd.forward(request, response);
		}
	}

}