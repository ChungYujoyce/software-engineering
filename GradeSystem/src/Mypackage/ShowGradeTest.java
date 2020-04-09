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
 * Test the show grade function.
 * 
 * Bugs: none known
 * 
 * @author       Huang Chung Yu
 * @version      1.0
 */

class ShowGradeTest {

	static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	static int [][] scores = new int[63][7];
	static String[] names = new String [63];
	/** ------------------------------------------------------------------------------
	 * test testShowGrade_1()
	 * This test is test the show grade function
	 * 
	 * input name - "½²©v½Ã"
	 * 		(lab1, lab2, lab3, mid-term, final-exam) 
	 * input scores - 84 92 98 94 99
	 * 
	 * expected result - ½²©v½Ã Grades:\nlab1: 84\nlab2: 92\nlab3: 98\nmid-term: 94\nfinal-exam: 99\n
	 * 
	 * */
	@Test
	void testShowGrade_1() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		names[54] = "½²©v½Ã";
	    scores[54][0] = 985002509;
		scores[54][2] = 84;
		scores[54][3] = 92;
		scores[54][4] = 98;
		scores[54][5] = 94;
		scores[54][6] = 99;
		ShowGrade.showGrade(names,scores,54);	
		String expected = "½²©v½Ã Grades:\nlab1: 84\nlab2: 92\nlab3: 98\nmid-term: 94\nfinal-exam: 99\n";
		String actuals =  outContent.toString();
		
		assertEquals(expected, actuals);

	}

	/** ------------------------------------------------------------------------------
	 * test testShowGrade_2()
	 * This test is test the show grade function
	 *
	 * input name - "³\¤åÄÉ"
	 * 		(lab1, lab2, lab3, mid-term, final-exam) 
	 * input scores - 88 92 88 98 91
	 * 
	 * expected result - ³\¤åÄÉ Grades:\nlab1: 88\nlab2: 92\nlab3: 88\nmid-term: 98\nfinal-exam: 91\n
	 * 
	 * */
	@Test
	void testShowGrade_2() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		names[0] = "³\¤åÄÉ";
	    scores[0][0] = 955002056;
		scores[0][2] = 88;
		scores[0][3] = 92;
		scores[0][4] = 88;
		scores[0][5] = 98;
		scores[0][6] = 91;
		ShowGrade.showGrade(names,scores,0);		
		String expected = "³\¤åÄÉ Grades:\nlab1: 88\nlab2: 92\nlab3: 88\nmid-term: 98\nfinal-exam: 91\n";
		String actuals =  outContent.toString();
		assertEquals(expected, actuals);

	}
}
