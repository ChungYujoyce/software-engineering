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

class InputTest {

	static ByteArrayOutputStream outContent = new ByteArrayOutputStream();

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
