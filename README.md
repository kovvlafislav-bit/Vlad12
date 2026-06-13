# Monkey Mod — мод для Minecraft 1.20.1 (Forge)

Добавляет мирное животное — **обезьяну (Monkey)**: спавнится в лесах,
бродит, паникует при ударе, размножается сладкими ягодами. Есть яйцо призыва.

## Что нужно
- Minecraft **1.20.1**
- **Forge 47.2.0** (или совместимый 47.x)
- JDK **17**
- (для сборки) Gradle 8.1.1 — проще всего через gradle-wrapper

## Сборка
В проекте нет бинарного `gradlew` (его нельзя положить текстом). Сделай одно из двух:

**Вариант А — добавить wrapper самому (один раз):**
```bash
cd monkeymod
gradle wrapper --gradle-version 8.1.1
./gradlew build      # на Windows: gradlew build
```

**Вариант Б — взять gradlew из официального MDK:**
1. Скачай Forge MDK для 1.20.1 с files.minecraftforge.net
2. Скопируй из него файлы `gradlew`, `gradlew.bat` и папку `gradle/wrapper/gradle-wrapper.jar` в эту папку.
3. Запусти `./gradlew build`

Готовый `.jar` появится в `build/libs/monkeymod-1.0.0.jar`.
Положи его в папку `mods` клиента/сервера с установленным Forge 1.20.1.

## Запустить из среды разработки
```bash
./gradlew genIntellijRuns   # или genEclipseRuns
./gradlew runClient
```

## Как получить животное в игре
- Дай себе яйцо призыва: `/give @s monkeymod:monkey_spawn_egg`
- Или ищи обезьян в лесных биомах (спавн настроен в
  `data/monkeymod/forge/biome_modifier/spawn_monkey.json`).
- Размножение: покорми двух обезьян сладкими ягодами.

## Как переделать под своё животное
- **Имя:** `assets/monkeymod/lang/*.json` (`entity.monkeymod.monkey`).
- **Текстура:** замени `assets/monkeymod/textures/entity/monkey.png`
  (64×64; раскладка кубов задана в `MonkeyModel.createBodyLayer()`).
- **Форма/модель:** правь кубы в `MonkeyModel.java`.
- **Поведение/еда/здоровье/скорость:** `MonkeyEntity.java`
  (`registerGoals`, `isFood`, `createAttributes`).
- **Где спавнится:** `spawn_monkey.json` (поменяй тег биома, вес, количество).
- **Цвета яйца призыва:** аргументы в `ModItems.MONKEY_SPAWN_EGG`.
- **Переименовать сам мод:** modId `monkeymod` встречается в пакете
  `com.example.monkeymod`, в `mods.toml`, в путях `assets/` и `data/`,
  и в `@Mod(...)`. Меняй везде согласованно.

## Получить готовый .jar без сборки на своём ПК (через GitHub)
1. Создай бесплатный аккаунт на github.com и нажми **New repository** (любое имя, Public).
2. На странице репозитория: **Add file → Upload files**, перетащи туда
   всё содержимое этой папки (включая папку `.github`), нажми **Commit**.
3. Открой вкладку **Actions** — сборка («Build mod») запустится сама,
   подожди ~2–3 минуты до зелёной галочки.
4. Зайди в завершившийся запуск → внизу блок **Artifacts** →
   скачай **monkeymod-jar** (это zip, внутри `monkeymod-1.0.0.jar`).
5. Распакуй, положи `monkeymod-1.0.0.jar` в папку `mods` (нужен Forge 1.20.1).
