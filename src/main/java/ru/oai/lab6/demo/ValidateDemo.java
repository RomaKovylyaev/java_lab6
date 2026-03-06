package ru.oai.lab6.demo;

import ru.oai.lab6.annotations.Validate;

/**
 * Демонстрационный класс для аннотации {@link Validate}.
 */
@Validate({String.class, Integer.class, UserProfile.class})
public class ValidateDemo {
}
