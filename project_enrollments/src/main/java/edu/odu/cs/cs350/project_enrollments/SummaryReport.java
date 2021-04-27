package edu.odu.cs.cs350.project_enrollments;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.*;
import java.net.*;

@SuppressWarnings("PMD")
public class SummaryReport {
	public static Date d3;
	public static long st;
	

	public static void deadlineD(String path) throws Throwable {
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
	    Date d1 = null;
	    Date d2 = null;
	    long diffInMillies = 0;
	    long diff = 0;
	    long perc = 0;
	    String d = "";
	    
	    boolean isURL = false;
	    
	    isURL = FileImports.validateUrl(path);
	    
	    if (isURL) {
	    	ArrayList<URL> urlsList = new ArrayList<URL>();
	    	urlsList = FileImports.getUrls(path);
	    	for (URL u : urlsList) {
	    		try {
    				BufferedReader r = new BufferedReader(new InputStreamReader(u.openStream()));
    				String currLine = "";
    				
    				if (u.toString().contains("dates.txt")) {
    					currLine = r.readLine();
    	    			d1 = sdformat.parse(currLine);
    	    			//System.out.println("d1="+d1);
    	    			currLine = r.readLine();
    	    			d2 = sdformat.parse(currLine);
    	    			//System.out.println("d2="+d2);
    	    			
    	    		} else {
    	    			// parse the url by '/'s, the last slice will be the full file name
    	    			String tmp = u.toString();
    	    			String[] slices = tmp.split("/");
    	    			/*
    	    			for (int i = 0; i < slices.length; i++) {
    	    				System.out.println("slices["+i+"]="+slices[i]);
    	    			}
    	    			*/
    	    			tmp = slices[slices.length-1];
    	    			//System.out.println("tmp="+tmp);
    	    			
    	    			// split one more time at the "." to separate 'file name' and 'file type extension'
    	    			String[] filenameSlices = tmp.split("\\.");
    	    			/*
    	    			for (int i = 0; i < filenameSlices.length; i++) {
    	    				System.out.println("slices["+i+"]="+filenameSlices[i]);
    	    			}
    	    			*/

    	    			d = filenameSlices[0];
    	    			//System.out.println("d="+d);
    	    			
    	    			d3 = sdformat.parse(d);
    	    			//System.out.println("d3="+d3.toString());
    	    	
    	    		}
    				
    				/*
    				while ((currLine = r.readLine()) != null) {
    					//sections.add(extractSection(currLine));
    				}
    				*/
    				
    			} catch (MalformedURLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
	    		
	    		
	    	}
	    	
	    }
	    else {
	    	File directoryPath = new File(path);	    
		    File filesList[] = directoryPath.listFiles();
		    Scanner sc = null;
		    
		    for(File file : filesList) {	
				sc = new Scanner(new File(path + file.getName()));
				String t = file.getName();
				
				// last date of snapshot is used to calculate percentage of time
				// expired for the enrollment period
				if(!t.equals("dates.txt")) {
					d = file.getName();
					d=d.substring(0,10);
					//System.out.print("Snap format: " + d + "\n");
					//d3 = sdformat.parse(d);
					d3 = sdformat.parse(d);
					//System.out.print("Snap Date: " + d3 + "\n");
				}
				
				if(t.equals("dates.txt")) {		
					d1 = sdformat.parse(sc.nextLine());
					//Date d2 = sdformat.parse(sc.next());
					d2 = sdformat.parse(sc.next());
					//System.out.print(d1 +"\n");
					//System.out.print(d2 + "\n");	
				}
				sc.close();
		    }
		    
		    diffInMillies = Math.abs(d2.getTime() - d1.getTime());
			diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			perc = diff;
			
			//System.out.print("difference: " + diff + "\n");
			diffInMillies = (d3.getTime() - d1.getTime());
			diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			//System.out.print("Third: " + diff + "\n");
			//System.out.print("percentage: " + diff + " " + perc + "\n");
			st = (diff*100)/perc;
			if(st <= 0){
				//System.out.print("percentage: %" + 0);
				st=0;
			}else if(st >= 100){
				//System.out.print("percentage: %" + 100);
				st = 100;
			}//else
				//System.out.print("percentage: %" + st);
			//System.exit(0);

	    }
	}
	
	
	/*
	 * The actual output
	 */
	public static void sReport(SortedMap<String, Course > in) {
		// % of enrollment period
		System.out.print(st + "% of enrollment period has elapsed. \n");
		System.out.println("\n");  
		
		// Header
		System.out.format("%-14s%-14s%-14s%-14s", "Course", "Enrollment", "Projected", "Cap");
		System.out.println("\n");
		
		// Semester Courses
		for (String key : in.keySet()) {
			//String courseTitle = key;
			//int actualEnrolled = in.get(key).getActualEnrolled();
			//int projectedEnrollment = in.get(key).getProjectedEnrollment();
			//int enrollmentCap = in.get(key).getEnrollmentCap();
			in.get(key).displayCLI();
		}
	}
}
