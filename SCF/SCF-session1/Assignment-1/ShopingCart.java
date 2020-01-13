import java.util.*;
/**represent the Shoping Cart
 * @author Ramdev
 * this class have an another class "Item",
 */
public class ShopingCart 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		ShopingCart cart = new ShopingCart();
		int choice = 0,ID = 0,quantity;
		boolean flag = true;
		while( flag )
		{
			System.out.println("Enter the operation your want to perform");
			System.out.println("1. Add item");
			System.out.println("2. Remove item");
			System.out.println("3. Update Quantity");
			System.out.println("4. Display the Items");
			System.out.println("5. Generate the Bill");
			System.out.println("6. if you are done !");
			choice = input.nextInt();
			switch( choice )
			{
			   case 1:  ShopingCart.showItems();
			   			System.out.println("Select the ID of Item your want to add");
			   			ID = input.nextInt();
			   			System.out.println("Enter the Quantity of the Item "+itemList[ID-1]);
			   			quantity = input.nextInt();
			   			cart.addItem(itemList[ID-1], itemPrices[ID-1], quantity);
			   			break;
			   case 2:  cart.displayItems();
						System.out.println("Select the ID of Item you want to remove ");
						ID = input.nextInt();
						cart.removeItem(ID);
				   		break;
			   case 3:  cart.displayItems();
	   					System.out.println("Select the ID of Item your whoose quantity you want to update");
	   					ID = input.nextInt();
	   					System.out.println("Enter the update Quantity of the Item "+cart.items[ID-1].name);
	   					quantity = input.nextInt();
	   					if(quantity == 0)
	   						cart.removeItem(ID);
	   					else
	   					    cart.updateQuantity(cart.items[ID-1].name,quantity);
	   					break;
			   case 4: 	cart.displayItems();
			   			break;
			   case 5: 	System.out.println("your total bill is " + cart.getBill());
			   			break;
			   case 6: 	flag = false;
			   			break;
			   default: System.out.println("please Input right choice ");		   			
			}
		}
	}
	private int noOfItems;
	private int typesOfItems;
	private float billOfCart;
	static String itemList[] = {"mango","apple","banana","orange","pinapple"}; 
	static float itemPrices[] = {30.0f,45.8f,23.6f,54.0f,78.09f};
	
	public ShopingCart()
	{
		noOfItems = 0;
		typesOfItems = 0;
		billOfCart = 0;
	}
	/** represent a item in Shoping cart
	 * @author Ramdev
	 */
	class Item
	{
		String name;
		float price;
		int quantity;
		public Item(String name,float price,int quantity)
		{
			this.name = name;
			this.price = price;
			this.quantity = quantity;
		}
	}
	/*
	 * the size of Item array is fixed at 5 because list of select able items is also 5
	 */
	public Item items[] = new Item[5]; 
	
	/** Add a item into the cart 
	 * 
	 * @param aName
	 * @param aPrice
	 * @param aQuantity
	 * @return Add a item if it is not in the cart, if it is already the in cart then increase the quantity  
	 */
	void addItem(String aName, float aPrice, int aQuantity)
	{
		int indexOfItem = searchIteam(aName);
		
		if(indexOfItem >= 0)
		{
			items[indexOfItem].quantity += aQuantity;
			noOfItems += aQuantity;
			billOfCart += aPrice*aQuantity;
		}
		else
		{
			Item item = new Item(aName,aPrice,aQuantity);
			items[typesOfItems] = item;
			noOfItems += aQuantity;
			typesOfItems += 1;
			billOfCart += aPrice*aQuantity;
		}
	}
	/** to remove any item from cart/ item list 
	 * 
	 * @param ID
	 * @return remove the item from Item list if it is available 
	 */
	
	void removeItem(int ID)
	{
		if(ID < 0 || ID > typesOfItems)
		{
			System.out.println("wrong Entery found");
		}
		else
		{
			noOfItems -= items[ID-1].quantity;
			billOfCart -= (items[ID-1].price)*(items[ID-1].quantity);
			while( ID < typesOfItems )
			{
				items[ID-1] = items[ID];
				ID += 1;
			}
			typesOfItems -= 1;
		}
	}
	/** 
	 * display the items of cart
	 */
	void displayItems()
	{
		System.out.println("ID      Name       Price	quantity");
		for(int iterator = 0; iterator < typesOfItems; iterator++)
		{
			System.out.println((iterator + 1) + "		" + items[iterator].name+"	   "+items[iterator].price+"	  "+items[iterator].quantity);
		}
	}
	/**
	 * 
	 * @return total bill of cart
	 */
	
	float getBill()
	{
		return billOfCart;
	}
	/** update the quantity of any item in the cart
	 * 
	 * @param uName
	 * @param uQuantity
	 */
	void updateQuantity(String uName, int uQuantity)
	{
		if(uQuantity < 0)
		{
			System.out.println("Wrong entry found.");
		}
		else
		{
			int n = searchIteam(uName);
			if(n != -1)
			{
				billOfCart -= billOfCart - items[n].price*items[n].quantity + items[n].price*uQuantity;
				noOfItems  -= noOfItems  - items[n].quantity + uQuantity;
				items[n].quantity = uQuantity;
			}
			else
			{
				System.out.println("item doesnot exists ");
			}
		}
	}
	/**
	 * 
	 * @param sName represents search name
	 * @return the index of item if it is available in the cart else return -1  
	 */
	int searchIteam(String sName)
	{
		for(int iterator = 0; iterator < typesOfItems; iterator++)
		{
			if(items[iterator].name == sName)
			{
				return iterator;
			}
		}
		return -1;
	}
	/**
	 * shows all the choices of items that could be added in to the cart 
	 */
	public static void showItems()
	{
		System.out.println("ID      Name       Price");
		for(int iterator = 0; iterator < itemList.length; iterator++)
		{
			System.out.println(( iterator + 1 ) +". 	 "+itemList[iterator]+"	   "+itemPrices[iterator]);
		}
	}	
}