/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topquiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import topquizbackend.*;

/**
 * Extends the QuestionPanel super class, to display content specific to
 * interactive question objects.
 *
 * @author ericpiacentini
 */
public class InteractiveQuestionPanel extends QuestionPanel {

    private InteractiveQuestion IAQ;
    private TopQuiz topquiz;
    private String userResponse;

    /**
     * Constructor for InterActiveQuestionPanel, displays all the content from
     * the super class QuestionPanel, as well as a JPG file that is used for
     * the interactive copmonent. 
     * @param IAQ takes in an InterActiveQuestion object from backend
     * @param topquiz takes in an instance of TopQuiz
     */
    public InteractiveQuestionPanel(InteractiveQuestion IAQ, TopQuiz topquiz) {
        super(IAQ, topquiz);
        this.IAQ = IAQ;
        this.topquiz = topquiz;
        this.userResponse = "";

        JPanel answersPanel = new GradientPanelBackground();

        ImageIcon fourcorners = new ImageIcon(getClass().getResource("fourcorners_mod.jpg"));
        JLabel imageLabel = new JLabel(fourcorners);
        
        answersPanel.addMouseListener(new MouseAdapter() {
            /**
             * The logic behind selecting the answer for the interactive component
             * detects where the user clicks their mouse and depending on that
             * location will highlight part of the map and select an answer.
             * Highlighting the  map is done by displaying one of four images
             * with the different states each lit up.
             * @param e 
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                if (x < 150 && y < 183) {
                    System.out.println("Utah");
                    userResponse = "North-West";
                    imageLabel.setIcon(new ImageIcon(getClass().getResource("fourcorners_mod_Utah.jpg")));
                    imageLabel.repaint();
                } else if (x > 150 && y < 183) {
                    userResponse = "North-East";
                    imageLabel.setIcon(new ImageIcon(getClass().getResource("fourcorners_mod_Colorado.jpg")));
                    imageLabel.repaint();
                } else if (x < 150 && y > 183) {
                    userResponse = "South-West";
                    imageLabel.setIcon(new ImageIcon(getClass().getResource("fourcorners_mod_Arizona.jpg")));
                    imageLabel.repaint();
                } else if (x > 150 && y > 183) {
                    userResponse = "South-East";
                    imageLabel.setIcon(new ImageIcon(getClass().getResource("fourcorners_mod_NewMexico.jpg")));
                    imageLabel.repaint();
                }
            }

        });

        answersPanel.add(imageLabel);
        this.add(answersPanel);
    }
    
    /**
     * Detects all action performed and if it detects the submit button was 
     * clicked, will then check the current selected answer against the
     * correct answer and either reward points if its correct, will then call
     * nextQuestion() to display the next question.
     * @param e the event that occurred
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == this.getSubmitButton()) {
            if (this.IAQ.isCorrectAnswer(this.userResponse)) {
                this.topquiz.quizBank.addPoints(this.IAQ.getScore());
            }
            this.topquiz.nextQuestion();
        }

    }
}
