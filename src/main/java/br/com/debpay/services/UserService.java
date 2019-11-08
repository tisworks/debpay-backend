package br.com.debpay.services;

import br.com.debpay.dao.IUserDAO;
import br.com.debpay.entities.User;
import br.com.debpay.util.MD5;

public class UserService implements IUserService {
  private final IUserDAO dao;
  private final String salt;

  public UserService(IUserDAO dao, String salt) {
    this.dao = dao;
    this.salt = salt;
  }

  @Override
  public int login(String login, String password) {
    var user = dao.get(login);
    if (user != null && user.getPassword().equals(MD5.hash(password, salt))) {
      return user.getId();
    }
    return 0;
  }

  @Override
  public int createUser(String login, String password) {
    dao.save(new User(login, MD5.hash(password, this.salt)));
    return login(login, password);
  }
}
