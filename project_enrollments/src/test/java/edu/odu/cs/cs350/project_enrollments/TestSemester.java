package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class TestSemester {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSemester() {
		//fail("Not yet implemented");
		Semester s1 = new Semester();
		//still need to check that the array existing and empty
		assertEquals(s1.getName(),"");
		assertEquals(s1.getRegistrationBegin(), 0);
		assertEquals(s1.getRegistrationEnd(), 0);
	}

	@Test
	void testSemesterStringStringString() {
		fail("Not yet implemented");
		//Semester s1 = new Semester();
		
		//Semester("201910","18-MAY-20","07-AUG-20");
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
		Semester si = new Semester();
		si.removeSnapshot(2);
		//Expected()
		
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
