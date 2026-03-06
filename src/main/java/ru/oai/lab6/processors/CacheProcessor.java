package ru.oai.lab6.processors;

import ru.oai.lab6.annotations.Cache;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Обработчик аннотации {@link Cache}.
 */
public final class CacheProcessor {
    private CacheProcessor() {
    }

    /**
     * Возвращает список именованных областей кеша.
     *
     * @param targetClass анализируемый класс
     * @return список областей кеша
     */
    public static List<String> getCacheAreas(Class<?> targetClass) {
        if (targetClass == null) {
            throw new IllegalArgumentException("Класс не должен быть null.");
        }
        Cache annotation = targetClass.getAnnotation(Cache.class);
        if (annotation == null) {
            throw new IllegalArgumentException("Аннотация @Cache на классе отсутствует.");
        }
        return Arrays.asList(annotation.value());
    }

    /**
     * Возвращает человекочитаемое описание областей кеша.
     *
     * @param targetClass анализируемый класс
     * @return описание областей кеша
     */
    public static String describe(Class<?> targetClass) {
        List<String> areas = getCacheAreas(targetClass);
        if (areas.isEmpty()) {
            return "Список кешируемых областей пуст.";
        }
        return areas.stream().collect(Collectors.joining(", "));
    }

    /**
     * Имитирует активацию кеширования для заданного класса.
     *
     * @param targetClass анализируемый класс
     * @param cacheStore хранилище кеша
     */
    public static void activateCache(Class<?> targetClass, Map<String, Object> cacheStore) {
        List<String> areas = getCacheAreas(targetClass);
        if (areas.isEmpty()) {
            return;
        }
        for (String area : areas) {
            cacheStore.putIfAbsent(area, "ACTIVE");
        }
    }
}
