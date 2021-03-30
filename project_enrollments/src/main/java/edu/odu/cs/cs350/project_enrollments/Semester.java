package edu.odu.cs.cs350.project_enrollments;

import java.util.ArrayList;

public class Semester {
	private String name;	// semester name should be in the form of "academicYear"+"semesterCode" ie 201910
	private ArrayList<Snapshot> snapshots;
	
	Semester() {
		name = "";
		snapshots = new ArrayList<Snapshot>();
	}
	
	Semester(String n) {
		// need to sanitize name somewhere
		name = n;
		snapshots = new ArrayList<Snapshot>();
	}
	
	Semester(Semester s) {
		this.name = s.getName();
		this.snapshots = s.getSnapshots();
	}
	
	public String getName()  {
		return this.name;
	}
	
	public ArrayList<Snapshot> getSnapshots() {
		return this.snapshots;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public void addSnapshot(Snapshot s) {
		snapshots.add(s);
	}
	
	public void removeSnapshot(int index) {
		snapshots.remove(index);
	}
}
