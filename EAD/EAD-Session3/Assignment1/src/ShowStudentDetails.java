import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowStudentDetails
 */
public class ShowStudentDetails extends HttpServlet {
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
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");
			request.setAttribute("students", rs);
			request.setAttribute("callingServlet","showAllStudent" );
			request.getRequestDispatcher("myWebContent/showStudents.jsp").forward(request, response);
			stmt.close();
			con.close();
		} 
	    catch (Exception e) 
	    {
		    out.println("<html><body><b>operation Show Students faild"+ "</b></body></html>");
			e.printStackTrace();
		} 
	}

}
