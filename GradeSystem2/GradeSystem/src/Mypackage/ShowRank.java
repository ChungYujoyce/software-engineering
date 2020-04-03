///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  ShowRank.java

//
// Semester:         Spring 2020
// Course:			 Software Engineering
//
// Author:           Huang Chung Yu
//
///////////////////////////////////////////////////////////////////////////////

package Mypackage;
import java.io.*;
import Mypackage.Input;
import java.util.Scanner;

/** ------------------------------------------------------------------------------
 * Class Student:
 * Initial properties of a student.
 * 
 * @param  Name    student name
 * @param  Score   student summation of weighted score
 * @return null
 * 
 * Method getName:  get the Name     Method setName:  set the Name
 * Method getScore: get the Score    Method getScore: get the Score
 *------------------------------------------------------------------------------*/

class Student{
	private String Name;
    private float Score; 
    public Student() {
        super();
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public float getScore() {
        return Score;
    }
    public void setScore(float Score) {
        this.Score = Score;
    }
}
/**
 * ShowRank object.
 * Show targeted student rank by calculating all students weighted score.
 *
 * Bugs: none known
 * 
 * @author Huang Chung Yu
 * @version      1.0
 * @see also     GradeSystem
 * 
 */
/** ------------------------------------------------------------------------------
 * Method showrank
 * Require user to input 5 numbers (summation equals 100) to update score weights.
 * 
 * @param 	int [] weights    get score weights (either modified or not)
 * @param   int target  	  get target student
 * @return	null
 * 
 * Time estimate: O(n) n: students number
 * Example: ShowRank.showrank(person.target, weights);
 * 
 * 1. Set each Student score by input weights(may change by user)
 * 2. 
 ------------------------------------------------------------------------------*/

public class ShowRank {
	static Info info = Input.read();
	static Student[] Students = new Student[63];
	public static void showrank(int target, int [] weights) {
		/* 1. Set each Student score by input weights(may change by user) 
		 * 	  Set Corresponding student's name
		 * */
		for(int i=0; i<63; i++) {
			Students[i] = new Student();
			float ave = (float)(info.scores[i][2]*weights[0]+info.scores[i][3]*weights[1]+
					info.scores[i][4]*weights[2]+info.scores[i][5]*weights[3]+info.scores[i][6]*weights[4])/100;
			
			Students[i].setName(info.names[i]);
			Students[i].setScore(ave);
		}
		/* 2. sort score*/
		sort(Students, 63);
		int rank = 1,tmp_rank=1;
		/* 3. If encounter target student, show the result.
		 * Notice that the rank may change only if scores are different.
		 * */
		for(int i=62 ; i>=0; i--) {			
			if(i==0 && Students[i].getScore() != Students[i+1].getScore()) rank = tmp_rank;
			if(info.names[target] == Students[i].getName()) 
				System.out.printf(Students[i].getName()+" Score: "+Students[i].getScore()+" Rank: "+ rank+ "\n");
			tmp_rank++;
			if(i!=0 && Students[i].getScore() != Students[i-1].getScore()) rank = tmp_rank;
		}
			
	}
	/** ------------------------------------------------------------------------------
	 * Method sort
	 * Sort students' score to relocate student's place according to the weights 
	 * 
	 * @param 	Student[] Students    get each Student object for sorting convenience
	 * @param   int n  	  			  get the number of student
	 * @return	null
	 * 
	 * Time estimate: O(n^2) n: students number
	 * Example: sort(Students, 63);
	 ------------------------------------------------------------------------------*/
	static void sort(Student[] Students, int n) {
        Student temp = new Student();

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(Students[i].getScore() > Students[j].getScore()) {
                    temp = Students[i];
                    Students[i] = Students[j];
                    Students[j] = temp;
                }
            }
        }
	}
}

