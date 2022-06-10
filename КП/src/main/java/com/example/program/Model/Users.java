package com.example.program.Model;

public class Users implements Entity {
    int id_User;
    /**
     * Функия возвращает id_User
     * @return id_User
     */
    public int getId_User() {
        return id_User;
    }

    /**
     * Функия задает значение
     * @param id_User id
     */
    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    /**
     * Функия возвращает login
     * @return login
     */
    public String getLogin() {
        return login;
    }
    /**
     * Функия задает login
     * @param  login login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Функия возвращает password
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Функия задает password
     * @param  password password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString(){
        return "User "+id_User+" login="+login+" passsword="+password;
    }

    @Override
    public void PrintEntity() {
        System.out.println(this.toString());
    }
    /**
     * функция проверки пустой ли пользователь
     * @return результат
     */
    @Override
    public boolean isEmpty() {
        if(id_User==0){
            return true;
        }
        return false;
    }

    String login;
    String password;
}
