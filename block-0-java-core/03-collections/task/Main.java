package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {
	List<String> names = new ArrayList<>();
	Map<String, Integer> nameToGrade = new TreeMap<>();
	Set<Integer> uniqueGrades = new HashSet<>();

	public Main() {
		names.add("Aлиса");
		names.add("Боб");
		names.add("Карл");
		names.add("Диана");
		names.add("Ева");

		nameToGrade.put("Aлиса", 85);
		nameToGrade.put("Боб", 92);
		nameToGrade.put("Карл", 78);
		nameToGrade.put("Диана", 95);
		nameToGrade.put("Ева", 88);

		uniqueGrades.addAll(nameToGrade.values());
	}

	public static void main(String[] args) {
		Main main = new Main();

		System.out.println("Список имён:");
		for (int i = 0; i < main.names.size(); i++) {
			System.out.println(String.format("%d. %s", i + 1, main.names.get(i)));
		}
		System.out.println("\nОценки студентов:");
		for (String name : main.nameToGrade.keySet()) {
			System.out.println(String.format("%s: %d", name, main.nameToGrade.get(name)));
		}
		System.out.println("\nУникальные оценки:");
		for (Integer grade : main.uniqueGrades) {
			System.out.println(grade);
		}

		int maxGrade = Integer.MIN_VALUE;
		String topStudent = "";
		int totalGrade = 0;

		for (Map.Entry<String, Integer> entry : main.nameToGrade.entrySet()) {
			String name = entry.getKey();
			int grade = entry.getValue();

			if (grade > maxGrade) {
				maxGrade = grade;
				topStudent = name;
			}
			totalGrade += grade;
		}

		double averageGrade = (double) totalGrade / main.nameToGrade.size();

		System.out.println(String.format("\nСтудент с максимальной оценкой: %s (%d)", topStudent, maxGrade));
		System.out.println(String.format("Средняя оценка по группе: %.1f", averageGrade));
	}
}


