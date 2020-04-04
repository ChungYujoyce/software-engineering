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


class UpdateWeightsTest {

	static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Test
	void testWeights_1() {
		ByteArrayInputStream in = new ByteArrayInputStream("20 20 20 20 20\nY\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent));
		System.setIn(System.in); 
		int[] weights = new int[] {10, 10, 10, 30, 40};
		weights = UpdateWeights.weights(weights);
		assertEquals("\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal-exam\t40%\n\tNew "
				+ "weights:\n \tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal exam\t20%\n"
				+ "Are they correct? Y (Yes) or N (No)\n", outContent.toString());
		
	}
	
	@Test
	void testWeights_2() {
		ByteArrayInputStream in = new ByteArrayInputStream("20 20 20 10 30\nY\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent));
		System.setIn(System.in); 
		int[] weights = new int[] {10, 10, 10, 30, 40};
		weights = UpdateWeights.weights(weights);
		
		assertEquals("\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal-exam\t40%\n\tNew "
				+ "weights:\n \tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t10%\n\tfinal exam\t30%\n"
				+ "Are they correct? Y (Yes) or N (No)\n", outContent.toString());

	}
	
	@Test
	void testcount_100_1() {
		ByteArrayInputStream in = new ByteArrayInputStream("20 20 20 20 30\n20 20 20 20 20\nY\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent)); 
		System.setIn(System.in); 
		int[] weights = new int[] {10, 10, 10, 30, 40};
		int[] new_weights = new int[5];
		Scanner W = new Scanner(System.in);
		String w = W.nextLine();
		int count = UpdateWeights.count_100(W, w, 0, weights, new_weights);
		
		assertEquals("\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal-exam\t40%\n", outContent.toString());
		assertTrue(count == 100);
		
	}

	@Test
	void testcount_100_2() {
		ByteArrayInputStream in = new ByteArrayInputStream("20 20 20 20 30\n20 20 0 20 20\n10 10 10 35 35\nY\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent)); 
		System.setIn(System.in); 
		int[] weights = new int[] {10, 10, 10, 30, 40};
		int[] new_weights = new int[5];
		Scanner W = new Scanner(System.in);
		String w = W.nextLine();
		int count = UpdateWeights.count_100(W, w, 0, weights, new_weights);
		
		assertEquals("\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal-exam\t40%\n", outContent.toString());
		assertTrue(count != 100);
		
	}
	
	@Test
	void testMakesure_1() {
		ByteArrayInputStream in = new ByteArrayInputStream("N\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("20 10 10 20 40\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("Y\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent)); 
		System.setIn(System.in); 
		int[] weights = new int[] {10, 10, 10, 30, 40};
		Scanner W = new Scanner(System.in);
		String w = W.nextLine();
		UpdateWeights.makesure(W, w, weights);
		assertEquals("", outContent.toString());
		
	}
	
	
	@Test
	void testMakesure_2() {
		ByteArrayInputStream in = new ByteArrayInputStream("S\nW\nY\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent)); 
		System.setIn(System.in); 
		int[] weights = new int[] {10, 10, 10, 30, 40};
		Scanner W = new Scanner(System.in);
		String w = W.nextLine();
		UpdateWeights.makesure(W, w, weights);
		
		assertEquals("Wrong command, please try again...Y (Yes) or N (No)\nWrong command, please try again...Y (Yes) "
				+ "or N (No)\n", outContent.toString());
		
	}

}
