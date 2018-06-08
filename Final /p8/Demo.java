public class MainClass {

	public static void main(String[] args) {
		Thread t1 = new NumberThread();
		Thread t2 = new VowelThread();

		t1.start();

		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();

	}

}
