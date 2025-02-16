package lukesh;

import java.util.Arrays;

class SortThread extends Thread {
	private int[] arr;

	public SortThread(int[] arr) {
		this.arr = arr;
	}

	public void run() {
		Arrays.sort(arr);
		System.out.println("Sorted Array: " + Arrays.toString(arr));
	}
}

public class MultiThreadSort {
	public static void main(String[] args) {
		int[] numbers = { 5, 3, 8, 1, 9, 2 };

		SortThread sortThread = new SortThread(numbers);
		sortThread.start();
	}
}
