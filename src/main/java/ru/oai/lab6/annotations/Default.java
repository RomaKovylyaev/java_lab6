package ru.oai.lab6.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для задания типа по умолчанию.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Default {
    /**
     * Возвращает тип по умолчанию.
     *
     * @return класс по умолчанию
     */
    Class<?> value();
}
