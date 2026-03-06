package ru.oai.lab6.processors;

import ru.oai.lab6.annotations.Mode;
import ru.oai.lab6.annotations.ToString;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Обработчик аннотации {@link ToString}.
 */
public final class ToStringProcessor {
    private ToStringProcessor() {
    }

    /**
     * Формирует строковое представление объекта на основе аннотаций полей.
     * Поля с {@code @ToString(Mode.NO)} исключаются из результата.
     * Неаннотированные поля включаются в результат.
     *
     * @param target объект для анализа
     * @return строковое представление объекта
     */
    public static String buildString(Object target) {
        if (target == null) {
            throw new IllegalArgumentException("Объект не должен быть null.");
        }

        Class<?> clazz = target.getClass();
        List<String> parts = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            ToString annotation = field.getAnnotation(ToString.class);
            boolean include = annotation == null || annotation.value() == Mode.YES;
            if (include) {
                try {
                    field.setAccessible(true);
                    parts.add(field.getName() + "=" + field.get(target));
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException("Не удалось прочитать поле: " + field.getName(), ex);
                }
            }
        }
        StringJoiner joiner = new StringJoiner(", ");
        parts.forEach(joiner::add);
        return clazz.getSimpleName() + "{" + joiner + "}";
    }
}
