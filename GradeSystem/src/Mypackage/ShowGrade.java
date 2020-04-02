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

public class ShowGrade {
	
	public static void showGrade(String[] names, int[][] scores, int target) {
		
		if(scores[target][2] < 60) {
			System.out.println(names[target] +" Grades:\nlab1: "+scores[target][2]+"*");
		}else {
			System.out.println(names[target] +" Grades:\nlab1: "+scores[target][2]);
		}
		if(scores[target][3] < 60) {
			System.out.println("lab2: "+scores[target][3]+"*");
		}else {
			System.out.println("lab2: "+scores[target][3]);
		}
		if(scores[target][4] < 60) {
			System.out.println("lab3: "+scores[target][4]+"*");
		}else {
			System.out.println("lab3: "+scores[target][4]);
		}
		if(scores[target][5] < 60) {
			System.out.println("mid-term: "+scores[target][5]+"*");
		}else {
			System.out.println("mid-term: "+scores[target][5]);
		}
		if(scores[target][6] < 60) {
			System.out.println("final-exam: "+scores[target][6]+"*");
		}else {
			System.out.println("final-exam: "+scores[target][6]);
		}
	}
}
