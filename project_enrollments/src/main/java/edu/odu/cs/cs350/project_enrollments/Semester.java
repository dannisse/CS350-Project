package edu.odu.cs.cs350.project_enrollments;

import java.util.ArrayList;

@SuppressWarnings("PMD")
public class Semester {
	private String name;	// semester name should be in the form of "academicYear"+"semesterCode" ie 201910
	private ArrayList<Snapshot> snapshots;
	private String registrationBegin;	// first day of registration
	private String registrationEnd;		// last day of registration
	
	Semester() {
		name = "";
		snapshots = new ArrayList<Snapshot>();
		registrationBegin = "";
		registrationEnd = "";
	}
	
	Semester(String n, String b, String e) {
		// need to sanitize name somewhere
		name = n;
		snapshots = new ArrayList<Snapshot>();
		registrationBegin = b;
		registrationEnd = e;
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
	
	public Snapshot getSnapshot(int index) {
		return this.snapshots.get(index);
	}
	
	public String getRegistrationBegin() {
		return this.registrationBegin;
	}
	
	public String getRegistrationEnd() {
		return this.registrationEnd;
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
	
	public void setRegistrationBegin(String b) {
		this.registrationBegin = b;
	}
	
	public void setRegistrationEnd(String e) {
		this.registrationEnd = e;
	}
}
