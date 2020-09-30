/**
 * 
 */
package topquizbackend;

import java.io.*;
import java.util.*;
import java.time.*;

/**
 * The QuestionBank class is used by the front-end classes and packages as a means of
 * accessing many of the objects detailed in the topquizbackend package. QuestionBank
 * maintains all the Questions for a given quiz as well as the currentScore for that
 * quiz, as well as possesses methods for not only de/serialization of Questions
 * from any .ser file containing Questions (stored in an ArrayList), but also methods 
 * for writing and reading from results from a text file.
 * 
 * @author ericpiacentini
 *
 */
public class QuestionBank {

	private ArrayList<Question> bank; // contains all Questions in a given iteration of the quiz

	private int currentScore; //contains the current user's score while taking the quiz

	/**
	 * Base Constructor.
	 * This method is not advisable to use as it does not automatically populate the bank of Questions.
	 */
	public QuestionBank() {
		this.bank = new ArrayList<>();
		this.currentScore = 0;
	}

	/**
	 * Robust Constructor for QuestionBank.
	 * The filename given should be of type .ser and contain a serialized ArrayList of Question objects,
	 * for proper functionality. This Constructor not only populates the bank attribute of this class,
	 * but also randomizes the order of Questions within the bank, so that no two QuestionBank objects
	 * will have the same order of Questions, even if they're created using the same .ser file
	 * @param filename String containing the name of the .ser file to be used for populating the QuestionBank's bank of Questions with
	 */
	public QuestionBank(String filename) {
		this.bank = new ArrayList<>();
		this.currentScore = 0;
		this.populateQuestionBank(filename);
		Collections.shuffle(this.bank);
	}

	/**
	 * @return the currentScore
	 */
	public int getCurrentScore() {
		return currentScore;
	}

	/**
	 * @return the bank
	 */
	public ArrayList<Question> getBank() {
		return bank;
	}

	/**
	 * @param currentScore the currentScore to set
	 */
	public void setCurrentScore(int currentScore) {
		if (currentScore < 0) {
			System.out.println("[QuestionBank] Error: Cannot set CurrentScore to negative value.");
			return;
		}
		this.currentScore = currentScore;
	}

	/**
	 * This method is used to add points to the user's curretnScore. The parameter must be
	 * non-negative for points to be added
	 * @param points the non-negative integer of how many points to add to the user's current score
	 */
	public void addPoints(int points) {
		if(points < 0) {
			System.out.println("[QuestionBank] Error: Cannot add negative points to CurrentScore.");
			return;
		}
		this.currentScore = this.currentScore + points;
	}

	/**
	 * Method for adding Questions to the QuestionBank's ArrayList of questions; bank.
	 * @param newQuestion the Question to be added to the bank ArrayList
	 */
	public void addNewQuestion(Question newQuestion) {
		this.bank.add(newQuestion);
	}

	/**
	 * This method checks whether the QuestionBank has Questions remaining in the bank. If so,
	 * it removes the Question from the head of the bank ArrayList, updates the ArrayList to
	 * edit all the indexes, and returns the former-head Question.
	 * @return Question object from the head of the bank ArrayList
	 */
	public Question popQuestion() {
		if (this.bank.isEmpty()) {
			System.out.println("[QuestionBank] Error: Question Bank is Empty - Cannot pop Question from bank.");
			return null;
		}
		return this.bank.remove(0);
	}

	/**
	 * This method takes the .ser filename pased as a parameter and extracts from that .ser file
	 * the ArrayList of Question objects. Using that ArrayList, it populates the bank with Questions.
	 * Note: There are try-catch blocks in this method to catch the most probable exceptions and fail with grace.
	 * @param filename String containing the name of the .ser file to be used for populating the QuestionBank's bank of Questions with
	 */
	public void populateQuestionBank(String filename) {
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream input = new ObjectInputStream(file);

			this.bank = (ArrayList<Question>)input.readObject();

			input.close();
			file.close();
		} catch (FileNotFoundException fnfex) {
			System.out.println("[QuestionBank] FileNotFoundException: Caught. Could not find file " + filename + ".");
			fnfex.printStackTrace();
		} catch (IOException ioex) {
			System.out.println("[QuestionBank] IOException: Caught.");
			ioex.printStackTrace();
		} catch (ClassNotFoundException cnfex) {
			System.out.println("[QuestionBank] ClassNotFoundException: Caught.");
			cnfex.printStackTrace();
		}
	}

	/**
	 * This method stores the ArrayList of Questions, bank, in a .ser file specified by the filename parameter.
	 * Note: There are try-catch blocks in this method to catch the most probable exceptions and fail with grace
	 * @param filename String continaing the name of the .ser file the QuestionBank's bank will be stored to.
	 */
	public void storeQuestionBank(String filename) {
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream output = new ObjectOutputStream(file);

			output.writeObject(this.bank);

			output.close();
			file.close();
		} catch (FileNotFoundException fnfex) {
			System.out.println("[QuestionBank] FileNotFoundException: Caught. Could not find file " + filename + ".");
			fnfex.printStackTrace();
		} catch (IOException ioex) {
			System.out.println("[QuestionBank] IOException: Caught.");
			ioex.printStackTrace();
		}
	}

	/**
	 * This method appends the latter two parameters as well as the QuestionBank's currentScore 
	 * to the end of the file specified by the filename parameters
	 * This method is used for storing the quiz result to the end of the results.txt file.
	 * It stores the quiz-taker's name, their score, and the time at which they completed the quiz.
	 * Note: There are try-catch blocks in this method to catch the most probable exceptions and fail with grace
	 * @param filename String of the filename to which the quiz result will be appended
	 * @param testerName String of the quiz-taker's name
	 * @param currentTime LocalDateTime of when the quiz-taker finished their quiz
	 */
	public void storeQuizResult(String filename, String testerName, LocalDateTime currentTime) {
		try {
			PrintWriter file = new PrintWriter(new FileWriter(filename, true));
			String outputResult = testerName + "\t" + this.getCurrentScore() 
			+ "\t" + currentTime;
			file.println(outputResult);
			file.close();
		} catch (FileNotFoundException fnfex) {
			System.out.println("[QuestionBank] FileNotFoundException: Caught. Could not find file " + filename + ".");
			fnfex.printStackTrace();
		} catch (IOException ioex) {
			System.out.println("[QuestionBank] IOException: Caught.");
			ioex.printStackTrace();
		}
	}

	/**
	 * This method is used to retrieve all quiz-results from the specified file and return them as an ArrayList of Strings.
	 * Note: There are try-catch blocks in this method to catch the most probable exceptions and fail with grace
	 * @param filename String of the file containing all previous quiz-results
	 * @return ArrayList of Strings all previous quiz-results from the specified file
	 */
	public ArrayList<String> retrieveQuizResults(String filename) {
		ArrayList<String> results = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = br.readLine();
			while (line != null) {
				results.add(line);
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException fnfex) {
			System.out.println("[QuestionBank] FileNotFoundException: Caught. Could not find file " + filename + ".");
			fnfex.printStackTrace();
		} catch (IOException ioex) {
			System.out.println("[QuestionBank] IOException: Caught.");
			ioex.printStackTrace();
		}
		return results;
	} 
}
