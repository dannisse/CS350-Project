package edu.odu.cs.cs350.project_enrollments;

public class ProjectEnrollments {

	public static void main(String[] args) {
		int numArgs = 0;
		for (String s : args) {
			System.out.println(s);
			numArgs++;
		}
		System.out.println(numArgs);
	}

}
