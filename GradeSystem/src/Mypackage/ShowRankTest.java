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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

/**
 * 
 * Test the show rank function.
 * 
 * Bugs: none known
 * 
 * @author       Huang Chung Yu
 * @version      1.0
 */
class ShowRankTest {

	static Student[] Students = new Student[63];
	static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	/** ------------------------------------------------------------------------------
	 * test testShowrank_1()
	 * This test is test the show rank function
	 * 
	 * Use user input weights to calculate correct student's rank.
	 * 
	 * input weights - {20,10,10,30,30}
	 * 
	 * expected result - 楊永成 Score: 87.6 Rank: 44
	 * 
	 * */
	@Test
	void testShowrank_1() {
		int []weights = {20,10,10,30,30};
		
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent));	
		ShowRank.showrank(7, weights);
		assertEquals("楊永成 Score: 87.6 Rank: 44\n", outContent.toString());
		
	}
	/** ------------------------------------------------------------------------------
	 * test testShowrank_2()
	 * This test is test the show rank function
	 * 
	 * Use user input weights to calculate correct student's rank.
	 * 
	 * input weights - {10,10,10,30,40}
	 * 
	 * expected result - 容家駒 Score: 90.9 Rank: 23\n
	 * 
	 * */
	@Test
	void testShowrank_2() {
		int []weights = {10,10,10,30,40};
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent));	
		ShowRank.showrank(19, weights);
		assertEquals("容家駒 Score: 90.9 Rank: 23\n", outContent.toString());
		
	}
	/** ------------------------------------------------------------------------------
	 * test testSort_1()
	 * This test is test the sorting function
	 * 
	 * input unsorted int list - {87,32,79,55,56,45,22,100,93,88,87,37,67}
	 * expected sorted in list - {22,32,37,45,55,56,67,79,87,87,88,93,100}
	 * 
	 * assertTrue(Arrays.equals(expect, get));
	 * 
	 * */
	@Test
	void testSort_1() {
		
		float []num = {87,32,79,55,56,45,22,100,93,88,87,37,67};
		float []expect = {22,32,37,45,55,56,67,79,87,87,88,93,100};
		float []get = new float[13];
		for (int i=0; i<13; i++) {
			Students[i] = new Student();
			Students[i].setScore(num[i]);
		}
		
		ShowRank.sort(Students, 13);
		for (int i=0; i<13; i++) {
			get[i] = Students[i].getScore();
		}
		assertTrue(Arrays.equals(expect, get));
		
	}
	/** ------------------------------------------------------------------------------
	 * test testSort_2()
	 * This test is test the sorting function
	 * 
	 * input unsorted int list - {100,93,88,87,37,67,87,32,79,55,56,45,22}
	 * expected sorted in list - {22,32,37,45,55,56,67,79,87,87,88,93,100}
	 * 
	 * assertTrue(Arrays.equals(expect, get));
	 * 
	 * */
	@Test
	void testSort_2() {
		float []num = {100,93,88,87,37,67,87,32,79,55,56,45,22};
		float []expect = {22,32,37,45,55,56,67,79,87,87,88,93,100};
		float []get = new float[13];
		for (int i=0; i<13; i++) {
			Students[i] = new Student();
			Students[i].setScore(num[i]);
		}
		
		ShowRank.sort(Students, 13);
		for (int i=0; i<13; i++) {
			get[i] = Students[i].getScore();
		}
		assertTrue(Arrays.equals(expect, get));
	}

}
