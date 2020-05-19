/**
 * 
 */
package topquizbackend;

import java.util.*;

/**
 * This is just a class for testing the Back-End classes. It mainly just checks whether
 * Question, MultipleChoiceQuestion, ShortAnswerQuestion, and QuestionBank are
 * working as intended.
 * 
 * @author keshavgovindaraju
 *
 */
public class BackEndTester {

	/**
	 * Main method for testing - calls all the rest.
	 * @param args the main-method's arguments
	 */
	public static void main(String[] args) {
		System.out.println("---[BackEndTester] Begin---");
		
		testQuestion();
		testMultipleChoiceQuestion();
		testShortAnswerQuestion();
		
		testQuestionBank();
		
		System.out.println("---[BackEndTester] End---");
	}
	
	/** 
	 * Method tests the Question class.
	 */
	private static void testQuestion() {
		System.out.println("\n[Question] TEST BEGIN\n");
		
		Question simpleTest = new Question("This is a sample Test Question's questiontext.", "This is the correct answer", 10);
		System.out.println("Test question text: " + simpleTest.getQuestionText());
		System.out.println("Bad answer test: " + simpleTest.isCorrectAnswer("bad answer"));
		System.out.println("Good answer test: " + simpleTest.isCorrectAnswer("This is the Correct answer"));
		System.out.println("Test question score: " + simpleTest.getScore());
		
		System.out.println("\n[Question] TEST END\n");
	}
	
	/**
	 * Method test the MultipleChoiceQuestion class
	 */
	private static void testMultipleChoiceQuestion() {
		System.out.println("\n[MultipleChoiceQuestion] TEST BEGIN\n");
		
		MultipleChoiceQuestion mcTestA = new MultipleChoiceQuestion("This is a sample MultipleChoiceQuestion question text.", "This is the correct answer", 20, 
				"Choice A Text", "This is the Correct answer", "Choice C Text", "Choice D Text", "Choice E Text");
		System.out.println("Test question text: " + mcTestA.getQuestionText());
		System.out.println("Bad answer test - string: " + mcTestA.isCorrectAnswer("bad answer"));
		System.out.println("Good answer test - string: " + mcTestA.isCorrectAnswer("This is the correct answer"));
		System.out.println("Bad answer test - int: " + mcTestA.isCorrectNumericAnswer(3));
		System.out.println("Good answer test - int: " + mcTestA.isCorrectNumericAnswer(1));
		//System.out.println("Bad answer test - A-E: " + mcTestA.isCorrectAnswer(mcTestA.getChoiceD()));
		//System.out.println("Good answer test - A-E: " + mcTestA.isCorrectAnswer(mcTestA.getChoiceB()));
		System.out.println("Test question score: " + mcTestA.getScore());
		
		System.out.println("\n[MultipleChoiceQuestion] TEST END\n");
	}
	
	/**
	 * Method tests the ShortAnswerQuestion class
	 */
	private static void testShortAnswerQuestion() {
		System.out.println("\n[ShortAnswerQuestion] TEST BEGIN\n");
		
		System.out.println("Test A");
		Question saTestA = new ShortAnswerQuestion("This is a sample ShortAnswerQuestion question text.", "correct", 30);
		System.out.println("Test question A text: " + saTestA.getQuestionText());
		System.out.println("Bad answer test: " + saTestA.isCorrectAnswer("bad answer"));
		System.out.println("Good answer test - exact: " + saTestA.isCorrectAnswer("correct"));
		System.out.println("Good answer test - inexact: " + saTestA.isCorrectAnswer("This is the correct answer."));
		System.out.println("Test question A score: " + saTestA.getScore());
		
		System.out.println("\nTest B");
		ArrayList<String> saTestBList = new ArrayList<>();
		saTestBList.add("Right");
		saTestBList.add("ObVIous");
		saTestBList.add("Accurate");
		Question saTestB = new ShortAnswerQuestion("This is another sample ShortAnswerQuestion question text, this time for testing multiple acceptable responese.", 
				"correct", 35, saTestBList);
		System.out.println("Test question B text: " + saTestB.getQuestionText());
		System.out.println("Bad answer test: " + saTestB.isCorrectAnswer("bad answer"));
		System.out.println("Good answer test - inexact: " + saTestB.isCorrectAnswer("This is the correct answer."));
		System.out.println("Good answer test - inexact(acceptable): " + saTestB.isCorrectAnswer("This is the right answer."));
		System.out.println("Good answer test - inexact(acceptable): " + saTestB.isCorrectAnswer("This is the obvious answer."));
		System.out.println("Good answer test - inexact(acceptable): " + saTestB.isCorrectAnswer("This is the accurate answer."));
		System.out.println("Test question B score: " + saTestB.getScore());
		
		System.out.println("\n[ShortAnswerQuestion] TEST END\n");
	}
	
