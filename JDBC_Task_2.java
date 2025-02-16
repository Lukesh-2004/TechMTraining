import java.sql.*;
import java.util.Scanner;

public class JDBCUpdate {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter Employee ID to update: ");
            int empId = sc.nextInt();
            sc.nextLine();  // Consume newline
            System.out.print("Enter new Employee Name: ");
            String empName = sc.nextLine();
            System.out.print("Enter new Salary: ");
            double salary = sc.nextDouble();

            String updateQuery = "UPDATE employees SET empName=?, salary=? WHERE empId=?";
            PreparedStatement pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1, empName);
            pstmt.setDouble(2, salary);
            pstmt.setInt(3, empId);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Employee ID not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
