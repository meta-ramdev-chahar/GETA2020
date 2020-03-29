/**
 * 
 * @author Ramdev
 * Implement the Method getMass to get the mass of a Organic compound formula
 */
public class OrganicCompound 
{
	final int C, O, H;  
	
	public OrganicCompound()
	{
		this.C = 12;
		this.H = 1;
		this.O = 16;
		
	}
	/**
	 * To get the mass of formula in string format
	 * @param formula : String
	 * @return the mass in integer
	 */
	public int getMass(String formula)
	{
		formula = formula.replaceAll(" ", "");
		int mass = 0;
		int prev = 0;
		int index = 0;
		while(index < formula.length())
		{
			System.out.println(formula.charAt(index));
			if(formula.charAt(index) == 'C')
			{
				mass += C;
				prev = C;
				index++;
			}
			else if(formula.charAt(index) == 'H')
			{
				mass += H;
				prev = H;
				index++;
			}
			else if(formula.charAt(index) == 'O')
			{
				mass += O;
				prev = O;
				index++;
			}
			else if(formula.charAt(index) >= '0' && formula.charAt(index) <= '9' )
			{
			    StringBuffer stringBuffer = new StringBuffer();
			   
			    while (index < formula.length() && formula.charAt(index) >= '0' && formula.charAt(index) <= '9')
			        stringBuffer.append(formula.charAt(index++));
			    
			    mass = mass - prev + prev * Integer.parseInt(stringBuffer.toString());
			}
			else if(formula.charAt(index) == '(')
			{
				index++;
				int count = 1;
				StringBuffer stringBuffer = new StringBuffer();
				while(count != 0)
				{
					if(formula.charAt(index) == '(')
						count++;
					else if(formula.charAt(index) == ')')
						count--;
					else
						stringBuffer.append(formula.charAt(index));
					index++;
				}
				StringBuffer temp = new StringBuffer();
				if(count == 0)
				{
					while (index < formula.length() && formula.charAt(index) >= '0' && formula.charAt(index) <= '9')
				        temp.append(formula.charAt(index++));
				}
				mass += (getMass(stringBuffer.toString()) * Integer.parseInt(temp.toString()));
			}
		
		}
		return mass;
	}
	public static void main(String args[])
	{
		OrganicCompound og = new OrganicCompound();
		System.out.print(og.getMass("CHOC(CH3)3"));
	}
}	