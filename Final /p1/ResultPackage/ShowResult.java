package ResultPackage;
import java.util.ArrayList;

public class ShowResult {
	public static void display(ArrayList<String> subjects, ArrayList<Integer> marks, ArrayList<Integer> credits, float sgpa){
		System.out.println("This sem results are : ");
		for(int i=0; i<subjects.size(); i++){
			System.out.println(subjects.get(i) + " " + credits.get(i) + " " + marks.get(i));
		}
		System.out.println("SGPA is : " + sgpa);
	}
	public static void showCGPA(float cgpa){
		System.out.println("CGPA is : " + cgpa);
	}
}
