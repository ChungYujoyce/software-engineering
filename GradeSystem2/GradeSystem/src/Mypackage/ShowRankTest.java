package Mypackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ShowRankTest {

	static Student student;
	static ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeEach
	void setUp() throws Exception {
		student = new Student();
		student.setName("³\¤åÄÉ");
		student.setScore(92.5f);
	}

	@AfterEach
	void tearDown() throws Exception {
		student = null;	
	}
	
	@Test
	void testShowrank_1() {
		
	}
	
	@Test
	void testShowrank_2() {
		fail("Not yet implemented");
	}
	
	@Test
	void testSort_1() {
		int []num = {87,32,79,55,56};
		int []expect = {32,55,56,79,87};
		int []actual = sort(Students, 63);
	}
	
	@Test
	void testSort_2() {
		fail("Not yet implemented");
	}

}
