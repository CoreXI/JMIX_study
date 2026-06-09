import java.util.List;

interface Payable {
	double calculateSalary();
}

public abstract class Employee implements Payable {
	private int id;
	private String name;

	public Employee(int id, String name) {
		if (id <= 0) throw new InvalidProductException("id не может быть <= 0: " + id);
		if (name == null || name.isEmpty()) throw new InvalidProductException("имя не может быть пустым");
		this.id = id;
		this.name = name;
	}

	public int getEmployeeById() {
		return (int) id;
	}

	public String getEmployeeByName() {
		return name;
	}

	public String getInfo() {
		return String.format("[%d] %s", id, name);
	}

	public static Employee findEmployeeById(List<Employee> employees, int id) {
		for (Employee e : employees) {
			if (e.getEmployeeById() == id) {
				return e;
			}
		}
		throw new EmployeeNotFound(id);
	}
}

class FullTimeEmployee extends Employee {
	private double monthlySalary;

	public FullTimeEmployee(int id, String name, double monthlySalary) {
		super(id, name);
		this.monthlySalary = monthlySalary;
	}

	@Override
	public double calculateSalary() {
		if (monthlySalary < 0)
			throw new PriceException(monthlySalary);
		return monthlySalary;
	}
}

class ContractEmployee extends Employee {
	private double hourlyRate;
	private int hoursWorked;

	public ContractEmployee(int id, String name, double hourlyRate, int hoursWorked) {
		super(id, name);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	@Override
	public double calculateSalary() {
		return hourlyRate * hoursWorked;
	}
}
