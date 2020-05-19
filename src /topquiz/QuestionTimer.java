/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topquiz;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

/**
 * Creates a QuestionTimer class that extends from thread and will create a 
 * JProgressBar that will starts at 100 and ticks down to 0.
 * @author ericpiacentini
 */
class QuestionTimer extends Thread {

    private static int DELAY = 250;
    private TopQuiz topquiz;
    private JProgressBar myQuestionTimer;
    private int currQuestion;
    
    /**
     * The constructor for QuestionTimer
     * @param progBar takes in the progressbar
     * @param topquiz  takes in an instance of TopQuiz
     */
    public QuestionTimer(JProgressBar progBar, TopQuiz topquiz) {
        this.myQuestionTimer = progBar;
        this.topquiz = topquiz;
        this.currQuestion = this.topquiz.getQNum();
    }
    
    /**
     * Initializes the value of the progress bar to be maximum, this causes
     * the progressbar to start full and slowly tick down (instead of the reverse)
     * After the progressbar is empty will check if qNum is equal to the current
     * question number, this is to prevent the thread from calling nextQuestion()
     * if the user pressed submit. This ensures the thread will only call
     * nextQuestion() when the time has run out and the user hasn't submitted.
     */
    public void run() {
        int minimum = this.myQuestionTimer.getMinimum();
        int maximum = this.myQuestionTimer.getMaximum();
        this.myQuestionTimer.setValue(maximum);
        this.myQuestionTimer.setBounds(250, 15, 200, 50);

        for (int i = maximum; i > minimum; i--) {
            try {
                int value = this.myQuestionTimer.getValue();
                this.myQuestionTimer.setValue(value - 1);
                Thread.sleep(this.DELAY);
            } catch (InterruptedException ignoredException) {
            }

        }

        if (this.topquiz.getQNum() == this.currQuestion) {
            this.topquiz.nextQuestion();
        }
    }

}
