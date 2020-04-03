package Mypackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


class UpdateWeightsTest {

	static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Test
	void testWeights_1() {
		ByteArrayInputStream in = new ByteArrayInputStream("20 20 20 20 20\nY\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent));
		System.setIn(System.in); 
		int [] weights = new int [5];
		weights[0] = 10;
		weights[1] = 10;
		weights[2] = 10;
		weights[3] = 30;
		weights[4] = 40;
		weights = UpdateWeights.weights(weights);
		assertEquals("\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal-exam\t40%\n\tNew "
				+ "weights:\n \tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal exam\t20%\n"
				+ "Are they correct? Y (Yes) or N (No)\n", outContent.toString());
	
	}
	
	@Test
	void testWeights_2() {
		ByteArrayInputStream in = new ByteArrayInputStream("20 20 20 20 30\nY\n20 20 20 20 20\nY\n".getBytes());
		System.setIn(in);
		
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent)); 
		System.setIn(System.in); 
		
		int [] weights = new int [5]; 
		weights[0] = 10;
		weights[1] = 10;
		weights[2] = 10;
		weights[3] = 30;
		weights[4] = 40;
		weights = UpdateWeights.weights(weights);
		
		assertEquals("\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal-exam\t40%\n"
				+ "Sum of 5 numbers should be 100, please try again~\n"
				+ "\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal-exam\t40%\n\tNew "
				+ "weights:\n \tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal exam\t20%\n"
				+ "Are they correct? Y (Yes) or N (No)\n", outContent.toString());
		
	}

	@Test
	void testMakesure_1() {
		
	}
	
	@Test
	void testMakesure_2() {
		
	}

}
