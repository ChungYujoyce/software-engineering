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

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


/**
 * Integration testing.
 * Test the whole project.
 * 
 * Bugs: none known
 * 
 * @author       Huang Chung Yu
 * @version      1.0
 */
public class mainTest {
	private static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testException()
	 * For main class exceptions handling
	 * 
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	Q						[leave system]
	 * (screen)		Thanks for using!
	 * 
	 * input - 
	 *  (user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "Enter ID or Q(finish usage)?\nThanks for using!\n"
	 */
	public void testException(){
		ByteArrayInputStream in = new ByteArrayInputStream("Q\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		main.main(new String[] {});
		
		assertEquals("Enter ID or Q(finish usage)?\nThanks for using!\n", outContent.toString());
		
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testUnexpectedScenario_1()
	 * For Unexpected Scenario 1 : input non-exiting ID
	 * 
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	000000000				[non-existing ID]
	 * (screen)		Sorry, your ID was wrong, please try again~				[Error message]
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	Q						[leave system]
	 * (screen)		Thanks for using!
	 * 
	 * 
	 * input - 
	 *  (user input) "000000000\nQ\n"
	 * 
	 * expected -
	 * 	(screen display) "Enter ID or Q(finish usage)?\nSorry, your ID was wrong, please try again~\n
	 *                    Enter ID or Q(finish usage)?Thanks for using!\n"
	 */
	public void testUnexpectedScenario_1(){
		
		ByteArrayInputStream in = new ByteArrayInputStream("000000000\nQ\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		main.main(new String[] {});
		//UserMode.user_mode();
		assertEquals("Enter ID or Q(finish usage)?\nSorry, your ID was wrong, please try again~\nThanks for using!\n", outContent.toString());
		
	}

	@Test
	/** ------------------------------------------------------------------------------
	 * test testUnexpectedScenario_2()
	 * For Unexpected Scenario 2 : Input an non-existing command
	 * 
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	955002056				[existing ID]
	 * (screen)		Welcome~ 許文馨
	 * (screen)		
	 * 					 1) Show Grade (enter: G) 
 	 *					 2) Show Rank (enter: R)
     *                   3) Show Average (enter: A)
 	 *					 4) Update Weights (enter: W)
 	 *					 5) Leave Menu (enter: E)
	 * (user input)	X						[non-existing command]
	 * (screen)		Wrong command, please try again.			[Error message]
	 * (screen)		
	 * 					 1) Show Grade (enter: G) 
 	 *					 2) Show Rank (enter: R)
     *                   3) Show Average (enter: A)
 	 *					 4) Update Weights (enter: W)
 	 *					 5) Leave Menu (enter: E)
	 * (user input)	E						[leave menu]
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	Q						[leave system]
	 * (screen)		Thanks for using!
	 * 
	 * input - 
	 *  (user input) "955002056\nX\nE\nQ\n"
	 * 
	 * expected -
	 * 	(screen display) "Enter ID or Q(finish usage)?Welcome~ 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n此指令不存在!\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n"
	 */
	public void testUnexpectedScenario_2(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\nX\nE\nQ\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		main.main(new String[] {});

		assertEquals("Enter ID or Q(finish usage)?\n"
				+ "Welcome~ 許文馨\n"
				+ " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
				+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
				+ "Leave Menu (enter: E)\n"
				+ "Wrong command, please try again.\n"
				+ "Welcome~ 許文馨\n"
				+ " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
				+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
				+ "Leave Menu (enter: E)\n"
				+ "Enter ID or Q(finish usage)?\n"
				+ "Thanks for using!\n", outContent.toString());
	}


	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_1
	 * For testing Normal Scenario 1, as below:
	 * 
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	955002056				[existing ID]
	 * (螢幕)		Welcome~ 許文馨
	 * (screen)		
	 * 					 1) Show Grade (enter: G) 
 	 *					 2) Show Rank (enter: R)
     *                   3) Show Average (enter: A)
 	 *					 4) Update Weights (enter: W)
 	 *					 5) Leave Menu (enter: E)
	 * (user input)	E						[leave menu]
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	Q						[leave system]
	 * (screen)		Thanks for using!
	 *  
	 * input - 
	 *  (user input) "955002056\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "輸入ID或 Q (結束使用)?Welcome 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n"
	 */
	public void testNormalScenario_1(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\nE\nQ\n".getBytes());
		System.setIn(in);System.setIn(in);
		
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		main.main(new String[] {});
		
		assertEquals("Enter ID or Q(finish usage)?\n"
				+ "Welcome~ 許文馨\n"
				+ " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
				+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
				+ "Leave Menu (enter: E)\n"
				+ "Enter ID or Q(finish usage)?\n"
				+ "Thanks for using!\n", outContent.toString());
	}
	
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_2()
	 * For testing Normal Scenario 2, as below:
	 * 
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	955002056			[存在的ID]
	 * (screen)		Welcome~ 許文馨
	 * (screen)		
	 * 					 1) Show Grade (enter: G) 
 	 *					 2) Show Rank (enter: R)
     *                   3) Show Average (enter: A)
 	 *					 4) Update Weights (enter: W)
 	 *					 5) Leave Menu (enter: E)
	 * (user input)	G					[顯示成績]
	 * (screen)			許文馨 Grades:
	 * 					lab1:		88　
	 * 					lab2:		92　
	 * 					lab3:		88　
	 * 					mid-term:	98　
	 * 					final exam:	91 
	 * (screen)		
	 * 					 1) Show Grade (enter: G) 
 	 *					 2) Show Rank (enter: R)
     *                   3) Show Average (enter: A)
 	 *					 4) Update Weights (enter: W)
 	 *					 5) Leave Menu (enter: E)
	 * (user input)	E						[leave menu]
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	Q						[leave system]
	 * (screen)		Thanks for using!
	  * 
	 * input - 
	 *  (user input) "955002056\n"
	 *	(user input) "G\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "輸入ID或 Q (結束使用)?Welcome 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n許文馨成績:\n\tlab1:\t\t88\nlab2:\t\t92\nlab3:\t\t88\nmid-term:\t98\nfinal exam:\t91\ntotal grade:\t92\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n此指令不存在!\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n"
	 */
	public void testNormalScenario_2(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\nG\nE\nQ\n".getBytes());
		System.setIn(in);
		
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		main.main(new String[] {});
		
		assertEquals("Enter ID or Q(finish usage)?\n"
					+ "Welcome~ " +"許文馨\n"
					+ " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
					+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
					+ "Leave Menu (enter: E)\n"
					+ "許文馨 Grades:\nlab1: 88\nlab2: 92\nlab3: 88\nmid-term: 98\nfinal-exam: 91\n"
					+ "Welcome~ 許文馨\n"
					+ " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
					+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
					+ "Leave Menu (enter: E)\n"
					+ "Enter ID or Q(finish usage)?\n"
					+ "Thanks for using!\n", outContent.toString());
	}
	
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_3()
	 * For testing Normal Scenario 3, as below:
	 * 
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	955002056			[existing ID]
	 * (screen)		Welcome~ 許文馨
	 * (screen)		
	 * 					 1) Show Grade (enter: G) 
 	 *					 2) Show Rank (enter: R)
     *                   3) Show Average (enter: A)
 	 *					 4) Update Weights (enter: W)
 	 *					 5) Leave Menu (enter: E)
	 * (user input)	A					[show average]
	 * (screen)		Average of 許文馨 is: 92.6
	 * (screen)		
	 * 					 1) Show Grade (enter: G) 
 	 *					 2) Show Rank (enter: R)
     *                   3) Show Average (enter: A)
 	 *					 4) Update Weights (enter: W)
 	 *					 5) Leave Menu (enter: E)
	 * (user input)	E						[leave menu]
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	Q						[leave system]
	 * (screen)		Thanks for using!
	 *  
	 * input - 
	 *  (user input) "955002056\n"
	 *	(user input) "A\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "輸入ID或 Q (結束使用)?Welcome 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n許文馨平均91.40\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n"
	 */
	public void testNormalScenario_3(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\nA\nE\nQ\n".getBytes());
		System.setIn(in);
		
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		main.main(new String[] {});
		
		assertEquals("Enter ID or Q(finish usage)?\n"
				+ "Welcome~ " +"許文馨\n"
				+ " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
				+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
				+ "Leave Menu (enter: E)\n"
				+ "Average of 許文馨 is: 92.6\n"
				+ "Welcome~ 許文馨\n"
				+ " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
				+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
				+ "Leave Menu (enter: E)\n"
				+ "Enter ID or Q(finish usage)?\n"
				+ "Thanks for using!\n", outContent.toString());
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_4()
	 * For testing Normal Scenario 4, as below:
	 * 
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	955002056			[existing ID]
	 * (screen)		Welcome~ 許文馨
	 * (screen)		
	 * 					 1) Show Grade (enter: G) 
 	 *					 2) Show Rank (enter: R)
     *                   3) Show Average (enter: A)
 	 *					 4) Update Weights (enter: W)
 	 *					 5) Leave Menu (enter: E)
	 * (user input)	R					[show rank]
	 * (螢幕)		許文馨 Score: 92.6 Rank: 14			
	 * (screen)		
	 * 					 1) Show Grade (enter: G) 
 	 *					 2) Show Rank (enter: R)
     *                   3) Show Average (enter: A)
 	 *					 4) Update Weights (enter: W)
 	 *					 5) Leave Menu (enter: E)
	 * (user input)	E						[leave menu]
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	Q						[leave system]
	 * (screen)		Thanks for using!
	 *  
	 * input - 
	 *  (user input) "955002056\n"
	 *	(user input) "R\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "輸入ID或 Q (結束使用)?Welcome 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n許文馨排名第14\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n"
	 */
	public void testNormalScenario_4(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\nR\nE\nQ\n".getBytes());
		System.setIn(in);
		
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		main.main(new String[] {});
		
		assertEquals("Enter ID or Q(finish usage)?\n"
				+ "Welcome~ " +"許文馨\n"
				+ " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
				+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
				+ "Leave Menu (enter: E)\n"
				+ "許文馨 Score: 92.6 Rank: 14\n"
				+ "Welcome~ 許文馨\n"
				+ " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
				+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
				+ "Leave Menu (enter: E)\n"
				+ "Enter ID or Q(finish usage)?\n"
				+ "Thanks for using!\n", outContent.toString());
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_5()
	 * For testing Normal Scenario 5, as below:
	 * 
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	955002056			[existing ID]
	 * (screen)		Welcome~ 許文馨
	 * 					 1) Show Grade (enter: G) 
 	 *					 2) Show Rank (enter: R)
     *                   3) Show Average (enter: A)
 	 *					 4) Update Weights (enter: W)
 	 *					 5) Leave Menu (enter: E)
	 * (user input)	W					[show eold weights]
	 * (screen)		
	 * 		   			lab1	10%
	 *					lab2	10%
	 *					lab3	10%
	 *					mid-term	30%
	 *					final-exam	40%
	 *
	 * (user input)	20 20 20 20 20
	 * (screen) New weights: 
	 * 		   			lab1           20%
     *            		lab2           20%
     *            		lab3           20%
     *            		mid-term       20%
     *            		final-exam      20%
	 * 		   		Are they correct? Y (Yes) or N (No)
	 * (user input)	Y					[certain]
	 * (screen)	Welcome~ 許文馨
	 * 					 1) Show Grade (enter: G) 
 	 *					 2) Show Rank (enter: R)
     *                   3) Show Average (enter: A)
 	 *					 4) Update Weights (enter: W)
 	 *					 5) Leave Menu (enter: E)
	 * (user input)	E						[leave menu]
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	Q						[leave system]
	 * (screen)		Thanks for using!
	 *
	 *
	 * input - 
	 *  (user input) "955002056\n"
	 *	(user input) "W\n"
	 *	(user input) "20 20 20 20 20\n"
	 * 	(user input) "Y\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "輸入ID或 Q (結束使用)?Welcome 許文馨\n輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n舊配分\n\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal exam\t40%\n輸入新配分(%)\n\tlab1\t\tlab2\t\tlab3\t\tmid-term\t\tfinal exam\t請確認新配分\n\tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal exam\t20%\n以上正確嗎? Y (Yes) 或 N (No):輸入指令\n\t1) G 顯示成績 (Grade)\n\t2) R 顯示排名 (Rank)\n\t3) A 顯示平均 (Average)\n\t4) W 更新配分 (Weight)\n\t5) E 離開選單 (Exit)\n輸入ID或 Q (結束使用)?結束使用，系統關閉。\n"
	 */
	public void testNormalScenario_5(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\nW\n20 20 20 20 20\nY\nE\nQ\n".getBytes());
		System.setIn(in);
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		main.main(new String[] {});
		
		assertEquals("Enter ID or Q(finish usage)?\n"
				+ "Welcome~ 許文馨\n"
				+ " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
				+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
				+ "Leave Menu (enter: E)\n"
				+ "\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal-exam\t40%\n"
				+ "\tNew weights:\n \tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal exam\t20%\n"
				+ "Are they correct? Y (Yes) or N (No)\n"
				+ "Welcome~ 許文馨\n"
				+ " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
				+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
				+ "Leave Menu (enter: E)\n"
				+ "Enter ID or Q(finish usage)?\n"
				+ "Thanks for using!\n", outContent.toString());
		
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_6()
	 * For testing Normal Scenario 6, as below:
	 * 
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	955002056			[existing ID]
	 * (screen)		Welcome~ 許文馨	
	 * 					 1) Show Grade (enter: G) 
 	 *					 2) Show Rank (enter: R)
     *                   3) Show Average (enter: A)
 	 *					 4) Update Weights (enter: W)
 	 *					 5) Leave Menu (enter: E)
	 * (user input)	W					[show old weights]
	 * (screen)		
	 * 		   			lab1           10%
     *            		lab2           10%
     *            		lab3           10%
     *            		mid-term       30%
     *            		final exam      40%
	 * (user input)	20 20 20 20 20
	 * (screen) 		New weights: 
	 * 		   			lab1           20%
     *            		lab2           20%
     *            		lab3           20%
     *            		mid-term       20%
     *            		final exam      20%
	 * 		   		Are they correct? Y (Yes) or N (No)
	 * (user input)	N					[not certain]
	 * (screen)		Welcome~ 許文馨
	 * 					 1) Show Grade (enter: G) 
 	 *					 2) Show Rank (enter: R)
     *                   3) Show Average (enter: A)
 	 *					 4) Update Weights (enter: W)
 	 *					 5) Leave Menu (enter: E)
	 * (user input)	E						[leave menu]
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	Q						[leave system]
	 * (screen)		Thanks for using!
	 *
	 *
	 * input - 
	 *  (user input) "955002056\n"
	 *	(user input) "W\n"
	 *	(user input) "20 20 20 20 20\n"
	 * 	(user input) "N\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "Enter ID or Q(finish usage)?\nWelcome~ 許文馨\n
	 * " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n 3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) Leave Menu (enter: E)\n"
	 */
	public void testNormalScenario_6(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\nW\n20 20 20 20 20\nN\n20 20 10 25 25\nY\nE\nQ\n".getBytes());
		System.setIn(in);
		
		ByteArrayOutputStream outContent1 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent1));		
		main.main(new String[] {});
		
		assertEquals("Enter ID or Q(finish usage)?\n"
				+ "Welcome~ 許文馨\n"
				+ " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
				+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
				+ "Leave Menu (enter: E)\n"
				+ "\tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal-exam\t20%\n"
				+ "\tNew weights:\n \tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal exam\t20%\n"
				+ "Are they correct? Y (Yes) or N (No)\n"
				+ "Please set the weights again...\n"
				+ "\tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal-exam\t20%\n"
				+ "\tNew weights:\n \tlab1\t20%\n\tlab2\t20%\n\tlab3\t10%\n\tmid-term\t25%\n\tfinal exam\t25%\n"
				+ "Are they correct? Y (Yes) or N (No)\n"
				+ "Welcome~ 許文馨\n"
				+ " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
				+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
				+ "Leave Menu (enter: E)\n"
				+ "Enter ID or Q(finish usage)?\n"
				+ "Thanks for using!\n", outContent1.toString());
		
	}
}
