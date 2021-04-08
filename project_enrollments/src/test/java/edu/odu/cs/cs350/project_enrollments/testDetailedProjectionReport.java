package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;


class testDetailedProjectionReport {

	//testDetailedProjectionReport defaultDetailedProjectionReport;
	DetailedProjecto
	@Before
	public void setup()
	{
		defaultDetailedProjectionReport  = new testDetailedProjectionReport();
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}



//shows only lecture classes
	@Test 
	void testShowLecture() {
		final String testLecture = null;

	//assertThat(showLecture, hasItem(hasProperty("Course", is("Lecture"))));
	
	assertThat(showLecture("Course", is("Lecture")));
	}
	
}