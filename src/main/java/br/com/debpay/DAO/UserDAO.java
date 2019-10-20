package br.com.debpay.DAO;

import br.com.debpay.Entities.User;
import br.com.debpay.Infrastructure.SQLDatabase;

import java.sql.SQLException;

public class UserDAO implements IUserDAO {
    private final SQLDatabase database;

    public UserDAO(SQLDatabase database) {
        this.database = database;
    }

    @Override
    public User getUser(String login) {
        var query =
            "SELECT * from users " +
            "WHERE login = ?";

        try {
            var stm = database.getConnection().prepareStatement(query);
            stm.setString(1, login);
            var rs = stm.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"));
            }
        } catch (SQLException e) {
            // TODO improve it
            e.printStackTrace();
        }
        return null;
    }
}
