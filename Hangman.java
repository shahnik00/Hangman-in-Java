
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
	public static void main(String[] args) {
		Hangman test = new Hangman();
		test.start();
	}

	static ArrayList<Character> playerGuess = new ArrayList<>();
	static int correctLetters = 0;
	static int wrongGuesses = 0;

	void start() {
		System.out.println("Enter a word:");
        Scanner wInput = new Scanner(System.in);
        String word = wInput.nextLine();

        wordState(word, Hangman.playerGuess);

        boolean lost = false;

        while(Hangman.correctLetters < word.length()) {
        	if(Hangman.wrongGuesses==6) { //checks attempts, determines losing
        		System.out.print("\nYou lost, try again!");
        		lost = true;
        		break;
        	}
        	correctLetters = 0; //reset count
        	System.out.print("\n");
			getPlayerGuess(word, playerGuess, wInput);
		}
        if(!lost) {
        	System.out.print("\nCongratulations, you won!");
        }
	}

    //this gets a letter and adds it to the arraylist. then it prints out the new "wordstate"
	private static void getPlayerGuess(String word, ArrayList<Character> playerGuess, Scanner input) {
		System.out.println("\nGuess a letter: ");
		String letter = input.nextLine();
		playerGuess.add(letter.charAt(0));

		if(!word.contains(letter)) {
			Hangman.wrongGuesses++;
		}
		wordState(word, playerGuess);
	}

    //word with guesses applied
    //B is to find when the word is completed
	private static void wordState(String word, ArrayList<Character> playerGuess) {
		for(int i = 0; i < word.length(); i++)
		{
			if(playerGuess.contains(word.charAt(i)))
			{
			    System.out.print(word.charAt(i) + " ");
			    Hangman.correctLetters++;
            }
            else
            {
                System.out.print("_ ");
            }
        }
		if(Hangman.wrongGuesses==0) {
			System.out.print("\n ____\n/    |\n|\n|\n|\n|_________");
		}
		if(Hangman.wrongGuesses==1) {
			System.out.print("\n ____\n/    |\n|    o\n|\n|\n|_________");
		}
		if(Hangman.wrongGuesses==2) {
			System.out.print("\n ____\n/    |\n|    o\n|    |\n|\n|_________");
		}
		if(Hangman.wrongGuesses==3) {
			System.out.print("\n ____\n/    |\n|    o\n|   /|\n|\n|_________");
		}
		if(Hangman.wrongGuesses==4) {
			System.out.print("\n ____\n/    |\n|    o\n|   /|\\\n|\n|_________");
		}
		if(Hangman.wrongGuesses==5) {
			System.out.print("\n ____\n/    |\n|    o\n|   /|\\\n|   /\n|_________");
		}
		if(Hangman.wrongGuesses==6) {
			System.out.print("\n ____\n/    |\n|    o\n|   /|\\\n|   / \\\n|_________");
		}
	}
}