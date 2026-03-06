package ru.oai.lab6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.oai.lab6.demo.InvokeDemo;
import ru.oai.lab6.processors.InvokeProcessor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тесты для обработчика {@code @Invoke}.
 */
class InvokeProcessorTest {
    private InvokeDemo demo;

    /**
     * Подготавливает объект перед каждым тестом.
     */
    @BeforeEach
    void setUp() {
        demo = new InvokeDemo();
    }

    /**
     * Проверяет корректный автоматический вызов метода.
     */
    @Test
    void invokeAnnotatedMethods_shouldExecuteMethodWithoutErrors() {
        assertDoesNotThrow(() -> InvokeProcessor.invokeAnnotatedMethods(demo));

        List<Object> results = InvokeProcessor.invokeAnnotatedMethods(demo);

        assertTrue(demo.isInvoked());
        assertEquals(2, demo.getCounter());
        assertEquals("Метод runTask() успешно выполнен.", results.get(0));
    }
}
