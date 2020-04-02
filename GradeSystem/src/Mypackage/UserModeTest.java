///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  UserModeTest.java
// Semester:         Spring 2020
// Course:			 Software Engineering
//
// Author:           Huang Chung Yu
//
///////////////////////////////////////////////////////////////////////////////

package Mypackage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
/**
 * Grades object testing.
 * Test i user input ID(correct/not correct) or Q(leave)
 * 
 * Bugs: none known
 * 
 * @author       Huang Chung Yu
 * @version      1.0
 */
class UserModeTest {
	static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	/** ------------------------------------------------------------------------------
	 * test testUser_mode()
	 * This test is for UserMode class 
	 * 
	 * (screen)		Enter ID of Q(finish usage)?
	 * (user input)	Q						[leave system]
	 * (screen)		Thanks for using!
	 * 
	 * input - (user input) "Q\n"
	 * 
	 * expected - (screen display) "Enter ID or Q(finish usage)?Thanks for using!\n"
	 */
	void testUser_mode() {
		ByteArrayInputStream in = new ByteArrayInputStream("Q\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		UserMode.user_mode();
		
		assertEquals("Enter ID or Q(finish usage)?\n", outContent.toString());
		
		System.setIn(System.in);
		System.setOut(null);
	}

}
