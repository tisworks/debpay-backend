package br.com.debpay.DAO;

import br.com.debpay.Entities.Operation;
import java.util.Date;
import java.util.List;

public interface IOperationDAO {

    List<Operation> listOperations(Date date, int userId);
}
