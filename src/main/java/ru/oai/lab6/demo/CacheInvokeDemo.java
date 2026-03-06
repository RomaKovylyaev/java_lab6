package ru.oai.lab6.demo;

import ru.oai.lab6.annotations.Cache;
import ru.oai.lab6.annotations.Invoke;

import java.util.Map;

/**
 * Класс для совместной демонстрации аннотаций {@link Cache} и {@link Invoke}.
 */
@Cache({"users", "orders"})
public class CacheInvokeDemo {
    private final Map<String, Object> fakeCache;
    private boolean invoked;

    /**
     * Создает экземпляр класса с фиктивным кешем.
     *
     * @param fakeCache фиктивное хранилище кеша
     */
    public CacheInvokeDemo(Map<String, Object> fakeCache) {
        this.fakeCache = fakeCache;
    }

    /**
     * Автоматически вызываемый метод, записывающий данные в фиктивный кеш.
     */
    @Invoke
    public void fillCache() {
        invoked = true;
        fakeCache.put("users", "loaded");
    }

    /**
     * Возвращает факт вызова метода.
     *
     * @return true, если метод был вызван
     */
    public boolean isInvoked() {
        return invoked;
    }
}
