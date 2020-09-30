/**
 * 
 */
package topquizbackend;

/**
 * The MultipleChoieQuestion class contains the back-end MC Question data
 * and the methods needed in the back-end for the proper execution of
 * front-end methods.
 * 
 * @author ericpiacentini
 *
 */
public class MultipleChoiceQuestion extends Question {
	
	private String [] choices; // an Array of Strings which contain the 
							// various Choices for a MultipleChoiceQuestion
	
	/**
	 * Base Constructor for MultipleChoiceQuestion
	 * Not advisable to use.
	 */
	public MultipleChoiceQuestion() {
		super();
		this.choices = new String[5];
	}

	/**
	 * Inherited Constructor for MultipleChoiceQuestion.
	 * The params are essentially the same as the super, Question.
	 * @param questionText String for the Question's text
	 * @param correctAnswer String for the Question's correct answer
	 * @param score int for the Question's point-value score
	 */
	public MultipleChoiceQuestion(String questionText, String correctAnswer, int score) {
		super(questionText, correctAnswer, score);
		choices = new String[5];
		//note, this constructor should not really be in use... but might be useful for testing purposes.
	}
	
	/**
	 * More robust Constructor for MultipleChoiceQuestion
	 * This is the advised Constructor to use for this Class, as it is complete
	 * Other Constructors for this class will not provide fully-functional MCQs.
	 * The first three parameters are inherited from the super-class, and function identically.
	 * @param questionText String for the Question's text
	 * @param correctAnswer String for the Question's correct answer
	 * @param score int for the Question's score
	 * @param choiceA String for the MCQ's Choice A
	 * @param choiceB String for the MCQ's Choice B
	 * @param choiceC String for the MCQ's Choice C
	 * @param choiceD String for the MCQ's Choice D
	 * @param choiceE String for the MCQ's Choice E
	 */
	public MultipleChoiceQuestion(String questionText, String correctAnswer, int score, 
			String choiceA, String choiceB, String choiceC, String choiceD, String choiceE) {
		super(questionText, correctAnswer, score);
		this.choices = new String[5];
		this.choices[0] = choiceA;
		this.choices[1] = choiceB;
		this.choices[2] = choiceC;
		this.choices[3] = choiceD;
		this.choices[4] = choiceE;
	}
	
	/**
	 * Method functions much like isCorrectAnswer() in the Super,
	 * only it takes an int for the specific answer-choice.
	 * instead of a String.
	 * @param answer int in range [0-4] (inclusive) denoting a possible answer choice
	 * @return boolean in the same vein as isCorrectAnswer() in the Question() class.
	 */
	public boolean isCorrectNumericAnswer(int answer) {
		if (answer < 0 || answer > 4) {
			System.out.println("[MultipleChoiceQuestion] Error: Answer given to question must be in range 0-4 inclusive. User attempted to enter " + answer + " to answer MultipleChoiceQuestion.");
			return false;
		}
		String letteranswer = Integer.toString('A' + answer);
		return this.isCorrectAnswer(letteranswer);
	}
	
	/**
	 * @return the choices
	 */
	public String [] getChoices() {
		return choices;
	}
	
	/**
	 * A more robust getter method which returns a specific answer choice for this MultipleChoiceQuestion
	 * @param choice int denoting which choice from choices array is desired
	 * @return String of the appropriate choice.
	 */
	public String getSpecificChoice(int choice) {
		return choices[choice];
	}
	
	//The following methods are outdated as of the creation of getSpecificChoice
	/*
	public String getChoiceA() {
		return choices[0];
	}
	
	public String getChoiceB() {
		return choices[1];
	}
	
	public String getChoiceC() {
		return choices[2];
	}
	
	public String getChoiceD() {
		return choices[3];
	}
	
	public String getChoiceE() {
		return choices[4];
	}
	*/
}
