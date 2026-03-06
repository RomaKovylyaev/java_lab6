package ru.oai.lab6;

import org.junit.jupiter.api.Test;
import ru.oai.lab6.demo.CacheInvokeDemo;
import ru.oai.lab6.demo.EmptyCacheDemo;
import ru.oai.lab6.processors.CacheProcessor;
import ru.oai.lab6.processors.InvokeProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Интеграционные тесты для совместной работы {@code @Cache} и {@code @Invoke}.
 */
class CacheInvokeIntegrationTest {
    /**
     * Проверяет совместную работу аннотаций на одном классе.
     */
    @Test
    void cacheAndInvoke_shouldWorkTogether() {
        Map<String, Object> fakeCache = new HashMap<>();
        CacheInvokeDemo demo = new CacheInvokeDemo(fakeCache);

        List<String> areas = CacheProcessor.getCacheAreas(CacheInvokeDemo.class);
        CacheProcessor.activateCache(CacheInvokeDemo.class, fakeCache);
        InvokeProcessor.invokeAnnotatedMethods(demo);

        assertEquals(List.of("users", "orders"), areas);
        assertTrue(demo.isInvoked());
        assertEquals("loaded", fakeCache.get("users"));
        assertEquals("ACTIVE", fakeCache.get("orders"));
    }

    /**
     * Проверяет, что при пустом массиве аннотации кеш не активируется.
     */
    @Test
    void cacheAndInvoke_shouldNotActivateCacheWhenAreasEmpty() {
        Map<String, Object> fakeCache = new HashMap<>();

        CacheProcessor.activateCache(EmptyCacheDemo.class, fakeCache);

        assertTrue(fakeCache.isEmpty());
    }
}
