package types;

public class Main {
	public static void main(String[] args) {
		String name = "Молоко";
		double price = 50.0;
		int quantity = 100;
		boolean isActive = true;

		Man m = new Man();
		
		m.outputProductionInfo(name, price, quantity, isActive);

		double totalValue = m.calculateTotalValue(price, quantity);
		var totalValue2 = m.calculateTotalValue(50.0, 100);
		int roundPrice = m.roundPrice(50.55);

		System.out.println(String.format("Общая стоимость: %.2f", totalValue));
		System.out.println(String.format("Общая стоимость (вариант 2): %.2f", totalValue2));
		System.out.println(String.format("Округлённая стоимость: %d", roundPrice));
	}
}
