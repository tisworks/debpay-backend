package br.com.debpay.DAO;

import br.com.debpay.Entities.Operation;
import java.sql.Date;
import java.util.List;

public interface IOperationDAO {

    List<Operation> listOperations(Date date);
}
