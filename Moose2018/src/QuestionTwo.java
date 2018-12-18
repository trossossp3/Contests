import java.util.Scanner;

public class QuestionTwo {

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		int n = in.nextInt();
		int temp1 =0, temp2=0;
		int total =0;
		
		for(int i =0; i<n; i++) {
			temp1 = in.nextInt();
			temp2 = in.nextInt();
			total+=temp1*temp2;
		}
		System.out.println(total);
		
	}
}
