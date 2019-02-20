import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		/*int app = 0;
		app+=in.nextInt()*3;
		app+=in.nextInt()*2;
		app+=in.nextInt()*1;
		int ban = 0;
		ban+=in.nextInt()*3;
		ban+=in.nextInt()*2;
		ban+=in.nextInt()*1;
		
		if(ban > app) {
			System.out.println("B");
		}else if(app > ban) {
			System.out.println("A");
		}else {
			System.out.println("T");
		}
		*/
		/*
		int n1 = in.nextInt();
		for(int i =0; i<n1;i++) {
			int temp = in.nextInt();
			String s1 = in.nextLine();
			for(int j = 0; j<temp;j++) {
				System.out.print(s1);
			}System.out.println();
			}
		
		*/
		/*
		int num = Integer.parseInt(in.nextLine());
		boolean flag = false;
		int count =0;
		for(int i =0; i<num;i++) {
			String s1 = in.nextLine();
			for(int j=0; j<s1.length()-1;j++){
				//System.out.println(s1.length());
				String temp1 =s1.substring(j,j+1);
				//String temp2 =s1.substring(j+1,j+2);
				if(s1.charAt(j)==s1.charAt(j+1)) {
					flag = false;
					count++;
				}else {
					flag = true;
					count++;
					System.out.print(count + " " + s1.substring(j,j+1)+" ");
					count =0;
				}
				
				
				
				
			}
			if(s1.length()>0) {
				count++;
				System.out.print(count + " " + s1.substring(s1.length()-1));
				count=0;
				System.out.println();
			}
			
				
		
		}
		*/
		
		int marks[][]={{1,2},{3,4}};
		String temp = in.nextLine();
		int length = temp.length();
		for(int i =0; i<length;i++) {
			if(temp.substring(i,i+1).equals("H")) {
				swapRows(marks,0,1);
			}else {
				swapColumns(marks);
			}
		}
		
		
		
		for(int[] row:marks) {
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
