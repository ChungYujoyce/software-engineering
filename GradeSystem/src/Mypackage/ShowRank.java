///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:  ShowRank.java
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

public class ShowRank {
	static Info info = Input.read();
	static Student[] Students = new Student[63];
	public static void showrank(int target, int [] weights) {
		
		for(int i=0; i<63; i++) {
			Students[i] = new Student();
			float ave = (float)(info.scores[i][2]*weights[0]+info.scores[i][3]*weights[1]+
					info.scores[i][4]*weights[2]+info.scores[i][5]*weights[3]+info.scores[i][6]*weights[4])/100;
			
			Students[i].setName(info.names[i]);
			Students[i].setScore(ave);
		}
		sort(Students, 63);
		int rank = 1,tmp_rank=1;
		for(int i=62 ; i>=0; i--) {			
			if(i==0 && Students[i].getScore() != Students[i+1].getScore()) rank = tmp_rank;
			if(info.names[target] == Students[i].getName()) 
				System.out.println(Students[i].getName()+" Score: "+Students[i].getScore()+" Rank: "+ rank);
			tmp_rank++;
			if(i!=0 && Students[i].getScore() != Students[i-1].getScore()) rank = tmp_rank;
		}
			
	}
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

