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
		//gym1 instance is created
		Gym gym1 = new Gym("Gym Rats", MAX_GYM_MEMBERS);
		
		try
		{
			System.out.println("****** Gym Fitness Report ******\n");
			System.out.println("Gym: " + gym1.getGymName());
			
			/**
			 * Reads athletes file 
			 * Display athlete's info
			 * Save athlete's info to a different file
			 */
			readGymAthletesInfoFromFile("gym1.txt", gym1);
			gym1.displayAthleteSummaries();
			gym1.saveReportToFile();
			
		  //If file is not found, displays an error
		} catch (FileNotFoundException e)
		{
			System.out.println("Error: gym1.txt file not found.");
		}
		
		//gym2 is the second created gym instance 
		Gym gym2 = new Gym("Mystery Muscle gym", MAX_GYM_MEMBERS);

		try
		{
			System.out.println("\n****** Gym Fitness Report ******\n");
			System.out.println("Gym: " + gym2.getGymName());
			readGymAthletesInfoFromFile("gym2.txt", gym2);
			gym2.displayAthleteSummaries();
			gym2.saveReportToFile();
			
		} catch (FileNotFoundException e)
		{
			System.out.println("\nError: gym2.txt file not found.");
		}
		
	}//End main

	//Reads athlete information from a file and places it to the gym file
	public static void readGymAthletesInfoFromFile(String filename, Gym currentGym) throws FileNotFoundException
	{
		Scanner fileScanner = null;
		try
		{
			fileScanner = new Scanner(new File(filename));

			//Read from file
			while (fileScanner.hasNextLine()) {
				
				//Reads athlete's info
				String firstName = fileScanner.next().trim();//trim removes white space
                String lastName = fileScanner.next().trim();
                double weight = fileScanner.nextDouble();
                double height = fileScanner.nextDouble();
                int age = fileScanner.nextInt();
               
                int[] dailyBurnedCalories = new int[7];
                for(int i = 0; i < 7; i++) {
                	dailyBurnedCalories[i] = fileScanner.nextInt();
                }
                /**
                 * Create new athlete
                 * Add athlete to gym file 
                 */
                Athlete currentAthlete = new Athlete(firstName, lastName, weight, height, age, dailyBurnedCalories);
                currentGym.addAthlete (currentAthlete);
			}
		} finally
		{
			if (fileScanner != null)
			{
				fileScanner.close();//Always close fileScanner
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
	
	//Constructor
	public Athlete(String firstName, String lastName, double weight, double height, int age, int[] dailyCaloriesBurned) {
		//this. is current object's instance variables
		this.firstName = firstName;
		this.lastName = lastName;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.dailyCaloriesBurned = dailyCaloriesBurned;
	}
	
	/**
	 * Methods
	 */
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	//Calculates and returns BMI 
	public double calculateBMI() {
		double bmi = Math.round(weight * 703 / (height * height));
		return bmi;
	}
	
	//Calculates average calories burned over 7 days of the week
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
	
	//Calculates max heart rate and subtracting athlete's age 
	public int calculateMaxHeartRate() {
		final int MAX_HEART_RATE = 220; //Constant max heart rate
		int bpm = (MAX_HEART_RATE - age);
		return bpm;
	}//End calculateMaxHeartRate
	
	//Determines athlete's category based on bmi
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
	
public Gym(String name, int maxAthletes) {
	this.name = name;
	athletes = new Athlete[maxAthletes];
	numAthletes = 0;
}
	
public String getGymName() {
	return name;
}

//Adds athlete to the gym
public void addAthlete(Athlete athlete) {
	if (numAthletes < athletes.length) {
		athletes[numAthletes] = athlete;
		numAthletes++;//Increment athlete to it's index
	//If no space in numAthletes, not added
	} else {
		System.out.println("Gym is full. Can't add " + athlete.getFirstName() + " " + athlete.getLastName());
	}
}//End addAthlete

/**
 *Displays summary for each athlete's data
 *Identify who is top athlete
 *Identify which athlete is underweight
 */
public void displayAthleteSummaries() {
	for (int i = 0; i < numAthletes; i++) {
			
		//
		Athlete athlete = athletes[i];
			
		//Print summary for each athlete #
		System.out.println("Athlete: " + athlete.getFirstName() + " " + athlete.getLastName());
		System.out.println("        Max Heart Rate: " + athlete.calculateMaxHeartRate() + " bpm");
	    System.out.println("        Average Daily Calories Burned: " + Math.round(athlete.getAverageCaloriesBurned()));
	    System.out.println("        BMI: " + athlete.calculateBMI() + "     Category: " + athlete.getBMICategory());
	}
	System.out.println(" ");
	findTopAthlete();
    displayUnderweightAthletes();
}//End displayAthleteSummaries

//Save athlete's report to Report.txt file
public void saveReportToFile() {
	String fileName = "Report.txt";
	try (PrintWriter writer = new PrintWriter(fileName)){

		for (int i = 0; i < numAthletes; i++ ) {
			Athlete thisAthlete = athletes[i];
			writer.println("        Athlete: " + thisAthlete.getFirstName() + " " + thisAthlete.getLastName());
			writer.println("        Max Heart Rate: " + thisAthlete.calculateMaxHeartRate() + " bpm");
		    writer.println("        Average Daily Calories Burned: " + Math.round(thisAthlete.getAverageCaloriesBurned()));
		    writer.println("        BMI: " + thisAthlete.calculateBMI() + "     Category: " + thisAthlete.getBMICategory());
		}
		  System.out.println("Report saved to: " + fileName);
	} catch (FileNotFoundException e)
	{
		System.out.println("\nError: " + fileName + " file not found.");
	}
}//End saveReportFile

//Identify athlete with the highest average calories burn
private void findTopAthlete() {
	double largestCalories = athletes[0].getAverageCaloriesBurned();
	int topAthlete = 0;
	
	//For loop to go through all the athletes in the array
	for (int i = 1; i < numAthletes; i++) {
		if (athletes[i].getAverageCaloriesBurned() > largestCalories) {
			largestCalories = athletes[i].getAverageCaloriesBurned();
			topAthlete = i;
	}
}
		 System.out.println("Top Athlete: " + athletes[topAthlete].getFirstName() + " " + athletes[topAthlete].getLastName());
}//End findTopAthlete

//Identify the lowest calories burn athlete
private void displayUnderweightAthletes() {
	double lowestCalories = athletes[0].getAverageCaloriesBurned();
	int underweightAthlete = 0;
	boolean underweight = true;
		
	for (int i = 1; i < numAthletes; i++) {
		if (athletes[i].getAverageCaloriesBurned() < lowestCalories) {
			lowestCalories = athletes[i].getAverageCaloriesBurned();
			underweightAthlete = i;
			underweight = false;
		}
		else if (lowestCalories != athletes[i].getAverageCaloriesBurned()){
			underweight = true;
		}
		else {
			System.out.println("No underweight Athlete");
		}
			}
	  System.out.println("Underweight Athlete: " + athletes[underweightAthlete].getFirstName() + " " + athletes[underweightAthlete].getLastName());
	
}//End displayUnderweightAthletes
	
}//End Gym Class 