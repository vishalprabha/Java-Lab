package studentpackage;

import ResultPackage.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RegisterStudent implements Student {

	String name, branch;
	ArrayList<String> subjects, prevSubjects;
	ArrayList<Integer> marks, credits, prevMarks, prevCredits;
	int creditsRegistered;
	float sgpa, cgpa;
	int semTotal, total;
	int totalCredits;
	@Override
	public void getDetails() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the details of the student");
		System.out.println("Enter the name");
		name = s.next();
		System.out.println("Enter the branch");
		branch = s.next();
		subjects = new ArrayList<>();
		credits = new ArrayList<>();
		marks = new ArrayList<>();
		prevSubjects = new ArrayList<>();
		prevMarks = new ArrayList<>();
		prevCredits = new ArrayList<>();
		creditsRegistered = 0;
		register();
	}
	
	public void register(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the subjects and credits to register");
		int ch=0;
		while(ch!=2){			
			System.out.println("Enter 1 to register new subject, 2 to stop.");
			ch = s.nextInt();
			switch(ch){
			case 1:
				System.out.println("Enter the subject and credits for it to register");
				String sub = s.next();
				int c = s.nextInt();
				creditsRegistered += c;
				subjects.add(sub);
				credits.add(c);
				try{
					if(creditsRegistered > 30){
						creditsRegistered = 0;
						subjects.clear();
						credits.clear();
						throw new CreditLimitException("Credit Limit exceeded");
					}
				}catch(CreditLimitException e){
					System.out.println(e);
					System.exit(0);
				}
				break;
			case 2:
				getMarks();
				break;
			}			
		}
		
	}
	
	public void getMarks(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the gradePoint for each of the subjects (1-10)");
		for(String x : subjects){
			System.out.println(x + " : ");
			marks.add(s.nextInt());
		}
		calculateSGPA();
	}
	
	public void calculateSGPA(){
		semTotal = 0;
		for(int i=0; i<subjects.size(); i++){
			semTotal += marks.get(i) * credits.get(i);
		}
		sgpa = (float)semTotal/creditsRegistered;
		try{
			if(sgpa > 10){
				throw new InvalidSGPA("Sgpa > 10 error");
			}
		}catch(InvalidSGPA e){
			System.out.println(e);
			System.exit(0);
		}
		total = semTotal;
		ShowResult.display(subjects, marks, credits, sgpa);
		calculateCGPA();
	}
	
	public void calculateCGPA(){
		System.out.println("Enter the previous 3 sems details");
		Scanner s = new Scanner(System.in);
		
		for(int i=0; i<6; i++){
			System.out.println("Subject, Credit, GradePoint");
			String sub = s.next();
			prevSubjects.add(sub);
			int cre = s.nextInt();
			prevCredits.add(cre);
			int mar = s.nextInt();
			prevMarks.add(mar);
			total += prevCredits.get(i) * prevMarks.get(i);	
			totalCredits += prevCredits.get(i);
		}
		totalCredits += creditsRegistered;
		cgpa = (float)total/totalCredits;
		ShowResult.showCGPA(cgpa);
	}

}
