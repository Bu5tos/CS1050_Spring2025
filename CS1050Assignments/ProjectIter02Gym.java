import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//Main class
public class ProjectIter02Gym
{
	public static void main(String[] args)
	{
		final int MAX_GYM_MEMBERS = 3;
		
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

			//Read from file
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();// Read the full line
                System.out.println(line);
				
				String firstName = fileScanner.next().trim();
                String lastName = fileScanner.next().trim();
                double weight = fileScanner.nextDouble();
                double height = fileScanner.nextDouble();
                int age = fileScanner.nextInt();
                Athlete currentAthlete = new Athlete(firstName, lastName, weight, height, age);
                currentGym.addAthlete (currentAthlete);
			}
		} finally
		{
			if (fileScanner != null)
			{
				fileScanner.close();
			}
		}
	}// end add athletes

}//End Class



// Athlete class
class Athlete {
	
	//Instance variables
	private String firstName;
	private String lastName;
	private double weight;
	private double height;
	private int age;
	private int[] dailyCaloriesBurned;
	
	//Constructors 
	public Athlete(String firstName, String lastName, double weight, double height, int age, int[] dailyCaloriesBurned) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.dailyCaloriesBurned = dailyCaloriesBurned;
	}
	
	//Methods
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public double calculateBMI() {
		double bmi = Math.round(weight * 703 / (height * height));
		return bmi;
	}
	
	public double getAverageCaloriesBurned() {
		double totalCalories = 0;
		double sum = 0;
		
		//Sum daily burned calories 
		for (int index = 0; index < dailyCaloriesBurned.length; index++) {
			sum = 0 + dailyCaloriesBurned[index];
			totalCalories = totalCalories + sum;
		}
		return totalCalories/7;
	}//getAverageCaloriesBurned
	
	public int calculateMaxHeartRate() {
		final int MAX_HEART_RATE = 220; //Constant max heart rate
		int bpm = (MAX_HEART_RATE - age);
		return bpm;
	}//End calculateMaxHeartRate
	
	public String getBMICategory() {
		final double MAX_UNDER_WEIGHT = 18.4;
		final double MIN_NORMAL = 18.5;
		final double MIN_OVER_WEIGHT = 25.0;
		final double MIN_OBESE = 40.0;
		
		String category = " ";
		double bmi = calculateBMI();
		
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
	
}//End Athlete Class

// Gym Class
class Gym {
	
	private String name;
	private Athlete[] athletes;
	private int numAthletes;
	
	public Gym(String name, Athlete[] athletes, int numAthletes) {
		this.name = name;
		this.athletes = athletes;
		this.numAthletes = numAthletes;
	}
	
	public String getGymName() {
		return name;
	}
	
	//public void saveReportToFile()
	
	public void addAthlete(Athlete athlete) {
		if (numAthletes < athletes.length) {
			athletes[numAthletes] = athlete;
			numAthletes++;
		} else {
			System.out.println("Gym is full. ");
		}
	}//End addAthlete
		
	public void displayAthleteSummaries() {
		
	}
		
	private void findTopAthlete() {
		double largestCalories = athletes[0].getAverageCaloriesBurned();
		int topAthlete = 1;
		
		for (int i = 1; i < numAthletes; i++) {
			if (athletes[i].getAverageCaloriesBurned() > largestCalories) {
				largestCalories = athletes[i].getAverageCaloriesBurned();
				topAthlete = i + 1;
		}
	}
			 System.out.println("Top Athlete: " + athletes[topAthlete]);
	}//End findTopAthlete
		
	private void displayUnderweightAthletes() {
		double lowestCalories = athletes[0].getAverageCaloriesBurned();
		int underweightAthlete = 1;
		boolean underweight = true;
		
		for (int i = 1; i < numAthletes; i++) {
			if (athletes[i].getAverageCaloriesBurned() < lowestCalories) {
				lowestCalories = athletes[i].getAverageCaloriesBurned();
				underweightAthlete = i + 1;
				underweight = false;
			}
			else if (lowestCalories != athletes[i].getAverageCaloriesBurned()){
				underweight = true;
			}
			else {
				System.out.println("No underweight Athlete");
			}
				}
			 System.out.println("Underweight Athlete: " + athletes[underweightAthlete]);
	}//End displayUnderweightAthletes
	
}//End Gym Class 