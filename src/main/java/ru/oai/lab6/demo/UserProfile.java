package ru.oai.lab6.demo;

import ru.oai.lab6.annotations.Mode;
import ru.oai.lab6.annotations.ToString;

/**
 * Демонстрационный класс для аннотации {@link ToString}.
 */
@ToString
public class UserProfile {
    private final String login;
    @ToString(Mode.NO)
    private final String password;
    private final int age;

    /**
     * Создает профиль пользователя.
     *
     * @param login логин
     * @param password пароль
     * @param age возраст
     */
    public UserProfile(String login, String password, int age) {
        this.login = login;
        this.password = password;
        this.age = age;
    }

    /**
     * Возвращает логин.
     *
     * @return логин
     */
    public String getLogin() {
        return login;
    }

    /**
     * Возвращает пароль.
     *
     * @return пароль
     */
    public String getPassword() {
        return password;
    }

    /**
     * Возвращает возраст.
     *
     * @return возраст
     */
    public int getAge() {
        return age;
    }
}
