package br.com.debpay.services;

public interface IUserService {
  int login(String login, String password);

  int createUser(String login, String password);
}
