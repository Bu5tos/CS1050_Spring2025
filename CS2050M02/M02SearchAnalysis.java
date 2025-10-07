/*/**
 * 
 */

public class M02SearchAnalysis
{

	public static void main(String[] args)
	{
		// Array sizes to test
		int[] sizes =
		{ 1, 10, 100, 1000, 10000 };

		/**
		 * Enhanced for loop (for-each loop)
		 * 
		 *
		 */
		for (int n : sizes) 
		{
			// Build a sorted array [1, 2, 3, ..., n]
			int[] data = new int[n];
			for (int i = 0; i < n; i++)
			{
				data[i] = i + 1;
			}

			System.out.println("\n=== Array size " + n + " ===");

			// Pick keys for test cases
			int firstKey = data[0]; // first element
			int middleKey = data[n / 2]; // middle element
			int lastKey = data[n - 1]; // last element
			int absentKey = n + 10; // guaranteed not present

			// Run Linear Search
			System.out.println("-- Linear Search --");
			linearSearch(data, firstKey);
			linearSearch(data, middleKey);
			linearSearch(data, lastKey);
			linearSearch(data, absentKey);

		}
	}

	// ---------- Linear Search with comparison counting ----------
	public static int linearSearch(int[] data, int key)
	{

		return -1;
	}

	// ---------- Binary Search with comparison counting ----------
	public static int binarySearch(int[] data, int key)
	{

		return -1;
	}

}
