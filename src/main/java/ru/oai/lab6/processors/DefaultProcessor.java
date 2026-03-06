package ru.oai.lab6.processors;

import ru.oai.lab6.annotations.Default;

import java.lang.reflect.Field;

/**
 * Обработчик аннотации {@link Default}.
 */
public final class DefaultProcessor {
    private DefaultProcessor() {
    }

    /**
     * Возвращает имя класса, указанного в аннотации на типе.
     *
     * @param targetClass класс для анализа
     * @return имя класса из аннотации
     */
    public static String getDefaultTypeNameFromClass(Class<?> targetClass) {
        if (targetClass == null) {
            throw new IllegalArgumentException("Класс не должен быть null.");
        }
        Default annotation = targetClass.getAnnotation(Default.class);
        if (annotation == null) {
            throw new IllegalArgumentException("Аннотация @Default на классе отсутствует.");
        }
        return annotation.value().getName();
    }

    /**
     * Возвращает имя класса, указанного в аннотации на поле.
     *
     * @param field поле для анализа
     * @return имя класса из аннотации
     */
    public static String getDefaultTypeNameFromField(Field field) {
        if (field == null) {
            throw new IllegalArgumentException("Поле не должно быть null.");
        }
        Default annotation = field.getAnnotation(Default.class);
        if (annotation == null) {
            throw new IllegalArgumentException("Аннотация @Default на поле отсутствует.");
        }
        return annotation.value().getName();
    }
}
