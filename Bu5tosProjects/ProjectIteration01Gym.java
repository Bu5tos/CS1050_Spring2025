import java.util.Scanner;
public class ProjectIteration01Gym {
	
public static void main(String[] args) {
	
	System.out.println("     Welcome to the Gym Athlete Fitness Tracker     ");
	System.out.println(" ");
	Scanner input = new Scanner(System.in);
	int numberOfAthletes = getValidNumAthletes(0, input);
	double[] bmis = new double[numberOfAthletes];
	int[] maxHeartRates = new int[numberOfAthletes];
	double[] averageDailyCaloriesBurned = new double[numberOfAthletes];
	
	for (int i = 0; i < numberOfAthletes; i++) {
		
		System.out.println(" ");
		double weight = getValidDoubles(input);
		System.out.println("Athlete's height(inches): ");
		double height = input.nextDouble();
		System.out.println("Athlete's age: ");
		int age = input.nextInt();
		double[] caloriesPerDay = getDailyCalories(input);
	
		maxHeartRates[i] = calculateMaxHeartRate(age);
		averageDailyCaloriesBurned[i] = Math.round(calculateAverageCaloriesBurned(caloriesPerDay));
		bmis[i] = Math.round(weight * 703 / (height * height));
	}
	
	System.out.println(" ");
	System.out.println("     Gym Weekly Fitness Summary     ");
	System.out.println(" ");
	
	displayAthletesSummary(averageDailyCaloriesBurned, bmis, maxHeartRates);
	
}//End main

public static double[] getDailyCalories(Scanner scanKeyboard) {
	
	double[] caloriesPerday = new double[7];
	
	for(int index = 0; index < caloriesPerday.length; index++) {
			
		System.out.println("Enter Calories burned on day " + (index + 1) + ":");
		caloriesPerday[index] = scanKeyboard.nextInt();
	}
	
	return caloriesPerday;
}//End getDailyCalories

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

public static double getValidDoubles(Scanner input) {
double validNum = 0;
	
	while(validNum <= 0) {
		System.out.println("Enter athlete's weight (lbs): ");
		if (input.hasNextDouble()) {
			validNum = input.nextDouble();
			if (validNum <= 0) {
				System.out.println("Error: Value must be greater than 0");
			}

	}
		
}
	return validNum;
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
}//End bmiCategory

public static void displayAthletesSummary(double[] averageCalories, double[] bmi, int[] maxHeartRates) {
    for (int i = 0; i < bmi.length; i++) {
	System.out.println("Max Heart Rate: " + maxHeartRates[i] + " bpm");
	System.out.println("Average Daily Calories Burned: " + averageCalories[i]);
	System.out.println("BMI: " + bmi[i] + "     Category: " + getBMICategory(bmi[i]));
    }
}//End displayAthletesSummary

}//End class