import java.util.Scanner;
public class ProjectIteration01Gym {
	
public static void main(String[] args) {
	
//User Story 1
	
	Scanner input = new Scanner(System.in);
	System.out.println("Enter number of athletes: ");
	final int NUMBER_OF_ATHLETES = input.nextInt();
	
	int[] arrayOfAthletes = new int[NUMBER_OF_ATHLETES];
	
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
}

}//End class