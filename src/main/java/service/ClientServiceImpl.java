package service;

import Provider.ApplicationContextProvider;
import iRepository.IClient;
import model.User;

import java.util.Scanner;

public class ClientServiceImpl implements IClient {


    public void startGame() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Guess the Word Game!");
        System.out.print("Enter your name please: ");
        String name = scanner.nextLine();
        System.out.print("Enter your family name please: ");
        String family = scanner.nextLine();


        UserService Usercontext = ApplicationContextProvider.getUserService();
        Usercontext.addNewUser(name, family);


        GameServiceImpl GameContex = ApplicationContextProvider.getGameService();
        // Start the game
        String newdWord = GameContex.createRandomWord();
        int wordLength = GameContex.getWordLength(newdWord);
        int totalGuesses = wordLength * 3;
        char[] guessedWord = new char[wordLength];
        for (int i = 0; i < wordLength; i++) {
            guessedWord[i] = '_';
        }

        System.out.println("Guess the word. You have " + totalGuesses + " chances.");

        while (totalGuesses > 0) {
            System.out.print("Enter your guess: ");

            String guess = scanner.nextLine();
            if ("Esc".equalsIgnoreCase(guess)) {
                System.out.println("Exiting game...");
                break;
            }
            char Resguess = guess.charAt(0);

            if (GameContex.isCorrectGuess(newdWord, Resguess)) {
                System.out.println("Well done! you find one correct word");
                for (int i = 0; i < wordLength; i++) {
                    if (GameContex.getSelectedWord().charAt(i) == Resguess) {
                        guessedWord[i] = Resguess;
                    }
                }
                if (GameContex.isWordGuessed(guessedWord)) {
                    User user = new User(name, family);
                    System.out.println("Congratulations! " + user.getName() + " " + user.getFamily() + " You've guessed the word!");
                    break;
                }
            } else {
                System.out.println("Sorry, wrong guess. Try again.");
                totalGuesses -= 1;
                System.out.println("Remaining chances: " + totalGuesses);
            }
        }

        if (totalGuesses == 0) {
            System.out.println("Game over! The word was: " + newdWord);
        }


        scanner.close();


    }

}
