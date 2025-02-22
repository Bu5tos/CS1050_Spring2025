/**
 * Calculate the BMI using formula in US units
 * Use will enter weight in pounds and height in inches
 */

// ADD CODE to import Scanner class 
import java.util.Scanner;

public class BodyMassIndex
{
	public static void main(String[] args)
	{
		//constants
		final int BMI_US_FACTOR = 703; //factor formula in pounds
		// Variables
		double weight; // The user's weight
		double height; // The user's height
		double bmi; // The user's BMI
		
		//MIN and MAX's limits to initialize variables 
		double MAX_UNDER_WEIGHT = 18.4;
		double MIN_NORMAL = 18.5;
		double MIN_OVER_WEIGHT = 25.0;
		double MIN_OBESE = 40.0;
		
		// Create a Scanner object for scanning input from keyboard
		Scanner input = new Scanner(System.in); 
		// ADD CODE name object variable input 
		
		// Tell the user what the program will do.
		System.out.println("This program will calculate your " + "body mass index, or BMI.");
		
		// Get the user's weight.
		System.out.println("Enter your weight, in pounds: ");
		// ADD CODE to input next double for weight
		weight = input.nextDouble();
		// Get the user's height.
		System.out.println("Enter your height, in inches: ");
		// ADD CODE input next double for height
		height = input.nextDouble();
		
		// Calculate the user's body mass index.
		bmi = weight * BMI_US_FACTOR / (height * height);

		// Display the user's BMI.
		System.out.printf("Your body mass index (BMI) is %f", bmi);
		System.out.println("");
		
		//Only one condition can be true 
		if (bmi <= MAX_UNDER_WEIGHT){
		System.out.println("Your category: underweight ");
		}
		else if (bmi >= MIN_OBESE ){
		System.out.println("Your category: Obese");
		}
		else if (bmi >= MIN_OVER_WEIGHT){
		System.out.println("Your category: Overweight");
		}
		else if (bmi >= MIN_NORMAL){
		System.out.println("Your category: Normal");
		}
		
	}
}
