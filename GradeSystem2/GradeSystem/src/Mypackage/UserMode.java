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
 * UserMode object.
 * Represents a user interface for a grade system.
 *
 * Bugs: none known
 * 
 * @author Huang Chung Yu
 * @version      2.0
 * @see also     GradeSystem
 */
/** ------------------------------------------------------------------------------
 * Class Person:
 * Initial properties of a searched person:
 * 
 * @param  user_in  user type in information, either a student ID or Q (leave the system)
 * @param  target   the system find the target student according to the input ID
 *------------------------------------------------------------------------------*/

class Person{
	public String user_in;
	public int target;
	public Person(String user_in, int target) {
		this.user_in = user_in;
		this.target = target;
	}
}

/** ------------------------------------------------------------------------------
 * Method user_mode
 * Require user to input ID or Q, and return the target object index(if exists) or only Q.
 
 * @return	Object Person(ID, target)
 * 
 * Time estimate: O(n)
 * Example: Person person = UserMode.user_mode(); 
 * 
 * If user input existing ID: return (ID, target ID index)
 * 			 non-existing ID: e.g. E/123 
 * 							  -> Sorry, your ID was wrong, please try again~
 * 							  
 * 				 		   Q: return (Q, -1 (initial value))
 ------------------------------------------------------------------------------*/

public class UserMode {
	public static Person user_mode() {
		System.out.printf("Enter ID or Q(finish usage)?\n");
		Scanner id = new Scanner(System.in);
		String ID = id.nextLine();
		int target = -1;
		if(new String("Q").equals(ID));
		else {
			Info info = Input.read(); // 962001051 §õ«Â§Ê 81 32 50 90 93 
			/* Find the target object(student) */
			while(target == -1) {
				for(int i=0; i<63; i++) {
					if(Objects.equals(ID, String.valueOf(info.scores[i][0]))) {
						target = i;
						break;
					}
				}
				/* If user input non-existing ID: can't find the student(target), 
				 * system will ask user to input ID again until find the target object. */
				
				if(target != -1) break;
				else {
					System.out.printf("Sorry, your ID was wrong, please try again~\n");
					ID = id.nextLine();
				}
			}
		}  
		return new Person(ID, target);
	}
}
