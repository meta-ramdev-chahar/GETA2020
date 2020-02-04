

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		try
		{
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement st = con.prepareStatement("delete from student where id = ?"); 
			st.setInt(1, Integer.parseInt(id));
			st.execute();
			out.println("<html><body><b>SuccesFully Deleted"+ "</b></body></html>");
			con.close();
			st.close();
			
		}
		catch(Exception e)
		{
			 out.println("<html><body><b>operation Deletion faild"+ "</b></body></html>");
			 e.printStackTrace();
		}
	}

}
