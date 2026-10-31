import java.util.Scanner;    //reads input

class Bankaccount   //create bankaccount class
{
    double balance = 10000;  //balance is store 
    
    void deposit(double amount) //deposit method that accepts amount
    {
        if(amount > 0)
        {
            balance = balance + amount; //add in balance
            System.out.println("Money Deposited Successfully.."); 
        } else 
        {
            System.out.println("Invalid Deposit amount");
        }
    }
    
    void withdraw(double amount) //withdraw method
    {
        if(amount <= 0)
        {
            System.out.println("Invalid Withdrawal amount");
        } else if(amount > balance)
        {
           System.out.println("Insufficient balance.."); 
        } else
        {
            balance = balance - amount; //subtract from balance
            System.out.println("Money Withdrawn Successfully..");
        }
    }
    
    void checkbalance() //check the balance method
    {
        System.out.println("Your balance is: Rs. " + balance);
    }
}

public class ATMmachine //create ATMmachine class
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); //reads input
        Bankaccount ac = new Bankaccount(); //object of account to call methods
        
        int choice; //choice for users
        
        do
        {
            System.out.println("\n Welcome to ATM Machine");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Deposit Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice: ");
            
            choice = sc.nextInt(); //reads int by the user 
            
            switch(choice)
            {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double wdamount = sc.nextDouble(); //reads amount given by user
                    ac.withdraw(wdamount); //call the withdraw method
                    break;
                
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double damount = sc.nextDouble(); // reads amount given by user
                    ac.deposit(damount); //call the deposit method
                    break;
                    
                case 3:
                    ac.checkbalance(); //call the checkbalance method
                    break;
                    
                case 4:
                    System.out.println("Thank You for using ATM Machine"); //when exit is inputed
                    break;
                    
                default:
                    System.out.println("Invalid Choice! Try Again.."); //wrong number
            }
        }
        
        while(choice != 4); //loop ends if 4 is equal
        
        sc.close(); //scanner close
    }
}
