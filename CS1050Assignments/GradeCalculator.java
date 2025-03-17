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
	  int classParticipation = input.nextInt();
	  System.out.println("Guided exploration grade: ");
	  int guidedExploration = input.nextInt();
	  System.out.println("quizzes grade: ");
	  int quizzes = input.nextInt();
	  System.out.println("project grade: ");
	  int projectIteration = input.nextInt();
	  System.out.println("final exam grade: ");
	  int finalExam = input.nextInt();	  
	  
	  double finalGrade = (CLASS_WEIGHT * classParticipation) +
	                      (GUIDED_WEIGHT * guidedExploration) +
	                      (QUIZZES_WEIGHT * quizzes) +
	                      (PROJECT_WEIGHT * projectIteration) +
	                      (FINAL_WEIGHT * finalExam);
	 
	  
	  
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
	}
	  
	  // A method of getting valid grades within range 
	  public static double getValidGrade(int min, int max, Scanner inputKeyboard) {
	  
	  
      double grade;
      
      //Continues until the input is correct
      while(true) {
	      System.out.println("Enter a number between" + min + max + ":");
	      grade = inputKeyboard.nextDouble();
      
	      // Checks if the user inputs a number out of the range
	      if (grade < min && grade > max) {
          System.out.println("Invalid input. Enter a number between" + min + max + ":");
      } else {
    	  return grade; //Returns valid grades
      }
      }
      
      }//end main
}//end class
