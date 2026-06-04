# Тема 5 — Generics

```
Текущая тема: Generics (обобщения)
Раздел: Блок 0 — Java Core
Пройдено: Типы, ООП, Коллекции, Исключения
Далее будет: Stream API
```

---

## Зачем это нужно

Ты уже писал `List<String>` и `Map<String, Integer>` — это и есть generics в действии. Теперь разберёмся, что это такое и как писать свои обобщённые классы.

**Проблема без generics:**

```java
// Без generics — теряем информацию о типе
List list = new ArrayList();
list.add("hello");
list.add(42);           // компилятор не возразит
String s = (String) list.get(1); // ClassCastException в рантайме!
```

**С generics — ошибка на этапе компиляции:**

```java
List<String> list = new ArrayList<>();
list.add("hello");
list.add(42); // ошибка компиляции: Integer не подходит для List<String>
```

---

## Обобщённый класс

```java
// T — параметр типа (любое имя, T — convention для "Type")
public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

// Использование
Box<String> stringBox = new Box<>("Hello");
Box<Integer> intBox = new Box<>(42);

String s = stringBox.getValue(); // String, без приведения типа
```

---

## Обобщённый метод

```java
public class Utils {
    // <T> перед возвращаемым типом — объявление параметра типа для метода
    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.println(item);
        }
    }
}

Utils.printArray(new String[]{"a", "b", "c"});
Utils.printArray(new Integer[]{1, 2, 3});
```

---

## Ограничения (bounds)

```java
// T должен быть Number или его наследником (Integer, Double, ...)
public <T extends Number> double sum(List<T> list) {
    double total = 0;
    for (T item : list) {
        total += item.doubleValue(); // метод Number доступен
    }
    return total;
}

sum(List.of(1, 2, 3));       // Integer — наследник Number ✓
sum(List.of("a", "b"));      // String — не наследник Number ✗ (ошибка компиляции)
```

---

## Wildcard — ?

`?` означает "какой-то тип, неизвестный":

```java
// Принимает List любого типа — только чтение
public void printList(List<?> list) {
    for (Object item : list) {
        System.out.println(item);
    }
}

// ? extends Number — любой подтип Number
public double sumList(List<? extends Number> list) { ... }
```

Wildcard — для методов, которым не важен конкретный тип, только что он существует.

---

## Как это используется в Spring / JMIX

В реальном коде ты будешь встречать generics постоянно:

```java
// Spring Data: репозиторий для работы с сущностью Product, первичный ключ Long
public interface ProductRepository extends JpaRepository<Product, Long> { }

// Возврат списка из сервиса
public List<Product> findAll() { ... }

// Optional — контейнер, который может содержать значение или быть пустым
Optional<Product> product = repository.findById(id);
```

`Optional<T>` — важный тип. Замена `null` при поиске:

```java
Optional<String> name = Optional.of("Alice");
Optional<String> empty = Optional.empty();

name.isPresent();           // true
name.get();                 // "Alice"
empty.orElse("Unknown");    // "Unknown" если пусто
```

---

## Суть

> Generics — параметризация типов. Пишешь код один раз, он работает с любым типом, но компилятор следит за корректностью. В Spring ты будешь использовать их каждый день через `List<T>`, `Optional<T>`, `JpaRepository<Entity, Id>`.
