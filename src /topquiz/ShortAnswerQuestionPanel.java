/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topquiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import topquizbackend.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Extends the QuestionPanel super class, to display content specific to short
 * answer question objects.
 *
 * @author ericpiacentini
 */
public class ShortAnswerQuestionPanel extends QuestionPanel {

    private ShortAnswerQuestion SAQ;
    private TopQuiz topquiz;
    private String userResponse;
    private JTextField answerTextField = new JTextField(20);
    
    /**
     * Displays all the content from the super QuestionPanel, and an extra
     * textfield for the user to enter their response.
     * @param SAQ a Short Answer Question from the backend
     * @param topquiz an instance of TopQuiz
     */
    public ShortAnswerQuestionPanel(ShortAnswerQuestion SAQ, TopQuiz topquiz) {
        super(SAQ, topquiz);
        this.SAQ = SAQ;
        this.topquiz = topquiz;

        JPanel answersPanel = new GradientPanelBackground();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        answersPanel.add(answerTextField);
        this.add(answersPanel);

    }
    
    /**
     * Detects an action performed, will then take the text from the textfield
     * and enter it as the user's response. Will check that value against the
     * correct answer of the question and reward points accordingly. Will then
     * call nextQuestion().
     * @param e the event that occurred
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        this.userResponse = this.answerTextField.getText();

        if (src == this.getSubmitButton()) {
            if (this.SAQ.isCorrectAnswer(userResponse)) {
                this.topquiz.quizBank.addPoints(this.SAQ.getScore());
            }
            this.topquiz.nextQuestion();
        }
    }

}
