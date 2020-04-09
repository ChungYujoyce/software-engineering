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
import java.util.Scanner;
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
	static Scanner s;
	@Test
	/** ------------------------------------------------------------------------------
	 * test testUser_mode_1()
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
	void testUser_mode_1() {
		ByteArrayInputStream in = new ByteArrayInputStream("Q\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		s = new Scanner(System.in);
		UserMode.user_mode(s);
		
		assertEquals("Enter ID or Q(finish usage)?\n", outContent.toString());
		
	}
	/** ------------------------------------------------------------------------------
	 * test testUser_mode_2()
	 * This test is for UserMode class 
	 * 
	 * (screen)		Enter ID of Q(finish usage)?
	 * (user input)	962001051					[existing ID]
	 * (screen)		none switch to other Class
	 * 
	 * input - (user input) "962001051\n"
	 * 
	 * expected - (screen display) "Enter ID or Q(finish usage)?\n"
	 */
	@Test
	void testUser_mode_2() {
		ByteArrayInputStream in = new ByteArrayInputStream("962001051\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));	
		s = new Scanner(System.in);
		UserMode.user_mode(s);
		
		assertEquals("Enter ID or Q(finish usage)?\n", outContent.toString());
		
	}
	/** ------------------------------------------------------------------------------
	 * test testUser_mode_3()
	 * This test is for UserMode class 
	 * 
	 * (screen)		Enter ID of Q(finish usage)?
	 * (user input)	12333						[non-existing ID]
	 * (screen)		Sorry, your ID was wrong, please try again~
	 * (user input) 962001051					[existing ID]
	 * (screen)		none switch to other Class
	 * 
	 * 
	 * input - (user input) "12333\n"
	 * 						"962001051\n"
	 * 
	 * expected - (screen display) "Enter ID or Q(finish usage)?\nSorry, your ID was wrong, please try again~\n"
	 */
	@Test
	void testUser_mode_3() {
		ByteArrayInputStream in = new ByteArrayInputStream("12333\n962001051\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent));	
		s = new Scanner(System.in);
		UserMode.user_mode(s); 
		assertEquals("Enter ID or Q(finish usage)?\nSorry, your ID was wrong, please try again~\n", outContent.toString()); 
	}


}
