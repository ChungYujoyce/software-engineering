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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * 
 * Test the show average function.
 * 
 * Bugs: none known
 * 
 * @author       Huang Chung Yu
 * @version      1.0
 */
class ShowAverageTest {

	static ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	/** ------------------------------------------------------------------------------
	 * test testAverage_1()
	 * This test is test the calculation of score average
	 * 
	 * 
	 * input name - "½²©v½Ã"
	 * 		(lab1, lab2, lab3, mid-term, final-exam) 
	 * input scores - 84 92 98 94 99
	 * 
	 * expected name - "½²©v½Ã"
	 * 		(lab1, lab2, lab3, mid-term, final-exam) 
	 * expected scores - 84 92 98 94 99
	 * 
	 * input name should equals name
	 * input scores should equals scores
	 * 
	 * */
	
	@Test
	void testAverage_1() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		int [][] scores = new int[63][7];
		int[] weights = new int[] {10, 10, 10, 30, 40};
		String[] names = new String [63];
		names[0] = "½²©v½Ã";
	    scores[0][0] = 985002509;
		scores[0][2] = 84;
		scores[0][3] = 92;
		scores[0][4] = 98;
		scores[0][5] = 94;
		scores[0][6] = 99;
		ShowAverage.average(54, weights);	
		String expected = "Average of ½²©v½Ã is: 95.2\n";
		String actuals =  outContent.toString();
		
		assertEquals(expected, actuals);
		System.setOut(null);
	}

	/** ------------------------------------------------------------------------------
	 * test testAverage_2()
	 * This test is test the calculation of score average
	 * 
	 * input name - "³\¤åÄÉ"
	 * 		(lab1, lab2, lab3, mid-term, final-exam) 
	 * input scores - 88 92 88 98 91
	 * 
	 * expected name - "³\¤åÄÉ"
	 * 		(lab1, lab2, lab3, mid-term, final-exam) 
	 * expected scores - 88 92 88 98 91
	 * 
	 * input name should equals name
	 * input scores should equals scores
	 * 
	 * */
	@Test
	void testAverage_2() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		int [][] scores = new int[63][7];
		int[] weights = new int[] {10, 10, 10, 30, 40};
		String[] names = new String [63];
		names[0] = "³\¤åÄÉ";
	    scores[0][0] = 955002056;
		scores[0][2] = 88;
		scores[0][3] = 92;
		scores[0][4] = 88;
		scores[0][5] = 98;
		scores[0][6] = 91;
		ShowAverage.average(0, weights);		
		String expected = "Average of ³\¤åÄÉ is: 92.6\n";
		String actuals =  outContent.toString();
		
		assertEquals(expected, actuals);
		System.setOut(null);
	}
	
}

