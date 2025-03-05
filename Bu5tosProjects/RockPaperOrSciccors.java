import java.util.Scanner;

public class RockPaperOrSciccors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
        System.out.println("Insert name here, player one: ");
		String playerOne = input.next();
		System.out.println("Insert name here, player two: ");
		String playerTwo = input.next();
		
		System.out.println("Choose VERY carefully, " + playerOne + ". Rock(R), paper(P), or scissors(S): ");
		char category = input.next().charAt(0);
	}

}
