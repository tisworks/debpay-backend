package br.com.debpay.dao;

import br.com.debpay.entities.User;

import java.util.List;

public interface IUserDAO {
  User get(int id);

  User get(String login);

  List<User> getAll();

  void save(User u);

  void update(User u);

  void delete(int id);
}
