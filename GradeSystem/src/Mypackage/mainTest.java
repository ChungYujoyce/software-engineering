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
import java.util.Scanner;

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
		
		ByteArrayInputStream in = new ByteArrayInputStream("000000000\n".getBytes());
		System.setIn(in);
		ByteArrayInputStream inn = new ByteArrayInputStream("Q\n".getBytes());
		System.setIn(inn);
		outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent));	
		main.main(new String[] {});
		//UserMode.user_mode();
		assertEquals("Enter ID or Q(finish usage)?\nSorry, your ID was wrong, please try again~\n", outContent.toString());
		
	}

	@Test
	/** ------------------------------------------------------------------------------
	 * test testUnexpectedScenario_2()
	 * For Unexpected Scenario 2 : Input an non-existing command
	 * 
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	955002056				[existing ID]
	 * (screen)		Welcome~ �\����
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
	 * 	(screen display) "Enter ID or Q(finish usage)?Welcome~ �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�����O���s�b!\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n"
	 */
	public void testUnexpectedScenario_2(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("X\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("E\n".getBytes()); 
		System.setIn(in);
		in = new ByteArrayInputStream("Q\n".getBytes()); 
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		main.main(new String[] {});
		
		assertEquals("Enter ID or Q(finish usage)?\nWelcome~ �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�����O���s�b!\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n", outContent.toString());
		
		System.setIn(System.in);
		System.setOut(null);
	}


	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_1
	 * For testing Normal Scenario 1, as below:
	 * 
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	955002056				[existing ID]
	 * (�ù�)		Welcome~ �\����
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
	 *  (user input) "955002056\nX\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n"
	 */
	public void testNormalScenario_1(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("E\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("Q\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		main.main(new String[] {});
		
		assertEquals("��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n", outContent.toString());
		
		System.setIn(System.in);
		System.setOut(null);
	}
	
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_2()
	 * For testing Normal Scenario 2, as below:
	 * 
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	955002056			[�s�b��ID]
	 * (screen)		Welcome~ �\����
	 * (screen)		
	 * 					 1) Show Grade (enter: G) 
 	 *					 2) Show Rank (enter: R)
     *                   3) Show Average (enter: A)
 	 *					 4) Update Weights (enter: W)
 	 *					 5) Leave Menu (enter: E)
	 * (user input)	G					[��ܦ��Z]
	 * (screen)			�\���� Grades:
	 * 					lab1:		88�@
	 * 					lab2:		92�@
	 * 					lab3:		88�@
	 * 					mid-term:	98�@
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
	 *  (user input) "955002056\nX\n"
	 *	(user input) "G\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�\���ɦ��Z:\n\tlab1:\t\t88\nlab2:\t\t92\nlab3:\t\t88\nmid-term:\t98\nfinal exam:\t91\ntotal grade:\t92\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�����O���s�b!\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n"
	 */
	public void testNormalScenario_2(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("G\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("E\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("Q\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		main.main(new String[] {});
		
		assertEquals("��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�\���ɦ��Z:\n\tlab1:\t\t88 \n\tlab2:\t\t92 \n\tlab3:\t\t88 \n\tmid-term:\t98 \n\tfinal exam:\t91 \n\ttotal grade:\t93 \n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n", outContent.toString());

		System.setIn(System.in);
		System.setOut(null);
	}
	
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_3()
	 * For testing Normal Scenario 3, as below:
	 * 
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	955002056			[existing ID]
	 * (screen)		Welcome~ �\����
	 * (screen)		
	 * 					 1) Show Grade (enter: G) 
 	 *					 2) Show Rank (enter: R)
     *                   3) Show Average (enter: A)
 	 *					 4) Update Weights (enter: W)
 	 *					 5) Leave Menu (enter: E)
	 * (user input)	A					[show average]
	 * (screen)		Average of �\���� is: 92.6
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
	 *  (user input) "955002056\nX\n"
	 *	(user input) "A\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�\���ɥ���91.40\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n"
	 */
	public void testNormalScenario_3(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("A\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("E\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("Q\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		main.main(new String[] {});
		
		assertEquals("��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�\���ɥ���91.40\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n", outContent.toString());

		System.setIn(System.in);
		System.setOut(null);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_4()
	 * For testing Normal Scenario 4, as below:
	 * 
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	955002056			[existing ID]
	 * (screen)		Welcome~ �\����
	 * (screen)		
	 * 					 1) Show Grade (enter: G) 
 	 *					 2) Show Rank (enter: R)
     *                   3) Show Average (enter: A)
 	 *					 4) Update Weights (enter: W)
 	 *					 5) Leave Menu (enter: E)
	 * (user input)	R					[show rank]
	 * (�ù�)		�\���� Score: 92.6 Rank: 14			
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
	 * 	(screen display) "��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�\���ɱƦW��14\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n"
	 */
	public void testNormalScenario_4(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("R\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("E\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("Q\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		main.main(new String[] {});
		
		assertEquals("��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�\���ɱƦW��14\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n", outContent.toString());
		
		System.setIn(System.in);
		System.setOut(null);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_5()
	 * For testing Normal Scenario 5, as below:
	 * 
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	955002056			[existing ID]
	 * (screen)		Welcome~ �\����
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
	 * (screen)	Welcome~ �\����
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
	 * 	(user input) "Y"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�°t��\n\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal exam\t40%\n��J�s�t��(%)\n\tlab1\t\tlab2\t\tlab3\t\tmid-term\t\tfinal exam\t�нT�{�s�t��\n\tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal exam\t20%\n�H�W���T��? Y (Yes) �� N (No):��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n"
	 */
	public void testNormalScenario_5(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("W\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("20 20 20 20 20\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("Y\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("E\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("Q\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		main.main(new String[] {});
		
		assertEquals("��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�°t��\n\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal exam\t40%\n��J�s�t��(%)\n\tlab1\t\tlab2\t\tlab3\t\tmid-term\t\tfinal exam\t�нT�{�s�t��\n\tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal exam\t20%\n�H�W���T��? Y (Yes) �� N (No):��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n", outContent.toString());
		
		System.setIn(System.in);
		System.setOut(null);
	}
	
	@Test
	/** ------------------------------------------------------------------------------
	 * test testNormalScenario_6()
	 * For testing Normal Scenario 6, as below:
	 * 
	 * (screen)		Enter ID or Q(finish usage)?
	 * (user input)	955002056			[existing ID]
	 * (screen)		Welcome~ �\����	
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
	 * (screen)		Welcome~ �\����
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
	 * 	(user input) "N"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "Enter ID or Q(finish usage)?\nWelcome~ �\����\n
	 * " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n 3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) Leave Menu (enter: E)\n"
	 */
	public void testNormalScenario_6(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("W\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("20 20 20 20 20\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("N\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("E\n".getBytes());
		System.setIn(in);
		in = new ByteArrayInputStream("Q\n".getBytes());
		System.setIn(in);
		
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		main.main(new String[] {});
		
		assertEquals("Enter ID or Q(finish usage)?\nWelcome~ �\����\n\t1) G Show Grade (enter: G)\n\t2) R Show Rank (enter: R)\n\t"
				+ "3) A Show Average (enter: A)\n\t4) Update Weights (enter: W)\n\t5) Leave Menu (enter: E)\n\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal-exam\t40%\n\tlab1\t\tlab2\t\tlab3\t\tmid-term\t\tfinal exam\t�нT�{�s�t��\n\tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal exam\t20%\n�H�W���T��? Y (Yes) �� N (No):��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n", outContent.toString());
		
		System.setIn(System.in);
	}
}
