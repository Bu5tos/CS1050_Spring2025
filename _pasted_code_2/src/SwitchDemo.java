import java.util.Scanner;  // Needed for the Scanner class

/**
 * This program demonstrates the switch statement.
 */

public class SwitchDemo
{
   public static void main(String[] args)
   {
      String input; // To hold keyboard input
      char choice;  // To store the user's choice

      // Create a Scanner object to read input.
      Scanner keyboard = new Scanner(System.in);

      // Ask the user to enter A, B, or C.
      System.out.print("Enter A, B, C, D, or F: ");
      input = keyboard.nextLine();
      choice = input.charAt(0);  // Get the first char
      
      // Determine which character the user entered.
      switch (choice)
      {
         // Switch statement 
         case 'A':
            System.out.println("You entered A.");
            // "False through" the next code if it is not selected
            break;
         case 'B':
            System.out.println("You entered B.");
            break;
         case 'C':
            System.out.println("You entered C.");
            break;
         case 'D':
        	System.out.println("You entered D. You must retake the class");
        	break;
         case 'F':
        	System.out.println("You entered F. You must retake the class");
        	break;
         // Used to perform an action if none of the letters get selected (line 45)
         default:
            // If user inputs a letter that is NOT listed
        	System.out.println("That's not A, B, C, D, or F!");
            
            
      }
   }
}
