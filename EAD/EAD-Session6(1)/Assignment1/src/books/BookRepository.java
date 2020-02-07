package books;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
/**
 * 
 * @author Ramdev
 * Implements the methods for database operations on table Book in database 
 * 
 */
public class BookRepository 
{

	List<Book> books;
	Connection con = null;

	/**
	 * Create a book repository
	 */
	public BookRepository()
	{		
		String url = "jdbc:mysql://localhost:3306/books";
		String uname = "root";
		String pass = "rama429874";	
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");		
			con = DriverManager.getConnection(url,uname,pass);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * To get all the books from database
	 * @return List of books
	 */
	public List<Book> getBooks()
	{
		List<Book> books = new ArrayList<>();
		String query1 = "select * from book";
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query1);
			while(rs.next())
			{
				Book a = new Book();
				a.setId(rs.getInt(1));
				a.setTitle(rs.getString(2));
				a.setWriter(rs.getString(3));
				a.setPublisher(rs.getString(4));
				a.setPublishedYear(rs.getInt(5));

				books.add(a);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return books; 
	}
	/**
	 * To get a book by its title
	 * @param title
	 * @return Book object
	 */
	public Book getBook(String title)
	{
		String query1 = "select * from book where title='"+title+"'";
		Book book = new Book();
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query1);
			if(rs.next())
			{
				book.setId(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setWriter(rs.getString(3));
				book.setPublisher(rs.getString(4));
				book.setPublishedYear(rs.getInt(5));			
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return book; 
	}
	/**
	 * To get a book by its ID
	 * @param id of book
	 * @return Book object
	 */
	public Book getBookById(int id)
	{
		String query1 = "select * from book where id="+id;
		Book a = new Book();
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query1);
			if(rs.next())
			{
				a.setId(rs.getInt(1));
				a.setTitle(rs.getString(2));
				a.setWriter(rs.getString(3));
				a.setPublisher(rs.getString(4));
				a.setPublishedYear(rs.getInt(5));			
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a; 	
	}
	/**
	 * To create/add a new book in database
	 * @param book : Object of Book
	 */
	public void create(Book book)
	{
		String query1 = "insert into book values(?,?,?,?,?)";
		try{
			PreparedStatement st = con.prepareStatement(query1);
			st.setInt(1, book.getId());
			st.setString(2, book.getTitle());
			st.setString(3, book.getWriter());
			st.setString(4, book.getPublisher());
			st.setInt(5, book.getPublishedYear());

			st.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	/**
	 * To update a book by title and published year using id
	 * @param book : Object of Book
	 */
	public void update(Book book)
	{
		//String query1="update book set title=?,writer=? where id=? ";
		String query1 = "update book set title=?,publishedyear=? where id=?";
		try{
			PreparedStatement st = con.prepareStatement(query1);
			st.setString(1, book.getTitle());
			st.setInt(2, book.getPublishedYear());
			st.setInt(3, book.getId());			
			st.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * To delete all the books from database
	 */
	public void deleteAll() 
	{
		String query1 = "delete from book";
		try{
			PreparedStatement st = con.prepareStatement(query1);
			st.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * To delete a book from database using its id
	 * @param id : Book's id
	 */
	public void deleteOne(int id) {
		String query1 = "delete from book where id=?";
		try{
			PreparedStatement st = con.prepareStatement(query1);
			st.setInt(1,id);
			st.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}
