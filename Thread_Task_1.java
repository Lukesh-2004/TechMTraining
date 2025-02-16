class HelloThread extends Thread {
	public void run() {
		System.out.println("Hello, Java!");
	}
}

public class BasicThread {
	public static void main(String[] args) {
		HelloThread thread = new HelloThread();
		thread.start(); // Start the thread
	}
}
