package studentpackage;

public class InvalidSGPA extends Exception {
	String s1;
	public InvalidSGPA(String s2) {
		s1 = s2;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return s1;
	}
	
}
