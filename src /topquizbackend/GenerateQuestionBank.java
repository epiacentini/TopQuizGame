/**
 * 
 */
package topquizbackend;

import java.util.*;

/**
 * This class is used to generate all the Questions used in the final-product of this application.
 * Its sole purpose is to generate the "question_bank.ser" file.
 * 
 * @author ericpiacentini
 *
 */
public class GenerateQuestionBank {
	/**
	 * Main method for GenerateQuestionBank class
	 * creates and populates a QuestionBank, and stores it in a serialized file.
	 * @param args main-method's arguments
	 */
	public static void main(String[] args) {
		System.out.println("[GenerateQuestionBank] Starting...");
		QuestionBank newBank = new QuestionBank();
		generateMulitpleChoiceQuestions(newBank);
		generateShortAnswerQuestions(newBank);
		generateInteractiveQuestions(newBank);
		newBank.storeQuestionBank("question_bank.ser");
		System.out.println("[GenerateQuestionBank] Complete");
		
		//checkQuestionBank(newBank);

	}
	
	/**
	 * Generates MultipleChoiceQuestions for the QuestionBank.
	 * @param bank the QuestionBank
	 */
	public static void generateMulitpleChoiceQuestions(QuestionBank bank) {
		bank.addNewQuestion(new MultipleChoiceQuestion("Who was the first President of the United States of America?", 
				"George Washington", 10, 
				"Alexander Hamilton", "Abraham Lincoln", "George Washington", "Theodore Roosevelt", "Howard Taft"));
		bank.addNewQuestion(new MultipleChoiceQuestion("Christopher Colombus first landed in the New World in which modern day location?", 
				"The Bahamas", 10,
				"Plymouth Rock, Massachusetts", "The Bahamas", "Cuba and Hispaniola", "Mexico", "Puerto Rico"));
		bank.addNewQuestion(new MultipleChoiceQuestion("How many Constitutional amendments are part of the Bill of Rights?",
				"Ten", 10,
				"Eight", "Nine", "Ten", "Eleven", "Twelve"));
		bank.addNewQuestion(new MultipleChoiceQuestion("Which famous historical document was signed in 1776?",
				"The U.S. Declaration of Independence", 10,
				"The Magna Carta", "The U.S. Constitution", "The Emancipation Proclamation", "The Federalist Papers", "The U.S. Declaration of Independence"));
		bank.addNewQuestion(new MultipleChoiceQuestion("Which important, international ally did the Thirteen Colonies have during the Revolutionary War?",
				"France", 10,
				"France", "Britain", "Germany", "Spain", "Russia"));
		bank.addNewQuestion(new MultipleChoiceQuestion("How many stripes are on the U.S. Flag?",
				"Thirteen", 10,
				"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen"));
		bank.addNewQuestion(new MultipleChoiceQuestion("Which of the following holidays is NOT a national holiday in the United States?",
				"Easter", 10,
				"New Year's Day", "Easter", "Independence Day", "Thanksgiving", "Christmas"));
		bank.addNewQuestion(new MultipleChoiceQuestion("Which of the following Wars did the U.S. fight in during the 1800s?",
				"Spanish-American War", 10,
				"Spanish-American War", "World War II", "Korean War", "Vietnam War", "Persian Gulf War"));
		bank.addNewQuestion(new MultipleChoiceQuestion("Which of the following states was NOT one of the original Thirteen Colonies?",
				"Maine", 10,
				"New Hampshire", "Virgina", "Rhode Island", "Massachusetts", "Maine"));
		bank.addNewQuestion(new MultipleChoiceQuestion("What is the national animal of the United States?",
				"Bald Eagle", 10,
				"Lion", "Bear", "Rooster", "Snake", "Bald Eagle"));
		bank.addNewQuestion(new MultipleChoiceQuestion("Which continent is the United States of America on?",
				"North America", 10,
				"Asia", "North America", "South America", "Africa", "Europe"));
		bank.addNewQuestion(new MultipleChoiceQuestion("In which state is the Liberty Bell located",
				"Pennsylvania", 10,
				"New York", "Massachusetts", "Pennsylvania", "Rhode Island", "Delaware"));
		bank.addNewQuestion(new MultipleChoiceQuestion("What is the National Anthem of the United States?",
				"The Star-Spangled Banner", 10,
				"America (My Country, ‘Tis of Thee)", "The Pledge of Allegiance", "This Land Is Your Land", "The Star-Spangled Banner", "America the Beautiful"));
		bank.addNewQuestion(new MultipleChoiceQuestion("Whose face is NOT on Mount Rushmore?",
				"Benjamin Franklin", 10,
				"George Washington", "Thomas Jefferson", "Benjamin Franklin", "Abraham Lincoln", "Theodore Roosevelt"));
		return;
	}
	
