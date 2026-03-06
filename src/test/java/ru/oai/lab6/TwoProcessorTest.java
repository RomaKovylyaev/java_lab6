package ru.oai.lab6;

import org.junit.jupiter.api.Test;
import ru.oai.lab6.demo.IncorrectTwoDemo;
import ru.oai.lab6.processors.TwoProcessor;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Тесты для обработчика {@code @Two}.
 */
class TwoProcessorTest {
    /**
     * Проверяет выброс исключения при некорректных значениях аннотации.
     */
    @Test
    void validate_shouldThrowWhenAnnotationValuesAreIncorrect() {
        assertThrows(IllegalArgumentException.class,
                () -> TwoProcessor.validate(IncorrectTwoDemo.class));
    }
}
