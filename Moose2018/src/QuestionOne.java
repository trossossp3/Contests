import java.util.Scanner;

public class QuestionOne{

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		int n = in.nextInt();
		in.nextLine();
		for(int i = 0; i < n; i++) {
			String fighter = in.nextLine();
			int power = Integer.parseInt(fighter.substring(fighter.indexOf(" ")+1));
			if(power > 9001) System.out.println(fighter.substring(0, fighter.indexOf(" ")));
		}
	}

	

}
