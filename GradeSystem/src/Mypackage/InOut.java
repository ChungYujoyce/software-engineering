///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  UserMode.java
// Semester:         Spring 2020
// Course:			 Software Engineering
//
// Author:           Huang Chung Yu
//
///////////////////////////////////////////////////////////////////////////////

package Mypackage;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import Mypackage.Input;

/**
 * InOut object.
 * Deal with user menu-interface.
 *
 * Bugs: none known
 * @version      1.0
 * @see also     GradeSystem
 */

/** ------------------------------------------------------------------------------
 * Method choose
 * Call this method after user input correct ID, show the user menu,
 * get another user input of command.
 * 
 * @param 		int target      An index which the system already searched for later usage.
 * @return		string command
 * 
 * Time estimate: O(1)
 * Example: String command = InOut.choose(person.target);
 ------------------------------------------------------------------------------*/

public class InOut {
	public static String choose(int target) {
		/* Get all student data */
		Info info = Input.read();
		/* Get target student name by index targeting name */
		System.out.println("Welcome~ "+ info.names[target]);
		System.out.println(" 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n 3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) Leave Menu (enter: E)");
		/* Get user command */
		Scanner id = new Scanner(System.in);
		String command = id.nextLine();
	
		return command;
	}
}
