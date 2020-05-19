/**
 * 
 */
package topquizbackend;

import java.util.*;

/**
 * The ShortAnswerQuestion class contains the back-end SA Question data
 * and the methods needed in the back-end for the proper execution of
 * front-end methods.
 * 
 * @author keshavgovindaraju
 *
 */
public class ShortAnswerQuestion extends Question {
	
	private ArrayList<String> acceptableResponses; //An ArrayList of acceptable responses beyond the standard 'correctAnswer'
	
	/**
	 * Basic Constructor
	 * Not Advisable to use.
	 */
	public ShortAnswerQuestion() {
		super();
		this.acceptableResponses = new ArrayList<>();
	}

	/**
	 * Inherited Constructor from the Super.
	 * It is okay to use this Constructor, if the user does not wish to denote any additional
	 * acceptable responses beyond correctAnswer.
	 * @param questionText String of the Question's text.
	 * @param correctAnswer String of the Question's correct answer
	 * @param score int of the Question's point-score.
	 */
	public ShortAnswerQuestion(String questionText, String correctAnswer, int score) {
		super(questionText, correctAnswer, score);
		this.acceptableResponses = new ArrayList<>();
	}

	/**
	 * More robust Constructor for ShortAnswerQuestion.
	 * This constructor allows the usage of an ArrayList of Strings containing
	 * acceptable Responses for the shortAnswer question.
	 * Do note: ShortAnswerQuestion answers need only contain any of either the
	 * correctAnswer or any member of acceptableResponses as a substring in order to
	 * return as true.
	 * @param questionText String of the Question's text
	 * @param correctAnswer String of the Question's correct answer
	 * @param score int of the Question's point-score
	 * @param acceptableResponses ArrayList of Strings containing additional Strings which may be 
	 * 									considered as acceptable answers to the ShortAnswerQuestion
	 */
	public ShortAnswerQuestion(String questionText, String correctAnswer, int score, ArrayList<String> acceptableResponses) {
		super(questionText, correctAnswer, score);
		this.acceptableResponses = acceptableResponses;
	}
	
	/**
	 * Method overrides isCorrectAnswer() in the super-class.
	 * This method checks not only if the String given as a parameter contains correctAnswer as a substring,
	 * but also checks if there are any Strings within acceptableREsponses which may also be contained
	 * within the parameter, answer, as a substring. Should the parameter, answer, be found to contain any of
	 * these as substrings, then the method returns True. Otherwise, it returns False.
	 * @param answer String containing a possible answer to this ShortAnswer Question
	 * @return boolean T/F based on whether answer matches any acceptable answer response or not
	 */
	@Override
	public boolean isCorrectAnswer(String answer) {
		if (answer.toLowerCase().contains(this.getCorrectAnswer().toLowerCase())) {
			return true;
		} else if (this.acceptableResponses.isEmpty() == false) {
			for (String acceptable : acceptableResponses) {
				if(answer.toLowerCase().contains(acceptable.toLowerCase())) {
					return true;
				}
			}
		}
		return false;
	}
}
