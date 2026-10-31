import java.util.Scanner;

public class Calculator
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Student Grade Calculator..");
        
        System.out.print("Enter the Total Number of Subjects: ");   // input no. of Subjects
        int subjects = scanner.nextInt(); //store no. of subjects
        
        double Totalmarks = 0;
        
        for(int i = 1; i <= subjects; i++)
        {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            double marks = scanner.nextDouble(); //decimal no. can also be taken
            
            while(marks < 0 || marks > 100) // validate the marks
            {
                System.out.print("Invalid marks! Please enter a marks between 0 and 100..");
                marks = scanner.nextDouble();
            }
            
            Totalmarks = Totalmarks + marks;  // sum of all subjects
        }
        
        double average = Totalmarks / subjects;  // calculate average percentage
        
        char grade;    // store single character like A,B,C,D...
        if (average >= 90) 
        {
          grade = 'A';
        } else if (average >= 80) 
        {
          grade = 'B';
        } else if (average >= 70) 
        {
          grade = 'C';
        } else if (average >= 60) 
        {
          grade = 'D';
        } else if (average >= 50) 
        {
          grade = 'E';
        } else 
        {
          grade = 'F';
        }
        
        System.out.println("\n--- Student Result ---");
        System.out.println("Total Marks Obtained: " + Totalmarks + " / " + (subjects * 100));
        System.out.println("Average Percentage: " + average + "%");
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}
