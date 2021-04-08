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
	public void setup()
	{
		defaultFileImports  = new FileImports();
	}
	
	@Test
	public void TestSanitizePath()
	{
		//testpath is created to emulate a possible file parameter that the program might run into
		//the expected path is the expected output when the file is run
		String TestPath = "C:\\Users\\Documents\\"; 
		String expectedPath = "C:\\Users\\Documents"; 
		
		//checks that the expected path is the correct path with proper / at the end of it
		assertEquals(defaultFileImports.sanitizePath(expectedPath), TestPath);
	}

	
//	@Test
//	public static boolean TestException()
//	{	
	


	
	
//	}
	
	//to see list of objects being created
	class CountedList extends ArrayList {
		  private static int counter = 0;
		  private int id = counter++;
		  public CountedList() {
		    System.out.println("CountedList #" + id);
		  }

		  public int getId() {
		    return id;
		  }
		}
	
	
}
