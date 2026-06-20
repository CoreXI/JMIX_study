# Gradle

```
Текущая тема: Gradle
Раздел: Блок 1 — Инструменты
Пройдено: IntelliJ IDEA
Далее будет: PostgreSQL
```

## Зачем это нужно

Gradle — это инструмент сборки проекта. Он отвечает за:
- загрузку зависимостей (библиотек)
- компиляцию кода
- запуск тестов
- упаковку в `.jar` файл

**Аналог из Node.js:** `npm` + `package.json`. Только вместо `package.json` — файл `build.gradle`.

---

## build.gradle — главный файл

```groovy
plugins {
    id 'java'
}

group = 'com.example'
version = '1.0'

repositories {
    mavenCentral()   // откуда качать библиотеки (аналог npmjs.com)
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter:3.2.0'
    testImplementation 'org.junit.jupiter:junit-jupiter:5.10.0'
}
```

| Gradle | npm аналог |
|--------|-----------|
| `repositories { mavenCentral() }` | npmjs.com registry |
| `dependencies { implementation '...' }` | `"dependencies": {}` в package.json |
| `testImplementation` | `"devDependencies": {}` |
| `gradle build` | `npm run build` |
| `gradle test` | `npm test` |

---

## Основные команды

```bash
./gradlew build        # собрать проект
./gradlew run          # запустить
./gradlew test         # запустить тесты
./gradlew dependencies # показать дерево зависимостей
./gradlew clean        # удалить папку build/
```

> `./gradlew` (Gradle Wrapper) — это локальная версия Gradle, зашитая в проект. Не нужно устанавливать Gradle глобально.

---

## Структура папок Gradle-проекта

```
project/
├── src/
│   ├── main/
│   │   └── java/        ← production код
│   └── test/
│       └── java/        ← тесты
├── build/               ← генерируется автоматически (в .gitignore)
├── build.gradle         ← конфигурация
├── settings.gradle      ← название проекта
└── gradlew              ← Gradle Wrapper
```

---

## Как добавить зависимость

1. Найти библиотеку на [search.maven.org](https://search.maven.org)
2. Скопировать строку для Gradle
3. Вставить в блок `dependencies {}` в `build.gradle`
4. IntelliJ предложит синхронизировать — нажать **Sync**

---

## Суть в том, что...

Gradle берёт на себя всё что связано со сборкой — ты описываешь **что** нужно, он разбирается **как**. В JMIX-проектах `build.gradle` уже настроен плагином Studio — тебе нужно уметь читать его и добавлять зависимости.
