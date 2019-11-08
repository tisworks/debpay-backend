package br.com.debpay.entities;

public class User {
    private int id;
    private String login;
    private String password;

    public User(int id, String login, String password) {
        setId(id);
        setLogin(login);
        setPassword(password);
    }

    public User(String login, String password) {
        setLogin(login);
        setPassword(password);
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
