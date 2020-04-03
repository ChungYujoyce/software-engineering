package Mypackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;


class ShowRankTest {

	static Student[] Students = new Student[63];
	
	static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Test
	void testShowrank_1() {
		int []weights = {20,10,10,30,30};
		
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent));	
		ShowRank.showrank(7, weights);
		assertEquals("·¨¥Ã¦¨ Score: 87.6 Rank: 44\n", outContent.toString());
		
	}
	
	@Test
	void testShowrank_2() {
		int []weights = {10,10,10,30,40};
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent));	
		ShowRank.showrank(19, weights);
		assertEquals("®e®a¾s Score: 90.9 Rank: 23\n", outContent.toString());
		
	}
	
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
