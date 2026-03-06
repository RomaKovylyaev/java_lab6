package ru.oai.lab6.processors;

import ru.oai.lab6.annotations.Validate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Обработчик аннотации {@link Validate}.
 */
public final class ValidateProcessor {
    private ValidateProcessor() {
    }

    /**
     * Извлекает список классов из аннотации {@link Validate}.
     *
     * @param targetClass анализируемый класс
     * @return список классов, указанных в аннотации
     */
    public static List<Class<?>> getValidatedClasses(Class<?> targetClass) {
        if (targetClass == null) {
            throw new IllegalArgumentException("Класс не должен быть null.");
        }
        Validate annotation = targetClass.getAnnotation(Validate.class);
        if (annotation == null) {
            throw new IllegalArgumentException("Аннотация @Validate на классе отсутствует.");
        }
        Class<?>[] values = annotation.value();
        if (values.length == 0) {
            throw new IllegalArgumentException("Список классов для валидации пуст.");
        }
        return Arrays.asList(values);
    }

    /**
     * Возвращает список имен классов из аннотации в удобном для вывода формате.
     *
     * @param targetClass анализируемый класс
     * @return список имен классов
     */
    public static String describeValidatedClasses(Class<?> targetClass) {
        return getValidatedClasses(targetClass).stream()
                .map(Class::getName)
                .collect(Collectors.joining(", "));
    }
}
