package ru.oai.lab6.demo;

import ru.oai.lab6.annotations.Invoke;

/**
 * Демонстрационный класс для аннотации {@link Invoke}.
 */
public class InvokeDemo {
    private boolean invoked;
    private int counter;

    /**
     * Автоматически вызываемый метод.
     *
     * @return сообщение о выполнении
     */
    @Invoke
    public String runTask() {
        invoked = true;
        counter++;
        return "Метод runTask() успешно выполнен.";
    }

    /**
     * Обычный метод без аннотации.
     */
    public void helper() {
        counter += 10;
    }

    /**
     * Возвращает факт вызова аннотированного метода.
     *
     * @return true, если метод был вызван
     */
    public boolean isInvoked() {
        return invoked;
    }

    /**
     * Возвращает значение счетчика.
     *
     * @return значение счетчика
     */
    public int getCounter() {
        return counter;
    }
}
