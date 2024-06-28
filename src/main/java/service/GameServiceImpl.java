package service;

import iRepository.IGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class GameServiceImpl implements IGame {

    private static final String[] words = {"BIRD", "TREE", "CLOUD", "ROSE"};
    private String selectedWord;

    public String createRandomWord() {
        selectedWord = words[new Random().nextInt(words.length)];
        return selectedWord;
    }

    public int getWordLength(String word) {
        return word.length();
    }

    public boolean isCorrectGuess(String word, char guess) {
        if (word.indexOf(guess) >= 0)
            return true;
        else return false;
    }

    public String getSelectedWord() {
        return selectedWord;
    }

    public boolean isWordGuessed(char[] guessedWord) {

        if (String.valueOf(guessedWord).equals(getSelectedWord()))
            return true;
        return false;
    }
}
