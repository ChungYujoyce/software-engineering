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
import java.io.*;
import java.util.*;
import Mypackage.Input;
import Mypackage.InOut;
import Mypackage.ShowGrade;
import Mypackage.UpdateWeights;
import Mypackage.UserMode;
/**
 * Main object.
 * Control the whole grading system interface
 *
 * Bugs: none known
 * 
 * @param none
 * @return null
 * 
 * @author Huang Chung Yu
 * @version      2.0
 * @see also     GradeSystem
 */
/** ------------------------------------------------------------------------------
 * Method main
 * Control user command (Q/G/W/A/E/R) and call different classes and execute.
 * 
 * Time estimate: O(n)
 * 
 * 1. Call in Info info = Input.read(); to get processed student data first.
 * 2. Call Person person = UserMode.user_mode(); to decide stay or leave the system.
 * 3. If command is Q: leave the system
 * 					G: show grade interface
 * 					W: update weights interface
 * 					A: show average interface
 * 					R: show rank interface
 * 					E: leave user menu 
 *     wrong commands: ask user to try again	
 * 4. If leave the system, whole project stop running.
 ------------------------------------------------------------------------------*/

public class main {
	static int[] weights = new int[] {10, 10, 10, 30, 40};
	public static void main(String[] args) {
		Info info = Input.read();
		Person person = UserMode.user_mode();
		while(!new String("Q").equals(person.user_in)){
			
			String command = InOut.choose(person.target);
			if(new String("G").equals(command)) {
				ShowGrade.showGrade(info.names, info.scores, person.target);
			}else if(new String("W").equals(command)){
				weights = UpdateWeights.weights(weights);
			}else if(new String("A").equals(command)){
				ShowAverage.average(person.target, weights);
			}else if(new String("R").equals(command)){
				ShowRank.showrank(person.target, weights);
			}else if(new String("E").equals(command)){
				person = UserMode.user_mode();
			}else {
				System.out.printf("Wrong command, please try again.\n");
			}
		}
		System.out.printf("Thanks for using!\n");
	}
}
