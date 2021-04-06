package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOffering {

	@BeforeEach
	void setUp() throws Exception {
	}

	//NEED TEST FOR DISPLAY
	
	@Test
	void testOffering() {
		Offering o1 = new Offering();
		
		assertEquals(o1.getSubject(), "");
		assertEquals(o1.getCourseNumber(), "");
		assertTrue(o1.getCourse()== o1.getSubject()+o1.getCourse());
		assertEquals(o1.getCrossListCap(), 0);
		assertEquals(o1.getEnrolled(), 0);
		assertEquals(o1.getXListGroup(), "");
		assertEquals(o1.getOverallCap(), 0);
		assertEquals(o1.getOverallEnr(), 0);
		assertEquals(o1.getInstructor(), "");
	}

	@Test
	void testOfferingSection() {
		Section s1 = new Section();
		Offering o2 = new Offering(s1);
	
		
		assertEquals(o2.getSubject(), "");
		assertEquals(o2.getCourseNumber(), "");
		assertTrue(o2.getCourse()== o2.getSubject()+o2.getCourse());
		assertEquals(o2.getCrossListCap(), 0);
		assertEquals(o2.getEnrolled(), 0);
		assertEquals(o2.getXListGroup(), "");
		assertEquals(o2.getOverallCap(), 0);
		assertEquals(o2.getOverallEnr(), 0);
		assertEquals(o2.getInstructor(), "");
	}

	@Test
	void testOfferingStringArray() {
		fail("Not yet implemented");
	}

	@Test
	void testSetSubject() {
		Offering o2 = new Offering();
		
		o2.setSubject("newSubj");
		
		assertNotNull(o2.getSubject());
		assertEquals(o2.getSubject(), "newSubj");
		
		assertEquals(o2.getCourseNumber(), "");
		assertTrue(o2.getCourse()== o2.getSubject()+o2.getCourse());
		assertEquals(o2.getCrossListCap(), 0);
		assertEquals(o2.getEnrolled(), 0);
		assertEquals(o2.getXListGroup(), "");
		assertEquals(o2.getOverallCap(), 0);
		assertEquals(o2.getOverallEnr(), 0);
		assertEquals(o2.getInstructor(), "");
	}

	@Test
	void testSetCourseNumber() {
		Offering o2 = new Offering();
	
		o2.setCourseNumber("12345");
		
		assertEquals(o2.getSubject(), "");
		assertNotNull(o2.getCourseNumber());
		assertEquals(o2.getCourseNumber(), "12345");
		
		assertTrue(o2.getCourse()== o2.getSubject()+o2.getCourse());
		assertEquals(o2.getCrossListCap(), 0);
		assertEquals(o2.getEnrolled(), 0);
		assertEquals(o2.getXListGroup(), "");
		assertEquals(o2.getOverallCap(), 0);
		assertEquals(o2.getOverallEnr(), 0);
		assertEquals(o2.getInstructor(), "");
	}

	@Test
	void testSetCrossListCap() {
		Section s1 = new Section();
		Offering o2 = new Offering(s1);
		Offering o1 = new Offering();
	
		o2.setCrossListCap(8);
		
		assertEquals(o2.getSubject(), "");
		assertEquals(o2.getCourseNumber(), "");
		assertTrue(o2.getCourse()== o2.getSubject()+o2.getCourse());
		assertEquals(o2.getCrossListCap(), 8);
		assertTrue(o2.getCrossListCap()!=o1.getCrossListCap());
		
		assertEquals(o2.getEnrolled(), 0);
		assertEquals(o2.getXListGroup(), "");
		assertEquals(o2.getOverallCap(), 0);
		assertEquals(o2.getOverallEnr(), 0);
		assertEquals(o2.getInstructor(), "");
	}

	@Test
	void testSetEnrolled() {
		Section s1 = new Section();
		Offering o2 = new Offering(s1);
	
		o2.setEnrolled(9);
		
		assertEquals(o2.getSubject(), "");
		assertEquals(o2.getCourseNumber(), "");
		assertTrue(o2.getCourse()== o2.getSubject()+o2.getCourse());
		assertEquals(o2.getCrossListCap(), 0);
		assertEquals(o2.getEnrolled(), 9);
		
		assertEquals(o2.getXListGroup(), "");
		assertEquals(o2.getOverallCap(), 0);
		assertEquals(o2.getOverallEnr(), 0);
		assertEquals(o2.getInstructor(), "");
	}

	//Continue here
	
	@Test
	void testSetXListGroup() {
		Section s1 = new Section();
		Offering o2 = new Offering(s1);
		
		o2.setXListGroup("NewXList");
		
		assertEquals(o2.getSubject(), "");
		assertEquals(o2.getCourseNumber(), "");
		assertTrue(o2.getCourse()== o2.getSubject()+o2.getCourse());
		assertEquals(o2.getCrossListCap(), 0);
		assertEquals(o2.getEnrolled(), 0);
		assertEquals(o2.getXListGroup(), "NewXlist");
		
		assertEquals(o2.getOverallCap(), 0);
		assertEquals(o2.getOverallEnr(), 0);
		assertEquals(o2.getInstructor(), "");
	}

	@Test
	void testSetOverallEnr() {
		Section s1 = new Section();
		Offering o2 = new Offering(s1);
	
		o2.setOverallEnr(9);
		
		assertEquals(o2.getSubject(), "");
		assertEquals(o2.getCourseNumber(), "");
		assertTrue(o2.getCourse()== o2.getSubject()+o2.getCourse());
		assertEquals(o2.getCrossListCap(), 0);
		assertEquals(o2.getEnrolled(), 0);
		assertEquals(o2.getXListGroup(), "");
		assertEquals(o2.getOverallCap(), 0);
		assertEquals(o2.getOverallEnr(), 9);
		
		assertEquals(o2.getInstructor(), "");
	}

	@Test
	void testSetInstructor() {
		Section s1 = new Section();
		Offering o2 = new Offering(s1);
	
		o2.setInstructor("NewInstructor");
		
		assertEquals(o2.getSubject(), "");
		assertEquals(o2.getCourseNumber(), "");
		assertTrue(o2.getCourse()== o2.getSubject()+o2.getCourse());
		assertEquals(o2.getCrossListCap(), 0);
		assertEquals(o2.getEnrolled(), 0);
		assertEquals(o2.getXListGroup(), "");
		assertEquals(o2.getOverallCap(), 0);
		assertEquals(o2.getOverallEnr(), 0);
		
		assertEquals(o2.getInstructor(), "NewInstructor");
	}

	@Test
	void testAddSection() {
		Section s1 = new Section();
		Offering o2 = new Offering(s1);
	
		o2.addSection(s1);
		
		assertEquals(o2.getSubject(), "");
		assertEquals(o2.getCourseNumber(), "");
		assertTrue(o2.getCourse()== o2.getSubject()+o2.getCourse());
		assertEquals(o2.getCrossListCap(), 0);
		assertEquals(o2.getEnrolled(), 0);
		assertEquals(o2.getXListGroup(), "");
		assertEquals(o2.getOverallCap(), 0);
		assertEquals(o2.getOverallEnr(), 0);
		assertEquals(o2.getInstructor(), "");
		
		assertTrue(o2.getSectionListSize()>0);
		assertFalse(o2.getSectionListSize()>1);
	}

	@Test
	void testDisplay() {
		fail("Not yet implemented");
	}

}
