package br.com.debpay.Services;

import br.com.debpay.DAO.IOperationDAO;
import br.com.debpay.DTO.OperationDTO;
import br.com.debpay.Entities.Operation;

import java.util.ArrayList;
import java.sql.Date;

public class OperationService implements IOperationService {

    private final IOperationDAO dao;

    public OperationService(IOperationDAO dao) {
        this.dao = dao;
    }

    @Override
    public ArrayList<OperationDTO> listOperations(int id, Date dueDate) {
        var operations = this.dao.listOperations(dueDate, id);
        var returnList = new ArrayList<OperationDTO>();
        for(Operation op : operations){
            returnList.add(OperationDTO.converter(op));
        }

        return returnList;
    }
}
