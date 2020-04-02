///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  UpdateWeights.java
// Semester:         Spring 2020
// Course:			 Software Engineering
//
// Author:           Huang Chung Yu
//
///////////////////////////////////////////////////////////////////////////////

package Mypackage;
import java.io.*;
import java.util.Scanner;
import Mypackage.UpdateWeights;

/**
 * UpdateWeights object.
 * Control update-weight system
 *
 * Bugs: none known
 * @version      1.0
 * @see also     GradeSystem
 */
/** ------------------------------------------------------------------------------
 * Method weights
 * Require user to input 5 numbers (summation equals 100) to update score weights.
 * 
 * @param 	int [] weights
 * @return	int [] new_weights
 * 
 * Time estimate: O(n)
 * Example: weights = UpdateWeights.weights(weights);
 * 
 * 1. show old score weights, and ask user to input new weights.
 * 2. Ask user to make sure the change is correct.
 * 3. If yes, update; otherwise, input again.
 * 4. If summation of 5 numbers is not 100, ask user to input again.
 * 5. If user type wrong command, ask user to input again. e.g. input "J" instead of "N"
 ------------------------------------------------------------------------------*/

public class UpdateWeights {
	public static int [] weights(int []weights) {
		/* 1. show old score weights, and ask user to input new weights.*/
		System.out.println("Old weights: lab1 "+weights[0]+"% lab2 "+weights[1]+"% lab3 "+weights[2]+"% mid-term "+weights[3]+"% final-exam "+weights[4]+"%\n");
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
			System.out.println("Sum of 5 numbers should be 100, please try again~");
			UpdateWeights.weights(weights);
		}
		/* 2. Ask user to make sure the change is correct. */
		System.out.println("New weights are: lab1 "+new_weights[0]+"% lab2 "+new_weights[1]+"% lab3 "+new_weights[2]+"% mid-term "+new_weights[3]+"% final-exam "+new_weights[4]+"%");
		System.out.println("Are they correct? Y (Yes) or N (No)");
		w = W.nextLine();
		while(true) {
			if(w.equals("Y")) { /* 3. If yes, update; otherwise, input again.*/
				break;
			}else if(w.equals("N")){
				System.out.println("Please set the weights again...");
				UpdateWeights.weights(weights);
			}else {
				/* 5. If user type wrong command, ask user to input again. e.g. input "J" instead of "N" */
				System.out.println("Wrong command, please try again...Y (Yes) or N (No)");
			}
			w = W.nextLine();
		}
		/* Update successfully */
		System.out.println("New weights: lab1 "+new_weights[0]+"% lab2 "+new_weights[1]+"% lab3 "+new_weights[2]+"% mid-term "+new_weights[3]+"% final-exam "+new_weights[4]+"%");
		return new_weights;
	}	
}
