import java.util.Scanner;

public class QuestionThree{

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		String sentence = in.nextLine();
		String current = "";
		boolean emojiDone = true;
		
		for(int i = 0; i < sentence.length(); i++) {
			String spot = sentence.substring(i, i+1);
			if(spot.equals(":")) {
				if(emojiDone == true) {
					emojiDone = false;
				} else {
					emojiDone = true;
					System.out.println(current);
					current = "";
				}
			} else {
				if(emojiDone == false) current+=spot;
			}
		}
	}

}
