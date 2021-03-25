package edu.odu.cs.cs350.project_enrollments;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileImports {
	
	// If a path string doesn't end in a / or \, add a / to the end of it.
	public static String sanitizePath(String path) {
		//System.out.println("PATH=" + path);
		if (path.length() == 0) {
			System.exit(1);
		}
		if (!path.endsWith("/") && !path.endsWith("\\")) {
			path = path.concat("/");
			//System.out.println("concatted");
			//System.out.println(path);
		}
		//int lastCharIndex = path.length()-1;
		return path;
	}
	
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
