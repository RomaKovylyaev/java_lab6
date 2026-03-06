package ru.oai.lab6.util;

import java.util.Scanner;

/**
 * Вспомогательный класс для безопасного чтения пользовательского ввода.
 */
public final class InputHelper {
    private InputHelper() {
    }

    /**
     * Считывает целое число с консоли с проверкой корректности.
     *
     * @param scanner сканер
     * @param prompt текст приглашения
     * @return введенное целое число
     */
    public static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }

    /**
     * Проверяет, что число находится в заданном диапазоне.
     *
     * @param value значение
     * @param min минимально допустимое значение
     * @param max максимально допустимое значение
     * @return true, если число входит в диапазон
     */
    public static boolean isInRange(int value, int min, int max) {
        return value >= min && value <= max;
    }
}
