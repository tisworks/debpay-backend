package br.com.debpay.Services;

import br.com.debpay.DAO.IOperationDAO;
import br.com.debpay.DAO.OperationDAO;
import br.com.debpay.DTO.OperationDTO;

import java.util.ArrayList;
import java.util.Date;

public class OperationService implements IOperationService {

    private final IOperationDAO dao;

    public OperationService(IOperationDAO dao) {
        this.dao = dao;
    }

    @Override
    public ArrayList<OperationDTO> listOperations(int id, Date dueDate) {
        return null;
    }
}
