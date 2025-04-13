
public class MO4PassArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] numbersArray = new int [10];
		int number = 5;
		
		updateRandomValue(numbersArray, number);
		
		System.out.println(number + ", this number was passed");
		
	}

	public static void updateRandomValue(int passedArray[], int passedNumber) {
		
		passedNumber = (int) (Math.random() * 10);
		
		for (int i = 0; i < passedArray.length; i++) {
			passedArray[i] = (int) (Math.random() * 10);
		
	}
		
	}
	
	public static void displayArrayValue(int[] array) {
		
		
		
	}
}
