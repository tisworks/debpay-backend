package br.com.debpay.dao;

import br.com.debpay.entities.User;
import br.com.debpay.infrastructure.SQLDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
  private final SQLDatabase database;

  public UserDAO(SQLDatabase database) {
    this.database = database;
  }

  @Override
  public User get(int id) {
    var query = "SELECT * from users";

    try {
      var stm = database.getConnection().prepareStatement(query);
      stm.setInt(1, id);
      var rs = stm.executeQuery();
      if (rs.next()) {
        return new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"));
      }
    } catch (SQLException e) {
      // TODO improve it
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public User get(String login) {
    var query = "SELECT * from users";

    try {
      var stm = database.getConnection().prepareStatement(query);
      stm.setString(1, login);
      var rs = stm.executeQuery();
      if (rs.next()) {
        return new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"));
      }
    } catch (SQLException e) {
      // TODO improve it
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public List<User> getAll() {
    var query = "SELECT * from users";
    var result = new ArrayList<User>();

    try {
      var stm = database.getConnection().prepareStatement(query);
      var rs = stm.executeQuery();
      while (rs.next()) {
        result.add(new User(rs.getInt("id"), rs.getString("login"), rs.getString("password")));
      }
    } catch (SQLException e) {
      // TODO improve it
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public void save(User u) {
    var query = "INSERT INTO users (login, password) VALUES (?, ?)";

    try {
      var stm = database.getConnection().prepareStatement(query);
      stm.setString(1, u.getLogin());
      stm.setString(2, u.getPassword());
      stm.executeUpdate();
    } catch (SQLException e) {
      // TODO improve it
      e.printStackTrace();
    }
  }

  @Override
  public void update(User u) {
    var query = "UPDATE users SET login = ?, password = ? WHERE id = ?";

    try {
      var stm = database.getConnection().prepareStatement(query);
      stm.setString(1, u.getLogin());
      stm.setString(2, u.getPassword());
      stm.setInt(3, u.getId());
      stm.executeUpdate();
    } catch (SQLException e) {
      // TODO improve it
      e.printStackTrace();
    }
  }

  @Override
  public void delete(int id) {
    var query = "UPDATE users SET disabled = ? WHERE id = ?";

    try {
      var stm = database.getConnection().prepareStatement(query);
      stm.setBoolean(1, true);
      stm.setInt(2, id);
      stm.executeUpdate();
    } catch (SQLException e) {
      // TODO improve it
      e.printStackTrace();
    }
  }
}
