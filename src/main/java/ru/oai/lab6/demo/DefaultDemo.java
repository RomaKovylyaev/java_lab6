package ru.oai.lab6.demo;

import ru.oai.lab6.annotations.Default;

/**
 * Демонстрационный класс для аннотации {@link Default}.
 */
@Default(String.class)
public class DefaultDemo {
    @Default(Integer.class)
    private Object fieldWithDefault;

    /**
     * Возвращает поле, аннотированное {@link Default}.
     *
     * @return значение поля
     */
    public Object getFieldWithDefault() {
        return fieldWithDefault;
    }
}
