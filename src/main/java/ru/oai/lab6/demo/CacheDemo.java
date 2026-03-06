package ru.oai.lab6.demo;

import ru.oai.lab6.annotations.Cache;

/**
 * Демонстрационный класс для аннотации {@link Cache}.
 */
@Cache({"users", "orders", "products"})
public class CacheDemo {
}
