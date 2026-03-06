package ru.oai.lab6.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация, управляющая участием типа или поля в строковом представлении.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface ToString {
    /**
     * Возвращает режим показа.
     *
     * @return режим показа
     */
    Mode value() default Mode.YES;
}
