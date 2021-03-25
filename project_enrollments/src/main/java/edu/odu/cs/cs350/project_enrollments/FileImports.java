package edu.odu.cs.cs350.project_enrollments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileImports {
	public static void findFile(String path) {	
	    File directoryPath = new File(path);	    
	    File filesList[] = directoryPath.listFiles();
	    
	    for(File file : filesList) {
	    		System.out.println("File name: "+file.getName() + "\n");
	    
	    		try {
	    			if("dates.txt" != file.getName()) {
	    			Scanner sc = new Scanner(new File(path + file.getName()));
	    			sc.useDelimiter(",");
	    			while(sc.hasNext()) {
	    				String s = sc.next() + ",";
	    				System.out.print(s);
	    			}
	    
	    			sc.close();
	    			}
	    		}catch (FileNotFoundException e) {
	    			System.err.println("File not Found");
	    		}
	    
	    }
	}
	
	public static boolean exception(String path) {
		Scanner fileScanner = null;
		boolean verdict = false;
	    try
	    {
	        fileScanner = new Scanner(new File(path + "dates.txt"));
	    }
	    catch(FileNotFoundException e)
	    {
	    	verdict = true;
	        System.err.println("Missing dates.txt");
	    }
	    finally
	    {
	        if(fileScanner!= null)
	            fileScanner.close();
	    }
		return verdict;
	}
}
