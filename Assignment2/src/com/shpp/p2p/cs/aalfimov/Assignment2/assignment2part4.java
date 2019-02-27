package com.shpp.p2p.cs.aalfimov.Assignment2;

import acm.graphics.GRect;
import acm.graphics.GLabel;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class assignment2part4 extends WindowProgram {


    /**
     * Set colors our flag
     */
    private static final Color firstColor = new Color(0, 43, 127);
    private static final Color secondColor = new Color(252, 209, 22);
    private static final Color thirdColor = new Color(206, 17, 38);

    public static final int APPLICATION_WIDTH = 300;
    public static final int APPLICATION_HEIGHT = 300;

    public static final int SIZE_FLAG_HORIZONTAL = 250;
    public static final int SIZE_FLAG_VERTICAL = 100;

    public void run() {

        /**
         * Positioning on the screen
         */
        double xCenter = getWidth() / 5.0;
        double yCenter = getHeight() / 7.0;


        /**
         * Drawing the first strip. Fill the first color
         */
        drawRect(xCenter, yCenter, xCenter, yCenter * 3, firstColor);

        /**
         * Drawing the second strip. Fill the second color
         */
        drawRect(xCenter * 2, yCenter, xCenter, yCenter * 3, secondColor);

        /**
         * Drawing the third strip. Fill the third color
         */
        drawRect(xCenter * 3, yCenter, xCenter, yCenter * 3, thirdColor);

        /**
         * Display the name of the country
         */
        writeLabel();
    }

    /**
     * The function draw the rect. Give her the coordinates and color to filled
     * @param x - coordinate on the horizontal axis
     * @param y - vertical axis coordinate
     * @param w - width of rectangle
     * @param h - height of a rectangle
     * @param color - color of rectangle
     */
    private void drawRect(double x, double y, double w, double h, Color color) {
        GRect rect = new GRect(x, y, w, h);
        rect.setColor(color);
        rect.setFilled(true);
        add(rect);
    }

    /**
     * The function write label with offset.
     */
    private void writeLabel() {
        GLabel label = new GLabel("Flag of Rumunia");
        label.setFont("Verdana-20");
        add(label, getWidth() - label.getWidth(), getHeight() - label.getDescent());
    }
}