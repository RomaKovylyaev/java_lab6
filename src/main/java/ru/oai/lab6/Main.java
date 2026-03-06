package ru.oai.lab6;

import ru.oai.lab6.demo.CacheDemo;
import ru.oai.lab6.demo.DefaultDemo;
import ru.oai.lab6.demo.EmptyCacheDemo;
import ru.oai.lab6.demo.TwoDemo;
import ru.oai.lab6.demo.UserProfile;
import ru.oai.lab6.demo.ValidateDemo;
import ru.oai.lab6.demo.InvokeDemo;
import ru.oai.lab6.processors.CacheProcessor;
import ru.oai.lab6.processors.DefaultProcessor;
import ru.oai.lab6.processors.InvokeProcessor;
import ru.oai.lab6.processors.ToStringProcessor;
import ru.oai.lab6.processors.TwoProcessor;
import ru.oai.lab6.processors.ValidateProcessor;
import ru.oai.lab6.util.InputHelper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Точка входа в приложение лабораторной работы №6.
 */
public class Main {
    /**
     * Запускает консольное приложение и демонстрирует все задания.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Лабораторная работа №6. Аннотации и тестирование.");
        System.out.println("Введите номер задания:");
        int zadanie = InputHelper.readInt(scanner, "> ");
        System.out.println("Введите номер задачи:");
        int zadacha = InputHelper.readInt(scanner, "> ");

        boolean valid = true;

        if (zadanie == 1) {
            if (!InputHelper.isInRange(zadacha, 1, 6)) {
                valid = false;
            } else if (zadacha == 1) {
                runTask1_1();
            } else if (zadacha == 2) {
                runTask1_2();
            } else if (zadacha == 3) {
                runTask1_3();
            } else if (zadacha == 4) {
                runTask1_4();
            } else if (zadacha == 5) {
                runTask1_5();
            } else {
                runTask1_6();
            }
        } else if (zadanie == 2) {
            if (!InputHelper.isInRange(zadacha, 1, 7)) {
                valid = false;
            } else if (zadacha == 1) {
                System.out.println("Запустите: mvn test -Dtest=ToStringProcessorTest");
            } else if (zadacha == 2) {
                System.out.println("Запустите: mvn test -Dtest=InvokeProcessorTest");
            } else if (zadacha == 3) {
                System.out.println("Запустите: mvn test -Dtest=DefaultProcessorTest");
            } else if (zadacha == 4) {
                System.out.println("Запустите: mvn test -Dtest=ValidateProcessorTest");
            } else if (zadacha == 5) {
                System.out.println("Запустите: mvn test -Dtest=CacheProcessorTest");
            } else if (zadacha == 6) {
                System.out.println("Запустите: mvn test -Dtest=TwoProcessorTest");
            } else {
                System.out.println("Запустите: mvn test -Dtest=CacheInvokeIntegrationTest");
            }
        } else {
            valid = false;
        }

        if (!valid) {
            System.out.println("Ошибка: такого задания или задачи не существует.");
        }
    }

    /**
     * Демонстрирует работу аннотации {@code @Invoke}.
     */
    private static void runTask1_1() {
        System.out.println("\nЗадание 1.1 — @Invoke");
        InvokeDemo demo = new InvokeDemo();
        List<Object> results = InvokeProcessor.invokeAnnotatedMethods(demo);
        System.out.println("Результаты вызова: " + results);
        System.out.println("Флаг invoked: " + demo.isInvoked());
        System.out.println("Счетчик: " + demo.getCounter());
    }

    /**
     * Демонстрирует работу аннотации {@code @Default}.
     */
    private static void runTask1_2() {
        System.out.println("\nЗадание 1.2 — @Default");
        System.out.println("Тип по умолчанию для класса: " + DefaultProcessor.getDefaultTypeNameFromClass(DefaultDemo.class));
        try {
            Field field = DefaultDemo.class.getDeclaredField("fieldWithDefault");
            System.out.println("Тип по умолчанию для поля: " + DefaultProcessor.getDefaultTypeNameFromField(field));
        } catch (NoSuchFieldException ex) {
            System.out.println("Ошибка доступа к полю: " + ex.getMessage());
        }
    }

    /**
     * Демонстрирует работу аннотации {@code @ToString}.
     */
    private static void runTask1_3() {
        System.out.println("\nЗадание 1.3 — @ToString");
        UserProfile profile = new UserProfile("student", "qwerty123", 19);
        System.out.println("Результат: " + ToStringProcessor.buildString(profile));
    }

    /**
     * Демонстрирует работу аннотации {@code @Validate}.
     */
    private static void runTask1_4() {
        System.out.println("\nЗадание 1.4 — @Validate");
        System.out.println("Классы для проверки: " + ValidateProcessor.describeValidatedClasses(ValidateDemo.class));
    }

    /**
     * Демонстрирует работу аннотации {@code @Two}.
     */
    private static void runTask1_5() {
        System.out.println("\nЗадание 1.5 — @Two");
        TwoProcessor.validate(TwoDemo.class);
        System.out.println("Значения аннотации: " + TwoProcessor.describe(TwoDemo.class));
    }

    /**
     * Демонстрирует работу аннотации {@code @Cache}.
     */
    private static void runTask1_6() {
        System.out.println("\nЗадание 1.6 — @Cache");
        System.out.println("Области кеша для CacheDemo: " + CacheProcessor.describe(CacheDemo.class));
        System.out.println("Области кеша для EmptyCacheDemo: " + CacheProcessor.describe(EmptyCacheDemo.class));
        Map<String, Object> cache = new HashMap<>();
        CacheProcessor.activateCache(CacheDemo.class, cache);
        System.out.println("Содержимое фиктивного кеша: " + cache);
    }
}
