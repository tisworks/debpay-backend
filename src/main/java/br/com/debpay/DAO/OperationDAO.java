package br.com.debpay.DAO;

import br.com.debpay.Entities.Operation;
import br.com.debpay.Infrastructure.SQLDatabase;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperationDAO implements IOperationDAO {
    private final SQLDatabase database;

    public OperationDAO(SQLDatabase database) {
        this.database = database;
    }

    @Override
    public List<Operation> listOperations(Date date) {

        var query =
                "SELECT * from operations " +
                        "WHERE login = ?";

        try{
            var returnList = new ArrayList<Operation>();
            var stm = database.getConnection().prepareStatement(query);
            stm.setString(1, date.toString());
            var rs = stm.executeQuery();
            while (rs.next()){
                var op = new Operation(
                    rs.getInt("id"),
                    rs.getString("description"),
                    rs.getDate("dueDate"),
                    rs.getInt("installmentsLeft"),
                    rs.getFloat("value"),
                    rs.getInt("contactId"),
                    rs.getInt("type"));
                returnList.add(op);
            }

            return returnList;
        }
        catch (SQLException e) {
            // TODO improve it
            e.printStackTrace();
        }

        return null;
    }
}