	/**
	 * Method tests the basic back-end for the QuestionBank class
	 * It does not test ALL the methods in QuestionBank, however
	 * Just the basic functionality, as the other methods
	 * were tested in-practice using front-end classes
	 */
	private static void testQuestionBank() {
		System.out.println("\n[QuestionBank] TEST BEGIN\n");
		
		System.out.println("Building a new Question Bank.");
		Question mcTestA = new MultipleChoiceQuestion("MC Question - the Answer is A.", "This is the correct answer", 20, 
				"This is the correct answer", "Choice B Test", "Choice C Text", "Choice D Text", "Choice E Text");
		Question mcTestB = new MultipleChoiceQuestion("MC Question - the Answer is B.", "This is the correct answer", 20, 
				"Choice A Test", "This is the correct answer", "Choice C Text", "Choice D Text", "Choice E Text");
		Question mcTestC = new MultipleChoiceQuestion("MC Question - the Answer is C.", "This is the correct answer", 20, 
				"Choice A Test", "Choice B Test", "This is the correct answer", "Choice D Text", "Choice E Text");
		Question mcTestD = new MultipleChoiceQuestion("MC Question - the Answer is D.", "This is the correct answer", 20, 
				"Choice A Test", "Choice B Test", "Choice C Text", "This is the correct answer", "Choice E Text");
		Question mcTestE = new MultipleChoiceQuestion("MC Question - the Answer is E.", "This is the correct answer", 20, 
				"Choice A Test", "Choice B Test", "Choice C Text", "Choice D Text", "This is the correct answer");
		
		Question saTestA = new ShortAnswerQuestion("This is a sample ShortAnswerQuestion question text.", "correct", 30);
		ArrayList<String> saTestBList = new ArrayList<>();
		saTestBList.add("Right");
		saTestBList.add("ObVIous");
		saTestBList.add("Accurate");
		Question saTestB = new ShortAnswerQuestion("This is another sample ShortAnswerQuestion question text, this time for testing multiple acceptable responese.", 
				"correct", 35, saTestBList);
		
		QuestionBank testBank = new QuestionBank();
		testBank.addNewQuestion(mcTestA);
		testBank.addNewQuestion(mcTestB);
		testBank.addNewQuestion(mcTestC);
		testBank.addNewQuestion(mcTestD);
		testBank.addNewQuestion(mcTestE);
		testBank.addNewQuestion(saTestA);
		testBank.addNewQuestion(saTestB);
		
		System.out.println("Testing Serialization");
		testBank.storeQuestionBank("./testing_questionbank.ser");
		
		//QuestionBank testBankB = new QuestionBank();
		//testBankB.populateQuestionBank("./testing_questionbank.ser");
		QuestionBank testBankB = new QuestionBank("./testing_questionbank.ser");
		for(Question que : testBankB.getBank()) {
			System.out.println(que.getQuestionText());
		}
		System.out.println("Testing Pop and Points");
		while(testBankB.getBank().isEmpty() == false) {
			Question que = testBankB.popQuestion();
			System.out.println(que.getQuestionText());
			testBankB.addPoints(que.getScore());
		}
		System.out.println("Total score: " + testBankB.getCurrentScore());
		
		
		System.out.println("\n[QuestionBank] TEST END\n");
	}

}
