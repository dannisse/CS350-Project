package edu.odu.cs.cs350.project_enrollments;


import java.io.File;
import java.io.FileNotFoundException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


//import java.util.Objects;



public class FileImports {
	
	// If a path string doesn't end in a / or \, add a / to the end of it.
	public static String sanitizePath(String path) {
		//System.out.println("PATH=" + path);
		if (path.length() == 0) {
			System.exit(1);
		}
		if (!path.endsWith("/") && !path.endsWith("\\")) {
			path = path.concat("/");
			//System.out.println("concatenated");
			//System.out.println(path);
		}
		return path;
	}
	
	public static boolean validateUrl(String url)
	{
		Pattern pattern= Pattern.compile("^(http|https)://", Pattern.CASE_INSENSITIVE);
		Matcher matcher=pattern.matcher(url);
	
		boolean matchFound=matcher.find();
		if(matchFound)
		{
			return true;
		}
		
		else 
		{
			return false;
		}
		

		
		
	}
	
	// Given a path, return the list of files in that path
	public static ArrayList<File> getFiles(String path) {	
		File directoryPath = new File(path);
		File filesArray[] = directoryPath.listFiles();
		ArrayList<File> filesList = new ArrayList<File>();
		for (File f: filesArray) {
			filesList.add(f);
		}
		return filesList;
	}
	
	// Returns a Section object.
	// @param line  a comma separated values line from a file in a semester directory
	public static Section extractSection(String line) {
		// Remove the first and last " characters
		line = line.substring(1, line.length()-1);
		
		//System.out.println("removed quotations\t" + line);
		
		// Now we can parse the internal "," delimiters.
		// If you simply split it by commas, then you would split 
		// Fields that have names like LASTNAM,FIRSTINITIAL, when you
		// really need this as one field
		String[] fields = line.split("\",\"");
		Section newSection = new Section(fields);
		return newSection;
	}
	
	// get all the sections in .csv file. there is one section per line in the file.
	// @param f a .csv file
	public static ArrayList<Section> getAllSections(File f) {
		ArrayList<Section> sections = null;
		Scanner s = null;
		try {
			s = new Scanner(f);
			String currLine = s.nextLine();	// read in the header line
			sections = new ArrayList<Section>();
			while (s.hasNextLine()) {
				currLine = s.nextLine();
				sections.add(extractSection(currLine));
			}
		} catch (FileNotFoundException err) {
			err.printStackTrace();
			System.exit(1);
		} finally {
			s.close();
		}
		return sections;
	}
	

	
//	public static void REFACTORTHIS(String path) {		    	    
//	    // Used for creating a new Offering when needed
//	    Offering newOffering = null;
//	    Offering currOffering = null;
//	    
//	    // Used for creating and updating a new Course when needed
//	    Course currCourse = null;
//	    //ArrayList<Course> tempCourses = null;
//	    
//	    Scanner sc = null;
//	    
//	    ArrayList<File> filesList = getFiles(path);
//	    
//	    for(File file : filesList) {
//	    		System.out.println("File name: "+file.getName() + "\n");
//
//	    		try {
//	    			sc = new Scanner(new File(path + file.getName()));
//	    			String t = file.getName();
//	    			if(!t.equals("dates.txt")) {
//	    				String currLine = sc.nextLine();	// header line
//		    			while(sc.hasNextLine()) {
//		    				currLine = sc.nextLine();
//		    				
//		    				Section newSection = extractSection(sc.nextLine());
//
//	    					
//	    					/*
//	    					 * CREATE NEW OFFERING AND COURSE
//	    					 * 
//	    					 * If currOffering is null
//	    					 * 	|-> If the row scanned doesn't match data from the previous one (course # and/or teacher)  -> create a new offering object and add that section to the offerings list
//	    					 * 			and update the current offering
//	    					 */
//	    					if(currOffering == null 
//	    							|| !newSection.getCourse().equals(currOffering.getCourse())
//	    							|| !newSection.instructor.equals(currOffering.getInstructor())) {	
//
//	    						/*
//	    						 * Add currOffering to the currCourse
//	    						 * 		- the offering is done processing at this point and is about to be changed
//	    						 */
//
//		    					if(currOffering != null) {
//		    						currCourse.addOffering(currOffering);
//		    					}
//		    					
//		    					
//		    					/*
//		    					 * If the Course title does not match the previous one OR this is the first entry (currOffering == null), then we need to create a new Course object
//		    					 * 		- Add the currCourse to data first
//		    					 */
//		    					if(currOffering == null || !newSection.getCourse().equals(currOffering.getCourse())) {
//		    						
//		    						String courseTitle = newSection.getCourse();
//		    						
//		    						// If it's not null, that means the Course is done processing. Add it to the data
//		    						if(currOffering != null) {
//		    						//	data.put(courseTitle, currCourse);
//    								}
//		    						
//		    						currCourse = new Course(courseTitle);
//	    						}
//		    					
//	    						
//	    						// Create new offering 
//	    						//newOffering = new Offering(fields);
//	    						
//	    						// Update current offering
//	    						currOffering = newOffering;
//	    						
//	    					}
//	    					
//	    					// Add section to the list of sections under that offering
//    						currOffering.addSection(newSection);
//		    			}
//		    		}
//	    			sc.close();
//	    		} catch (FileNotFoundException e) {
//	    			System.err.println("File not Found");
//	    		}
//	    	}
//	}
	
	
	// Returns true if directory path does not contain a dates.txt file.
	// Return false if the file is present.
	public static boolean containsDates(String path) {
		Scanner fileScanner = null;
		boolean verdict = true;
	    try {
	        fileScanner = new Scanner(new File(path + "dates.txt"));
	    } catch(FileNotFoundException e) {
	    	verdict = false;
	        System.err.println("Missing dates.txt");
	    } finally {
	        if(fileScanner!= null) {
	            fileScanner.close();
	        }
	    }
		return verdict;
	}
}
