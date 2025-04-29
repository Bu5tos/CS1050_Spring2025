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
class athlete {
	
}

// Gym Class
