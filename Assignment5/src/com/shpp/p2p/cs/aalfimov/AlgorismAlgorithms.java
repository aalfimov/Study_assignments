package com.shpp.p2p.cs.aalfimov;

import com.shpp.cs.a.console.TextProgram;


public class AlgorismAlgorithms extends TextProgram {


    public void run() {
        /* Sit in a loop, reading numbers and adding them. */
        while (true) {
            String n1 = readLine("Enter first number: ");
            String n2 = readLine("Enter second number: ");
            println(n1 + " + " + n2 + " = " + addNumericStrings(n1, n2));
            println();
        }
    }

    /**
     * Given two string representations of nonnegative integers, adds the
     * numbers represented by those strings and returns the result.
     *
     * @param n1 The first number.
     * @param n2 The second number.
     * @return A String representation of n1 + n2
     */
    private String addNumericStrings(String n1, String n2) {
        /**
         * Find the longest array
         */
        int stringLength = n1.length()+1;
        if (stringLength < n2.length()) {
            stringLength = n2.length()+1;
        }

        int [] arrayN1 = stringToArray(n1,stringLength);
        int [] arrayN2 = stringToArray(n2,stringLength);

        /**
         * Add values,
         * if the values are greater than 9,
         * transfer 1 to the next number
         */
        for(int i = stringLength-1; i>=0;i--){
            arrayN1[i] = arrayN1[i] + arrayN2[i];
            if (arrayN1[i] > 9) {
                arrayN1[i] = arrayN1[i] % 10;
                arrayN1[i - 1]++;
            }
        }

        return backToString(arrayN1);
    }

    /**
     * Remove char from string
     * @param s string
     * @param pos position char to remove
     * @return
     */
    private static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    /**
     * Transform array to string. If first char '0', remove it.
     * @param array to convert
     * @return string
     */
    private String backToString (int[] array){
        String result = "";
        for (int i : array) {
            result += Integer.toString(i);
        }
        if(result.startsWith("0")){
            result=removeCharAt(result,0);
        }
        return result;
    }

    /**
     * The method converts a string to an array for ease of use.
     * Shift the values to the right.
     *
     * @param string to convert in array
     * @param stringLength array length
     * @return array
     */
    private int [] stringToArray (String string, int stringLength){
        int [] array = new int [stringLength];
        int offset = stringLength-string.length();
        for (int i=0; i<string.length();i++){
            array[i+offset] = string.charAt(i) - '0';
        }
        return array;
    }
}
