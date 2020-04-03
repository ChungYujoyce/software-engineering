///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  ShowAverage.java
// Semester:         Spring 2020
// Course:			 Software Engineering
//
// Author:           Huang Chung Yu
//
///////////////////////////////////////////////////////////////////////////////

package Mypackage;
import java.io.*;
import Mypackage.Input;
import Mypackage.UpdateWeights;
/**
 * ShowAverage object.
 * Show targeted student weighted score average
 *
 * Bugs: none known
 * 
 * @author Huang Chung Yu
 * @version      1.0
 * @see also     GradeSystem
 * 
 */
/** ------------------------------------------------------------------------------
 * Method showAverage
 * Sho target student weighted score average
 * 
 * @param   int [] weights  	  get score weights
 * @param   int target			  get target student index
 * @return	null
 * 
 * Time estimate: O(1) 
 * Example: ShowAverage.average(person.target, weights);
 *
 * 
 ------------------------------------------------------------------------------*/

public class ShowAverage {
	public static void average(int target, int[] weights) {
		Info info = Input.read();
		float total = (float)(info.scores[target][2]*weights[0]+info.scores[target][3]*weights[1]+
				info.scores[target][4]*weights[2]+info.scores[target][5]*weights[3]+info.scores[target][6]*weights[4])/100;
		System.out.printf("Average of "+info.names[target]+" is: "+total+"\n");
	}
}
