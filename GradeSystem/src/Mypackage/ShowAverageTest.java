package Mypackage;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShowAverageTest {

	static ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	
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
	
	@Test
	void testintegration_1() {
		
	}
	
	@Test
	void testintegration_2() {
		
	}
}

