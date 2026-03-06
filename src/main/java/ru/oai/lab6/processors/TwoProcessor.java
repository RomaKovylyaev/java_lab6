package ru.oai.lab6.processors;

import ru.oai.lab6.annotations.Two;

/**
 * Обработчик аннотации {@link Two}.
 */
public final class TwoProcessor {
    private TwoProcessor() {
    }

    /**
     * Считывает аннотацию и возвращает текстовое описание значений.
     *
     * @param targetClass анализируемый класс
     * @return строка с двумя значениями из аннотации
     */
    public static String describe(Class<?> targetClass) {
        Two annotation = getAnnotation(targetClass);
        return "first='" + annotation.first() + "', second=" + annotation.second();
    }

    /**
     * Проверяет корректность значений аннотации.
     *
     * @param targetClass анализируемый класс
     */
    public static void validate(Class<?> targetClass) {
        Two annotation = getAnnotation(targetClass);
        if (annotation.first() == null || annotation.first().isBlank()) {
            throw new IllegalArgumentException("Свойство first не должно быть пустым.");
        }
        if (annotation.second() < 0) {
            throw new IllegalArgumentException("Свойство second не должно быть отрицательным.");
        }
    }

    private static Two getAnnotation(Class<?> targetClass) {
        if (targetClass == null) {
            throw new IllegalArgumentException("Класс не должен быть null.");
        }
        Two annotation = targetClass.getAnnotation(Two.class);
        if (annotation == null) {
            throw new IllegalArgumentException("Аннотация @Two на классе отсутствует.");
        }
        return annotation;
    }
}
