package edu.odu.cs.cs350.project_enrollments;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class ProjectEnrollments {


	public static void main(String[] args) throws Exception{
	    Scanner sc = new Scanner(new File(".csv file"));
	    sc.useDelimiter(",");

	    while(sc.hasNext()) {
	        String s = sc.next() + ",";
	        System.out.print(s);
	    }

	    sc.close();
	}


}
