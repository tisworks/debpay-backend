package br.com.debpay.DAO;

import br.com.debpay.Entities.User;

import java.util.List;

public interface IUserDAO {
    User get(int id);
    User get(String login);
    List<User> getAll();
    void save(User u);
    void update(User u);
    void delete(int id);
}
