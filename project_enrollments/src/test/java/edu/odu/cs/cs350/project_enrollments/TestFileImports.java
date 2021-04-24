package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.File;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Before;
import java.io.InputStream;
import java.lang.Object;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import org.junit.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.*;



//import org.junit.Test;    
@SuppressWarnings("PMD")
public class TestFileImports {
	FileImports fileimports;
	  private final InputStream systemIn = System.in;
	    private final PrintStream systemOut = System.out;
	    private ByteArrayInputStream testIn;
	    private ByteArrayOutputStream testOut;
	    
	    @Before
	    public void setUpOutput() {
	        testOut = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(testOut));
	    }
	    private String getOutput() {
	        return testOut.toString();
	    }

	    @After
	    public void restoreSystemInputOutput() {
	        System.setIn(systemIn);
	        System.setOut(systemOut);
	    }

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
		String testPath = "C:/Documents/Historic";
		String expectedPath = "C:/Documents/Historic/";
		assertEquals(expectedPath,FileImports.sanitizePath(testPath));
	}


	
	@Test
	public void TestvalidateUrl() {
		
		
		
		String TestURL = "https://www.cs.odu.edu/~zeil/courseSchedule/History/201720/2017-01-01.csv";
		String OtherURL = "https://www.cs.odu.edu/~zeil/courseSchedule/History/";
		
		
		assertTrue(FileImports.validateUrl(TestURL));
		assertFalse(FileImports.validateUrl(OtherURL));
		

	}
	
	//to see list of objects being created
	class CountedList extends ArrayList {
		  private int counter = 0;
		  private int id = counter++;
		  public CountedList() {
		    System.out.println("CountedList #" + id);
		  }

		  public int getId() {
		    return id;
		  }
		}
	
	
	@Test
	public void TestContainsDates()
	{
		assertTrue(FileImports.containsDates("./src/test/resources/201910/201910/"));
		assertFalse(FileImports.containsDates("./src/test/resources/201910/"));
		
	}
	
}