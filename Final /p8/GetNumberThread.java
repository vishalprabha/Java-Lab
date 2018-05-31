import java.util.Scanner;

public class GetNumberThread extends Thread {

	@Override
	public void run() {
		Scanner s = new Scanner(System.in);
		String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		System.out.println("Enter a number with 4 or more digits");
		int num = s.nextInt();
		if (Integer.toString(num).length() >= 4) {
			for (char c : Integer.toString(num).toCharArray()) {
				System.out.println(numbers[Character.getNumericValue(c)]);
			}
		}
	}

}
