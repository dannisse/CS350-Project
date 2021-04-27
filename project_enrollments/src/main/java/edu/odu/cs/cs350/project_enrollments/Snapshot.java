package edu.odu.cs.cs350.project_enrollments;

import java.io.File;
import java.util.ArrayList;
import java.net.URL;


// A snapshot is a collection of information about sections on a certain day.
public class Snapshot {
	private String date;
	private ArrayList<Section> sections;
	

	// need to test this overall
	public Snapshot() {
		date = "";
	}
	
	public Snapshot(File f) {
		
		date = f.getName();	// need to test: does this even work? the name should be something like "2019-04-01", or YYYY-MM-DD
		sections = FileImports.getAllSections(f);
	}
	
	public Snapshot(URL u) {
		// TODO Auto-generated constructor stub
		date = "TESTING"; // TODO:	write function to obtain date from the URL
		sections = FileImports.getAllSections(u);
	}
	
	public String getDate() {
		return this.date;
	}
	
	public ArrayList<Section> getSections() {
		return this.sections;
	}
	
	public Section getSection(int index) {
		return this.sections.get(index);
	}

	
	/*
	 * Display for testing purposes
	 */
	/*public void display()
	{
		System.out.println("\t" + this.date + "\n");
		for(Section sec : this.sections)
		{
			System.out.print("\t");
			sec.display();
		} 
	}*/
}
