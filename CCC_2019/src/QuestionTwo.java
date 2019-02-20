import java.util.Scanner;

public class QuestionTwo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int app = 0;
		app += in.nextInt() * 3;
		app += in.nextInt() * 2;
		app += in.nextInt() * 1;
		int ban = 0;
		ban += in.nextInt() * 3;
		ban += in.nextInt() * 2;
		ban += in.nextInt() * 1;

		if (ban > app) {
			System.out.println("B");
		} else if (app > ban) {
			System.out.println("A");
		} else {
			System.out.println("T");
		}
	}
}
