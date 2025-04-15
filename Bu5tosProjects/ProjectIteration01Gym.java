import java.util.Scanner;
public class ProjectIteration01Gym {
	
public static void main(String[] args) {
	
//User Story 1
	
	System.out.println("     Welcome to the Gym Athlete Fitness Tracker     ");
	System.out.println(" ");
	Scanner input = new Scanner(System.in);
	int numberOfAthletes = getValidNumAthletes(0, input);
	int[] arrayOfAthletes = new int[numberOfAthletes];
	
	double weight = getValidWeight(0, input);
	System.out.println("Athlete's height(inches): ");
	double height = input.nextInt();
	System.out.println("Athlete's age: ");
	int age = input.nextInt();
	int[] dailyBurnedCalories = caloriesBurned(input);
	System.out.println(" ");
	
	System.out.println("     Gym Weekly Fitness Summary     ");

}//End main

public static int[] caloriesBurned(Scanner input) {
	
	int[] day = new int[7];
	
	for(int index = 0; index < day.length; index++) {
			
		System.out.println("Enter Calories burned on day " + (index + 1) + ":");
		day[index] = input.nextInt();
	}
	
	return day;
}//End caloriesBurned method

public static int getValidNumAthletes(int numberOfAthletes, Scanner input) {
	do {
		
		System.out.println("Enter number of athletes: ");
		numberOfAthletes = input.nextInt();
		
		if(numberOfAthletes <= 0) {
			System.out.println("Error: value must be greater than 0");
		}
		
}   while (numberOfAthletes <= 0);	
	return numberOfAthletes;
}//End getValidNumAthletes

public static double getValidWeight(int weight, Scanner input) {
	do {
		
		System.out.println("Athlete's weight: ");
		weight = input.nextInt();
		
		if(weight <= 0) {
			System.out.println("Error: value must be greater than 0");
		}
	} while (weight <= 0);
	return weight;
}//End getValidWeight



}//End class