# Тема 2 — Классы и ООП

```
Текущая тема: Классы и ООП
Раздел: Блок 0 — Java Core
Пройдено: Типы данных и переменные
Далее будет: Коллекции
```

---

## Зачем это нужно

В JS классы появились в ES6 и по сути — синтаксический сахар над прототипами.
В Java классы — это основа всего. **Любой код живёт внутри класса.** Нет функций вне классов, нет скриптов — только классы.

---

## Класс и объект

```java
// Определение класса
public class Product {
    // Поля (fields) — данные объекта
    String name;
    double price;
    int stock;

    // Конструктор — вызывается при создании объекта
    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Метод — поведение объекта
    public double totalValue() {
        return price * stock;
    }
}

// Создание объекта (экземпляра класса)
Product laptop = new Product("Ноутбук", 1299.99, 5);
System.out.println(laptop.totalValue()); // 6499.95
```

> `this` — ссылка на текущий объект. Как `this` в JS-классах, но работает предсказуемо всегда.

---

## Модификаторы доступа

Явно контролируем, кто может обращаться к полю или методу:

| Модификатор | Доступ |
|-------------|--------|
| `public` | отовсюду |
| `private` | только внутри класса |
| `protected` | внутри класса и наследников |
| _(нет)_ | внутри пакета |

В хорошем коде поля — `private`, доступ через методы:

```java
public class Product {
    private String name;
    private double price;

    // Getter — читать поле
    public String getName() { return name; }

    // Setter — изменить поле
    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Цена не может быть отрицательной");
        this.price = price;
    }
}
```

Это называется **инкапсуляция** — данные скрыты, доступ только через контролируемые методы.

---

## Наследование

```java
public class DiscountedProduct extends Product {
    private double discountPercent;

    public DiscountedProduct(String name, double price, int stock, double discountPercent) {
        super(name, price, stock); // вызов конструктора родителя
        this.discountPercent = discountPercent;
    }

    // Переопределение метода родителя
    @Override
    public double totalValue() {
        double discount = super.totalValue() * discountPercent / 100;
        return super.totalValue() - discount;
    }
}
```

- `extends` — наследование (только одного класса, в отличие от JS где тоже одно, но через прототипы)
- `super` — обращение к родителю
- `@Override` — аннотация, говорит компилятору "я намеренно переопределяю метод"

---

## Интерфейс

Интерфейс — контракт. Описывает **что** умеет делать объект, но не **как**.

```java
public interface Sellable {
    double getPrice();
    boolean isAvailable();
}

public class Product implements Sellable {
    private double price;
    private int stock;

    @Override
    public double getPrice() { return price; }

    @Override
    public boolean isAvailable() { return stock > 0; }
}
```

В JS нет интерфейсов (в TS есть). В Java это фундаментальная часть архитектуры — через интерфейсы строится слабая связанность кода.

**Отличие от абстрактного класса:**
- Интерфейс: только контракт (что делать), можно реализовывать несколько
- Абстрактный класс: частичная реализация (как делать часть), только один

---

## Статические поля и методы

`static` — принадлежит классу, а не объекту:

```java
public class MathUtils {
    public static final double PI = 3.14159;

    public static double circleArea(double radius) {
        return PI * radius * radius;
    }
}

// Вызов без создания объекта
double area = MathUtils.circleArea(5.0);
```

Аналог в JS: статические методы класса или функции модуля.

---

## Суть

> В Java весь код живёт в классах. Класс описывает данные (поля) и поведение (методы). Инкапсуляция, наследование, интерфейсы — инструменты для построения понятной и устойчивой архитектуры.
