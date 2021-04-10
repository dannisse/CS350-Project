package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Before;
//import org.junit.Test;    

public class TestFileImports {

	//Example code
		/*
		 public class ReadFileTest {

	    private Path workingDir;

	    @Before
	    public void init() {
	        this.workingDir = Path.of("", "src/test/resources");
	    }

	    @Test //example function
	    public void read() throws IOException {
	        Path file = this.workingDir.resolve("test.file");
	        String content = Files.readString(file);
	        assertThat(content, is("duke"));
	    }

	}    */

FileImports defaultFileImports;
	
	@Before
	public void setup() throws Exception {
	}
	
	@Test
	public static void TestSanitizePath()
	{
		FileImports f1 = new FileImports();
		//testpath is created to emulate a possible file parameter that the program might run into
		//the expected path is the expected output when the file is run
		String TestPath = "C:\\some:dir\\some:file\\"; 
		String expectedPath = "C:\\some:dir\\some:file"; 
		
		//checks that the expected path is the correct path with proper / at the end of it
		assertEquals(expectedPath,f1.sanitizePath(TestPath));
	}

	@Test
	public void TestExtractSection()
	{
		FileImports f1 = new FileImports();
		
		String line = "";//need to finish but 
		String expected = "";
		//provide a line that can be implemented into the function
		//assertThat(expected, f1.extractSection(line));
		
		//needs to also make sure that the " were removed and extraction is working properly
		
		//this will make sure that the seperations are working properly within extractSection
		//fail("Not yet implemented");
	}
	

	
	@Test
	public static void TestContainsDates()
	{
		
		FileImports f2 = new FileImports();
		//will test if there is a dates.txt file present or not. if there is a dates.txt file present
		//it will return false, if there is not a dates.txt file, present it will return true
		String present = "C:\\some:dir\\some:file\\dates.txt";
		String notpresent = "C:\\Users\\Documents\\";
		assertTrue(f2.containsDates(notpresent));
		assertFalse(f2.containsDates(present));
		
	}
}
