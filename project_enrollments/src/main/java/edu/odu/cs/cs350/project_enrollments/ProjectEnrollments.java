package edu.odu.cs.cs350.project_enrollments;

import java.util.*;
import java.io.File;

public class ProjectEnrollments {

	public static void main(String[] args) throws Throwable {
		
		/*
		ArrayList<eSnapshot> data = new ArrayList<eSnapshot>();
		if (args.length != 0) {
			//System.out.println(args[0]);
			String path = args[0];
			path = FileImports.sanitizePath(path);
			if(FileImports.exception(path) == false) {
				FileImports.findFile(path, data);
				//SummaryReport.deadlineD(path);
				//SummaryReport.sReport();
				//eSnapshot.mathFR(data);
				//for(int i = 0; i<data.size(); i++) {
					//data.get(i).print();
				//}
			}
		}
		*/
		
		if (args.length == 0) {
			System.exit(1);
		}

		// A semester is collection of snapshots. A snapshot is a collection of section information on a certain day. 
		ArrayList<Semester> histSems = new ArrayList<Semester>();
		
		// import historical semesters. this needs to work with URLs
		for (int i = 0; i < args.length-2; i++) {
			String path = FileImports.sanitizePath(args[i]);
			if (FileImports.containsDates(path)) {
				//todo: need to give semester name and start and end dates
				Semester sem = new Semester();
				ArrayList<File> filesList = FileImports.getFiles(path);
				for (File f: filesList) {
					String fileName = f.getName();
					
					// Make sure we're not adding dates.txt
					if(!fileName.equals("dates.txt")) {
						Snapshot snap = new Snapshot(f);
						sem.addSnapshot(snap);
					}
				}
				histSems.add(sem);
			}
		}
		
		/*
		 * Import current semester (second to last argument)
		 */
		Semester currSemester = new Semester();
		String path = FileImports.sanitizePath(args[args.length-2]);
		if (FileImports.containsDates(path)) {
			//todo: need to give semester name and start and end dates
			
			ArrayList<File> filesList = FileImports.getFiles(path);
			for (File f: filesList) {
				String fileName = f.getName();
				
				// Make sure we're not adding dates.txt
				if(!fileName.equals("dates.txt")) {
					Snapshot snap = new Snapshot(f);
					currSemester.addSnapshot(snap);
				}
			}
		}
					
		
		/*
		 * Print histSems for testing purposes
		 * 
		 * 	- prints each snapshot and the sections contained in them
		 
		for (Semester sem : histSems) {
			
			System.out.println("=======================================\n");
			ArrayList<Snapshot> snp = sem.getSnapshots();
			for(Snapshot snpsht : snp)
			{
				System.out.println(".................\n");
				snpsht.display();
			}
			
		}
		*/
		
		
		/*
		 * Generate Offerings and Course from the last snapshot in the semester
		 * 
		 * 	- Generate Offering if course name OR instructor changes
		 * 	- Generate Course if course name changes
		 */
		
		/*
		 * Historical Semester
		 * 
		 * @TODO MAKE IT SO IT READS EVERY SEMESTER IN SEMESESTERS LIST
		 * IT IS CURRENTLY ONLY DOING THE LAST ONE ADDED
		 */
		ArrayList<Snapshot> histSnapshots = histSems.get(histSems.size()-1).getSnapshots();
		Snapshot lastHistSnapshot = histSnapshots.get(histSnapshots.size() - 1);
		ArrayList<Section> histSections = lastHistSnapshot.getSections();
		
		SortedMap<String, Course > histSemesterList = new TreeMap<String, Course >();
		generateOfferingsAndCourses(histSections, histSemesterList);
		

		/*
		 * 
		 * Current Semester
		 * 
		 */
		ArrayList<Snapshot> currSnapshots = currSemester.getSnapshots();
		Snapshot lastCurrSnapshot = currSnapshots.get(currSnapshots.size() - 1);
		ArrayList<Section> currSections = lastCurrSnapshot.getSections();
		
		SortedMap<String, Course > currSemesterList = new TreeMap<String, Course >();
		generateOfferingsAndCourses(currSections, currSemesterList);
		
		
		
		
		System.out.println("AYYd "+currSemesterList.size());
		for (String key : currSemesterList.keySet()) {
			
			System.out.println("=======================================\n");
			currSemesterList.get(key).display();
		}
		
		
		
		
		/*
		 * 
		 * CLI Output
		 * 
		 */
		
		String pathCurrDir = args[args.length-2];
		pathCurrDir = FileImports.sanitizePath(pathCurrDir);
		SummaryReport.deadlineD(pathCurrDir);
		SummaryReport.sReport(currSemesterList);

		
		
		
		
		
		
		/*
		 * Current Semester Courses Setup
		 */
		//SortedMap<String, Course > currSemester = new TreeMap<String, Course >();
		// Add to currCourse
		
		/*
		 * Historical Semester Courses Setup
		 
		SortedMap<String, Course > historicalSemester = new TreeMap<String, Course >();
		// Add to historicalCourse
		if (args.length != 0) {
			String path = args[1];
			path = FileImports.sanitizePath(path);
			if(FileImports.containsDates(path)) {
				//FileImports.getCSVFiles(path, historicalSemester);
			}
		}
		
		*/
		/*
		 * Print Semester
		 
		for (String key : currSemester.keySet()) {
			
			System.out.println("=======================================\n");
			currSemester.get(key).display();
		}
		
		System.out.println("LIST SIZE: " + currSemester.size());
		System.out.println("HISTORICAL LIST SIZE: " + historicalSemester.size());
		*/
		
		
		
		/*
		if (args.length < 3) {
			System.out.println("Too few arugments.");
			System.out.println("Usage: java -jar program.jar [historical semester directories] [current semester directory] [excel file output location]");
			System.exit(1);
		}

		List<String> histDirs = new ArrayList<String>();
		
		// The last two arguments to the program are the current semester dir
		// and the export path for the spreadsheet file.
		for (int i = 0; i < args.length-2; i++) {
			histDirs.add(args[i]);
		}

		int currDirIndex = args.length-2;
		int exportPathIndex = args.length-1;
		String currDir = args[currDirIndex];
		String exportPath = args[exportPathIndex];

		System.out.println("CURRDIR=" + currDir);
		System.out.println("EXPORTPATH=" + exportPath);
 		
		int i = 0;
		for (String s : args) {
			System.out.printf("%d\t%s\n", i++, s);
		}		
		System.out.printf("%d total args\n", args.length);
		
		System.out.println("Historical Semester directories:");
		for (String s : histDirs) {
			System.out.println(s);
		}
		*/
	}
	
	
	
	/*
	 * Generate Offerings and Courses
	 * 
	 * 	@Param: ArrayList of Sections 
	 * 	@Param: SortedMap to add courses to
	 * 	@Returns: A list of generated courses
	 */
	
	public static void generateOfferingsAndCourses(ArrayList<Section> in, SortedMap<String, Course > data) {
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
	
	
	/*
	 * Generate projected enrollment to currentSemester Course Map based of historicalSemester Course Map
	 */
	public static void generateProjectEnrollment(SortedMap<String, Course > currIn, SortedMap<String, Course > histIn)
	{
		
	}
	
	
}