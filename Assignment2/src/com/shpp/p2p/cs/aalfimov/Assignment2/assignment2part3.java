package com.shpp.p2p.cs.aalfimov.Assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

public class assignment2part3 extends WindowProgram {

    /**
     * My program draws paws from the coordinates of the constants
     */

    private static final double FIRST_TOE_OFFSET_X = 0;
    private static final double FIRST_TOE_OFFSET_Y = 20;
    private static final double SECOND_TOE_OFFSET_X = 30;
    private static final double SECOND_TOE_OFFSET_Y = 0;
    private static final double THIRD_TOE_OFFSET_X = 60;
    private static final double THIRD_TOE_OFFSET_Y = 20;

    /**
     * The position of the heel relative to the upper-left corner of the pawprint.
     */
    private static final double HEEL_OFFSET_X = 20;
    private static final double HEEL_OFFSET_Y = 40;

    /**
     * Each toe is an oval with this width and height.
     */
    private static final double TOE_WIDTH = 20;
    private static final double TOE_HEIGHT = 30;

    /**
     * The heel is an oval with this width and height.
     */
    private static final double HEEL_WIDTH = 40;
    private static final double HEEL_HEIGHT = 60;

    /**
     * The default width and height of the window. These constants will tell Java to
     * create a window whose size is *approximately* given by these dimensions. You should
     * not directly use these constants in your program; instead, use getWidth() and
     * getHeight(), which return the *exact* width and height of the window.
     */
    public static final int APPLICATION_WIDTH = 270;
    public static final int APPLICATION_HEIGHT = 220;

    public void run() {
        drawPawprint(20, 20);
        drawPawprint(180, 70);
    }

    /**
     * Draws a pawprint. The parameters should specify the upper-left corner of the
     * bounding box containing that pawprint.
     *
     * @param x The x coordinate of the upper-left corner of the bounding box for the pawprint.
     * @param y The y coordinate of the upper-left corner of the bounding box for the pawprint.
     */


    private void drawPawprint(double x, double y) {

        /**
         * Draw the first toe using the drawOval function. Give her the coordinates of the beginning and end of the oval.
         */
        drawOval(FIRST_TOE_OFFSET_X + x, FIRST_TOE_OFFSET_Y + y, TOE_WIDTH, TOE_HEIGHT);

        /**
         * Draw the second toe using the drawOval function. Give her the coordinates of the beginning and end of the oval.
         */
        drawOval(SECOND_TOE_OFFSET_X + x, SECOND_TOE_OFFSET_Y + y, TOE_WIDTH, TOE_HEIGHT);

        /**
         * Draw the third toe using the drawOval function. Give her the coordinates of the beginning and end of the oval.
         */
        drawOval(THIRD_TOE_OFFSET_X + x, THIRD_TOE_OFFSET_Y + y, TOE_WIDTH, TOE_HEIGHT);

        /**
         * Draw the paw using the drawOval function. Give her the coordinates of the beginning and end of the oval.
         */
        drawOval(HEEL_OFFSET_X + x, HEEL_OFFSET_Y + y, HEEL_WIDTH, HEEL_HEIGHT);
    }

    /**
     * The function draws oval. The input takes coordinates, where to draw and size oval.
     *
     * @param x - coordinate on the horizontal axis
     * @param y - vertical axis coordinate
     * @param w - width of oval
     * @param h - height of the oval
     */
    private void drawOval(double x, double y, double w, double h) {
        GOval oval = new GOval(x, y, w, h);
        oval.setFilled(true);
        add(oval);
    }
}
