package edu.odu.cs.cs350.project_enrollments;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sun.tools.javac.Main;

class TestSnapshot {

	
	Snapshot defaultsnapshot;
	
	@BeforeEach
	void setUp() throws Exception {
		
		defaultsnapshot = new Snapshot();
	}

	@Test
	void testSnapshot() {
		Snapshot s = new Snapshot();
		ArrayList<Section> arr = s.getSections();
		
		assertEquals(s.getDate(),"");
		assertEquals(s.getSections(), arr);
	}
	
	@Test
	void testSnapshotFile() {
		
		
		String path = "./bin/edu/odu/cs/cs350/project_enrollments/resources/201910/201910/2019-03-31.csv";
		File f = new File(path);
		
		Snapshot s = new Snapshot(f);
		
	}
}
