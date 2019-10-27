package br.com.debpay.DAO;

import br.com.debpay.Entities.Operation;

import java.util.List;

public interface IOperationDAO {
    Operation get(int id);
    List<Operation> getAll(int userId);
    void save(Operation o);
    void update(Operation o);
    void delete(int id);
}
