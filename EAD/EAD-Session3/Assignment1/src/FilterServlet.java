

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

/**
 * Servlet implementation class FilterServlet
 */

public class FilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		try
		{
			Connection con = DatabaseConnection.initializeDatabase();
			String classOfStudent = request.getParameter("classOfStudent");
			PreparedStatement st = con.prepareStatement("select * from student where class = ?"); 
			st.setString(1, classOfStudent);
			ResultSet rs = st.executeQuery();
			request.setAttribute("students", rs);
			request.getRequestDispatcher("myWebContent/showStudents.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			out.println("<html><body><b>operation Filter Students faild"+ "</b></body></html>");
			e.printStackTrace();
			
		}
	}
}


