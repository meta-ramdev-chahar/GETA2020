package books;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 
 * @author Ramdev
 * Implement the RESTFull API of book 
 */
@Path("/books")
public class BookResource 
{

	BookRepository repository = new BookRepository();

	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Book> getBooks()
	{
		return repository.getBooks();
	}

	@GET
	@Path("/{title}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Book getBook(@PathParam("title") String title)
	{
		return repository.getBook(title);
	}

	@POST
	public Book createBook(Book book)
	{
		repository.create(book);
		return book;
	}

	@PUT
	public void updateBook(Book book)
	{
		repository.update(book);
	}

	@DELETE
	public void deleteBooks()
	{
		repository.deleteAll();
	}
	
	@DELETE
	@Path("/{id}")
	public Book deleteOneBook(@PathParam("id") int id)
	{
		Book book = repository.getBookById(id);
		repository.deleteOne(id);
		return book;
	}
}
