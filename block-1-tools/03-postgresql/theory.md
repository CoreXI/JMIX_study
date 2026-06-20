# PostgreSQL

```
Текущая тема: PostgreSQL
Раздел: Блок 1 — Инструменты
Пройдено: IntelliJ IDEA, Gradle
Далее будет: Docker — запуск PostgreSQL в контейнере
```

## Зачем это нужно

PostgreSQL — реляционная база данных, которую используют большинство JMIX-проектов. Spring Data JPA и JMIX работают поверх неё.

**Аналог из Node.js:** если работал с MySQL или PostgreSQL через Sequelize/Prisma — концепции те же. Если только с MongoDB — будет небольшая перестройка мышления.

---

## Ключевые концепции

### Таблицы и строки
В реляционной БД данные хранятся в **таблицах** (аналог коллекций в MongoDB, но со строгой схемой):

```sql
-- таблица сотрудников
CREATE TABLE employee (
    id        BIGSERIAL PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    department VARCHAR(100),
    salary    NUMERIC(10, 2)
);
```

### Основные типы данных

| PostgreSQL | Java | Описание |
|-----------|------|----------|
| `BIGSERIAL` | `Long` | автоинкремент ID |
| `VARCHAR(n)` | `String` | строка до n символов |
| `TEXT` | `String` | строка без ограничений |
| `INTEGER` | `Integer` | целое число |
| `NUMERIC(p,s)` | `BigDecimal` | число с точностью |
| `BOOLEAN` | `Boolean` | true/false |
| `TIMESTAMP` | `LocalDateTime` | дата и время |

---

## Базовые SQL-команды

```sql
-- создать запись
INSERT INTO employee (name, department, salary)
VALUES ('Иван', 'IT', 85000);

-- получить все записи
SELECT * FROM employee;

-- фильтрация
SELECT name, salary FROM employee
WHERE department = 'IT' AND salary > 70000;

-- обновить
UPDATE employee SET salary = 90000 WHERE name = 'Иван';

-- удалить
DELETE FROM employee WHERE id = 1;

-- группировка (аналог groupingBy в Stream API)
SELECT department, COUNT(*), AVG(salary)
FROM employee
GROUP BY department;
```

---

## Связи между таблицами

```sql
CREATE TABLE department (
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE employee (
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(255),
    department_id BIGINT REFERENCES department(id)  -- внешний ключ
);

-- JOIN: получить сотрудников с названием отдела
SELECT e.name, d.name AS department
FROM employee e
JOIN department d ON e.department_id = d.id;
```

---

## Подключение из Java (через Spring)

В `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=postgres
spring.datasource.password=secret
```

---

## Суть в том, что...

PostgreSQL хранит данные в таблицах со строгой схемой. SQL — язык запросов к этим данным. В JMIX ты редко пишешь SQL вручную — JPA делает это за тебя, но понимать что происходит "под капотом" обязательно.
