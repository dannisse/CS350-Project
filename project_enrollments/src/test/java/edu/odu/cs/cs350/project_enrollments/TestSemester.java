package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.ArrayList;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;


@SuppressWarnings("PMD")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestSemester {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSemester() {
		Semester s1 = new Semester();
		ArrayList<Snapshot> snapshots = new ArrayList<Snapshot>();
		
		assertEquals(snapshots.size(), 0);
		assertEquals(s1.getName(),"");
		assertEquals(s1.getRegistrationBegin(), "");
		assertEquals(s1.getRegistrationEnd(), "");
	}

	@Test
	void testSemesterStringStringString() {
		//fail("Not yet implemented");
		Semester s1 = new Semester("201910","18-MAY-20","07-AUG-20");
		
		assertEquals("201910" , s1.getName());	
		assertEquals("18-MAY-20" , s1.getRegistrationBegin());	
		assertEquals("07-AUG-20" , s1.getRegistrationEnd());	
		}
	

	@Test
	void testSemesterSemester() {
		
		//fail("Not yet implemented");
		// i believe this is correct?
		Semester s1 = new Semester();
		Semester s2 = new Semester(s1);
		
		assertEquals(s2.getName(), s1.getName());
		assertEquals(s2.getSnapshots(), s1.getSnapshots());
	}

	@Test
	void testSetName() {
	
		Semester si = new Semester();
		
		si.setName("201910");  
		assertEquals("201910", si.getName()); 
		//make sure the name you set is equal
	}

	@Test
	void testAddSnapshot() {
		fail("Not yet implemented");
		Semester s1 = new Semester();
		File f = new File ("C:/some:dir/some:file/file.txt");
		Snapshot snap = new Snapshot(f);
		
		s1.addSnapshot(snap);
		
		
		assertEquals(s1.getName(), "file.txt");  //?? have to fix this test
		assertEquals(s1.getRegistrationBegin(), "");
		assertEquals(s1.getRegistrationEnd(), "");
	}
	

	@Test
	public void testRemoveSnapshot() {
		fail("Not yet implemented");
		//Semester si = new Semester();
		//File f = new File ("D:/blue/file.txt");
		//Snapshot snap = new Snapshot(f);
		 //not working need to fix
		
		//si.addSnapshot(snap);
	//	assertEquals(snap, si.getSnapshots());
		
	}

	@Test
	void testSetRegistrationBegin() {
	
		Semester si = new Semester();
		
		 si.setRegistrationBegin("18-MAY-20");
		assertEquals("18-MAY-20", si.getRegistrationBegin()); 
		//make sure the name you set is equal
	}

	@Test
	void testSetRegistrationEnd() {
		
		Semester si = new Semester();
		
		 si.setRegistrationEnd("07-AUG-20");
		assertEquals( "07-AUG-20", si.getRegistrationEnd()); 
		//make sure the name you set is equal

	}

}
