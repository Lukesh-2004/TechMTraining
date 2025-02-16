import java.sql.*;
import java.util.Scanner;

public class JDBCMenu {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Scanner sc = new Scanner(System.in)) {

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Insert a new Row");
                System.out.println("2. Update a Row");
                System.out.println("3. Delete a Row");
                System.out.println("4. Select a Row");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1: // Insert
                        System.out.print("Enter Employee ID: ");
                        int empId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Employee Name: ");
                        String empName = sc.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();

                        String insertQuery = "INSERT INTO employees (empId, empName, salary) VALUES (?, ?, ?)";
                        PreparedStatement pstmtInsert = conn.prepareStatement(insertQuery);
                        pstmtInsert.setInt(1, empId);
                        pstmtInsert.setString(2, empName);
                        pstmtInsert.setDouble(3, salary);
                        pstmtInsert.executeUpdate();
                        System.out.println("Employee inserted successfully.");
                        break;

                    case 2: // Update
                        System.out.print("Enter Employee ID to update: ");
                        empId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new Employee Name: ");
                        empName = sc.nextLine();
                        System.out.print("Enter new Salary: ");
                        salary = sc.nextDouble();

                        String updateQuery = "UPDATE employees SET empName=?, salary=? WHERE empId=?";
                        PreparedStatement pstmtUpdate = conn.prepareStatement(updateQuery);
                        pstmtUpdate.setString(1, empName);
                        pstmtUpdate.setDouble(2, salary);
                        pstmtUpdate.setInt(3, empId);
                        pstmtUpdate.executeUpdate();
                        System.out.println("Employee updated successfully.");
                        break;

                    case 3: // Delete
                        System.out.print("Enter Employee ID to delete: ");
                        empId = sc.nextInt();

                        String deleteQuery = "DELETE FROM employees WHERE empId=?";
                        PreparedStatement pstmtDelete = conn.prepareStatement(deleteQuery);
                        pstmtDelete.setInt(1, empId);
                        pstmtDelete.executeUpdate();
                        System.out.println("Employee deleted successfully.");
                        break;

                    case 4: // Select
                        System.out.print("Enter Employee ID to search: ");
                        empId = sc.nextInt();

                        String selectQuery = "SELECT * FROM employees WHERE empId=?";
                        PreparedStatement pstmtSelect = conn.prepareStatement(selectQuery);
                        pstmtSelect.setInt(1, empId);
                        ResultSet rs = pstmtSelect.executeQuery();

                        if (rs.next()) {
                            System.out.println("Employee ID: " + rs.getInt("empId"));
                            System.out.println("Employee Name: " + rs.getString("empName"));
                            System.out.println("Salary: " + rs.getDouble("salary"));
                        } else {
                            System.out.println("Employee not found.");
                        }
                        break;

                    case 5: // Exit
                        System.out.println("Exiting program...");
                        return;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
