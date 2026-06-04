# Тема 4 — Исключения

```
Текущая тема: Исключения
Раздел: Блок 0 — Java Core
Пройдено: Типы, ООП, Коллекции
Далее будет: Generics
```

---

## Зачем это нужно

В JS ошибки — обычные объекты, бросаешь что хочешь. В Java исключения — часть системы типов. Компилятор **заставит** тебя обработать некоторые из них. Это неудобно поначалу, но спасает от забытых обработчиков ошибок.

---

## Иерархия исключений

```
Throwable
├── Error          — критические ошибки JVM (OutOfMemoryError) — не трогаем
└── Exception
    ├── IOException, SQLException, ...  — checked (проверяемые)
    └── RuntimeException
        ├── NullPointerException
        ├── IllegalArgumentException
        ├── IndexOutOfBoundsException
        └── ...                        — unchecked (непроверяемые)
```

**Checked** — компилятор требует обработки (`try/catch` или `throws`).
**Unchecked (RuntimeException)** — обрабатывать не обязан, но можно.

---

## try / catch / finally

```java
try {
    int result = 10 / 0; // ArithmeticException
} catch (ArithmeticException e) {
    System.out.println("Ошибка: " + e.getMessage());
} finally {
    System.out.println("Выполняется всегда"); // как finally в JS
}
```

Несколько catch — от конкретного к общему:

```java
try {
    String s = null;
    s.length(); // NullPointerException
} catch (NullPointerException e) {
    System.out.println("Null!");
} catch (Exception e) {
    System.out.println("Что-то другое: " + e.getMessage());
}
```

---

## throw — бросить исключение

```java
public void setAge(int age) {
    if (age < 0 || age > 150) {
        throw new IllegalArgumentException("Некорректный возраст: " + age);
    }
    this.age = age;
}
```

---

## throws — объявить исключение в сигнатуре метода

Для checked-исключений: если не обрабатываешь внутри — объяви в сигнатуре:

```java
public void readFile(String path) throws IOException {
    // работа с файлом — может бросить IOException
}

// Тогда вызывающий код обязан обработать:
try {
    readFile("data.txt");
} catch (IOException e) {
    System.out.println("Файл не найден");
}
```

---

## Своё исключение

```java
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(int productId) {
        super("Продукт не найден: id=" + productId);
    }
}

// Использование
throw new ProductNotFoundException(42);
```

В реальных проектах (и в JMIX) кастомные исключения — норма. Они делают ошибки читаемыми.

---

## try-with-resources

Для ресурсов, которые нужно закрыть (файлы, соединения с БД) — автоматическое закрытие:

```java
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    String line = reader.readLine();
} catch (IOException e) {
    e.printStackTrace();
}
// reader закроется автоматически, даже если было исключение
```

Аналог `.finally()` с закрытием ресурса в Node.js.

---

## Суть

> Исключения в Java — часть системы типов. Checked-исключения компилятор заставит обработать. Unchecked — твоя ответственность. Своё исключение — чистый способ сообщить об ошибке домена.
