package ru.oai.lab6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.oai.lab6.annotations.Default;
import ru.oai.lab6.demo.DefaultDemo;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Тесты для обработчика {@code @Default}.
 */
class DefaultProcessorTest {
    /**
     * Возвращает данные для параметризованного теста.
     *
     * @return поток тестовых значений
     */
    static Stream<Object[]> defaultSources() throws NoSuchFieldException {
        Field field = DefaultDemo.class.getDeclaredField("fieldWithDefault");
        return Stream.of(
                new Object[]{DefaultDemo.class, String.class},
                new Object[]{field, Integer.class}
        );
    }

    /**
     * Проверяет, что Reflection корректно возвращает аннотацию и ожидаемый класс.
     *
     * @param source класс или поле
     * @param expected ожидаемый тип
     */
    @ParameterizedTest
    @MethodSource("defaultSources")
    void defaultAnnotation_shouldReturnExpectedValue(Object source, Class<?> expected) {
        if (source instanceof Class<?> clazz) {
            Default annotation = clazz.getAnnotation(Default.class);
            assertNotNull(annotation);
            assertEquals(expected, annotation.value());
        } else if (source instanceof Field field) {
            Default annotation = field.getAnnotation(Default.class);
            assertNotNull(annotation);
            assertEquals(expected, annotation.value());
        }
    }
}
