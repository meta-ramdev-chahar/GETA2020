import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;
import java.io.IOException;  

import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  

import org.apache.poi.ss.usermodel.Row;

/**
 * 
 * @author Ramdev
 * CounselingProcess Class implements the counseling process of a college
 * 
 */
public class CounselingProcess  
{  
	/**
	 * To get the List of All programs with their capacity in a HashMap from a excel file
	 * @return HashMap
	 * @throws IOException if no file found at given path
	 */
	public HashMap<String, Double> getPrograms(String path) throws IOException  
	{  
		HashMap<String, Double> programs = new HashMap<>();

		FileInputStream fis = new FileInputStream(new File(path));  

		HSSFWorkbook workbook = new HSSFWorkbook(fis);   

		HSSFSheet sheet = workbook.getSheetAt(0);  

		for(Row row: sheet)     
		{   
			programs.put(row.getCell(0).getStringCellValue(), row.getCell(1).getNumericCellValue());	  
		}  
		return programs;
	}  

	/**
	 * To get Result Of counseling
	 * @param programs
	 * @param path
	 * @throws IOException
	 */
	public void getCounselingResult(HashMap<String, Double> programs, String pathOfStudentFile) throws IOException
	{
		HashMap<String, String> resultFile = new HashMap<>();

		FileInputStream fis = new FileInputStream(new File(pathOfStudentFile));  

		HSSFWorkbook workbook = new HSSFWorkbook(fis);   

		HSSFSheet sheet = workbook.getSheetAt(0);

		for(Row row: sheet)
		{
			String student = row.getCell(0).getStringCellValue();
			String firstOption = row.getCell(1).getStringCellValue();
			String secondOption = row.getCell(2).getStringCellValue();
			String thirdOption = row.getCell(3).getStringCellValue();

			if( programs.get(firstOption) > 0.0)
			{
				programs.put(firstOption, programs.get(firstOption) - 1);
				resultFile.put(student, firstOption);
			}
			else if (programs.get(secondOption) > 0.0)
			{
				programs.put(secondOption, programs.get(secondOption) - 1);
				resultFile.put(student, secondOption);
			}
			else if (programs.get(thirdOption) > 0.0)
			{
				programs.put(thirdOption, programs.get(thirdOption) - 1);
				resultFile.put(student, thirdOption);
			}

		}
		this.writeExcelFile(resultFile);

	}
	
	/**
	 * 
	 * To Write Excel File From a HashMap
	 * @param resultFile : HashMap 
	 */
	private void writeExcelFile(HashMap<String, String> resultFile)
	{

		HSSFWorkbook newWorkbook = new HSSFWorkbook();   

		HSSFSheet newSheet = newWorkbook.createSheet("resultSheet");

		int rowNumber = 0;

		for(String student: resultFile.keySet())
		{
			Row row = newSheet.createRow(rowNumber++);

			Cell cell = row.createCell(0);
			cell.setCellValue(student);

			cell = row.createCell(1);
			cell.setCellValue(resultFile.get(student));
		}

		try { 
			FileOutputStream out = new FileOutputStream(new File("resultFile.xls")); 
			newWorkbook.write(out); 
			out.close(); 
			System.out.println("resultFile.xls written successfully on disk."); 
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		}	
	}

	public static void main(String args[])
	{
		String pathOfProgramFile = "C://Users//Ramdev//Desktop//programs.xls";
		String pathOfStudentFile = "C://Users//Ramdev//Desktop//students.xls";
		CounselingProcess cs = new CounselingProcess();
		HashMap<String, Double> programs = null;
		try
		{
			programs = cs.getPrograms(pathOfProgramFile);
			cs.getCounselingResult(programs,pathOfStudentFile);
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
	}
}  


