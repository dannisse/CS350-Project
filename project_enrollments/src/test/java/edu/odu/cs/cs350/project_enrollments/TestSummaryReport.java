package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Before;
//import org.junit.Test; 

public class TestSummaryReport {

	
	SummaryReport defaultSummaryReport;
	
	
	@Before
	public void setup()
	{
		defaultSummaryReport  = new SummaryReport();
	}
	
	
	@Test
	public void TestDeadline(){
		
	}
}