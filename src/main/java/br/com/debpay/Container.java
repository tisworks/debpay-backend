package br.com.debpay;

import br.com.debpay.DAO.UserDAO;
import br.com.debpay.Infrastructure.SQLDatabase;
import br.com.debpay.Services.UserService;

public class Container {
    private static final SQLDatabase SQLite  = new SQLDatabase("org.sqlite.JDBC","jdbc:sqlite:test.db");

    private Container() { }

    public static UserService getUserService() {
        return new UserService(new UserDAO(Container.SQLite));
    }
}
