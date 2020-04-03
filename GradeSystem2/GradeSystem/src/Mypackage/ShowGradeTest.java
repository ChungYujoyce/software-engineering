package Mypackage;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShowGradeTest {

	static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	
	@Test
	void testShowGrade_1() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		int [][] scores = new int[63][7];
		String[] names = new String [63];
		names[0] = "½²©v½Ã";
	    scores[0][0] = 985002509;
		scores[0][2] = 84;
		scores[0][3] = 92;
		scores[0][4] = 98;
		scores[0][5] = 94;
		scores[0][6] = 99;
		ShowGrade.showGrade(names,scores,54);	
		String expected = "½²©v½Ã Grades:\n\tlab1:\t\t84 \n\tlab2:\t\t92 \n\tlab3:\t\t98 \n\tmid-term:\t94 \n\tfinal exam:\t99 \n\ttotal grade:\t95 \n";
		String actuals =  outContent.toString();
		
		assertEquals(expected, actuals);
		System.setOut(null);
	}

	@Test
	void testShowGrade_2() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		int [][] scores = new int[63][7];
		String[] names = new String [63];
		names[0] = "³\¤åÄÉ";
	    scores[0][0] = 955002056;
		scores[0][2] = 88;
		scores[0][3] = 92;
		scores[0][4] = 88;
		scores[0][5] = 98;
		scores[0][6] = 91;
		ShowGrade.showGrade(names,scores,0);		
		String expected = "³\¤åÄÉ Grades:\n\tlab1:\t\t88 \n\tlab2:\t\t92 \n\tlab3:\t\t88 \n\tmid-term:\t98 \n\tfinal exam:\t91 \n\ttotal grade:\t93 \n";
		String actuals =  outContent.toString();
		
		assertEquals(expected, actuals);
		System.setOut(null);
	}
}
