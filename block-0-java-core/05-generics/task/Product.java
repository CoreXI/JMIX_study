import java.util.List;
import java.util.Optional;

class Result<T> {
	private final T value;
	private final String errorMessage;
	private final boolean success;

	private Result(T value, String errorMessage, boolean success) {
		this.value = value;
		this.errorMessage = errorMessage;
		this.success = success;
	}

	public static <T> Result<T> ok(T value) {
		return new Result<>(value, null, true);
	}

	public static <T> Result<T> fail(String message) {
		return new Result<>(null, message, false);
	}

	public T getValue() { return value; }
	public String getErrorMessage() { return errorMessage; }
	public boolean isSuccess() { return success; }
}

public class Product {

	public static Result<String> findProduct(List<String> products, String name) {
		for (String product : products) {
			if (product.equals(name)) {
				return Result.ok(product);
			}
		}
		return Result.fail("Продукт не найден: " + name);
	}

	public static <T extends Comparable<T>> Optional<T> max(List<T> list) {
		if (list.isEmpty()) {
			return Optional.empty();
		}
		T max = list.get(0);
		for (T item : list) {
			if (item.compareTo(max) > 0) {
				max = item;
			}
		}
		return Optional.of(max);
	}

	public static void main(String[] args) {
		List<String> products = List.of("Яблоко", "Банан", "Груша");

		Result<String> found = findProduct(products, "Банан");
		Result<String> notFound = findProduct(products, "Манго");

		System.out.println(found.isSuccess() ? found.getValue() : found.getErrorMessage());
		System.out.println(notFound.isSuccess() ? notFound.getValue() : notFound.getErrorMessage());

		Optional<Integer> maxInt = max(List.of(3, 1, 7, 2, 5));
		Optional<String> maxStr = max(List.of("банан", "яблоко", "груша"));

		maxInt.ifPresent(v -> System.out.println("Максимум int: " + v));
		maxStr.ifPresent(v -> System.out.println("Максимум String: " + v));

		Optional<Integer> empty = max(List.<Integer>of());
		System.out.println("Пустой список: " + empty.isPresent());
	}
}
