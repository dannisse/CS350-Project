package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matcher;
import org.junit.Before;

import org.junit.jupiter.api.Test;

class testDetailedProjectionReport {

	@Test
	void test() {
		fail("Not yet implemented");
	}

}

//shows only lecture classes
	@Test
	public void testLecture() {
	Object getLecture;
	Object testLecture;
	assertThat((testLecture).getLecture(), hasItem(hasProperty("Course", is("Lecture"))));
	}

	private Matcher hasItem(Object hasProperty) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object hasProperty(String string, Object object) {
	// TODO Auto-generated method stub
	return null;
}

	private Object is(String string) {
	// TODO Auto-generated method stub
	return null;
}}