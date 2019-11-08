package br.com.debpay.DAO;

import br.com.debpay.entities.User;
import br.com.debpay.infrastructure.SQLDatabase;
import br.com.debpay.dao.UserDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class UserDAOTest {
    SQLDatabase database;
    UserDAO uDAO = new UserDAO(database);

    @BeforeEach
    void setUp() throws SQLException {
        var query = "INSERT INTO users (login, password, id) VALUES (?, ?, ?)";
        var stm = database.getConnection().prepareStatement(query);

        stm.setString(1, "test@email.com");
        stm.setString(2, "12345");
        stm.setString(3, "12345");
        stm.executeUpdate();
    }

    @AfterEach
    void tearDown() throws SQLException {
        var query = "DELETE FROM users WHERE login = ? AND password = ? AND id = ?";
        var stm = database.getConnection().prepareStatement(query);

        stm.setString(1, "test@email.com");
        stm.setString(2, "12345");
        stm.setString(3, "12345");
        stm.executeUpdate();
    }

    @Test
    void get() {
        User user;
        User user1;
        user = uDAO.get(12345);
        user1 = uDAO.get("test@email.com");
        boolean cond = false;

        if (user.getId() == 12345 && user.getLogin().compareTo("test@email.com") == 0 && user.getPassword().compareTo("12345") == 0 && user1.getId() == 12345 && user1.getLogin().compareTo("test@email.com") == 0 && user1.getPassword().compareTo("12345") == 0)
            cond = true;

        Assertions.assertTrue(cond);
    }

    @Test
    void getAll() {

    }

    @Test
    void save() {
        User user = new User();
        user.setLogin("teste");
        user.setPassword("password");
        uDAO.save(user);
        boolean cond = false;
        if (uDAO.get("teste").getLogin().compareTo("teste") == 0)
            cond = true;

        Assertions.assertTrue(cond);
    }

    @Test
    void update() {
        User user = uDAO.get(12345);
        user.setLogin("teste");
        uDAO.update(user);
        boolean cond = false;
        if (uDAO.get(12345).getLogin().compareTo("teste") == 0)
            cond = true;

        Assertions.assertTrue(cond);
    }

    @Test
    void delete() {
        uDAO.delete(12345);
        boolean cond = false;
        if (uDAO.get(12345) == null)
            cond = true;

        Assertions.assertTrue(cond);
    }
}