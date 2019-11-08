package br.com.debpay;

import br.com.debpay.dao.ContactDAO;
import br.com.debpay.dao.OperationDAO;
import br.com.debpay.dao.UserDAO;
import br.com.debpay.infrastructure.SQLDatabase;
import br.com.debpay.services.*;

public class Container {
  private static final SQLDatabase SQLite =
      new SQLDatabase("org.sqlite.JDBC", "jdbc:sqlite:test.db");
  private static final String salt = "JoseDaSilva";

  private Container() {}

  public static IUserService getUserService() {
    return new UserService(new UserDAO(SQLite), salt);
  }

  public static IOperationService getOperationService() {
    return new OperationService(new OperationDAO(SQLite));
  }

  public static IContactService getContactService() {
    return new ContactService(new ContactDAO(SQLite));
  }
}
