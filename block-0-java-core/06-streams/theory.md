# Тема 6 — Stream API

```
Текущая тема: Stream API
Раздел: Блок 0 — Java Core
Пройдено: Типы, ООП, Коллекции, Исключения, Generics
Далее будет: Блок 1 — Инструменты → Блок 2 — Spring Boot
```

---

## Зачем это нужно

Stream API — это `.filter()`, `.map()`, `.reduce()` из JS, но для Java-коллекций.
Если ты в Node.js писал цепочки `array.filter(...).map(...).reduce(...)` — Stream API ляжет интуитивно.

---

## Что такое Stream

`Stream` — конвейер обработки данных. Не хранит данные, только описывает операции над ними.

```
Источник → [промежуточные операции] → терминальная операция
```

```java
List<String> names = List.of("Alice", "Bob", "Charlie", "Anna");

List<String> result = names.stream()        // создать поток
    .filter(n -> n.startsWith("A"))         // оставить только начинающиеся на A
    .map(String::toUpperCase)               // привести к верхнему регистру
    .sorted()                               // сортировать
    .collect(Collectors.toList());          // собрать обратно в List

// result: [ALICE, ANNA]
```

---

## Лямбда-выражения

Stream API использует лямбды — анонимные функции. Аналог стрелочных функций в JS:

```java
// JS:   n => n.startsWith("A")
// Java: n -> n.startsWith("A")

// JS:   (a, b) => a + b
// Java: (a, b) -> a + b
```

Лямбды передаются в методы Stream как аргументы.

---

## Промежуточные операции (возвращают Stream)

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

// filter — оставить элементы по условию (аналог .filter в JS)
numbers.stream().filter(n -> n % 2 == 0); // 2, 4, 6

// map — преобразовать каждый элемент (аналог .map в JS)
numbers.stream().map(n -> n * 2); // 2, 4, 6, 8, 10, 12

// sorted — сортировать
numbers.stream().sorted();
numbers.stream().sorted((a, b) -> b - a); // обратный порядок

// distinct — убрать дубликаты
List.of(1, 2, 2, 3).stream().distinct(); // 1, 2, 3

// limit / skip — срез (аналог .slice в JS)
numbers.stream().skip(2).limit(3); // 3, 4, 5
```

---

## Терминальные операции (завершают конвейер)

```java
List<String> names = List.of("Alice", "Bob", "Charlie");

// collect — собрать в коллекцию
List<String> list = names.stream().collect(Collectors.toList());

// forEach — перебрать (аналог .forEach в JS)
names.stream().forEach(System.out::println);

// count — количество элементов
long count = names.stream().filter(n -> n.length() > 3).count(); // 2

// findFirst — первый элемент (возвращает Optional)
Optional<String> first = names.stream().filter(n -> n.startsWith("B")).findFirst();

// anyMatch / allMatch / noneMatch — проверки (аналог .some / .every в JS)
boolean hasShort = names.stream().anyMatch(n -> n.length() < 4); // true (Bob)
boolean allLong  = names.stream().allMatch(n -> n.length() > 2); // true

// reduce — свернуть в одно значение (аналог .reduce в JS)
int sum = List.of(1, 2, 3, 4, 5).stream().reduce(0, Integer::sum); // 15
```

---

## Специализированные стримы для чисел

Для `int`, `double`, `long` есть специальные стримы с удобными методами:

```java
List<Integer> nums = List.of(10, 20, 30, 40);

int sum     = nums.stream().mapToInt(Integer::intValue).sum();     // 100
double avg  = nums.stream().mapToInt(Integer::intValue).average().orElse(0); // 25.0
int max     = nums.stream().mapToInt(Integer::intValue).max().orElse(0);     // 40
```

---

## Collectors — куда собрать результат

```java
// В List
Collectors.toList()

// В Set (убирает дубликаты)
Collectors.toSet()

// В Map: имя → длина имени
Map<String, Integer> nameLength = names.stream()
    .collect(Collectors.toMap(n -> n, String::length));

// Группировка (аналог .groupBy)
Map<Integer, List<String>> byLength = names.stream()
    .collect(Collectors.groupingBy(String::length));
// { 3: ["Bob"], 5: ["Alice"], 7: ["Charlie"] }

// Соединить в строку
String joined = names.stream().collect(Collectors.joining(", ")); // "Alice, Bob, Charlie"
```

---

## Method Reference — `::` вместо лямбды

Если лямбда просто вызывает метод — можно написать короче:

```java
// Лямбда
names.stream().map(n -> n.toUpperCase())
// Method reference
names.stream().map(String::toUpperCase)

// Лямбда
names.stream().forEach(n -> System.out.println(n))
// Method reference
names.stream().forEach(System.out::println)
```

---

## Суть

> Stream API — цепочки `.filter().map().collect()` для Java-коллекций. Логика та же, что в JS, синтаксис немного другой. В Spring-коде ты будешь использовать их постоянно для обработки данных из БД.
