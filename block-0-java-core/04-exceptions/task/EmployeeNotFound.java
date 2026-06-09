public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound(int id) {
        super("Сотрудник с id " + id + " не найден");
    }
}

class PriceException extends RuntimeException {
    public PriceException(double salary) {
        super("Зарплата не может быть отрицательной: " + salary);
    }
}

class InvalidProductException extends RuntimeException {
    public InvalidProductException(String message) {
        super(message);
    }

    public InvalidProductException(String message, Exception e) {
        super(message, e);
    }
}
