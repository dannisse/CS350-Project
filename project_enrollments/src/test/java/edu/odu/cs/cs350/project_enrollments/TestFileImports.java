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
	public void TestSanitizePath()
	{
		FileImports f1 = new FileImports();
		//testpath is created to emulate a possible file parameter that the program might run into
		//the expected path is the expected output when the file is run
		String TestPath = "C:\\Users\\Documents\\"; 
		String expectedPath = "C:\\Users\\Documents"; 
		
		//checks that the expected path is the correct path with proper / at the end of it
		assertEquals(f1.sanitizePath(TestPath), expectedPath);
	}

	@Test
	public void TestGetAllSections()
	{
		fail("Not yet implemented");
	}
	
	@Test
	public  void TestContainsDates()
	{
		FileImports f2 = new FileImports();
		//will test if there is a daes.txt file present or not. if there is a dates.txt file present
		//it will return false, if there is not a dates.txt file present it will return true
		String present = "C:\\Users\\Documents\\dates.txt";
		String notpresent = "C:\\Users\\Documents\\";
		assertTrue(f2.containsDates(notpresent));
		assertFalse(f2.containsDates(present));
		
	}
}
