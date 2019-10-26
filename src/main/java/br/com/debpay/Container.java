package br.com.debpay;

import br.com.debpay.DAO.UserDAO;
import br.com.debpay.Infrastructure.SQLDatabase;
import br.com.debpay.Services.IOperationService;
import br.com.debpay.Services.IUserService;
import br.com.debpay.Services.UserService;

public class Container {
    // Should be parameterized as environment variables, but since we don't have a environment yet... (Probably won't)
    private static final SQLDatabase SQLite = new SQLDatabase("org.sqlite.JDBC", "jdbc:sqlite:test.db");
    private static final String salt = "JoseDaSilva";

    private Container() {
    }

    public static IUserService getUserService() {
        return new UserService(new UserDAO(Container.SQLite), salt);
    }

    public static IOperationService getOperationService() {
        return null;
    }
}
