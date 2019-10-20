package br.com.debpay.DAO;

import br.com.debpay.Entities.User;

public interface IUserDAO {
    User getUser(String login);
}
