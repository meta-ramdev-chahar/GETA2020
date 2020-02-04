

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchStudent
 */

public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		try 
	    {
			Connection con = DatabaseConnection.initializeDatabase();
			String name = request.getParameter("name");
			PreparedStatement st = con .prepareStatement("select * from student where first_name = ? or last_name = ?"); 
			st.setString(1, name);
			st.setString(2, name);
			ResultSet rs = st.executeQuery();
			request.setAttribute("students", rs);
			request.getRequestDispatcher("myWebContent/showStudents.jsp").forward(request, response);
			st.close();
			con.close();
		} 
	    catch (Exception e) 
	    {
		    out.println("<html><body><b>operation Search student Students faild"+ "</b></body></html>");
			e.printStackTrace();
		} 
	}


}
