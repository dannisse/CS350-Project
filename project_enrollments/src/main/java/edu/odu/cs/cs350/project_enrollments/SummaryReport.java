package edu.odu.cs.cs350.project_enrollments;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.*;

public class SummaryReport {
	public static Date d3;
	public static long st;
	

	public static void deadlineD(String path) throws Throwable {
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		File directoryPath = new File(path);	    
	    File filesList[] = directoryPath.listFiles();
	    Date d1;
	    Date d2;
	    long diffInMillies;
	    long diff;
	    long perc;
	    String d;
	    
	    Scanner sc = null;
	    for(File file : filesList) {	
			sc = new Scanner(new File(path + file.getName()));
			String t = file.getName();
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
			
			sc.close();
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
	
	public static void generateOfferingsAndCourses(ArrayList<Section> in, SortedMap<String, Course > data) throws IOException {
		/*
		 * Go through each section. 
		 * 
		 * If the Course name OR instructor changes -> create a new Offering
		 * 		- Add list of Sections to that offering
		 * 	
		 * If Course name stays the same AND teacher changes -> create new course
		 * 		- Add list of offerings to that Course
		 */
		
		//Offering newOffering = null;
	    Offering currOffering = null;
	    
	    Course currCourse = null;
	    
		//String currCourseName = "";
		//String currInstructor = ""; 
		
		for(Section newSection : in)
		{
			if(currOffering == null 
					|| !newSection.getCourse().equals(currOffering.getCourse())
					|| !newSection.instructor.equals(currOffering.getInstructor())) {	

				/*
				 * Add currOffering to the currCourse
				 * 		- the offering is done processing at this point and is about to be changed
				 */

				if(currOffering != null) {
					currCourse.addOffering(currOffering);
				}
				
				
				/*
				 * If the Course title does not match the previous one OR this is the first entry (currOffering == null), then we need to create a new Course object
				 * 		- Add the currCourse to data first
				 */
				if(currOffering == null || !newSection.getCourse().equals(currOffering.getCourse())) {
					
					String courseTitle = newSection.getCourse();
					
					// If it's not null, that means the Course is done processing. Add it to the data
					if(currOffering != null) {
						data.put(courseTitle, currCourse);
					}
					
					currCourse = new Course(courseTitle);
				}
				
				
				// Create new offering 

				currOffering = new Offering(newSection);
				
			}
			
			// Add Section to Offering
			currOffering.addSection(newSection);
		}
	
		
	}
	
}
