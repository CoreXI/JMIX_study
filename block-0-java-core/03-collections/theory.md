# Тема 3 — Коллекции

```
Текущая тема: Коллекции
Раздел: Блок 0 — Java Core
Пройдено: Типы данных, Классы и ООП
Далее будет: Исключения
```

---

## Зачем это нужно

В JS для всего хватает `Array` и `Object`. В Java коллекции — это целая иерархия классов, каждый из которых оптимален для своей задачи. Нужно знать три основных: `List`, `Map`, `Set`.

---

## List — упорядоченный список

Аналог массива в JS. Хранит элементы в порядке добавления, допускает дубликаты.

```java
import java.util.ArrayList;
import java.util.List;

List<String> names = new ArrayList<>();

names.add("Alice");
names.add("Bob");
names.add("Alice"); // дубликат — допустим

System.out.println(names.get(0));   // Alice
System.out.println(names.size());   // 3
names.remove("Bob");

// Перебор
for (String name : names) {
    System.out.println(name);
}
```

> `List` — интерфейс. `ArrayList` — реализация (как динамический массив). Есть ещё `LinkedList`, но для старта ArrayList покрывает 90% случаев.

---

## Map — ключ-значение

Аналог объекта `{}` или `Map` в JS. Хранит пары ключ → значение.

```java
import java.util.HashMap;
import java.util.Map;

Map<String, Integer> scores = new HashMap<>();

scores.put("Alice", 95);
scores.put("Bob", 87);
scores.put("Alice", 99); // перезапишет предыдущее значение

System.out.println(scores.get("Alice"));        // 99
System.out.println(scores.containsKey("Bob"));  // true
System.out.println(scores.getOrDefault("Eve", 0)); // 0 — если ключа нет

// Перебор
for (Map.Entry<String, Integer> entry : scores.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

---

## Set — уникальные элементы

Коллекция без дубликатов. Порядок не гарантирован.

```java
import java.util.HashSet;
import java.util.Set;

Set<String> tags = new HashSet<>();

tags.add("java");
tags.add("spring");
tags.add("java"); // дубликат — проигнорируется

System.out.println(tags.size());           // 2
System.out.println(tags.contains("java")); // true
```

Используй Set когда важна **уникальность**, а не порядок.

---

## Обобщённое правило выбора

| Задача | Коллекция |
|--------|-----------|
| Список с дубликатами, важен порядок | `List` (ArrayList) |
| Ключ → значение | `Map` (HashMap) |
| Только уникальные значения | `Set` (HashSet) |
| Список с сортировкой | `TreeSet` / `TreeMap` |

---

## Типизация коллекций

Коллекции в Java **типизированы** — в угловых скобках указываешь тип:

```java
List<String>            // список строк
List<Integer>           // список чисел (не int — обёртка!)
Map<String, Product>    // строка → объект Product
List<List<String>>      // список списков
```

Попытка добавить не тот тип — ошибка компиляции. Это и есть смысл дженериков (подробнее — тема 5).

---

## Неизменяемые коллекции

```java
List<String> fixed = List.of("a", "b", "c");   // нельзя добавить/удалить
Map<String, Integer> config = Map.of("timeout", 30, "retries", 3);
```

`List.of()` / `Map.of()` — фабричные методы (Java 9+). Для конфигураций и констант.

---

## Суть

> Три кита: `List` — упорядоченный список, `Map` — ключ-значение, `Set` — уникальные элементы. Все типизированы — компилятор знает что внутри.
