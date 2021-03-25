package edu.odu.cs.cs350.project_enrollments;

import java.io.*;
import java.util.Scanner;



public class ProjectEnrollments {

	public static void main(String args[]) throws Exception{
		String path = args[0];
		
		if(FileImports.exception(path) == false) {
			FileImports.findFile(path);
		
	    /*Scanner sc = new Scanner(new File(path + "2016-02-01.csv"));
	    sc.useDelimiter(",");

	    while(sc.hasNext()) {
	        String s = sc.next() + ",";
	        System.out.print(s);
	    }

	    sc.close();*/
	}
	}

}