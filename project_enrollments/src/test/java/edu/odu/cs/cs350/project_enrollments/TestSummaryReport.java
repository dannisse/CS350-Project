package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Before;
//import org.junit.Test; 

public class TestSummaryReport {

	
	SummaryReport defaultSummaryReport;
	
	
	@Before
	public void setup()
	{
	}
	
	
	@Test
	public void TestDeadline() throws Throwable{
		SummaryReport sr1 = new SummaryReport();
		
		sr1.deadlineD("./src/test/resources/201910/201910/");
		
		//fail("Not yet implemented");
		
	}

	
	@Test
	public void testSReport() {
		SummaryReport sr1 = new SummaryReport();
		SortedMap<String, Course > currSemesterList = new TreeMap<String, Course >();
		
		sr1.sReport(currSemesterList);
		
		
				
		//fail("Not yet implemented");
	}
	
	@Test
	public void TestgenerateOfferingsAndCourses() throws IOException {
		SummaryReport sr1 = new SummaryReport();
		
		Semester currSemester = new Semester();
		String path = FileImports.sanitizePath("./src/test/resources/201910/201910/");
		if (FileImports.containsDates(path)) {
			//todo: need to give semester name and start and end dates
			
			ArrayList<File> filesList = FileImports.getFiles(path);
			for (File f: filesList) {
				String fileName = f.getName();
				
				// Make sure we're not adding dates.txt
				if(!fileName.equals("dates.txt")) {
					Snapshot snap = new Snapshot(f);
					currSemester.addSnapshot(snap);
				}
			}
		}
		ArrayList<Snapshot> currSnapshots = currSemester.getSnapshots();
		
		Snapshot lastCurrSnapshot = currSnapshots.get(currSnapshots.size() - 1);
		ArrayList<Section> currSections = lastCurrSnapshot.getSections();
		
		SortedMap<String, Course > currSemesterList = new TreeMap<String, Course >();
		sr1.generateOfferingsAndCourses(currSections, currSemesterList);
		
		
		//fail("not yet implemented");
	}

}