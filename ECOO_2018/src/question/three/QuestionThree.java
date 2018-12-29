package question.three;

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

public class QuestionThree {
    private static QuestionThree o = new QuestionThree();
    
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
    private static final String INPUT_FILE_NAME = "src\\question\\three\\DATA32.txt";
    private static final String OUTPUT_FILE_NAME = "output.txt";
    
    private static boolean stdIn = false;
    private static boolean stdOut = false;
    
    public static void main(String[] args) throws IOException {
        String packageName = "";
        if (!stdIn || !stdOut) {
            try {
                packageName = o.getClass().getPackage().toString().split(" ")[1] + "/";
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
    	int N = in.nextInt();
    	int X = in.nextInt();
    	int Y = in.nextInt();
    	int Z = in.nextInt();
    	
    	int count = 0;
    	int[] result = new int[N];
    	
    	String[] numbers = new String[N];
    	for (int i = 0; i < N; i++) {
    		numbers[i] = in.nextLine();
    	}
    	
    	in.nextLine();
    	
    	String[] answers = new String[N];
    	for (int i = 0; i < N; i++) {
    		answers[i] = in.nextLine();
    	}
    	
    	int[] indeces = new int[N];
    	
    	for (int i = 0; i < N; i++) {
    		String[] array = new String[numbers[i].length()];
    		
    		for (int j = 0; j < numbers[i].length(); j++) {
    			array[j] = numbers[i].charAt(j) + "";
    		}
    		
    		for (int j = 0; j < array.length; j++) {
    			if (array[j].equals("0"))
    				array[j] = Integer.toString(Z);
    			else if (Integer.parseInt(array[j]) % 2 == 0)   				
    				array[j] = Integer.parseInt(array[j]) + X + "";
    			else if (Integer.parseInt(array[j]) % 2 == 1) {
    				array[j] = Integer.parseInt(array[j]) - Y + "";
    				if (Integer.parseInt(array[j]) < 0) {
    					array[j] = "0";
    				}
    			}
    		}
    	   
    		String answer = "";
    		for (String j : array) {
    			answer += j;
    		}
    		numbers[i] = answer;    
    	}
    	
    	boolean wasFalse = false;
    	
    	int counting = 0;
    	
    	int pop = 0;
    	
    	for (int j = 0; j < N; j++) {
			if (!numbers[j].equals(answers[j])) {
				wasFalse = true;
				indeces[pop] = j + 1;
				counting++;
				pop++;
			}
		}
    	
    	in.nextLine();
    	
    	if (wasFalse) {
    		System.out.print("FAIL: " + indeces[0]);
    		for (int i = 1; i < counting; i++) {
    			System.out.print(", " + indeces[i]);
    		}
    		System.out.println("");
    	} else {
    		System.out.println("MATCH");
    	}
    	
    	
    }
}