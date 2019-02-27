package com.shpp.p2p.cs.aalfimov;

import com.shpp.cs.a.console.TextProgram;

import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class assignment5part3 extends TextProgram {
    /**
     * Path to the dictionary
     */
    private static final String FILE = "assets/en-dictionary.txt";

    /**
     * A game. We ask the user for 3 letters of the license plate of the car.
     * We find a word from the wording, in which there are these letters in the same sequence.
     */
    public void run() {
        /**
         * Ask the user for the word and do a length check
         */
        while (true) {
            println("Enter car number with 3 chars: ");
            String wordToFind = readLine().replaceAll("[0-9]", "").toLowerCase();
            if (wordToFind.length() > 3 || wordToFind.length() < 3) {
                println("Wrong length, only 3 char needed. Try again:");
                continue;
            }
            findAnswer(wordToFind);
        }
    }

    private String findAnswer(String wordToFind) {
        /**
         * Read dictionary and put in array list
         */
        ArrayList<String> dictionary = readDictionary();

        /**
         * Save each letter in a separate variable for convenience
         */
        char one = wordToFind.charAt(0);
        char two = wordToFind.charAt(1);
        char three = wordToFind.charAt(2);

        /**
         * We look for a letter in a word, if we find it,
         * we continue the search from the place where we stopped
         */
        for (String word : dictionary) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == one) {
                    for (int j = i; j < word.length(); j++) {
                        if (word.charAt(j) == two) {
                            for (int k = j; k < word.length(); k++) {
                                if (word.charAt(k) == three) {
                                    println(word);
                                }
                            }
                        }
                    }
                }
            }
        }
        return "";
    }

    /**
     * Read the file en-dictionary.txt and put in the ArrayList
     *
     * @return array with english dictionary
     */
    private ArrayList<String> readDictionary() {
        ArrayList<String> dictionary = new ArrayList<>();
        try (BufferedReader readFile = new BufferedReader(new FileReader(FILE))) {
            String word;
            while (true) {
                word = readFile.readLine();
                if (word == null) {
                    break;
                }
                dictionary.add(word);
            }
        } catch (IOException ex) {
            println(ex.getMessage());
        }
        return dictionary;
    }
}








