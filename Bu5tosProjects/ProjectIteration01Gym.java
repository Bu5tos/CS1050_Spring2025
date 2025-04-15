import java.util.Scanner;
public class ProjectIteration01Gym {
	
public static void main(String[] args) {
	
//User Story 1
	
	Scanner input = new Scanner(System.in);
	int numberOfAthletes = getValidData(0, input);
	int[] arrayOfAthletes = new int[numberOfAthletes];
	
	System.out.println("Athlete's weight: ");
	double weight = input.nextInt();
	System.out.println("Athlete's height(inches): ");
	double height = input.nextInt();
	System.out.println("Athlete's age: ");
	int age = input.nextInt();
	int[] dailyBurnedCalories = caloriesBurned(input);

}//End main

public static int[] caloriesBurned(Scanner input) {
	
	int[] day = new int[7];
	
	for(int index = 0; index < day.length; index++) {
			
		System.out.println("Enter Calories burned on day " + (index + 1) + ":");
		day[index] = input.nextInt();
	}
	
	return day;
}//End caloriesBurned method

public static int getValidData(int numberOfAthletes, Scanner input) {
	do {
		
		System.out.println("Enter number of athletes: ");
		numberOfAthletes = input.nextInt();
		
		if(numberOfAthletes <= 0) {
			System.out.println("Error: value must be greater than 0");
		}
		
}   while (numberOfAthletes <= 0);	
	return numberOfAthletes;
	
	
	
}//End getValidData
}//End class