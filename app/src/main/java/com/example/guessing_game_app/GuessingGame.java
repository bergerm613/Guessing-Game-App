package com.example.guessing_game_app;

import java.util.HashMap;
import java.util.Random;

public class GuessingGame {
    Random rand = new Random();
    String compsGuess;

    HashMap<Integer, String> numToString;

    GuessingGame() {
        numToString = new HashMap<>();
        numToString.put(1, "one");
        numToString.put(2, "two");
        numToString.put(3, "three");
    }

    public String getGuessResult(String clicked) {
        regenerateCompsGuess();
        return getSolutionText(clicked);
    }

    private void regenerateCompsGuess() {
        compsGuess = numToString.get(rand.nextInt(3) + 1);
    }

    private String getSolutionText(String clicked) {
        return clicked.equalsIgnoreCase(compsGuess)
                ? "Yes! The answer was " + clicked.toLowerCase() + "."
                : "Aw man, " + clicked.toLowerCase() + " was not the answer.";
    }
}
