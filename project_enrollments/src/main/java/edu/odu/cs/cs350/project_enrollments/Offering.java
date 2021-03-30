package edu.odu.cs.cs350.project_enrollments;

import java.util.Vector;

/*
 * Object that will contain all the information for each individual offerings. 
 * (each unique class offering in CSV files)
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
	 * The professor teaching the offering
	 */
	private String instructor; 
	
	
	/*
	 * A vector that contains ever section that is a part of this course
	 *
	 *	- Holds the actual object 'Section'
	 */
	private Vector<Section> sectionList = new Vector<Section>();
	
	
	
	
	/*
	 * 
	 *  DEFAULT CONSTRUCTOR
	 *  ** NEED TO FINISH
	 */
	public Offering()
	{
		this.subject 	= "";
	}
	
	/*
	 * Constructor - create an offering object by providing a section
	 */
	public Offering(Section in)
	{
		this.subject 		= in.subj;
		this.courseNumber 	= in.crse;
		this.crossListCap 	= Integer.parseInt(in.xlst_cap);
		//this.enrolled 		= Integer.parseInt(in.enr);// Gonna update this as we add sections
		this.enrolled		= 0;
		this.link 			= in.link;
		this.xListGroup 	= in.xlst_group;
		
		// Some sections' overallCap cell is blank. So we need execption handling to prevent errors when doing parseInt on it 
		try{
			this.overallCap = Integer.parseInt(in.overall_cap);
		} catch(NumberFormatException ex){
		    this.overallCap = 0;
		}
		
		this.overallEnr 	= Integer.parseInt(in.overall_enr);
		this.instructor		= in.instructor;
	}
	
	/*
	 * Constructor - create an offering object by providing a row of data (String) from the CSV file as param. 
	 */
	public Offering(String[] fields)
	{
		
		this.subject 		= fields[2];
		this.courseNumber 	= fields[3];
		this.crossListCap 	= Integer.parseInt(fields[6]);
		//this.enrolled 		= Integer.parseInt(fields[7]); // Gonna update this as we add sections
		this.enrolled		= 0;
		this.link 			= fields[8];
		this.xListGroup 	= fields[9];
		
		// Some sections' overallCap cell is blank. So we need execption handling to prevent errors when doing parseInt on it 
		try{
			this.overallCap = Integer.parseInt(fields[22]);
		} catch(NumberFormatException ex){
		    this.overallCap = 0;
		}
		
		this.overallEnr 	= Integer.parseInt(fields[23]);
		this.instructor		= fields[20];
		
		
	}
	
	
	


	/*
	 * GETTERS
	 */
	public String getSubject() { return this.subject; }
	public String getCourseNumber() { return this.courseNumber; }
	
	public String getCourse() { return (this.subject + this.courseNumber);} // Get full course name e.g. CS350
	
	public int getCrossListCap() { return this.crossListCap; }
	public int getEnrolled() { return this.enrolled; }
	public String getXListGroup() { return this.xListGroup; }
	public int getOverallCap() { return this.overallCap; }
	public int getOverallEnr() { return this.overallEnr; }
	public String getInstructor() { return this.instructor; }
	
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
	public void setInstructor(String in) { this.instructor = in; }
	
	
	/*
	 * Add to sectionList
	 * 
	 * Param: Section to add
	 */
	public void addSection(Section in)
	{
		this.sectionList.addElement(in);
		// Update enrollment
		this.enrolled += in.getEnr();
	}
	
	/*
	 * Print every section listed under this offering
	 */
	public void display()
	{
		
		System.out.println("\t[Offering]   " + this.subject + this.courseNumber + " -> " + this.instructor +  "\n");
		
		for( Section section : this.sectionList )
		{
			System.out.println("\t\t[Section]   " + section.enr + " | " + section.getCourse() + " " + section.CRN + " -> " + this.getInstructor() );
		}
	}
	
}
