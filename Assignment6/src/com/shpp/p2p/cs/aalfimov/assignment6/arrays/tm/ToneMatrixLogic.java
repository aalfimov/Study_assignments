package com.shpp.p2p.cs.aalfimov.assignment6.arrays.tm;

public class ToneMatrixLogic {

    /**
     * Given the contents of the tone matrix, returns a string of notes that should be played
     * to represent that matrix.
     *
     * @param toneMatrix The contents of the tone matrix.
     * @param column     The column number that is currently being played.
     * @param samples    The sound samples associated with each row.
     * @return A sound sample corresponding to all notes currently being played.
     */
    public static double[] matrixToMusic(boolean[][] toneMatrix, int column, double[][] samples) {
        double[] result = new double[ToneMatrixConstants.sampleSize()];

        double minValue = 0;
        double maxValue = 0;

        for (int i = 0; i < toneMatrix.length; i++) {
            if (toneMatrix[i][column]) {
                for (int x = 0; x < samples[i].length; x++) {
                    result[x] = result[x] + samples[i][x];
                    if (maxValue < result[x]) {
                        maxValue = result[x];
                    }
                    if (minValue > result[x]) {
                        minValue = result[x];
                    }
                }
            }
        }

        return normalize(result, minValue, maxValue);
    }

    /**
     * Normalize the matrix of sounds.
     * If the value of the largest or smallest item has gone beyond [-1.0, 1.0],
     * divide all the tones into this value.
     *
     * @param result   array with sound samples
     * @param minValue minimum value of tone
     * @param maxValue maximum value of tone
     * @return array with normalized sound samples
     */
    public static double[] normalize(double[] result, double minValue, double maxValue) {

        for (int i = 0; i < result.length; i++) {
            if (maxValue > 1 && result[i] > 0)
                result[i] = result[i] / maxValue;
            else if (minValue < -1 && result[i] < 0)
                result[i] = result[i] / -(minValue);
        }

        return result;
    }
}
