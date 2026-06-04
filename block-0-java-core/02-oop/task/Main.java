package oop;

public class Main {
	FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(1, "Иванов Иван", 50000);
	ContractEmployee contractEmployee = new ContractEmployee(2, "Петров Петр", 200, 160);

	public static void main(String[] args) {
		Main main = new Main();

		System.out.println(main.fullTimeEmployee.getInfo());
		System.out.println(String.format("Зарплата: %.2f", main.fullTimeEmployee.calculateSalary()));

		System.out.println(main.contractEmployee.getInfo());
		System.out.println(String.format("Зарплата: %.2f", main.contractEmployee.calculateSalary()));
	}
}
