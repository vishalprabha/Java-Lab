import java.util.Scanner;

public class GetStringThread extends Thread {

	@Override
	public void run() {
		System.out.println("Enter a string");
		Scanner s = new Scanner(System.in);
		String in = s.next();
		String vowels = "AEIOUaeiou";
		int count = 0;
		for(Character c : in.toCharArray()){
			if(vowels.contains(Character.toString(c))){
				count++;
			}
		}
		System.out.println("Number of vowels : " + count);
	}
	
}
