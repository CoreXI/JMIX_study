
public class Result<T> {
	private final T value;
	private final Exception exception;

	private Result(T value, Exception exception) {
		this.value = value;
		this.exception = exception;

		for (StackTraceElement element : exception.getStackTrace()) {
			System.out.println(element);
		}
	}

	public static <T> Result<T> success(T value) {
		return new Result<>(value, null);
	}

	public static <T> Result<T> failure(Exception e) {
		return new Result<>(null, e);
	}

}



