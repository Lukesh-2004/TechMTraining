package lukesh;

class MatrixMultiplication extends Thread {
	private int[][] A, B, C;
	private int row, col, size;

	public MatrixMultiplication(int[][] A, int[][] B, int[][] C, int row, int col, int size) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.row = row;
		this.col = col;
		this.size = size;
	}

	public void run() {
		int sum = 0;
		for (int k = 0; k < size; k++) {
			sum += A[row][k] * B[k][col];
		}
		C[row][col] = sum;
	}
}

public class MultiThreadMatrix {
	public static void main(String[] args) throws InterruptedException {
		int[][] A = { { 1, 2 }, { 3, 4 } };
		int[][] B = { { 5, 6 }, { 7, 8 } };
		int[][] C = new int[2][2];

		Thread[][] threads = new Thread[2][2];

		// Create and start threads for each element in the result matrix
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				threads[i][j] = new MatrixMultiplication(A, B, C, i, j, 2);
				threads[i][j].start();
			}
		}

		// Wait for all threads to complete
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				threads[i][j].join();
			}
		}

		// Print the result matrix
		System.out.println("Resultant Matrix:");
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}
	}
}
