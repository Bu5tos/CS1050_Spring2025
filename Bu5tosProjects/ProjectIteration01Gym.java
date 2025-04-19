import java.util.Scanner;
public class ProjectIteration01Gym {
	
public static void main(String[] args) {
	
	System.out.println("     Welcome to the Gym Athlete Fitness Tracker     ");
	System.out.println(" ");
	Scanner input = new Scanner(System.in);
	System.out.println("Enter number of athletes: ");
	int numberOfAthletes = getValidIntegers(input);
	double[] bmis = new double[numberOfAthletes];
	int[] maxHeartRates = new int[numberOfAthletes];
	double[] averageDailyCaloriesBurned = new double[numberOfAthletes];
	
	for (int i = 0; i < numberOfAthletes; i++) {
		
		System.out.println(" ");
		System.out.println("Enter data for Athlete " + numberOfAthletes + ":");
		System.out.println("Enter athlete's weight (lbs): ");
		double weight = getValidDoubles(input);
		System.out.println("Athlete's height(inches): ");
		double height = getValidDoubles(input);
		System.out.println("Athlete's age: ");
		int age = getValidIntegers(input);
		double[] caloriesPerDay = getDailyCalories(input);
	
		maxHeartRates[i] = calculateMaxHeartRate(age);
		averageDailyCaloriesBurned[i] = Math.round(calculateAverageCaloriesBurned(caloriesPerDay));
		bmis[i] = Math.round(weight * 703 / (height * height));
	}
	
	System.out.println(" ");
	System.out.println("     Gym Weekly Fitness Summary     ");
	System.out.println(" ");
	
	displayAthletesSummary(averageDailyCaloriesBurned, bmis, maxHeartRates);
	
	System.out.println("Top Athlete (Most Average Daily Calories Burned): " + findTopAthleteIndex(averageDailyCaloriesBurned));
	
}//End main

public static double[] getDailyCalories(Scanner scanKeyboard) {
	
	double[] caloriesPerday = new double[7];
	
	for(int index = 0; index < caloriesPerday.length; index++) {
			
		System.out.println("Enter Calories burned on day " + (index + 1) + ":");
		caloriesPerday[index] = scanKeyboard.nextInt();
	}
	
	return caloriesPerday;
}//End getDailyCalories

public static int getValidIntegers(Scanner input) {
int validNumber = 0;
	
	while(validNumber <= 0) {
		if (input.hasNextDouble()) {
			validNumber = input.nextInt();
			if (validNumber <= 0) {
				System.out.println("Error: Value must be greater than 0");
			}
	}	
}
	return validNumber;
}//End getValidIntegers

public static double getValidDoubles(Scanner input) {
double validNumber2 = 0;
	
	while(validNumber2 <= 0) {
		if (input.hasNextDouble()) {
			validNumber2 = input.nextDouble();
			if (validNumber2 <= 0) {
				System.out.println("Error: Value must be greater than 0");
			}
	}	
}
	return validNumber2;
}//End getValidDouble

public static int calculateMaxHeartRate(int age) {
	int maxHeartRate = 220;
	int bpm = (maxHeartRate - age);
	return bpm;
}//End calculateMaxHeartRate

public static double calculateAverageCaloriesBurned(double dailyBurnedCalories[]) {
	double totalCalories = 0;
	double sum = 0;
	
	for (int index = 0; index < dailyBurnedCalories.length; index++) {
		sum = 0 + dailyBurnedCalories[index];
		totalCalories = totalCalories + sum;
	}
	return totalCalories/7;
}//End calculateAverageCaloriesBurned

public static String getBMICategory(double bmi) {
	double MAX_UNDER_WEIGHT = 18.4;
	double MIN_NORMAL = 18.5;
	double MIN_OVER_WEIGHT = 25.0;
	double MIN_OBESE = 40.0;
	
	String category = "?";
	
	if (bmi <= MAX_UNDER_WEIGHT){
		    category = "underweight";
		}
		else if (bmi >= MIN_OBESE ){
			category = "obese";
		}
		else if (bmi >= MIN_OVER_WEIGHT){
			category = "overweight";
		}
		else if (bmi >= MIN_NORMAL){
			category = "Normal";
		}
	return category;
}//End getBMICategory

public static void displayAthletesSummary(double[] averageCalories, double[] bmi, int[] maxHeartRates) {
	int nextAthlete = 0;
    for (int i = 0; i < bmi.length; i++) {
    	nextAthlete = nextAthlete + 1;
    	System.out.println("Athlete " + nextAthlete);
	    System.out.println("        Max Heart Rate: " + maxHeartRates[i] + " bpm");
	    System.out.println("        Average Daily Calories Burned: " + averageCalories[i]);
	    System.out.println("        BMI: " + bmi[i] + "     Category: " + getBMICategory(bmi[i]));
	    System.out.println(" ");
    }
}//End displayAthletesSummary

public static double findTopAthleteIndex(double[] averageDailyCaloriesBurned) {
	double largestCalories = averageDailyCaloriesBurned[0];
	
	for (int i = 1; i < averageDailyCaloriesBurned.length; i++) {
		if (averageDailyCaloriesBurned[i] > largestCalories) {
			largestCalories = averageDailyCaloriesBurned[i];
	}
}
	return largestCalories;
}//End findTopAthleteIndex

}//End class