package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * This servlet redirect to show friends page
 */
@WebServlet("/RedirectToShowFriendsPage")
public class RedirectToShowFriendsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RedirectToShowFriendsPage() {
		super();

	}

	/**
	 * This method is use to redirect to show friends page
	 * @param request object of HttpServletRequest
	 * @param response object of HttpServletResponse
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		try
		{
			String email = (String) session.getAttribute("email");
			EmployeeFacade employeeFacade = EmployeeFacade.getInstance();
			int eid = employeeFacade.getEmployeeId(email);
			List<EmployeeDTO> friendList = new ArrayList<EmployeeDTO>();
			friendList = employeeFacade.getFriendList(email, eid);
			session.setAttribute("friendList", friendList);
			response.sendRedirect("jsp/private/employeefriends.jsp");
		}
		catch(Exception e)
		{
			session.setAttribute("error","Can't get friend list");
			RequestDispatcher rd = request.getRequestDispatcher("ShowEmployeeDetailServlet");
			rd.forward(request, response);
		}
	}
}