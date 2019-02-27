package com.shpp.p2p.cs.aalfimov;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;


public class Breakout extends WindowProgram {
    /**
     * Width and height of application window in pixels
     */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    /**
     * Dimensions of game board (usually the same)
     */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;
    /**
     * Dimensions of the paddle
     */
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;
    /**
     * Offset of the paddle up from the bottom
     */
    private static final int PADDLE_Y_OFFSET = 30;
    /**
     * Number of bricks per row
     */
    private static final int NBRICKS_PER_ROW = 10;
    /**
     * Number of rows of bricks
     */
    private static final int NBRICK_ROWS = 10;
    /**
     * Separation between bricks
     */
    private static final int BRICK_SEP = 4;
    /**
     * Width of a brick
     */
    private static final int BRICK_WIDTH = (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;
    /**
     * Height of a brick
     */
    private static final int BRICK_HEIGHT = 8;
    /**
     * Radius of the ball in pixels
     */
    private static final int BALL_RADIUS = 10;
    /**
     * Offset of the top brick row from the top
     */
    private static final int BRICK_Y_OFFSET = 70;
    /**
     * Number of turns
     */
    private static final int NTURNS = 3;
    /**
     * The amount of time to pause between frames (100 fps).
     */
    private static final double PAUSE_TIME = 1000.0 / 100;
    /**
     * Make Paddle
     */
    private GRect PADDLE;
    /**
     * Make ball
     */
    private GOval BALL;
    /**
     * Ball speed
     */
    private double VX, VY = 3.0;

    /**
     * Counter of brick
     */
    private int WINNING_COUNTER = NBRICK_ROWS * NBRICKS_PER_ROW;

    /**
     * Game Breakout
     */
    public void run() {
        startGame();
    }

    /**
     * Create objects and start the game.
     * Player has NTURNS attempts.
     * Depending on the result, call endGame() with true or false.
     */
    private void startGame() {
        preparationForTheGame();
        for (int i = 0; i < NTURNS; i++) {
            waitForClick();
            game();
        }
        if (WINNING_COUNTER > 0) {
            endGame(false);
        }
    }

    /**
     * The game continues until the count of bricks has reached zero,
     * or attempts have expired.
     */
    private void game() {
        while (true) {
            ricochet();
            if (BALL.getY() > APPLICATION_HEIGHT) {
                BALL.move(WIDTH, HEIGHT);
                makeBall();
                break;
            }
            if (WINNING_COUNTER == 0) {
                endGame(true);
                break;
            }
            pause(PAUSE_TIME);
        }
    }

    /**
     * Create objects: paddle, ball, bricks.
     * Start listen the mouse. Ready to click mouse.
     */
    private void preparationForTheGame() {
        setUpThePaddle();
        makeBall();
        makeBricks();
        addMouseListeners();
    }

    /**
     * Make paddle, GRect object with start coordinate in centre APPLICATION_WIDTH
     * Y coordinates with PADDLE_Y_OFFSET
     */
    private void setUpThePaddle() {
        PADDLE = new GRect(WIDTH / 2 - PADDLE_WIDTH / 2,
                HEIGHT - PADDLE_Y_OFFSET,
                PADDLE_WIDTH,
                PADDLE_HEIGHT);
        PADDLE.setFilled(true);
        PADDLE.setColor(Color.BLACK);
        add(PADDLE);
    }

    /**
     * Make ball in center of screen. Give him random start value.
     */
    private GOval makeBall() {
        BALL = new GOval(WIDTH / 2 - BALL_RADIUS / 2,
                HEIGHT / 2 - BALL_RADIUS / 2,
                BALL_RADIUS * 2,
                BALL_RADIUS * 2);
        BALL.setFilled(true);
        BALL.setFillColor(Color.BLACK);
        add(BALL);
        randomStartValues();
        return BALL;
    }

    /**
     * The ball starts to fall down, randomly between 1.0 and 3.0 x coordinate offset
     */
    private void randomStartValues() {
        RandomGenerator rgen = RandomGenerator.getInstance();
        VX = rgen.nextDouble(1.0, 3.0);
        if (rgen.nextBoolean(0.5))
            VX = -VX;
    }

    /**
     * Make array with colors for each rows
     * Draw 100 brick, 10 per row, and fill them color.
     */
    private void makeBricks() {
        Color[] arrayColor = new Color[]{Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN};
        for (int i = 0; i < NBRICKS_PER_ROW; i++) {
            for (int j = 0; j < NBRICK_ROWS; j++) {
                drawBricks(i * (BRICK_WIDTH + BRICK_SEP) + BRICK_SEP,
                        j * (BRICK_HEIGHT + BRICK_SEP) - BRICK_SEP + BRICK_Y_OFFSET,
                        BRICK_WIDTH,
                        BRICK_HEIGHT,
                        arrayColor[j / 2]);
            }
        }
    }

    /**
     * The function draw the Brick. Give her the coordinates and color to filled
     *
     * @param x     - coordinate on the horizontal axis
     * @param y     - vertical axis coordinate
     * @param w     - width of rectangle
     * @param h     - height of a rectangle
     * @param color - color of Brick
     */
    private void drawBricks(int x, int y, int w, int h, Color color) {
        GRect brick = new GRect(x, y, w, h);
        brick.setFilled(true);
        brick.setColor(color);
        add(brick);
    }

    /**
     * Move the paddle behind the mouse and watch, so as not to climb out the screen
     *
     * @param mouseEvent follow the mouse movement
     */
    public void mouseMoved(MouseEvent mouseEvent) {
        if ((mouseEvent.getX() < WIDTH - PADDLE_WIDTH / 2) && (mouseEvent.getX() > PADDLE_WIDTH / 2)) {
            PADDLE.setLocation(mouseEvent.getX() - PADDLE_WIDTH / 2, HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
        }
    }


    /**
     * Ricochet of the ball from the edges of the screen and other objects
     */
    private void ricochet() {
        BALL.move(VX, VY);
        if (BALL.getY() < 0) {
            VY = -VY;
        }
        if (BALL.getX() < 0 || BALL.getX() > APPLICATION_WIDTH - BALL_RADIUS * 2) {
            VX = -VX;
        }
        GObject collider = getCollidingObject();
        if (collider == PADDLE) {
            VY = -VY;
        } else if (collider != null) {
            remove(collider);
            WINNING_COUNTER--;
            VY = -VY;
        }

    }

    /**
     * Check four corners around the ball
     *
     * @return Return the object if we could find it. Otherwise, return null.
     */
    private GObject getCollidingObject() {

        if ((getElementAt(BALL.getX(), BALL.getY())) != null) {
            return getElementAt(BALL.getX(), BALL.getY());
        } else if (getElementAt((BALL.getX() + 2 * BALL_RADIUS), BALL.getY()) != null) {
            return getElementAt(BALL.getX() + 2 * BALL_RADIUS, BALL.getY());
        } else if (getElementAt(BALL.getX(), (BALL.getY() + 2 * BALL_RADIUS)) != null) {
            return getElementAt(BALL.getX(), BALL.getY() + 2 * BALL_RADIUS);
        } else if (getElementAt((BALL.getX() + 2 * BALL_RADIUS), (BALL.getY() + 2 * BALL_RADIUS)) != null) {
            return getElementAt(BALL.getX() + 2 * BALL_RADIUS, BALL.getY() + 2 * BALL_RADIUS);
        } else {
            return null;
        }
    }

    /**
     * Display the label of the end game.
     *
     * @param end - is a boolean: true - win game, false - lose.
     * @return label of end game
     */
    private GLabel endGame(boolean end) {
        String screen = "Congratulations! You win!";
        if (end == false) {
            screen = "Game Over";
        }
        GLabel endGameScreen = new GLabel(screen, WIDTH / 2, HEIGHT / 2);
        endGameScreen.setFont("Verdana-30");
        endGameScreen.move(-endGameScreen.getWidth() / 2, -endGameScreen.getHeight() / 2);
        if (end == false) {
            endGameScreen.setColor(Color.RED);
        } else {
            endGameScreen.setColor(Color.GREEN);
        }
        add(endGameScreen);
        return endGameScreen;
    }
}

