import java.util.Arrays;
import java.util.Scanner;

public class QuestionFour{

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int n = in.nextInt();
		in.nextLine();
		int[] packets = new int[n];
		for(int i = 0; i < n; i++) {		
			packets[i] = in.nextInt();
		}
		int maxCount = 0;
		for(int i = 0; i <= n/2; i++) {
			int count = 0;
			for(int j = 0; j < n; j+=2) {
				count+=packets[j];
				if(j==(i*2)) {
					try {
						count+=packets[j+1];
						j++;
					} catch(Exception ex) {
						//Error
					}
				}
			}
			maxCount = Math.max(count, maxCount);
		}
		System.out.println(maxCount);
	}

}
