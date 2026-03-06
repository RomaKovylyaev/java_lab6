package ru.oai.lab6;

import org.junit.jupiter.api.Test;
import ru.oai.lab6.demo.UserProfile;
import ru.oai.lab6.processors.ToStringProcessor;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тесты для обработчика {@code @ToString}.
 */
class ToStringProcessorTest {
    /**
     * Проверяет, что в строку попадают только допустимые поля.
     */
    @Test
    void buildString_shouldIncludeAllowedFieldsAndExcludeForbiddenField() {
        UserProfile profile = new UserProfile("student", "secret", 20);

        String result = ToStringProcessor.buildString(profile);

        assertTrue(result.contains("login=student"));
        assertTrue(result.contains("age=20"));
        assertFalse(result.contains("password=secret"));
    }
}
