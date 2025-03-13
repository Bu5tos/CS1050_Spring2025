public class GradeCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	  final double CLASS_WEIGHT = .1;
	  final double GUIDED_WEIGHT = .2;
	  final double QUIZZES_WEIGHT = .25;
	  final double PROJECT_WEIGHT = .25;
	  final double FINAL_WEIGHT = .2;
	  
	  int classParticipation = 80;
	  int guidedExploration = 70;
	  int quizzes = 80;
	  int projectIteration = 74;
	  int finalExam = 82;
	  
	  double finalGrade = (CLASS_WEIGHT * classParticipation) +
	                      (GUIDED_WEIGHT * guidedExploration) +
	                      (QUIZZES_WEIGHT * quizzes) +
	                      (PROJECT_WEIGHT * projectIteration) +
	                      (FINAL_WEIGHT * finalExam);
	  
	  System.out.println(finalGrade);
	                      
	
	}//end main
}//end class
