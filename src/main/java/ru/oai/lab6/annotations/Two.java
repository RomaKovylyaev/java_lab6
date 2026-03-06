package ru.oai.lab6.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация, содержащая строковое и числовое значение.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Two {
    /**
     * Возвращает строковое значение.
     *
     * @return строковое значение
     */
    String first();

    /**
     * Возвращает числовое значение.
     *
     * @return числовое значение
     */
    int second();
}
