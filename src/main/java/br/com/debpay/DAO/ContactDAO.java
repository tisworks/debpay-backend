package br.com.debpay.DAO;

import br.com.debpay.Entities.Contact;
import br.com.debpay.Entities.User;
import br.com.debpay.Infrastructure.SQLDatabase;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ContactDAO implements IContactDAO {
    private final SQLDatabase database;

    public ContactDAO(SQLDatabase database) {
        this.database = database;
    }

    @Override
    public Contact get(int id) {
        var query = "SELECT * from contacts WHERE id = ?";

        try {
            var stm = database.getConnection().prepareStatement(query);
            stm.setInt(1, id);
            var rs = stm.executeQuery();
            if (rs.next()) {
                var user = new User();
                user.setId(rs.getInt("user_id"));

                return new Contact(
                        rs.getInt("id"),
                        user,
                        rs.getString("name"),
                        rs.getString("cpf"),
                        rs.getString("bank_code"),
                        rs.getString("bank_agency"),
                        rs.getString("bank_account")
                );
            }
        } catch (SQLException e) {
            // TODO improve it
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Contact> getAll(int userId) {
        var query = "SELECT * from contacts WHERE user_id = ?";
        var result = new ArrayList<Contact>();

        try {
            var stm = database.getConnection().prepareStatement(query);
            stm.setInt(1, userId);
            var rs = stm.executeQuery();
            while (rs.next()) {
                var user = new User();
                user.setId(rs.getInt("user_id"));

                result.add(new Contact(
                        rs.getInt("id"),
                        user,
                        rs.getString("name"),
                        rs.getString("cpf"),
                        rs.getString("bank_code"),
                        rs.getString("bank_agency"),
                        rs.getString("bank_account")
                ));
            }
        } catch (SQLException e) {
            // TODO improve it
            e.printStackTrace();
        }
        return result;
    }

    private PreparedStatement setContactRow(String query, Contact c) throws Exception {
        var stm = database.getConnection().prepareStatement(query);
        stm.setInt(1, c.getUser().getId());
        stm.setString(2, c.getName());
        stm.setString(3, c.getCpf());
        stm.setString(4, c.getBankCode());
        stm.setString(5, c.getBankAgency());
        stm.setString(6, c.getBankAccount());
        return stm;
    }

    @Override
    public void save(Contact c) {
        var query = "INSERT INTO contacts (user_id, name, cpf, bank_code, bank_agency, bank_account) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            var stm = setContactRow(query, c);
            stm.executeUpdate();
        } catch (Exception e) {
            // TODO improve it
            e.printStackTrace();
        }
    }

    @Override
    public void update(Contact c) {
        var query = "UPDATE contacts SET user_id = ?, name = ?, cpf = ?, bank_code = ?, bank_agency = ?," +
                " bank_account = ? WHERE id = ?";

        try {
            var stm = setContactRow(query, c);
            stm.setInt(7, c.getId());
            stm.executeUpdate();
        } catch (Exception e) {
            // TODO improve it
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        var query = "UPDATE contacts SET disabled = ? WHERE id = ?";

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
