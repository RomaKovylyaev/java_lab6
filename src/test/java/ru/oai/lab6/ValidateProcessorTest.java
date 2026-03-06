package ru.oai.lab6;

import org.junit.jupiter.api.Test;
import ru.oai.lab6.demo.EmptyValidateDemo;
import ru.oai.lab6.demo.UserProfile;
import ru.oai.lab6.demo.ValidateDemo;
import ru.oai.lab6.processors.ValidateProcessor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тесты для обработчика {@code @Validate}.
 */
class ValidateProcessorTest {
    /**
     * Проверяет корректное извлечение массива типов.
     */
    @Test
    void getValidatedClasses_shouldReturnAnnotationValues() {
        List<Class<?>> classes = ValidateProcessor.getValidatedClasses(ValidateDemo.class);

        assertEquals(3, classes.size());
        assertTrue(classes.contains(String.class));
        assertTrue(classes.contains(Integer.class));
        assertTrue(classes.contains(UserProfile.class));
    }

    /**
     * Проверяет выброс исключения при пустом массиве типов.
     */
    @Test
    void getValidatedClasses_shouldThrowWhenAnnotationArrayIsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> ValidateProcessor.getValidatedClasses(EmptyValidateDemo.class));
    }
}
