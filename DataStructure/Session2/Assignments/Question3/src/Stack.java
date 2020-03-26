/**
 * @author Ramdev
 * Stack interface defines the methods of stack
 *
 */
public interface Stack<T> 
{

	/**
	 * To remove element from the top of the stack
	 * @return the popped element from stack
	 * @throws Exception 
	 */
	 public T pop() throws Exception;

	/**
	 * To push the element to the stack
	 * @param <T>
	 * @param c : the element to be pushed into the stack
	 * @return true if successfully inserted
	 */
	 public boolean push(T object) throws Exception;

	/**
	 * @return true if the stack is empty
	 */
	 public boolean isEmpty();

	/**
	 * @return the Top most element of the stack
	 */
	 public T peek()throws Exception;

	/**
	 * display all the element of stack;
	 */
	 public void display();

}