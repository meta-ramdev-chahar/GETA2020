import java.util.List;

/**
 * 
 * @author Ramdev
 * Define the interface for a dictionary
 */
public interface Dictionary<KEY, VALUE>
{
	public void add(KEY key, VALUE value);

	public void  delete(KEY key);

	public VALUE get(KEY key);

	public List<Pair<KEY,VALUE>> getSortedListOfKeyValuePairs();

	public List<Pair<KEY,VALUE>> getSortedListOfKeyValuePairs(KEY keyA, KEY keyB);
}
