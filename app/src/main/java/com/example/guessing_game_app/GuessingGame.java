package com.example.guessing_game_app;

import java.util.HashMap;
import java.util.Random;

public class GuessingGame {
    Random rand = new Random();
    int compsGuess;

    HashMap<Integer, String> numToString;

    GuessingGame() {
        regenerateCompsGuess();

        numToString = new HashMap<>();
        numToString.put(1, "one");
        numToString.put(2, "two");
        numToString.put(3, "three");
    }

    private void regenerateCompsGuess() {
        compsGuess = rand.nextInt(2) + 1;
    }

    public String getSolution(int clicked) {
        regenerateCompsGuess();

        String clickedString = numToString.get(clicked);
        if (clicked == compsGuess) {
            return "Yes! The answer was " + clickedString + ".";
        } else {
            return "Aw man, " + clickedString + " was not the answer.";
        }
    }
}
