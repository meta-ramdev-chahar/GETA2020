
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
/**
 * 
 * @author Ramdev
 * Implement the Dictionary interface using BST
 */
public class MyDictionary implements Dictionary<Integer, String> 
{	
	/**
	 * 
	 * @author Ramdev
	 * A KeyValue pair in Dictionary
	 */
	public class KeyValue
	{
		int key;
		String value;
		KeyValue left;
		KeyValue right;

		public KeyValue(int key, String value)
		{
			this.key = key;
			this.value = value;
		}
	}

	KeyValue root;


	public MyDictionary(JSONObject listOfkeyValuePairs) 
	{
		this.root = null;
		for(Object key : listOfkeyValuePairs.keySet())
		{
			this.add((Integer)key, (String)listOfkeyValuePairs.get(key));
		}
	}

	@Override
	public void add(Integer key, String value)
	{
		root = addToDict(root, key, value);
		System.out.println("Ïnsertation Succesfull");
	}
	
	/**
	 * To add a Key value pair to the dictionary 
	 * @param root2
	 * @param key
	 * @param value
	 * @return
	 */
	private KeyValue addToDict(KeyValue root2, int key, String value) 
	{
		/* If the tree is empty, return a new node */
		if (root2 == null) { 
			root2 = new KeyValue(key, value); 
			return root2; 
		} 

		/* Otherwise, recur down the tree */
		if (key < root2.key) 
			root2.left = addToDict(root2.left, key, value); 
		else if (key > root2.key) 
			root2.right = addToDict(root2.right, key, value); 

		/* return the (unchanged) node pointer */
		return root2;
	}

	@Override
	public void delete(Integer key) 
	{
		root = deleteFromDict(root, key);
		if(root == null)
		{
			System.out.println("No value is found to delete");
		}
		System.out.println("Deletion Succesfull");

	}
	
	/**
	 * To delete a key value pair from the dictionary using key
	 * @param root2
	 * @param key
	 * @return
	 */
	private KeyValue deleteFromDict(KeyValue root2, Integer key)
	{
		if (root2 == null)  return root2; 

		if (key < root2.key) 
			root2.left = deleteFromDict(root2.left, key); 
		else if (key > root2.key) 
			root2.right = deleteFromDict(root2.right, key);   
		else
		{ 
			// node with only one child or no child 
			if (root2.left == null) 
				return root2.right; 
			else if (root2.right == null) 
				return root2.left; 

			// node with two children: Get the inorder successor (smallest 
			// in the right subtree) 
			int tempkey = minValue(root2.right); 
			root2.value = this.get(tempkey);
			root2.key = tempkey;

			// Delete the inorder successor 
			root2.right = deleteFromDict(root2.right, root2.key); 
		} 

		return root2;
	}

	/**
	 * To Get the inorder successor (smallest in the right subtree)
	 * @param right
	 * @return
	 */
	private int minValue(KeyValue right)
	{
		int minv = right.key; 
		while (right.left != null) 
		{ 
			minv = right.left.key; 
			right = right.left; 
		} 
		return minv;
	}
	
	@Override
	public String get(Integer key)
	{
		KeyValue serchResult = searchInDict(root, key); 
		if(serchResult == null)
			return null;
		return serchResult.value;
	}
	
	/**
	 * To search a element in dictionary
	 * @param root2
	 * @param key
	 * @return
	 */
	private KeyValue searchInDict(KeyValue root2, int key) 
	{
		if(key == root2.key) 
			return root2;
		else if(key < root.key )
			return searchInDict(root2.left, key);
		else if(key > root.key)
			return searchInDict(root2.right, key);
		return null;
	}

	@Override
	public List<Pair<Integer, String>> getSortedListOfKeyValuePairs() 
	{
		List<Pair<Integer, String>> resutltSortedListOfKeyValuePairs = new ArrayList<>();
		getInorderTraversalList(resutltSortedListOfKeyValuePairs, root);
		return resutltSortedListOfKeyValuePairs;
	}

	/**
	 * To inorder traverse a whole dictionary
	 * @param resutltSortedListOfKeyValuePairs
	 * @param root2
	 */
	private void getInorderTraversalList( List<Pair<Integer, String>> resutltSortedListOfKeyValuePairs, KeyValue root2) 
	{
		if (root2 != null) 
		{ 
			getInorderTraversalList(resutltSortedListOfKeyValuePairs, root2.left); 
			resutltSortedListOfKeyValuePairs.add(new Pair<Integer, String>(root2.key, root2.value)); 
			getInorderTraversalList(resutltSortedListOfKeyValuePairs, root2.right); 
		} 
	}

	@Override
	public List<Pair<Integer, String>> getSortedListOfKeyValuePairs(Integer keyA, Integer keyB) 
	{
		List<Pair<Integer, String>> resutltSortedListOfKeyValuePairs = new ArrayList<>();
		getInorderTraversalList(resutltSortedListOfKeyValuePairs, root, keyA, keyB);
		return resutltSortedListOfKeyValuePairs;

	}
	
	/**
	 * To inorder traverse a  dictionary in given key range
	 * @param resutltSortedListOfKeyValuePairs
	 * @param root2
	 * @param keyA
	 * @param keyB
	 */
	private void getInorderTraversalList(List<Pair<Integer, String>> resutltSortedListOfKeyValuePairs, KeyValue root2, Integer keyA, Integer keyB) 
	{
		if (root2 != null) 
		{     
			getInorderTraversalList(resutltSortedListOfKeyValuePairs, root2.left, keyA, keyB);
			if(root2.key >= keyA && root2.key <= keyB)
				resutltSortedListOfKeyValuePairs.add(new Pair<Integer, String>(root2.key, root2.value));
			getInorderTraversalList(resutltSortedListOfKeyValuePairs, root2.right, keyA, keyB); 
		} 
	}

	public static void main(String args[])
	{
		JSONObject jobj = new JSONObject();
		/**
		 * Initial values
		 */
		jobj.put(3, "sample3");
		jobj.put(2, "sample2");
		jobj.put(4, "sample4");
		jobj.put(1, "sample1");
		
		MyDictionary obj = new MyDictionary(jobj);
		
		/**
		 * Adding new values
		 */
		obj.add(5, "sample5");
		obj.add(6, "sample6");
		obj.add(7, "sample7");
		obj.add(8, "sample8");
		obj.add(9, "sample9");
		obj.add(10, "sample10");
		
		/**
		 * Deleting values
		 */
		obj.delete(2);
		
		/**
		 * Sorting List of whole Dictionary
		 */
		List<Pair<Integer, String>> ls = obj.getSortedListOfKeyValuePairs();

	    for(Pair p: ls)
	    {
	    	System.out.println(p.getL() +":"+ p.getR());
	    }
	    
	    /**
	     * Sorting List of only given range of keys
	     */
		List<Pair<Integer, String>> ls2 = obj.getSortedListOfKeyValuePairs(6,8);

		for(Pair p: ls2)
		{
			System.out.println(p.getL() +":"+ p.getR());
		}
	}

}
