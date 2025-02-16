package lukesh;

import java.util.Scanner;

class Employee {
	private int empId;
	private String empName;
	private double annualSalary;
	private int yearsWorked;

	// Constructor
	public Employee(int empId, String empName, double annualSalary, int yearsWorked) {
		this.empId = empId;
		this.empName = empName;
		this.annualSalary = annualSalary;
		this.yearsWorked = yearsWorked;
	}

	// Method to display employee details
	public void getEmployeeDetails() {
		System.out.println("Employee ID: " + empId);
		System.out.println("Employee Name: " + empName);
		System.out.println("Annual Salary: " + annualSalary);
		System.out.println("Years Worked: " + yearsWorked);
	}

	// Method to determine loan eligibility
	public void getLoanEligibility() {
		if (yearsWorked <= 5) {
			System.out.println("Not eligible for a loan.");
			return;
		}

		double loanAmount = 0;
		if (annualSalary >= 15_00_000) {
			loanAmount = 7_00_000;
		} else if (annualSalary >= 10_00_000) {
			loanAmount = 5_00_000;
		} else if (annualSalary >= 6_00_000) {
			loanAmount = 2_00_000;
		}

		if (loanAmount > 0) {
			System.out.println("Eligible for a loan of: ₹" + loanAmount);
		} else {
			System.out.println("Not eligible for a loan.");
		}
	}
}

public class EmployeeTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Input employee details
		System.out.print("Enter Employee ID: ");
		int empId = sc.nextInt();
		sc.nextLine(); // Consume newline
		System.out.print("Enter Employee Name: ");
		String empName = sc.nextLine();
		System.out.print("Enter Annual Salary: ");
		double annualSalary = sc.nextDouble();
		System.out.print("Enter Years Worked: ");
		int yearsWorked = sc.nextInt();

		// Create employee object and check eligibility
		Employee emp = new Employee(empId, empName, annualSalary, yearsWorked);
		System.out.println("\nEmployee Details:");
		emp.getEmployeeDetails();

		System.out.println("\nLoan Eligibility:");
		emp.getLoanEligibility();

		sc.close();
	}
}
