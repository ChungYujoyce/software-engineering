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
import Mypackage.Input;


/**
 * InOut object.
 * Deal with user menu-interface.
 *
 * Bugs: none known
 * 
 * @author Huang Chung Yu
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
	public static String choose(int target, Scanner s) {
		/* Get all student data */
		Info info = Input.read();
		String command = "";
		/* Get target student name by index targeting name */
		if(target != 1) {
			System.out.printf("Welcome~ "+ info.names[target]+"\n");
			System.out.printf(" 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
					+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
					+ "Leave Menu (enter: E)\n");
			/* Get user command */
			command = s.nextLine();
		}
		return command;
	}
}
