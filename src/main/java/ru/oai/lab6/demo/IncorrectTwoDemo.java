package ru.oai.lab6.demo;

import ru.oai.lab6.annotations.Two;

/**
 * Демонстрационный класс с некорректными значениями аннотации {@link Two}.
 */
@Two(first = "", second = -1)
public class IncorrectTwoDemo {
}
