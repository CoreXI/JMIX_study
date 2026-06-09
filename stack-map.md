# Карта стека: путь к Junior JMIX-разработчику

## Контекст

Старт: **Middle Node.js разработчик**
Цель: **Junior JMIX (Java) разработчик**

Что переносится из Node.js без изучения:
- Понимание серверной логики (request/response, middleware, роутинг)
- Работа с БД (модели, связи, запросы)
- REST API (эндпоинты, JSON, HTTP-статусы)
- Git и базовые инструменты разработчика

---

## Блок 0 — Java Core
> Аналог: знание JavaScript. Быстрый прогон, акцент на отличиях от JS.

- [x] Типы данных и переменные (строгая типизация vs динамическая)
- [x] Классы и объекты (class в Java vs class в JS)
- [x] ООП: наследование, интерфейсы, абстрактные классы
- [x] Коллекции: List, Map, Set (аналог Array и Object в JS)
- [x] Исключения: try/catch, checked vs unchecked
- [ ] Generics: `List<String>` — зачем нужны типы-параметры
- [ ] Stream API: фильтрация и трансформация коллекций (аналог .filter/.map в JS)

---

## Блок 1 — Инструменты
> Часть уже знакома. Проходим только новое.

- [ ] IntelliJ IDEA — среда разработки, горячие клавиши, структура проекта
- [ ] Gradle — сборщик проекта (аналог npm/package.json)
- [ ] PostgreSQL — реляционная БД (если не работал плотно)
- [ ] Docker — запуск PostgreSQL локально в контейнере

---

## Блок 2 — Spring Boot
> Аналог: Express/Fastify, но фреймворк управляет твоим кодом, а не наоборот.

### 2.1 IoC и Dependency Injection
- [ ] Что такое Inversion of Control — ключевая ментальная перестройка
- [ ] Spring-контекст: как фреймворк собирает приложение
- [ ] Аннотации: `@Component`, `@Service`, `@Repository`, `@Controller`
- [ ] `@Autowired` — как Spring внедряет зависимости

### 2.2 Spring MVC / REST
- [ ] `@RestController`, `@GetMapping`, `@PostMapping`
- [ ] `@RequestBody`, `@PathVariable`, `@RequestParam`
- [ ] ResponseEntity — управление HTTP-ответом
- [ ] Первый рабочий REST API на Spring Boot

### 2.3 Конфигурация
- [ ] `application.properties` / `application.yml`
- [ ] Профили (`dev`, `prod`)
- [ ] `@Value`, `@ConfigurationProperties`

---

## Блок 3 — Spring Data JPA
> Аналог: Sequelize / Prisma, но ORM на основе Hibernate.

- [ ] Что такое ORM и зачем он нужен
- [ ] `@Entity`, `@Table`, `@Column` — маппинг класса на таблицу БД
- [ ] `@Id`, `@GeneratedValue` — первичный ключ
- [ ] Связи: `@OneToMany`, `@ManyToOne`, `@ManyToMany`
- [ ] `JpaRepository` — готовые методы CRUD без написания SQL
- [ ] Методы по имени: `findByEmail`, `findAllByStatus`
- [ ] `@Query` — кастомные JPQL-запросы
- [ ] Транзакции: `@Transactional`

---

## Блок 4 — Spring Security (базово)
> Нужен для понимания JMIX Security. Проходим только суть.

- [ ] Аутентификация vs авторизация — разница понятий
- [ ] Как Spring Security встраивается в цепочку запроса
- [ ] Роли и права: `@PreAuthorize`, `hasRole()`
- [ ] JWT-токены (базово) — если знакомо по Node.js, будет быстро

---

## Блок 5 — JMIX Framework
> Нет аналога в Node.js-мире. Изучаем с нуля.

### 5.1 Архитектура
- [ ] Что такое JMIX и какую задачу он решает
- [ ] Структура JMIX-проекта
- [ ] Studio плагин для IntelliJ IDEA
- [ ] Add-ons: что это и как подключать

### 5.2 Data Model
- [ ] JmixEntity vs обычный JPA Entity
- [ ] MetaClass, MetaProperty — зачем нужна метамодель
- [ ] Аудит: `@CreatedDate`, `@LastModifiedBy` и встроенные трейты
- [ ] Soft delete — "мягкое" удаление записей

### 5.3 UI (Vaadin-based)
- [ ] Концепция серверного UI — чем отличается от React/Vue
- [ ] Views и Fragments
- [ ] Стандартные компоненты: DataGrid, Form, ComboBox
- [ ] Data Binding: как UI подключается к данным
- [ ] Actions и события

### 5.4 Security
- [ ] Роли в JMIX: Resource Role vs Row-level Role
- [ ] Политики доступа к Entity и атрибутам
- [ ] Управление через UI vs код

### 5.5 Business Logic
- [ ] Services: где писать бизнес-логику
- [ ] Events: реакция на события жизненного цикла Entity
- [ ] Bean Validation: `@NotNull`, `@Size` и кастомные валидаторы

---

## Итоговый проект

Самостоятельно создать JMIX-приложение с нуля:
- [ ] Спроектировать Data Model (3-5 сущностей со связями)
- [ ] Настроить роли и права доступа
- [ ] Реализовать бизнес-логику через Service
- [ ] Покрыть основные CRUD-операции через UI
- [ ] Задеплоить локально через Docker

---

## Прогресс

| Блок | Статус |
|------|--------|
| 0 — Java Core | 5/7 — в процессе |
| 1 — Инструменты | не начат |
| 2 — Spring Boot | не начат |
| 3 — Spring Data JPA | не начат |
| 4 — Spring Security | не начат |****
| 5 — JMIX Framework | не начат |
| Итоговый проект | не начат |
