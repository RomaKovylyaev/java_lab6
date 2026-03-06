package ru.oai.lab6.processors;

import ru.oai.lab6.annotations.Invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Обработчик аннотации {@link Invoke}.
 */
public final class InvokeProcessor {
    private InvokeProcessor() {
    }

    /**
     * Находит и вызывает все методы экземпляра, помеченные аннотацией {@link Invoke}.
     *
     * @param target целевой объект
     * @return список результатов вызванных методов; для void-методов добавляется {@code null}
     */
    public static List<Object> invokeAnnotatedMethods(Object target) {
        if (target == null) {
            throw new IllegalArgumentException("Целевой объект не должен быть null.");
        }

        List<Object> results = new ArrayList<>();
        Method[] methods = target.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                if (method.getParameterCount() != 0) {
                    throw new IllegalStateException("Метод с @Invoke не должен иметь параметров: " + method.getName());
                }
                try {
                    method.setAccessible(true);
                    results.add(method.invoke(target));
                } catch (IllegalAccessException | InvocationTargetException ex) {
                    throw new RuntimeException("Ошибка при вызове метода: " + method.getName(), ex);
                }
            }
        }
        return results;
    }
}
