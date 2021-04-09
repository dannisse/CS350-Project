package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestOffering {

	@BeforeEach
	void setUp() throws Exception {
	}

	//NEED TEST FOR DISPLAY
	
	@Test
	void testOfferingDefault() {
		Offering o1 = new Offering();
		
		assertEquals(o1.getSubject(), "");
		assertEquals(o1.getCourseNumber(), "");
		assertEquals(o1.getCrossListCap(), 0);
		assertEquals(o1.getEnrolled(), 0);
		assertEquals(o1.getXListGroup(), "");
		assertEquals(o1.getOverallCap(), 0);
		assertEquals(o1.getOverallEnr(), 0);
		assertEquals(o1.getInstructor(), "");
		assertEquals(o1.getCourse(), o1.getSubject()+o1.getCourseNumber());
	}

	@Test
	void testOfferingSection() {
		Section s1 = new Section();
		Offering o2 = new Offering(s1);
	
		
		//assertEquals(o2.getSubject(), "");
		//assertEquals(o2.getCourseNumber(), "");
		//assertEquals(o2.getCrossListCap(), 0);
		//assertEquals(o2.getEnrolled(), 0);
		//assertEquals(o2.getXListGroup(), "");
		//assertEquals(o2.getOverallCap(), 0);
		//assertEquals(o2.getOverallEnr(), 0);
		//assertEquals(o2.getInstructor(), "");
		//assertEquals(o2.getCourse(), o2.getSubject()+o2.getCourseNumber());
	}

	@Test
	void testOfferingStringArray() {
		fail("Not yet implemented");
	}

	@Test
	void testSetSubject() {
		Offering o2 = new Offering();
		
		o2.setSubject("newSubj");
		
		assertEquals(o2.getSubject(), "newSubj");
		
		assertEquals(o2.getCourseNumber(), "");
		assertEquals(o2.getCrossListCap(), 0);
		assertEquals(o2.getEnrolled(), 0);
		assertEquals(o2.getXListGroup(), "");
		assertEquals(o2.getOverallCap(), 0);
		assertEquals(o2.getOverallEnr(), 0);
		assertEquals(o2.getInstructor(), "");
		assertEquals(o2.getCourse(), o2.getSubject()+o2.getCourseNumber());
	}

	@Test
	void testSetCourseNumber() {
		Offering o2 = new Offering();
	
		o2.setCourseNumber("12345");
		
		assertEquals(o2.getSubject(), "");
		assertEquals(o2.getCourseNumber(), "12345");
		
		assertEquals(o2.getCrossListCap(), 0);
		assertEquals(o2.getEnrolled(), 0);
		assertEquals(o2.getXListGroup(), "");
		assertEquals(o2.getOverallCap(), 0);
		assertEquals(o2.getOverallEnr(), 0);
		assertEquals(o2.getInstructor(), "");
		assertEquals(o2.getCourse(), o2.getSubject()+o2.getCourseNumber());
	}

	@Test
	void testSetCrossListCap() {
		Offering o2 = new Offering();
	
		o2.setCrossListCap(8);
		
		assertEquals(o2.getSubject(), "");
		assertEquals(o2.getCourseNumber(), "");
		assertEquals(o2.getCrossListCap(), 8);
		
		assertEquals(o2.getEnrolled(), 0);
		assertEquals(o2.getXListGroup(), "");
		assertEquals(o2.getOverallCap(), 0);
		assertEquals(o2.getOverallEnr(), 0);
		assertEquals(o2.getInstructor(), "");
		assertEquals(o2.getCourse(), o2.getSubject()+o2.getCourseNumber());
	}

	@Test
	void testSetEnrolled() {
		Offering o2 = new Offering();
	
		o2.setEnrolled(9);
		
		assertEquals(o2.getSubject(), "");
		assertEquals(o2.getCourseNumber(), "");
		assertEquals(o2.getCrossListCap(), 0);
		assertEquals(o2.getEnrolled(), 9);
		
		assertEquals(o2.getXListGroup(), "");
		assertEquals(o2.getOverallCap(), 0);
		assertEquals(o2.getOverallEnr(), 0);
		assertEquals(o2.getInstructor(), "");
		assertEquals(o2.getCourse(), o2.getSubject()+o2.getCourseNumber());
	}
	
	@Test
	void testSetXListGroup() {
		Offering o2 = new Offering();
		
		o2.setXListGroup("NewXList");
		
		assertEquals(o2.getSubject(), "");
		assertEquals(o2.getCourseNumber(), "");
		assertEquals(o2.getCrossListCap(), 0);
		assertEquals(o2.getEnrolled(), 0);
		assertEquals(o2.getXListGroup(), "NewXList");
		
		assertEquals(o2.getOverallCap(), 0);
		assertEquals(o2.getOverallEnr(), 0);
		assertEquals(o2.getInstructor(), "");
		assertEquals(o2.getCourse(), o2.getSubject()+o2.getCourseNumber());
	}

	@Test
	void testSetOverallEnr() {
		Offering o2 = new Offering();
	
		o2.setOverallEnr(9);
		
		assertEquals(o2.getSubject(), "");
		assertEquals(o2.getCourseNumber(), "");
		assertEquals(o2.getCrossListCap(), 0);
		assertEquals(o2.getEnrolled(), 0);
		assertEquals(o2.getXListGroup(), "");
		assertEquals(o2.getOverallCap(), 0);
		assertEquals(o2.getOverallEnr(), 9);
		
		assertEquals(o2.getInstructor(), "");
		assertEquals(o2.getCourse(), o2.getSubject()+o2.getCourseNumber());
	}

	@Test
	void testSetInstructor() {
		Offering o2 = new Offering();
	
		o2.setInstructor("NewInstructor");
		
		assertEquals(o2.getSubject(), "");
		assertEquals(o2.getCourseNumber(), "");
		assertEquals(o2.getCrossListCap(), 0);
		assertEquals(o2.getEnrolled(), 0);
		assertEquals(o2.getXListGroup(), "");
		assertEquals(o2.getOverallCap(), 0);
		assertEquals(o2.getOverallEnr(), 0);
		assertEquals(o2.getInstructor(), "NewInstructor");
		
		assertEquals(o2.getCourse(), o2.getSubject()+o2.getCourseNumber());
	}

	@Test
	void testAddSection() {
		Section s1 = new Section();
		Offering o2 = new Offering(s1);
	
		o2.addSection(s1);
		
		assertEquals(o2.getSubject(), "");
		assertEquals(o2.getCourseNumber(), "");
		assertEquals(o2.getCourse(), o2.getSubject()+o2.getCourseNumber());
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
