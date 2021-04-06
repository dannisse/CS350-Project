package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSection {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testDefaultConstructor() {
		Section s1 = new Section();
		
		assertTrue(s1.getCourse()== s1.getSubj()+s1.getCrse());
		assertEquals(s1.getNum(),"");
		assertEquals(s1.getCRNum(), 0);
		assertEquals(s1.getEnr(), 0);
		assertEquals(s1.getCap(), 0);
		assertEquals(s1.getCRN(), 0);
		assertEquals(s1.getSubj(), 0);
	}

	@Test
	void testSectionStringArray() {
		fail("Not yet implemented");
	}

	@Test
	void testSectionSection() {
		fail("Not yet implemented");
	}

	@Test
	void testPrint() {
		fail("Not yet implemented");
	}

	@Test
	void testMathFR() {
		fail("Not yet implemented");
	}

	@Test
	void testSetEnr() {
		fail("Not yet implemented");
	}

	@Test
	void testSetCap() {
		fail("Not yet implemented");
	}

	@Test
	void testDisplay() {
		fail("Not yet implemented");
	}

}
