package br.com.debpay.entities;

public class User {
  private int id;
  private String login;
  private String password;
  private String name;

  public User(int id, String login, String password, String name) {
    setId(id);
    setLogin(login);
    setPassword(password);
    setName(name);
  }

  public User(String login, String password, String name) {
    setLogin(login);
    setPassword(password);
    setName(name);
  }

  public User() {}

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
