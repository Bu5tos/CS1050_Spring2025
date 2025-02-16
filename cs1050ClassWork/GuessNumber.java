/**
 * This program takes user input to see if they can guess the 
 * random number generated
 */


import java.util.Scanner; //Import Scanner class

public class GuessNumber //Class Identifier: "GuessNumber"
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// Main method
	    int number = (int)(Math.random() * 101);
        //Data type: "int" Variable: "number"
	   
	    Scanner input = new Scanner(System.in); 
	    System.out.println("Guess a magic number between 0 and 100");
       
	    // Declare an "int" to store the "guess"
	    // Initialize "guess" 
	    int guess = -1;
	    // If guess doesn't match to number, the code will run repeatedly until the number is correct
	    while (guess != number)
	    {
	      //
	      System.out.print("\nEnter your guess: ");
	      if (input.hasNextInt())
	      {
	      guess = input.nextInt();

	      if (guess == number)
	        System.out.println("Yes, the number is " + number);
	      else if (guess > number)
	        System.out.println("Your guess is too high");
	      else
	        System.out.println("Your guess is too low");
	      } else 
	      {
	    	  System.out.println("Invalid input. Please enter an integer.");
	    	  input.next();
	      }
	    } 
		input.close();
		System.out.println("Thank you for playing!");
	}

}