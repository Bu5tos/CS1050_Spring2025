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
	  if (finalGrade >= 90) 
		  System.out.println("Letter grade: " + 'A');
	  
	}
	  
	  public static double getValidGrade(int min, int max, Scanner inputKeyboard) {
	  
		
	  
	}//end main
}//end class
