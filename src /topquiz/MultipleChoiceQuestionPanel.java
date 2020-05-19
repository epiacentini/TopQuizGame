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
 *Extends the QuestionPanel super class, to display content specific to
 * multiple choice question objects.
 * @author ericpiacentini
 */
public class MultipleChoiceQuestionPanel extends QuestionPanel {

    private MultipleChoiceQuestion MCQ;
    private TopQuiz topquiz;

    private String userResponse;
    private JRadioButton[] responses;
    
    /**
     * Constructor for the MultipleChoiceQuestionPanel, displays the question
     * as well as radio buttons with text answer options and a submit button.
     * @param MCQ takes in a MultipleChoiceQuestion object from backend
     * @param topquiz takes in an instance of TopQuiz
     */
    public MultipleChoiceQuestionPanel(MultipleChoiceQuestion MCQ, TopQuiz topquiz) {
        super(MCQ, topquiz);
        this.MCQ = MCQ;
        this.topquiz = topquiz;

        JPanel answersPanel = new GradientPanelBackground();
        ButtonGroup group = new ButtonGroup();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        answersPanel.add(Box.createVerticalGlue());
        this.responses = new JRadioButton[this.MCQ.getChoices().length];

        for (int i = 0; i < this.MCQ.getChoices().length; ++i) {
            this.responses[i] = new JRadioButton(this.MCQ.getSpecificChoice(i));
            this.responses[i].addActionListener(this);
            answersPanel.add(responses[i]);

            group.add(responses[i]);
        }

        this.add(answersPanel);
    }
    
    /**
     * Detects all action performed and stores that action performed into src.
     * Will check if the src came from a JRadioButton and if it did will take
     * the text from that and set it as the users answer. If submit button is
     * detected as being clicked, will check the userResponse against the correct
     * answer and reward points accordingly. Will then call nextquestion().
     * @param e the event that occured
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if (src instanceof JRadioButton) {
            this.userResponse = ((JRadioButton) src).getText();
        }

        if (src == this.getSubmitButton()) {
            if (this.MCQ.isCorrectAnswer(this.userResponse)) {
                this.topquiz.quizBank.addPoints(this.MCQ.getScore());
            }
            this.topquiz.nextQuestion();
        }
    }

}
