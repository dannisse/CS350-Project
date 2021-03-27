package edu.odu.cs.cs350.project_enrollments;

/*
 * Object that will contain all the information for each individual offerings. 
 * (each unique CRN in CSV files)
 */
public class Offering {
	
	/*
	 * Five digit identifier for the offering
	 */
	int crn;
	
	/*
	 * Title of the offering
	 */
	String subject;
	
	/*
	 * The course # (e.g. the 350 in CS350)
	 * (It's a string to account for the courses with letters in it.
	 */
	String courseNumber;
	
	/*
	 * The number of students that will be able to be enrolled in a particular section
	 */
	int crossListCap = 0;
	
	/*
	 * The number of students currently enrolled
	 */
	int enrolled;
	
	/*
	 * Used to link labs and recitations to a lecture.
	 */
	String link;
	
	/*
	 * Used to identify which sections of a course belong to a single offering.
	 */
	String xListGroup;
	
	/*
	 * The maximum number of students that will be able to enroll in a certain section that is being offered
	 */
	int overallCap;
	
	/*
	 * The total number of students that are enrolled in a particular section
	 */
	int overallEnr;


	
}
