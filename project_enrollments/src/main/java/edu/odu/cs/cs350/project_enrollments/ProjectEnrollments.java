package edu.odu.cs.cs350.project_enrollments;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.net.*;

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
		
		FileImports f1 = new FileImports();
		histSems = f1.history(histSems, args);
		
		// import historical semesters. this needs to work with URLs
		/*for (int i = 0; i < args.length-2; i++) { 
			String path = FileImports.sanitizePath(args[i]);
			if (FileImports.containsDates(path)) {
				//todo: need to give semester name and start and end dates
				Semester sem = new Semester();
				
				boolean isURL = FileImports.validateUrl(path);
				if (isURL) {
					System.out.println("Retrieving from "+path+":");
					ArrayList<URL> urlsList = FileImports.getUrls(path);
					
					for (URL u: urlsList) {
						System.out.println("Retrieving "+u.toString());
						if (!u.toString().contains("dates.txt")) {
							Snapshot snap = new Snapshot(u);
							sem.addSnapshot(snap);
							//System.out.println("added snapshot from url.");
							
							/*
							ArrayList<Section> sections = sem.getSnapshot(sem.getSnapshots().size()-1).getSections();
							for (Section s: sections) {
								s.print();
							}
							*/
							
							//System.exit(0);
						/*}
					}
				} else {
					ArrayList<File> filesList = FileImports.getFiles(path);
					
					for (File f: filesList) {
						String fileName = f.getName();
						
						// Make sure we're not adding dates.txt
						if(!fileName.equals("dates.txt")) {
							Snapshot snap = new Snapshot(f);
							sem.addSnapshot(snap);
						}
						
					}
				}
				
				
				histSems.add(sem);
				System.out.println("Historical semester successfully imported.");

			}
		}*/

		
		/*
		 * Import current semester (second to last argument)
		 */
		Semester currSemester = new Semester();
		f1.current(currSemester, args);
		/*String path = FileImports.sanitizePath(args[args.length-2]);
		if (FileImports.containsDates(path)) {
			//todo: need to give semester name and start and end dates
			
						boolean isURL = FileImports.validateUrl(path);
			
			if (isURL) {
				System.out.println("Retrieving from "+path+":");
				ArrayList<URL> urlsList = FileImports.getUrls(path);
				
				for (URL u: urlsList) {
					System.out.println("Retrieving "+u.toString());
					if (!u.toString().contains("dates.txt")) {
						Snapshot snap = new Snapshot(u);
						currSemester.addSnapshot(snap);
						//System.out.println("added snapshot from url.");
						
						/*
						ArrayList<Section> sections = sem.getSnapshot(sem.getSnapshots().size()-1).getSections();
						for (Section s: sections) {
							s.print();
						}
						*/
						
						//System.exit(0);
					/*}
				}
			} else {
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
			System.out.println("Current semester successfully imported.");
		}*/
		
		String exPath = FileImports.sanitizePath(args[args.length-1]);
		
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
		SummaryReport.generateOfferingsAndCourses(histSections, histSemesterList);
		

		/*
		 * 
		 * Current Semester
		 * 
		 */
		ArrayList<Snapshot> currSnapshots = currSemester.getSnapshots();
		Snapshot lastCurrSnapshot = currSnapshots.get(currSnapshots.size() - 1);
		ArrayList<Section> currSections = lastCurrSnapshot.getSections();
		
		SortedMap<String, Course > currSemesterList = new TreeMap<String, Course >();
		SummaryReport.generateOfferingsAndCourses(currSections, currSemesterList);
		
		
		/*System.out.println("AYYd "+histSemesterList.size());
		for (String key : histSemesterList.keySet()) {
			
			System.out.println("=======================================\n");
			histSemesterList.get(key).display();
			break;
		}
		
		
		System.out.println("AYYd "+currSemesterList.size());
		for (String key : currSemesterList.keySet()) {
			
			System.out.println("=======================================\n");
			currSemesterList.get(key).display();
			break;
		}*/
		
		
		
		
		/*
		 * 
		 * CLI Output
		 * 
		 */
		
		String pathCurrDir = args[args.length-2];
		pathCurrDir = FileImports.sanitizePath(pathCurrDir);
		SummaryReport.deadlineD(pathCurrDir);
		SummaryReport.sReport(currSemesterList);
		
		DetailedReport dr = new DetailedReport();
		dr.createExcel(histSemesterList, currSemesterList, exPath);
		
		
		
		
		
		
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
	

	
	
	/*
	 * Generate projected enrollment to currentSemester Course Map based of historicalSemester Course Map
	 */
	/*public static void generateProjectEnrollment(SortedMap<String, Course > currIn, SortedMap<String, Course > histIn)
	{
		
	}*/
	
	
}