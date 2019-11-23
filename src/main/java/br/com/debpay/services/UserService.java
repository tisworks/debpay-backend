package br.com.debpay.services;

import br.com.debpay.dao.IUserDAO;
import br.com.debpay.dto.UserDTO;
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
  public UserDTO login(String login, String password) {
    var user = dao.get(login);
    if (user != null && user.getPassword().equals(MD5.hash(password, salt))) {
      var dto = new UserDTO();
      dto.setId(user.getId());
      dto.setLogin(user.getLogin());
      dto.setName(user.getName());
      return dto;
    }
    return null;
  }

  @Override
  public UserDTO createUser(String login, String password, String name) {
    dao.save(new User(login, MD5.hash(password, this.salt), name));
    return login(login, password);
  }
}
