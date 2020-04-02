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

public class ShowAverage {
	public static void average(int target, int[] weights) {
		Info info = Input.read();
		float total = (float)(info.scores[target][2]*weights[0]+info.scores[target][3]*weights[1]+
				info.scores[target][4]*weights[2]+info.scores[target][5]*weights[3]+info.scores[target][6]*weights[4])/100;
		System.out.println("Average of "+info.names[target]+" is: "+total);
	}
}
