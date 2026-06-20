# Задание — Gradle

## Задание: Разобраться со сборкой проекта

**Цель:** Научиться читать `build.gradle`, добавлять зависимости и запускать сборку из командной строки.

**Что нужно сделать:**

1. Открой `JMIX_study.iml` — найди откуда IntelliJ берёт настройки проекта
2. Создай новый Gradle-проект через IntelliJ: **File → New → Project → Gradle → Java**
3. В созданном проекте найди `build.gradle` и изучи его структуру
4. Добавь зависимость в `dependencies {}`:
   ```groovy
   implementation 'com.google.code.gson:gson:2.10.1'
   ```
5. Синхронизируй проект (IntelliJ покажет кнопку **Sync**)
6. Убедись что в панели **External Libraries** появился `gson`
7. Запусти из терминала:
   ```bash
   ./gradlew build
   ```

**Задание выполнено, если:**
- [ ] Gradle-проект создан и открывается без ошибок
- [ ] Зависимость `gson` добавлена и видна в External Libraries
- [ ] `./gradlew build` завершился с `BUILD SUCCESSFUL`
- [ ] Понимаешь разницу между `implementation` и `testImplementation`

**Подсказка:** Если `./gradlew` не запускается — проверь права: `chmod +x gradlew`.
