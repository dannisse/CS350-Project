/**
 * 
 */
package edu.odu.cs.cs350.project_enrollments;

/*
 * Object that will contain all the information for each individual offerings. 
 * (each unique CRN in CSV files (each row))
 * 
 *  - This will be created when a CSV file is being scanned. Every row will create a new section
 */
public class Section {
	/*
	 * Five digit identifier for the offering
	 */
	private int crn;

	/*
	 * The number of students currently enrolled
	 */
	private int enrolled;
	
	/*
	 * Title of the class
	 */
	private String courseTitle;
	
	
	/*
	 *  CONSTRUCTORS
	 */
	public Section()
	{
		this.crn		= 0;

	}
	
	public Section(int crn, int enrolled, String title)
	{
		this.crn			=	crn;
		this.enrolled		=	enrolled;
		this.courseTitle	=	title;
	}
	
	
	


	/*
	 * GETTERS
	 */
	public int getCrn() { return this.crn; }
	public String getCourseTitle() { return this.courseTitle; }
	public int getEnrolled() { return this.enrolled; }

	
	/*
	 * SETTERS
	 */
	public void setCrn(int in) { this.crn = in; }
	public void setCourseTitle(String in) { this.courseTitle = in; }
	public void setEnrolled(int in) { this.enrolled = in; }

}
