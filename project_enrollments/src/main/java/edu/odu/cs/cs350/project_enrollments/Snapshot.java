package edu.odu.cs.cs350.project_enrollments;

import java.io.File;
import java.util.ArrayList;

// A snapshot is a collection of information about sections on a certain day.
public class Snapshot {
	private String date;
	private ArrayList<Section> sections;
	

	// need to test this overall
	public Snapshot(File f) {
		String fileName = f.getName();
		if(!fileName.equals("dates.txt")) {
			date = f.getName();	// need to test: does this even work? the name should be something like "2019-04-01", or YYYY-MM-DD
			sections = FileImports.getAllSections(f);
		}
	}
	
	public String getDate() {
		return this.date;
	}
	
	public ArrayList<Section> getSections() {
		return this.sections;
	}
}
