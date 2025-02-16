class ExceptionHandlingExample {
	public static void main(String[] args) {
		try {
			int result = 10 / 0; // This will cause an ArithmeticException
			System.out.println(result);
		} catch (ArithmeticException e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
		System.out.println("Program continues after exception handling.");
	}
}
