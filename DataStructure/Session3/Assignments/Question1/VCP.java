package question1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Ramdev
 * Implements a virtual command prompt
 *
 */
public class VCP 
{

	Folder currentFolder;
	List<String> foldersHierarchy = new ArrayList<String>();

	/**
	 * @return currentFolder, in which folder you are working currently
	 */
	public Folder getCurrentFolder() 
	{
		return currentFolder;
	}

	/**
	 * To set current folder
	 * @param currentFolder
	 */
	public void setCurrentFolder(Folder currentFolder) 
	{
		this.currentFolder = currentFolder;
	}

	/**
	 * To get folder hierarchy
	 * @return List folder
	 */
	public List<String> getFolders() 
	{
		return foldersHierarchy;
	}

	/**
	 * Constructor
	 */
	public VCP() {
		currentFolder = new Folder("R");// root folder(Directory) created
	}

	/**
	 * Flow of Virtual command prompt will start from here
	 */
	public void runVcp() {
		try {
			String inputCommand;
			Scanner input = new Scanner(System.in);

			while (true) {
				printPath();
				inputCommand = input.nextLine();
				String[] commands = inputCommand.split(" ");
				if (commands.length == 1) 
				{
					switch (commands[0]) 
					{
						case "bk":
							bk();
							break;

						case "ls":
							ls();
							break;

						case "tree":
							tree();
							break;
						case "exit":
							System.exit(0);
							break;

						default:
							System.out.println("Command Not found");
					}
				}
				else if (commands.length == 2) 
				{
					switch (commands[0]) 
					{
						case "mkdir":
							mkdir(commands[1]);
							break;

						case "cd":
							cd(commands[1]);
							break;

						case "find":
							find(commands[1]);
							break;

						default:
							System.out.println("Command Not found");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * To make new directory in VCP
	 * @param folderName is new folder name which is going to be create in this current folder
	 */
	public void mkdir(String folderName) 
	{
		try {
			if (folderName == null) 
			{
				System.out.print("folder name can't be null");
			} else 
			{
				boolean status = this.getCurrentFolder().mkdir(folderName);
				if (status == false) 
				{
					System.out.println("folder already exist with same name then new folder will not create");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * To change directory
	 * @param folderName is sub folder name which is going to be current folder now
	 */
	public void cd(String folderName) 
	{
		try {
			if (folderName == null) 
			{
				System.out.print("folder name can't be null");
			} else 
			{
				Folder subFolder = this.getCurrentFolder().cd(folderName);
				if (subFolder != null) 
				{
					this.setCurrentFolder(subFolder);
					this.foldersHierarchy.add(subFolder.getFolderName());
				} else 
				{
					System.out.println("folder doesn't exist with this name");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * To find a folder in its sub folders or its subfolder's sub folders
	 * @param folderName is for finding folder recursively in current folder in it's
	 *                   sub folder as well
	 */
	public void find(String folderName) 
	{
		try {
			if (folderName == null) 
			{
				System.out.print("folder name can't be null");
			} 
			else 
			{
				Folder foundFolder = this.getCurrentFolder().find(folderName);
				if (foundFolder != null) 
				{
					String path = getPathOfFolder(foundFolder);
					System.out.println(path);
				} else 
				{
					System.out.println("Not Found");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * To get path of folder
	 * @param foundFolder is for finding path of given folder
	 * @param path is the path of foundFolder in string form
	 */
	private String getPathOfFolder(Folder foundFolder) 
	{
		String path = null;
		try {
			Folder currentFolder = foundFolder;
			
			 // making a stack for maintaining the hierarchy 
			Stack<String> foldersHierarchy = new Stack<String>();
			path = new String(" ");

			while (currentFolder != null) {
				foldersHierarchy.push(currentFolder.getFolderName());
				currentFolder = currentFolder.getRootFolder();
			}
 
			while (!foldersHierarchy.empty()) 
			{
				path = path + "/" + foldersHierarchy.pop();// adding folder in path
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

	/**
	 * Moving form current directory to it's parent directory
	 */
	public void bk() 
	{
		try {
			if (this.getCurrentFolder().getRootFolder() != null) 
			{
				
				this.setCurrentFolder(this.getCurrentFolder().getRootFolder());

				this.foldersHierarchy.remove(this.foldersHierarchy.size() - 1);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * To print all the subFolder in this folder
	 */
	public void ls() 
	{
		try {
			List<Folder> subFolders = this.getCurrentFolder().ls();
			for (Folder subFolder : subFolders) 
			{
				System.out.println(subFolder.getDateAndTime() + "  " + subFolder.getFolderName());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * To print tree structure 
	 * @throws Exception print the tree
	 */
	public void tree() throws Exception 
	{
		printTree(this.getCurrentFolder(), 0);
	}

	/**
	 * To display the tree of the given directory
	 * @param currentDirectory
	 * @param nesting is the level of the subfolder
	 */
	private void printTree(Folder currentDirectory, int nesting) 
	{
		try {
			if (currentDirectory == null) 
			{
				System.out.print("directory can't be null");
			} else 
			{
				for (Folder subDirectory : currentDirectory.getSubFolders()) 
				{
					for (int i = 0; i < nesting; i++)
						System.out.print("|    ");
					if (subDirectory.getSubFolders().size() != 0) 
					{
						System.out.println("|___" + subDirectory.getFolderName());
						printTree(subDirectory, nesting + 1);
					} else
						System.out.println("|___" + subDirectory.getFolderName());
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * To print the whole path of current working directory
	 */
	private void printPath() 
	{
		try {
			System.out.print("R:");
			for (String folderName : this.getFolders())
			{
				System.out.print("\\" + folderName);
			}
			System.out.print(">");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		VCP command = new VCP();
		command.runVcp();
	}

}