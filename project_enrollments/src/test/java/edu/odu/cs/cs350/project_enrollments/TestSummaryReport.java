package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
		
		fail("Not yet implemented");
		
	}

	
	@Test
	public void testSReport() {
		SummaryReport sr1 = new SummaryReport();
		SortedMap<String, Course > currSemesterList = new TreeMap<String, Course >();
		
		sr1.sReport(currSemesterList);
		
		
				
		fail("Not yet implemented");
	}


}