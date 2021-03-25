package edu.odu.cs.cs350.project_enrollments;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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
	
	public static void findFile(String path) {	
		File directoryPath = new File(path);	    
	    File filesList[] = directoryPath.listFiles();
	    
	    List<eSnapshot> data = new ArrayList<eSnapshot>();
	    
	    for(File file : filesList) {
	    		System.out.println("File name: "+file.getName() + "\n");
	    
	    		try {
	    			if("dates.txt" != file.getName()) {
	    			Scanner sc = new Scanner(new File(path + file.getName()));
	    			//sc.useDelimiter(",");
	    			while(sc.hasNextLine()) {
	    				//if(sc.nextLine().contains("XLST")) {
	    					
	    				//}
	    				String currLine = sc.nextLine();
	    				data.add(new eSnapshot(currLine));
	    				data.get(data.size()-1).print();
	    				System.out.println("\n");
	    				//System.out.println(currLine);
	    				//String s = sc.next() + ",";
	    				//System.out.print(s);
	    				//System.exit(0);
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
