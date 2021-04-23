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
		//FileImports f1 = new FileImports();
		//testpath is created to emulate a possible file parameter that the program might run into
		//the expected path is the expected output when the file is run
		
		final String testPath = "C:/Documents/Historic";
		final String expectedPath = "C:/Documents/Historic/";
		//checks that the expected path is the correct path with proper / at the end of it
		assertEquals(expectedPath,FileImports.sanitizePath(testPath));
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
		fail("Not yet implemented");
	}
	
//	@Test
//	public static boolean TestException()
//	{	
	
	
	
//	}
	
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
		//fail("Not yet implemented");
		//FileImports f2 = new FileImports();
		//will test if there is a dates.txt file present or not. if there is a dates.txt file present
		//it will return false, if there is not a dates.txt file, present it will return true
		//need to fetch users supplied file directory 
		//String present = "D:/blue/historic/dates.txt";	
		//String notpresent = "D:/blue/historic/";
		//assertTrue(FileImports.containsDates(notpresent));
		//assertFalse(FileImports.containsDates(present));
		
		


		//Pattern pattern = Pattern.compile("(?<!\\S)"+ "dates.txt");
		// this doesn't compile...
		//i know im attempting to fix it atm 
		
		//gonna fix this tmmr
		String path = "(?<!\\S)" + "dates.txt";
		assertTrue(FileImports.containsDates("(?<!\\S)"));
		assertFalse(FileImports.containsDates("(?<!\\S)" + "dates.txt"));
		//Document doc;
		//assertThat(doc.select("a[href]").text(),is("dates.txt"));
		
	}
	
}