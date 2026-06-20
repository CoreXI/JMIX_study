# Задание — Docker

## Задание: Запустить PostgreSQL в контейнере

**Цель:** Поднять PostgreSQL через Docker и подключиться к нему — без локальной установки.

**Что нужно сделать:**

1. Установи Docker Desktop если ещё не установлен
2. Запусти PostgreSQL контейнером:
   ```bash
   docker run -d \
     --name postgres-dev \
     -e POSTGRES_USER=postgres \
     -e POSTGRES_PASSWORD=secret \
     -e POSTGRES_DB=jmix_study \
     -p 5432:5432 \
     postgres:16
   ```
3. Убедись что контейнер запущен: `docker ps`
4. Подключись к базе через psql внутри контейнера:
   ```bash
   docker exec -it postgres-dev psql -U postgres -d jmix_study
   ```
5. Выполни SQL из задания по PostgreSQL (создай таблицу `employee`, добавь записи)
6. Создай файл `docker-compose.yml` в корне проекта с конфигурацией PostgreSQL
7. Останови контейнер и подними через `docker-compose up -d` — убедись что данные сохранились (volume)

**Задание выполнено, если:**
- [ ] `docker ps` показывает запущенный `postgres-dev`
- [ ] Удалось подключиться через `docker exec` и выполнить SQL
- [ ] `docker-compose.yml` создан и `docker-compose up -d` работает
- [ ] После `docker-compose down` и `docker-compose up -d` данные в таблице сохранились

**Подсказка:** Если порт 5432 уже занят локальным PostgreSQL — измени маппинг на `-p 5433:5432` и подключайся на порт 5433.
