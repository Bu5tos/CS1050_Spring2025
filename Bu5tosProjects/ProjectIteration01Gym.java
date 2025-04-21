import java.util.Scanner;
public class ProjectIteration01Gym {
	
public static void main(String[] args) {
	
	System.out.println("\n     Welcome to the Gym Athlete Fitness Tracker     \n");
	
	//Initialize Scanner for user to use keyboard
	Scanner input = new Scanner(System.in);
	
	System.out.println("Enter number of athletes: ");
	int numberOfAthletes = getValidIntegers(input);
	
	//Initialize arrays [] to store each athlete's data 
	double[] bmis = new double[numberOfAthletes];
	int[] maxHeartRates = new int[numberOfAthletes];
	double[] averageDailyCaloriesBurned = new double[numberOfAthletes];
	
	//Loop through each athlete to collect data
	for (int i = 0; i < numberOfAthletes; i++) {
		
		System.out.println(" ");
		System.out.println("Enter data for Athlete " + numberOfAthletes + ":");
		
		System.out.println("Enter athlete's weight (lbs): ");
		double weight = getValidDoubles(input);
		
		System.out.println("Athlete's height(inches): ");
		double height = getValidDoubles(input);
		
		System.out.println("Athlete's age: ");
		int age = getValidIntegers(input);
		
		//An array to store each athlete's daily burned calories in a week
		double[] caloriesPerDay = getDailyCalories(input);
	
		//Calculate and store athlete's data 
		maxHeartRates[i] = calculateMaxHeartRate(age);
		averageDailyCaloriesBurned[i] = Math.round(calculateAverageCaloriesBurned(caloriesPerDay));
		bmis[i] = Math.round(weight * 703 / (height * height));
	}//End for loop
	
	System.out.println("\n     Gym Weekly Fitness Summary     \n");
	
	//Display each athlete's fitness summary and category
	displayAthletesSummary(averageDailyCaloriesBurned, bmis, maxHeartRates);
	
	System.out.println("Top Athlete (Most Average Daily Calories Burned): Athlete " + findTopAthleteIndex(averageDailyCaloriesBurned));
}//End main

public static double[] getDailyCalories(Scanner scanKeyboard) {
	double[] caloriesPerday = new double[7]; //Initialize array to store daily calories for 7 days
	
	//Use for loop to collect calorie data from user for each day
	for(int index = 0; index < caloriesPerday.length; index++) {	
		System.out.println("Enter Calories burned on day " + (index + 1) + ":");
		caloriesPerday[index] = scanKeyboard.nextInt();
	}
	return caloriesPerday;
}//End getDailyCalories

public static int getValidIntegers(Scanner input) {
int validNumber = 0;
	
	while(validNumber <= 0) {
		if (input.hasNextInt()) {//Checks number if its an integer
			validNumber = input.nextInt();
			if (validNumber <= 0) { //Checks number if its positive
				System.out.println("Error: Value must be greater than 0");
			}
	}
}
	return validNumber;
}//End getValidIntegers

public static double getValidDoubles(Scanner input) {
double validNumber2 = 0;
	
	while(validNumber2 <= 0) {
		if (input.hasNextDouble()) {//Checks number if its a double
			validNumber2 = input.nextDouble();
			if (validNumber2 <= 0) {
				System.out.println("Error: Value must be greater than 0");
			}
	}	
}
	return validNumber2;
}//End getValidDouble

public static int calculateMaxHeartRate(int age) {
	final int MAX_HEART_RATE = 220; //Constant max heart rate
	int bpm = (MAX_HEART_RATE - age);
	return bpm;
}//End calculateMaxHeartRate

public static double calculateAverageCaloriesBurned(double dailyBurnedCalories[]) {
	double totalCalories = 0;
	double sum = 0;
	
	//Sum daily burned calories 
	for (int index = 0; index < dailyBurnedCalories.length; index++) {
		sum = 0 + dailyBurnedCalories[index];
		totalCalories = totalCalories + sum;
	}
	return totalCalories/7;
}//End calculateAverageCaloriesBurned

public static String getBMICategory(double bmi) {
	//Define range of categories
	final double MAX_UNDER_WEIGHT = 18.4;
	final double MIN_NORMAL = 18.5;
	final double MIN_OVER_WEIGHT = 25.0;
	final double MIN_OBESE = 40.0;
	
	String category = " ";
	
	//Determine BMI category
	if (bmi <= MAX_UNDER_WEIGHT){
		    category = "Underweight";
		}
		else if (bmi >= MIN_OBESE ){
			category = "Obese";
		}
		else if (bmi >= MIN_OVER_WEIGHT){
			category = "Overweight";
		}
		else if (bmi >= MIN_NORMAL){
			category = "Normal";
		}
	return category;
}//End getBMICategory

public static void displayAthletesSummary(double[] averageCalories, double[] bmi, int[] maxHeartRates) {
	int nextAthlete = 0; 
	
	//Use for loop to iterate through each athlete's data
    for (int i = 0; i < bmi.length; i++) {
    	//Print summary for each athlete #
    	nextAthlete = nextAthlete + 1;
    	System.out.println("Athlete " + nextAthlete);
	    System.out.println("        Max Heart Rate: " + maxHeartRates[i] + " bpm");
	    System.out.println("        Average Daily Calories Burned: " + averageCalories[i]);
	    System.out.println("        BMI: " + bmi[i] + "     Category: " + getBMICategory(bmi[i]));
	    System.out.println(" ");
    }
}//End displayAthletesSummary

public static int findTopAthleteIndex(double[] averageDailyCaloriesBurned) {
	double largestCalories = averageDailyCaloriesBurned[0];
	int topAthlete = 1;
	
	for (int i = 1; i < averageDailyCaloriesBurned.length; i++) {
		if (averageDailyCaloriesBurned[i] > largestCalories) {//
			largestCalories = averageDailyCaloriesBurned[i];
			topAthlete = i + 1;
	}
}
	return topAthlete;
}//End findTopAthleteIndex

}//End class