/**
 * 
 */

/**
 * 
 */

import java.util.Scanner;

public class MO2L06MathChars
	{
	
	public static void main(String[] args) 
	{

		double exponentResult = Math.pow(10, 2);
		System.out.println("result =" + exponentResult);
		System.out.println("");
		
	    double randomDouble = Math.random();
	    int randomInt = (int)randomDouble;
	    randomInt = (int)(randomDouble * 10);
	    randomInt = (int)(randomDouble * 10 + 1);
	
   	    //Note: ('') = character. ("") = string
        char middleInitial = '1';//Assigns the character 4 to numCharacter
        int charIntValue = 1;
   
        System.out.println(middleInitial);
        charIntValue = (int)middleInitial;
        System.out.println("");
        
        System.out.println(charIntValue);
	
	    Scanner input = new Scanner(System.in);
	
	    System.out.println("Enter a char");
	    char someChar = input.next().charAt(0);
	    System.out.printf("A char was enetred with ascii value %d\n", someChar);
	    
	    String firstName = "Bustos";
	    
	    int myStringLength = myString.length();
	    System.out.println("The length of my string is = " + myStringLength);
	    
	    System.out.println("The 1st letter in student's name is " + myStringLength);
	    System.out.println("The last letter is " + myString.charAt(myString.length()-1));
	    
	    System.out.println("The last letter is " + myString.charAt(myString.length()+1));
	
	}

}
