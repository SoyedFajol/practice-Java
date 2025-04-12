import java.util.Scanner;
import java.util.Random;


public class NumberGuessGame {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            Random random= new Random();

            int numberToGuess=random.nextInt(100)+1;
            int guess;
            int attempts=0;
            System.out.println("Guess the number between 1 and 100!");
            do{
                System.out.print("Enter your guess:");
                guess=scanner.nextInt();
                attempts++;
                if(guess < numberToGuess){
                    System.out.println("Too Low");
                }else if (guess > numberToGuess){
                    System.out.println("Too high!");
                }else {
                    System.out.println("Correct you guess it in  " + attempts + "  attempts.");
                }
            }while(guess!=numberToGuess);
        }


    }
    
}
