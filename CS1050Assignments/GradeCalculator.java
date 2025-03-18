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
	  
	//Use keyboard to enter integer numbers for grade
	  Scanner input = new Scanner(System.in);
	  char anotherGrade;
	  
	  do {
	  //Valid grade range
	  final int min = 0;
	  final int max = 105;
	  
	  //Valid grade numbers 
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
		  letterGrade = 'A';
		  System.out.println("Letter grade: " + letterGrade);
	  }
	  else if (finalGrade >= 80) {
		  letterGrade = 'B';
		  System.out.println("Letter grade: " + letterGrade);
	  }
	  else if (finalGrade >= 70) {
		  letterGrade = 'C';
		  System.out.println("Letter grade: " + letterGrade);
	  }
	  else if (finalGrade >= 60) {
		  letterGrade = 'D';
		  System.out.println("Letter grade: " + letterGrade);
	  }
	  else if (finalGrade <= 59){
		  letterGrade = 'F';
	      System.out.println("Letter grade: " + letterGrade);
	  }
	     
	
	  System.out.println(" ");
	  System.out.println("Would you like to calculate another student's grade?");
	  System.out.println("Enter y for yes or n for no: ");
	  anotherGrade = input.next().charAt(0);
	  
	  } while(anotherGrade == 'y');
	    System.out.println("Goodbye");
	    
	    
	}
	
	  // A method of getting valid grades within range 
	  public static double getValidGrade(int min, int max, Scanner inputKeyboard) {
	  
		  double currentGrade = inputKeyboard.nextDouble();
		  
      while(currentGrade < min || currentGrade > max) {
    	  System.out.println("Invalid input. Choose between " + min + "-" + max);
    	  currentGrade = inputKeyboard.nextDouble();
    	  
      }
            return currentGrade; 
}
}
