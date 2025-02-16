import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student> {
	String name;
	int[] marks;
	int total;
	double average;

	public Student(String name, int[] marks) {
		this.name = name;
		this.marks = marks;
		this.total = Arrays.stream(marks).sum(); // Calculate total marks
		this.average = (double) total / marks.length; // Calculate average marks
	}

	@Override
	public int compareTo(Student other) {
		return Integer.compare(other.total, this.total); // Sorting in descending order
	}
}

public class StudentMarks {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Get number of students
		System.out.print("Enter number of students: ");
		int n = sc.nextInt();

		Student[] students = new Student[n];

		// Read student data
		for (int i = 0; i < n; i++) {
			System.out.print("Enter student name: ");
			String name = sc.nextLine();
			System.out.print("Enter number of subjects: ");
			int subjects = sc.nextInt();
			int[] marks = new int[subjects];

			System.out.println("Enter marks:");
			for (int j = 0; j < subjects; j++) {
				marks[j] = sc.nextInt();
			}

			students[i] = new Student(name, marks);
		}

		// Sort students based on total marks
		Arrays.sort(students);

		// Print sorted list
		System.out.println("\nSorted Student List (by Total Marks):");
		for (Student s : students) {
			System.out.println("Name: " + s.name + ", Total: " + s.total + ", Average: " + s.average);
		}

		sc.close();
	}
}
