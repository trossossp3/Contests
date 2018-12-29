
public class test {
	public static void main(String[] args) {
		int n = (int) Math.pow(10, 5);
		int cases = 3;
		
		int[] ylist = new int[cases];
		for(int c = 0; c < cases; c++) {
			int m = 4;
			int b = 2;
			int count = 0;
			for(int x = 1; x < n+1; x++) {
				count += m*x+b;
			}
			ylist[c]=count;
		}
		System.out.println(ylist[0]);
	}

}
