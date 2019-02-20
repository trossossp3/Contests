import java.util.Scanner;
public class QuestionThree {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = Integer.parseInt(in.nextLine());
		boolean flag = false;
		int count = 0;
		for (int i = 0; i < num; i++) {
			String s1 = in.nextLine();
			for (int j = 0; j < s1.length() - 1; j++) {
				// System.out.println(s1.length());
				String temp1 = s1.substring(j, j + 1);
				// String temp2 =s1.substring(j+1,j+2);
				if (s1.charAt(j) == s1.charAt(j + 1)) {
					flag = false;
					count++;
				} else {
					flag = true;
					count++;
					System.out.print(count + " " + s1.substring(j, j + 1) + " ");
					count = 0;
				}

			}
			if (s1.length() > 0) {
				count++;
				System.out.print(count + " " + s1.substring(s1.length() - 1));
				count = 0;
				System.out.println();
			}

		}
	}
}