	/**
	 * Generates ShortAnswerQuestions for the QuestionBank.
	 * @param bank the QuestionBank
	 */
	public static void generateShortAnswerQuestions(QuestionBank bank) {
		bank.addNewQuestion(new ShortAnswerQuestion("There are _______ senators in the U.S. Senate.",
				"100", 15,
				new ArrayList<String>(Arrays.asList("hundred"))));
		bank.addNewQuestion(new ShortAnswerQuestion("Where is the Statue of Liberty located?",
				"New York", 15,
				new ArrayList<String>(Arrays.asList("NY", "Liberty Island", "Hudson", "New Jersey", "NJ"))));
		bank.addNewQuestion(new ShortAnswerQuestion("What are the first three words of the Preamble to U.S. Constitution?",
				"We the People", 15,
				new ArrayList<String>(Arrays.asList("We, the People"))));
		bank.addNewQuestion(new ShortAnswerQuestion("The United States of America is made up of how many states?",
				"50", 15,
				new ArrayList<String>(Arrays.asList("fifty"))));
		bank.addNewQuestion(new ShortAnswerQuestion("California is part of which Time-Zone?",
				"Pacific", 15,
				new ArrayList<String>(Arrays.asList("PST", "-8"))));
		bank.addNewQuestion(new ShortAnswerQuestion("Name one of the three Unalienable Rights listed in the U.S. Declaration of Independence",
				"Life", 15,
				new ArrayList<String>(Arrays.asList("Liberty", "Happiness"))));
		return;
	}
	
	/**
	 * Generates InteractiveQuestions for the QuestionBank.
	 * @param bank the QuestionBank
	 */
	public static void generateInteractiveQuestions(QuestionBank bank) {
		bank.addNewQuestion(new InteractiveQuestion("Which of the states displayed in the image is Utah? Click on your answer and then Submit it.",
				"North-West", 30, "fourcorners_mod.jpg",
				"North-West", "North-East", "South-East", "South-West"));
		bank.addNewQuestion(new InteractiveQuestion("Which of the states displayed in the image is Colorado? Click on your answer and then Submit it.",
				"North-East", 30, "fourcorners_mod.jpg",
				"North-West", "North-East", "South-East", "South-West"));
		bank.addNewQuestion(new InteractiveQuestion("Which of the states displayed in the image is New Mexico? Click on your answer and then Submit it.",
				"South-East", 30, "fourcorners_mod.jpg",
				"North-West", "North-East", "South-East", "South-West"));
		bank.addNewQuestion(new InteractiveQuestion("Which of the states displayed in the image is Arizona? Click on your answer and then Submit it.",
				"South-West", 30, "fourcorners_mod.jpg",
				"North-West", "North-East", "South-East", "South-West"));
		return;
	}
	
	/**
	 * A method for printing basic details of the QuestionBank to the terminal,
	 * used to verity if the QuestionBank was generated properly or not.
	 * @param bank the QuestionBank
	 */
	public static void checkQuestionBank(QuestionBank bank) {
		System.out.println("Checking the QB...\n");
		int qNum = 0;
		int totalPossibleScore = 0;
		for (Question que : bank.getBank()) {
			System.out.println("Question Number: " + ++qNum);
			System.out.println(que.getQuestionText());
			totalPossibleScore += que.getScore();
		}
		System.out.println("Total Possible Score: "+ totalPossibleScore + "\n");
		System.out.println("\nDone checking QB.");
	}
	
}
