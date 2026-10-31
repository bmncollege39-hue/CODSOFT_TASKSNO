import java.util.Scanner;  //take input

public class Quizapplication 
{
  public static void main(String[] args) 
  {
    Scanner scanner = new Scanner(System.in);  //created object

    String[] questions =            //questions is an array name storing questions
    {
      "1. Which language is used for Android development?",
      "2. Which keyword is used to create a class in Java?",
      "3. Which method is the starting point of Java?",
      "4. Which data type stores whole numbers?",
      "5. Which symbol ends a Java statement?"
    };

    String[][] options =          // 2D... store multiple choice options
    {
      {"1. Java", "2. HTML", "3. CSS", "4. SQL"},
      {"1. function", "2. class", "3. create", "4. object"},
      {"1. start()", "2. run()", "3. main()", "4. begin()"},
      {"1. String", "2. boolean", "3. int", "4. char"},
      {"1. :", "2. ,", "3. .", "4. ;"}
    };

    int[] correctans = {1, 2, 3, 3, 4};  //store correct answers
    int[] userans = new int[questions.length];  //store user answer

    int score = 0;  //starts from 0 
    int timelimit = 15; //time limit is given for questions

    System.out.println("***----***----***----");
    System.out.println("JAVA QUIZ APPLICATION");
    System.out.println("***----***----***----");
    System.out.println("You have " + timelimit +
                           " seconds for each question.");
    System.out.println("Enter 1, 2, 3, or 4 to answer.");
    System.out.println();

    for (int i = 0; i < questions.length; i++)  //displaying questions
    {
      System.out.println("--------------------------------");
      System.out.println(questions[i]); // i.. display question at the current array position

      for (int j = 0; j < options[i].length; j++)  //displaying options
      {
        System.out.println(options[i][j]);
      }

      System.out.println();

      long starttime = System.currentTimeMillis();  //start the timer... store it in milliseconds
      System.out.print("Enter your answer: ");

      String answer = scanner.nextLine().trim(); //reads user input

      long endtime = System.currentTimeMillis(); //store time after user press enter
      long timetaken = (endtime - starttime) / 1000; //calculate time taken

      if (timetaken > timelimit) //check time limit
      {
        userans[i] = 0;
        System.out.println("Time's up! No marks awarded....");
      } else 
      {
      try      //convert answer into integer
      {
        int selected = Integer.parseInt(answer);

        if (selected >= 1 && selected <= 4) //validate selected option
        {
          userans[i] = selected;

          if (selected == correctans[i]) //check whether answer is correct
          {
            score++;
            System.out.println("Correct answer...");
          } else 
          {
            System.out.println("Incorrect answer...");
          }
        } else 
        {
          userans[i] = 0;
          System.out.println("Invalid option..");
        }
      } catch (NumberFormatException e) //handle non numeric input like abc
      {
        userans[i] = 0;
        System.out.println("Please enter a valid number..");
      }
      }

      System.out.println("Correct option: "
                               + options[i][correctans[i] - 1]);
      System.out.println();
    }

      System.out.println("***----***----***----");
      System.out.println("    QUIZ RESULTS");
      System.out.println("***----***----***----");

      System.out.println("Total Questions: " + questions.length);
      System.out.println("Correct Answers: " + score);
      System.out.println("Incorrect / Unanswered: "
                           + (questions.length - score));
      System.out.println("Final Score: " + score + " / "
                           + questions.length);
      System.out.println("Percentage: "
                           + (score * 100 / questions.length) + "%");

      System.out.println();
      System.out.println(" ANSWER SUMMARY");
      System.out.println("***----***----***----");

      for (int i = 0; i < questions.length; i++)  //display answer
      {
        System.out.println(questions[i]);

        if (userans[i] == correctans[i]) 
        {
          System.out.println("Your answer: "
                    + options[i][userans[i] - 1]);
          System.out.println("Result: Correct");
        } else 
        {
          if (userans[i] == 0) 
          {
            System.out.println("Your answer: Not answered");
          } else 
          {
            System.out.println("Your answer: "
                        + options[i][userans[i] - 1]);
          }

            System.out.println("Result: Incorrect");
            System.out.println("Correct answer: "
                    + options[i][correctans[i] - 1]);
        }

        System.out.println();
      }

      System.out.println("Thank you for playing the quiz..");

      scanner.close();
  }
}
