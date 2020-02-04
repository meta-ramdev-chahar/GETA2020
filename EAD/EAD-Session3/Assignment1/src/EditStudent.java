

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

/**
 * Servlet implementation class EditStudent
 */
public class EditStudent extends HttpServlet {
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
			Integer id = Integer.parseInt(request.getParameter("id"));

			PreparedStatement st = con .prepareStatement("select * from student where id = ?"); 
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			request.setAttribute("student", rs);
			request.getRequestDispatcher("myWebContent/updateStudent.jsp").forward(request, response);
			con.close();
		} 
	    catch (Exception e) 
	    {
		    out.println("<html><body><b>operation Edit student Students faild"+ "</b></body></html>");
			e.printStackTrace();
		} 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		  PrintWriter out = response.getWriter();  
		  String id = request.getParameter("id");
		  String firstName = request.getParameter("firstName");  
		  String lastName = request.getParameter("lastName");  
		  String fatherName = request.getParameter("fatherName");
		  String email = request.getParameter("email");
		  String classOfStudent = request.getParameter("class");
		  String age = request.getParameter("age");
		  
		  try
		  {
			  Connection con = DatabaseConnection.initializeDatabase();
			  PreparedStatement st = con.prepareStatement("update student set first_name = ?, last_name = ?, father_name = ?, email = ?, class = ?, age = ? where id = ?"); 
	 
	          st.setString(1, firstName);
	          st.setString(2, lastName);
	          st.setString(3, fatherName);
	          st.setString(4, email);
	          st.setString(5, classOfStudent);
	          st.setInt(6, Integer.parseInt(age));
	          st.setInt(7,Integer.parseInt(id));
	          st.executeUpdate();
			  st.close();
	          con.close();
			  out.println("<html><body><b>Successfully Updated "+ "</b></body></html>");
		  }
		  catch(Exception e)
		  {
			  out.println("<html><body><b>operation faild"+ "</b></body></html>");
			  e.printStackTrace();	  
		  } 
	}

}
