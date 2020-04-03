///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  UpdateWeights.java
// Semester:         Spring 2020
// Course:			 Software Engineering
//
// Author:           Huang Chung Yu
///////////////////////////////////////////////////////////////////////////////

package Mypackage;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import Mypackage.UpdateWeights;

/**
 * UpdateWeights object.
 * Control update-weight system
 *
 * Bugs: none known
 * 
 * @author Huang Chung Yu
 * @version      1.0
 * @see also     GradeSystem
 */
/** ------------------------------------------------------------------------------
 * Method weights
 * 
 * Initial weight are 10 10 10 30 40
 * Require user to input 5 numbers (summation equals 100) to update score weights.
 * 
 * @param 	int [] weights
 * @return	int [] new_weights  means user-inputed-new weights
 * 
 * Time estimate: O(1)
 * Example: weights = UpdateWeights.weights(weights);
 * 
 * 1. show old score weights, and ask user to input new weights.
 * 2. Ask user to make sure the change is correct.
 * 3. If yes, update; otherwise, input again.
 * 4. If summation of 5 numbers is not 100, ask user to input again.
 * 5. If user type wrong command, ask user to input again. e.g. input "J" instead of "N"
 ------------------------------------------------------------------------------*/
/** ------------------------------------------------------------------------------
 * Method makesure
 * 
 * @param 	Scanner W
 * @param 	String w
 * @param 	int [] weights
 * 
 * @return	null
 * 
 * Time estimate: O(n)
 * Example: weights = UpdateWeights.weights(weights);
 * 
 * 1. If type Y: right one; N: wrong one
 * 2. If command typed wrong, ask user try again.
 * ----------------------------------------------------------------------------*/

public class UpdateWeights {
	public static int [] weights(int []weights) {
		/* 1. show old score weights, and ask user to input new weights.*/
		System.out.printf("\tlab1\t%d%%\n\tlab2\t%d%%\n\tlab3\t%d%%\n\tmid-term\t%d%%\n\tfinal-exam\t%d%%\n",weights[0],weights[1],weights[2],weights[3],weights[4]);
		Scanner W = new Scanner(System.in);
		String w = W.nextLine();
		String [] neww = w.split(" ");
		int [] new_weights = new int [5];   
		int count = 0;
		for(int i=0;i<5;i++) {
			new_weights[i] = Integer.parseInt(neww[i]);
			count += new_weights[i];
		}
		/* 4. If summation of 5 numbers is not 100, ask user to input again. */
		if(count != 100) {
			System.out.printf("Sum of 5 numbers should be 100, please try again~\n");
			UpdateWeights.weights(weights);
		}
		/* 2. Ask user to make sure the change is correct. */
		System.out.printf("\tNew weights:\n \tlab1\t%d%%\n\tlab2\t%d%%\n\tlab3\t%d%%\n\tmid-term\t%d%%\n\tfinal exam\t%d%%\n",new_weights[0],new_weights[1],new_weights[2],new_weights[3],new_weights[4]);
		System.out.printf("Are they correct? Y (Yes) or N (No)\n");
		w = W.nextLine();
		makesure(W, w, weights);
		/* Update successfully */
		return new_weights;
	}	
	static void makesure(Scanner W, String w, int [] weights) {
		while(true) {
			if(w.equals("Y")){
				break; /* 3. If yes, update; otherwise, input again.*/
			}else if(w.equals("N")){
				System.out.printf("Please set the weights again...\n");
				UpdateWeights.weights(weights);
				/* 5. If user type wrong command, ask user to input again. e.g. input "J" instead of "N" */
			}else 
				System.out.printf("Wrong command, please try again...Y (Yes) or N (No)\n");
				w = W.nextLine();
		}
	}
}
