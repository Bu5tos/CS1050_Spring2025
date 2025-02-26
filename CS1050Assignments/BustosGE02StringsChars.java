/**
 * 
 */

/**
 * 
 */

import java.util.Scanner;

public class BustosGE02StringsChars 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		//User types in first and last name twice 
		Scanner input = new Scanner(System.in);
		System.out.println("Enter student 1 first name: " );
		String firstName1 = input.next();
		System.out.println("Enter student 1 last name: " );
		String lastName1 = input.next();
		System.out.println("Enter student 2 first name: " );
		String firstName2 = input.next();
		System.out.println("Enter student 2 last name: " );
		String lastName2 = input.next();
		
		System.out.println("Students in alphabetical order by last name:" );
		
		//Comparing last name with first name
	    if (lastName1.compareToIgnoreCase(lastName2) > 0)
	    {
	    	System.out.print(firstName2 + " " + lastName2);
	    	System.out.println(firstName1 + " " + lastName1);
	    	
	    }
	    else if (lastName1.compareToIgnoreCase(lastName2) < 0)
	    {
	    	System.out.println(firstName1 + " " + lastName1);
	    	System.out.print(firstName2 + " " + lastName2);
	    }
	
	    System.out.println(" ");
	    System.out.println("Initials: ");
	    
	    char firstInitial1 = firstName1.charAt(0);
	    char lastInitial1 = lastName1.charAt(0);
	    char firstInitial2 = firstName2.charAt(0);
	    char lastInitial2 = lastName2.charAt(0);
	    
        System.out.println("Student 1: " + firstInitial1 + ". " + lastInitial1 + ".");
        System.out.println("Student 2: " + firstInitial2 + ". " + lastInitial2 + ".");
	    
	}
}

