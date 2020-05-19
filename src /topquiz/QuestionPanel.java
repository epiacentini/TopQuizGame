/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topquiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import topquizbackend.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The super question panel for displaying the questions' text, submit button
 * and a progress bar that serves as a timer. This class extends
 * GradientPanelBackground for displaying a colorful GUI panel
 *
 * @author ericpiacentini
 */
public class QuestionPanel extends GradientPanelBackground/*JPanel*/ implements ActionListener {

    private Question question;
    private TopQuiz topquiz;

    private JButton submit = new JButton("Submit");

    /**
     * Constructor for QuestionPanel super that displays the questions' 
     * text, submit button and a progress bar that serves as a timer.
     * @param question takes in a Question object from the backend
     * @param topquiz takes in an instance of TopQuiz
     */
    public QuestionPanel(Question question, TopQuiz topquiz) {
        this.topquiz = topquiz;
        this.question = question;

        JPanel questionPanel = new GradientPanelBackground();

        JPanel submitPanel = new GradientPanelBackground();

        JPanel headerPanel = new GradientPanelBackground();

        JLabel headerLabel = new JLabel();

        Font headerFont = new Font("Monospaced", Font.BOLD, 30);
        Font questionFont = new Font("ZapfDingbats", Font.BOLD, 15);

        JLabel questionLabel = new JLabel("Question " + topquiz.getQNum() + ": " + this.question.getQuestionText());
        questionLabel.setFont(questionFont);
        headerPanel.add(Box.createHorizontalGlue());
        headerLabel.setText("Top Quiz \t\t Test Taker: " + this.topquiz.getTesterName());
        headerLabel.setFont(headerFont);
        headerPanel.add(headerLabel);

        JProgressBar myProgBar = new JProgressBar(0, 120);
        headerPanel.add(myProgBar);
        add(headerPanel);

        questionPanel.add(questionLabel);
        add(questionPanel);

        submitPanel.add(submit);
        submit.addActionListener(this);
        add(submitPanel);

        myProgBar.setStringPainted(false);
        Thread progress = new QuestionTimer(myProgBar, this.topquiz);
        progress.start();
    }
    
    /**
     * Method defenition required by interface for ActionListener, is overriden
     * by the subclasses of QuestionPanel.
     * @param e the event that occurred
     */
    public void actionPerformed(ActionEvent e) {

    }
    
    /**
     * 
     * @return the submit button
     */
    public JButton getSubmitButton() {
        return this.submit;
    }

}
