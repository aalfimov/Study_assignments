package com.shpp.p2p.cs.aalfimov.assignment6.arrays.sg;

import acm.graphics.*;

public class SteganographyLogic {
    /**
     * Given a GImage containing a hidden message, finds the hidden message
     * contained within it and returns a boolean array containing that message.
     * <p/>
     * A message has been hidden in the input image as follows.  For each pixel
     * in the image, if that pixel has a red component that is an even number,
     * the message value at that pixel is false.  If the red component is an odd
     * number, the message value at that pixel is true.
     *
     * @param source The image containing the hidden message.
     * @return The hidden message, expressed as a boolean array.
     */
    public static boolean[][] findMessage(GImage source) {
        int[][] pixels = source.getPixelArray();
        boolean[][] result = new boolean[pixels.length][pixels[0].length];
        int colorRed;

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[0].length; j++) {
                colorRed = GImage.getRed(pixels[i][j]);
                if (colorRed % 2 == 1) {
                    result[i][j] = true;
                } else {
                    result[i][j] = false;
                }
            }
        }
        return result;
    }

    /**
     * Hides the given message inside the specified image.
     * <p/>
     * The image will be given to you as a GImage of some size, and the message will
     * be specified as a boolean array of pixels, where each white pixel is denoted
     * false and each black pixel is denoted true.
     * <p/>
     * The message should be hidden in the image by adjusting the red channel of all
     * the pixels in the original image.  For each pixel in the original image, you
     * should make the red channel an even number if the message color is white at
     * that position, and odd otherwise.
     * <p/>
     * You can assume that the dimensions of the message and the image are the same.
     * <p/>
     *
     * @param message The message to hide.
     * @param source  The source image.
     * @return A GImage whose pixels have the message hidden within it.
     */
    public static GImage hideMessage(boolean[][] message, GImage source) {
        int[][] pixels = source.getPixelArray();
        int colorRed;

        for (int i = 0; i < message.length; i++) {
            for (int j = 0; j < message[0].length; j++) {
                colorRed = GImage.getRed(pixels[i][j]);
                if (!message[i][j]) {
                    if (colorRed % 2 == 1) {
                        colorRed--;
                    }
                } else {
                    if (colorRed % 2 == 0) {
                        colorRed++;
                    }
                }
                pixels[i][j] = GImage.createRGBPixel(colorRed, GImage.getGreen(pixels[i][j]), GImage.getBlue(pixels[i][j]));
            }
        }
        GImage result = new GImage(pixels);
        return result;
    }
}
