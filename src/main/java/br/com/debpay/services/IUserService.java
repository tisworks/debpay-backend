package br.com.debpay.services;

import br.com.debpay.dto.UserDTO;

public interface IUserService {
  UserDTO login(String login, String password);

  UserDTO createUser(String login, String password, String name);
}
