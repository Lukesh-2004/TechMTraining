package lukesh;

import java.util.concurrent.atomic.AtomicInteger;

class PrimeSumThread extends Thread {
	private int start, end;
	private AtomicInteger totalSum;

	public PrimeSumThread(int start, int end, AtomicInteger totalSum) {
		this.start = start;
		this.end = end;
		this.totalSum = totalSum;
	}

	// Check if a number is prime
	private boolean isPrime(int num) {
		if (num < 2)
			return false;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public void run() {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				sum += i;
			}
		}
		totalSum.addAndGet(sum); // Add local sum to shared totalSum
	}
}

public class MultiThreadPrimeSum {
	public static void main(String[] args) throws InterruptedException {
		int limit = 50; // Change as needed
		int numThreads = 5;
		int range = limit / numThreads;

		Thread[] threads = new Thread[numThreads];
		AtomicInteger totalSum = new AtomicInteger(0);

		// Create and start threads
		for (int i = 0; i < numThreads; i++) {
			int start = i * range + 1;
			int end = (i == numThreads - 1) ? limit : (i + 1) * range;

			threads[i] = new PrimeSumThread(start, end, totalSum);
			threads[i].start();
		}

		// Wait for all threads to complete
		for (Thread thread : threads) {
			thread.join();
		}

		// Print total sum of prime numbers
		System.out.println("Sum of Prime Numbers up to " + limit + " is: " + totalSum);
	}
}
