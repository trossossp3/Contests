import java.util.Scanner;

public class QuestionFour {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int marks[][] = { { 1, 2 }, { 3, 4 } };
		String temp = in.nextLine();
		int length = temp.length();
		for (int i = 0; i < length; i++) {
			if (temp.substring(i, i + 1).equals("H")) {
				swapRows(marks, 0, 1);
			} else {
				swapColumns(marks);
			}
		}

		for (int[] row : marks) {
			System.out.println(row[0] + " " + row[1]);
		}
	}

	public static void swapRows(int array[][], int rowA, int rowB) {
		int tmpRow[] = array[rowA];
		array[rowA] = array[rowB];
		array[rowB] = tmpRow;
	}

	public static void swapColumns(int array[][]) {
		int topLeft = array[0][0];
		int topRight = array[0][1];
		int bottomLeft = array[1][0];
		int bottomRight = array[1][1];

		int temp = topLeft;
		topLeft = topRight;
		topRight = temp;

		temp = bottomLeft;
		bottomLeft = bottomRight;
		bottomRight = temp;

		array[0][0] = topLeft;
		array[0][1] = topRight;
		array[1][0] = bottomLeft;
		array[1][1] = bottomRight;

	}

}
