import java.util.Scanner;

public class GradeCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	  //Category percentages
	  final double CLASS_WEIGHT = .1;
	  final double GUIDED_WEIGHT = .2;
	  final double QUIZZES_WEIGHT = .25;
	  final double PROJECT_WEIGHT = .25;
	  final double FINAL_WEIGHT = .2;
	  
	  //Valid grade range
	  final int min = 0;
	  final int max = 105;
	  
	  //Use keyboard to enter integer numbers for grade
	  Scanner input = new Scanner(System.in); 
	  System.out.println("Class participation grade: ");
	  double classParticipation = getValidGrade(min, max, input);
	  System.out.println("Guided exploration grade: ");
	  double guidedExploration = getValidGrade(min, max, input);
	  System.out.println("quizzes grade: ");
	  double quizzes = getValidGrade(min, max, input);
	  System.out.println("project grade: ");
	  double projectIteration = getValidGrade(min, max, input);
	  System.out.println("final exam grade: ");
	  double finalExam = getValidGrade(min, max, input);	  
	  
	 
	  //Percentages * user's input grade will be firstly multiplied, then added in different categories
	  double finalGrade = (CLASS_WEIGHT * classParticipation) +
	                      (GUIDED_WEIGHT * guidedExploration) +
	                      (QUIZZES_WEIGHT * quizzes) +
	                      (PROJECT_WEIGHT * projectIteration) +
	                      (FINAL_WEIGHT * finalExam);
	  
	  //Overall grade
	  System.out.println("Final grade: " + finalGrade);
	  
	  //Final letter grade
	  char letterGrade;
	  if (finalGrade >= 90) {
		  System.out.println("Letter grade: " + 'A');
	  }
	  else if (finalGrade >= 80) {
		  System.out.println("Letter grade: " + 'B');
	  }
	  else if (finalGrade >= 70) {
		  System.out.println("Letter grade: " + 'C');
	  }
	  else if (finalGrade >= 60) {
		  System.out.println("Letter grade: " + 'D');
	  }
	  else if (finalGrade <= 59){
	      System.out.println("Letter grade: " + 'F');
	  }
	  System.out.println(" ");
	  System.out.println("Would you like to calculate another student's grade?");
	  System.out.println("Enter y for yes or n for no: ");
      char yOrn = input.next().charAt(0);
	}
	  
	  // A method of getting valid grades within range 
	  public static double getValidGrade(int min, int max, Scanner inputKeyboard) {
	  
      double grade;//Store user's input
      
      //Continues until the input is correct
      while(true) {
	      grade = inputKeyboard.nextDouble();
      
	      // Checks if the user inputs a number out of the range
	      if (grade < min && grade > max) {
          System.out.println("Invalid input. Enter a number between " + min + "-" + max + ":");
      } else {
    	  return grade; //Returns valid grades
      }
      }//end loop
      
      }//end main
}//end class
