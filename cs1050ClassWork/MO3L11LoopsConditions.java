
public class MO3L11LoopsConditions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int max = 5;
	int total = sumOneToMax(max);
	System.out.println("Sum is: " + total);
	}

	
	public static void sumOneToMax(int max)
	{
		int total = 0;
		int counter = 0;
	
		for (int sum = 1; sum <= max; sum++)
		{
			counter = counter + 1;
			total = total + counter;
			System.out.println("Counter: " + counter);
			System.out.println("Total: " + total);
		}
			return total;
		}	
  }


