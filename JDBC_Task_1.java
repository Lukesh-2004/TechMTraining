package lukesh;

import java.sql.*;
import java.util.Scanner;

public class JDBCInsert {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/your_database"; // Change database name
		String user = "your_username"; // Change username
		String password = "your_password"; // Change password

		String insertQuery = "INSERT INTO employees (empId, empName, salary) VALUES (?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(insertQuery);
				Scanner sc = new Scanner(System.in)) {

			System.out.print("Enter number of employees to insert: ");
			int n = sc.nextInt();
			sc.nextLine(); // Consume newline

			for (int i = 0; i < n; i++) {
				System.out.print("Enter Employee ID: ");
				int empId = sc.nextInt();
				sc.nextLine(); // Consume newline
				System.out.print("Enter Employee Name: ");
				String empName = sc.nextLine();
				System.out.print("Enter Salary: ");
				double salary = sc.nextDouble();
				sc.nextLine(); // Consume newline

				pstmt.setInt(1, empId);
				pstmt.setString(2, empName);
				pstmt.setDouble(3, salary);

				pstmt.executeUpdate(); // Execute the insertion
				System.out.println("Employee inserted successfully.");
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Error: Duplicate Employee ID.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
