package br.com.debpay.DAO;

import br.com.debpay.Entities.Contact;
import br.com.debpay.Entities.Operation;
import br.com.debpay.Entities.OperationType;
import br.com.debpay.Entities.User;
import br.com.debpay.Infrastructure.SQLDatabase;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationDAO implements IOperationDAO {
    private static final SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
    private final SQLDatabase database;

    public OperationDAO(SQLDatabase database) {
        this.database = database;
    }

    @Override
    public Operation get(int id) {
        var query = "SELECT * from operations WHERE id = ?";

        try {
            var stm = database.getConnection().prepareStatement(query);
            stm.setInt(1, id);
            var rs = stm.executeQuery();
            if (rs.next()) {
                var user = new User();
                user.setId(rs.getInt("user_id"));

                var contact = new Contact();
                contact.setId(rs.getInt("contact_id"));
                contact.setUser(user);

                return new Operation(
                        rs.getInt("id"),
                        rs.getString("description"),
                        OperationType.valueOf(rs.getInt("type")),
                        sdt.parse(rs.getString("due_date")),
                        rs.getInt("installments_left"),
                        rs.getFloat("value"),
                        contact
                );
            }
        } catch (Exception e) {
            // TODO improve it
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Operation> getAll(int userId, Date date) {
        var query = "SELECT * from operations WHERE user_id = ?";
        var result = new ArrayList<Operation>();

        if(date != null)
            query += " AND due_date = ?";

        try {
            var stm = database.getConnection().prepareStatement(query);
            stm.setInt(1, userId);
            if(date != null)
                stm.setString(2, sdt.format(date));
            var rs = stm.executeQuery();
            while (rs.next()) {
                var user = new User();
                user.setId(rs.getInt("user_id"));

                var contact = new Contact();
                contact.setId(rs.getInt("contact_id"));
                contact.setUser(user);


                result.add(new Operation(
                        rs.getInt("id"),
                        rs.getString("description"),
                        OperationType.valueOf(rs.getInt("type")),
                        sdt.parse(rs.getString("due_date")),
                        rs.getInt("installments_left"),
                        rs.getFloat("value"),
                        contact
                ));
            }
        } catch (Exception e) {
            // TODO improve it
            e.printStackTrace();
        }
        return result;
    }

    private PreparedStatement setOperationRow(String query, Operation o) throws Exception {
        var stm = database.getConnection().prepareStatement(query);
        stm.setString(1, o.getDescription());
        stm.setInt(2, o.getType().getValue());
        stm.setString(3, sdt.format(o.getDueDate()));
        stm.setInt(4, o.getInstallmentsLeft());
        stm.setFloat(5, o.getValue());
        stm.setInt(6, o.getContact().getId());
        stm.setInt(7, o.getContact().getUser().getId());
        return stm;
    }

    @Override
    public void save(Operation o) {
        var query = "INSERT INTO operations (description, type, due_date, installments_left, value, contact_id, user_id)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            var stm = setOperationRow(query, o);
            stm.executeUpdate();
        } catch (Exception e) {
            // TODO improve it
            e.printStackTrace();
        }
    }

    @Override
    public void update(Operation o) {
        var query = "UPDATE users SET description = ?, type = ?, due_date = ?, installments_left = ?,  " +
                "value = ?, contact_id = ?, user_id = ? WHERE id = ?";

        try {
            var stm = setOperationRow(query, o);
            stm.setInt(8, o.getId());
            stm.executeUpdate();
        } catch (Exception e) {
            // TODO improve it
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        var query = "UPDATE operations SET disabled = ? WHERE id = ?";

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
