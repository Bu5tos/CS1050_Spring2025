/**
 * 
 */
package cs1050ClassWork;

/**
 * 
 */
public class UnitTestGym {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int[] arrayCalories = {100, 200, 400, 350, 273};
	
	int topAthlete = getTopAthlete(arrayCalories);
	System.out.println("Top athlete is " + topAthlete);
	
	}
		
	public static int getTopAthlete(int[] arrayCalories) {
	
	int largest = arrayCalories[0];
	
	for (int i = 1; i < arrayCalories.length; i++) {	
		if (arrayCalories[i] > largest)
		   largest = arrayCalories[i];	   
	}
	    return largest;
	}

}
