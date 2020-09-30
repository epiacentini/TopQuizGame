/**
 * 
 */
package topquizbackend;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * The InteractiveQuestion class contains the back-end IA Question data
 * and the methods needed in the back-end for the proper execution of
 * front-end methods.
 * 
 * @author ericpiacentini
 *
 */
public class InteractiveQuestion extends Question {

	private String imageFileName; //String for the filename of the InteractiveQuestion's image.
	private String [] choices;	//the possible choices that could be given for an answer to the InteractiveQuestion
	
	/**
	 * Basic Constructor
	 * Not advisable to use, will result in errors.
	 */
	public InteractiveQuestion() {
		super();
		this.setImageFileName("");
		this.choices = new String[4];
	}

	/**
	 * Inherited Constructor from the Super.
	 * Not advisable to use, will result in errors.
	 * @param questionText String for the Question's text
	 * @param correctAnswer String for the Question's correct answer
	 * @param score int for the Question's point-valueas a score.
	 */
	public InteractiveQuestion(String questionText, String correctAnswer, int score) {
		super(questionText, correctAnswer, score);
		this.imageFileName = "";
		this.choices = new String[4];
	}

	/**
	 * Robust Constructor for the InteractiveQuestion class.
	 * Inherits some parameters from the super-class. Also sets the filename for the Image used
	 * in InteractiveQuestions, as well as the various choices for answering based on that image.
	 * @param questionText String for the Question's text
	 * @param correctAnswer String for the Question's correct answer
	 * @param score int for the Question's point-value as a score.
	 * @param imageFileName String for the filename/location of the Image to be displayed with the InteractiveQuestion
	 * @param choiceA String for the IAQ's choice A
	 * @param choiceB String for the IAQ's choice B
	 * @param choiceC String for the IAQ's choice C
	 * @param choiceD String for the IAQ's choice D
	 */
	public InteractiveQuestion(String questionText, String correctAnswer, int score, String imageFileName,
			String choiceA, String choiceB, String choiceC, String choiceD) {
		super(questionText, correctAnswer, score);
		this.setImageFileName(imageFileName);
		this.choices = new String[4];
		this.choices[0] = choiceA;
		this.choices[1] = choiceB;
		this.choices[2] = choiceC;
		this.choices[3] = choiceD;
	}
	
	/**
	 * @return the imageFileName
	 */
	public String getImageFileName() {
		return imageFileName;
	}

	/**
	 * @param imageFileName the imageFileName to set
	 */
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	/**
	 * @return the choices
	 */
	public String[] getChoices() {
		return choices;
	}
	
	/**
	 * A more robust getter method which returns a specific answer choice for this InteractiveQuestion
	 * @param choice int denoting which choice from choices array is desired
	 * @return String of the appropriate choice.
	 */
	public String getSpecificChoice(int choice) {
		return choices[choice];
	}
	
	/**
	 * Getter method which returns an ImageIcon directly taken using this object's imageFileName
	 * @return ImageIcon for this InteractiveQuestion's imageFileName
	 */
	public ImageIcon getInteractiveQuestionImageIcon() {
		return new ImageIcon(this.getImageFileName());
	}
	
	/**
	 * Getter method which returns an ImageIcon directly taken using this object's imageFileName
	 * @return Image for this InteractiveQuestion's imageFileName
	 */
	public Image getInteractiveQuestionImage() {
		return new ImageIcon(this.getImageFileName()).getImage();
	}
}
