# Лабораторная работа №6 по Java

Проект содержит:
- все 6 задач из раздела «Аннотации»;
- все 7 тестов из раздела «Тестирование»;
- консольный интерфейс с выбором задания и задачи через `if-else`;
- проверку ввода;
- javadoc-комментарии для классов и методов.

## Структура проекта
- `src/main/java` — основной код;
- `src/test/java` — JUnit 5 тесты;
- `pom.xml` — зависимости JUnit 5 и Mockito.

## Запуск приложения
Скомпилировать и запустить главный класс `ru.oai.lab6.Main`.

## Запуск тестов
При наличии Maven:
```bash
mvn test
```

Для запуска конкретного теста:
```bash
mvn test -Dtest=ToStringProcessorTest
mvn test -Dtest=InvokeProcessorTest
mvn test -Dtest=DefaultProcessorTest
mvn test -Dtest=ValidateProcessorTest
mvn test -Dtest=CacheProcessorTest
mvn test -Dtest=TwoProcessorTest
mvn test -Dtest=CacheInvokeIntegrationTest
```
