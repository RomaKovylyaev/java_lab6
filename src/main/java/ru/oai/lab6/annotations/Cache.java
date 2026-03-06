package ru.oai.lab6.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для хранения списка кешируемых областей.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Cache {
    /**
     * Возвращает список именованных областей кеша.
     *
     * @return массив имен областей
     */
    String[] value() default {};
}
