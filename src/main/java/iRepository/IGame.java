package iRepository;

public interface IGame {
    String createRandomWord();
    int getWordLength(String word);
    boolean isCorrectGuess(String word, char guess);
    public boolean isWordGuessed(char[] guessedWord);
}
