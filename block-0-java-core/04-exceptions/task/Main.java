import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		FullTimeEmployee petr = new FullTimeEmployee(2, "Петр", 4030.00);
		FullTimeEmployee sidor = new FullTimeEmployee(3, "Сидор", 4100.00);
		FullTimeEmployee alexey = new FullTimeEmployee(4, "Алексей", 3000.00);

		List<Employee> list = Arrays.asList(petr, sidor, alexey, new FullTimeEmployee(5, "Василий", 4000.00));

		// Сценарий 1: сотрудник не найден
		try {
			Employee.findEmployeeById(list, 10);
		} catch (EmployeeNotFound e) {
			System.out.println(e.getMessage());
		}

		// Сценарий 2: отрицательная зарплата
		try {
			FullTimeEmployee broken = new FullTimeEmployee(6, "Тест", -4000.00);
			broken.calculateSalary();
		} catch (PriceException e) {
			System.out.println(e.getMessage());
		}

		// Сценарий 3: некорректные данные сотрудника (пустое имя)
		try {
			new FullTimeEmployee(7, "", 3000.00);
		} catch (InvalidProductException e) {
			System.out.println(e.getMessage());
		}
	}
}
