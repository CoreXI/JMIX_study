package types;

public class Man {
	public void outputProductionInfo(String name, double price, int quantity, boolean isActive) {
		System.out.println(String.format("Товар: %s | Цена: %.2f | Склад: %d шт | Активен: %b", name, price, quantity, isActive));
	}
	
	public double calculateTotalValue(double price, int quantity) {
		return price * quantity;
	}

	public int roundPrice(double price) {
		return (int) price;
	}

}
