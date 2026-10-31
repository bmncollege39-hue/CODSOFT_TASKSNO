import java.util.Scanner;  // takes input from user
import java.util.Random;  // generate random number

public class Game 
{
    public static void main(String[] args) 
    {
      Scanner scanner = new Scanner(System.in); // Creates object of scanner and random
      Random random = new Random();
      char playAgain; // Creates variable for playing Again
      int Totalscore = 0; // variable to store points of all games played
      int Gameswon = 0;  // counts user has won
      int Totalgames = 0; // counts total game played

      do
      {
        int maxRound = 5; // Only 5 rounds to play game
        int num = random.nextInt(100) + 1; // generate secret no.
        boolean guessedCorrectly = false; // Creates boolean variable
        int attempts = 0; // counts the guess
        int Gamescore = 0; // store points earned 
        
        Totalgames++;
        
        System.out.println("\nWelcome to the Number Guessing Game..");
        System.out.println("Guess a Number between 1 to 100.");
        
        for(int round = 1; round <= maxRound; round++)  // 5 round loops
        {
          System.out.println("\nGuess the Number: "); //user will input a no.
          int user = scanner.nextInt();  //reads user guess
          
          attempts++; // increases attempts

          if(user < 1 || user > 100)  // within that range
          {
            System.out.println("Enter a Number between 1 to 100..");
            continue;    // moves to next round
          }
        
          if(user < num)
          {
            System.out.println("Your Guess Number is too Low!");  // if small
          }
          else if(user == num)
          {
            System.out.println("Your Guess Number is Correct");   // if correct
            guessedCorrectly = true;
            
            Gameswon++; // game won by user increases
            Gamescore = (maxRound - round + 1) * 20; // calculates points
            
            break;   // exit loop
          }
          else
          {
            System.out.println("Your Guess Number is too High!");  // if high
          }

          System.out.println("Round " + round + " of " + maxRound + " Number Game");
          System.out.println(round + " Round Finished..");
        }
        
        if (!guessedCorrectly)  // if not correct
        {
            System.out.println("\nGame Over! The correct number was " + num);  
        }
        
        Totalscore += Gamescore;

        System.out.println("\n--**-- GAME SCORE --**--");
        System.out.println("Attempts Taken: " + attempts);
        System.out.println("Score in This Game: " + Gamescore);
        System.out.println("Total Score: " + Totalscore);
        System.out.println("Games Won: " + Gameswon);
        System.out.println("Games Played: " + Totalgames);
        
        System.out.print("\nDo you want to Play Again? Click Button(y/n): "); // to play Again
        playAgain = scanner.next().toLowerCase().charAt(0);  // user response
      }
      
      while(playAgain == 'y');
      
      System.out.println("\n--**-- FINAL SCORE --**--");
      System.out.println("Total Score: " + Totalscore);
      System.out.println("Games Played: " + Totalgames);
      System.out.println("Games Won: " + Gameswon);
      
      System.out.println("Thank you for playing..");
      
      scanner.close();
        
    }
}
