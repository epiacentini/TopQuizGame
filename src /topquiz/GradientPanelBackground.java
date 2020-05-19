/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topquiz;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
/**
 * Gradient painted panel for the background of the GUI
 * @author ericpiacentini
 */
public class GradientPanelBackground extends JPanel {
    
    /**
     * Method for generating the gradient coloring and applying to the panel.
     * @param g is a Graphics object for the panel itself
     */
    @Override
    public void paintComponent(Graphics g) {
         super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint gp = new GradientPaint(0, 0,
                    Color.YELLOW, getWidth(), getHeight(),
                    Color.ORANGE);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight()); 
    }
}

 