package edu.odu.cs.cs350.project_enrollments;

import java.util.*;

public class ProjectEnrollments {

	public static void main(String[] args) throws Throwable {
		
		/*
		 * Check Number of Arguments
		 */
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
		
		
		/*
		 * Create SEMESTERS
		 * 		- Semester is a map [key=>Course Title, val=>Course Object] of courses in one directory.
		 */
		
		/*
		 * Current Semester Courses Setup
		 */
		SortedMap<String, Course > currSemester = new TreeMap<String, Course >();
		// Add to currCourse
		if (args.length != 0) {
			String path = args[1];
			path = FileImports.sanitizePath(path);
			if(FileImports.exception(path) == false) {
				FileImports.findFile(path, currSemester);
			}
		}
		
		/*
		 * Historical Semester Courses Setup
		 */
		SortedMap<String, Course > historicalSemester = new TreeMap<String, Course >();
		// Add to historicalCourse
		if (args.length != 0) {
			String path = args[0];
			path = FileImports.sanitizePath(path);
			if(FileImports.exception(path) == false) {
				FileImports.findFile(path, historicalSemester);
			}
		}
		
		
		/*
		 * Print Semester [Testing Purposes]
		 */
		for (String key : currSemester.keySet()) {
			
			System.out.println("=======================================\n");
			currSemester.get(key).display();
		}
		
		System.out.println("LIST SIZE: " + currSemester.size());
		System.out.println("HISTORICAL LIST SIZE: " + historicalSemester.size() + "\n\n");
		
		
		
		/*
		 * 
		 * CLI Output
		 * 
		 */
		
		String path = args[0];
		path = FileImports.sanitizePath(path);
		SummaryReport.deadlineD(path);
		SummaryReport.sReport(currSemester);
		
		
		/*
		ArrayList<Section> data = new ArrayList<Section>();
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

		/*int currDirIndex = args.length-2;
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
		}*/
	}
}