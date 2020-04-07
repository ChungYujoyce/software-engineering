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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

class InOutTest {

	static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	static Scanner s;
	@Test
	void testchoose_1() {
		ByteArrayInputStream in = new ByteArrayInputStream("A\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		s = new Scanner(System.in);
		InOut.choose(8, s);
		String expected = "Welcome~ ³\Öqµ®\n"+
				" 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
						+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
						+ "Leave Menu (enter: E)\n";
		String actuals =  outContent.toString();
		
		assertEquals(expected, actuals);
		
	}

	@Test
	void testchoose_2() {
		ByteArrayInputStream in = new ByteArrayInputStream("G\n".getBytes());
		System.setIn(in);
		
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		s = new Scanner(System.in);
		InOut.choose(23, s);
		String expected = "Welcome~ ¥v©ö¯³\n"+
		" 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
				+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
				+ "Leave Menu (enter: E)\n";
	    String actuals =  outContent.toString();
		
		assertEquals(expected, actuals);
	}


}
