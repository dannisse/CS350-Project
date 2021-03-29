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
	
	/*
	 * Search through files in a directory
	 * 	- If the file exists -> Scan every row in that file
	 * 	-- For each row scanned, create a new section (eSnapshot) object
	 * 	--- If the row scanned doesn't match data from the previous one (course # and/or teacher) -> create a new offering object and add that section to the offerings list
	 */
	public static void findFile(String path, ArrayList<eSnapshot> data) {	
		File directoryPath = new File(path);	    
	    File filesList[] = directoryPath.listFiles();
	    
	    Offering newOffering = null;
	    Offering currOffering = null;
	    
	    Scanner sc = null;
	    
	    /*
	     * Search through files in a directory
	     */
	    for(File file : filesList) {
	    		//System.out.println("File name: "+file.getName() + "\n");

	    		try {
	    			sc = new Scanner(new File(path + file.getName()));
	    			//sc.useDelimiter(",");
	    			String t = file.getName();
	    			if(!t.equals("dates.txt")) {
	    				
	    				
	    				/*
	    				 * Search through each row of the file
	    				 */
		    			while(sc.hasNextLine()) {
	
		    		
		    				String currLine = sc.nextLine(); 			
		    				if(!currLine.contains("CRN,SUBJ,CRSE,XLST CAP,ENR,LINK,XLST GROUP,OVERALL CAP,OVERALL ENR,INSTRUCTOR")) {
		    					
		    					/*
		    					 * Create new section (eSnapshot)
		    					 */
		    					eSnapshot newSection = new eSnapshot(currLine);
		    					
		    					/*
		    					 * If currOffering is null
		    					 * 	|-> If the row scanned doesn't match data from the previous one (course # and/or teacher)  -> create a new offering object and add that section to the offerings list
		    					 * 			and update the current offering
		    					 */
			    					if(currOffering == null || (newSection.getCourse() != currOffering.getCourse() || newSection.instructor != currOffering.getInstructor()) )
			    					{
			    						if (currOffering != null)
			    						{
			    							if(newSection.getCourse() != currOffering.getCourse())
				    						{
				    							System.out.println(newSection.getCourse() + " DAMN " + currOffering.getCourse());
				    						}
				    						if( newSection.instructor != currOffering.getInstructor() )
				    						{
				    							System.out.println("Poo");
				    						}
			    						}
			    						
			    						
			    						// Create new offering 
			    						newOffering = new Offering(currLine);
			    						
			    						// Update current offering
			    						currOffering = newOffering;
			    						
			    						// Add section to the list of sections under that offering
			    						currOffering.addSection(newSection);
			    						
			    					}
		    					
		    					// Test display
		    					if (currOffering != null)
		    					{
		    						currOffering.display();
		    					}
		    					
		    					
		    					data.add(new eSnapshot(currLine));
		    				}
	    				}
		    			
		    			
	    			}
	    			sc.close();
	    		}
	    		catch (FileNotFoundException e) {
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
