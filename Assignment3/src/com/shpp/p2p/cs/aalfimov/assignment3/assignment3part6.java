package com.shpp.p2p.cs.aalfimov.assignment3;

import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;
import acm.graphics.GOval;


public class assignment3part6 extends WindowProgram {

    public static final double BALL_SIZE = 100;

    /**
     * The amount of time to pause between frames (48fps).
     */
    public static final double PAUSE_TIME = 1000.0 / 13;
    public static final double ANIMATION_TIME = PAUSE_TIME * 5;
    public static final double OFFSET = 10.0;

    public void run() {
        /**
         * Make ball, and move them by circle with OFFSET * i
         */

        for (double i = 1; i < ANIMATION_TIME; i++) {
            GOval ball = makeBall();
            add(ball);
            ball.move(Math.sin(i) * OFFSET * i, Math.cos(i) * OFFSET * i);
            pause(PAUSE_TIME);
        }
    }

    /**
     * The program creates a ball with a random color in a center of screen
     *
     * @return ball
     */

    public GOval makeBall() {

        RandomGenerator rgen = RandomGenerator.getInstance();
        GOval ball = new GOval((getWidth() - BALL_SIZE) / 2, (getHeight() - BALL_SIZE) / 2, BALL_SIZE, BALL_SIZE);
        ball.setFilled(true);
        ball.setColor(rgen.nextColor());
        return ball;
    }

}