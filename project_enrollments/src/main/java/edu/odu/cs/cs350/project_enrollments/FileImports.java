package edu.odu.cs.cs350.project_enrollments;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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
		return path;
	}
	
	public static void findFile(String path, ArrayList<eSnapshot> data) {	
		File directoryPath = new File(path);	    
	    File filesList[] = directoryPath.listFiles();
	    
	    
	    
	    Scanner sc = null;
	    
	    for(File file : filesList) {
	    		System.out.println("File name: "+file.getName() + "\n");

	    		try {
	    			sc = new Scanner(new File(path + file.getName()));
	    			String t = file.getName();
	    			if(!t.equals("dates.txt")) {
	    				String currLine = sc.nextLine();	// header line
		    			while(sc.hasNextLine()) {
		    				currLine = sc.nextLine();
		    				
		    				// Remove the first and last " characters
		    				currLine = currLine.substring(1, currLine.length()-1);
		    				
		    				//System.out.println("removed quotations\t" + currLine);
		    				
		    				// Now we can parse the internal "," delimeters.
		    				// If you simply split it by commas, then you would split 
		    				// Fields that have names like LASTNAM,FIRSTINITIAL, when you
		    				// really need this as one field
		    				String[] fields = currLine.split("\",\"");
		    				
		    				//System.out.println(fields.length);
		    				//System.out.print("LINE\t" + currLine + "\n");
		    				//System.out.print("PARSED\t");
		    				
		    				
		    				//for (int i = 0; i < fields.length; i++) {
		    				//	System.out.print(fields[i]+",");
		    				//}
		    				//System.out.print("\n");
		    				
		    				data.add(new eSnapshot(fields));
		    				
		    				//data.get(data.size()-1).print();
		    				
		    				//System.out.println();
		    				//System.exit(0);
		    			}
		    		}
	    			sc.close();
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
