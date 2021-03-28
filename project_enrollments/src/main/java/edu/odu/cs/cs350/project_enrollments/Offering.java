package edu.odu.cs.cs350.project_enrollments;

/*
 * Object that will contain all the information for each individual offerings. 
 * (each unique CRN in CSV files)
 * 
 *  - This will be created when a CSV file is being scanned and a row (section) has data that isn't already recorded
 */
public class Offering {
	
	/*
	 * Title of the offering
	 */
	private String subject;
	
	/*
	 * The course # (e.g. the 350 in CS350)
	 * (It's a string to account for the courses with letters in it.
	 */
	private String courseNumber;
	
	/*
	 * The number of students that will be able to be enrolled in a particular section
	 */
	private int crossListCap;
	
	/*
	 * The number of students currently enrolled
	 */
	private int enrolled;
	
	/*
	 * Used to link labs and recitations to a lecture.
	 */
	private String link;
	
	/*
	 * Used to identify which sections of a course belong to a single offering.
	 */
	private String xListGroup;
	
	/*
	 * The maximum number of students that will be able to enroll in a certain section that is being offered
	 */
	private int overallCap;
	
	/*
	 * The total number of students that are enrolled in a particular section
	 */
	private int overallEnr;
	
	
	
	
	
	/*
	 * ** NEED TO FINISH
	 *  CONSTRUCTORS
	 */
	public Offering()
	{
		this.subject 	= "";
	}
	
	
	


	/*
	 * GETTERS
	 */
	public String getSubject() { return this.subject; }
	public String getCourseNumber() { return this.courseNumber; }
	public int getCrossListCap() { return this.crossListCap; }
	public int getEnrolled() { return this.enrolled; }
	public String getXListGroup() { return this.xListGroup; }
	public int getOverallCap() { return this.overallCap; }
	public int getOverallEnr() { return this.overallEnr; }
	
	/*
	 * SETTERS
	 */
	public void setSubject(String in) { this.subject = in; }
	public void setCourseNumber(String in) { this.courseNumber = in; }
	public void setCrossListCap(int in) { this.crossListCap = in; }
	public void setEnrolled(int in) { this.enrolled = in; }
	public void setXListGroup(String in) { this.xListGroup = in; }
	public void setOverallCap(int in) { this.overallCap = in; }
	public void setOverallEnr(int in) { this.overallEnr = in; }
	
}
