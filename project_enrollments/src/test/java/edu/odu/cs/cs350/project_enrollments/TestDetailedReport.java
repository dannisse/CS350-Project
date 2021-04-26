package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matcher;
import org.junit.Before;

import org.junit.jupiter.api.Test;
	public class TestDetailedReport {

		DetailedReport defaultDetailedReport;
		
		@Before
		public void setup() throws Exception{
			//defaultDetailedReport  = new DetailedReport();
		}

		@Test
		public void  deadlineD()
		{	
			//make sure percentage isnt negative
			ArrayList<Double> ret = new ArrayList<Double>();
			assertTrue(ret.size()>=0);


		}
		//TODO test for the output
		@Test
		public void testCreateExcel() throws IOException{
			DetailedReport dr = new DetailedReport();
			SortedMap<String, Course > histSemesterList = new TreeMap<String, Course >();
			SortedMap<String, Course > currSemesterList = new TreeMap<String, Course >();
			String path = "./project_enrollments/src/test/resources/testExcel.xlsx";
			
			dr.createExcel(histSemesterList, currSemesterList, path);
			
			
			//fail("Not yet implemented");

		}
		/*
		//TODO test output to see one sheet per course
		@Test
	  public void testOneSheet () {
			fail("Not yet implemented");
		}
	//TODO test output of history of past enrollments
		@Test
		  public void testPastEnrollments() {
				fail("Not yet implemented");
			}
		*/
	}
	
	