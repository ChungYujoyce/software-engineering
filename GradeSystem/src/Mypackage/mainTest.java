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
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\nX\nE\nQ\n".getBytes());
		System.setIn(in);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		main.main(new String[] {});

		assertEquals("Enter ID or Q(finish usage)?\n"
				+ "Welcome~ �\����\n"
				+ " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
				+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
				+ "Leave Menu (enter: E)\n"
				+ "Wrong command, please try again.\n"
				+ "Welcome~ �\����\n"
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
	 *  (user input) "955002056\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n"
	 */
	public void testNormalScenario_1(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\nE\nQ\n".getBytes());
		System.setIn(in);System.setIn(in);
		
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		main.main(new String[] {});
		
		assertEquals("Enter ID or Q(finish usage)?\n"
				+ "Welcome~ �\����\n"
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
	 *  (user input) "955002056\n"
	 *	(user input) "G\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�\���ɦ��Z:\n\tlab1:\t\t88\nlab2:\t\t92\nlab3:\t\t88\nmid-term:\t98\nfinal exam:\t91\ntotal grade:\t92\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�����O���s�b!\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n"
	 */
	public void testNormalScenario_2(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\nG\nE\nQ\n".getBytes());
		System.setIn(in);
		
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		main.main(new String[] {});
		
		assertEquals("Enter ID or Q(finish usage)?\n"
					+ "Welcome~ " +"�\����\n"
					+ " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
					+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
					+ "Leave Menu (enter: E)\n"
					+ "�\���� Grades:\nlab1: 88\nlab2: 92\nlab3: 88\nmid-term: 98\nfinal-exam: 91\n"
					+ "Welcome~ �\����\n"
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
	 *  (user input) "955002056\n"
	 *	(user input) "A\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�\���ɥ���91.40\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n"
	 */
	public void testNormalScenario_3(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\nA\nE\nQ\n".getBytes());
		System.setIn(in);
		
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		main.main(new String[] {});
		
		assertEquals("Enter ID or Q(finish usage)?\n"
				+ "Welcome~ " +"�\����\n"
				+ " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
				+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
				+ "Leave Menu (enter: E)\n"
				+ "Average of �\���� is: 92.6\n"
				+ "Welcome~ �\����\n"
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
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\nR\nE\nQ\n".getBytes());
		System.setIn(in);
		
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		main.main(new String[] {});
		
		assertEquals("Enter ID or Q(finish usage)?\n"
				+ "Welcome~ " +"�\����\n"
				+ " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
				+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
				+ "Leave Menu (enter: E)\n"
				+ "�\���� Score: 92.6 Rank: 14\n"
				+ "Welcome~ �\����\n"
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
	 * 	(user input) "Y\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "��JID�� Q (�����ϥ�)?Welcome �\����\n��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n�°t��\n\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal exam\t40%\n��J�s�t��(%)\n\tlab1\t\tlab2\t\tlab3\t\tmid-term\t\tfinal exam\t�нT�{�s�t��\n\tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal exam\t20%\n�H�W���T��? Y (Yes) �� N (No):��J���O\n\t1) G ��ܦ��Z (Grade)\n\t2) R ��ܱƦW (Rank)\n\t3) A ��ܥ��� (Average)\n\t4) W ��s�t�� (Weight)\n\t5) E ���}��� (Exit)\n��JID�� Q (�����ϥ�)?�����ϥΡA�t�������C\n"
	 */
	public void testNormalScenario_5(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\nW\n20 20 20 20 20\nY\nE\nQ\n".getBytes());
		System.setIn(in);
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));		
		main.main(new String[] {});
		
		assertEquals("Enter ID or Q(finish usage)?\n"
				+ "Welcome~ �\����\n"
				+ " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
				+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
				+ "Leave Menu (enter: E)\n"
				+ "\tlab1\t10%\n\tlab2\t10%\n\tlab3\t10%\n\tmid-term\t30%\n\tfinal-exam\t40%\n"
				+ "\tNew weights:\n \tlab1\t20%\n\tlab2\t20%\n\tlab3\t20%\n\tmid-term\t20%\n\tfinal exam\t20%\n"
				+ "Are they correct? Y (Yes) or N (No)\n"
				+ "Welcome~ �\����\n"
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
	 * 	(user input) "N\n"
	 * 	(user input) "E\n"
	 *	(user input) "Q\n"
	 * 
	 * expected -
	 * 	(screen display) "Enter ID or Q(finish usage)?\nWelcome~ �\����\n
	 * " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n 3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) Leave Menu (enter: E)\n"
	 */
	public void testNormalScenario_6(){
		ByteArrayInputStream in = new ByteArrayInputStream("955002056\nW\n20 20 20 20 20\nN\n20 20 10 25 25\nY\nE\nQ\n".getBytes());
		System.setIn(in);
		
		ByteArrayOutputStream outContent1 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent1));		
		main.main(new String[] {});
		
		assertEquals("Enter ID or Q(finish usage)?\n"
				+ "Welcome~ �\����\n"
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
				+ "Welcome~ �\����\n"
				+ " 1) Show Grade (enter: G) \n 2) Show Rank (enter: R)\n "
				+ "3) Show Average (enter: A)\n 4) Update Weights (enter: W)\n 5) "
				+ "Leave Menu (enter: E)\n"
				+ "Enter ID or Q(finish usage)?\n"
				+ "Thanks for using!\n", outContent1.toString());
		
	}
}
