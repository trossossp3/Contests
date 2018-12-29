import java.util.Scanner;

public class QuestionFive {
	public static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int n = (int) Math.pow(10, 5);
		int cases = Integer.parseInt(in.nextLine());
		long[] ylist = new long[n];
		
		for(int c = 0; c < cases; c++) {
			int m = in.nextInt();
			int b = in.nextInt();
			for(int x = 1; x <= n; x++) {
				ylist[c]+=(m*x+b);
			}
		}
		
		long maxCount = ylist[0];
		for(int i = 0; i < ylist.length; i++) {
			maxCount = (long) Math.max(maxCount, ylist[i]);
		}
		System.out.println(maxCount);
		
	}
	
}
