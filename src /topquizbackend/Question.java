/**
 * 
 */
package topquizbackend;

import java.io.*;

/**
 * Parent Class to all the other ___Question classes. Contains the back-end variables
 * and methods used by all other Question-type classes in the back-end.
 * The Question Class implements Serializable in order to be stored in the .ser file.
 * It possesses the basic private variables for all Questions, as well as the basic
 * methods for getters and checking a given answer to the question.
 * 
 * @author keshavgovindaraju
 *
 */
public class Question implements Serializable {

	private String questionText;
	private String correctAnswer;
	private int score;
	
	/**
	 * Base Constructor, no parameters.
	 * In most cases, this should not be used.
	 */
	public Question() {
		questionText = "";
		correctAnswer = "";
		score = 0;
	}
	
	/**
	 * More robust Question Constructor
	 * @param questionText String of the text to be displayed for the Question
	 * @param correctAnswer String of the Question's correct answer
	 * @param score int of how many points the question is worth
	 */
	public Question(String questionText, String correctAnswer, int score) {
		this.questionText = questionText;
		this.correctAnswer = correctAnswer;
		this.score = score;
	}

	/**
	 * This method returns True or False based on whether the param given
	 * matches the Question variable's private String, correct Answer
	 * @param answer String containing a potential answer for the Question
	 * @return boolean T/F based on whether answer matches correctAnswer or not
	 */
	public boolean isCorrectAnswer(String answer) {
		return this.getCorrectAnswer().equalsIgnoreCase(answer);
	}
	
	//The following are basic getters
	
	/**
	 * @return the questionText
	 */
	public String getQuestionText() {
		return questionText;
	}

	/**
	 * @return the correctAnswer
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

}
