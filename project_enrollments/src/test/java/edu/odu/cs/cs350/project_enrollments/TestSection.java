 package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestSection {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testDefaultConstructor() {
		Section s1 = new Section();
		
		assertEquals(s1.getNum(), 000);
		assertEquals(s1.getCRNum(), 0);
		assertEquals(s1.getEnr(), 0);
		assertEquals(s1.getCap(), "0");
		assertEquals(s1.getCRN(), "0");
		assertEquals(s1.getSubj(), "");
		assertEquals(s1.getCrse(), "000L");
		assertEquals(s1.getCourse(), s1.getSubj()+s1.getCrse());
	}

	@Test
	void testSectionStringArray() {
		String line = "\"20\",\"13947\",\"CS\",\"120G\",\"INTRO INFO LIT & RSCH REC (A)\",\"0\",\"20\",\"0\",\"H3\",\"1X\",\"C\",\"I\",\"E\","
				+ "\"SYNC\",\"Y\",\" 545- 635PM\",\"R\",\"WEB5\",\"\",\"O\",\"ZEHRA,S\",\"\",\"20\",\"0\",\"1\",\"SYNC\",\"24-AUG-19\",\"06-DEC-19\","
				+ "\"0\",\"0\",\"0\",\"RECITATION. YOU MUST ALSO REGISTER FOR THE ONLINE (A) LECTURE\"";
		String[] fields = line.split("\",\"");
		Section s1 = new Section(fields);
			
		assertEquals(s1.getNum(),120);
		assertEquals(s1.getCRNum(), Integer.parseInt(fields[1]));
		assertEquals(s1.getEnr(), Integer.parseInt(fields[7]));
		assertEquals(s1.getCap(), fields[22]);
		assertEquals(s1.getCRN(), fields[1]);
		assertEquals(s1.getSubj(), fields[2]);
		assertEquals(s1.getCourse(), s1.getSubj()+s1.getCrse());
	}

	@Test
	void testSectionCopy() {
		String line = "\"20\",\"13947\",\"CS\",\"120G\",\"INTRO INFO LIT & RSCH REC (A)\",\"0\",\"20\",\"0\",\"H3\",\"1X\",\"C\",\"I\",\"E\","
				+ "\"SYNC\",\"Y\",\" 545- 635PM\",\"R\",\"WEB5\",\"\",\"O\",\"ZEHRA,S\",\"\",\"20\",\"0\",\"1\",\"SYNC\",\"24-AUG-19\",\"06-DEC-19\","
				+ "\"0\",\"0\",\"0\",\"RECITATION. YOU MUST ALSO REGISTER FOR THE ONLINE (A) LECTURE\"";
		String[] fields = line.split("\",\"");
		Section s1 = new Section(fields);
		Section s2 = new Section(s1);
		
		assertEquals(s2.getNum(), s1.getNum());
		assertEquals(s2.getCRNum(), s1.getCRNum());
		assertEquals(s2.getEnr(), s1.getEnr());
		assertEquals(s2.getCap(), s1.getCap());
		assertEquals(s2.getCRN(), s1.getCRN());
		assertEquals(s2.getSubj(), s1.getSubj());
		assertEquals(s2.getCourse(), s1.getCourse());
	}

	@Test
	void testSetEnr() {
		Section s1 = new Section();
		
		s1.setEnr(90);
		
		assertEquals(s1.getNum(), 000);
		assertEquals(s1.getCRNum(), 0);
		assertEquals(s1.getEnr(), 90);
		
		assertEquals(s1.getCap(), "0");
		assertEquals(s1.getCRN(), "0");
		assertEquals(s1.getSubj(), "");
		assertEquals(s1.getCrse(), "000L");
		assertEquals(s1.getCourse(), s1.getSubj()+s1.getCrse());
	}

	@Test
	void testSetCap() {
		Section s1 = new Section();
		
		s1.setCap(90);
		
		assertEquals(s1.getNum(), 000);
		assertEquals(s1.getCRNum(), 0);
		assertEquals(s1.getEnr(), 0);
		assertEquals(s1.getCap(), "90");
		assertEquals(s1.getCRN(), "0");
		assertEquals(s1.getSubj(), "");
		assertEquals(s1.getCrse(), "000L");
		assertEquals(s1.getCourse(), s1.getSubj()+s1.getCrse());
	}
	
	//TODO finish these functions up 
/*	@Test
	void testMathFR() {
		
		fail("Not yet implemented");
	}

	@Test
	void testDisplay() {
		fail("Not yet implemented");
	}

	@Test
	void testPrint() {
		fail("Not yet implemented");
	}*/
}
