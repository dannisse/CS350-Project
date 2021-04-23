package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.ArrayList;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestSemester {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSemester() {
		Semester s1 = new Semester();
		
		assertEquals(s1.getName(),"");
		assertEquals(s1.getRegistrationBegin(), "");
		assertEquals(s1.getRegistrationEnd(), "");
		assertEquals(s1.snapshotsSize(), 0);
	}

	@Test
	void testSemesterStringStringString() {
		String n = "";
		String b = "";
		String e = "";
		Semester s1 = new Semester(n, b, e);
		
		assertEquals(n, s1.getName());	
		assertEquals(b , s1.getRegistrationBegin());	
		assertEquals(e, s1.getRegistrationEnd());	
		assertEquals(s1.snapshotsSize(), 0);
		}
	

	@Test
	void testSemesterSemester() {
		
	
		Semester s1 = new Semester();
		Semester s2 = new Semester(s1);
		
		assertEquals(s2.getName(), s1.getName());
		assertEquals(s2.getSnapshots(), s1.getSnapshots());
		assertEquals(s1.snapshotsSize(), s2.snapshotsSize());
	}

	@Test
	void testSetName() {
	
		Semester si = new Semester();
		
		si.setName("201910");  
		
		assertEquals(si.getName(),"201910" ); 
		assertEquals(si.getRegistrationBegin(),""); 
		assertEquals(si.getRegistrationEnd(), ""); 
		assertEquals(si.snapshotsSize(), 0);
		
	}

	@Test
	void testAddSnapshot() {
		
		Snapshot sn = new Snapshot();
		Semester s1 = new Semester();
		
		s1.addSnapshot(sn);
		
		assertEquals("", s1.getName());	
		assertEquals("", s1.getRegistrationBegin());	
		assertEquals("", s1.getRegistrationEnd());	
		assertEquals(s1.snapshotsSize(), 1);
		
		//TODO need to fix implemnetation, not working properly atm
		/*
		 * Semester s1 = new Semester(); File f = new File
		 * ("C:/some:dir/some:file/file.txt"); Snapshot snap = new Snapshot(f);
		 * 
		 * s1.addSnapshot(snap);
		 * 
		 * 
		 * assertEquals(s1.getName(), "file.txt"); //?? have to fix this test
		 * assertEquals(s1.getRegistrationBegin(), "");
		 * assertEquals(s1.getRegistrationEnd(), "");
		 */
	}
	

	@Test
	public void testRemoveSnapshot() {
		Snapshot sn = new Snapshot();
		Semester s1 = new Semester();
		
		s1.addSnapshot(sn);
		
		assertEquals("", s1.getName());	
		assertEquals("", s1.getRegistrationBegin());	
		assertEquals("", s1.getRegistrationEnd());
		assertEquals(s1.snapshotsSize(), 1);
		
		s1.removeSnapshot(0);
		
		assertEquals(s1.snapshotsSize(), 0);
		
	
	}

	@Test
	void testSetRegistrationBegin() {
	
		Semester si = new Semester();
		
		 si.setRegistrationBegin("18-MAY-20");
		 
		 assertEquals(si.getName(),"" ); 
		assertEquals( si.getRegistrationBegin(), "18-MAY-20"); 
		assertEquals(si.getRegistrationEnd(),"");
		assertEquals(si.snapshotsSize(), 0);
	}

	@Test
	void testSetRegistrationEnd() {
		
		Semester si = new Semester();
		
		 si.setRegistrationEnd("07-AUG-20");
		 
		assertEquals(si.getName(),"" ); 
		assertEquals(si.getRegistrationBegin(),""); 
		assertEquals(si.getRegistrationEnd(),"07-AUG-20");
		assertEquals(si.snapshotsSize(), 0);

	}

}
