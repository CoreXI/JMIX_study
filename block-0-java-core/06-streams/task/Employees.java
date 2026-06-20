package streams;

public class Employees {

	class Employee {
		private String name;
		private String department;
		private Double salary;
		private Integer experience;

		public Employee(String name, String department, Double salary, Integer experience) {
			this.name = name;
			this.department = department;
			this.salary = salary;
			this.experience = experience;
		}

		public String getName() { return name; }
		public void setName(String name) { this.name = name; }

		public String getDepartment() { return department; }
		public void setDepartment(String department) { this.department = department; }

		public Double getSalary() { return salary; }
		public void setSalary(Double salary) { this.salary = salary; }

		public Integer getExperience() { return experience; }
		public void setExperience(Integer experience) { this.experience = experience; }
	}

	public Employee checkEmployee(Employee employee) {
		GenerateRandomEmployee generator = new GenerateRandomEmployee();

		if (employee.getName() == null) {
			employee.setName(generator.generateRandomName());
		}
		if (employee.getDepartment() == null) {
			employee.setDepartment(generator.generateRandomDepartment());
		}
		if (employee.getSalary() == null) {
			employee.setSalary(generator.generateRandomSalary());
		}
		if (employee.getExperience() == null) {
			employee.setExperience(generator.generateRandomExperience());
		}

		return employee;
	}

	private class GenerateRandomEmployee {
		private static final String[] NAMES = {
				"Иван", "Мария", "Петр", "Анна", "Сергей", "Елена", "Дмитрий", "Ольга",
				"Алексей", "Наталья", "Михаил", "Татьяна", "Андрей", "Юлия", "Владимир",
				"Екатерина", "Николай", "Ирина", "Артем", "Светлана"
		};
		private static final String[] DEPARTMENTS = { "HR", "IT", "Sales", "Marketing" };
		private static final int DEFAULT_SALARY_MIN = 30000;
		private static final int DEFAULT_SALARY_MAX = 100000;
		private static final int DEFAULT_EXPERIENCE_MIN = 0;
		private static final int DEFAULT_EXPERIENCE_MAX = 20;

		public String generateRandomName() {
			int index = (int) (Math.random() * NAMES.length);
			return NAMES[index];
		}

		public String generateRandomDepartment() {
			int index = (int) (Math.random() * DEPARTMENTS.length);
			return DEPARTMENTS[index];
		}

		public Double generateRandomSalary(int min, int max) {
			return Math.round(Math.random() * (max - min) + min) * 1.0;
		}

		public Double generateRandomSalary() {
			return generateRandomSalary(DEFAULT_SALARY_MIN, DEFAULT_SALARY_MAX);
		}

		public Integer generateRandomExperience() {
			return (int) (Math.random() * (DEFAULT_EXPERIENCE_MAX - DEFAULT_EXPERIENCE_MIN + 1)) + DEFAULT_EXPERIENCE_MIN;
		}
	}

}
