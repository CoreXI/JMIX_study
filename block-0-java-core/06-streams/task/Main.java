package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	List<Employees.Employee> staff = new ArrayList<>();
	Employees employees = new Employees();

	public static void main(String[] args) {
		Main main = new Main();
		main.setupDepartments();
		Result<Map<String, List<Employees.Employee>>> grouped = main.groupByDepartment();
		main.printStaff(grouped);
	}

	private void setupDepartments() {
		fillDepartment("IT", new String[] { "Иван", "Мария", "Петр" });
		fillDepartment("HR", new String[] { "Сергей", null });
		addStaff(3);
	}

	private void printStaff(Result<Map<String, List<Employees.Employee>>> result) {
		for (Map.Entry<String, List<Employees.Employee>> entry : result.getValue().entrySet()) {
			System.out.println("Отдел: " + entry.getKey() + ", сотрудников: " + entry.getValue().size());
			for (Employees.Employee emp : entry.getValue()) {
				System.out.println("  Имя: " + emp.getName() + ", Зарплата: " + emp.getSalary() + ", Опыт: "
						+ emp.getExperience() + " лет");
			}
		}
		System.out.println("Самый высокооплачиваемый сотрудник с опытом > 3 лет: " +
				staff.stream()
						.filter(emp -> emp.getExperience() != null && emp.getExperience() > 3)
						.max((emp1, emp2) -> emp1.getSalary().compareTo(emp2.getSalary()))
						.map(emp -> emp.getName() + " с зарплатой " + emp.getSalary())
						.orElse("Нет сотрудников с опытом > 3 лет"));

		double averageSalary = staff.stream()
				.mapToDouble(Employees.Employee::getSalary)
				.average()
				.orElse(0.0);

		System.out.println("Средняя зарплата: " + averageSalary);

		System.out.println("Сотрудники с зарплатой выше средней: " +
				staff.stream()
						.filter(emp -> emp.getSalary() != null && emp.getSalary() > averageSalary)
						.map(Employees.Employee::getName)
						.collect(Collectors.joining(", ")));
	}

	// одиночные варианты
	private void addStaff(Employees.Employee employee) {
		staff.add(employees.checkEmployee(employee));
	}

	private void addStaff(String name) {
		staff.add(employees.checkEmployee(employees.new Employee(name, null, null, null)));
	}

	private void addStaff() {
		staff.add(employees.checkEmployee(employees.new Employee(null, null, null, null)));
	}

	// массив объектов
	private void addStaff(Employees.Employee[] employeeArray) {
		for (Employees.Employee employee : employeeArray) {
			addStaff(employee);
		}
	}

	// массив имён
	private void addStaff(String[] names) {
		for (String name : names) {
			addStaff(name);
		}
	}

	public void fillDepartment(String department, String[] names) {
		for (String name : names) {
			staff.add(employees.checkEmployee(employees.new Employee(name, department, null, null)));
		}
	}

	private Result<Map<String, List<Employees.Employee>>> groupByDepartment() {
		Map<String, List<Employees.Employee>> grouped = staff.stream()
				.collect(Collectors.groupingBy(Employees.Employee::getDepartment));
		return new Result<>("departments", grouped);
	}

	// число — N случайных сотрудников
	private void addStaff(int count) {
		for (int i = 0; i < count; i++) {
			addStaff();
		}
	}
}
