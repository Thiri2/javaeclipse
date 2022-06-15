package day20;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CRUD2 {

	public static void main(String[] args) throws SQLException {
		saveMultipleEmployee();
	}


	private static void saveMultipleEmployee() throws SQLException {
		
		var empList = new ArrayList<Employee>();
		Scanner sc = new Scanner(System.in);
		
		for(var i = 0; i < 2; i++) {
			System.out.println("Enter data for emp : " + (i + 1));
			Employee emp = new Employee();
			
			System.out.println("Enter empno : ");
			emp.setEmpId(Integer.parseInt(sc.nextLine()));
			
			System.out.println("Enter email : ");
			emp.setEmail(sc.nextLine());
			
			System.out.println("Enter password : ");
			emp.setPassword(sc.nextLine());
			
			System.out.println("Enter city : ");
			emp.setCity(sc.nextLine());
			
			System.out.println("Enter salary : ");
			emp.setSalary(Double.parseDouble(sc.nextLine()));
			
			System.out.println("Enter birthday : ");
			emp.setBirthday(LocalDate.parse(sc.nextLine()));
			
			empList.add(emp);
		}
		
		//DatabaseHandler.saveEmployee(empList);
		DatabaseHandler.manageTransaction(empList);
		System.out.println("success");
		
		sc.close();
	}
}
