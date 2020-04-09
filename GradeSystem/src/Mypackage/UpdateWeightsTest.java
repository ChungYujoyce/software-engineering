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
/**
 * 
 * Test the update score weights function.
 * 
 * Bugs: none known
 * 
 * @author       Huang Chung Yu
 * @version      1.0
 */

class UpdateWeightsTest {
	
	static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	static Scanner s;
	/** ------------------------------------------------------------------------------
	 * test testWeights_1()
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
	 * expected - (screen display) 
	 * 				"\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal-exam\t40%\n\tNew "
	 *				"weights:\n \tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal-exam\t20%\n"
	 *				"Are they correct? Y (Yes) or N (No)\n"
	 *  
	 *  */
	@Test
	void testWeights_1() {
		ByteArrayInputStream in = new ByteArrayInputStream("20 20 20 20 20\nY\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent));
		int[] weights = new int[] {10, 10, 10, 30, 40};
		System.setIn(System.in); 
		s = new Scanner(System.in);
		weights = UpdateWeights.weights(weights, s);
		assertEquals("\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal-exam\t40%\n\tNew "
				+ "weights:\n \tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal-exam\t20%\n"
				+ "Are they correct? Y (Yes) or N (No)\n", outContent.toString());
		System.setOut(null);
		
	}
	/** ------------------------------------------------------------------------------
	 * test testWeights_2()  
	 * This test is for UpdateWeights class 
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
	 * expected - (screen display) 
	 * 				"\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal-exam\t40%\nSum of 5 numbers should be 100, please try again~\n"
	 *		     	"\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal-exam\t40%\n"
	 *		    	"\tNew weights:\n \tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t10%\n\tfinal-exam\t30%\n"
	 *		    	"Are they correct? Y (Yes) or N (No)\n"
	 */
	@Test
	void testWeights_2() {
		ByteArrayInputStream in = new ByteArrayInputStream("20 20 20 10 90\n20 20 20 10 30\nY\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent));
		int[] weights = new int[] {10, 10, 10, 30, 40};
		System.setIn(System.in); 
		s = new Scanner(System.in);
		weights = UpdateWeights.weights(weights, s);
		
		assertEquals("\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal-exam\t40%\nSum of 5 numbers should be 100, please try again~\n"
				+ "\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal-exam\t40%\n"
				+ "\tNew weights:\n \tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t10%\n\tfinal-exam\t30%\n"
				+ "Are they correct? Y (Yes) or N (No)\n", outContent.toString());

	}
	/** ------------------------------------------------------------------------------
	 * test testcount_100_1()  ---> Test invalid user input weights
	 * This test is for UpdateWeights class 
	 * 
	 * Check if the use input weights are sum up as 100.
	 * 
	 * (screen)			 "lab1	10%
	 *					  lab2	10%
	 *					  lab3	10%
	 *					  mid-term	    30%
	 *					  final-exam	40%"
	 * (user input)	20 20 20 20 30				[invalid weights]
	 * (screen)		Please set the weights again...
	 * (user input) 20 20 20 20 20				[valid weights]
	 * (screen)		Are they correct? Y (Yes) or N (No)
	 * (user input) Y
	 * 
	 * assertTrue(count != 100) 20+20+20+20+30 = 110 != 100
	 * 
	 */
	@Test
	void testcount_100_1() {
		ByteArrayInputStream in = new ByteArrayInputStream("20 20 20 20 30\n20 20 20 20 20\nY\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent));
		int[] weights = new int[] {10, 10, 10, 30, 40};
		System.setIn(System.in); 
		int[] new_weights = new int[5];
		s = new Scanner(System.in);
		int count = UpdateWeights.count_100(s, 0, weights, new_weights);
		
		assertEquals("\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal-exam\t40%\n", outContent.toString());
		assertTrue(count != 100);
		
	}

	/** ------------------------------------------------------------------------------
	 * test testcount_100_2()   ---> Test invalid user input weights
	 * This test is for UpdateWeights class 
	 * 
	 * Check if the use input weights are sum up as 100.
	 * 
	 * (screen)			 "lab1	10%
	 *					  lab2	10%
	 *					  lab3	10%
	 *					  mid-term	    30%
	 *					  final-exam	40%"
	 * (user input)	20 20 20 20 30				[invalid weights]
	 * (screen)		Please set the weights again...
	 * (user input) 20 20 0 20 20				[invalid weights]
	 * (screen)		Please set the weights again...
	 * (user input) 10 10 10 35 35				[valid weights]
	 * (screen)		Are they correct? Y (Yes) or N (No)
	 * (user input) Y
	 * 
	 * assertTrue(count != 100) 20+20+0+20+20 = 80 != 100
	 * 
	 */
	@Test
	void testcount_100_2() {
		ByteArrayInputStream in = new ByteArrayInputStream("20 20 20 20 30\n20 20 0 20 20\n10 10 10 35 35\nY\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent)); 
		int[] weights = new int[] {10, 10, 10, 30, 40};
		System.setIn(System.in); 
		int[] new_weights = new int[5];
		s = new Scanner(System.in);
		int count = UpdateWeights.count_100(s, 0, weights, new_weights);
		
		assertEquals("\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal-exam\t40%\n", outContent.toString());
		assertTrue(count != 100);
		
	}
	/** ------------------------------------------------------------------------------
	 * test testMakesure_1()   ---> Test valid user input command
	 * This test is for UpdateWeights class 
	 * 
	 * Check whether the user decide to use the input weights for updating.
	 * 
	 * (screen)		Are they correct? Y (Yes) or N (No)	 
	 * (user input)	N							[valid command]
	 * (screen)		Please set the weights again...
	 * (user input) 20 10 10 20 40			    [valid weights]
	 * (screen)		Are they correct? Y (Yes) or N (No)
	 * (user input) Y
	 * 
	 * input - 
	 *  (user input) "N\n"
	 *	(user input) "20 10 10 20 40\n"
	 *	(user input) "Y\n"
	 * 
	 * expected -
	 * (screen display)
	 * 			"Please set the weights again...\n" 
	 *			"	lab1	10%\n" 
	 *			"	lab2	10%\n"  
	 *			"	lab3	10%\n"  
	 *			"	mid-term	30%\n"  
	 *			"	final-exam	40%\n"  
	 *			"	New weights:\n" 
	 * 			" 	lab1	20%\n"  
	 *			"	lab2	10%\n" 
	 *			"	lab3	10%\n" 
	 *			"	mid-term	20%\n"  
	 *			"	final-exam	40%\n"  
	 *			"Are they correct? Y (Yes) or N (No)\n"
	 * 
	 */
	@Test
	void testMakesure_1() {
		ByteArrayInputStream in = new ByteArrayInputStream("N\n20 10 10 20 40\nY\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent)); 
		System.setIn(System.in); 
		s = new Scanner(System.in);
		int[] weights = new int[] {10, 10, 10, 30, 40};
		String w = s.nextLine();
		UpdateWeights.makesure(w, weights, s);
		assertEquals("Please set the weights again...\n" + 
				"	lab1	10%\n" + 
				"	lab2	10%\n" + 
				"	lab3	10%\n" + 
				"	mid-term	30%\n" + 
				"	final-exam	40%\n" + 
				"	New weights:\n" + 
				" 	lab1	20%\n" + 
				"	lab2	10%\n" + 
				"	lab3	10%\n" + 
				"	mid-term	20%\n" + 
				"	final-exam	40%\n" + 
				"Are they correct? Y (Yes) or N (No)\n" , outContent.toString());
		
	}
	
	/** ------------------------------------------------------------------------------
	 * test testMakesure_2()  ---> Test invalid user input command
	 *
	 * This test is for UpdateWeights class 
	 * 
	 * Check whether the user decide to use the input weights for updating.
	 * 
	 * (screen)		Are they correct? Y (Yes) or N (No)	 
	 * (user input)	S							[invalid command]
	 *  (screen)	Wrong command, please try again...Y (Yes) or N (No)
	 * (user input) W							[invalid command]
	 * (screen)		Wrong command, please try again...Y (Yes) or N (No)
	 * (user input) Y   						[valid command]
	 * 
	 * input - 
	 *  (user input) "S\n"
	 *	(user input) "W\n"
	 *	(user input) "Y\n"
	 * 
	 * expected -
	 * (screen display)
	 * 			"Wrong command, please try again...Y (Yes) or N (No)\n"
	 *			"Wrong command, please try again...Y (Yes) or N (No)\n"
	 */
	@Test
	void testMakesure_2() {
		ByteArrayInputStream in = new ByteArrayInputStream("S\nW\nY\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent)); 
		int[] weights = new int[] {10, 10, 10, 30, 40};
		s = new Scanner(System.in);
		String w = s.nextLine();
		UpdateWeights.makesure(w, weights, s);
		
		assertEquals("Wrong command, please try again...Y (Yes) or N (No)\n"+
				"Wrong command, please try again...Y (Yes) or N (No)\n", outContent.toString());
		
	}

}
