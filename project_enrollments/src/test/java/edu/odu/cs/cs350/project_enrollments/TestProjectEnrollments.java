package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.*;
import org.junit.Before;
//import org.junit.Test; 

public class TestProjectEnrollments {
	
	
	ProjectEnrollments defaultProjectEnrollments;
	

	@Before
	public void setup()
	{
		defaultProjectEnrollments  = new ProjectEnrollments();
	}
	
	@Test
	public void TestgenerateOfferingsAndCourses() {
		fail("not yet implemented");
	}
	
	
	
}