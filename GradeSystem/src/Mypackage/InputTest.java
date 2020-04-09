///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  Main.java
// Semester:         Spring 2020
// Course:			 Software Engineering
//
// Author:           Huang Chung Yu
//
///////////////////////////////////////////////////////////////////////////////

package Mypackage;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
/**
 * 
 * Test the read data file function.
 * 
 * Bugs: none known
 * 
 * @author       Huang Chung Yu
 * @version      1.0
 */

class InputTest {

	static ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	/** ------------------------------------------------------------------------------
	 * test testRead_1()
	 * This test is for Input class 
	 * 
	 * Manaully input the target student information,
	 * expect to get the correct scores and names.
	 * 
	 * input1 - "¶À´Â°¶"
	 * 		(ID, name, lab1, lab2, lab3, mid-term, final-exam) 
	 * input2 - '985002510, 0, 91, 97, 82, 98, 81'
	 * 
	 * expected1 - "¶À´Â°¶"
	 * 		(ID, name, lab1, lab2, lab3, mid-term, final-exam) 
	 * expected2 - '985002510, 0, 91, 97, 82, 98, 81'
	 * 
	 * input1 should equals expected1
	 * input2 should equals expected2
	 * 
	 * */
	@Test
	void testRead_1() {
		
		Info info = Input.read();		
		String expected1 = "¶À´Â°¶";
		String actuals1 =  info.names[55].toString();
		
		int [] expected2 = {985002510, 0, 91, 97, 82, 98, 81};
		int [] actuals2 =  info.scores[55];

		assertEquals(expected1, actuals1);
		assertTrue(Arrays.equals(expected2, actuals2));
		
	}
	/** ------------------------------------------------------------------------------
	 * test testRead_2()
	 * This test is for Input class 
	 * 
	 * Manaully input the target student information,
	 * expect to get the correct scores and names.
	 * 
	 * input1 - "³\Öqµ®"
	 * 		(ID, name, lab1, lab2, lab3, mid-term, final-exam) 
	 * input2 - '975002039, 0, 97, 84, 87, 99, 89'
	 * 
	 * expected1 - "³\Öqµ®"
	 * 		(ID, name, lab1, lab2, lab3, mid-term, final-exam) 
	 * expected2 - '975002039, 0, 97, 84, 87, 99, 89'
	 * 
	 * input1 should equals expected1
	 * input2 should equals expected2
	 * 
	 * */
	@Test
	void testRead_2() {
		
		Info info = Input.read();		
		String expected1 = "³\Öqµ®";
		String actuals1 =  info.names[8].toString();
		
		int [] expected2 = {975002039, 0, 97, 84, 87, 99, 89};
		int [] actuals2 =  info.scores[8];
		
		assertEquals(expected1, actuals1);
		assertTrue(Arrays.equals(expected2, actuals2));
		
	}

	
}
