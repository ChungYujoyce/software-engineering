///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  ShowGrade.java
// Semester:         Spring 2020
// Course:			 Software Engineering
//
// Author:           Huang Chung Yu
//
///////////////////////////////////////////////////////////////////////////////

package Mypackage;
import java.io.*;
import java.util.*;
import Mypackage.Input;
/**
 * ShowGrade object.
 * Show targeted student all grades (lab1 lab2 lab3 mid-term final-exam)
 *
 * Bugs: none known
 * 
 * @author Huang Chung Yu
 * @version      1.0
 * @see also     GradeSystem
 * 
 */
/** ------------------------------------------------------------------------------
 * Method showGrade
 * Require user to input 5 numbers (summation equals 100) to update score weights.
 * 
 * @param 	String [] names       get target student's name
 * @param   int [][] scores  	  get target student's all scores
 * @param   int target			  get target student index
 * @return	null
 * 
 * Time estimate: O(1) 
 * Example: ShowGrade.showGrade(info.names, info.scores, person.target);
 *
 * If score under 60, ther's a mark behind the score. e.g. 96,78,20*,82,53*
 ------------------------------------------------------------------------------*/

public class ShowGrade {
	
	public static void showGrade(String[] names, int[][] scores, int target) {
	
		if(scores[target][2] < 60) 
			System.out.printf(names[target] +" Grades:\nlab1: "+scores[target][2]+"*\n");
		else System.out.printf(names[target] +" Grades:\nlab1: "+scores[target][2]+"\n");

		if(scores[target][3] < 60) 
			System.out.printf("lab2: "+scores[target][3]+"*\n");
		else System.out.printf("lab2: "+scores[target][3]+"\n");
	
		if(scores[target][4] < 60) 
			System.out.printf("lab3: "+scores[target][4]+"*\n");
		else System.out.printf("lab3: "+scores[target][4]+"\n");
		
		if(scores[target][5] < 60) 
			System.out.printf("mid-term: "+scores[target][5]+"*\n");
		else System.out.printf("mid-term: "+scores[target][5]+"\n");
		
		if(scores[target][6] < 60) 
			System.out.printf("final-exam: "+scores[target][6]+"*\n");
		else System.out.printf("final-exam: "+scores[target][6]+"\n");
	}
}
