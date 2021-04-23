package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matcher;
import org.junit.Before;

import org.junit.jupiter.api.Test;
	public class TestDetailedReport {

		DetailedReport defaultDetailedReport;
		
		@Before
		public void setup()
		{
			defaultDetailedReport  = new DetailedReport();
		}

		//TODO test for the output
		@Test
		public void testCreateExcel(){
			
			fail("Not yet implemented");

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
	
	