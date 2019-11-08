package br.com.debpay.dao;

import br.com.debpay.entities.Operation;

import java.util.Date;
import java.util.List;

public interface IOperationDAO {
  Operation get(int id);

  List<Operation> getAll(int userId, Date date);

  void save(Operation o);

  void update(Operation o);

  void delete(int id);
}
