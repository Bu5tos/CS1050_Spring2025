import java.util.Scanner;
public class HardingFirstJavaProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.print("Hello Java");
        
        Scanner input = new Scanner(System.in);
        double weight = getValidDouble(input);
        System.out.println("You entered: " + weight);
	}

}

public static double getValidDouble(Scanner input) {
	
	double validNum = 0;
	
	while(validNum <= 0) {
		System.out.println("Enter postive number");
		if (input.hasNextDouble()) {
			validNum = input.nextDouble();
			if (validNum <= 0) {
				System.out.println("error try again");
			}

	}
		return validNum;
}
	
}