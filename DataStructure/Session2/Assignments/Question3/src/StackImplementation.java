/**
 * @author Ramdev
 * StackOperation class implements the Stack interface and give definition to its operational functions
 * @param <T>
 *
 */
public class StackImplementation<T> implements Stack
{
	final int SIZE = 1000;
	private int top = -1;
	private T[] stack = ((T[]) new Object[this.SIZE]);

	@Override
	public Object pop() throws Exception 
	{
		if(this.top == -1) 
		{
			throw new Exception("Stack underflowed");
		}
		return this.stack[this.top--];
	}
	
	@Override
	public boolean push(Object object) throws Exception 
	{
		if(this.top == this.SIZE - 1) 
		{
			throw new Exception("Stack overflowed");
		}
		this.stack[++this.top] = (T) object;
		return true;
	}
	
	@Override
	public boolean isEmpty() 
	{
		if(this.top == -1)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public Object peek() throws Exception 
	{
		if(isEmpty())
		{
			throw new Exception("Stack underflowed");
		}
		return this.stack[top];
	}
	@Override
	public void display() 
	{
		for(int i = 0; i <= top; i++)
			System.out.print(stack[i] + ", ");		
	}
}