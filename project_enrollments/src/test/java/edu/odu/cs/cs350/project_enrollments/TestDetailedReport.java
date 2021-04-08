package edu.odu.cs.cs350.project_enrollments;

	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.Before;


	public class TestDetailedReport {

		DetailedReport defaultDetailedReport;
		
		@Before
		public void setup()
		{
			defaultDetailedReport  = new DetailedReport();
		}



	//shows only lecture classes
		@Test 
		void testShowLecture() {
			final String testLecture = null;

		//assertThat(showLecture, hasItem(hasProperty("Course", is("Lecture"))));
		
		assertThat(showLecture("Course", is("Lecture")));
		}
		
	}
}
