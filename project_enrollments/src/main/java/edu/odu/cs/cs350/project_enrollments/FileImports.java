package edu.odu.cs.cs350.project_enrollments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileImports {
	public static void findFile(String path) {	
	    File directoryPath = new File(path);	    
	    File filesList[] = directoryPath.listFiles();
	    Scanner sc = null;
	    for(File file : filesList) {
	    		System.out.println("File name: "+file.getName());
	    		sc= new Scanner(file.getName());
	    		sc.useDelimiter(",");
	    		
	    		String input;
	    		StringBuffer sb = new StringBuffer();
	    		while(sc.hasNext()) {
	    			input = sc.nextLine();
	                sb.append(input+" ");
	    	    }

	    	    sc.close();

	    }
	}
	public static boolean exception(String path) {
		Scanner fileScanner = null;
		boolean verdict = false;
	    try
	    {
	        fileScanner = new Scanner(new File(path + "dates.txt"));
	        while(fileScanner .hasNextLine())
	        {
	            String eachLine= fileScanner.nextLine();
	            String[] wordsFromFile = eachLine.split("\\W");
	        }
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
