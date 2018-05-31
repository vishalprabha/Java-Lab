/*
 * Author - Niranjan A
 */
public class Demo {

	public static void main(String[] args) throws InterruptedException {
		GetNumberThread nt = new GetNumberThread();
		GetStringThread st = new GetStringThread();
		nt.start();
		Thread.sleep(5000);
		st.start();
	}

}
