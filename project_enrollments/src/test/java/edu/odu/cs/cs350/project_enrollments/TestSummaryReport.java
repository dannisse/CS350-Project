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
		fail("Not yet implemented");
		
	}

	// TODO test for output of courses in current semester
			@Test
			public void testCoursesinCurrentSem() {
				/* 
			
    			@Before
    			public void init() {
        		this.workingDir = Path.of("", "src/test/resources");
    			}

    			@Test
    			public void read() throws IOException {
        		Path file = this.workingDir.resolve("test.file");
        		String content = Files.readString(file);
        		assertThat(content, is("output"));
    			}

}    
				*/
				fail("Not yet implemented");
			}

			//shows only lecture classes
			@Test 
			public void testShowLecture() {
			//Object DetailedReport = null;
			//private String DetailedReport = new String("Lecture");
			//assertThat(showLecture, hasItem(hasProperty("Course", is("Lecture"))));
			//assertThat(DetailedReport,matches("Lecture"));
			//assertThat(showLecture("Course", is("Lecture")));
				fail("Not yet implemented");
			}

}