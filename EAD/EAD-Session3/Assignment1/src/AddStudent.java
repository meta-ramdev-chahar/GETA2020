
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudent
 */
public class AddStudent extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
		PrintWriter out = response.getWriter();        
		String firstName = request.getParameter("firstName");  
		String lastName = request.getParameter("lastName");  
		String fatherName = request.getParameter("fatherName");
		String email = request.getParameter("email");
		String classOfStudent = request.getParameter("class");
		String age = request.getParameter("age");

		try
		{	
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement st = con.prepareStatement("insert into student(first_name, last_name, father_name, email, class, age) values(?, ?, ?, ?, ?, ?)"); 

			st.setString(1, firstName);
			st.setString(2, lastName);
			st.setString(3, fatherName);
			st.setString(4, email);
			st.setString(5, classOfStudent);
			st.setInt(6, Integer.parseInt(age));

			st.executeUpdate();
			st.close();
			con.close();
			out.println("<html><body><b>Successfully Inserted "+ "</b></body></html>");
		}
		catch(Exception e)
		{
			out.println("<html><body><b>operation faild"+ "</b></body></html>");
			e.printStackTrace();	  
		} 
	}

}
