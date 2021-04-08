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



	//shows only lecture classes
		@Test 
		public void testShowLecture() {
			final String testLecture = null;

		//assertThat(showLecture, hasItem(hasProperty("Course", is("Lecture"))));
		
		//assertThat(showLecture("Course", is("Lecture")));
		}
		
		//test for the output
		@Test
		public void testDreport(){
			
			fail("Not yet implemented");

		}
		
		
	}


	
	