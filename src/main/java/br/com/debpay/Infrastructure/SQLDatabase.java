package br.com.debpay.Infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLDatabase {
    private Connection connection;

    public SQLDatabase(String driverClassName, String connectionString) {
        try {
            Class.forName(driverClassName);
            this.connection = DriverManager.getConnection(connectionString);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(1);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
