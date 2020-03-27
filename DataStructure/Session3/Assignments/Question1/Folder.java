package question1;

import java.util.*;

/**
 * @author Ramdev
 * Folder class will manage the folder, sub folders and the methods to operate will folders
 *
 */
public class Folder 
{
	String folderName;
	List<Folder> subFolders;
	Folder rootFolder;
	Date dateAndTime;

	/**
	 * @param name : name of newly created folder.
	 */
	Folder(String name) 
	{
		this.folderName = name;
		subFolders = new LinkedList<Folder>();
		this.rootFolder = null;
		this.dateAndTime = Calendar.getInstance().getTime();
	}

	/**
	 * To implement mkdir command in VCP
	 * @param folderName 
	 */
	public boolean mkdir(String folderName)
	{
		try {
			Folder subFolder = findSubDirectory(folderName);
			if (subFolder != null) 
			{
				return false;
			} else 
			{
				subFolder = new Folder(folderName);
				subFolder.setRootFolder(this);
				this.subFolders.add(subFolder);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * To implement cd (change directory) in VCP 
	 * @param subFolderName : name of the subFolder to change the directory
	 * @return subFolder if exist else return "null"
	 */
	public Folder cd(String subFolderName) throws Exception 
	{
		return findSubDirectory(subFolderName);
	}

	/**
	 * To implement bk(back) command in VCP
	 * @return the root folder bk stands for back
	 */
	public Folder bk() throws Exception 
	{
		return this.getRootFolder();
	}

	/**
	 * To print list of all folders in a folder
	 * @return subFolders of this folder
	 */
	public List<Folder> ls() throws Exception 
	{
		return this.getSubFolders();
	}

	/**
	 * To find a subFolder in the sub folders of current folder and sub folders of its sub folder's
	 * @param subFolderName which we need to find recursively in subFolders
	 * @return foundSubFolder if folder exist else null
	 */
	public Folder find(String subFolderName) 
	{
		try {
			List<Folder> subFolders = this.getSubFolders();
			
			Folder foundFolder;
			
			for (Folder subFolder : subFolders) 
			{
				if (subFolderName.equals(subFolder.getFolderName())) 
				{
					return subFolder;
				}
			}
			for (Folder subFolder : subFolders) {

				foundFolder = subFolder.find(subFolderName);
				if (foundFolder != null) 
				{
					return foundFolder;
				}
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * To find a folder in sub folders by its name
	 * @param folderName : it is the name of the folder to find in the directory
	 * @return the reference of the sub folder with the name as @param folderName
	 */
	public Folder findSubDirectory(String folderName) 
	{
		try {
			for (Folder subFolder : this.getSubFolders()) 
			{
				if (folderName.equals(subFolder.getFolderName())) 
				{
					return subFolder;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @return the name of the current folder name.
	 */
	public String getFolderName() throws Exception 
	{
		return folderName;
	}

	/**
	 * @param folderName is the name of the folder that is going to be 
	 * 			set as the name of the current folder.
	 */
	public void setFolderName(String folderName) throws Exception 
	{
		this.folderName = folderName;
	}

	/**
	 * @return the list of sub folders of the current parent folder.
	 */
	public List<Folder> getSubFolders() throws Exception 
	{
		return subFolders;
	}

	/**
	 * @param subFolders set the list of sub folders to the current folder.
	 */
	public void setSubFolders(List<Folder> subFolders) throws Exception 
	{
		this.subFolders = subFolders;
	}

	/**
	 * @return the parent folder.
	 */
	public Folder getRootFolder() throws Exception 
	{
		return rootFolder;
	}

	/**
	 * @param rootFolder is the folder that is going to be the root folder.
	 */
	public void setRootFolder(Folder rootFolder) throws Exception 
	{
		this.rootFolder = rootFolder;
	}

	/**
	 * @return the Date and Time
	 */
	public Date getDateAndTime() throws Exception 
	{
		return dateAndTime;
	}
}