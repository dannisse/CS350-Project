package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSemester {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSemester() {
		fail("Not yet implemented");
	}

	@Test
	void testSemesterStringStringString() {
		fail("Not yet implemented");
	}

	@Test
	void testSemesterSemester() {
		fail("Not yet implemented");
	}

	@Test
	void testSetName() {
	
		Semester si = new Semester();
		
		si.setName("201910");  
		assertEquals(si.getName(), "201910"); 
		//make sure the name u set is equal
	}

	@Test
	void testAddSnapshot() {
		fail("Not yet implemented");
	}
	

	@Test
	void testRemoveSnapshot() {
		fail("Not yet implemented");
	}

	@Test
	void testSetRegistrationBegin() {
	
		Semester si = new Semester();
		
		 si.setRegistrationBegin("18-MAY-20");
		assertEquals(si.getRegistrationBegin(), "18-MAY-20"); 
		//make sure the name u set is equal
	}

	@Test
	void testSetRegistrationEnd() {
		
		Semester si = new Semester();
		
		 si.setRegistrationEnd("07-AUG-20");
		assertEquals(si.getRegistrationEnd(), "07-AUG-20"); 
		//make sure the name u set is equal

	}

}
