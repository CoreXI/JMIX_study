package streams;

public class Result<T> {
	private String key;
	private T value;

	public Result(String key, T value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() { return key; }
	public T getValue() { return value; }
}
