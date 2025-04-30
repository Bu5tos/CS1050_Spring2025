import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//Main class
public class ProjectIter02Gym
{
	public static void main(String[] args)
	{
		int MAX_GYM_MEMBERS = 3;
		
		Gym gym1 = new Gym("Elite Fitness", MAX_GYM_MEMBERS);

		try
		{
			readGymAthletesInfoFromFile("gym1.txt", gym1);
			gym1.displayAthleteSummaries();
			gym1.saveReportToFile();
			
		} catch (FileNotFoundException e)
		{
			System.out.println("Error: File not found.");
		}
		
		Gym gym2 = new Gym("Work in Progress", MAX_GYM_MEMBERS);

		try
		{
			readGymAthletesInfoFromFile("gym2.txt", gym2);
			gym2.displayAthleteSummaries();
			gym2.saveReportToFile();
			
		} catch (FileNotFoundException e)
		{
			System.out.println("Error: File not found.");
		}

	}//End main

	/**
	 * 
	 */
	public static void readGymAthletesInfoFromFile(String filename, Gym currentGym) throws FileNotFoundException
	{
		
		
		Scanner fileScanner = null;
		try
		{

			fileScanner = new Scanner(new File(filename));

			//Add code to read from file


		} finally
		{
			if (fileScanner != null)
			{
				fileScanner.close();
			}
		}
	}// end add athletes

} //End Class



// Athlete class
class Athlete {
	
	//Instance variables
	private String firstName;
	private String lastName;
	private double weight;
	private double height;
	private int age;
	private int[] dailyCaloriesBurned;
	
	public Athlete(String firstName, String lastName, double weight, double height, int age, int[] dailyCaloriesBurned) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.dailyCaloriesBurned = dailyCaloriesBurned;
	}
	
	public String getFirstName() {
		
	}
	
	public String getLastName() {
		
	}
	
	public double getAverageCaloriesBurned(double dailyBurnedCalories[]) {
		double totalCalories = 0;
		double sum = 0;
		
		//Sum daily burned calories 
		for (int index = 0; index < dailyBurnedCalories.length; index++) {
			sum = 0 + dailyBurnedCalories[index];
			totalCalories = totalCalories + sum;
		}
		return totalCalories/7;
	}//getAverageCaloriesBurned
	
	public int calculateMaxHeartRate(int age) {
		final int MAX_HEART_RATE = 220; //Constant max heart rate
		int bpm = (MAX_HEART_RATE - age);
		return bpm;
	}//End calculateMaxHeartRate
	
	public double calculateBMI(double weight, double height) {
		double bmi = Math.round(weight * 703 / (height * height));
		return bmi;
	}
	
	public String getBMICategory(double bmi) {
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
	}//End calculateBMI
	
}//End class Athlete

// Gym Class
