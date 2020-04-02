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

final class Info{
	public String [] names = new String [64];
	public int [][] scores = new int[64][7];
	public Info(String[] names, int[][]scores) {
		this.names = names;
		this.scores = scores;
	}
}

public class Input {
	public static Info read() {
		String [] names = new String [63];
		int [][] scores = new int[63][7];
		try { 
			String pathname = "C:\\Users\\USER\\Desktop\\³n¤u\\SE_HW2_106062109_105042014\\GradeSystem\\input.txt"; 
			File filename = new File(pathname); 
			FileInputStream fis = new FileInputStream(filename);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
			String oneLine;
			int count = 0;
			while((oneLine = br.readLine()) != null) {
				String st0 = oneLine.split(" ")[1];
				names[count] = st0;
				for(int j=0; j< 7; j++) {
					if(j==1) {
						continue;
					}else {
						String st = oneLine.split(" ")[j];
						scores[count][j] = Integer.parseInt(st);
					}
				}
				count ++;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new Info(names, scores);
	}
	
}
