package model;

	import java.math.BigDecimal;
	import java.util.Date;

public class CRUD {
	public static void main(String[] args) {

	EmployeeCRUD employeeCRUD = new EmployeeCRUD();
	Employee employee = createEmployee();
	BigDecimal id = employee.getEmployeeId();
	System.out.print(id);

	employeeCRUD.createEmployee(employee);
	employeeCRUD.readEmployee(id);
	employeeCRUD.updateSalary(id);
	employeeCRUD.deleteEmployee(id);
	}
	
	private static Employee createEmployee() {
		
		int employeeId = 2000;
		Employee emp = new Employee();
		emp.setFirstName("Jan");
		emp.setLastName("Kowalski");
		emp.setHireDate(new Date());
		emp.setEmployeeId(new BigDecimal(employeeId));
		emp.setSalary(new BigDecimal("10000"));
		emp.setEmail("jkowal@gmail.com");
		emp.setJobId("SH_CLERK");
		return emp;
	}

}
