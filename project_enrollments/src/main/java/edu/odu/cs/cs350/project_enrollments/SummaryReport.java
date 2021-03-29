package edu.odu.cs.cs350.project_enrollments;

import java.io.File;
import java.util.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.text.*;

public class SummaryReport {
	public static Date d3;
	public static long st;
	

	public static void deadlineD(String path) throws Throwable {
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		File directoryPath = new File(path);	    
	    File filesList[] = directoryPath.listFiles();
	    Date d1;
	    Date d2;
	    long diffInMillies;
	    long diff;
	    long perc;
	    String d;
	    
	    Scanner sc = null;
	    for(File file : filesList) {	
			sc = new Scanner(new File(path + file.getName()));
			String t = file.getName();
			if(!t.equals("dates.txt")) {
				d = file.getName();
				d=d.substring(0,10);
				//System.out.print("Snap format: " + d + "\n");
				//d3 = sdformat.parse(d);
				d3 = sdformat.parse(d);
				//System.out.print("Snap Date: " + d3 + "\n");
			}
			if(t.equals("dates.txt")) {		
				
				d1 = sdformat.parse(sc.nextLine());
				//Date d2 = sdformat.parse(sc.next());
				d2 = sdformat.parse(sc.next());
				//System.out.print(d1 +"\n");
				//System.out.print(d2 + "\n");
				
				diffInMillies = Math.abs(d2.getTime() - d1.getTime());
				diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
				perc = diff;
				
				//System.out.print("difference: " + diff + "\n");
				diffInMillies = (d3.getTime() - d1.getTime());
				diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
				//System.out.print("Third: " + diff + "\n");
				//System.out.print("percentage: " + diff + " " + perc + "\n");
				st = (diff*100)/perc;
				if(st <= 0){
					//System.out.print("percentage: %" + 0);
					st=0;
				}else if(st >= 100){
					//System.out.print("percentage: %" + 100);
					st = 100;
				}//else
					//System.out.print("percentage: %" + st);
				//System.exit(0);
			}
			
			sc.close();
	    }
	}
	
	
	
	public static void sReport() {
		System.out.print(st + "% of enrollment period has elapsed. \n");
		System.out.print(" Course\tEnrollment\tProjected\tCap \n");
		
	}
}
