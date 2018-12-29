package question.four;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class QuestionFour {
    private static QuestionFour o = new QuestionFour();
    
    public static class Reader {
    	
        private BufferedReader in;
        private StringTokenizer st;

        public Reader(InputStream inputStream) {
        	in = new BufferedReader(new InputStreamReader(inputStream));
        }

        public Reader(String fileName) throws FileNotFoundException {
        	in = new BufferedReader(new FileReader(fileName));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(in.readLine().trim());
            }
            return st.nextToken();
        }

        public String next(String delim) throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(in.readLine().trim());
            }
            return st.nextToken(delim);
        }
        
        public String nextLine() throws IOException {
            st = null;
            return in.readLine();
        }

        // public BigInteger nextBigInteger() throws IOException { return new BigInteger(next()); }

        public byte nextByte() throws IOException { return Byte.parseByte(next()); }
        public byte nextByte(String delim) throws IOException { return Byte.parseByte(next(delim)); }
        public char nextChar() throws IOException { return next().charAt(0); }
        public char nextChar(String delim) throws IOException { return next(delim).charAt(0); }
        public double nextDouble() throws IOException { return Double.parseDouble(next()); }
        public double nextDouble(String delim) throws IOException { return Double.parseDouble(next(delim)); }
        public float nextFloat() throws IOException { return Float.parseFloat(next()); }
        public float nextFloat(String delim) throws IOException { return Float.parseFloat(next(delim)); }
        public int nextInt() throws IOException { return Integer.parseInt(next()); }
        public int nextInt(String delim) throws IOException { return Integer.parseInt(next(delim)); }
        public long nextLong() throws IOException { return Long.parseLong(next()); }
        public long nextLong(String delim) throws IOException { return Long.parseLong(next(delim)); }
        public short nextShort() throws IOException { return Short.parseShort(next()); }
        public short nextShort(String delim) throws IOException { return Short.parseShort(next(delim)); }
    } // Reader class
    
    private static Reader in;
    private static PrintWriter out;
    
    private static final int NUM_OF_TEST_CASES = 10; // TODO CHANGE NUMBER OF TEST CASES
    
    // TODO CHANGE FILE NAMES
    private static final String INPUT_FILE_NAME = "src\\question\\four\\DATA41.txt";
    private static final String OUTPUT_FILE_NAME = "output.txt";
    
    private static boolean stdIn = false;
    private static boolean stdOut = false;
    
    public static void main(String[] args) throws IOException {
        if (!stdIn || !stdOut) {
            try {
                String packageName = o.getClass().getPackage().toString().split(" ")[1] + "/";
            } catch (NullPointerException e) {}
        }
        if (stdIn) in = new Reader(System.in);
        else in = new Reader(INPUT_FILE_NAME);
        if (stdOut) out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        else out = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME)));
        
        for (int i = 1; i <= NUM_OF_TEST_CASES; i++) {
            run(i);
            out.flush();
        }
        out.close();
    }
    
    public static void run(int testCaseNum) throws IOException {
    	
    	Box b2 = new Box(0,-1,1,0, 1);
    	Box b1 = new Box(-1,0,0,-1, 1);
    	int x = in.nextInt();
    	int y = in.nextInt();
    	
    	Box.direction = 1;
    	
    	if (b2.checkPoint(x, y)) {
    		System.out.println("1");
    		return;
    	}
    	Box.direction = 2;
    	if (b1.checkPoint(x, y)) {
    		System.out.println("2");
    		return;
    	}
    	
    	Box.direction = 3;
    	
    	Box.index = 2;
    	
    	boolean poppy = true;
    	
    	while (poppy) {
    		Box temp1 = b1;
    		Box temp2 = b2;
    		b1 = Box.addBox(temp1, temp2);
    		b2 = temp1;
    		Box.index++;
    		if (b1.checkPoint(x,y)) {
    			poppy = false;
    		}
    		
    		Box.nextDirection();
    	}
    	
    	System.out.println(Box.index);  	
    	
    }
    
    
}


class Box {
	public int x1;
	public int y1;
	public int x2;
	public int y2;
	public int size;
	public static int direction = 3;
	public static int index = 1;
	
	public Box(int x1, int y1, int x2, int y2, int size) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.size = size;
	}
	
	public static Box addBox(Box b1, Box b2) {
		int sIze = b1.size + b2.size;
		if (direction == 1) {
			return new Box(b1.x1 - sIze, b1.y1 - sIze, b1.x1, b1.y1, sIze);
		} else if (direction == 2) {
			return new Box(b1.x1 - sIze, b1.y1 + sIze, b1.x1, b1.y1, sIze);
		} else if (direction == 3) {
			return new Box(b1.x1 + sIze, b1.y1 + sIze, b1.x1, b1.y1, sIze);
		} else {
			return new Box(b1.x1 + sIze, b1.y1 - sIze, b1.x1, b1.y1, sIze);
		}
	}
	
	public boolean checkPoint(int x, int y) {
		if (direction == 1) {
			return (x >= x1 && x <= x2 && y >= y1 && y <= y2);
		}
		if (direction == 2) {
			return (x >= x1 && x <= x2 && y <= y1 && y >= y2);
		}
		if (direction == 3) {
			return (x <= x1 && x >= x2 && y <= y1 && y >= y2);
		}
		if (direction == 4) {
			return (x <= x1 && x >= x2 && y >= y1 && y <= y2);
		}
		return false;
	}
	
	public static void nextDirection() {
		direction++;
		if (Box.direction > 4) {
			Box.direction = 1;
		}
	}
}
