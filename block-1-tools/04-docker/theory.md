# Docker

```
Текущая тема: Docker
Раздел: Блок 1 — Инструменты
Пройдено: IntelliJ IDEA, Gradle, PostgreSQL
Далее будет: Блок 2 — Spring Boot
```

## Зачем это нужно

Docker позволяет запускать приложения в изолированных контейнерах. Для разработки это означает: не нужно устанавливать PostgreSQL локально — запускаешь контейнер, работаешь, останавливаешь.

**Аналог:** представь что контейнер — это лёгкая виртуальная машина, которая запускается за секунды и содержит только то, что нужно.

---

## Ключевые понятия

| Понятие | Что это |
|---------|---------|
| **Image** | Шаблон (рецепт) — описание что должно быть в контейнере |
| **Container** | Запущенный экземпляр image |
| **Docker Hub** | Реестр готовых image (как npmjs, но для контейнеров) |
| **Volume** | Папка на твоём компьютере, примонтированная в контейнер |
| **Port mapping** | Проброс порта из контейнера на твой компьютер |

---

## Запуск PostgreSQL через Docker

```bash
docker run -d \
  --name postgres-dev \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=secret \
  -e POSTGRES_DB=jmix_study \
  -p 5432:5432 \
  postgres:16
```

Что здесь происходит:
- `-d` — запустить в фоне
- `--name postgres-dev` — имя контейнера
- `-e` — переменные окружения (логин, пароль, имя БД)
- `-p 5432:5432` — порт контейнера → порт на твоём компьютере
- `postgres:16` — image PostgreSQL версии 16

---

## Основные команды

```bash
docker ps                        # список запущенных контейнеров
docker ps -a                     # все контейнеры (включая остановленные)
docker stop postgres-dev         # остановить контейнер
docker start postgres-dev        # запустить снова
docker rm postgres-dev           # удалить контейнер
docker logs postgres-dev         # посмотреть логи

# зайти в контейнер и открыть psql
docker exec -it postgres-dev psql -U postgres -d jmix_study
```

---

## docker-compose — запуск нескольких сервисов

В реальных проектах используют `docker-compose.yml` чтобы запускать несколько контейнеров одной командой:

```yaml
# docker-compose.yml
version: '3.8'
services:
  postgres:
    image: postgres:16
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: secret
      POSTGRES_DB: jmix_study
    ports:
      - "5432:5432"
    volumes:
      - postgres-data:/var/lib/postgresql/data

volumes:
  postgres-data:
```

```bash
docker-compose up -d     # запустить
docker-compose down      # остановить
```

`volumes` здесь сохраняет данные между перезапусками контейнера.

---

## Суть в том, что...

Docker решает проблему "у меня работает, у тебя нет" — окружение одинаковое везде. Для разработки главное: уметь запустить PostgreSQL в контейнере и подключиться к нему из Spring-приложения.
