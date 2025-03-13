/*
  *  add comments
  */

import java.util.Scanner;

public class ArraysCode {

	public static void main(String[] args)
	{
		
		// 5. Declare new array called randomNumbers 
		
		// 6. Write Code to fill the array with random numbers from 1 to 10 
		
		// 7. Write Code to find the index containing the smallest number in the randomNumbers array 
		
		// 8. write code to display the index and value of the smallest number
		
		// 9. write a method to return the index containing the smallest number in the randomNumber array

		final int LENGTH_NUMBERS = 10;
		int[] randomNumbers = new int [LENGTH_NUMBERS];
		int length = randomNumbers.length;
		
		for(length = 0; length < LENGTH_NUMBERS; length++);
		   
		   System.out.println("Smallest number is: " + length);
		
		
		
		
		
		
		
		
		// Examples of processing arrays
		final int TOTAL_NUMBERS = 5;
		// Creating an array of integers, creating a new object, holding an address
		int[] numbers = new int[TOTAL_NUMBERS];
		
		//.length is the storage of how many locations can be stored in an array
		int numbersLength = numbers.length;

		// 1. Explain
		System.out.println("Update this message with what is going on");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter " + numbersLength + " values: ");
		for (int index = 0; index < numbersLength; index++) {
			System.out.printf("Enter value #%d: ", index+1);
			numbers[index] = input.nextInt();
		}

		// 2. Explain
		System.out.println("Update this message with what is going on");
		for (int index = 0; index < numbersLength; index++) {
			System.out.println("numbers[" + index + "] = " + numbers[index]);
		}

		// 3. Explain
		System.out.println("Update this message with what is going on");
		int badNameVar = 0;
		for (int index = 0; index < numbers.length; index++) {
			badNameVar = badNameVar + numbers[index];
		}
		System.out.println("Update badNameVar = " + badNameVar);

		// 4. Explain
		System.out.println("Update this message with what is going on");
		int badNameVar2 = numbers[0];
		for (int index = 1; index < numbers.length; index++) {
			if (numbers[index] > badNameVar2) {
				badNameVar2 = numbers[index];
			}
		}
		System.out.println("Update badNameVar2 = " + badNameVar2);
		
		
		input.close();
	} // main
	

	
}// end class