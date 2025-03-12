

public class RockPaperOrSciccors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	int oddNumbers = 0;
	int counter = 0;
	
	for (int sum = 0; sum < 5; sum++) {
	
		counter = counter + 1;
		oddNumbers = oddNumbers + counter;
		
		System.out.println("Total odd number is: " + (oddNumbers / 2));
		
	}
  }
}
