package com.example.program.Model;

public class Users {
    int id_User;

    /**
     * Функция возвращает id_User
     *
     * @return id_User
     */
    public int getId_User() {
        return id_User;
    }

    /**
     * Функция задает значение
     *
     * @param id_User id
     */
    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    /**
     * Функция возвращает login
     *
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Функция задает login
     *
     * @param login login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Функция возвращает password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Функция задает password
     *
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User " + id_User + " login=" + login + " password=" + password;
    }

    String login;
    String password;
}