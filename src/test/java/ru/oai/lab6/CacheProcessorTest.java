package ru.oai.lab6;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.oai.lab6.demo.CacheDemo;
import ru.oai.lab6.demo.EmptyCacheDemo;
import ru.oai.lab6.processors.CacheProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Тесты для обработчика {@code @Cache}.
 */
class CacheProcessorTest {
    /**
     * Проверяет корректное чтение нескольких областей кеша.
     */
    @Test
    void getCacheAreas_shouldReturnSeveralNamedAreas() {
        List<String> areas = CacheProcessor.getCacheAreas(CacheDemo.class);

        assertEquals(List.of("users", "orders", "products"), areas);
    }

    /**
     * Проверяет, что при пустом массиве кеширование не производится.
     */
    @Test
    void activateCache_shouldNotCacheWhenAreasAreEmpty() {
        @SuppressWarnings("unchecked")
        Map<String, Object> cacheStore = Mockito.mock(Map.class);

        CacheProcessor.activateCache(EmptyCacheDemo.class, cacheStore);

        verify(cacheStore, never()).putIfAbsent(anyString(), eq("ACTIVE"));
    }

    /**
     * Проверяет активацию кеша для нескольких областей.
     */
    @Test
    void activateCache_shouldFillMultipleAreas() {
        Map<String, Object> cacheStore = new HashMap<>();

        CacheProcessor.activateCache(CacheDemo.class, cacheStore);

        assertEquals(3, cacheStore.size());
        assertTrue(cacheStore.containsKey("users"));
        assertTrue(cacheStore.containsKey("orders"));
        assertTrue(cacheStore.containsKey("products"));
    }
}
