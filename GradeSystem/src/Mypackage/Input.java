///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  Input.java
// Semester:         Spring 2020
// Course:			 Software Engineering
//
// Author:           Huang Chung Yu
//
///////////////////////////////////////////////////////////////////////////////

package Mypackage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
 * Class Info:
 * Initial properties of a student.
 * 
 * @param  Name    student name
 * @param  Score   student summation of weighted score
 * @return null
 * 
 * Method getName:  get the Name     Method setName:  set the Name
 * Method getScore: get the Score    Method getScore: get the Score
 *------------------------------------------------------------------------------*/

final class Info{
	public String [] names = new String [64];
	public int [][] scores = new int[64][7];
	public Info(String[] names, int[][]scores) {
		this.names = names;
		this.scores = scores;
	}
}
/** ------------------------------------------------------------------------------
 * Method showGrade
 * 
 * 
 *@return   Info(names, scores)  the object contains students' names and all scores
 * 
 * Time estimate: O(n) 
 * Example: Info info = Input.read();
 *
 * 
 ------------------------------------------------------------------------------*/

public class Input {
	public static Info read() {
		String [] names = new String [63];
		int [][] scores = new int[63][7];
		try {  /* Read file */
			String pathname = "C:\\Users\\USER\\Desktop\\software-engineering\\GradeSystem\\input.txt"; 
			File filename = new File(pathname); 
			FileInputStream fis = new FileInputStream(filename);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
			String oneLine;  int count = 0;
			/*store Names in an array, scores in another matrix*/
			while((oneLine = br.readLine()) != null) { 
				String st0 = oneLine.split(" ")[1];	
				names[count] = st0;
				for(int j=0; j< 7; j++) {
					if(j==1) { continue; }
					else {
						String st = oneLine.split(" ")[j];
						scores[count][j] = Integer.parseInt(st);
					}
				} count ++;
			}
		}catch (Exception e) {e.printStackTrace(); }
		return new Info(names, scores);
	}
}
